import { compileWat, WasmRunner } from "@exercism/wasm-lib";

let wasmModule;
let currentInstance;

beforeAll(async () => {
  try {
    const watPath = new URL("./darts.wat", import.meta.url);
    const { buffer } = await compileWat(watPath);
    wasmModule = await WebAssembly.compile(buffer);
  } catch (err) {
    console.log(`Error compiling *.wat: \n${err}`);
    process.exit(1);
  }
});

describe("Darts", () => {
  beforeEach(async () => {
    currentInstance = null;

    if (!wasmModule) {
      return Promise.reject();
    }
    try {
      currentInstance = await new WasmRunner(wasmModule);
      return Promise.resolve();
    } catch (err) {
      console.log(`Error instantiating WebAssembly module: ${err}`);
      return Promise.reject();
    }
  });

  test("Missed target", () => {
    expect(currentInstance.exports.score(-9, 9)).toEqual(0);
  });

  xtest("On the outer circle", () => {
    expect(currentInstance.exports.score(0, 10)).toEqual(1);
  });

  xtest("On the middle circle", () => {
    expect(currentInstance.exports.score(-5, 0)).toEqual(5);
  });

  xtest("On the inner circle", () => {
    expect(currentInstance.exports.score(0, -1)).toEqual(10);
  });

  xtest("Exactly on centre", () => {
    expect(currentInstance.exports.score(0, 0)).toEqual(10);
  });

  xtest("Near the centre", () => {
    expect(currentInstance.exports.score(-0.1, -0.1)).toEqual(10);
  });

  xtest("Just within the inner circle", () => {
    expect(currentInstance.exports.score(0.7, 0.7)).toEqual(10);
  });

  xtest("Just outside the inner circle", () => {
    expect(currentInstance.exports.score(0.8, -0.8)).toEqual(5);
  });

  xtest("Just within the middle circle", () => {
    expect(currentInstance.exports.score(-3.5, 3.5)).toEqual(5);
  });

  xtest("Just outside the middle circle", () => {
    expect(currentInstance.exports.score(-3.6, -3.6)).toEqual(1);
  });

  xtest("Just within the outer circle", () => {
    expect(currentInstance.exports.score(-7.0, 7.0)).toEqual(1);
  });

  xtest("Just outside the outer circle", () => {
    expect(currentInstance.exports.score(7.1, -7.1)).toEqual(0);
  });

  xtest("Asymmetric position between the inner and middle circles", () => {
    expect(currentInstance.exports.score(0.5, -4)).toEqual(5);
  });
});

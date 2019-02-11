import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int handshake) {

        List<Signal> events = new ArrayList<>();

        for (int j = 0; j < Signal.values().length; j++) {
            int bitMask = 1 << j;
            if (isBitSet(handshake, bitMask)) {
                events.add(Signal.values()[j]);
            }
        }

        if (shouldReverse(handshake)) {
            Collections.reverse(events);
        }

        return events;
    }

    private boolean shouldReverse(int handshake) {
        int jumpBit = 1 << Signal.values().length;
        return isBitSet(handshake, jumpBit);
    }

    private boolean isBitSet(int handshake, int index) {
        return (index & handshake) != 0;
    }

}

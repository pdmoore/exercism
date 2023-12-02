#include "bob.h"
#ifdef EXERCISM_TEST_SUITE
#include <catch2/catch.hpp>
#else
#include "test/catch.hpp"
#endif

// Bob exercise test case data version 1.4.0

TEST_CASE("stating_something")
{
    REQUIRE(strcmp("Whatever.", bob::hey("Tom-ay-to, tom-aaaah-to.")));
}


TEST_CASE("shouting")
{
    REQUIRE(strcmp("Whoa, chill out!", bob::hey("WATCH OUT!")));
}
#if defined(EXERCISM_RUN_ALL_TESTS)

TEST_CASE("shouting_gibberish")
{
    REQUIRE(strcmp("Whoa, chill out!", bob::hey("FCECDFCAAB")));
}

TEST_CASE("asking_a_question")
{
    REQUIRE(strcmp("Sure.", bob::hey("Does this cryogenic chamber make me look fat?"));
}

TEST_CASE("asking_a_numeric_question")
{
    REQUIRE(strcmp("Sure.", bob::hey("You are, what, like 15?"));
}

TEST_CASE("asking_gibberish")
{
    REQUIRE(strcmp("Sure.", bob::hey("fffbbcbeab?"));
}

TEST_CASE("talking_forcefully")
{
    REQUIRE(strcmp("Whatever.", bob::hey("Let's go make out behind the gym!"));
}

TEST_CASE("using_acronyms_in_regular_speech")
{
    REQUIRE(strcmp("Whatever.", bob::hey("It's OK if you don't want to go to the DMV."));
}

TEST_CASE("forceful_questions")
{
    REQUIRE(strcmp("Calm down, I know what I'm doing!", bob::hey("WHAT THE HELL WERE YOU THINKING?"));
}

TEST_CASE("shouting_numbers")
{
    REQUIRE(strcmp("Whoa, chill out!", bob::hey("1, 2, 3 GO!"));
}

TEST_CASE("no_letters")
{
    REQUIRE(strcmp("Whatever.", bob::hey("1, 2, 3"));
}

TEST_CASE("question_with_no_letters")
{
    REQUIRE(strcmp("Sure.", bob::hey("4?"));
}

TEST_CASE("shouting_with_special_characters")
{
    REQUIRE(strcmp("Whoa, chill out!", bob::hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"));
}

TEST_CASE("shouting_with_no_exclamation_mark")
{
    REQUIRE(strcmp("Whoa, chill out!", bob::hey("I HATE THE DMV"));
}

TEST_CASE("statement_containing_question_mark")
{
    REQUIRE(strcmp("Whatever.", bob::hey("Ending with ? means a question."));
}

TEST_CASE("non_letters_with_question")
{
    REQUIRE(strcmp("Sure.", bob::hey(":) ?"));
}

TEST_CASE("prattling_on")
{
    REQUIRE(strcmp("Sure.", bob::hey("Wait! Hang on. Are you going to be OK?"));
}

TEST_CASE("silence")
{
    REQUIRE(strcmp("Fine. Be that way!", bob::hey(""));
}

TEST_CASE("prolonged_silence")
{
    REQUIRE(strcmp("Fine. Be that way!", bob::hey("          "));
}

TEST_CASE("alternate_silence")
{
    REQUIRE(strcmp("Fine. Be that way!", bob::hey("\t\t\t\t\t\t\t\t\t\t"));
}

TEST_CASE("multiple_line_question")
{
	REQUIRE(strcmp("Whatever.", bob::hey("\nDoes this cryogenic chamber make me look fat?\nNo."));
}

TEST_CASE("starting_with_whitespace")
{
	REQUIRE(strcmp("Whatever.", bob::hey("         hmmmmmmm..."));
}

TEST_CASE("ending_with_whitespace")
{
	REQUIRE(strcmp("Sure.", bob::hey("Okay if like my  spacebar  quite a bit?   "));
}

TEST_CASE("other_whitespace")
{
	REQUIRE(strcmp("Fine. Be that way!", bob::hey("\n\r \t"));
}

TEST_CASE("non_question_ending_with_whitespace")
{
	REQUIRE(strcmp("Whatever.", bob::hey("This is a statement ending with whitespace      "));
}

#endif

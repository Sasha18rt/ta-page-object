package com.softserve.edu.teachua.tests;

import com.softserve.edu.teachua.data.*;
import com.softserve.edu.teachua.pages.challenge.ChallengeTeachPage;
import com.softserve.edu.teachua.pages.challenge.YoutubeFrame;
import com.softserve.edu.teachua.pages.club.AdvancedClubPage;
import com.softserve.edu.teachua.pages.club.ClubComponent;
import com.softserve.edu.teachua.pages.club.ClubDetailsPage;
import com.softserve.edu.teachua.pages.club.ClubPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SomeTest extends TestRunner {

    @Test
    public <T> void checkTeachChallenge() {
        YoutubeFrame youtubeFrame = loadApplication()
                .gotoTeachChallengePage()
                .gotoYoutubeFrame();
        //
        Assertions.assertNotNull(youtubeFrame);
    }

    private static Stream<Arguments> challengeProvider() {
        return Stream.of(
                Arguments.of("Навчайся")
        );
    }

    public static Object[][] challengeProvider2() {
        return new Object[][]{
                {"Навчайся"}
        };
    }

    @ParameterizedTest(name = "{index} => challengeName={0}")
    @MethodSource("challengeProvider")
    public void checkChallenge(String challengeName) {
        YoutubeFrame youtubeFrame = loadApplication()
                .gotoChallengePage(challengeName, ChallengeTeachPage.class)
                .gotoYoutubeFrame();
        //
        Assertions.assertFalse(youtubeFrame.getYoutubeLinkText().isEmpty());
    }


    private static Stream<Arguments> challengeTeachProvider() {
        return Stream.of(
                Arguments.of(Challengies.TO_LEARN_CHALLENGE, UrlContents.WEBINAR_IFRAME),
                Arguments.of(Challengies.TO_LEARN_CHALLENGE, UrlContents.WEBINAR2_IFRAME)
        );
    }


    @ParameterizedTest(name = "{index} => challengeName = {0}")
    @MethodSource("challengeTeachProvider")
    public void checkChallenge(Challengies challengeName, UrlContents urlContents) {
        YoutubeFrame youtubeFrame = loadApplication()
                .gotoChallengePage(challengeName, ChallengeTeachPage.class)
                .gotoYoutubeFrameBySrc(urlContents)
                .playVideoContent();

        Assertions.assertTrue(youtubeFrame.getYoutubeLinkText().contains(urlContents.getSearchVideo()));
    }

    private static Stream<Arguments> cityProvider() {
        return Stream.of(
                Arguments.of(Cities.KYIV_CITY),
                Arguments.of(Cities.HARKIV_CITY)
        );
    }

    @ParameterizedTest(name = "{index} => city={0}")
    @MethodSource("cityProvider")
    public void checkCityClubs(Cities city) {
        ClubComponent ClubComponent = loadApplication()
                .gotoClubPage()
                .chooseCity(city)
                .getClubContainer()
                .getFirstClubComponent();
        //
        Assertions.assertTrue(ClubComponent.getAddressLabelText().contains(city.getCity()));
    }


    private static Stream<Arguments> clubProvider() {
        return Stream.of(
                Arguments.of(ClubContents.NEW_CADRE_CLUB),
                Arguments.of(ClubContents.VECTOR_CLUB)
        );
    }
    private static Stream<Arguments> advancedClubProvider() {
        return Stream.of(
                Arguments.of(ClubContents.GREEN_COUNTRY_CLUB)
        );
    }
    @ParameterizedTest(name = "{index} => clubContents={0}")
    @MethodSource("clubProvider")
    public void checkClubExist(ClubContents clubContents) {
        ClubComponent ClubComponent = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .getClubContainer()
                .getClubComponentByPartialTitle(clubContents.getTitle());
        //
        Assertions.assertTrue(ClubComponent.getTitleLinkText().contains(clubContents.getTitle()));
    }

    @ParameterizedTest(name = "{index} => clubContents={0}")
    @MethodSource("advancedClubProvider")
    public void checkAdvancedSearch(ClubContents clubContents) {
        AdvancedClubPage advancedClubPage = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .gotoAdvancedClubPage();
        //
        Assertions.assertTrue(advancedClubPage.isExistClubByPartialName(clubContents.getTitle()));
    }

    private static Stream<Arguments> commentProvider() {
        return Stream.of(
                Arguments.of(ClubContents.IT_EDUCATION_CLUB, CommentContents.FIRST_COMMENT)
        );
    }

    @ParameterizedTest(name = "{index} => clubContents={0}, commentContents={0}")
    @MethodSource("commentProvider")
    public void checkCommentExist(ClubContents clubContents, CommentContents commentContents) {
        ClubDetailsPage clubDetailsPage = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .getClubContainer()
                .getClubComponentByPartialTitle(clubContents.getTitle())
                .openClubDetailsPage();
        //
        Assertions.assertTrue(clubDetailsPage.getCommentContainer().getClubCommentAuthors().contains(commentContents.getAuthor()));
    }
}

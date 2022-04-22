package edu.psu.ist.hcdd340.recipeats;

final class RecipeProfile {


    private final String profileName;
    private final String profileID;
    private boolean isLiked;
    private final int profileImageID;

    RecipeProfile(String profileName, String profileID, boolean isLiked, int profileImageID) {
        this.profileName = profileName;
        this.profileID = profileID;
        this.isLiked = isLiked;
        this.profileImageID = profileImageID;
    }


    public int getProfileImageID() {
        return profileImageID;
    }

    public String getProfileName() {
        return profileName;
    }

    public boolean getProfileLikeStatus() {
        return isLiked;
    }


    public void setProfileLikeStatus(boolean status) {
        this.isLiked = status;
    }


    public String getProfileID() {
        return profileID;
    }


}


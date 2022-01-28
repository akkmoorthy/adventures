package com.adventures.others.immutable;

import java.util.Date;

import static com.adventures.others.immutable.User1.getBuilder;


public class ImmutableBuilder {

    public static void main(String[] args) {

        // user with nickname and password
        User1 user1 = getBuilder("marin21", "hjju9887h").build();
        System.out.println("User 1 successfully created on: " + user1.getCreated());

        // user with nickname, password and email
        User1 user2 = getBuilder("ionk", "44fef22")
                .email("ion@gmail.com")
                .build();
        System.out.println("User 2 successfully created on: " + user2.getCreated());

        // user with nickname, password, email, firstname and lastname
        User1 user3 = getBuilder("monika", "klooi0988")
                .email("monika@gmail.com")
                .firstName("Monika")
                .lastName("Ghuenter")
                .build();
        System.out.println("User 3 successfully created on: " + user3.getCreated());
    }

}

final class User1 {

    private final String nickname;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Date created;

    private User1(UserBuilder builder) {
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.created = builder.created;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
    }

    public static UserBuilder getBuilder(String nickname, String password) {
        return new User1.UserBuilder(nickname, password);
    }

    public static final class UserBuilder {

        private final String nickname;
        private final String password;
        private final Date created;
        private String email;
        private String firstname;
        private String lastname;

        public UserBuilder(String nickname, String password) {
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }

        public UserBuilder firstName(String firsname) {
            this.firstname = firsname;
            return this;
        }

        public UserBuilder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User1 build() {
            return new User1(this);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }
}


package com.example.coursework;

import com.example.coursework.Model.Review;
import com.example.coursework.Model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class CourseworkApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DBService dbService;
	private static final OkHttpClient CLIENT = new OkHttpClient();

	private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

	ObjectMapper objectMapper = new ObjectMapper();
	@Test
	void getUsersNickname() throws IOException {
		int user_id = 51322;
		String nick_name = "Forex";
		double balance = 123123.43;
		String phone_number = "+79533621489";
		jdbcTemplate.update("INSERT INTO \"USERS\" (user_id , nick_name, balance , phone_number) VALUES (?,?,?,?)" ,
				user_id , nick_name, balance , phone_number);

		Request  request = new Request.Builder().url("http://localhost:8080/get_Users_nickname?nick_name=" + nick_name).build();

		Response content;

		content = Objects.requireNonNull((CourseworkApplicationTests.CLIENT.newCall(request).execute()));
		Users entity = objectMapper.readValue(Objects.requireNonNull(content.body()).string(), Users.class);

		Assertions.assertEquals(entity , new Users(user_id , nick_name , balance , phone_number));

		jdbcTemplate.update("DELETE FROM \"USERS\" WHERE nick_name = ?" ,
				nick_name );
	}

	@Test
	void addReview() throws IOException {
		String text = "sdfsdfwerweqdqweqwe";
		int assessment = 3;
		int game_id = 5;
		jdbcTemplate.update("INSERT INTO \"REVIEWS\" (text , assessment , game_id) VALUES (?,?,?)"
				, text , assessment , game_id);

		Request  request = new Request.Builder().url("http://localhost:8080/add_Review?assessment=" + assessment + "&game_id=" + game_id +
				"&text=" + text).build();

		Objects.requireNonNull((CourseworkApplicationTests.CLIENT.newCall(request).execute()));

		List<Review> review = jdbcTemplate.query("SELECT FROM \"REVIEWS\" WHERE text = ? AND assessment = ? AND game_id = ?" ,
				(rs , rowNum) -> new Review(   rs.getInt("review_id") ,
						rs.getString("text"), rs.getInt("assessment"), rs.getInt("game_id") ) ,
				text , assessment , game_id );

		Assertions.assertEquals(review.get(0), new Review(1, text , assessment , game_id));

		jdbcTemplate.update("DELETE FROM \"REVIEWS\" WHERE text = ? AND assessment = ? AND game_id = ? " ,
				text , assessment , game_id);
	}


	@Test
	void setUserNickname() throws IOException {
		String nick = "flomikoon";

		int user_id = 436234;
		String nick_name = "Forex";
		double balance = 123123.43;
		String phone_number = "+79533621489";
		jdbcTemplate.update("INSERT INTO \"USERS\" (user_id , nick_name, balance , phone_number) VALUES (?,?,?,?)" ,
				user_id , nick_name, balance , phone_number);

		Request  request = new Request.Builder().url("http://localhost:8080/set_nickname?nick=" + nick + "&id=" + user_id).build();

		Objects.requireNonNull((CourseworkApplicationTests.CLIENT.newCall(request).execute()));

		List<Users> user = jdbcTemplate.query("SELECT FROM \"USERS\" WHERE user_id = ? AND nick_name= ? AND balance = ? AND phone_number = ?" ,
				(rs , rowNum) -> new Users(rs.getInt("user_id") ,
						rs.getString("nick_name"),
						rs.getDouble("balance"),
						rs.getString("phone_number") ),
				user_id , nick , balance , phone_number );

		Assertions.assertEquals(user.get(0), new Users(user_id, nick, balance , phone_number));

		jdbcTemplate.update("DELETE FROM \"USERS\" WHERE user_id = ?" ,
				user_id);
	}
}

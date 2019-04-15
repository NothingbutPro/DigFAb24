package com.ics.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class ChatActivity extends AppCompatActivity {

   LinearLayout ll_chat;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.chat_activity);

       ll_chat=findViewById(R.id.chat_next1);

       ll_chat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(ChatActivity.this, ChatSentMessage.class);
               startActivity(intent);
           }
       });
   }
}

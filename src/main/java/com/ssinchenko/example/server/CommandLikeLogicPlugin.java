package com.ssinchenko.example.server;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.ssinchenko.example.lib.CommandLikeLogic;
import com.ssinchenko.example.proto.CallCommandLikeLogic;
import java.io.IOException;
import org.apache.spark.sql.connect.planner.SparkConnectPlanner;
import org.apache.spark.sql.connect.plugin.CommandPlugin;

/** The simplest of all the possible cases. Just call a command and that's it. */
public class CommandLikeLogicPlugin implements CommandPlugin {
  @Override
  public boolean process(byte[] command, SparkConnectPlanner planner) {
    Any commandProto;
    try {
      commandProto = Any.parseFrom(command);
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException(e);
    }
    if (commandProto.is(CallCommandLikeLogic.class)) {
      try {
        var message = commandProto.unpack(CallCommandLikeLogic.class);
        CommandLikeLogic.commandA(message.getParamA(), message.getParamB(), message.getParamC());
      } catch (IOException e) {
        // I'm not 100% sure what is the right way to work with Exception here.
        // In this case, I guess, SparkConnect server will just die with internal error.
        // To avoid it returns false better.
        return false;
      }
    }
    return true;
  }
}

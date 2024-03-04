package com.ssinchenko.example.server;

import static org.junit.jupiter.api.Assertions.*;

import com.ssinchenko.example.lib.ObjectManipulationLogic;
import org.junit.jupiter.api.Test;

class ObjectManipulationLogicPluginTest {
  @Test
  void getObj() {
    var obj = new ObjectManipulationLogic("str", 100L);
    var id = ObjectManipulationLogicPlugin.addObj(obj);
    assertEquals(System.identityHashCode(obj), id);
    assertNotNull(ObjectManipulationLogicPlugin.getObj(id));
  }
}

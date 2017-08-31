/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.support;

import org.llvm.cl.aliases.optString;
import org.junit.Test;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.cl.*;


//<editor-fold defaultstate="collapsed" desc="static type CommandLineTest">
@Converted(kind = Converted.Kind.AUTO,
 NM="CommandLineTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -test=CommandLineTest")
//</editor-fold>
public final class CommandLineTest extends ADTSupportTestBase {

  public CommandLineTest() {
    super(TestState.Successful);
  }
  
//JAVA: using namespace llvm
//JAVA: namespace (anonymous) {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TempEnvVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 22,
 FQN="(anonymous namespace)::TempEnvVar", NM="_ZN12_GLOBAL__N_110TempEnvVarE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_110TempEnvVarE")
//</editor-fold>
public static class TempEnvVar implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TempEnvVar::TempEnvVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 24,
   FQN="(anonymous namespace)::TempEnvVar::TempEnvVar", NM="_ZN12_GLOBAL__N_110TempEnvVarC1EPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_110TempEnvVarC1EPKcS2_")
  //</editor-fold>
  public TempEnvVar(/*const*/char$ptr/*char P*/ name, /*const*/char$ptr/*char P*/ value) {
    // : name(name) 
    //START JInit
    this.name = $tryConstClone(name);
    //END JInit
    /*const*/char$ptr/*char P*/ old_value = $tryConstClone(getenv(name));
    EXPECT_EQ(null,old_value);
    std.setenv(name, value, /*true*/1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TempEnvVar::~TempEnvVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 35,
   FQN="(anonymous namespace)::TempEnvVar::~TempEnvVar", NM="_ZN12_GLOBAL__N_110TempEnvVarD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_110TempEnvVarD0Ev")
  //</editor-fold>
  public void $destroy() {
    // Assume setenv and unsetenv come together.
    std.unsetenv(name);
  }

/*private:*/
  private /*const*/char$ptr/*char P*//*const*/ name;

  @Override public String toString() {
    return "" + "name=" + Casts.toJavaString(name); // NOI18N
  }  
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 48,
 FQN="(anonymous namespace)::StackOption", NM="_ZN12_GLOBAL__N_111StackOptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_111StackOptionE")
//</editor-fold>
public static class StackOption</*typename*/ T>  extends /*public*/ opt<T> implements Destructors.ClassWithDestructor {
  // JAVA: typedef cl::opt<T> Base
//  public final class Base extends opt<T>{ };
/*public:*/
  // One option...
  /*template <class M0t> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption::StackOption<T>">
  public StackOption(T DefaultValue, boolean ExternalStorage, basic_parser<T> Parser, Object... flags)/* override*/ {
      super(DefaultValue, ExternalStorage ? StorageKind.External : StorageKind.Internal, Parser, flags);
  }

//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 54,
//   FQN="(anonymous namespace)::StackOption::StackOption<T>", NM="Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_")
//  //</editor-fold>
//  public /*explicit*/ </*class*/ M0t> StackOption(final /*const*/ M0t /*&*/ M0) {
//    // : Base(M0) 
//    //START JInit
//    /*ParenListExpr*/super(M0);
//    //END JInit
//  }
//
//  
//  // Two options...
//  /*template <class M0t, class M1t> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption::StackOption<T>">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 58,
//   FQN="(anonymous namespace)::StackOption::StackOption<T>", NM="Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_RKT0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_RKT0_")
//  //</editor-fold>
//  public </*class*/ M0t, /*class*/ M1t> StackOption(final /*const*/ M0t /*&*/ M0, final /*const*/ M1t /*&*/ M1) {
//    // : Base(M0, M1) 
//    //START JInit
//    /*ParenListExpr*/super(M0, M1);
//    //END JInit
//  }
//
//  
//  // Three options...
//  /*template <class M0t, class M1t, class M2t> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption::StackOption<T>">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 62,
//   FQN="(anonymous namespace)::StackOption::StackOption<T>", NM="Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_RKT0_RKT1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_RKT0_RKT1_")
//  //</editor-fold>
//  public </*class*/ M0t, /*class*/ M1t, /*class*/ M2t> StackOption(final /*const*/ M0t /*&*/ M0, final /*const*/ M1t /*&*/ M1, final /*const*/ M2t /*&*/ M2) {
//    // : Base(M0, M1, M2) 
//    //START JInit
//    /*ParenListExpr*/super(M0, M1, M2);
//    //END JInit
//  }
//
//  
//  // Four options...
//  /*template <class M0t, class M1t, class M2t, class M3t> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption::StackOption<T>">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 66,
//   FQN="(anonymous namespace)::StackOption::StackOption<T>", NM="Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_RKT0_RKT1_RKT2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=Tpl__ZN12_GLOBAL__N_111StackOptionC1ERKT_RKT0_RKT1_RKT2_")
//  //</editor-fold>
//  public </*class*/ M0t, /*class*/ M1t, /*class*/ M2t, /*class*/ M3t> StackOption(final /*const*/ M0t /*&*/ M0, final /*const*/ M1t /*&*/ M1, final /*const*/ M2t /*&*/ M2, final /*const*/ M3t /*&*/ M3) {
//    // : Base(M0, M1, M2, M3) 
//    //START JInit
//    /*ParenListExpr*/super(M0, M1, M2, M3);
//    //END JInit
//  }
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption::~StackOption<T>">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 69, FQN = "(anonymous namespace)::StackOption::~StackOption<T>", NM = "_ZN12_GLOBAL__N_111StackOptionD0Ev", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_111StackOptionD0Ev")
    public void $destroy() /* override*/ {
      this.removeArgument();
      super.$destroy();
    }

  
  /*template <class DT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackOption::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 71,
   FQN="(anonymous namespace)::StackOption::operator=", NM="Tpl__ZN12_GLOBAL__N_111StackOptionaSERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=Tpl__ZN12_GLOBAL__N_111StackOptionaSERKT_")
  //</editor-fold>
  public /*<class DT> StackOption<T>*/ T /*&*/ $assign(final /*const*/ /*DT*/T /*&*/ V) {
    this.setValue(V);
    return /*Deref*/this.$T(); // JAVA: the return value is never used
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
  };

  public static class StackOptionBool  extends /*public*/ StackOption<Boolean> implements Destructors.ClassWithDestructor {    
    private StackOptionBool(Object... flags) {
      super(Boolean.FALSE, false, new parserBoolean(), flags);
    }
  }
  public static class StackOptionString  extends /*public*/ StackOption<std.string> implements Destructors.ClassWithDestructor {
    private StackOptionString(Object... flags) {
      super(string.EMPTY, false, new parserString(), flags);
    }
  }
  public static class StackOptionInt  extends /*public*/ StackOption<Integer> implements Destructors.ClassWithDestructor {
    private StackOptionInt(Object... flags) {
      super(0, false, new parserInt(), flags);
    }
  }

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackSubCommand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 77,
 FQN="(anonymous namespace)::StackSubCommand", NM="_ZN12_GLOBAL__N_115StackSubCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_115StackSubCommandE")
//</editor-fold>
public static class StackSubCommand extends /*public*/ SubCommand implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackSubCommand::StackSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 79,
   FQN="(anonymous namespace)::StackSubCommand::StackSubCommand", NM="_ZN12_GLOBAL__N_115StackSubCommandC1EPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_115StackSubCommandC1EPKcS2_")
  //</editor-fold>
  public StackSubCommand(/*const*/char$ptr/*char P*//*const*/ Name) {
    this(Name, 
      (/*const*/char$ptr/*char P*//*const*/)null);
  }
  public StackSubCommand(/*const*/char$ptr/*char P*//*const*/ Name, 
      /*const*/char$ptr/*char P*//*const*/ Description/*= null*/) {
    // : SubCommand(Name, Description) 
    //START JInit
    super(Name, Description);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackSubCommand::StackSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 83,
   FQN="(anonymous namespace)::StackSubCommand::StackSubCommand", NM="_ZN12_GLOBAL__N_115StackSubCommandC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_115StackSubCommandC1Ev")
  //</editor-fold>
  public StackSubCommand() {
    // : SubCommand() 
    //START JInit
    super();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackSubCommand::~StackSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 85,
   FQN="(anonymous namespace)::StackSubCommand::~StackSubCommand", NM="_ZN12_GLOBAL__N_115StackSubCommandD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_115StackSubCommandD0Ev")
  //</editor-fold>
  public void $destroy() {
    unregisterSubCommand();
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 89,
 FQN="(anonymous namespace)::TestCategory", NM="_ZN12_GLOBAL__N_112TestCategoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_112TestCategoryE")
//</editor-fold>
public static final OptionCategory TestCategory/*J*/= new OptionCategory($("Test Options"), $("Description"));
;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_ModifyExisitingOption_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 90,
 FQN="(anonymous namespace)::CommandLineTest_ModifyExisitingOption_Test::TestBody", NM="_ZN12_GLOBAL__N_142CommandLineTest_ModifyExisitingOption_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_142CommandLineTest_ModifyExisitingOption_Test8TestBodyEv")
//</editor-fold>
@Test public void test_ModifyExisitingOption() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   StackOptionInt TestOption = null;
  try {
    TestOption/*J*/= new StackOptionInt($("test-option"), new desc($("old description")));
    
    /*const*//*char*/char$ptr Description/*[16]*/ = $("New description");
    /*const*//*char*/char$ptr ArgString/*[16]*/ = $("new-test-option");
    /*const*//*char*/char$ptr ValueString/*[8]*/ = $("Integer");
    
    final StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ Map = ClGlobals.getRegisteredOptions(ClGlobals.TopLevelSubCommand.$star());
    ASSERT_TRUE(Map.count(new StringRef(/*KEEP_STR*/"test-option")) == 1);
    
    Option /*P*/ Retrieved = Map.$at(/*STRINGREF_STR*/"test-option");
    EXPECT_EQ($AddrOf(TestOption),Retrieved);
    EXPECT_EQ($AddrOf(ClGlobals.GeneralCategory),Retrieved.Category);
    
    Retrieved.setCategory(TestCategory);
    EXPECT_EQ($AddrOf(TestCategory),Retrieved.Category);
    
    Retrieved.setDescription(new StringRef(Description));
    ASSERT_STREQ(Retrieved.HelpStr,Description);
    
    Retrieved.setArgStr(new StringRef(ArgString));
    ASSERT_STREQ(ArgString,Retrieved.ArgStr);
    
    Retrieved.setValueStr(new StringRef(ValueString));
    ASSERT_STREQ(Retrieved.ValueStr,ValueString);
    
    Retrieved.setHiddenFlag(OptionHidden.Hidden);
    EXPECT_EQ(OptionHidden.Hidden,TestOption.getOptionHiddenFlag());
  } finally {
    if (TestOption != null) { TestOption.$destroy(); }
  }
}


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::test_env_var">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 131,
 FQN="(anonymous namespace)::test_env_var", NM="_ZN12_GLOBAL__N_1L12test_env_varE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_1L12test_env_varE")
//</editor-fold>
public static final/*const*//*char*/char$ptr test_env_var/*[29]*/ = $("LLVM_TEST_COMMAND_LINE_FLAGS");

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EnvironmentTestOption">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 133,
 FQN="(anonymous namespace)::EnvironmentTestOption", NM="_ZN12_GLOBAL__N_121EnvironmentTestOptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_121EnvironmentTestOptionE")
//</editor-fold>
public static final optString EnvironmentTestOption/*J*/= new optString($("env-test-opt"));
;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_ParseEnvironment_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 134,
 FQN="(anonymous namespace)::CommandLineTest_ParseEnvironment_Test::TestBody", NM="_ZN12_GLOBAL__N_137CommandLineTest_ParseEnvironment_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_137CommandLineTest_ParseEnvironment_Test8TestBodyEv")
//</editor-fold>
@Test public void test_ParseEnvironment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   TempEnvVar TEV = null;
  try {
    TEV/*J*/= new TempEnvVar(test_env_var, $("-env-test-opt=hello"));
    EXPECT_EQ("",EnvironmentTestOption);
    ClGlobals.ParseEnvironmentOptions($("CommandLineTest"), test_env_var);
    EXPECT_EQ("hello",EnvironmentTestOption);
  } finally {
    if (TEV != null) { TEV.$destroy(); }
  }
}


// This test used to make valgrind complain
// ("Conditional jump or move depends on uninitialised value(s)")
//
// Warning: Do not run any tests after this one that try to gain access to
// registered command line options because this will likely result in a
// SEGFAULT. This can occur because the cl::opt in the test below is declared
// on the stack which will be destroyed after the test completes but the
// command line system will still hold a pointer to a deallocated cl::Option.
;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_ParseEnvironmentToLocalVar_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 149,
 FQN="(anonymous namespace)::CommandLineTest_ParseEnvironmentToLocalVar_Test::TestBody", NM="_ZN12_GLOBAL__N_147CommandLineTest_ParseEnvironmentToLocalVar_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_147CommandLineTest_ParseEnvironmentToLocalVar_Test8TestBodyEv")
//</editor-fold>
@Test public void test_ParseEnvironmentToLocalVar() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   StackOptionString EnvironmentTestOptionLocal = null;
  TempEnvVar TEV = null;
  try {
    // Put cl::opt on stack to check for proper initialization of fields.
    EnvironmentTestOptionLocal/*J*/= new StackOptionString($("env-test-opt-local"));
    TEV/*J*/= new TempEnvVar(test_env_var, $("-env-test-opt-local=hello-local"));
    EXPECT_EQ("",EnvironmentTestOptionLocal);
    ClGlobals.ParseEnvironmentOptions($("CommandLineTest"), test_env_var);
    EXPECT_EQ("hello-local",EnvironmentTestOptionLocal);
  } finally {
    if (TEV != null) { TEV.$destroy(); }
    if (EnvironmentTestOptionLocal != null) { EnvironmentTestOptionLocal.$destroy(); }
  }
}

// SKIP_ENVIRONMENT_TESTS
;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_UseOptionCategory_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 160,
 FQN="(anonymous namespace)::CommandLineTest_UseOptionCategory_Test::TestBody", NM="_ZN12_GLOBAL__N_138CommandLineTest_UseOptionCategory_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_138CommandLineTest_UseOptionCategory_Test8TestBodyEv")
//</editor-fold>
@Test public void test_UseOptionCategory() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   StackOptionInt TestOption2 = null;
  try {
    TestOption2/*J*/= new StackOptionInt($("test-option"), new cat(TestCategory));
    EXPECT_EQ($AddrOf(TestCategory),TestOption2.Category);
  } finally {
    if (TestOption2 != null) { TestOption2.$destroy(); }
  }
}

@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 167)
private static @FunctionalInterface interface ParserFunction {
  void $call(StringRef Source, StringSaver /*&*/Saver,
                            SmallVectorImpl<char$ptr> /*&*/NewArgv,
                            boolean MarkEOLs);
}
// JAVA: typedef void (ParserFunction)(StringRef, StringSaver &, SmallVectorImpl<const char *> &, bool)
//public final class ParserFunction extends /*ADD MAPPING FOR FUN PTR[void (StringRef, StringSaver & , SmallVectorImpl</*const*/char$ptr/*char P*/ > & , bool)]*/void (StringRef, StringSaver /*&*/ , SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ , boolean){ };

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::testCommandLineTokenizer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 171,
 FQN="(anonymous namespace)::testCommandLineTokenizer", NM="_ZN12_GLOBAL__N_124testCommandLineTokenizerEPFvN4llvm9StringRefERNS0_11StringSaverERNS0_15SmallVectorImplIPKcEEbES6_PKS6_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_124testCommandLineTokenizerEPFvN4llvm9StringRefERNS0_11StringSaverERNS0_15SmallVectorImplIPKcEEbES6_PKS6_j")
//</editor-fold>
public static void testCommandLineTokenizer(ParserFunction parse, /*const*/char$ptr/*char P*/ Input, 
                        type$ptr</*const*/char$ptr/*char P*//*const*//*[-1]*/> Output, /*size_t*/int OutputSize) {
  BumpPtrAllocatorImpl A = null;
  try {
    SmallVector</*const*/char$ptr/*char P*//*,  0*/> Actual/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  0*/>(0, null);
    A/*J*/= new BumpPtrAllocatorImpl();
    StringSaver Saver/*J*/= new StringSaver(A);
    parse.$call(new StringRef(Input), Saver, Actual, /*MarkEOLs=*/ false);
    EXPECT_EQ(OutputSize,Actual.size());
    for (/*uint*/int I = 0, E = Actual.size(); I != E; ++I) {
      if ($less_uint(I, OutputSize)) {
    EXPECT_STREQ(Output.$at(I),Actual.$at(I));
      }
    }
  } finally {
    if (A != null) { A.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_TokenizeGNUCommandLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 184,
 FQN="(anonymous namespace)::CommandLineTest_TokenizeGNUCommandLine_Test::TestBody", NM="_ZN12_GLOBAL__N_143CommandLineTest_TokenizeGNUCommandLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_143CommandLineTest_TokenizeGNUCommandLine_Test8TestBodyEv")
//</editor-fold>
@Test public void test_TokenizeGNUCommandLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   /*const*/char$ptr/*char P*/ Input = $("foo\\ bar \"foo bar\" 'foo bar' 'foo\\\\bar' -DFOO=bar\\(\\) foo\"bar\"baz C:\\\\src\\\\foo.cpp \"C:\\src\\foo.cpp\"");
  type$ptr</*const*/char$ptr/*char P*//*const*//*[8]*/> Output = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*8*/] {
    $("foo bar"), $("foo bar"), $("foo bar"), $("foo\\bar"), 
    $("-DFOO=bar()"), $("foobarbaz"), $("C:\\src\\foo.cpp"), $("C:srcfoo.cpp")});
  testCommandLineTokenizer(/*FuncRef*/ClGlobals::TokenizeGNUCommandLine, Input, Output, 
      array_lengthof(Output.$array()));
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_TokenizeWindowsCommandLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 195,
 FQN="(anonymous namespace)::CommandLineTest_TokenizeWindowsCommandLine_Test::TestBody", NM="_ZN12_GLOBAL__N_147CommandLineTest_TokenizeWindowsCommandLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_147CommandLineTest_TokenizeWindowsCommandLine_Test8TestBodyEv")
//</editor-fold>
@Test public void test_TokenizeWindowsCommandLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   /*const*/char$ptr/*char P*/ Input = $("a\\b c\\\\d e\\\\\"f g\" h\\\"i j\\\\\\\"k \"lmn\" o pqr \"st \\\"u\" \\v");
  type$ptr</*const*/char$ptr/*char P*//*const*//*[10]*/> Output = create_type$ptr(new /*const*/char$ptr/*char P*//*const*/ [/*10*/] {
    $("a\\b"), $("c\\\\d"), $("e\\f g"), $("h\"i"), $("j\\\"k"), 
    $("lmn"), $o, $("pqr"), $("st \"u"), $("\\v")});
  testCommandLineTokenizer(/*FuncRef*/ClGlobals::TokenizeWindowsCommandLine, Input, Output, 
      array_lengthof(Output.$array()));
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_AliasesWithArguments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 204,
 FQN="(anonymous namespace)::CommandLineTest_AliasesWithArguments_Test::TestBody", NM="_ZN12_GLOBAL__N_141CommandLineTest_AliasesWithArguments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_141CommandLineTest_AliasesWithArguments_Test8TestBodyEv")
//</editor-fold>
@Test public void test_AliasesWithArguments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   final/*static*/ /*const*//*size_t*/int ARGC = test_AliasesWithArguments$$.ARGC;
  char$ptr Inputs[][] = new char$ptr[4][];
  { // type$ptr</*const*/char$ptr/*char P*//*const*//*[3]*/> [/*4*/] {
    Inputs[0] = new /*const*/char$ptr/*char P*//*const*/ [/*3*/] {$("-tool"), $("-actual=x"), $("-extra")};
    Inputs[1] = new /*const*/char$ptr/*char P*//*const*/ [/*3*/] {$("-tool"), $("-actual"), $x};
    Inputs[2] = new /*const*/char$ptr/*char P*//*const*/ [/*3*/] {$("-tool"), $("-alias=x"), $("-extra")};
    Inputs[3] = new /*const*/char$ptr/*char P*//*const*/ [/*3*/] {$("-tool"), $("-alias"), $x};
  };
  
  for (/*size_t*/int i = 0, e = array_lengthof(Inputs); $less_uint(i, e); ++i) {
    StackOptionString Actual = null;
    StackOptionBool Extra = null;
    StackOptionString Input = null;
    alias Alias = null;
    try {
      Actual/*J*/= new StackOptionString($("actual"));
      Extra/*J*/= new StackOptionBool($("extra"));
      Input/*J*/= new StackOptionString(FormattingFlags.Positional);
      
      Alias/*J*/= new alias($("alias"), new aliasopt(Actual));
      
      ClGlobals.ParseCommandLineOptions(ARGC, Inputs[i]);
    EXPECT_EQ("x",Actual);
    EXPECT_EQ(0,Input.getNumOccurrences());
      
      Alias.removeArgument();
    } finally {
      if (Alias != null) { Alias.$destroy(); }
      if (Input != null) { Input.$destroy(); }
      if (Extra != null) { Extra.$destroy(); }
      if (Actual != null) { Actual.$destroy(); }
    }
  }
}
private static final class test_AliasesWithArguments$$ {
  static final/*static*/ /*const*//*size_t*/int ARGC = 3;
}


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::testAliasRequired">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 228,
 FQN="(anonymous namespace)::testAliasRequired", NM="_ZN12_GLOBAL__N_117testAliasRequiredEiPKPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_117testAliasRequiredEiPKPKc")
//</editor-fold>
public static void testAliasRequired(int argc, /*const*/type$ptr<char$ptr>/*char P const P*/ argv) {  
  StackOptionString Option = null;
  alias Alias = null;
  try {
    Option/*J*/= new StackOptionString($("option"), NumOccurrencesFlag.Required);
    Alias/*J*/= new alias($o, new aliasopt(Option));
    
    ClGlobals.ParseCommandLineOptions(argc, argv);
    EXPECT_EQ("x",Option);
    EXPECT_EQ(1,Option.getNumOccurrences());
    
    Alias.removeArgument();
  } finally {
    if (Alias != null) { Alias.$destroy(); }
    if (Option != null) { Option.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_AliasRequired_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 239,
 FQN="(anonymous namespace)::CommandLineTest_AliasRequired_Test::TestBody", NM="_ZN12_GLOBAL__N_134CommandLineTest_AliasRequired_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_134CommandLineTest_AliasRequired_Test8TestBodyEv")
//</editor-fold>
@Test public void test_AliasRequired() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> opts1 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("-tool"), $("-option=x")});
  type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> opts2 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("-tool"), $("-o"), $x});
  testAliasRequired(array_lengthof(opts1.$array()), opts1);
  testAliasRequired(array_lengthof(opts2.$array()), opts2);
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_HideUnrelatedOptions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 246,
 FQN="(anonymous namespace)::CommandLineTest_HideUnrelatedOptions_Test::TestBody", NM="_ZN12_GLOBAL__N_141CommandLineTest_HideUnrelatedOptions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_141CommandLineTest_HideUnrelatedOptions_Test8TestBodyEv")
//</editor-fold>
@Test public void test_HideUnrelatedOptions() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
   StackOptionInt TestOption1 = null;
  StackOptionInt TestOption2 = null;
  try {
    TestOption1/*J*/= new StackOptionInt($("hide-option-1"));
    TestOption2/*J*/= new StackOptionInt($("hide-option-2"), new cat(TestCategory));
    
    ClGlobals.HideUnrelatedOptions(TestCategory);
    EXPECT_EQ(OptionHidden.ReallyHidden,TestOption1.getOptionHiddenFlag());
    EXPECT_EQ(OptionHidden.NotHidden,TestOption2.getOptionHiddenFlag());
    SubCommand $star1 = ClGlobals.TopLevelSubCommand.$star();
    
    final StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ Map = ClGlobals.getRegisteredOptions($star1.OptionsMap);
    EXPECT_EQ(OptionHidden.NotHidden,Map.$at(/*STRINGREF_STR*/"help").getOptionHiddenFlag());
  } finally {
    if (TestOption2 != null) { TestOption2.$destroy(); }
    if (TestOption1 != null) { TestOption1.$destroy(); }
  }
}


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TestCategory2">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 263,
 FQN="(anonymous namespace)::TestCategory2", NM="_ZN12_GLOBAL__N_113TestCategory2E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_113TestCategory2E")
//</editor-fold>
public static final OptionCategory TestCategory2/*J*/= new OptionCategory($("Test Options set 2"), $("Description"));
;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_HideUnrelatedOptionsMulti_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 265,
 FQN="(anonymous namespace)::CommandLineTest_HideUnrelatedOptionsMulti_Test::TestBody", NM="_ZN12_GLOBAL__N_146CommandLineTest_HideUnrelatedOptionsMulti_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_146CommandLineTest_HideUnrelatedOptionsMulti_Test8TestBodyEv")
//</editor-fold>
@Test public void test_HideUnrelatedOptionsMulti() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
  StackOptionInt TestOption1 = null;
  StackOptionInt TestOption2 = null;
  StackOptionInt TestOption3 = null;
  try {
    TestOption1/*J*/= new StackOptionInt($("multi-hide-option-1"));
    TestOption2/*J*/= new StackOptionInt($("multi-hide-option-2"), new cat(TestCategory));
    TestOption3/*J*/= new StackOptionInt($("multi-hide-option-3"), new cat(TestCategory2));
    
    /*const*/ OptionCategory /*P*/ VisibleCategories[/*2*/] = new /*const*/ OptionCategory /*P*/  [/*2*/] {
      $AddrOf(TestCategory), 
      $AddrOf(TestCategory2)};
    
    ClGlobals.HideUnrelatedOptions(makeArrayRef(VisibleCategories));
    EXPECT_EQ(OptionHidden.ReallyHidden,TestOption1.getOptionHiddenFlag());
    EXPECT_EQ(OptionHidden.NotHidden,TestOption2.getOptionHiddenFlag());
    EXPECT_EQ(OptionHidden.NotHidden,TestOption3.getOptionHiddenFlag());
    
    final StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ Map = ClGlobals.getRegisteredOptions(ClGlobals.TopLevelSubCommand.$star());
    EXPECT_EQ(OptionHidden.NotHidden,Map.$at(/*STRINGREF_STR*/"help").getOptionHiddenFlag());
  } finally {
    if (TestOption3 != null) { TestOption3.$destroy(); }
    if (TestOption2 != null) { TestOption2.$destroy(); }
    if (TestOption1 != null) { TestOption1.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_SetValueInSubcategories_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 288,
 FQN="(anonymous namespace)::CommandLineTest_SetValueInSubcategories_Test::TestBody", NM="_ZN12_GLOBAL__N_144CommandLineTest_SetValueInSubcategories_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_144CommandLineTest_SetValueInSubcategories_Test8TestBodyEv")
//</editor-fold>
@Test public void test_SetValueInSubcategories() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
   StackSubCommand SC1 = null;
  StackSubCommand SC2 = null;
  StackOptionBool TopLevelOpt = null;
  StackOptionBool SC1Opt = null;
  StackOptionBool SC2Opt = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    SC1/*J*/= new StackSubCommand($("sc1"), $("First subcommand"));
    SC2/*J*/= new StackSubCommand($("sc2"), $("Second subcommand"));
    
    TopLevelOpt/*J*/= new StackOptionBool($("top-level"), ClGlobals.init(false));
    SC1Opt/*J*/= new StackOptionBool($("sc1"), new sub(SC1), ClGlobals.init(false));
    SC2Opt/*J*/= new StackOptionBool($("sc2"), new sub(SC2), ClGlobals.init(false));
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_FALSE((SC1Opt).$T());
    EXPECT_FALSE((SC2Opt).$T());
    type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("prog"), $("-top-level")});
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(2, args, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(TopLevelOpt.$T());
    EXPECT_FALSE((SC1Opt).$T());
    EXPECT_FALSE((SC2Opt).$T());
    
    TopLevelOpt.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_FALSE((SC1Opt).$T());
    EXPECT_FALSE((SC2Opt).$T());
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args2 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc1"), $("-sc1")});
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args2, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_TRUE(SC1Opt.$T());
    EXPECT_FALSE((SC2Opt).$T());
    
    SC1Opt.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_FALSE((SC1Opt).$T());
    EXPECT_FALSE((SC2Opt).$T());
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args3 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc2"), $("-sc2")});
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args3, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_FALSE((SC1Opt).$T());
    EXPECT_TRUE(SC2Opt.$T());
  } finally {
    if (SC2Opt != null) { SC2Opt.$destroy(); }
    if (SC1Opt != null) { SC1Opt.$destroy(); }
    if (TopLevelOpt != null) { TopLevelOpt.$destroy(); }
    if (SC2 != null) { SC2.$destroy(); }
    if (SC1 != null) { SC1.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_LookupFailsInWrongSubCommand_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 332,
 FQN="(anonymous namespace)::CommandLineTest_LookupFailsInWrongSubCommand_Test::TestBody", NM="_ZN12_GLOBAL__N_149CommandLineTest_LookupFailsInWrongSubCommand_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_149CommandLineTest_LookupFailsInWrongSubCommand_Test8TestBodyEv")
//</editor-fold>
@Test public void test_LookupFailsInWrongSubCommand() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   StackSubCommand SC1 = null;
  StackSubCommand SC2 = null;
  StackOptionBool SC1Opt = null;
  StackOptionBool SC2Opt = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    SC1/*J*/= new StackSubCommand($("sc1"), $("First subcommand"));
    SC2/*J*/= new StackSubCommand($("sc2"), $("Second subcommand"));
    
    SC1Opt/*J*/= new StackOptionBool($("sc1"), new sub(SC1), ClGlobals.init(false));
    SC2Opt/*J*/= new StackOptionBool($("sc2"), new sub(SC2), ClGlobals.init(false));
    
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc1"), $("-sc2")});
    EXPECT_FALSE(ClGlobals.ParseCommandLineOptions(3, args, (/*const*/char$ptr/*char P*/ )null, true));
  } finally {
    if (SC2Opt != null) { SC2Opt.$destroy(); }
    if (SC1Opt != null) { SC1Opt.$destroy(); }
    if (SC2 != null) { SC2.$destroy(); }
    if (SC1 != null) { SC1.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_AddToAllSubCommands_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 345,
 FQN="(anonymous namespace)::CommandLineTest_AddToAllSubCommands_Test::TestBody", NM="_ZN12_GLOBAL__N_140CommandLineTest_AddToAllSubCommands_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_140CommandLineTest_AddToAllSubCommands_Test8TestBodyEv")
//</editor-fold>
@Test public void test_AddToAllSubCommands() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
   StackSubCommand SC1 = null;
  StackOptionBool AllOpt = null;
  StackSubCommand SC2 = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    SC1/*J*/= new StackSubCommand($("sc1"), $("First subcommand"));
    AllOpt/*J*/= new StackOptionBool($("everywhere"), new sub(ClGlobals.AllSubCommands.$star()), 
        ClGlobals.init(false));
    SC2/*J*/= new StackSubCommand($("sc2"), $("Second subcommand"));
    
    type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("prog"), $("-everywhere")});
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args2 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc1"), $("-everywhere")});
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args3 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc2"), $("-everywhere")});
    EXPECT_FALSE((AllOpt).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(2, args, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(AllOpt.$T());
    
    AllOpt.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((AllOpt).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args2, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(AllOpt.$T());
    
    AllOpt.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((AllOpt).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args3, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(AllOpt.$T());
  } finally {
    if (SC2 != null) { SC2.$destroy(); }
    if (AllOpt != null) { AllOpt.$destroy(); }
    if (SC1 != null) { SC1.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_ReparseCommandLineOptions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 376,
 FQN="(anonymous namespace)::CommandLineTest_ReparseCommandLineOptions_Test::TestBody", NM="_ZN12_GLOBAL__N_146CommandLineTest_ReparseCommandLineOptions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_146CommandLineTest_ReparseCommandLineOptions_Test8TestBodyEv")
//</editor-fold>
@Test public void test_ReparseCommandLineOptions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   StackOptionBool TopLevelOpt = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    TopLevelOpt/*J*/= new StackOptionBool($("top-level"), new sub(ClGlobals.TopLevelSubCommand.$star()), 
        ClGlobals.init(false));
    
    type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("prog"), $("-top-level")});
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(2, args, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(TopLevelOpt.$T());
    
    TopLevelOpt.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((TopLevelOpt).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(2, args, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(TopLevelOpt.$T());
  } finally {
    if (TopLevelOpt != null) { TopLevelOpt.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_RemoveFromRegularSubCommand_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 396,
 FQN="(anonymous namespace)::CommandLineTest_RemoveFromRegularSubCommand_Test::TestBody", NM="_ZN12_GLOBAL__N_148CommandLineTest_RemoveFromRegularSubCommand_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_148CommandLineTest_RemoveFromRegularSubCommand_Test8TestBodyEv")
//</editor-fold>
@Test public void test_RemoveFromRegularSubCommand() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
   StackSubCommand SC = null;
  StackOptionBool RemoveOption = null;
  StackOptionBool KeepOption = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    SC/*J*/= new StackSubCommand($("sc"), $("Subcommand"));
    RemoveOption/*J*/= new StackOptionBool($("remove-option"), new sub(SC), ClGlobals.init(false));
    KeepOption/*J*/= new StackOptionBool($("keep-option"), new sub(SC), ClGlobals.init(false));
    
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc"), $("-remove-option")});
    EXPECT_FALSE((RemoveOption).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(RemoveOption.$T());
    
    RemoveOption.removeArgument();
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE(ClGlobals.ParseCommandLineOptions(3, args, (/*const*/char$ptr/*char P*/ )null, true));
  } finally {
    if (KeepOption != null) { KeepOption.$destroy(); }
    if (RemoveOption != null) { RemoveOption.$destroy(); }
    if (SC != null) { SC.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_RemoveFromTopLevelSubCommand_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 415,
 FQN="(anonymous namespace)::CommandLineTest_RemoveFromTopLevelSubCommand_Test::TestBody", NM="_ZN12_GLOBAL__N_149CommandLineTest_RemoveFromTopLevelSubCommand_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_149CommandLineTest_RemoveFromTopLevelSubCommand_Test8TestBodyEv")
//</editor-fold>
@Test public void test_RemoveFromTopLevelSubCommand() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   StackOptionBool TopLevelRemove = null;
  StackOptionBool TopLevelKeep = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    TopLevelRemove/*J*/= new StackOptionBool($("top-level-remove"), new sub(ClGlobals.TopLevelSubCommand.$star()), ClGlobals.init(false));
    TopLevelKeep/*J*/= new StackOptionBool($("top-level-keep"), new sub(ClGlobals.TopLevelSubCommand.$star()), ClGlobals.init(false));
    
    type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> args = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("prog"), $("-top-level-remove")});
    EXPECT_FALSE((TopLevelRemove).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(2, args, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(TopLevelRemove.$T());
    
    TopLevelRemove.removeArgument();
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE(ClGlobals.ParseCommandLineOptions(2, args, (/*const*/char$ptr/*char P*/ )null, true));
  } finally {
    if (TopLevelKeep != null) { TopLevelKeep.$destroy(); }
    if (TopLevelRemove != null) { TopLevelRemove.$destroy(); }
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineTest_RemoveFromAllSubCommands_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp", line = 435,
 FQN="(anonymous namespace)::CommandLineTest_RemoveFromAllSubCommands_Test::TestBody", NM="_ZN12_GLOBAL__N_145CommandLineTest_RemoveFromAllSubCommands_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/Support/CommandLineTest.cpp -nm=_ZN12_GLOBAL__N_145CommandLineTest_RemoveFromAllSubCommands_Test8TestBodyEv")
//</editor-fold>
@Test public void test_RemoveFromAllSubCommands() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
   StackSubCommand SC1 = null;
  StackSubCommand SC2 = null;
  StackOptionBool RemoveOption = null;
  StackOptionBool KeepOption = null;
  try {
    ClGlobals.ResetCommandLineParser();
    
    SC1/*J*/= new StackSubCommand($("sc1"), $("First Subcommand"));
    SC2/*J*/= new StackSubCommand($("sc2"), $("Second Subcommand"));
    RemoveOption/*J*/= new StackOptionBool($("remove-option"), new sub(ClGlobals.AllSubCommands.$star()), 
        ClGlobals.init(false));
    KeepOption/*J*/= new StackOptionBool($("keep-option"), new sub(ClGlobals.AllSubCommands.$star()), 
        ClGlobals.init(false));
    
    type$ptr</*const*/char$ptr/*char P*/ /*[2]*/> args0 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*2*/] {$("prog"), $("-remove-option")});
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args1 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc1"), $("-remove-option")});
    type$ptr</*const*/char$ptr/*char P*/ /*[3]*/> args2 = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*3*/] {$("prog"), $("sc2"), $("-remove-option")});
    
    // It should work for all subcommands including the top-level.
    EXPECT_FALSE((RemoveOption).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(2, args0, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(RemoveOption.$T());
    
    RemoveOption.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((RemoveOption).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args1, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(RemoveOption.$T());
    
    RemoveOption.$assign(/*KEEP_BOOL*/false);
    
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE((RemoveOption).$T());
    EXPECT_TRUE(ClGlobals.ParseCommandLineOptions(3, args2, (/*const*/char$ptr/*char P*/ )null, true));
    EXPECT_TRUE(RemoveOption.$T());
    
    RemoveOption.removeArgument();
    
    // It should not work for any subcommands including the top-level.
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE(ClGlobals.ParseCommandLineOptions(2, args0, (/*const*/char$ptr/*char P*/ )null, true));
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE(ClGlobals.ParseCommandLineOptions(3, args1, (/*const*/char$ptr/*char P*/ )null, true));
    ClGlobals.ResetAllOptionOccurrences();
    EXPECT_FALSE(ClGlobals.ParseCommandLineOptions(3, args2, (/*const*/char$ptr/*char P*/ )null, true));
  } finally {
    if (KeepOption != null) { KeepOption.$destroy(); }
    if (RemoveOption != null) { RemoveOption.$destroy(); }
    if (SC2 != null) { SC2.$destroy(); }
    if (SC1 != null) { SC1.$destroy(); }
  }
}

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class CommandLineTest

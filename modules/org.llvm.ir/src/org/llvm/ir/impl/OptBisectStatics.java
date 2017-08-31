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
package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.cl.*;
import org.llvm.ir.java.*;
import org.llvm.cl.aliases.optInt;


//<editor-fold defaultstate="collapsed" desc="static type OptBisectStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.OptBisectStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14OptBisectLimit;_ZL14getDescriptionB5cxx11RKN4llvm10BasicBlockE;_ZL14getDescriptionB5cxx11RKN4llvm12CallGraphSCCE;_ZL14getDescriptionB5cxx11RKN4llvm4LoopE;_ZL14getDescriptionB5cxx11RKN4llvm6ModuleE;_ZL14getDescriptionB5cxx11RKN4llvm8FunctionE;_ZL16printCaseMessageiN4llvm9StringRefEb;_ZL16printPassMessageRKN4llvm9StringRefEiS0_b; -static-type=OptBisectStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class OptBisectStatics {

//<editor-fold defaultstate="collapsed" desc="OptBisectLimit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 27,
 FQN="OptBisectLimit", NM="_ZL14OptBisectLimit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14OptBisectLimit")
//</editor-fold>
public static optInt OptBisectLimit/*J*/= new optInt(false, $("opt-bisect-limit"), OptionHidden.Hidden, 
    ClGlobals.init$Int(INT_MAX), NumOccurrencesFlag.Optional, 
    new desc($("Maximum optimization to perform")));
//<editor-fold defaultstate="collapsed" desc="printPassMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 35,
 FQN="printPassMessage", NM="_ZL16printPassMessageRKN4llvm9StringRefEiS0_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL16printPassMessageRKN4llvm9StringRefEiS0_b")
//</editor-fold>
public static void printPassMessage(final /*const*/ StringRef /*&*/ Name, int PassNum, 
                StringRef TargetDesc, boolean Running) {
  StringRef Status = new StringRef(Running ? $EMPTY : $("NOT "));
  errs().$out(/*KEEP_STR*/"BISECT: ").$out(/*NO_COPY*/Status).$out(/*KEEP_STR*/"running pass ").$out(
      /*KEEP_STR*/$LPAREN
  ).$out_int(PassNum).$out(/*KEEP_STR*/") ").$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/" on ").$out(/*NO_COPY*/TargetDesc).$out(/*KEEP_STR*/$LF);
}

//<editor-fold defaultstate="collapsed" desc="printCaseMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 42,
 FQN="printCaseMessage", NM="_ZL16printCaseMessageiN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL16printCaseMessageiN4llvm9StringRefEb")
//</editor-fold>
public static void printCaseMessage(int CaseNum, StringRef Msg, boolean Running) {
  if (Running) {
    errs().$out(/*KEEP_STR*/"BISECT: running case (");
  } else {
    errs().$out(/*KEEP_STR*/"BISECT: NOT running case (");
  }
  errs().$out_int(CaseNum).$out(/*KEEP_STR*/"): ").$out(/*NO_COPY*/Msg).$out(/*KEEP_STR*/$LF);
}

//<editor-fold defaultstate="collapsed" desc="getDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 50,
 FQN="getDescription", NM="_ZL14getDescriptionRKN4llvm6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14getDescriptionRKN4llvm6ModuleE")
//</editor-fold>
public static std.string getDescription(final /*const*/ Module /*&*/ M) {
  return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"module (", M.getName().str()), /*KEEP_STR*/")");
}

//<editor-fold defaultstate="collapsed" desc="getDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 54,
 FQN="getDescription", NM="_ZL14getDescriptionRKN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14getDescriptionRKN4llvm8FunctionE")
//</editor-fold>
public static std.string getDescription(final /*const*/ Function /*&*/ F) {
  return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"function (", F.getName().str()), /*KEEP_STR*/")");
}

//<editor-fold defaultstate="collapsed" desc="getDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 58,
 FQN="getDescription", NM="_ZL14getDescriptionRKN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14getDescriptionRKN4llvm10BasicBlockE")
//</editor-fold>
public static std.string getDescription(final /*const*/ BasicBlock /*&*/ BB) {
  return $add_string_T$C$P($add_string($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"basic block (", BB.getName().str()), /*KEEP_STR*/") in function ("), 
          BB.getParent$Const().getName().str()), /*KEEP_STR*/")");
}

//<editor-fold defaultstate="collapsed" desc="getDescription">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 63,
 FQN="getDescription", NM="_ZL14getDescriptionRKN4llvm4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14getDescriptionRKN4llvm4LoopE")
//</editor-fold>
public static std.string getDescription(final /*const*/ Loop /*&*/ L) {
  // FIXME: I'd like to be able to provide a better description here, but
  //        calling L->getHeader() would introduce a new dependency on the
  //        LLVMCore library.
  return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"loop");
}

//<editor-fold defaultstate="collapsed" desc="getDescription">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp", line = 70,
 FQN="getDescription", NM="_ZL14getDescriptionRKN4llvm12CallGraphSCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp -nm=_ZL14getDescriptionRKN4llvm12CallGraphSCCE")
//</editor-fold>
public static std.string getDescription(final /*const*/ CallGraphSCCBase /*&*/ SCC) {
  std.string Desc = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"SCC (");
  boolean First = true;
  for (CallGraphNodeBase /*P*/ CGN : SCC) {
    if (First) {
      First = false;
    } else {
      Desc.$addassign_T$C$P(/*KEEP_STR*/", ");
    }
    Function /*P*/ F = CGN.getFunction();
    if ((F != null)) {
      $addassign_string_StringRef(Desc, F.getName());
    } else {
      Desc.$addassign_T$C$P(/*KEEP_STR*/"<<null function>>");
    }
  }
  Desc.$addassign_T$C$P(/*KEEP_STR*/")");
  return Desc;
}

} // END OF class OptBisectStatics

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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CallAndMessageCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZL23supportsNilWithFloatRetRKN4llvm6TripleE;_ZL35describeUninitializedArgumentInCallRKN5clang4ento9CallEventEb;_ZN12_GLOBAL__N_112ChecksFilterE; -static-type=CallAndMessageCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class CallAndMessageCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChecksFilter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 31,
 FQN="(anonymous namespace)::ChecksFilter", NM="_ZN12_GLOBAL__N_112ChecksFilterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN12_GLOBAL__N_112ChecksFilterE")
//</editor-fold>
public static class/*struct*/ ChecksFilter {
  public DefaultBool Check_CallAndMessageUnInitRefArg;
  public DefaultBool Check_CallAndMessageChecker;
  
  public CheckName CheckName_CallAndMessageUnInitRefArg;
  public CheckName CheckName_CallAndMessageChecker;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChecksFilter::ChecksFilter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 31,
   FQN="(anonymous namespace)::ChecksFilter::ChecksFilter", NM="_ZN12_GLOBAL__N_112ChecksFilterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZN12_GLOBAL__N_112ChecksFilterC1Ev")
  //</editor-fold>
  public /*inline*/ ChecksFilter() {
    // : Check_CallAndMessageUnInitRefArg(), Check_CallAndMessageChecker(), CheckName_CallAndMessageUnInitRefArg(), CheckName_CallAndMessageChecker() 
    //START JInit
    this.Check_CallAndMessageUnInitRefArg = new DefaultBool();
    this.Check_CallAndMessageChecker = new DefaultBool();
    this.CheckName_CallAndMessageUnInitRefArg = new CheckName();
    this.CheckName_CallAndMessageChecker = new CheckName();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Check_CallAndMessageUnInitRefArg=" + Check_CallAndMessageUnInitRefArg // NOI18N
              + ", Check_CallAndMessageChecker=" + Check_CallAndMessageChecker // NOI18N
              + ", CheckName_CallAndMessageUnInitRefArg=" + CheckName_CallAndMessageUnInitRefArg // NOI18N
              + ", CheckName_CallAndMessageChecker=" + CheckName_CallAndMessageChecker; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="describeUninitializedArgumentInCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 114,
 FQN="describeUninitializedArgumentInCall", NM="_ZL35describeUninitializedArgumentInCallRKN5clang4ento9CallEventEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZL35describeUninitializedArgumentInCallRKN5clang4ento9CallEventEb")
//</editor-fold>
public static StringRef describeUninitializedArgumentInCall(final /*const*/ CallEvent /*&*/ Call, 
                                   boolean IsFirstArgument) {
  switch (Call.getKind()) {
   case CE_ObjCMessage:
    {
      final /*const*/ ObjCMethodCall /*&*/ Msg = cast_ObjCMethodCall(Call);
      switch (Msg.getMessageKind()) {
       case OCM_Message:
        return new StringRef(/*KEEP_STR*/"Argument in message expression is an uninitialized value");
       case OCM_PropertyAccess:
        assert (Msg.isSetter()) : "Getters have no args";
        return new StringRef(/*KEEP_STR*/"Argument for property setter is an uninitialized value");
       case OCM_Subscript:
        if (Msg.isSetter() && IsFirstArgument) {
          return new StringRef(/*KEEP_STR*/"Argument for subscript setter is an uninitialized value");
        }
        return new StringRef(/*KEEP_STR*/"Subscript index is an uninitialized value");
      }
      throw new llvm_unreachable("Unknown message kind.");
    }
   case CE_Block:
    return new StringRef(/*KEEP_STR*/"Block call argument is an uninitialized value");
   default:
    return new StringRef(/*KEEP_STR*/"Function call argument is an uninitialized value");
  }
}

//<editor-fold defaultstate="collapsed" desc="supportsNilWithFloatRet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp", line = 523,
 FQN="supportsNilWithFloatRet", NM="_ZL23supportsNilWithFloatRetRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CallAndMessageChecker.cpp -nm=_ZL23supportsNilWithFloatRetRKN4llvm6TripleE")
//</editor-fold>
public static boolean supportsNilWithFloatRet(final /*const*/ Triple /*&*/ triple) {
  return (triple.getVendor() == Triple.VendorType.Apple
     && (triple.isiOS() || triple.isWatchOS()
     || !triple.isMacOSXVersionLT(10, 5)));
}

} // END OF class CallAndMessageCheckerStatics

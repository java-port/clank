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
import org.clank.support.aliases.uint$ptr;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type NSErrorCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.NSErrorCheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=Tpl__ZL7hasFlagN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE;Tpl__ZL7setFlagN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValERNS2_14CheckerContextE;_ZL21parameterTypeFromSValN5clang4ento4SValERNS0_14CheckerContextE;_ZL9IsCFErrorN5clang8QualTypeEPNS_14IdentifierInfoE;_ZL9IsNSErrorN5clang8QualTypeEPNS_14IdentifierInfoE; -static-type=NSErrorCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class NSErrorCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="IsNSError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 281,
 FQN="IsNSError", NM="_ZL9IsNSErrorN5clang8QualTypeEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZL9IsNSErrorN5clang8QualTypeEPNS_14IdentifierInfoE")
//</editor-fold>
public static boolean IsNSError(QualType T, IdentifierInfo /*P*/ II) {
  
  /*const*/ PointerType /*P*/ PPT = T.$arrow().getAs(PointerType.class);
  if (!(PPT != null)) {
    return false;
  }
  
  /*const*/ ObjCObjectPointerType /*P*/ PT = PPT.getPointeeType().$arrow().getAs(ObjCObjectPointerType.class);
  if (!(PT != null)) {
    return false;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ ID = PT.getInterfaceDecl();
  
  // FIXME: Can ID ever be NULL?
  if ((ID != null)) {
    return II == ID.getIdentifier();
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="IsCFError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 302,
 FQN="IsCFError", NM="_ZL9IsCFErrorN5clang8QualTypeEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZL9IsCFErrorN5clang8QualTypeEPNS_14IdentifierInfoE")
//</editor-fold>
public static boolean IsCFError(QualType T, IdentifierInfo /*P*/ II) {
  /*const*/ PointerType /*P*/ PPT = T.$arrow().getAs(PointerType.class);
  if (!(PPT != null)) {
    return false;
  }
  
  /*const*/ TypedefType /*P*/ TT = PPT.getPointeeType().$arrow().getAs$TypedefType();
  if (!(TT != null)) {
    return false;
  }
  
  return TT.getDecl().getIdentifier() == II;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="hasFlag">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 174,
 FQN="hasFlag", NM="Tpl__ZL7hasFlagN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=Tpl__ZL7hasFlagN5clang4ento4SValEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
//</editor-fold>
public static </*typename*/ T> boolean hasFlag(ProgramStatePartialTraitImmutableMapPtrUInt<SymExpr> $trait, SVal val, IntrusiveRefCntPtr</*const*/ ProgramState> state) {
  {
    /*const*/ SymExpr /*P*/ sym = val.getAsSymbol();
    if ((sym != null)) {
      {
        /*const*/uint$ptr/*uint P*/ attachedFlags = state.$arrow().get($trait, sym);
        if (/*JAVA*/(attachedFlags != null)) {
          return (attachedFlags.$star() != 0);
        }
      }
    }
  }
  return false;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="setFlag">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 182,
 FQN="setFlag", NM="Tpl__ZL7setFlagN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValERNS2_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=Tpl__ZL7setFlagN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValERNS2_14CheckerContextE")
//</editor-fold>
public static </*typename*/ T> void setFlag(ProgramStatePartialTraitImmutableMapPtrUInt<SymExpr> $trait, IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal val, final CheckerContext /*&*/ C) {
  {
    // We tag the symbol that the SVal wraps.
    /*const*/ SymExpr /*P*/ sym = val.getAsSymbol();
    if ((sym != null)) {
      C.addTransition(state.$arrow().set($trait, sym, true));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="parameterTypeFromSVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 188,
 FQN="parameterTypeFromSVal", NM="_ZL21parameterTypeFromSValN5clang4ento4SValERNS0_14CheckerContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZL21parameterTypeFromSValN5clang4ento4SValERNS0_14CheckerContextE")
//</editor-fold>
public static QualType parameterTypeFromSVal(SVal val, final CheckerContext /*&*/ C) {
  /*const*/ StackFrameContext /*P*/ SFC = C.getLocationContext().getCurrentStackFrame();
  {
    Optional<NsLoc.MemRegionVal> X = val.getAs(NsLoc.MemRegionVal.class);
    if (X.$bool()) {
      /*const*/ MemRegion /*P*/ R = X.$arrow().getRegion();
      {
        /*const*/ VarRegion /*P*/ VR = R.getAs(VarRegion.class);
        if ((VR != null)) {
          {
            /*const*/ StackArgumentsSpaceRegion /*P*/ stackReg = dyn_cast_StackArgumentsSpaceRegion(VR.getMemorySpace());
            if ((stackReg != null)) {
              if (stackReg.getStackFrame() == SFC) {
                return VR.getValueType();
              }
            }
          }
        }
      }
    }
  }
  
  return new QualType();
}

} // END OF class NSErrorCheckerStatics

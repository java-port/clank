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
package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import org.clang.analysis.analyses.threadSafety.til.ThreadSafetyTIL.ThreadSafetyTILGlobals;


//<editor-fold defaultstate="collapsed" desc="static type TilGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15getCanonicalValEPKNS1_5SExprE;_ZN5clang12threadSafety3til20getUnaryOpcodeStringENS1_15TIL_UnaryOpcodeE;_ZN5clang12threadSafety3til21getBinaryOpcodeStringENS1_16TIL_BinaryOpcodeE;_ZN5clang12threadSafety3til21simplifyIncompleteArgEPNS1_3PhiE;_ZN5clang12threadSafety3til22simplifyToCanonicalValEPNS1_5SExprE;_ZN5clang12threadSafety3tilL7BOP_MaxE;_ZN5clang12threadSafety3tilL7BOP_MinE;_ZN5clang12threadSafety3tilL7COP_MaxE;_ZN5clang12threadSafety3tilL7COP_MinE;_ZN5clang12threadSafety3tilL7UOP_MaxE;_ZN5clang12threadSafety3tilL7UOP_MinE;_ZN5clang12threadSafety3tilL8CAST_MaxE;_ZN5clang12threadSafety3tilL8CAST_MinE; -static-type=TilGlobals -package=org.clang.analysis.analyses.threadSafety.til")
//</editor-fold>
public final class TilGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::COP_Min">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 109,
 FQN="clang::threadSafety::til::COP_Min", NM="_ZN5clang12threadSafety3tilL7COP_MinE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL7COP_MinE")
//</editor-fold>
public static /*const*/ TIL_Opcode COP_Min = TIL_Opcode.COP_Future;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::COP_Max">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 110,
 FQN="clang::threadSafety::til::COP_Max", NM="_ZN5clang12threadSafety3tilL7COP_MaxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL7COP_MaxE")
//</editor-fold>
public static /*const*/ TIL_Opcode COP_Max = TIL_Opcode.COP_Branch;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UOP_Min">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 111,
 FQN="clang::threadSafety::til::UOP_Min", NM="_ZN5clang12threadSafety3tilL7UOP_MinE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL7UOP_MinE")
//</editor-fold>
public static /*const*/ TIL_UnaryOpcode UOP_Min = TIL_UnaryOpcode.UOP_Minus;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::UOP_Max">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 112,
 FQN="clang::threadSafety::til::UOP_Max", NM="_ZN5clang12threadSafety3tilL7UOP_MaxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL7UOP_MaxE")
//</editor-fold>
public static /*const*/ TIL_UnaryOpcode UOP_Max = TIL_UnaryOpcode.UOP_LogicNot;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BOP_Min">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 113,
 FQN="clang::threadSafety::til::BOP_Min", NM="_ZN5clang12threadSafety3tilL7BOP_MinE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL7BOP_MinE")
//</editor-fold>
public static /*const*/ TIL_BinaryOpcode BOP_Min = TIL_BinaryOpcode.BOP_Add;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::BOP_Max">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 114,
 FQN="clang::threadSafety::til::BOP_Max", NM="_ZN5clang12threadSafety3tilL7BOP_MaxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL7BOP_MaxE")
//</editor-fold>
public static /*const*/ TIL_BinaryOpcode BOP_Max = TIL_BinaryOpcode.BOP_LogicOr;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CAST_Min">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 115,
 FQN="clang::threadSafety::til::CAST_Min", NM="_ZN5clang12threadSafety3tilL8CAST_MinE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL8CAST_MinE")
//</editor-fold>
public static /*const*/ TIL_CastOpcode CAST_Min = TIL_CastOpcode.CAST_none;
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::CAST_Max">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 116,
 FQN="clang::threadSafety::til::CAST_Max", NM="_ZN5clang12threadSafety3tilL8CAST_MaxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3tilL8CAST_MaxE")
//</editor-fold>
public static /*const*/ TIL_CastOpcode CAST_Max = TIL_CastOpcode.CAST_toInt;

/// Return the name of a unary opcode.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::getUnaryOpcodeString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 16,
 FQN="clang::threadSafety::til::getUnaryOpcodeString", NM="_ZN5clang12threadSafety3til20getUnaryOpcodeStringENS1_15TIL_UnaryOpcodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til20getUnaryOpcodeStringENS1_15TIL_UnaryOpcodeE")
//</editor-fold>
public static StringRef getUnaryOpcodeString(TIL_UnaryOpcode Op) {
  switch (Op) {
   case UOP_Minus:
    return new StringRef(/*KEEP_STR*/$MINUS);
   case UOP_BitNot:
    return new StringRef(/*KEEP_STR*/$TILDE);
   case UOP_LogicNot:
    return new StringRef(/*KEEP_STR*/$EXCLAIM);
  }
  return new StringRef(/*KEEP_STR*/$EMPTY);
}


/// Return the name of a binary opcode.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::getBinaryOpcodeString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 25,
 FQN="clang::threadSafety::til::getBinaryOpcodeString", NM="_ZN5clang12threadSafety3til21getBinaryOpcodeStringENS1_16TIL_BinaryOpcodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til21getBinaryOpcodeStringENS1_16TIL_BinaryOpcodeE")
//</editor-fold>
public static StringRef getBinaryOpcodeString(TIL_BinaryOpcode Op) {
  switch (Op) {
   case BOP_Mul:
    return new StringRef(/*KEEP_STR*/$STAR);
   case BOP_Div:
    return new StringRef(/*KEEP_STR*/$SLASH);
   case BOP_Rem:
    return new StringRef(/*KEEP_STR*/$PERCENT);
   case BOP_Add:
    return new StringRef(/*KEEP_STR*/$PLUS);
   case BOP_Sub:
    return new StringRef(/*KEEP_STR*/$MINUS);
   case BOP_Shl:
    return new StringRef(/*KEEP_STR*/$LT_LT);
   case BOP_Shr:
    return new StringRef(/*KEEP_STR*/$GT_GT);
   case BOP_BitAnd:
    return new StringRef(/*KEEP_STR*/$AMP);
   case BOP_BitXor:
    return new StringRef(/*KEEP_STR*/$CARET);
   case BOP_BitOr:
    return new StringRef(/*KEEP_STR*/$PIPE);
   case BOP_Eq:
    return new StringRef(/*KEEP_STR*/$EQ_EQ);
   case BOP_Neq:
    return new StringRef(/*KEEP_STR*/$EXCLAIM_EQ);
   case BOP_Lt:
    return new StringRef(/*KEEP_STR*/$LT);
   case BOP_Leq:
    return new StringRef(/*KEEP_STR*/$LT_EQ);
   case BOP_LogicAnd:
    return new StringRef(/*KEEP_STR*/$AMP_AMP);
   case BOP_LogicOr:
    return new StringRef(/*KEEP_STR*/$PIPE_PIPE);
  }
  return new StringRef(/*KEEP_STR*/$EMPTY);
}


// If E is a variable, then trace back through any aliases or redundant
// Phi nodes to find the canonical definition.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::getCanonicalVal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 82,
 FQN="clang::threadSafety::til::getCanonicalVal", NM="_ZN5clang12threadSafety3til15getCanonicalValEPKNS1_5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til15getCanonicalValEPKNS1_5SExprE")
//</editor-fold>
public static /*const*/ SExpr /*P*/ getCanonicalVal(/*const*/ SExpr /*P*/ E) {
  while (true) {
    {
      /*const*/ Variable /*P*/ V = dyn_cast_Variable(E);
      if ((V != null)) {
        if (V.kind() == Variable.VariableKind.VK_Let) {
          E = V.definition$Const();
          continue;
        }
      }
    }
    {
      /*const*/ Phi /*P*/ Ph = dyn_cast_Phi(E);
      if ((Ph != null)) {
        if (Ph.status() == Phi.Status.PH_SingleVal) {
          E = Ph.values$Const().$at$Const(0);
          continue;
        }
      }
    }
    break;
  }
  return E;
}


// If E is a variable, then trace back through any aliases or redundant
// Phi nodes to find the canonical definition.
// The non-const version will simplify incomplete Phi nodes.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::simplifyToCanonicalVal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 105,
 FQN="clang::threadSafety::til::simplifyToCanonicalVal", NM="_ZN5clang12threadSafety3til22simplifyToCanonicalValEPNS1_5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til22simplifyToCanonicalValEPNS1_5SExprE")
//</editor-fold>
public static SExpr /*P*/ simplifyToCanonicalVal(SExpr /*P*/ E) {
  while (true) {
    {
      Variable /*P*/ V = dyn_cast_Variable(E);
      if ((V != null)) {
        if (V.kind() != Variable.VariableKind.VK_Let) {
          return V;
        }
        // Eliminate redundant variables, e.g. x = y, or x = 5,
        // but keep anything more complicated.
        if (ThreadSafetyTILGlobals.isTrivial(V.definition())) {
          E = V.definition();
          continue;
        }
        return V;
      }
    }
    {
      Phi /*P*/ Ph = dyn_cast_Phi(E);
      if ((Ph != null)) {
        if (Ph.status() == Phi.Status.PH_Incomplete) {
          simplifyIncompleteArg(Ph);
        }
        // Eliminate redundant Phi nodes.
        if (Ph.status() == Phi.Status.PH_SingleVal) {
          E = Ph.values().$at(0);
          continue;
        }
      }
    }
    return E;
  }
}


// Trace the arguments of an incomplete Phi node to see if they have the same
// canonical definition.  If so, mark the Phi node as redundant.
// getCanonicalVal() will recursively call simplifyIncompletePhi().
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::simplifyIncompleteArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp", line = 135,
 FQN="clang::threadSafety::til::simplifyIncompleteArg", NM="_ZN5clang12threadSafety3til21simplifyIncompleteArgEPNS1_3PhiE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til21simplifyIncompleteArgEPNS1_3PhiE")
//</editor-fold>
public static void simplifyIncompleteArg(Phi /*P*/ Ph) {
  assert ((Ph != null) && Ph.status() == Phi.Status.PH_Incomplete);
  
  // eliminate infinite recursion -- assume that this node is not redundant.
  Ph.setStatus(Phi.Status.PH_MultiVal);
  
  SExpr /*P*/ E0 = simplifyToCanonicalVal(Ph.values().$at(0));
  for (/*uint*/int i = 1, n = Ph.values().size(); $less_uint(i, n); ++i) {
    SExpr /*P*/ Ei = simplifyToCanonicalVal(Ph.values().$at(i));
    if (Ei == Ph) {
      continue; // Recursive reference to itself.  Don't count.
    }
    if (Ei != E0) {
      return; // Status is already set to MultiVal.
    }
  }
  Ph.setStatus(Phi.Status.PH_SingleVal);
}

} // END OF class TilGlobals

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
package org.llvm.mc.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import static org.llvm.adt.java.ADTRTTI.dyn_cast_MCSymbolRefExpr;
import org.llvm.mc.*;


//<editor-fold defaultstate="collapsed" desc="static type MCExprStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCExprStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZL19EvaluateSymbolicAddPKN4llvm11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_yEEEEbRKNS_7MCValueEPKNS_15MCSymbolRefExprESN_xRSI_;_ZL35AttemptToFoldSymbolOffsetDifferencePKN4llvm11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_yEEEEbRPKNS_15MCSymbolRefExprESL_Rx;_ZL9canExpandRKN4llvm8MCSymbolEb; -static-type=MCExprStatics -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCExprStatics {


/// \brief Helper method for \see EvaluateSymbolAdd().
//<editor-fold defaultstate="collapsed" desc="AttemptToFoldSymbolOffsetDifference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 448,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 473,
 FQN="AttemptToFoldSymbolOffsetDifference", NM="_ZL35AttemptToFoldSymbolOffsetDifferencePKN4llvm11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_yEEEEbRPKNS_15MCSymbolRefExprESL_Rx",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZL35AttemptToFoldSymbolOffsetDifferencePKN4llvm11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_yEEEEbRPKNS_15MCSymbolRefExprESL_Rx")
//</editor-fold>
public static void AttemptToFoldSymbolOffsetDifference(/*const*/ MCAssembler /*P*/ Asm, /*const*/ MCAsmLayout /*P*/ Layout, 
                                   /*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/ Addrs, boolean InSet, final type$ref</*const*/ MCSymbolRefExpr /*P*/ /*&*/> A, 
                                   final type$ref</*const*/ MCSymbolRefExpr /*P*/ /*&*/> B, final long$ref/*int64_t &*/ Addend) {
  if (!(A.$deref() != null) || !(B.$deref() != null)) {
    return;
  }
  
  final /*const*/ MCSymbol /*&*/ SA = A.$deref().getSymbol();
  final /*const*/ MCSymbol /*&*/ SB = B.$deref().getSymbol();
  if (SA.isUndefined() || SB.isUndefined()) {
    return;
  }
  if (!Asm.getWriter().isSymbolRefDifferenceFullyResolved($Deref(Asm), A.$deref(), B.$deref(), InSet)) {
    return;
  }
  if (SA.getFragment() == SB.getFragment() && !SA.isVariable()
     && !SB.isVariable()) {
    Addend.$set$addassign((SA.getOffset() - SB.getOffset()));
    
    // Pointers to Thumb symbols need to have their low-bit set to allow
    // for interworking.
    if (Asm.isThumbFunc($AddrOf(SA))) {
      Addend.$set$orassign(1);
    }
    
    // Clear the symbol expr pointers to indicate we have folded these
    // operands.
    A.$set(B.$set(null));
    return;
  }
  if (!(Layout != null)) {
    return;
  }
  
  final /*const*/ MCSection /*&*/ SecA = $Deref(SA.getFragment().getParent());
  final /*const*/ MCSection /*&*/ SecB = $Deref(SB.getFragment().getParent());
  if (($AddrOf(SecA) != $AddrOf(SecB)) && !(Addrs != null)) {
    return;
  }
  
  // Eagerly evaluate.
  Addend.$set$addassign(Layout.getSymbolOffset(A.$deref().getSymbol())
     - Layout.getSymbolOffset(B.$deref().getSymbol()));
  if ((Addrs != null) && ($AddrOf(SecA) != $AddrOf(SecB))) {
    Addend.$set$addassign((Addrs.lookup($AddrOf(SecA)) - Addrs.lookup($AddrOf(SecB))));
  }
  
  // Pointers to Thumb symbols need to have their low-bit set to allow
  // for interworking.
  if (Asm.isThumbFunc($AddrOf(SA))) {
    Addend.$set$orassign(1);
  }
  
  // Clear the symbol expr pointers to indicate we have folded these
  // operands.
  A.$set(B.$set(null));
}


/// \brief Evaluate the result of an add between (conceptually) two MCValues.
///
/// This routine conceptually attempts to construct an MCValue:
///   Result = (Result_A - Result_B + Result_Cst)
/// from two MCValue's LHS and RHS where
///   Result = LHS + RHS
/// and
///   Result = (LHS_A - LHS_B + LHS_Cst) + (RHS_A - RHS_B + RHS_Cst).
///
/// This routine attempts to aggresively fold the operands such that the result
/// is representable in an MCValue, but may not always succeed.
///
/// \returns True on success, false if the result is not representable in an
/// MCValue.

/// NOTE: It is really important to have both the Asm and Layout arguments.
/// They might look redundant, but this function can be used before layout
/// is done (see the object streamer for example) and having the Asm argument
/// lets us avoid relaxations early.
//<editor-fold defaultstate="collapsed" desc="EvaluateSymbolicAdd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 523,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 548,
 FQN="EvaluateSymbolicAdd", NM="_ZL19EvaluateSymbolicAddPKN4llvm11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_yEEEEbRKNS_7MCValueEPKNS_15MCSymbolRefExprESN_xRSI_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZL19EvaluateSymbolicAddPKN4llvm11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_yEEEEbRKNS_7MCValueEPKNS_15MCSymbolRefExprESN_xRSI_")
//</editor-fold>
public static boolean EvaluateSymbolicAdd(/*const*/ MCAssembler /*P*/ Asm, /*const*/ MCAsmLayout /*P*/ Layout, 
                   /*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/ Addrs, boolean InSet, final /*const*/ MCValue /*&*/ LHS, 
                   /*const*/ type$ref<MCSymbolRefExpr /*P*/> RHS_A, /*const*/ type$ref<MCSymbolRefExpr /*P*/> RHS_B, 
                   long/*int64_t*/ RHS_Cst, final MCValue /*&*/ Res) {
  // FIXME: This routine (and other evaluation parts) are *incredibly* sloppy
  // about dealing with modifiers. This will ultimately bite us, one day.
  type$ref</*const*/ MCSymbolRefExpr /*P*/ > LHS_A = create_type$ref(LHS.getSymA());
  type$ref</*const*/ MCSymbolRefExpr /*P*/ > LHS_B = create_type$ref(LHS.getSymB());
  long/*int64_t*/ LHS_Cst = LHS.getConstant();
  
  // Fold the result constant immediately.
  long$ref Result_Cst = create_long$ref(LHS_Cst + RHS_Cst);
  assert ((!(Layout != null) || (Asm != null))) : "Must have an assembler object if layout is given!";
  
  // If we have a layout, we can fold resolved differences.
  if ((Asm != null)) {
    // First, fold out any differences which are fully resolved. By
    // reassociating terms in
    //   Result = (LHS_A - LHS_B + LHS_Cst) + (RHS_A - RHS_B + RHS_Cst).
    // we have the four possible differences:
    //   (LHS_A - LHS_B),
    //   (LHS_A - RHS_B),
    //   (RHS_A - LHS_B),
    //   (RHS_A - RHS_B).
    // Since we are attempting to be as aggressive as possible about folding, we
    // attempt to evaluate each possible alternative.
    AttemptToFoldSymbolOffsetDifference(Asm, Layout, Addrs, InSet, LHS_A, LHS_B, 
        Result_Cst);
    AttemptToFoldSymbolOffsetDifference(Asm, Layout, Addrs, InSet, LHS_A, RHS_B, 
        Result_Cst);
    AttemptToFoldSymbolOffsetDifference(Asm, Layout, Addrs, InSet, RHS_A, LHS_B, 
        Result_Cst);
    AttemptToFoldSymbolOffsetDifference(Asm, Layout, Addrs, InSet, RHS_A, RHS_B, 
        Result_Cst);
  }
  
  // We can't represent the addition or subtraction of two symbols.
  if (((LHS_A.$deref() != null) && (RHS_A.$deref() != null)) || ((LHS_B.$deref() != null) && (RHS_B.$deref() != null))) {
    return false;
  }
  
  // At this point, we have at most one additive symbol and one subtractive
  // symbol -- find them.
  /*const*/ MCSymbolRefExpr /*P*/ A = (LHS_A.$deref() != null) ? LHS_A.$deref() : RHS_A.$deref();
  /*const*/ MCSymbolRefExpr /*P*/ B = (LHS_B.$deref() != null) ? LHS_B.$deref() : RHS_B.$deref();
  
  Res.$assignMove(MCValue.get(A, B, Result_Cst.$deref()));
  return true;
}

//<editor-fold defaultstate="collapsed" desc="canExpand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 589,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 614,
 FQN="canExpand", NM="_ZL9canExpandRKN4llvm8MCSymbolEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZL9canExpandRKN4llvm8MCSymbolEb")
//</editor-fold>
public static boolean canExpand(final /*const*/ MCSymbol /*&*/ Sym, boolean InSet) {
  /*const*/ MCExpr /*P*/ Expr = Sym.getVariableValue();
  /*const*/ MCSymbolRefExpr /*P*/ Inner = dyn_cast_MCSymbolRefExpr(Expr);
  if ((Inner != null)) {
    if (Inner.getKind() == MCSymbolRefExpr.VariantKind.VK_WEAKREF) {
      return false;
    }
  }
  if (InSet) {
    return true;
  }
  return !Sym.isInSection();
}

} // END OF class MCExprStatics

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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCExpr$C;


/// \brief This represents an "assembler immediate".
///
///  In its most general form, this can hold ":Kind:(SymbolA - SymbolB +
///  imm64)".  Not all targets supports relocations of this general form, but we
///  need to represent this anyway.
///
/// In general both SymbolA and SymbolB will also have a modifier
/// analogous to the top-level Kind. Current targets are not expected
/// to make use of both though. The choice comes down to whether
/// relocation modifiers apply to the closest symbol or the whole
/// expression.
///
/// Note that this class must remain a simple POD value class, because we need
/// it to live in unions etc.
//<editor-fold defaultstate="collapsed" desc="llvm::MCValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 40,
 FQN="llvm::MCValue", NM="_ZN4llvm7MCValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCValueE")
//</editor-fold>
public class MCValue {
  private /*const*/ MCSymbolRefExpr /*P*/ SymA;
  private /*const*/ MCSymbolRefExpr /*P*/ SymB;
  private long/*int64_t*/ Cst;
  private /*uint32_t*/int RefKind;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::getConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 46,
   FQN="llvm::MCValue::getConstant", NM="_ZNK4llvm7MCValue11getConstantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCValue11getConstantEv")
  //</editor-fold>
  public long/*int64_t*/ getConstant() /*const*/ {
    return Cst;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::getSymA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 47,
   FQN="llvm::MCValue::getSymA", NM="_ZNK4llvm7MCValue7getSymAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCValue7getSymAEv")
  //</editor-fold>
  public /*const*/ MCSymbolRefExpr /*P*/ getSymA() /*const*/ {
    return SymA;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::getSymB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 48,
   FQN="llvm::MCValue::getSymB", NM="_ZNK4llvm7MCValue7getSymBEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCValue7getSymBEv")
  //</editor-fold>
  public /*const*/ MCSymbolRefExpr /*P*/ getSymB() /*const*/ {
    return SymB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::getRefKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 49,
   FQN="llvm::MCValue::getRefKind", NM="_ZNK4llvm7MCValue10getRefKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCValue10getRefKindEv")
  //</editor-fold>
  public /*uint32_t*/int getRefKind() /*const*/ {
    return RefKind;
  }

  
  /// \brief Is this an absolute (as opposed to relocatable) value.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::isAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 52,
   FQN="llvm::MCValue::isAbsolute", NM="_ZNK4llvm7MCValue10isAbsoluteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCValue10isAbsoluteEv")
  //</editor-fold>
  public boolean isAbsolute() /*const*/ {
    return !(SymA != null) && !(SymB != null);
  }

  
  /// \brief Print the value to the stream \p OS.
  
  /// \brief Print the value to the stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCValue.cpp", line = 18,
   FQN="llvm::MCValue::print", NM="_ZNK4llvm7MCValue5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCValue.cpp -nm=_ZNK4llvm7MCValue5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    if (isAbsolute()) {
      OS.$out_llong(getConstant());
      return;
    }
    
    // FIXME: prints as a number, which isn't ideal. But the meaning will be
    // target-specific anyway.
    if ((getRefKind() != 0)) {
      OS.$out_char($$COLON).$out_uint(getRefKind()).$out_char($$COLON);
    }
    
    $out_raw_ostream_MCExpr$C(OS, $Deref(getSymA()));
    if ((getSymB() != null)) {
      OS.$out(/*KEEP_STR*/" - ");
      $out_raw_ostream_MCExpr$C(OS, $Deref(getSymB()));
    }
    if ((getConstant() != 0)) {
      OS.$out(/*KEEP_STR*/" + ").$out_llong(getConstant());
    }
  }


  
  /// \brief Print the value to stderr.
  
  /// \brief Print the value to stderr.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCValue.cpp", line = 41,
   FQN="llvm::MCValue::dump", NM="_ZNK4llvm7MCValue4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCValue.cpp -nm=_ZNK4llvm7MCValue4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::getAccessVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCValue.cpp", line = 46,
   FQN="llvm::MCValue::getAccessVariant", NM="_ZNK4llvm7MCValue16getAccessVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCValue.cpp -nm=_ZNK4llvm7MCValue16getAccessVariantEv")
  //</editor-fold>
  public MCSymbolRefExpr.VariantKind getAccessVariant() /*const*/ {
    /*const*/ MCSymbolRefExpr /*P*/ B = getSymB();
    if ((B != null)) {
      if (B.getKind() != MCSymbolRefExpr.VariantKind.VK_None) {
        throw new llvm_unreachable("unsupported");
      }
    }
    
    /*const*/ MCSymbolRefExpr /*P*/ A = getSymA();
    if (!(A != null)) {
      return MCSymbolRefExpr.VariantKind.VK_None;
    }
    
    MCSymbolRefExpr.VariantKind Kind = (MCSymbolRefExpr.VariantKind) A.getKind();
    if (Kind == MCSymbolRefExpr.VariantKind.VK_WEAKREF) {
      return MCSymbolRefExpr.VariantKind.VK_None;
    }
    return Kind;
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 62,
   FQN="llvm::MCValue::get", NM="_ZN4llvm7MCValue3getEPKNS_15MCSymbolRefExprES3_xj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCValue3getEPKNS_15MCSymbolRefExprES3_xj")
  //</editor-fold>
  public static MCValue get(/*const*/ MCSymbolRefExpr /*P*/ SymA) {
    return get(SymA, 
     (/*const*/ MCSymbolRefExpr /*P*/ )null, 
     0, 0);
  }
  public static MCValue get(/*const*/ MCSymbolRefExpr /*P*/ SymA, 
     /*const*/ MCSymbolRefExpr /*P*/ SymB/*= null*/) {
    return get(SymA, 
     SymB, 
     0, 0);
  }
  public static MCValue get(/*const*/ MCSymbolRefExpr /*P*/ SymA, 
     /*const*/ MCSymbolRefExpr /*P*/ SymB/*= null*/, 
     long/*int64_t*/ Val/*= 0*/) {
    return get(SymA, 
     SymB, 
     Val, 0);
  }
  public static MCValue get(/*const*/ MCSymbolRefExpr /*P*/ SymA, 
     /*const*/ MCSymbolRefExpr /*P*/ SymB/*= null*/, 
     long/*int64_t*/ Val/*= 0*/, /*uint32_t*/int RefKind/*= 0*/) {
    MCValue R/*J*/= new MCValue();
    R.Cst = Val;
    R.SymA = SymA;
    R.SymB = SymB;
    R.RefKind = RefKind;
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 73,
   FQN="llvm::MCValue::get", NM="_ZN4llvm7MCValue3getEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCValue3getEx")
  //</editor-fold>
  public static MCValue get(long/*int64_t*/ Val) {
    MCValue R/*J*/= new MCValue();
    R.Cst = Val;
    R.SymA = null;
    R.SymB = null;
    R.RefKind = 0;
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::MCValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 40,
   FQN="llvm::MCValue::MCValue", NM="_ZN4llvm7MCValueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCValueC1Ev")
  //</editor-fold>
  public /*inline*/ MCValue() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::MCValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 40,
   FQN="llvm::MCValue::MCValue", NM="_ZN4llvm7MCValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCValueC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCValue(final /*const*/ MCValue /*&*/ $Prm0) {
    // : SymA(.SymA), SymB(.SymB), Cst(.Cst), RefKind(.RefKind) 
    //START JInit
    this.SymA = $Prm0.SymA;
    this.SymB = $Prm0.SymB;
    this.Cst = $Prm0.Cst;
    this.RefKind = $Prm0.RefKind;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::MCValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 40,
   FQN="llvm::MCValue::MCValue", NM="_ZN4llvm7MCValueC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCValueC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCValue(JD$Move _dparam, final MCValue /*&&*/$Prm0) {
    // : SymA(static_cast<MCValue &&>().SymA), SymB(static_cast<MCValue &&>().SymB), Cst(static_cast<MCValue &&>().Cst), RefKind(static_cast<MCValue &&>().RefKind) 
    //START JInit
    this.SymA = $Prm0.SymA;
    this.SymB = $Prm0.SymB;
    this.Cst = $Prm0.Cst;
    this.RefKind = $Prm0.RefKind;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 40,
   FQN="llvm::MCValue::operator=", NM="_ZN4llvm7MCValueaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm7MCValueaSERKS0_")
  //</editor-fold>
  public /*inline*/ MCValue /*&*/ $assign(final /*const*/ MCValue /*&*/ $Prm0) {
    this.SymA = $Prm0.SymA;
    this.SymB = $Prm0.SymB;
    this.Cst = $Prm0.Cst;
    this.RefKind = $Prm0.RefKind;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCValue::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCValue.h", line = 40,
   FQN="llvm::MCValue::operator=", NM="_ZN4llvm7MCValueaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm7MCValueaSEOS0_")
  //</editor-fold>
  public /*inline*/ MCValue /*&*/ $assignMove(final MCValue /*&&*/$Prm0) {
    this.SymA = $Prm0.SymA;
    this.SymB = $Prm0.SymB;
    this.Cst = $Prm0.Cst;
    this.RefKind = $Prm0.RefKind;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "SymA=" + "[MCSymbolRefExpr]" // NOI18N
              + ", SymB=" + "[MCSymbolRefExpr]" // NOI18N
              + ", Cst=" + Cst // NOI18N
              + ", RefKind=" + RefKind; // NOI18N
  }
}

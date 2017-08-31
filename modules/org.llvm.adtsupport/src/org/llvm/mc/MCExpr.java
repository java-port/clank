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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import static org.llvm.adt.java.ADTRTTI.*;
import org.llvm.mc.impl.MCExprStatics;
import org.llvm.mc.stats.impl.StatsStatics;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCExpr$C;


/// \brief Base class for the full range of assembler expressions which are
/// needed for parsing.
//<editor-fold defaultstate="collapsed" desc="llvm::MCExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 34,
 FQN="llvm::MCExpr", NM="_ZN4llvm6MCExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm6MCExprE")
//</editor-fold>
public class MCExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::ExprKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 36,
   FQN="llvm::MCExpr::ExprKind", NM="_ZN4llvm6MCExpr8ExprKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm6MCExpr8ExprKindE")
  //</editor-fold>
  public enum ExprKind implements Native.NativeUShortEnum {
    Binary(0), ///< Binary expressions.
    Constant(Binary.getValue() + 1), ///< Constant expressions.
    SymbolRef(Constant.getValue() + 1), ///< References to labels and assigned expressions.
    Unary(SymbolRef.getValue() + 1), ///< Unary expressions.
    Target(Unary.getValue() + 1); ///< Target specific expression.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ExprKind valueOf(int val) {
      ExprKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ExprKind[] VALUES;
      private static final ExprKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ExprKind kind : ExprKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ExprKind[min < 0 ? (1-min) : 0];
        VALUES = new ExprKind[max >= 0 ? (1+max) : 0];
        for (ExprKind kind : ExprKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint16_t*/char value;
    private ExprKind(int val) { this.value = (/*uint16_t*/char)val;}
    @Override public final /*uint16_t*/char getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private ExprKind Kind;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::MCExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 47,
   FQN="llvm::MCExpr::MCExpr", NM="_ZN4llvm6MCExprC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm6MCExprC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCExpr(final /*const*/ MCExpr /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 48,
   FQN="llvm::MCExpr::operator=", NM="_ZN4llvm6MCExpraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm6MCExpraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCExpr /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 418,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 443,
   FQN="llvm::MCExpr::evaluateAsAbsolute", NM="_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxPKNS_11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoISB_EENS_6detail12DenseMapPairISB_yEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxPKNS_11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoISB_EENS_6detail12DenseMapPairISB_yEEEE")
  //</editor-fold>
  private boolean evaluateAsAbsolute(final long$ref/*int64_t &*/ Res, /*const*/ MCAssembler /*P*/ Asm, 
                    /*const*/ MCAsmLayout /*P*/ Layout, 
                    /*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/ Addrs) /*const*/ {
    // FIXME: The use if InSet = Addrs is a hack. Setting InSet causes us
    // absolutize differences across sections and that is what the MachO writer
    // uses Addrs for.
    return evaluateAsAbsolute(Res, Asm, Layout, Addrs, (Addrs != null));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 427,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 452,
   FQN="llvm::MCExpr::evaluateAsAbsolute", NM="_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxPKNS_11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoISB_EENS_6detail12DenseMapPairISB_yEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxPKNS_11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoISB_EENS_6detail12DenseMapPairISB_yEEEEb")
  //</editor-fold>
  private boolean evaluateAsAbsolute(final long$ref/*int64_t &*/ Res, /*const*/ MCAssembler /*P*/ Asm, 
                    /*const*/ MCAsmLayout /*P*/ Layout, 
                    /*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/ Addrs, boolean InSet) /*const*/ {
    MCValue Value/*J*/= new MCValue();
    {
      
      // Fast path constants.
      /*const*/ MCConstantExpr /*P*/ CE = dyn_cast_MCConstantExpr(this);
      if ((CE != null)) {
        Res.$set(CE.getValue());
        return true;
      }
    }
    
    boolean IsRelocatable = evaluateAsRelocatableImpl(Value, Asm, Layout, (/*const*/ MCFixup /*P*/ )null, Addrs, InSet);
    
    // Record the current value.
    Res.$set(Value.getConstant());
    
    return IsRelocatable && Value.isAbsolute();
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::MCExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 59,
   FQN="llvm::MCExpr::MCExpr", NM="_ZN4llvm6MCExprC1ENS0_8ExprKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm6MCExprC1ENS0_8ExprKindE")
  //</editor-fold>
  protected /*explicit*/ MCExpr(ExprKind Kind) {
    // : Kind(Kind) 
    //START JInit
    this.Kind = Kind;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsRelocatableImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 602,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 627,
   FQN="llvm::MCExpr::evaluateAsRelocatableImpl", NM="_ZNK4llvm6MCExpr25evaluateAsRelocatableImplERNS_7MCValueEPKNS_11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_7MCFixupEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoISF_EENS_6detail12DenseMapPairISF_yEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr25evaluateAsRelocatableImplERNS_7MCValueEPKNS_11MCAssemblerEPKNS_11MCAsmLayoutEPKNS_7MCFixupEPKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoISF_EENS_6detail12DenseMapPairISF_yEEEEb")
  //</editor-fold>
  protected boolean evaluateAsRelocatableImpl(final MCValue /*&*/ Res, /*const*/ MCAssembler /*P*/ Asm, 
                           /*const*/ MCAsmLayout /*P*/ Layout, 
                           /*const*/ MCFixup /*P*/ Fixup, 
                           /*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/ Addrs, 
                           boolean InSet) /*const*/ {
    StatsStatics.MCExprEvaluate.$preInc();
    switch ((ExprKind)getKind()) {
     case Target:
      return cast_MCTargetExpr(this).evaluateAsRelocatableImpl(Res, Layout, 
          Fixup);
     case Constant:
      Res.$assignMove(MCValue.get(cast_MCConstantExpr(this).getValue()));
      return true;
     case SymbolRef:
      {
        /*const*/ MCSymbolRefExpr /*P*/ SRE = cast_MCSymbolRefExpr(this);
        final /*const*/ MCSymbol /*&*/ Sym = SRE.getSymbol();
        
        // Evaluate recursively if this is a variable.
        if (Sym.isVariable() && SRE.getKind() == MCSymbolRefExpr.VariantKind.VK_None
           && MCExprStatics.canExpand(Sym, InSet)) {
          boolean IsMachO = SRE.hasSubsectionsViaSymbols();
          if (Sym.getVariableValue().evaluateAsRelocatableImpl(Res, Asm, Layout, Fixup, Addrs, InSet || IsMachO)) {
            if (!IsMachO) {
              return true;
            }
            
            /*const*/ MCSymbolRefExpr /*P*/ A = Res.getSymA();
            /*const*/ MCSymbolRefExpr /*P*/ B = Res.getSymB();
            // FIXME: This is small hack. Given
            // a = b + 4
            // .long a
            // the OS X assembler will completely drop the 4. We should probably
            // include it in the relocation or produce an error if that is not
            // possible.
            if (!(A != null) && !(B != null)) {
              return true;
            }
          }
        }
        
        Res.$assignMove(MCValue.get(SRE, (/*const*/ MCSymbolRefExpr /*P*/ )null, 0));
        return true;
      }
     case Unary:
      {
        /*const*/ MCUnaryExpr /*P*/ AUE = cast_MCUnaryExpr(this);
        MCValue Value/*J*/= new MCValue();
        if (!AUE.getSubExpr().evaluateAsRelocatableImpl(Value, Asm, Layout, Fixup, 
            Addrs, InSet)) {
          return false;
        }
        switch (AUE.getOpcode()) {
         case LNot:
          if (!Value.isAbsolute()) {
            return false;
          }
          Res.$assignMove(MCValue.get(((!(Value.getConstant() != 0)) ? 1 : 0)));
          break;
         case Minus:
          /// -(a - b + const) ==> (b - a - const)
          if ((Value.getSymA() != null) && !(Value.getSymB() != null)) {
            return false;
          }
          
          // The cast avoids undefined behavior if the constant is INT64_MIN.
          Res.$assignMove(MCValue.get(Value.getSymB(), Value.getSymA(), 
                  -(long/*uint64_t*/)Value.getConstant()));
          break;
         case Not:
          if (!Value.isAbsolute()) {
            return false;
          }
          Res.$assignMove(MCValue.get(~Value.getConstant()));
          break;
         case Plus:
          Res.$assign(Value);
          break;
        }
        
        return true;
      }
     case Binary:
      {
        /*const*/ MCBinaryExpr /*P*/ ABE = cast_MCBinaryExpr(this);
        MCValue LHSValue/*J*/= new MCValue();
        MCValue RHSValue/*J*/= new MCValue();
        if (!ABE.getLHS().evaluateAsRelocatableImpl(LHSValue, Asm, Layout, Fixup, 
            Addrs, InSet)
           || !ABE.getRHS().evaluateAsRelocatableImpl(RHSValue, Asm, Layout, Fixup, 
            Addrs, InSet)) {
          return false;
        }
        
        // We only support a few operations on non-constant expressions, handle
        // those first.
        if (!LHSValue.isAbsolute() || !RHSValue.isAbsolute()) {
          switch (ABE.getOpcode()) {
           default:
            return false;
           case Sub:
            // Negate RHS and add.
            // The cast avoids undefined behavior if the constant is INT64_MIN.
            return MCExprStatics.EvaluateSymbolicAdd(Asm, Layout, Addrs, InSet, LHSValue, 
                create_type$ref(RHSValue.getSymB()), create_type$ref(RHSValue.getSymA()), 
                -(long/*uint64_t*/)RHSValue.getConstant(), Res);
           case Add:
            return MCExprStatics.EvaluateSymbolicAdd(Asm, Layout, Addrs, InSet, LHSValue, 
                create_type$ref(RHSValue.getSymA()), create_type$ref(RHSValue.getSymB()), 
                RHSValue.getConstant(), Res);
          }
        }
        
        // FIXME: We need target hooks for the evaluation. It may be limited in
        // width, and gas defines the result of comparisons differently from
        // Apple as.
        long/*int64_t*/ LHS = LHSValue.getConstant();
        long/*int64_t*/ RHS = RHSValue.getConstant();
        long/*int64_t*/ Result = 0;
        switch (ABE.getOpcode()) {
         case AShr:
          Result = LHS >> RHS;
          break;
         case Add:
          Result = LHS + RHS;
          break;
         case And:
          Result = LHS & RHS;
          break;
         case Div:
          // Handle division by zero. gas just emits a warning and keeps going,
          // we try to be stricter.
          // FIXME: Currently the caller of this function has no way to understand
          // we're bailing out because of 'division by zero'. Therefore, it will
          // emit a 'expected relocatable expression' error. It would be nice to
          // change this code to emit a better diagnostic.
          if (RHS == 0) {
            return false;
          }
          Result = LHS / RHS;
          break;
         case EQ:
          Result = ((LHS == RHS) ? 1 : 0);
          break;
         case GT:
          Result = ((LHS > RHS) ? 1 : 0);
          break;
         case GTE:
          Result = ((LHS >= RHS) ? 1 : 0);
          break;
         case LAnd:
          Result = (((LHS != 0) && (RHS != 0)) ? 1 : 0);
          break;
         case LOr:
          Result = (((LHS != 0) || (RHS != 0)) ? 1 : 0);
          break;
         case LShr:
          Result = ((long/*uint64_t*/)(LHS)) >>> ((long/*uint64_t*/)(RHS));
          break;
         case LT:
          Result = ((LHS < RHS) ? 1 : 0);
          break;
         case LTE:
          Result = ((LHS <= RHS) ? 1 : 0);
          break;
         case Mod:
          Result = LHS % RHS;
          break;
         case Mul:
          Result = LHS * RHS;
          break;
         case NE:
          Result = ((LHS != RHS) ? 1 : 0);
          break;
         case Or:
          Result = LHS | RHS;
          break;
         case Shl:
          Result = ((long/*uint64_t*/)(LHS)) << ((long/*uint64_t*/)(RHS));
          break;
         case Sub:
          Result = LHS - RHS;
          break;
         case Xor:
          Result = LHS ^ RHS;
          break;
        }
        
        Res.$assignMove(MCValue.get(Result));
        return true;
      }
    }
    throw new llvm_unreachable("Invalid assembly expression kind!");
  }

/*public:*/
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 70,
   FQN="llvm::MCExpr::getKind", NM="_ZNK4llvm6MCExpr7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr7getKindEv")
  //</editor-fold>
  public Native.NativeUShortEnum getKind() /*const*/ {
    return Kind;
  }

  
  /// @}
  /// \name Utility Methods
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 33,
   FQN="llvm::MCExpr::print", NM="_ZNK4llvm6MCExpr5printERNS_11raw_ostreamEPKNS_9MCAsmInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr5printERNS_11raw_ostreamEPKNS_9MCAsmInfoEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, /*const*/ MCAsmInfo /*P*/ MAI) /*const*/ {
    print(OS, MAI, false);
  }
  public void print(final raw_ostream /*&*/ OS, /*const*/ MCAsmInfo /*P*/ MAI, boolean InParens/*= false*/) /*const*/ {
    switch ((ExprKind)getKind()) {
     case Target:
      cast_MCTargetExpr(this).printImpl(OS, MAI);
      /*JAVA:return*/return;
     case Constant:
      OS.$out_llong(cast_MCConstantExpr(/*Deref*/this).getValue());
      return;
     case SymbolRef:
      {
        final /*const*/ MCSymbolRefExpr /*&*/ SRE = cast_MCSymbolRefExpr(/*Deref*/this);
        final /*const*/ MCSymbol /*&*/ Sym = SRE.getSymbol();
        // Parenthesize names that start with $ so that they don't look like
        // absolute names.
        boolean UseParens = !InParens && (Sym.getName().size() != 0) && Sym.getName().$at(0) == $$DOLLAR;
        if (UseParens) {
          OS.$out_char($$LPAREN);
          Sym.print(OS, MAI);
          OS.$out_char($$RPAREN);
        } else {
          Sym.print(OS, MAI);
        }
        if (SRE.getKind() != MCSymbolRefExpr.VariantKind.VK_None) {
          SRE.printVariantKind(OS);
        }
        
        return;
      }
     case Unary:
      {
        final /*const*/ MCUnaryExpr /*&*/ UE = cast_MCUnaryExpr(/*Deref*/this);
        switch (UE.getOpcode()) {
         case LNot:
          OS.$out_char($$EXCLAMATION);
          break;
         case Minus:
          OS.$out_char($$MINUS);
          break;
         case Not:
          OS.$out_char($$TILDE);
          break;
         case Plus:
          OS.$out_char($$PLUS);
          break;
        }
        UE.getSubExpr().print(OS, MAI);
        return;
      }
     case Binary:
      {
        final /*const*/ MCBinaryExpr /*&*/ BE = cast_MCBinaryExpr(/*Deref*/this);
        
        // Only print parens around the LHS if it is non-trivial.
        if (isa_MCConstantExpr(BE.getLHS()) || isa_MCSymbolRefExpr(BE.getLHS())) {
          BE.getLHS().print(OS, MAI);
        } else {
          OS.$out_char($$LPAREN);
          BE.getLHS().print(OS, MAI);
          OS.$out_char($$RPAREN);
        }
        switch (BE.getOpcode()) {
         case Add:
          {
            // Print "X-42" instead of "X+-42".
            /*const*/ MCConstantExpr /*P*/ RHSC = dyn_cast_MCConstantExpr(BE.getRHS());
            if ((RHSC != null)) {
              if (RHSC.getValue() < 0) {
                OS.$out_llong(RHSC.getValue());
                return;
              }
            }
          }
          
          OS.$out_char($$PLUS);
          break;
         case AShr:
          OS.$out(/*KEEP_STR*/$GT_GT);
          break;
         case And:
          OS.$out_char($$AMP);
          break;
         case Div:
          OS.$out_char($$SLASH);
          break;
         case EQ:
          OS.$out(/*KEEP_STR*/$EQ_EQ);
          break;
         case GT:
          OS.$out_char($$GT);
          break;
         case GTE:
          OS.$out(/*KEEP_STR*/$GT_EQ);
          break;
         case LAnd:
          OS.$out(/*KEEP_STR*/$AMP_AMP);
          break;
         case LOr:
          OS.$out(/*KEEP_STR*/$PIPE_PIPE);
          break;
         case LShr:
          OS.$out(/*KEEP_STR*/$GT_GT);
          break;
         case LT:
          OS.$out_char($$LT);
          break;
         case LTE:
          OS.$out(/*KEEP_STR*/$LT_EQ);
          break;
         case Mod:
          OS.$out_char($$PERCENT);
          break;
         case Mul:
          OS.$out_char($$STAR);
          break;
         case NE:
          OS.$out(/*KEEP_STR*/$EXCLAIM_EQ);
          break;
         case Or:
          OS.$out_char($$PIPE);
          break;
         case Shl:
          OS.$out(/*KEEP_STR*/$LT_LT);
          break;
         case Sub:
          OS.$out_char($$MINUS);
          break;
         case Xor:
          OS.$out_char($$CARET);
          break;
        }
        
        // Only print parens around the LHS if it is non-trivial.
        if (isa_MCConstantExpr(BE.getRHS()) || isa_MCSymbolRefExpr(BE.getRHS())) {
          BE.getRHS().print(OS, MAI);
        } else {
          OS.$out_char($$LPAREN);
          BE.getRHS().print(OS, MAI);
          OS.$out_char($$RPAREN);
        }
        return;
      }
    }
    throw new llvm_unreachable("Invalid expression kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 133,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 132,
   FQN="llvm::MCExpr::dump", NM="_ZNK4llvm6MCExpr4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    $out_raw_ostream_MCExpr$C(dbgs(), /*Deref*/this);
    dbgs().$out_char($$LF);
  }

  
  /// @}
  /// \name Expression Evaluation
  /// @{
  
  /// \brief Try to evaluate the expression to an absolute value.
  ///
  /// \param Res - The absolute value, if evaluation succeeds.
  /// \param Layout - The assembler layout object to use for evaluating symbol
  /// values. If not given, then only non-symbolic expressions will be
  /// evaluated.
  /// \return - True on success.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 402,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 427,
   FQN="llvm::MCExpr::evaluateAsAbsolute", NM="_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxRKNS_11MCAsmLayoutERKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_yEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxRKNS_11MCAsmLayoutERKNS_8DenseMapIPKNS_9MCSectionEyNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_yEEEE")
  //</editor-fold>
  public boolean evaluateAsAbsolute(final long$ref/*int64_t &*/ Res, 
                    final /*const*/ MCAsmLayout /*&*/ Layout, 
                    final /*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*&*/ Addrs) /*const*/ {
    return evaluateAsAbsolute(Res, $AddrOf(Layout.getAssembler()), $AddrOf(Layout), $AddrOf(Addrs));
  }

  
  /* *** */
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 393,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 418,
   FQN="llvm::MCExpr::evaluateAsAbsolute", NM="_ZNK4llvm6MCExpr18evaluateAsAbsoluteERx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr18evaluateAsAbsoluteERx")
  //</editor-fold>
  public boolean evaluateAsAbsolute(final long$ref/*int64_t &*/ Res) /*const*/ {
    return evaluateAsAbsolute(Res, (/*const*/ MCAssembler /*P*/ )null, (/*const*/ MCAsmLayout /*P*/ )null, (/*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/)null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 408,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 433,
   FQN="llvm::MCExpr::evaluateAsAbsolute", NM="_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxRKNS_11MCAssemblerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxRKNS_11MCAssemblerE")
  //</editor-fold>
  public boolean evaluateAsAbsolute(final long$ref/*int64_t &*/ Res, final /*const*/ MCAssembler /*&*/ Asm) /*const*/ {
    return evaluateAsAbsolute(Res, $AddrOf(Asm), (/*const*/ MCAsmLayout /*P*/ )null, (/*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/)null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 397,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 422,
   FQN="llvm::MCExpr::evaluateAsAbsolute", NM="_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxRKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr18evaluateAsAbsoluteERxRKNS_11MCAsmLayoutE")
  //</editor-fold>
  public boolean evaluateAsAbsolute(final long$ref/*int64_t &*/ Res, 
                    final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    return evaluateAsAbsolute(Res, $AddrOf(Layout.getAssembler()), $AddrOf(Layout), (/*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/)null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateKnownAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 412,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 437,
   FQN="llvm::MCExpr::evaluateKnownAbsolute", NM="_ZNK4llvm6MCExpr21evaluateKnownAbsoluteERxRKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr21evaluateKnownAbsoluteERxRKNS_11MCAsmLayoutE")
  //</editor-fold>
  public boolean evaluateKnownAbsolute(final long$ref/*int64_t &*/ Res, 
                       final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    return evaluateAsAbsolute(Res, $AddrOf(Layout.getAssembler()), $AddrOf(Layout), (/*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/)null, 
        true);
  }

  
  /// \brief Try to evaluate the expression to a relocatable value, i.e. an
  /// expression of the fixed form (a - b + constant).
  ///
  /// \param Res - The relocatable value, if evaluation succeeds.
  /// \param Layout - The assembler layout object to use for evaluating values.
  /// \param Fixup - The Fixup object if available.
  /// \return - True on success.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsRelocatable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 575,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 600,
   FQN="llvm::MCExpr::evaluateAsRelocatable", NM="_ZNK4llvm6MCExpr21evaluateAsRelocatableERNS_7MCValueEPKNS_11MCAsmLayoutEPKNS_7MCFixupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr21evaluateAsRelocatableERNS_7MCValueEPKNS_11MCAsmLayoutEPKNS_7MCFixupE")
  //</editor-fold>
  public boolean evaluateAsRelocatable(final MCValue /*&*/ Res, 
                       /*const*/ MCAsmLayout /*P*/ Layout, 
                       /*const*/ MCFixup /*P*/ Fixup) /*const*/ {
    MCAssembler /*P*/ Assembler = (Layout != null) ? $AddrOf(Layout.getAssembler()) : null;
    return evaluateAsRelocatableImpl(Res, Assembler, Layout, Fixup, (/*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/)null, 
        false);
  }

  
  /// \brief Try to evaluate the expression to the form (a - b + constant) where
  /// neither a nor b are variables.
  ///
  /// This is a more aggressive variant of evaluateAsRelocatable. The intended
  /// use is for when relocations are not available, like the .size directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::evaluateAsValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 583,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 608,
   FQN="llvm::MCExpr::evaluateAsValue", NM="_ZNK4llvm6MCExpr15evaluateAsValueERNS_7MCValueERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr15evaluateAsValueERNS_7MCValueERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public boolean evaluateAsValue(final MCValue /*&*/ Res, final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    MCAssembler /*P*/ Assembler = $AddrOf(Layout.getAssembler());
    return evaluateAsRelocatableImpl(Res, Assembler, $AddrOf(Layout), (/*const*/ MCFixup /*P*/ )null, (/*const*/DenseMapTypeULong</*const*/ MCSection /*P*/ > /*P*/)null, 
        true);
  }

  
  /// \brief Find the "associated section" for this expression, which is
  /// currently defined as the absolute section for constants, or
  /// otherwise the section associated with the first defined symbol in the
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCExpr::findAssociatedFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 759,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 781,
   FQN="llvm::MCExpr::findAssociatedFragment", NM="_ZNK4llvm6MCExpr22findAssociatedFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm6MCExpr22findAssociatedFragmentEv")
  //</editor-fold>
  public MCFragment /*P*/ findAssociatedFragment() /*const*/ {
    switch ((ExprKind)getKind()) {
     case Target:
      // We never look through target specific expressions.
      return cast_MCTargetExpr(this).findAssociatedFragment();
     case Constant:
      return MCSymbol.AbsolutePseudoFragment;
     case SymbolRef:
      {
        /*const*/ MCSymbolRefExpr /*P*/ SRE = cast_MCSymbolRefExpr(this);
        final /*const*/ MCSymbol /*&*/ Sym = SRE.getSymbol();
        return Sym.getFragment();
      }
     case Unary:
      return cast_MCUnaryExpr(this).getSubExpr().findAssociatedFragment();
     case Binary:
      {
        /*const*/ MCBinaryExpr /*P*/ BE = cast_MCBinaryExpr(this);
        MCFragment /*P*/ LHS_F = BE.getLHS().findAssociatedFragment();
        MCFragment /*P*/ RHS_F = BE.getRHS().findAssociatedFragment();
        
        // If either is absolute, return the other.
        if (LHS_F == MCSymbol.AbsolutePseudoFragment) {
          return RHS_F;
        }
        if (RHS_F == MCSymbol.AbsolutePseudoFragment) {
          return LHS_F;
        }
        
        // Not always correct, but probably the best we can do without more context.
        if (BE.getOpcode() == MCBinaryExpr.Opcode.Sub) {
          return MCSymbol.AbsolutePseudoFragment;
        }
        
        // Otherwise, return the first non-null fragment.
        return (LHS_F != null) ? LHS_F : RHS_F;
      }
    }
    throw new llvm_unreachable("Invalid assembly expression kind!");
  }

  public/*protected*/ /*virtual*/ void $destroy() {
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind; // NOI18N
  }
/// @}
}

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
import static org.llvm.mc.MCContextGlobals.$new_uint_MCContext_uint;


/// \brief Binary assembler expressions.
//<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 383,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 410,
 FQN="llvm::MCBinaryExpr", NM="_ZN4llvm12MCBinaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExprE")
//</editor-fold>
public class MCBinaryExpr extends /*public*/ MCExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::Opcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 385,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 412,
   FQN="llvm::MCBinaryExpr::Opcode", NM="_ZN4llvm12MCBinaryExpr6OpcodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr6OpcodeE")
  //</editor-fold>
  public enum Opcode implements Native.NativeUIntEnum {
    Add(0), ///< Addition.
    And(Add.getValue() + 1), ///< Bitwise and.
    Div(And.getValue() + 1), ///< Signed division.
    EQ(Div.getValue() + 1), ///< Equality comparison.
    GT(EQ.getValue() + 1), ///< Signed greater than comparison (result is either 0 or some
    ///< target-specific non-zero value)
    GTE(GT.getValue() + 1), ///< Signed greater than or equal comparison (result is either 0 or
    ///< some target-specific non-zero value).
    LAnd(GTE.getValue() + 1), ///< Logical and.
    LOr(LAnd.getValue() + 1), ///< Logical or.
    LT(LOr.getValue() + 1), ///< Signed less than comparison (result is either 0 or
    ///< some target-specific non-zero value).
    LTE(LT.getValue() + 1), ///< Signed less than or equal comparison (result is either 0 or
    ///< some target-specific non-zero value).
    Mod(LTE.getValue() + 1), ///< Signed remainder.
    Mul(Mod.getValue() + 1), ///< Multiplication.
    NE(Mul.getValue() + 1), ///< Inequality comparison.
    Or(NE.getValue() + 1), ///< Bitwise or.
    Shl(Or.getValue() + 1), ///< Shift left.
    AShr(Shl.getValue() + 1), ///< Arithmetic shift right.
    LShr(AShr.getValue() + 1), ///< Logical shift right.
    Sub(LShr.getValue() + 1), ///< Subtraction.
    Xor(Sub.getValue() + 1); ///< Bitwise exclusive or.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Opcode valueOf(int val) {
      Opcode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Opcode[] VALUES;
      private static final Opcode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Opcode kind : Opcode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Opcode[min < 0 ? (1-min) : 0];
        VALUES = new Opcode[max >= 0 ? (1+max) : 0];
        for (Opcode kind : Opcode.values()) {
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

    private final /*uint*/int value;
    private Opcode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private Opcode Op;
  private /*const*/ MCExpr /*P*/ LHS;
  private /*const*/ MCExpr /*P*/ RHS;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::MCBinaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 415,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 442,
   FQN="llvm::MCBinaryExpr::MCBinaryExpr", NM="_ZN4llvm12MCBinaryExprC1ENS0_6OpcodeEPKNS_6MCExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExprC1ENS0_6OpcodeEPKNS_6MCExprES4_")
  //</editor-fold>
  private MCBinaryExpr(Opcode Op, /*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS) {
    // : MCExpr(MCExpr::Binary), Op(Op), LHS(LHS), RHS(RHS) 
    //START JInit
    super(MCExpr.ExprKind.Binary);
    this.Op = Op;
    this.LHS = LHS;
    this.RHS = RHS;
    //END JInit
  }

/*public:*/
  /// \name Construction
  /// @{
  
  /* *** */
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 141,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 140,
   FQN="llvm::MCBinaryExpr::create", NM="_ZN4llvm12MCBinaryExpr6createENS0_6OpcodeEPKNS_6MCExprES4_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr6createENS0_6OpcodeEPKNS_6MCExprES4_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ create(Opcode Opc, /*const*/ MCExpr /*P*/ LHS, 
        /*const*/ MCExpr /*P*/ RHS, final MCContext /*&*/ Ctx) {
    return /*NEW_EXPR [operator new] NM=_ZnwjRN4llvm9MCContextEj*/
    /*new (Ctx)*/ $new_uint_MCContext_uint(Ctx, (type$ptr<?> New$Mem)->{
        return new MCBinaryExpr(Opc, LHS, RHS);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 424,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 451,
   FQN="llvm::MCBinaryExpr::createAdd", NM="_ZN4llvm12MCBinaryExpr9createAddEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createAddEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createAdd(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Add, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 428,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 455,
   FQN="llvm::MCBinaryExpr::createAnd", NM="_ZN4llvm12MCBinaryExpr9createAndEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createAndEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createAnd(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.And, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 432,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 459,
   FQN="llvm::MCBinaryExpr::createDiv", NM="_ZN4llvm12MCBinaryExpr9createDivEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createDivEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createDiv(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Div, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 463,
   FQN="llvm::MCBinaryExpr::createEQ", NM="_ZN4llvm12MCBinaryExpr8createEQEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr8createEQEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createEQ(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
          final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.EQ, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 440,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 467,
   FQN="llvm::MCBinaryExpr::createGT", NM="_ZN4llvm12MCBinaryExpr8createGTEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr8createGTEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createGT(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
          final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.GT, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createGTE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 444,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 471,
   FQN="llvm::MCBinaryExpr::createGTE", NM="_ZN4llvm12MCBinaryExpr9createGTEEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createGTEEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createGTE(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.GTE, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createLAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 475,
   FQN="llvm::MCBinaryExpr::createLAnd", NM="_ZN4llvm12MCBinaryExpr10createLAndEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr10createLAndEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createLAnd(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
            final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.LAnd, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createLOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 479,
   FQN="llvm::MCBinaryExpr::createLOr", NM="_ZN4llvm12MCBinaryExpr9createLOrEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createLOrEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createLOr(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.LOr, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 456,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 483,
   FQN="llvm::MCBinaryExpr::createLT", NM="_ZN4llvm12MCBinaryExpr8createLTEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr8createLTEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createLT(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
          final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.LT, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createLTE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 460,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 487,
   FQN="llvm::MCBinaryExpr::createLTE", NM="_ZN4llvm12MCBinaryExpr9createLTEEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createLTEEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createLTE(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.LTE, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createMod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 491,
   FQN="llvm::MCBinaryExpr::createMod", NM="_ZN4llvm12MCBinaryExpr9createModEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createModEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createMod(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Mod, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 468,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 495,
   FQN="llvm::MCBinaryExpr::createMul", NM="_ZN4llvm12MCBinaryExpr9createMulEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createMulEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createMul(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Mul, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createNE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 472,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 499,
   FQN="llvm::MCBinaryExpr::createNE", NM="_ZN4llvm12MCBinaryExpr8createNEEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr8createNEEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createNE(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
          final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.NE, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 503,
   FQN="llvm::MCBinaryExpr::createOr", NM="_ZN4llvm12MCBinaryExpr8createOrEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr8createOrEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createOr(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
          final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Or, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 480,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 507,
   FQN="llvm::MCBinaryExpr::createShl", NM="_ZN4llvm12MCBinaryExpr9createShlEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createShlEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createShl(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Shl, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createAShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 484,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 511,
   FQN="llvm::MCBinaryExpr::createAShr", NM="_ZN4llvm12MCBinaryExpr10createAShrEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr10createAShrEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createAShr(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
            final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.AShr, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createLShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 488,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 515,
   FQN="llvm::MCBinaryExpr::createLShr", NM="_ZN4llvm12MCBinaryExpr10createLShrEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr10createLShrEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createLShr(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
            final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.LShr, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 492,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 519,
   FQN="llvm::MCBinaryExpr::createSub", NM="_ZN4llvm12MCBinaryExpr9createSubEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createSubEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createSub(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Sub, LHS, RHS, Ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::createXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 496,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 523,
   FQN="llvm::MCBinaryExpr::createXor", NM="_ZN4llvm12MCBinaryExpr9createXorEPKNS_6MCExprES3_RNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr9createXorEPKNS_6MCExprES3_RNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCBinaryExpr /*P*/ createXor(/*const*/ MCExpr /*P*/ LHS, /*const*/ MCExpr /*P*/ RHS, 
           final MCContext /*&*/ Ctx) {
    return MCBinaryExpr.create(Opcode.Xor, LHS, RHS, Ctx);
  }

  
  /// @}
  /// \name Accessors
  /// @{
  
  /// \brief Get the kind of this binary expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 506,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 533,
   FQN="llvm::MCBinaryExpr::getOpcode", NM="_ZNK4llvm12MCBinaryExpr9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCBinaryExpr9getOpcodeEv")
  //</editor-fold>
  public Opcode getOpcode() /*const*/ {
    return Op;
  }

  
  /// \brief Get the left-hand side expression of the binary operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::getLHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 509,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 536,
   FQN="llvm::MCBinaryExpr::getLHS", NM="_ZNK4llvm12MCBinaryExpr6getLHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCBinaryExpr6getLHSEv")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getLHS() /*const*/ {
    return LHS;
  }

  
  /// \brief Get the right-hand side expression of the binary operator.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::getRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 512,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 539,
   FQN="llvm::MCBinaryExpr::getRHS", NM="_ZNK4llvm12MCBinaryExpr6getRHSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCBinaryExpr6getRHSEv")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getRHS() /*const*/ {
    return RHS;
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCBinaryExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 516,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 543,
   FQN="llvm::MCBinaryExpr::classof", NM="_ZN4llvm12MCBinaryExpr7classofEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCBinaryExpr7classofEPKNS_6MCExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCExpr /*P*/ E) {
    return E.getKind() == MCExpr.ExprKind.Binary;
  }

  
  @Override public String toString() {
    return "" + "Op=" + Op // NOI18N
              + ", LHS=" + "[MCExpr]" // NOI18N
              + ", RHS=" + "[MCExpr]" // NOI18N
              + super.toString(); // NOI18N
  }
}

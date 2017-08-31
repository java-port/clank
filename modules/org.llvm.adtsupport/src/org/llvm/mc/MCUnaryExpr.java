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


/// \brief Unary assembler expressions.
//<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 330,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 357,
 FQN="llvm::MCUnaryExpr", NM="_ZN4llvm11MCUnaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExprE")
//</editor-fold>
public class MCUnaryExpr extends /*public*/ MCExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::Opcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 359,
   FQN="llvm::MCUnaryExpr::Opcode", NM="_ZN4llvm11MCUnaryExpr6OpcodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr6OpcodeE")
  //</editor-fold>
  public enum Opcode implements Native.NativeUIntEnum {
    LNot(0), ///< Logical negation.
    Minus(LNot.getValue() + 1), ///< Unary minus.
    Not(Minus.getValue() + 1), ///< Bitwise negation.
    Plus(Not.getValue() + 1); ///< Unary plus.

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
  private /*const*/ MCExpr /*P*/ Expr;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::MCUnaryExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 370,
   FQN="llvm::MCUnaryExpr::MCUnaryExpr", NM="_ZN4llvm11MCUnaryExprC1ENS0_6OpcodeEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExprC1ENS0_6OpcodeEPKNS_6MCExprE")
  //</editor-fold>
  private MCUnaryExpr(Opcode Op, /*const*/ MCExpr /*P*/ Expr) {
    // : MCExpr(MCExpr::Unary), Op(Op), Expr(Expr) 
    super(MCExpr.ExprKind.Unary);
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// \name Construction
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 146,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 145,
   FQN="llvm::MCUnaryExpr::create", NM="_ZN4llvm11MCUnaryExpr6createENS0_6OpcodeEPKNS_6MCExprERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr6createENS0_6OpcodeEPKNS_6MCExprERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCUnaryExpr /*P*/ create(Opcode Opc, /*const*/ MCExpr /*P*/ Expr, 
        final MCContext /*&*/ Ctx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::createLNot">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 352,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 379,
   FQN="llvm::MCUnaryExpr::createLNot", NM="_ZN4llvm11MCUnaryExpr10createLNotEPKNS_6MCExprERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr10createLNotEPKNS_6MCExprERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCUnaryExpr /*P*/ createLNot(/*const*/ MCExpr /*P*/ Expr, final MCContext /*&*/ Ctx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::createMinus">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 355,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 382,
   FQN="llvm::MCUnaryExpr::createMinus", NM="_ZN4llvm11MCUnaryExpr11createMinusEPKNS_6MCExprERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr11createMinusEPKNS_6MCExprERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCUnaryExpr /*P*/ createMinus(/*const*/ MCExpr /*P*/ Expr, final MCContext /*&*/ Ctx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::createNot">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 358,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 385,
   FQN="llvm::MCUnaryExpr::createNot", NM="_ZN4llvm11MCUnaryExpr9createNotEPKNS_6MCExprERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr9createNotEPKNS_6MCExprERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCUnaryExpr /*P*/ createNot(/*const*/ MCExpr /*P*/ Expr, final MCContext /*&*/ Ctx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::createPlus">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 361,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 388,
   FQN="llvm::MCUnaryExpr::createPlus", NM="_ZN4llvm11MCUnaryExpr10createPlusEPKNS_6MCExprERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr10createPlusEPKNS_6MCExprERNS_9MCContextE")
  //</editor-fold>
  public static /*const*/ MCUnaryExpr /*P*/ createPlus(/*const*/ MCExpr /*P*/ Expr, final MCContext /*&*/ Ctx) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @}
  /// \name Accessors
  /// @{
  
  /// \brief Get the kind of this unary expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::getOpcode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 370,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 397,
   FQN="llvm::MCUnaryExpr::getOpcode", NM="_ZNK4llvm11MCUnaryExpr9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm11MCUnaryExpr9getOpcodeEv")
  //</editor-fold>
  public Opcode getOpcode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the child of this unary expression.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::getSubExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 373,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 400,
   FQN="llvm::MCUnaryExpr::getSubExpr", NM="_ZNK4llvm11MCUnaryExpr10getSubExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm11MCUnaryExpr10getSubExprEv")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getSubExpr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCUnaryExpr::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 377,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 404,
   FQN="llvm::MCUnaryExpr::classof", NM="_ZN4llvm11MCUnaryExpr7classofEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm11MCUnaryExpr7classofEPKNS_6MCExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCExpr /*P*/ E) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Op=" + Op // NOI18N
              + ", Expr=" + "[MCExpr]" // NOI18N
              + super.toString(); // NOI18N
  }
}

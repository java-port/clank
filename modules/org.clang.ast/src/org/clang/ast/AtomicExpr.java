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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// AtomicExpr - Variadic atomic builtins: __atomic_exchange, __atomic_fetch_*,
/// __atomic_load, __atomic_store, and __atomic_compare_exchange_*, for the
/// similarly-named C++11 instructions, and __c11 variants for <stdatomic.h>.
/// All of these instructions take one primary pointer and at least one memory
/// order.
//<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4804,
 FQN="clang::AtomicExpr", NM="_ZN5clang10AtomicExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExprE")
//</editor-fold>
public class AtomicExpr extends /*public*/ Expr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::AtomicOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4806,
   FQN="clang::AtomicExpr::AtomicOp", NM="_ZN5clang10AtomicExpr8AtomicOpE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExpr8AtomicOpE")
  //</editor-fold>
  public enum AtomicOp implements Native.ComparableLower {
    
    // C11 _Atomic operations for <stdatomic.h>.
    AO__c11_atomic_init(0),
    AO__c11_atomic_load(AO__c11_atomic_init.getValue() + 1),
    AO__c11_atomic_store(AO__c11_atomic_load.getValue() + 1),
    AO__c11_atomic_exchange(AO__c11_atomic_store.getValue() + 1),
    AO__c11_atomic_compare_exchange_strong(AO__c11_atomic_exchange.getValue() + 1),
    AO__c11_atomic_compare_exchange_weak(AO__c11_atomic_compare_exchange_strong.getValue() + 1),
    AO__c11_atomic_fetch_add(AO__c11_atomic_compare_exchange_weak.getValue() + 1),
    AO__c11_atomic_fetch_sub(AO__c11_atomic_fetch_add.getValue() + 1),
    AO__c11_atomic_fetch_and(AO__c11_atomic_fetch_sub.getValue() + 1),
    AO__c11_atomic_fetch_or(AO__c11_atomic_fetch_and.getValue() + 1),
    AO__c11_atomic_fetch_xor(AO__c11_atomic_fetch_or.getValue() + 1),
    
    // GNU atomic builtins.
    AO__atomic_load(AO__c11_atomic_fetch_xor.getValue() + 1),
    AO__atomic_load_n(AO__atomic_load.getValue() + 1),
    AO__atomic_store(AO__atomic_load_n.getValue() + 1),
    AO__atomic_store_n(AO__atomic_store.getValue() + 1),
    AO__atomic_exchange(AO__atomic_store_n.getValue() + 1),
    AO__atomic_exchange_n(AO__atomic_exchange.getValue() + 1),
    AO__atomic_compare_exchange(AO__atomic_exchange_n.getValue() + 1),
    AO__atomic_compare_exchange_n(AO__atomic_compare_exchange.getValue() + 1),
    AO__atomic_fetch_add(AO__atomic_compare_exchange_n.getValue() + 1),
    AO__atomic_fetch_sub(AO__atomic_fetch_add.getValue() + 1),
    AO__atomic_fetch_and(AO__atomic_fetch_sub.getValue() + 1),
    AO__atomic_fetch_or(AO__atomic_fetch_and.getValue() + 1),
    AO__atomic_fetch_xor(AO__atomic_fetch_or.getValue() + 1),
    AO__atomic_fetch_nand(AO__atomic_fetch_xor.getValue() + 1),
    AO__atomic_add_fetch(AO__atomic_fetch_nand.getValue() + 1),
    AO__atomic_sub_fetch(AO__atomic_add_fetch.getValue() + 1),
    AO__atomic_and_fetch(AO__atomic_sub_fetch.getValue() + 1),
    AO__atomic_or_fetch(AO__atomic_and_fetch.getValue() + 1),
    AO__atomic_xor_fetch(AO__atomic_or_fetch.getValue() + 1),
    AO__atomic_nand_fetch(AO__atomic_xor_fetch.getValue() + 1),
    // Avoid trailing comma
    BI_First(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AtomicOp valueOf(int val) {
      AtomicOp out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AtomicOp[] VALUES;
      private static final AtomicOp[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AtomicOp kind : AtomicOp.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AtomicOp[min < 0 ? (1-min) : 0];
        VALUES = new AtomicOp[max >= 0 ? (1+max) : 0];
        for (AtomicOp kind : AtomicOp.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AtomicOp(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AtomicOp)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AtomicOp)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4815,
   FQN="clang::AtomicExpr::(anonymous)", NM="_ZN5clang10AtomicExprE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExprE_Unnamed_enum1")
  //</editor-fold>
  private enum Unnamed_enum1 implements Native.ComparableLower {
    PTR(0),
    ORDER(PTR.getValue() + 1),
    VAL1(ORDER.getValue() + 1),
    ORDER_FAIL(VAL1.getValue() + 1),
    VAL2(ORDER_FAIL.getValue() + 1),
    WEAK(VAL2.getValue() + 1),
    END_EXPR(WEAK.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum1 valueOf(int val) {
      Unnamed_enum1 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum1[] VALUES;
      private static final Unnamed_enum1[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum1[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum1[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum1 kind : Unnamed_enum1.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum1(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum1)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum1)obj).value);}
    //</editor-fold>
  };
  /*friend*/public Stmt /*P*/ SubExprs[/*6*/] = new Stmt /*P*/  [6];
  /*friend*/public /*uint*/int NumSubExprs;
  /*friend*/public SourceLocation BuiltinLoc;
  /*friend*/public SourceLocation RParenLoc;
  /*friend*/public AtomicOp Op;
  
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::AtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3820,
   FQN="clang::AtomicExpr::AtomicExpr", NM="_ZN5clang10AtomicExprC1ENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeENS0_8AtomicOpES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExprC1ENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEENS_8QualTypeENS0_8AtomicOpES1_")
  //</editor-fold>
  public AtomicExpr(SourceLocation BLoc, ArrayRef<Expr /*P*/ > args, 
      QualType t, AtomicOp op, SourceLocation RP) {
    // : Expr(AtomicExprClass, t, VK_RValue, OK_Ordinary, false, false, false, false), NumSubExprs(args.size()), BuiltinLoc(BLoc), RParenLoc(RP), Op(op) 
    //START JInit
    super(StmtClass.AtomicExprClass, new QualType(t), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, false, false, false);
    this.NumSubExprs = args.size();
    this.BuiltinLoc = new SourceLocation(BLoc);
    this.RParenLoc = new SourceLocation(RP);
    this.Op = op;
    //END JInit
    assert (args.size() == getNumSubExprs(op)) : "wrong number of subexpressions";
    for (/*uint*/int i = 0; i != args.size(); i++) {
      if (args.$at(i).isTypeDependent()) {
        Unnamed_field.ExprBits.TypeDependent = true;
      }
      if (args.$at(i).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (args.$at(i).isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (args.$at(i).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      SubExprs[i] = args.$at(i);
    }
  }

  
  /// \brief Determine the number of arguments the specified atomic builtin
  /// should have.
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getNumSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3841,
   FQN="clang::AtomicExpr::getNumSubExprs", NM="_ZN5clang10AtomicExpr14getNumSubExprsENS0_8AtomicOpE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExpr14getNumSubExprsENS0_8AtomicOpE")
  //</editor-fold>
  public static /*uint*/int getNumSubExprs(AtomicOp Op) {
    switch (Op) {
     case AO__c11_atomic_init:
     case AO__c11_atomic_load:
     case AO__atomic_load_n:
      return 2;
     case AO__c11_atomic_store:
     case AO__c11_atomic_exchange:
     case AO__atomic_load:
     case AO__atomic_store:
     case AO__atomic_store_n:
     case AO__atomic_exchange_n:
     case AO__c11_atomic_fetch_add:
     case AO__c11_atomic_fetch_sub:
     case AO__c11_atomic_fetch_and:
     case AO__c11_atomic_fetch_or:
     case AO__c11_atomic_fetch_xor:
     case AO__atomic_fetch_add:
     case AO__atomic_fetch_sub:
     case AO__atomic_fetch_and:
     case AO__atomic_fetch_or:
     case AO__atomic_fetch_xor:
     case AO__atomic_fetch_nand:
     case AO__atomic_add_fetch:
     case AO__atomic_sub_fetch:
     case AO__atomic_and_fetch:
     case AO__atomic_or_fetch:
     case AO__atomic_xor_fetch:
     case AO__atomic_nand_fetch:
      return 3;
     case AO__atomic_exchange:
      return 4;
     case AO__c11_atomic_compare_exchange_strong:
     case AO__c11_atomic_compare_exchange_weak:
      return 5;
     case AO__atomic_compare_exchange:
     case AO__atomic_compare_exchange_n:
      return 6;
    }
    throw new llvm_unreachable("unknown atomic op");
  }

  
  /// \brief Build an empty AtomicExpr.
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::AtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4832,
   FQN="clang::AtomicExpr::AtomicExpr", NM="_ZN5clang10AtomicExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ AtomicExpr(EmptyShell Empty) {
    // : Expr(AtomicExprClass, Empty), BuiltinLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.AtomicExprClass, new EmptyShell(Empty));
    this.BuiltinLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4834,
   FQN="clang::AtomicExpr::getPtr", NM="_ZNK5clang10AtomicExpr6getPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr6getPtrEv")
  //</editor-fold>
  public Expr /*P*/ getPtr() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum1.PTR.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4837,
   FQN="clang::AtomicExpr::getOrder", NM="_ZNK5clang10AtomicExpr8getOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr8getOrderEv")
  //</editor-fold>
  public Expr /*P*/ getOrder() /*const*/ {
    return cast_Expr(SubExprs[Unnamed_enum1.ORDER.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getVal1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4840,
   FQN="clang::AtomicExpr::getVal1", NM="_ZNK5clang10AtomicExpr7getVal1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr7getVal1Ev")
  //</editor-fold>
  public Expr /*P*/ getVal1() /*const*/ {
    if (Op == AtomicOp.AO__c11_atomic_init) {
      return cast_Expr(SubExprs[Unnamed_enum1.ORDER.getValue()]);
    }
    assert ($greater_uint(NumSubExprs, Unnamed_enum1.VAL1.getValue()));
    return cast_Expr(SubExprs[Unnamed_enum1.VAL1.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getOrderFail">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4846,
   FQN="clang::AtomicExpr::getOrderFail", NM="_ZNK5clang10AtomicExpr12getOrderFailEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr12getOrderFailEv")
  //</editor-fold>
  public Expr /*P*/ getOrderFail() /*const*/ {
    assert ($greater_uint(NumSubExprs, Unnamed_enum1.ORDER_FAIL.getValue()));
    return cast_Expr(SubExprs[Unnamed_enum1.ORDER_FAIL.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getVal2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4850,
   FQN="clang::AtomicExpr::getVal2", NM="_ZNK5clang10AtomicExpr7getVal2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr7getVal2Ev")
  //</editor-fold>
  public Expr /*P*/ getVal2() /*const*/ {
    if (Op == AtomicOp.AO__atomic_exchange) {
      return cast_Expr(SubExprs[Unnamed_enum1.ORDER_FAIL.getValue()]);
    }
    assert ($greater_uint(NumSubExprs, Unnamed_enum1.VAL2.getValue()));
    return cast_Expr(SubExprs[Unnamed_enum1.VAL2.getValue()]);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4856,
   FQN="clang::AtomicExpr::getWeak", NM="_ZNK5clang10AtomicExpr7getWeakEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr7getWeakEv")
  //</editor-fold>
  public Expr /*P*/ getWeak() /*const*/ {
    assert ($greater_uint(NumSubExprs, Unnamed_enum1.WEAK.getValue()));
    return cast_Expr(SubExprs[Unnamed_enum1.WEAK.getValue()]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4861,
   FQN="clang::AtomicExpr::getOp", NM="_ZNK5clang10AtomicExpr5getOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr5getOpEv")
  //</editor-fold>
  public AtomicOp getOp() /*const*/ {
    return Op;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getNumSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4862,
   FQN="clang::AtomicExpr::getNumSubExprs", NM="_ZNK5clang10AtomicExpr14getNumSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr14getNumSubExprsEv")
  //</editor-fold>
  public /*uint*/int getNumSubExprs() /*const*/ {
    return NumSubExprs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4864,
   FQN="clang::AtomicExpr::getSubExprs", NM="_ZN5clang10AtomicExpr11getSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExpr11getSubExprsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getSubExprs() {
    return (type$ptr)create_type$ptr(SubExprs);//((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, SubExprs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4865,
   FQN="clang::AtomicExpr::getSubExprs", NM="_ZNK5clang10AtomicExpr11getSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr11getSubExprsEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> getSubExprs$Const() /*const*/ {
    return (type$ptr)create_type$ptr(SubExprs);//((type$ptr<Expr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, create_type$ptr(SubExprs)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::isVolatile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4869,
   FQN="clang::AtomicExpr::isVolatile", NM="_ZNK5clang10AtomicExpr10isVolatileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr10isVolatileEv")
  //</editor-fold>
  public boolean isVolatile() /*const*/ {
    return getPtr().getType().$arrow().getPointeeType().isVolatileQualified();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::isCmpXChg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4873,
   FQN="clang::AtomicExpr::isCmpXChg", NM="_ZNK5clang10AtomicExpr9isCmpXChgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr9isCmpXChgEv")
  //</editor-fold>
  public boolean isCmpXChg() /*const*/ {
    return getOp() == AtomicOp.AO__c11_atomic_compare_exchange_strong
       || getOp() == AtomicOp.AO__c11_atomic_compare_exchange_weak
       || getOp() == AtomicOp.AO__atomic_compare_exchange
       || getOp() == AtomicOp.AO__atomic_compare_exchange_n;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4880,
   FQN="clang::AtomicExpr::getBuiltinLoc", NM="_ZNK5clang10AtomicExpr13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4881,
   FQN="clang::AtomicExpr::getRParenLoc", NM="_ZNK5clang10AtomicExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4883,
   FQN="clang::AtomicExpr::getLocStart", NM="_ZNK5clang10AtomicExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4884,
   FQN="clang::AtomicExpr::getLocEnd", NM="_ZNK5clang10AtomicExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang10AtomicExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4886,
   FQN="clang::AtomicExpr::classof", NM="_ZN5clang10AtomicExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.AtomicExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4891,
   FQN="clang::AtomicExpr::children", NM="_ZN5clang10AtomicExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang10AtomicExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr(SubExprs)), new StmtIterator(create_type$ptr(SubExprs).$add(NumSubExprs)));
  }

  
  @Override public String toString() {
    return "" + "SubExprs=" + SubExprs // NOI18N
              + ", NumSubExprs=" + NumSubExprs // NOI18N
              + ", BuiltinLoc=" + BuiltinLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", Op=" + Op // NOI18N
              + super.toString(); // NOI18N
  }
}

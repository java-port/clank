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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.threadSafety.til.*;


// Base class for literal values.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 516,
 FQN="clang::threadSafety::til::Literal", NM="_ZN5clang12threadSafety3til7LiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7LiteralE")
//</editor-fold>
public class Literal extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 518,
   FQN="clang::threadSafety::til::Literal::classof", NM="_ZN5clang12threadSafety3til7Literal7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7Literal7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Literal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::Literal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 520,
   FQN="clang::threadSafety::til::Literal::Literal", NM="_ZN5clang12threadSafety3til7LiteralC1EPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7LiteralC1EPKNS_4ExprE")
  //</editor-fold>
  public Literal(/*const*/ Expr /*P*/ C) {
    // : SExpr(COP_Literal), ValType(ValueType::getValueType<void>()), Cexpr(C) 
    //START JInit
    super(TIL_Opcode.COP_Literal);
    this.ValType = ValueType./*<void>*/getValueType$Void();
    this.Cexpr = C;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::Literal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 523,
   FQN="clang::threadSafety::til::Literal::Literal", NM="_ZN5clang12threadSafety3til7LiteralC1ENS1_9ValueTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7LiteralC1ENS1_9ValueTypeE")
  //</editor-fold>
  public Literal(ValueType VT) {
    // : SExpr(COP_Literal), ValType(VT), Cexpr(null) 
    //START JInit
    super(TIL_Opcode.COP_Literal);
    this.ValType = new ValueType(VT);
    this.Cexpr = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::Literal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 524,
   FQN="clang::threadSafety::til::Literal::Literal", NM="_ZN5clang12threadSafety3til7LiteralC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til7LiteralC1ERKS2_")
  //</editor-fold>
  public Literal(final /*const*/ Literal /*&*/ L) {
    // : SExpr(L), ValType(L.ValType), Cexpr(L.Cexpr) 
    //START JInit
    super(L);
    this.ValType = new ValueType(L.ValType);
    this.Cexpr = L.Cexpr;
    //END JInit
  }

  
  // The clang expression for this literal.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::clangExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 527,
   FQN="clang::threadSafety::til::Literal::clangExpr", NM="_ZNK5clang12threadSafety3til7Literal9clangExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7Literal9clangExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ clangExpr() /*const*/ {
    return Cexpr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::valueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 529,
   FQN="clang::threadSafety::til::Literal::valueType", NM="_ZNK5clang12threadSafety3til7Literal9valueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til7Literal9valueTypeEv")
  //</editor-fold>
  public ValueType valueType() /*const*/ {
    return new ValueType(ValType);
  }

  
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::as">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 531,
   FQN="clang::threadSafety::til::Literal::as", NM="Tpl__ZNK5clang12threadSafety3til7Literal2asEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZNK5clang12threadSafety3til7Literal2asEv")
  //</editor-fold>
  public </*class*/ T> /*const*/ LiteralT<T> /*&*/ as$Const(Class<T> clazz) /*const*/ {
    ///export1/home/alsimon/LLVM39/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp
    return Native.$star(((/*static_cast*//*const*/ LiteralT<T> /*P*/ )(this)));
  }

  public /*const*/ LiteralTBool /*&*/ as$Const$Bool() /*const*/ {
    return (LiteralTBool)this;
  }
  public /*const*/ LiteralTByte /*&*/ as$Const$Byte() /*const*/ {
    return (LiteralTByte)this;
  }
  public /*const*/ LiteralTShort /*&*/ as$Const$Short() /*const*/ {
    return (LiteralTShort)this;
  }
  public /*const*/ LiteralTUshort /*&*/ as$Const$Ushort() /*const*/ {
    return (LiteralTUshort)this;
  }
  public /*const*/ LiteralTInt /*&*/ as$Const$Int() /*const*/ {
    return (LiteralTInt)this;
  }
  public /*const*/ LiteralTUint /*&*/ as$Const$Uint() /*const*/ {
    return (LiteralTUint)this;
  }
  public /*const*/ LiteralTLlong /*&*/ as$Const$Llong() /*const*/ {
    return (LiteralTLlong)this;
  }
  public /*const*/ LiteralTUllong /*&*/ as$Const$Ullong() /*const*/ {
    return (LiteralTUllong)this;
  }
  public /*const*/ LiteralTFloat /*&*/ as$Const$Float() /*const*/ {
    return (LiteralTFloat)this;
  }
  public /*const*/ LiteralTDouble /*&*/ as$Const$Double() /*const*/ {
    return (LiteralTDouble)this;
  }
  public /*const*/ LiteralTStringRef /*&*/ as$Const$StringRef() /*const*/ {
    return (LiteralTStringRef)this;
  }
  
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::as">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 534,
   FQN="clang::threadSafety::til::Literal::as", NM="Tpl__ZN5clang12threadSafety3til7Literal2asEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til7Literal2asEv")
  //</editor-fold>
  public </*class*/ T> LiteralT<T> /*&*/ as(Class<T> clazz) {
    return Native.$star(((/*static_cast*/LiteralT<T> /*P*/ )(this)));
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 569,
   FQN="clang::threadSafety::til::Literal::traverse", NM="Tpl__ZN5clang12threadSafety3til7Literal8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til7Literal8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    if ((Cexpr != null)) {
      return Vs.reduceLiteral(/*Deref*/this);
    }
    switch (ValType.Base) {
     case BT_Void:
      break;
     case BT_Bool:
      return Vs.reduceLiteralT(this.as(boolean.class));
     case BT_Int:
      {
        switch (ValType.Size) {
         case ST_8:
          if (ValType.Signed) {
            return Vs.reduceLiteralT(this.as(byte/*int8_t*/.class));
          } else {
            return Vs.reduceLiteralT(this.as(byte/*uint8_t*/.class));
          }
         case ST_16:
          if (ValType.Signed) {
            return Vs.reduceLiteralT(this.as(short/*int16_t*/.class));
          } else {
            return Vs.reduceLiteralT(this.as(/*uint16_t*/char.class));
          }
         case ST_32:
          if (ValType.Signed) {
            return Vs.reduceLiteralT(this.as(int/*int32_t*/.class));
          } else {
            return Vs.reduceLiteralT(this.as(/*uint32_t*/int.class));
          }
         case ST_64:
          if (ValType.Signed) {
            return Vs.reduceLiteralT(this.as(long/*int64_t*/.class));
          } else {
            return Vs.reduceLiteralT(this.as(long/*uint64_t*/.class));
          }
         default:
          break;
        }
      }
     case BT_Float:
      {
        switch (ValType.Size) {
         case ST_32:
          return Vs.reduceLiteralT(this.as(float.class));
         case ST_64:
          return Vs.reduceLiteralT(this.as(double.class));
         default:
          break;
        }
      }
     case BT_String:
      return Vs.reduceLiteralT(this.as(StringRef.class));
     case BT_Pointer:
      return Vs.reduceLiteralT(this.as(Object/*void P*/ .class));
     case BT_ValueRef:
      break;
    }
    return Vs.reduceLiteral(/*Deref*/this);
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Literal::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 541,
   FQN="clang::threadSafety::til::Literal::compare", NM="Tpl__ZNK5clang12threadSafety3til7Literal7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til7Literal7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Literal /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    // TODO: defer actual comparison to LiteralT
    return Cmp.trueResult();
  }

/*private:*/
  private /*const*/ ValueType ValType;
  private /*const*/ Expr /*P*/ Cexpr;
  
  @Override public String toString() {
    return "" + "ValType=" + ValType // NOI18N
              + ", Cexpr=" + Cexpr // NOI18N
              + super.toString(); // NOI18N
  }
}

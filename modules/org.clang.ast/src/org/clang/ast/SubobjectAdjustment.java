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


/// \brief An adjustment to be made to the temporary created when emitting a
/// reference binding, which accesses a particular subobject of that temporary.
//<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 59,
 FQN="clang::SubobjectAdjustment", NM="_ZN5clang19SubobjectAdjustmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustmentE")
//</editor-fold>
public class/*struct*/ SubobjectAdjustment implements NativeCloneable<SubobjectAdjustment> {
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 60,
   FQN="clang::SubobjectAdjustment::(anonymous)", NM="_ZN5clang19SubobjectAdjustmentE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustmentE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    DerivedToBaseAdjustment(0),
    FieldAdjustment(DerivedToBaseAdjustment.getValue() + 1),
    MemberPointerAdjustment(FieldAdjustment.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
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
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  public Unnamed_enum Kind;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::DTB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 66,
   FQN="clang::SubobjectAdjustment::DTB", NM="_ZN5clang19SubobjectAdjustment3DTBE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustment3DTBE")
  //</editor-fold>
  public static class/*struct*/ DTB {
    public /*const*/ CastExpr /*P*/ BasePath;
    public /*const*/ CXXRecordDecl /*P*/ DerivedClass;
    
    @Override public String toString() {
      return "" + "BasePath=" + BasePath // NOI18N
                + ", DerivedClass=" + DerivedClass; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::P">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 71,
   FQN="clang::SubobjectAdjustment::P", NM="_ZN5clang19SubobjectAdjustment1PE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustment1PE")
  //</editor-fold>
  public static class/*struct*/ P {
    public /*const*/ MemberPointerType /*P*/ MPT;
    public Expr /*P*/ RHS;
    
    @Override public String toString() {
      return "" + "MPT=" + MPT // NOI18N
                + ", RHS=" + RHS; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 76,
   FQN="clang::SubobjectAdjustment::(anonymous)", NM="_ZN5clang19SubobjectAdjustmentE_Unnamed_union3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustmentE_Unnamed_union3")
  //</editor-fold>
  public static class/*union*/ Unnamed_union3 {
    public final DTB DerivedToBase;
    public FieldDecl /*P*/ Field;
    public final P Ptr;
    
    private Unnamed_union3() {
      DerivedToBase = new DTB();
      Field = null;
      Ptr = new P();
    }
    
    @Override public String toString() {
      return "" + "DerivedToBase=" + DerivedToBase // NOI18N
                + ", Field=" + Field // NOI18N
                + ", Ptr=" + Ptr; // NOI18N
    }
  };
  public final Unnamed_union3 Unnamed_field1 = new Unnamed_union3();
  
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::SubobjectAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 82,
   FQN="clang::SubobjectAdjustment::SubobjectAdjustment", NM="_ZN5clang19SubobjectAdjustmentC1EPKNS_8CastExprEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustmentC1EPKNS_8CastExprEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public SubobjectAdjustment(/*const*/ CastExpr /*P*/ BasePath, 
      /*const*/ CXXRecordDecl /*P*/ DerivedClass) {
    // : Kind(DerivedToBaseAdjustment) 
    //START JInit
    this.Kind = Unnamed_enum.DerivedToBaseAdjustment;
    //END JInit
    Unnamed_field1.DerivedToBase.BasePath = BasePath;
    Unnamed_field1.DerivedToBase.DerivedClass = DerivedClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::SubobjectAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 89,
   FQN="clang::SubobjectAdjustment::SubobjectAdjustment", NM="_ZN5clang19SubobjectAdjustmentC1EPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustmentC1EPNS_9FieldDeclE")
  //</editor-fold>
  public SubobjectAdjustment(FieldDecl /*P*/ Field) {
    // : Kind(FieldAdjustment) 
    //START JInit
    this.Kind = Unnamed_enum.FieldAdjustment;
    //END JInit
    this.Unnamed_field1.Field = Field;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubobjectAdjustment::SubobjectAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 94,
   FQN="clang::SubobjectAdjustment::SubobjectAdjustment", NM="_ZN5clang19SubobjectAdjustmentC1EPKNS_17MemberPointerTypeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19SubobjectAdjustmentC1EPKNS_17MemberPointerTypeEPNS_4ExprE")
  //</editor-fold>
  public SubobjectAdjustment(/*const*/ MemberPointerType /*P*/ MPT, Expr /*P*/ RHS) {
    // : Kind(MemberPointerAdjustment) 
    //START JInit
    this.Kind = Unnamed_enum.MemberPointerAdjustment;
    //END JInit
    this.Unnamed_field1.Ptr.MPT = MPT;
    this.Unnamed_field1.Ptr.RHS = RHS;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public SubobjectAdjustment() {
    this.Kind = Unnamed_enum.DerivedToBaseAdjustment;
  }

  private SubobjectAdjustment(SubobjectAdjustment $Prm0) {
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1.Field = $Prm0.Unnamed_field1.Field;
    this.Unnamed_field1.Ptr.MPT = $Prm0.Unnamed_field1.Ptr.MPT;
    this.Unnamed_field1.Ptr.RHS = $Prm0.Unnamed_field1.Ptr.RHS;
    this.Unnamed_field1.DerivedToBase.BasePath = $Prm0.Unnamed_field1.DerivedToBase.BasePath;
    this.Unnamed_field1.DerivedToBase.DerivedClass = $Prm0.Unnamed_field1.DerivedToBase.DerivedClass;
  }
  
  @Override public SubobjectAdjustment clone() {
    return new SubobjectAdjustment(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
  }
}

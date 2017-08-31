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

package org.clang.sema;

import org.clank.support.*;
import org.clang.ast.*;


/// BadConversionSequence - Records information about an invalid
/// conversion sequence.
//<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 328,
 FQN="clang::BadConversionSequence", NM="_ZN5clang21BadConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequenceE")
//</editor-fold>
public class/*struct*/ BadConversionSequence {
  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::FailureKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 329,
   FQN="clang::BadConversionSequence::FailureKind", NM="_ZN5clang21BadConversionSequence11FailureKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequence11FailureKindE")
  //</editor-fold>
  public enum FailureKind implements Native.ComparableLower {
    no_conversion(0),
    unrelated_class(no_conversion.getValue() + 1),
    bad_qualifiers(unrelated_class.getValue() + 1),
    lvalue_ref_to_rvalue(bad_qualifiers.getValue() + 1),
    rvalue_ref_to_lvalue(lvalue_ref_to_rvalue.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FailureKind valueOf(int val) {
      FailureKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FailureKind[] VALUES;
      private static final FailureKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FailureKind kind : FailureKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FailureKind[min < 0 ? (1-min) : 0];
        VALUES = new FailureKind[max >= 0 ? (1+max) : 0];
        for (FailureKind kind : FailureKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FailureKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FailureKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FailureKind)obj).value);}
    //</editor-fold>
  };
  
  // This can be null, e.g. for implicit object arguments.
  public Expr /*P*/ FromExpr;
  
  public FailureKind Kind;
/*private:*/
  // The type we're converting from (an opaque QualType).
  private Object/*void P*/ FromTy;
  
  // The type we're converting to (an opaque QualType).
  private Object/*void P*/ ToTy;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 350,
   FQN="clang::BadConversionSequence::init", NM="_ZN5clang21BadConversionSequence4initENS0_11FailureKindEPNS_4ExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequence4initENS0_11FailureKindEPNS_4ExprENS_8QualTypeE")
  //</editor-fold>
  public void init(FailureKind K, Expr /*P*/ From, QualType To) {
    init(K, From.getType(), new QualType(To));
    FromExpr = From;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 354,
   FQN="clang::BadConversionSequence::init", NM="_ZN5clang21BadConversionSequence4initENS0_11FailureKindENS_8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequence4initENS0_11FailureKindENS_8QualTypeES2_")
  //</editor-fold>
  public void init(FailureKind K, QualType From, QualType To) {
    Kind = K;
    FromExpr = null;
    setFromType(new QualType(From));
    setToType(new QualType(To));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::getFromType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 361,
   FQN="clang::BadConversionSequence::getFromType", NM="_ZNK5clang21BadConversionSequence11getFromTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang21BadConversionSequence11getFromTypeEv")
  //</editor-fold>
  public QualType getFromType() /*const*/ {
    return QualType.getFromOpaquePtr(FromTy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::getToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 362,
   FQN="clang::BadConversionSequence::getToType", NM="_ZNK5clang21BadConversionSequence9getToTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZNK5clang21BadConversionSequence9getToTypeEv")
  //</editor-fold>
  public QualType getToType() /*const*/ {
    return QualType.getFromOpaquePtr(ToTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::setFromExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 364,
   FQN="clang::BadConversionSequence::setFromExpr", NM="_ZN5clang21BadConversionSequence11setFromExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequence11setFromExprEPNS_4ExprE")
  //</editor-fold>
  public void setFromExpr(Expr /*P*/ E) {
    FromExpr = E;
    setFromType(E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::setFromType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 368,
   FQN="clang::BadConversionSequence::setFromType", NM="_ZN5clang21BadConversionSequence11setFromTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequence11setFromTypeENS_8QualTypeE")
  //</editor-fold>
  public void setFromType(QualType T) {
    FromTy = T.getAsOpaquePtr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::setToType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 369,
   FQN="clang::BadConversionSequence::setToType", NM="_ZN5clang21BadConversionSequence9setToTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequence9setToTypeENS_8QualTypeE")
  //</editor-fold>
  public void setToType(QualType T) {
    ToTy = T.getAsOpaquePtr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BadConversionSequence::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Overload.h", line = 328,
   FQN="clang::BadConversionSequence::operator=", NM="_ZN5clang21BadConversionSequenceaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang21BadConversionSequenceaSERKS0_")
  //</editor-fold>
  public /*inline*/ BadConversionSequence /*&*/ $assign(final /*const*/ BadConversionSequence /*&*/ $Prm0) {
    this.FromExpr = $Prm0.FromExpr;
    this.Kind = $Prm0.Kind;
    this.FromTy = $Prm0.FromTy;
    this.ToTy = $Prm0.ToTy;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "FromExpr=" + FromExpr // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", FromTy=" + FromTy // NOI18N
              + ", ToTy=" + ToTy; // NOI18N
  }
}

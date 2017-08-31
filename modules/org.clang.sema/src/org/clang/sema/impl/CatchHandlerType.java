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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import static org.clang.ast.QualType.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3537,
 FQN="(anonymous namespace)::CatchHandlerType", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeE")
//</editor-fold>
public class CatchHandlerType {
  private QualType QT;
  private /*JBIT unsigned int*/ boolean IsPointer /*: 1*/;
  
  // This is a special constructor to be used only with DenseMapInfo's
  // getEmptyKey() and getTombstoneKey() functions.
  /*friend  struct llvm::DenseMapInfo<CatchHandlerType>*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::Unique">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3544,
   FQN="(anonymous namespace)::CatchHandlerType::Unique", NM="_ZN12_GLOBAL__N_116CatchHandlerType6UniqueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerType6UniqueE")
  //</editor-fold>
  /*friend*/ public enum Unique implements Native.ComparableLower {
    ForDenseMap(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unique valueOf(int val) {
      Unique out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unique[] VALUES;
      private static final Unique[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unique kind : Unique.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unique[min < 0 ? (1-min) : 0];
        VALUES = new Unique[max >= 0 ? (1+max) : 0];
        for (Unique kind : Unique.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unique(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unique)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unique)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::CatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3545,
   FQN="(anonymous namespace)::CatchHandlerType::CatchHandlerType", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeC1EN5clang8QualTypeENS0_6UniqueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeC1EN5clang8QualTypeENS0_6UniqueE")
  //</editor-fold>
  /*friend*/ public CatchHandlerType(QualType QT, Unique $Prm1) {
    // : QT(QT), IsPointer(false) 
    //START JInit
    this.QT = new QualType(QT);
    this.IsPointer = false;
    //END JInit
  }

/*public:*/
  /// Used when creating a CatchHandlerType from a handler type; will determine
  /// whether the type is a pointer or reference and will strip off the top
  /// level pointer and cv-qualifiers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::CatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3551,
   FQN="(anonymous namespace)::CatchHandlerType::CatchHandlerType", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeC1EN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeC1EN5clang8QualTypeE")
  //</editor-fold>
  public CatchHandlerType(QualType Q) {
    // : QT(Q), IsPointer(false) 
    //START JInit
    this.QT = new QualType(Q);
    this.IsPointer = false;
    //END JInit
    if (QT.$arrow().isPointerType()) {
      IsPointer = true;
    }
    if (IsPointer || QT.$arrow().isReferenceType()) {
      QT.$assignMove(QT.$arrow().getPointeeType());
    }
    QT.$assignMove(QT.getUnqualifiedType());
  }

  
  /// Used when creating a CatchHandlerType from a base class type; pretends the
  /// type passed in had the pointer qualifier, does not need to get an
  /// unqualified type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::CatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3563,
   FQN="(anonymous namespace)::CatchHandlerType::CatchHandlerType", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeC1EN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeC1EN5clang8QualTypeEb")
  //</editor-fold>
  public CatchHandlerType(QualType QT, boolean IsPointer) {
    // : QT(QT), IsPointer(IsPointer) 
    //START JInit
    this.QT = new QualType(QT);
    this.IsPointer = IsPointer;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::underlying">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3566,
   FQN="(anonymous namespace)::CatchHandlerType::underlying", NM="_ZNK12_GLOBAL__N_116CatchHandlerType10underlyingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK12_GLOBAL__N_116CatchHandlerType10underlyingEv")
  //</editor-fold>
  public QualType underlying() /*const*/ {
    return new QualType(QT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::isPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3567,
   FQN="(anonymous namespace)::CatchHandlerType::isPointer", NM="_ZNK12_GLOBAL__N_116CatchHandlerType9isPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK12_GLOBAL__N_116CatchHandlerType9isPointerEv")
  //</editor-fold>
  public boolean isPointer() /*const*/ {
    return IsPointer;
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3569,
   FQN="(anonymous namespace)::operator==", NM="_ZN12_GLOBAL__N_1eqERKNS_16CatchHandlerTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_1eqERKNS_16CatchHandlerTypeES2_")
  //</editor-fold>
  public static boolean $eq_CatchHandlerType$C(final /*const*/ CatchHandlerType /*&*/ LHS, 
                        final /*const*/ CatchHandlerType /*&*/ RHS) {
    // If the pointer qualification does not match, we can return early.
    if (LHS.IsPointer != RHS.IsPointer) {
      return false;
    }
    // Otherwise, check the underlying type without cv-qualifiers.
    return $eq_QualType$C(LHS.QT, RHS.QT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::CatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3537,
   FQN="(anonymous namespace)::CatchHandlerType::CatchHandlerType", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CatchHandlerType(final /*const*/ CatchHandlerType /*&*/ $Prm0) {
    // : QT(.QT), IsPointer(.IsPointer) 
    //START JInit
    this.QT = new QualType($Prm0.QT);
    this.IsPointer = $Prm0.IsPointer;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::CatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3537,
   FQN="(anonymous namespace)::CatchHandlerType::CatchHandlerType", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeC1EOS0_")
  //</editor-fold>
  public /*inline*/ CatchHandlerType(JD$Move _dparam, final CatchHandlerType /*&&*/$Prm0) {
    // : QT(static_cast<CatchHandlerType &&>().QT), IsPointer(static_cast<CatchHandlerType &&>().IsPointer) 
    //START JInit
    this.QT = new QualType(JD$Move.INSTANCE, $Prm0.QT);
    this.IsPointer = $Prm0.IsPointer;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CatchHandlerType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3537,
   FQN="(anonymous namespace)::CatchHandlerType::operator=", NM="_ZN12_GLOBAL__N_116CatchHandlerTypeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_116CatchHandlerTypeaSEOS0_")
  //</editor-fold>
  public /*inline*/ CatchHandlerType /*&*/ $assignMove(final CatchHandlerType /*&&*/$Prm0) {
    this.QT.$assignMove($Prm0.QT);
    this.IsPointer = $Prm0.IsPointer;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "QT=" + QT // NOI18N
              + ", IsPointer=" + IsPointer; // NOI18N
  }
}

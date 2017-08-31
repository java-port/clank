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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// \brief Checks whether delete-expression, and new-expression used for
///  initializing deletee have the same array form.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2578,
 FQN="(anonymous namespace)::MismatchingNewDeleteDetector", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetectorE")
//</editor-fold>
public class MismatchingNewDeleteDetector implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::MismatchResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2580,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::MismatchResult", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector14MismatchResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector14MismatchResultE")
  //</editor-fold>
  public enum MismatchResult implements Native.ComparableLower {
    /// Indicates that there is no mismatch or a mismatch cannot be proven.
    NoMismatch(0),
    /// Indicates that variable is initialized with mismatching form of \a new.
    VarInitMismatches(NoMismatch.getValue() + 1),
    /// Indicates that member is initialized with mismatching form of \a new.
    MemberInitMismatches(VarInitMismatches.getValue() + 1),
    /// Indicates that 1 or more constructors' definitions could not been
    /// analyzed, and they will be checked again at the end of translation unit.
    AnalyzeLater(MemberInitMismatches.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MismatchResult valueOf(int val) {
      MismatchResult out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MismatchResult[] VALUES;
      private static final MismatchResult[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MismatchResult kind : MismatchResult.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MismatchResult[min < 0 ? (1-min) : 0];
        VALUES = new MismatchResult[max >= 0 ? (1+max) : 0];
        for (MismatchResult kind : MismatchResult.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private MismatchResult(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MismatchResult)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MismatchResult)obj).value);}
    //</editor-fold>
  };
  
  /// \param EndOfTU True, if this is the final analysis at the end of
  /// translation unit. False, if this is the initial analysis at the point
  /// delete-expression was encountered.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::MismatchingNewDeleteDetector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2595,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::MismatchingNewDeleteDetector", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetectorC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetectorC1Eb")
  //</editor-fold>
  public /*explicit*/ MismatchingNewDeleteDetector(boolean EndOfTU) {
    // : NewExprs(), IsArrayForm(false), Field(null), EndOfTU(EndOfTU), HasUndefinedConstructors(false) 
    //START JInit
    this.NewExprs = new SmallVector</*const*/ CXXNewExpr /*P*/ >(4, (/*const*/ CXXNewExpr /*P*/ )null);
    this.IsArrayForm = false;
    this.Field = null;
    this.EndOfTU = EndOfTU;
    this.HasUndefinedConstructors = false;
    //END JInit
  }

  
  /// \brief Checks whether pointee of a delete-expression is initialized with
  /// matching form of new-expression.
  ///
  /// If return value is \c VarInitMismatches or \c MemberInitMismatches at the
  /// point where delete-expression is encountered, then a warning will be
  /// issued immediately. If return value is \c AnalyzeLater at the point where
  /// delete-expression is seen, then member will be analyzed at the end of
  /// translation unit. \c AnalyzeLater is returned iff at least one constructor
  /// couldn't be analyzed. If at least one constructor initializes the member
  /// with matching type of new, the return value is \c NoMismatch.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2663,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeDeleteExpr", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector17analyzeDeleteExprEPKN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector17analyzeDeleteExprEPKN5clang13CXXDeleteExprE")
  //</editor-fold>
  public MismatchingNewDeleteDetector.MismatchResult analyzeDeleteExpr(/*const*/ CXXDeleteExpr /*P*/ DE) {
    NewExprs.clear();
    assert ((DE != null)) : "Expected delete-expression";
    IsArrayForm = DE.isArrayForm();
    /*const*/ Expr /*P*/ E = DE.getArgument$Const().IgnoreParenImpCasts$Const();
    {
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
      if ((ME != null)) {
        return analyzeMemberExpr(ME);
      } else {
        /*const*/ DeclRefExpr /*P*/ D = dyn_cast_DeclRefExpr(E);
        if ((D != null)) {
          if (!hasMatchingVarInit(D)) {
            return MismatchResult.VarInitMismatches;
          }
        }
      }
    }
    return MismatchResult.NoMismatch;
  }

  /// \brief Analyzes a class member.
  /// \param Field Class member to analyze.
  /// \param DeleteWasArrayForm Array form-ness of the delete-expression used
  /// for deleting the \p Field.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2734,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeField", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector12analyzeFieldEPN5clang9FieldDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector12analyzeFieldEPN5clang9FieldDeclEb")
  //</editor-fold>
  public MismatchingNewDeleteDetector.MismatchResult analyzeField(FieldDecl /*P*/ Field, 
              boolean DeleteWasArrayForm) {
    assert (Field != null) : "Analysis requires a valid class member.";
    this.Field = Field;
    IsArrayForm = DeleteWasArrayForm;
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(Field.getParent());
    for (/*const*/ CXXConstructorDecl /*P*/ CD : RD.ctors()) {
      if (hasMatchingNewInCtor(CD)) {
        return MismatchResult.NoMismatch;
      }
    }
    if (HasUndefinedConstructors) {
      return EndOfTU ? MismatchResult.NoMismatch : MismatchResult.AnalyzeLater;
    }
    if (!NewExprs.empty()) {
      return MismatchResult.MemberInitMismatches;
    }
    return Field.hasInClassInitializer() ? analyzeInClassInitializer() : MismatchResult.NoMismatch;
  }

  /// List of mismatching new-expressions used for initialization of the pointee
  public SmallVector</*const*/ CXXNewExpr /*P*/ > NewExprs;
  /// Indicates whether delete-expression was in array form.
  public boolean IsArrayForm;
  public FieldDecl /*P*/ Field;
/*private:*/
  private /*const*/boolean EndOfTU;
  /// \brief Indicates that there is at least one constructor without body.
  private boolean HasUndefinedConstructors;
  /// \brief Returns \c CXXNewExpr from given initialization expression.
  /// \param E Expression used for initializing pointee in delete-expression.
  /// E can be a single-element \c InitListExpr consisting of new-expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::getNewExprFromInitListOrExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2678,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::getNewExprFromInitListOrExpr", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector28getNewExprFromInitListOrExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector28getNewExprFromInitListOrExprEPKN5clang4ExprE")
  //</editor-fold>
  private /*const*/ CXXNewExpr /*P*/ getNewExprFromInitListOrExpr(/*const*/ Expr /*P*/ E) {
    assert (E != null) : "Expected a valid initializer expression";
    E = E.IgnoreParenImpCasts$Const();
    {
      /*const*/ InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(E);
      if ((ILE != null)) {
        if (ILE.getNumInits() == 1) {
          E = dyn_cast_CXXNewExpr(ILE.getInit$Const(0).IgnoreParenImpCasts$Const());
        }
      }
    }
    
    return dyn_cast_or_null_CXXNewExpr(E);
  }

  /// \brief Returns whether member is initialized with mismatching form of
  /// \c new either by the member initializer or in-class initialization.
  ///
  /// If bodies of all constructors are not visible at the end of translation
  /// unit or at least one constructor initializes member with the matching
  /// form of \c new, mismatch cannot be proven, and this function will return
  /// \c NoMismatch.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2753,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeMemberExpr", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector17analyzeMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector17analyzeMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  private MismatchingNewDeleteDetector.MismatchResult analyzeMemberExpr(/*const*/ MemberExpr /*P*/ ME) {
    assert (ME != null) : "Expected a member expression";
    {
      FieldDecl /*P*/ F = dyn_cast_FieldDecl(ME.getMemberDecl());
      if ((F != null)) {
        return analyzeField(F, IsArrayForm);
      }
    }
    return MismatchResult.NoMismatch;
  }

  /// \brief Returns whether variable is initialized with mismatching form of
  /// \c new.
  ///
  /// If variable is initialized with matching form of \c new or variable is not
  /// initialized with a \c new expression, this function will return true.
  /// If variable is initialized with mismatching form of \c new, returns false.
  /// \param D Variable to analyze.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::hasMatchingVarInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2761,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::hasMatchingVarInit", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector18hasMatchingVarInitEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector18hasMatchingVarInitEPKN5clang11DeclRefExprE")
  //</editor-fold>
  private boolean hasMatchingVarInit(/*const*/ DeclRefExpr /*P*/ D) {
    /*const*/ CXXNewExpr /*P*/ NE = null;
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D.getDecl$Const());
      if ((VD != null)) {
        if (VD.hasInit() && ((NE = getNewExprFromInitListOrExpr(VD.getInit$Const())) != null)
           && NE.isArray() != IsArrayForm) {
          NewExprs.push_back(NE);
        }
      }
    }
    return NewExprs.empty();
  }

  /// \brief Checks whether the constructor initializes pointee with mismatching
  /// form of \c new.
  ///
  /// Returns true, if member is initialized with matching form of \c new in
  /// member initializer list. Returns false, if member is initialized with the
  /// matching form of \c new in this constructor's initializer or given
  /// constructor isn't defined at the point where delete-expression is seen, or
  /// member isn't initialized by the constructor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::hasMatchingNewInCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2703,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::hasMatchingNewInCtor", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector20hasMatchingNewInCtorEPKN5clang18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector20hasMatchingNewInCtorEPKN5clang18CXXConstructorDeclE")
  //</editor-fold>
  private boolean hasMatchingNewInCtor(/*const*/ CXXConstructorDecl /*P*/ CD) {
    if (CD.isImplicit()) {
      return false;
    }
    type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref(CD);
    if (!CD.isThisDeclarationADefinition() && !CD.isDefined(Definition)) {
      HasUndefinedConstructors = true;
      return EndOfTU;
    }
    for (/*const*/ CXXCtorInitializer /*P*/ CI : cast_CXXConstructorDecl(Definition.$deref()).inits$Const()) {
      if (hasMatchingNewInCtorInit(CI)) {
        return true;
      }
    }
    return false;
  }

  /// \brief Checks whether member is initialized with matching form of
  /// \c new in member initializer list.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::hasMatchingNewInCtorInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2690,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::hasMatchingNewInCtorInit", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector24hasMatchingNewInCtorInitEPKN5clang18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector24hasMatchingNewInCtorInitEPKN5clang18CXXCtorInitializerE")
  //</editor-fold>
  private boolean hasMatchingNewInCtorInit(/*const*/ CXXCtorInitializer /*P*/ CI) {
    /*const*/ CXXNewExpr /*P*/ NE = null;
    if (Field == CI.getMember()
       && ((NE = getNewExprFromInitListOrExpr(CI.getInit())) != null)) {
      if (NE.isArray() == IsArrayForm) {
        return true;
      } else {
        NewExprs.push_back(NE);
      }
    }
    return false;
  }

  /// Checks whether member is initialized with mismatching form of \c new by
  /// in-class initializer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeInClassInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2719,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::analyzeInClassInitializer", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector25analyzeInClassInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetector25analyzeInClassInitializerEv")
  //</editor-fold>
  private MismatchingNewDeleteDetector.MismatchResult analyzeInClassInitializer() {
    assert (Field != null) : "This should be called only for members";
    /*const*/ Expr /*P*/ InitExpr = Field.getInClassInitializer();
    if (!(InitExpr != null)) {
      return EndOfTU ? MismatchResult.NoMismatch : MismatchResult.AnalyzeLater;
    }
    {
      /*const*/ CXXNewExpr /*P*/ NE = getNewExprFromInitListOrExpr(InitExpr);
      if ((NE != null)) {
        if (NE.isArray() != IsArrayForm) {
          NewExprs.push_back(NE);
          return MismatchResult.MemberInitMismatches;
        }
      }
    }
    return MismatchResult.NoMismatch;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MismatchingNewDeleteDetector::~MismatchingNewDeleteDetector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2578,
   FQN="(anonymous namespace)::MismatchingNewDeleteDetector::~MismatchingNewDeleteDetector", NM="_ZN12_GLOBAL__N_128MismatchingNewDeleteDetectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN12_GLOBAL__N_128MismatchingNewDeleteDetectorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NewExprs.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "NewExprs=" + NewExprs // NOI18N
              + ", IsArrayForm=" + IsArrayForm // NOI18N
              + ", Field=" + Field // NOI18N
              + ", EndOfTU=" + EndOfTU // NOI18N
              + ", HasUndefinedConstructors=" + HasUndefinedConstructors; // NOI18N
  }
}

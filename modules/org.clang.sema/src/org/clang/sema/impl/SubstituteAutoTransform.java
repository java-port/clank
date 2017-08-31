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
import org.clang.sema.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// Substitute the 'auto' type specifier within a type for a given replacement
/// type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubstituteAutoTransform">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3926,
 FQN="(anonymous namespace)::SubstituteAutoTransform", NM="_ZN12_GLOBAL__N_123SubstituteAutoTransformE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_123SubstituteAutoTransformE")
//</editor-fold>
public class SubstituteAutoTransform extends /*public*/ TreeTransform<SubstituteAutoTransform> implements Destructors.ClassWithDestructor {
  private QualType Replacement;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubstituteAutoTransform::SubstituteAutoTransform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3930,
   FQN="(anonymous namespace)::SubstituteAutoTransform::SubstituteAutoTransform", NM="_ZN12_GLOBAL__N_123SubstituteAutoTransformC1ERN5clang4SemaENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_123SubstituteAutoTransformC1ERN5clang4SemaENS1_8QualTypeE")
  //</editor-fold>
  public SubstituteAutoTransform(final Sema /*&*/ SemaRef, QualType Replacement) {
    // : TreeTransform<SubstituteAutoTransform>(SemaRef), Replacement(Replacement) 
    //START JInit
    super(SemaRef);
    this.Replacement = new QualType(Replacement);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubstituteAutoTransform::TransformAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3934,
   FQN="(anonymous namespace)::SubstituteAutoTransform::TransformAutoType", NM="_ZN12_GLOBAL__N_123SubstituteAutoTransform17TransformAutoTypeERN5clang14TypeLocBuilderENS1_11AutoTypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_123SubstituteAutoTransform17TransformAutoTypeERN5clang14TypeLocBuilderENS1_11AutoTypeLocE")
  //</editor-fold>
  public QualType TransformAutoType(final TypeLocBuilder /*&*/ TLB, AutoTypeLoc TL) {
    // If we're building the type pattern to deduce against, don't wrap the
    // substituted type in an AutoType. Certain template deduction rules
    // apply only when a template type parameter appears directly (and not if
    // the parameter is found through desugaring). For instance:
    //   auto &&lref = lvalue;
    // must transform into "rvalue reference to T" not "rvalue reference to
    // auto type deduced as T" in order for [temp.deduct.call]p3 to apply.
    if (!Replacement.isNull() && isa_TemplateTypeParmType(Replacement)) {
      QualType Result = new QualType(Replacement);
      TemplateTypeParmTypeLoc NewTL = TLB.push(TemplateTypeParmTypeLoc.class, new QualType(Result));
      NewTL.setNameLoc(TL.getNameLoc());
      return Result;
    } else {
      boolean Dependent = !Replacement.isNull() && Replacement.$arrow().isDependentType();
      QualType Result = SemaRef.Context.getAutoType(Dependent ? new QualType() : new QualType(Replacement), 
          TL.getTypePtr().getKeyword(), 
          Dependent);
      AutoTypeLoc NewTL = TLB.push(AutoTypeLoc.class, new QualType(Result));
      NewTL.setNameLoc(TL.getNameLoc());
      return Result;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubstituteAutoTransform::TransformLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3961,
   FQN="(anonymous namespace)::SubstituteAutoTransform::TransformLambdaExpr", NM="_ZN12_GLOBAL__N_123SubstituteAutoTransform19TransformLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_123SubstituteAutoTransform19TransformLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformLambdaExpr(LambdaExpr /*P*/ E) {
    // Lambdas never need to be transformed.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubstituteAutoTransform::Apply">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3966,
   FQN="(anonymous namespace)::SubstituteAutoTransform::Apply", NM="_ZN12_GLOBAL__N_123SubstituteAutoTransform5ApplyEN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_123SubstituteAutoTransform5ApplyEN5clang7TypeLocE")
  //</editor-fold>
  public QualType Apply(TypeLoc TL) {
    TypeLocBuilder TLB = null;
    try {
      // Create some scratch storage for the transformed type locations.
      // FIXME: We're just going to throw this information away. Don't build it.
      TLB/*J*/= new TypeLocBuilder();
      TLB.reserve(TL.getFullDataSize());
      return TransformType(TLB, new TypeLoc(TL));
    } finally {
      if (TLB != null) { TLB.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubstituteAutoTransform::~SubstituteAutoTransform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3926,
   FQN="(anonymous namespace)::SubstituteAutoTransform::~SubstituteAutoTransform", NM="_ZN12_GLOBAL__N_123SubstituteAutoTransformD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN12_GLOBAL__N_123SubstituteAutoTransformD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Replacement=" + Replacement // NOI18N
              + super.toString(); // NOI18N
  }
}

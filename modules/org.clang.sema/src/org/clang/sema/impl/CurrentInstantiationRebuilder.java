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
import org.clang.basic.*;
import org.clang.sema.*;

// See Sema::RebuildTypeInCurrentInstantiation
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8393,
 FQN="(anonymous namespace)::CurrentInstantiationRebuilder", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilderE")
//</editor-fold>
public class CurrentInstantiationRebuilder extends /*public*/ TreeTransform<CurrentInstantiationRebuilder> implements Destructors.ClassWithDestructor {
  private SourceLocation Loc;
  private DeclarationName Entity;
/*public:*/
  /*typedef TreeTransform<CurrentInstantiationRebuilder> inherited*/
//  public final class inherited extends TreeTransform<CurrentInstantiationRebuilder>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::CurrentInstantiationRebuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8401,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::CurrentInstantiationRebuilder", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilderC1ERN5clang4SemaENS1_14SourceLocationENS1_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilderC1ERN5clang4SemaENS1_14SourceLocationENS1_15DeclarationNameE")
  //</editor-fold>
  public CurrentInstantiationRebuilder(final Sema /*&*/ SemaRef, 
      SourceLocation Loc, 
      DeclarationName Entity) {
    // : TreeTransform<CurrentInstantiationRebuilder>(SemaRef), Loc(Loc), Entity(Entity) 
    //START JInit
    super(SemaRef);
    this.Loc = new SourceLocation(Loc);
    this.Entity = new DeclarationName(Entity);
    //END JInit
  }

  
  /// \brief Determine whether the given type \p T has already been
  /// transformed.
  ///
  /// For the purposes of type reconstruction, a type has already been
  /// transformed if it is NULL or if it is not dependent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::AlreadyTransformed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8412,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::AlreadyTransformed", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder18AlreadyTransformedEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder18AlreadyTransformedEN5clang8QualTypeE")
  //</editor-fold>
  public boolean AlreadyTransformed(QualType T) {
    return T.isNull() || !T.$arrow().isDependentType();
  }

  
  /// \brief Returns the location of the entity whose type is being
  /// rebuilt.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::getBaseLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8418,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::getBaseLocation", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder15getBaseLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder15getBaseLocationEv")
  //</editor-fold>
  public SourceLocation getBaseLocation() {
    return new SourceLocation(Loc);
  }

  
  /// \brief Returns the name of the entity whose type is being rebuilt.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::getBaseEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8421,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::getBaseEntity", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder13getBaseEntityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder13getBaseEntityEv")
  //</editor-fold>
  public DeclarationName getBaseEntity() {
    return new DeclarationName(Entity);
  }

  
  /// \brief Sets the "base" location and entity when that
  /// information is known based on another transformation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::setBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8425,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::setBase", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder7setBaseEN5clang14SourceLocationENS1_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder7setBaseEN5clang14SourceLocationENS1_15DeclarationNameE")
  //</editor-fold>
  public void setBase(SourceLocation Loc, DeclarationName Entity) {
    this.Loc.$assign(Loc);
    this.Entity.$assign(Entity);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::TransformLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8430,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::TransformLambdaExpr", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder19TransformLambdaExprEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilder19TransformLambdaExprEPN5clang10LambdaExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformLambdaExpr(LambdaExpr /*P*/ E) {
    // Lambdas never need to be transformed.
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CurrentInstantiationRebuilder::~CurrentInstantiationRebuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8393,
   FQN="(anonymous namespace)::CurrentInstantiationRebuilder::~CurrentInstantiationRebuilder", NM="_ZN12_GLOBAL__N_129CurrentInstantiationRebuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN12_GLOBAL__N_129CurrentInstantiationRebuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", Entity=" + Entity // NOI18N
              + super.toString(); // NOI18N
  }
}

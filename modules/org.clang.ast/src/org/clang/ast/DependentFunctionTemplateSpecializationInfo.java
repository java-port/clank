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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clank.java.std;
import org.llvm.adt.java.TrailingObjectsUtils;
import org.llvm.support.TrailingObjects.*;


/// \brief Provides information about a dependent function-template
/// specialization declaration.
///
/// Since explicit function template specialization and instantiation
/// declarations can only appear in namespace scope, and you can only
/// specialize a member of a fully-specialized class, the only way to
/// get one of these is in a friend declaration like the following:
///
/// \code
///   template \<class T> void foo(T);
///   template \<class T> class A {
///     friend void foo<>(T);
///   };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 564,
 FQN="clang::DependentFunctionTemplateSpecializationInfo", NM="_ZN5clang43DependentFunctionTemplateSpecializationInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang43DependentFunctionTemplateSpecializationInfoE")
//</editor-fold>
public final class DependentFunctionTemplateSpecializationInfo implements /*private*/ TrailingObjects2<DependentFunctionTemplateSpecializationInfo, TemplateArgumentLoc, FunctionTemplateDecl /*P*/ > {
  /// The number of potential template candidates.
  private /*uint*/int NumTemplates;
  
  /// The number of template arguments.
  private /*uint*/int NumArgs;
  
  /// The locations of the left and right angle brackets.
  private SourceRange AngleLocs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 577,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::numTrailingObjects", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_19TemplateArgumentLocEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_19TemplateArgumentLocEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$TemplateArgumentLoc(OverloadToken<TemplateArgumentLoc> $Prm0) /*const*/ {
    return NumArgs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 580,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::numTrailingObjects", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_20FunctionTemplateDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_20FunctionTemplateDeclEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$FunctionTemplateDecl$P(OverloadToken<FunctionTemplateDecl /*P*/ > $Prm0) /*const*/ {
    return NumTemplates;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::DependentFunctionTemplateSpecializationInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3256,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::DependentFunctionTemplateSpecializationInfo", NM="_ZN5clang43DependentFunctionTemplateSpecializationInfoC1ERKNS_17UnresolvedSetImplERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang43DependentFunctionTemplateSpecializationInfoC1ERKNS_17UnresolvedSetImplERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  private DependentFunctionTemplateSpecializationInfo(type$ptr<?> $this, final /*const*/ UnresolvedSetImpl /*&*/ Ts, 
      final /*const*/ TemplateArgumentListInfo /*&*/ TArgs) {
    // : TrailingObjects<DependentFunctionTemplateSpecializationInfo, TemplateArgumentLoc, FunctionTemplateDecl * >(), AngleLocs(TArgs.getLAngleLoc(), TArgs.getRAngleLoc()) 
    //START JInit
    $TrailingObjects();
    this.$TrailingObjects = TrailingObjectsUtils.$putThisAndShift(this, $this);
    this.AngleLocs = new SourceRange(TArgs.getLAngleLoc(), TArgs.getRAngleLoc());
    //END JInit
    
    NumTemplates = Ts.size();
    NumArgs = TArgs.size();
    
    type$ptr<FunctionTemplateDecl /*P*/ /*P*/> TsArray = $tryClone(getTrailingObjects(FunctionTemplateDecl /*P*/.class));
    for (/*uint*/int I = 0, E = Ts.size(); I != E; ++I)  {
      TsArray.$set(I, cast_FunctionTemplateDecl(Ts.$at$Const(I).$arrow().getUnderlyingDecl()));
    }
    
    type$ptr<TemplateArgumentLoc/*P*/> ArgsArray = $tryClone(getTrailingObjects(TemplateArgumentLoc.class));
    for (/*uint*/int I = 0, E = TArgs.size(); I != E; ++I)  {
      /*FIXME:NEW_EXPR[System]*/ArgsArray.$set(I,/*new (&ArgsArray[I])*/ new TemplateArgumentLoc(TArgs.$at$Const(I)));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3246,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::Create", NM="_ZN5clang43DependentFunctionTemplateSpecializationInfo6CreateERNS_10ASTContextERKNS_17UnresolvedSetImplERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang43DependentFunctionTemplateSpecializationInfo6CreateERNS_10ASTContextERKNS_17UnresolvedSetImplERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static DependentFunctionTemplateSpecializationInfo /*P*/ Create(final ASTContext /*&*/ Context, final /*const*/ UnresolvedSetImpl /*&*/ Ts, 
        final /*const*/ TemplateArgumentListInfo /*&*/ TArgs) {
    Object/*void P*/ Buffer = Context.Allocate$JavaRef(
            TrailingObjects.totalSizeToAlloc$Same(TemplateArgumentLoc.class, FunctionTemplateDecl.class, TArgs.size(), Ts.size()),
            new std.pairIntPtr<>(1, ()->null), // this
            new std.pairIntPtr<>(TArgs.size(), ()->new TemplateArgumentLoc()), // TemplateArgumentLocs
            new std.pairIntPtr<>(Ts.size(), ()->null) // FunctionTemplateDecl*
    );
    return ((/*JCast*/DependentFunctionTemplateSpecializationInfo /*P*/ )(/*NEW_EXPR [System]*/Buffer = /*new (Buffer)*/ $new_uint_voidPtr(Buffer, (type$ptr<?> New$Mem)->{
        return new DependentFunctionTemplateSpecializationInfo(New$Mem, Ts, TArgs);
    })));
  }

  
  /// \brief Returns the number of function templates that this might
  /// be a specialization of.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getNumTemplates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 595,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getNumTemplates", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo15getNumTemplatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo15getNumTemplatesEv")
  //</editor-fold>
  public /*uint*/int getNumTemplates() /*const*/ {
    return NumTemplates;
  }

  
  /// \brief Returns the i'th template candidate.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 598,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getTemplate", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo11getTemplateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo11getTemplateEj")
  //</editor-fold>
  public FunctionTemplateDecl /*P*/ getTemplate(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumTemplates())) : "template index out of range";
    return getTrailingObjects$Const(FunctionTemplateDecl /*P*/.class).$at(I);
  }

  
  /// \brief Returns the explicit template arguments that were given.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 604,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getTemplateArgs", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    return getTrailingObjects$Const(TemplateArgumentLoc.class);
  }

  
  /// \brief Returns the number of explicit template arguments that were given.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getNumTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 609,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getNumTemplateArgs", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo18getNumTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo18getNumTemplateArgsEv")
  //</editor-fold>
  public /*uint*/int getNumTemplateArgs() /*const*/ {
    return NumArgs;
  }

  
  /// \brief Returns the nth template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getTemplateArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 612,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getTemplateArg", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo14getTemplateArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo14getTemplateArgEj")
  //</editor-fold>
  public /*const*/ TemplateArgumentLoc /*&*/ getTemplateArg(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumTemplateArgs())) : "template arg index out of range";
    return getTemplateArgs().$at(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 617,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getLAngleLoc", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    return AngleLocs.getBegin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentFunctionTemplateSpecializationInfo::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 621,
   FQN="clang::DependentFunctionTemplateSpecializationInfo::getRAngleLoc", NM="_ZNK5clang43DependentFunctionTemplateSpecializationInfo12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang43DependentFunctionTemplateSpecializationInfo12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    return AngleLocs.getEnd();
  }

  
  /*friend  TrailingObjects<DependentFunctionTemplateSpecializationInfo, TemplateArgumentLoc, FunctionTemplateDecl *>*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects_OverloadToken$TemplateArgumentLoc((OverloadToken<TemplateArgumentLoc>)null); 
  }
  
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { 
    return numTrailingObjects_OverloadToken$FunctionTemplateDecl$P((OverloadToken<FunctionTemplateDecl /*P*/ >)null); 
  }
  
  private final type$ptr<?> $TrailingObjects;
    
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return $TrailingObjects;
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == TemplateArgumentLoc.class
            || clazz == FunctionTemplateDecl.class;
    if (clazz == TemplateArgumentLoc.class) {
      return 0;
    }
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumTemplates=" + NumTemplates // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + ", AngleLocs=" + AngleLocs // NOI18N
              + super.toString(); // NOI18N
  }
}

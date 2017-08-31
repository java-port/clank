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
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clank.java.std;
import org.llvm.support.TrailingObjects.*;


/// \brief A reference to a name which we were able to look up during
/// parsing but could not resolve to a specific declaration.
///
/// This arises in several ways:
///   * we might be waiting for argument-dependent lookup;
///   * the name might resolve to an overloaded function;
/// and eventually:
///   * the lookup might have included a function template.
///
/// These never include UnresolvedUsingValueDecls, which are always class
/// members and therefore appear only in UnresolvedMemberLookupExprs.
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2671,
 FQN="clang::UnresolvedLookupExpr", NM="_ZN5clang20UnresolvedLookupExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExprE")
//</editor-fold>
public final class UnresolvedLookupExpr extends /*public*/ OverloadExpr implements /*private*/ TrailingObjects2<UnresolvedLookupExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc> {
  /// True if these lookup results should be extended by
  /// argument-dependent lookup if this is the operand of a function
  /// call.
  /*friend*/public boolean RequiresADL;
  
  /// True if these lookup results are overloaded.  This is pretty
  /// trivially rederivable if we urgently need to kill this field.
  /*friend*/public boolean Overloaded;
  
  /// The naming class (C++ [class.access.base]p5) of the lookup, if
  /// any.  This can generally be recalculated from the context chain,
  /// but that can be fairly expensive for unqualified lookups.  If we
  /// want to improve memory use here, this could go in a union
  /// against the qualified-lookup bits.
  /*friend*/public CXXRecordDecl /*P*/ NamingClass;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2691,
   FQN="clang::UnresolvedLookupExpr::numTrailingObjects", NM="_ZNK5clang20UnresolvedLookupExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedLookupExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_24ASTTemplateKWAndArgsInfoEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<ASTTemplateKWAndArgsInfo> $Prm0) /*const*/ {
    return HasTemplateKWAndArgsInfo ? 1 : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::UnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2695,
   FQN="clang::UnresolvedLookupExpr::UnresolvedLookupExpr", NM="_ZN5clang20UnresolvedLookupExprC1ERKNS_10ASTContextEPNS_13CXXRecordDeclENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEbbPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExprC1ERKNS_10ASTContextEPNS_13CXXRecordDeclENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEbbPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESE_")
  //</editor-fold>
  private UnresolvedLookupExpr(final /*const*/ ASTContext /*&*/ C, 
      CXXRecordDecl /*P*/ NamingClass, 
      NestedNameSpecifierLoc QualifierLoc, 
      SourceLocation TemplateKWLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      boolean RequiresADL, boolean Overloaded, 
      /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs, 
      UnresolvedSetIterator Begin, UnresolvedSetIterator End) {
    // : OverloadExpr(UnresolvedLookupExprClass, C, QualifierLoc, TemplateKWLoc, NameInfo, TemplateArgs, Begin, End, false, false, false), TrailingObjects<UnresolvedLookupExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), RequiresADL(RequiresADL), Overloaded(Overloaded), NamingClass(NamingClass) 
    //START JInit
    super(StmtClass.UnresolvedLookupExprClass, C, new NestedNameSpecifierLoc(QualifierLoc), new SourceLocation(TemplateKWLoc), 
        NameInfo, TemplateArgs, new UnresolvedSetIterator(Begin), new UnresolvedSetIterator(End), false, false, false);
    $TrailingObjects();
    this.RequiresADL = RequiresADL;
    this.Overloaded = Overloaded;
    this.NamingClass = NamingClass;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::UnresolvedLookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2709,
   FQN="clang::UnresolvedLookupExpr::UnresolvedLookupExpr", NM="_ZN5clang20UnresolvedLookupExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  private UnresolvedLookupExpr(EmptyShell Empty) {
    // : OverloadExpr(UnresolvedLookupExprClass, Empty), TrailingObjects<UnresolvedLookupExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>(), RequiresADL(false), Overloaded(false), NamingClass(null) 
    //START JInit
    super(StmtClass.UnresolvedLookupExprClass, new EmptyShell(Empty));
    $TrailingObjects();
    this.RequiresADL = false;
    this.Overloaded = false;
    this.NamingClass = null;
    //END JInit
  }

  
  /*friend  TrailingObjects<UnresolvedLookupExpr, ASTTemplateKWAndArgsInfo, TemplateArgumentLoc>*/
  /*friend  class OverloadExpr*/
  /*friend  class ASTStmtReader*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2719,
   FQN="clang::UnresolvedLookupExpr::Create", NM="_ZN5clang20UnresolvedLookupExpr6CreateERKNS_10ASTContextEPNS_13CXXRecordDeclENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoEbbNS_21UnresolvedSetIteratorESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExpr6CreateERKNS_10ASTContextEPNS_13CXXRecordDeclENS_22NestedNameSpecifierLocERKNS_19DeclarationNameInfoEbbNS_21UnresolvedSetIteratorESA_")
  //</editor-fold>
  public static UnresolvedLookupExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        CXXRecordDecl /*P*/ NamingClass, 
        NestedNameSpecifierLoc QualifierLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        boolean ADL, boolean Overloaded, 
        UnresolvedSetIterator Begin, 
        UnresolvedSetIterator End) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new UnresolvedLookupExpr(C, NamingClass, new NestedNameSpecifierLoc(QualifierLoc), 
                new SourceLocation(), NameInfo, 
                ADL, Overloaded, (/*const*/ TemplateArgumentListInfo /*P*/ )null, new UnresolvedSetIterator(Begin), new UnresolvedSetIterator(End));
     });
  }

  
  
  // UnresolvedLookupExpr
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 212,
   FQN="clang::UnresolvedLookupExpr::Create", NM="_ZN5clang20UnresolvedLookupExpr6CreateERKNS_10ASTContextEPNS_13CXXRecordDeclENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEbPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExpr6CreateERKNS_10ASTContextEPNS_13CXXRecordDeclENS_22NestedNameSpecifierLocENS_14SourceLocationERKNS_19DeclarationNameInfoEbPKNS_24TemplateArgumentListInfoENS_21UnresolvedSetIteratorESE_")
  //</editor-fold>
  public static UnresolvedLookupExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, 
        CXXRecordDecl /*P*/ NamingClass, 
        NestedNameSpecifierLoc QualifierLoc, 
        SourceLocation TemplateKWLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        boolean ADL, 
        /*const*/ TemplateArgumentListInfo /*P*/ Args, 
        UnresolvedSetIterator Begin, 
        UnresolvedSetIterator End) {
    assert ((Args != null) || TemplateKWLoc.isValid());
    /*uint*/int num_args = (Args != null) ? Args.size() : 0;
    
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, 1, num_args);
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size, alignOf(UnresolvedLookupExpr.class),
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>(1, ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>(num_args, ()->new TemplateArgumentLoc())
    );
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new UnresolvedLookupExpr(C, NamingClass, new NestedNameSpecifierLoc(QualifierLoc), 
                new SourceLocation(TemplateKWLoc), NameInfo, 
                ADL, /*Overload*/ true, Args, 
                new UnresolvedSetIterator(Begin), new UnresolvedSetIterator(End));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 236,
   FQN="clang::UnresolvedLookupExpr::CreateEmpty", NM="_ZN5clang20UnresolvedLookupExpr11CreateEmptyERKNS_10ASTContextEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExpr11CreateEmptyERKNS_10ASTContextEbj")
  //</editor-fold>
  public static UnresolvedLookupExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             boolean HasTemplateKWAndArgsInfo, 
             /*uint*/int NumTemplateArgs) {
    assert (NumTemplateArgs == 0 || HasTemplateKWAndArgsInfo);
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(ASTTemplateKWAndArgsInfo.class, TemplateArgumentLoc.class, (HasTemplateKWAndArgsInfo ? 1 : 0), NumTemplateArgs);
    Object/*void P*/ _Mem = C.Allocate$JavaRef(Size, alignOf(UnresolvedLookupExpr.class),
            new std.pairIntPtr<>(1, ()->null), // for this
            new std.pairIntPtr<>((HasTemplateKWAndArgsInfo ? 1 : 0), ()->new ASTTemplateKWAndArgsInfo()),
            new std.pairIntPtr<>(NumTemplateArgs, ()->new TemplateArgumentLoc())
    );
    UnresolvedLookupExpr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new UnresolvedLookupExpr(new EmptyShell());
     });
    E.HasTemplateKWAndArgsInfo = HasTemplateKWAndArgsInfo;
    return E;
  }

  
  /// True if this declaration should be extended by
  /// argument-dependent lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::requiresADL">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2747,
   FQN="clang::UnresolvedLookupExpr::requiresADL", NM="_ZNK5clang20UnresolvedLookupExpr11requiresADLEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedLookupExpr11requiresADLEv")
  //</editor-fold>
  public boolean requiresADL() /*const*/ {
    return RequiresADL;
  }

  
  /// True if this lookup is overloaded.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::isOverloaded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2750,
   FQN="clang::UnresolvedLookupExpr::isOverloaded", NM="_ZNK5clang20UnresolvedLookupExpr12isOverloadedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedLookupExpr12isOverloadedEv")
  //</editor-fold>
  public boolean isOverloaded() /*const*/ {
    return Overloaded;
  }

  
  /// Gets the 'naming class' (in the sense of C++0x
  /// [class.access.base]p5) of the lookup.  This is the scope
  /// that was looked in to find these results.
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::getNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2755,
   FQN="clang::UnresolvedLookupExpr::getNamingClass", NM="_ZNK5clang20UnresolvedLookupExpr14getNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedLookupExpr14getNamingClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getNamingClass() /*const*/ {
    return NamingClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2757,
   FQN="clang::UnresolvedLookupExpr::getLocStart", NM="_ZNK5clang20UnresolvedLookupExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedLookupExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    {
      NestedNameSpecifierLoc l = getQualifierLoc();
      if (l.$bool()) {
        return l.getBeginLoc();
      }
    }
    return getNameInfo().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2762,
   FQN="clang::UnresolvedLookupExpr::getLocEnd", NM="_ZNK5clang20UnresolvedLookupExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang20UnresolvedLookupExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (hasExplicitTemplateArgs()) {
      return getRAngleLoc();
    }
    return getNameInfo().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2768,
   FQN="clang::UnresolvedLookupExpr::children", NM="_ZN5clang20UnresolvedLookupExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedLookupExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2772,
   FQN="clang::UnresolvedLookupExpr::classof", NM="_ZN5clang20UnresolvedLookupExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang20UnresolvedLookupExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.UnresolvedLookupExprClass;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects((OverloadToken<ASTTemplateKWAndArgsInfo>)null); 
  }

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == ASTTemplateKWAndArgsInfo.class 
            || clazz == TemplateArgumentLoc.class;
    if (clazz == ASTTemplateKWAndArgsInfo.class) {
      return 0;
    }
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "RequiresADL=" + RequiresADL // NOI18N
              + ", Overloaded=" + Overloaded // NOI18N
              + ", NamingClass=" + NamingClass // NOI18N
              + super.toString(); // NOI18N
  }
}

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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.java.*;
import org.llvm.support.TrailingObjects.*;


/// NonTypeTemplateParmDecl - Declares a non-type template parameter,
/// e.g., "Size" in
/// @code
/// template<int Size> class array { };
/// @endcode
//<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1140,
 FQN="clang::NonTypeTemplateParmDecl", NM="_ZN5clang23NonTypeTemplateParmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDeclE")
//</editor-fold>
public final class NonTypeTemplateParmDecl extends /*public*/ DeclaratorDecl implements /*protected*/ TemplateParmPosition, /*private*/ TrailingObjects<NonTypeTemplateParmDecl, std.pair<QualType, TypeSourceInfo /*P*/ > >, Common$TemplateParmDecl<NonTypeTemplateParmDecl, Expr/*P*/>, Destructors.ClassWithDestructor {
  /// \brief The default template argument, if any, and whether or not
  /// it was inherited.
  /*typedef DefaultArgStorage<NonTypeTemplateParmDecl, Expr *> DefArgStorage*/
//  public final class DefArgStorage extends DefArgStorage_NonTypeTemplateParmDecl{ };
  private DefArgStorage_NonTypeTemplateParmDecl DefaultArgument;
  
  // FIXME: Collapse this into TemplateParamPosition; or, just move depth/index
  // down here to save memory.
  
  /// \brief Whether this non-type template parameter is a parameter pack.
  /*friend*/public boolean ParameterPack;
  
  /// \brief Whether this non-type template parameter is an "expanded"
  /// parameter pack, meaning that its type is a pack expansion and we
  /// already know the set of types that expansion expands to.
  private boolean ExpandedParameterPack;
  
  /// \brief The number of types in an expanded parameter pack.
  private /*uint*/int NumExpandedTypes;
  
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1164,
   FQN="clang::NonTypeTemplateParmDecl::numTrailingObjects", NM="_ZNK5clang23NonTypeTemplateParmDecl18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenISt4pairINS_8QualTypeEPNS_14TypeSourceInfoEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenISt4pairINS_8QualTypeEPNS_14TypeSourceInfoEEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<std.pair<QualType, TypeSourceInfo /*P*/ > > $Prm0) /*const*/ {
    return NumExpandedTypes;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::NonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1169,
   FQN="clang::NonTypeTemplateParmDecl::NonTypeTemplateParmDecl", NM="_ZN5clang23NonTypeTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationES3_jjPNS_14IdentifierInfoENS_8QualTypeEbPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationES3_jjPNS_14IdentifierInfoENS_8QualTypeEbPNS_14TypeSourceInfoE")
  //</editor-fold>
  private NonTypeTemplateParmDecl(DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, /*uint*/int D, /*uint*/int P, 
      IdentifierInfo /*P*/ Id, QualType T, 
      boolean ParameterPack, TypeSourceInfo /*P*/ TInfo) {
    // : DeclaratorDecl(NonTypeTemplateParm, DC, IdLoc, Id, T, TInfo, StartLoc), TemplateParmPosition(D, P), TrailingObjects<NonTypeTemplateParmDecl, std::pair<QualType, TypeSourceInfo * > >(), DefaultArgument(), ParameterPack(ParameterPack), ExpandedParameterPack(false), NumExpandedTypes(0) 
    //START JInit
    super(Kind.NonTypeTemplateParm, DC, new SourceLocation(IdLoc), new DeclarationName(Id), new QualType(T), TInfo, new SourceLocation(StartLoc));
    this.TemplateParmPosition$Flds = $TemplateParmPosition(D, P);
    $TrailingObjects();
    this.DefaultArgument = new DefArgStorage_NonTypeTemplateParmDecl();
    this.ParameterPack = ParameterPack;
    this.ExpandedParameterPack = false;
    this.NumExpandedTypes = 0;
    //END JInit
  }

  
  
  //===----------------------------------------------------------------------===//
  // NonTypeTemplateParmDecl Method Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::NonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use simple initialization*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 520,
   FQN="clang::NonTypeTemplateParmDecl::NonTypeTemplateParmDecl", NM="_ZN5clang23NonTypeTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationES3_jjPNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEN4llvm8ArrayRefIS6_EENSA_IS8_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationES3_jjPNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEN4llvm8ArrayRefIS6_EENSA_IS8_EE")
  //</editor-fold>
  private NonTypeTemplateParmDecl(DeclContext /*P*/ DC, SourceLocation StartLoc, SourceLocation IdLoc, /*uint*/int D, 
      /*uint*/int P, IdentifierInfo /*P*/ Id, QualType T, TypeSourceInfo /*P*/ TInfo, 
      ArrayRef<QualType> ExpandedTypes, ArrayRef<TypeSourceInfo /*P*/ > ExpandedTInfos) {
    // : DeclaratorDecl(NonTypeTemplateParm, DC, IdLoc, Id, T, TInfo, StartLoc), TemplateParmPosition(D, P), TrailingObjects<NonTypeTemplateParmDecl, std::pair<QualType, TypeSourceInfo * > >(), DefaultArgument(), ParameterPack(true), ExpandedParameterPack(true), NumExpandedTypes(ExpandedTypes.size()) 
    //START JInit
    super(Kind.NonTypeTemplateParm, DC, new SourceLocation(IdLoc), new DeclarationName(Id), new QualType(T), TInfo, new SourceLocation(StartLoc));
    this.TemplateParmPosition$Flds = $TemplateParmPosition(D, P);
    $TrailingObjects();
    this.DefaultArgument = new DefArgStorage_NonTypeTemplateParmDecl();
    this.ParameterPack = true;
    this.ExpandedParameterPack = true;
    this.NumExpandedTypes = ExpandedTypes.size();
    //END JInit
    if (!ExpandedTypes.empty() && !ExpandedTInfos.empty()) {
      type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ >> /*P*/ TypesAndInfos = (type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ >> /*P*/)(type$ptr)getTrailingObjects(std.pairTypePtr.class);
      for (/*uint*/int I = 0; I != NumExpandedTypes; ++I) {
        ///*FIXME: NEW_EXPR [System]*//*AddrOf*/TypesAndInfos.$at(I).first = /*new (&TypesAndInfos[I].first)*/ new QualType(ExpandedTypes.$at(I));
        TypesAndInfos.$at(I).first.$assignMove(/*new (&TypesAndInfos[I].first)*/ new QualType(ExpandedTypes.$at(I)));
        TypesAndInfos.$at(I).second = ExpandedTInfos.$at(I);
      }
    }
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  TrailingObjects<NonTypeTemplateParmDecl, pair<QualType, TypeSourceInfo *> >*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 537,
   FQN="clang::NonTypeTemplateParmDecl::Create", NM="_ZN5clang23NonTypeTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_jjPNS_14IdentifierInfoENS_8QualTypeEbPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_jjPNS_14IdentifierInfoENS_8QualTypeEbPNS_14TypeSourceInfoE")
  //</editor-fold>
  public static NonTypeTemplateParmDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation IdLoc, 
        /*uint*/int D, /*uint*/int P, IdentifierInfo /*P*/ Id, 
        QualType T, boolean ParameterPack, 
        TypeSourceInfo /*P*/ TInfo) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new NonTypeTemplateParmDecl(DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), D, P, Id, 
                new QualType(T), ParameterPack, TInfo);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 547,
   FQN="clang::NonTypeTemplateParmDecl::Create", NM="_ZN5clang23NonTypeTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_jjPNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEN4llvm8ArrayRefIS9_EENSD_ISB_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_jjPNS_14IdentifierInfoENS_8QualTypeEPNS_14TypeSourceInfoEN4llvm8ArrayRefIS9_EENSD_ISB_EE")
  //</editor-fold>
  public static NonTypeTemplateParmDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, SourceLocation StartLoc, 
        SourceLocation IdLoc, /*uint*/int D, /*uint*/int P, IdentifierInfo /*P*/ Id, 
        QualType T, TypeSourceInfo /*P*/ TInfo, ArrayRef<QualType> ExpandedTypes, 
        ArrayRef<TypeSourceInfo /*P*/ > ExpandedTInfos) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<std.pair<QualType, TypeSourceInfo *> >(ExpandedTypes.size()))*/ Decl.$new(C, DC, TrailingObjects.additionalSizeToAlloc$Same(std.pairTypePtr.class, ExpandedTypes.size()), (type$ptr<?> Mem)->{
        return new NonTypeTemplateParmDecl(DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), D, P, Id, new QualType(T), TInfo, 
                new ArrayRef<QualType>(ExpandedTypes), new ArrayRef<TypeSourceInfo /*P*/ >(ExpandedTInfos));
     },
       new std.pairIntPtr<>(ExpandedTypes.size(), ()->new std.pairTypePtr<>(new QualType(), (TypeSourceInfo/*P*/)null)) // for std.pair<QualType, TypeSourceInfo *>
    );
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 559,
   FQN="clang::NonTypeTemplateParmDecl::CreateDeserialized", NM="_ZN5clang23NonTypeTemplateParmDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static NonTypeTemplateParmDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new NonTypeTemplateParmDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), 0, 0, (IdentifierInfo /*P*/ )null, 
                new QualType(), false, (TypeSourceInfo /*P*/ )null);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 566,
   FQN="clang::NonTypeTemplateParmDecl::CreateDeserialized", NM="_ZN5clang23NonTypeTemplateParmDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static NonTypeTemplateParmDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID, 
                    /*uint*/int NumExpandedTypes) {
    NonTypeTemplateParmDecl /*P*/ NTTP = /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<std.pair<QualType, TypeSourceInfo *> >(NumExpandedTypes))*/ Decl.$new(C, ID, TrailingObjects.additionalSizeToAlloc$Same(pair.class, NumExpandedTypes), (type$ptr<?> Mem)->{
        return new NonTypeTemplateParmDecl((DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), 
                0, 0, (IdentifierInfo /*P*/ )null, new QualType(), (TypeSourceInfo /*P*/ )null, new ArrayRef<QualType>(None, false), 
                new ArrayRef<TypeSourceInfo /*P*/ >(None, true));
     },
        new std.pairIntPtr<>(NumExpandedTypes, ()->new std.pairTypePtr<>(new QualType(), (TypeSourceInfo/*P*/)null)) // for std.pair<QualType, TypeSourceInfo *>
    );
    NTTP.NumExpandedTypes = NumExpandedTypes;
    return NTTP;
  }

  
  //JAVA: using TemplateParmPosition::getDepth;
  //JAVA: using TemplateParmPosition::setDepth;
  //JAVA: using TemplateParmPosition::getPosition;
  //JAVA: using TemplateParmPosition::setPosition;
  //JAVA: using TemplateParmPosition::getIndex;
  
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 579,
   FQN="clang::NonTypeTemplateParmDecl::getSourceRange", NM="_ZNK5clang23NonTypeTemplateParmDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (hasDefaultArgument() && !defaultArgumentWasInherited()) {
      return new SourceRange(getOuterLocStart(), 
          getDefaultArgument().getSourceRange().getEnd());
    }
    return super.getSourceRange();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getDefaultArgStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1214,
   FQN="clang::NonTypeTemplateParmDecl::getDefaultArgStorage", NM="_ZNK5clang23NonTypeTemplateParmDecl20getDefaultArgStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl20getDefaultArgStorageEv")
  //</editor-fold>
  @Override public /*const*/DefArgStorage_NonTypeTemplateParmDecl/*&*/ getDefaultArgStorage() /*const*/ {
    return DefaultArgument;
  }

  
  /// \brief Determine whether this template parameter has a default
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::hasDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1218,
   FQN="clang::NonTypeTemplateParmDecl::hasDefaultArgument", NM="_ZNK5clang23NonTypeTemplateParmDecl18hasDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl18hasDefaultArgumentEv")
  //</editor-fold>
  @Override public boolean hasDefaultArgument() /*const*/ {
    return DefaultArgument.isSet();
  }

  
  /// \brief Retrieve the default argument, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1221,
   FQN="clang::NonTypeTemplateParmDecl::getDefaultArgument", NM="_ZNK5clang23NonTypeTemplateParmDecl18getDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl18getDefaultArgumentEv")
  //</editor-fold>
  public Expr /*P*/ getDefaultArgument() /*const*/ {
    return DefaultArgument.get();
  }

  
  /// \brief Retrieve the location of the default argument, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getDefaultArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 586,
   FQN="clang::NonTypeTemplateParmDecl::getDefaultArgumentLoc", NM="_ZNK5clang23NonTypeTemplateParmDecl21getDefaultArgumentLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl21getDefaultArgumentLocEv")
  //</editor-fold>
  public SourceLocation getDefaultArgumentLoc() /*const*/ {
    return hasDefaultArgument() ? getDefaultArgument().getSourceRange().getBegin() : new SourceLocation();
  }

  
  /// \brief Determines whether the default argument was inherited
  /// from a previous declaration of this template.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::defaultArgumentWasInherited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1228,
   FQN="clang::NonTypeTemplateParmDecl::defaultArgumentWasInherited", NM="_ZNK5clang23NonTypeTemplateParmDecl27defaultArgumentWasInheritedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl27defaultArgumentWasInheritedEv")
  //</editor-fold>
  public boolean defaultArgumentWasInherited() /*const*/ {
    return DefaultArgument.isInherited();
  }

  
  /// \brief Set the default argument for this template parameter, and
  /// whether that default argument was inherited from another
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::setDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1235,
   FQN="clang::NonTypeTemplateParmDecl::setDefaultArgument", NM="_ZN5clang23NonTypeTemplateParmDecl18setDefaultArgumentEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl18setDefaultArgumentEPNS_4ExprE")
  //</editor-fold>
  public void setDefaultArgument(Expr /*P*/ DefArg) {
    DefaultArgument.set(DefArg);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::setInheritedDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1236,
   FQN="clang::NonTypeTemplateParmDecl::setInheritedDefaultArgument", NM="_ZN5clang23NonTypeTemplateParmDecl27setInheritedDefaultArgumentERKNS_10ASTContextEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl27setInheritedDefaultArgumentERKNS_10ASTContextEPS0_")
  //</editor-fold>
  public void setInheritedDefaultArgument(final /*const*/ ASTContext /*&*/ C, 
                             NonTypeTemplateParmDecl /*P*/ Parm) {
    DefaultArgument.setInherited(C, Parm);
  }

  
  /// \brief Removes the default argument of this template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::removeDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1242,
   FQN="clang::NonTypeTemplateParmDecl::removeDefaultArgument", NM="_ZN5clang23NonTypeTemplateParmDecl21removeDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl21removeDefaultArgumentEv")
  //</editor-fold>
  public void removeDefaultArgument() {
    DefaultArgument.clear();
  }

  
  /// \brief Whether this parameter is a non-type template parameter pack.
  ///
  /// If the parameter is a parameter pack, the type may be a
  /// \c PackExpansionType. In the following example, the \c Dims parameter
  /// is a parameter pack (whose type is 'unsigned').
  ///
  /// \code
  /// template<typename T, unsigned ...Dims> struct multi_array;
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::isParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1253,
   FQN="clang::NonTypeTemplateParmDecl::isParameterPack", NM="_ZNK5clang23NonTypeTemplateParmDecl15isParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl15isParameterPackEv")
  //</editor-fold>
  public boolean isParameterPack() /*const*/ {
    return ParameterPack;
  }

  
  /// \brief Whether this parameter pack is a pack expansion.
  ///
  /// A non-type template parameter pack is a pack expansion if its type
  /// contains an unexpanded parameter pack. In this case, we will have
  /// built a PackExpansionType wrapping the type.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1260,
   FQN="clang::NonTypeTemplateParmDecl::isPackExpansion", NM="_ZNK5clang23NonTypeTemplateParmDecl15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return ParameterPack && (getType().$arrow().getAs(PackExpansionType.class) != null);
  }

  
  /// \brief Whether this parameter is a non-type template parameter pack
  /// that has a known list of different types at different positions.
  ///
  /// A parameter pack is an expanded parameter pack when the original
  /// parameter pack's type was itself a pack expansion, and that expansion
  /// has already been expanded. For example, given:
  ///
  /// \code
  /// template<typename ...Types>
  /// struct X {
  ///   template<Types ...Values>
  ///   struct Y { /* ... */ };
  /// };
  /// \endcode
  ///
  /// The parameter pack \c Values has a \c PackExpansionType as its type,
  /// which expands \c Types. When \c Types is supplied with template arguments
  /// by instantiating \c X, the instantiation of \c Values becomes an
  /// expanded parameter pack. For example, instantiating
  /// \c X<int, unsigned int> results in \c Values being an expanded parameter
  /// pack with expansion types \c int and \c unsigned int.
  ///
  /// The \c getExpansionType() and \c getExpansionTypeSourceInfo() functions
  /// return the expansion types.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::isExpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1288,
   FQN="clang::NonTypeTemplateParmDecl::isExpandedParameterPack", NM="_ZNK5clang23NonTypeTemplateParmDecl23isExpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl23isExpandedParameterPackEv")
  //</editor-fold>
  public boolean isExpandedParameterPack() /*const*/ {
    return ExpandedParameterPack;
  }

  
  /// \brief Retrieves the number of expansion types in an expanded parameter
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getNumExpansionTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1292,
   FQN="clang::NonTypeTemplateParmDecl::getNumExpansionTypes", NM="_ZNK5clang23NonTypeTemplateParmDecl20getNumExpansionTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl20getNumExpansionTypesEv")
  //</editor-fold>
  public /*uint*/int getNumExpansionTypes() /*const*/ {
    assert (ExpandedParameterPack) : "Not an expansion parameter pack";
    return NumExpandedTypes;
  }

  
  /// \brief Retrieve a particular expansion type within an expanded parameter
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getExpansionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1299,
   FQN="clang::NonTypeTemplateParmDecl::getExpansionType", NM="_ZNK5clang23NonTypeTemplateParmDecl16getExpansionTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl16getExpansionTypeEj")
  //</editor-fold>
  public QualType getExpansionType(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, NumExpandedTypes)) : "Out-of-range expansion type index";
    type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ >> /*P*/ TypesAndInfos = (type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ >> /*P*/)(type$ptr)getTrailingObjects$Const(std.pairTypePtr.class);
    return new QualType(TypesAndInfos.$at(I).first);
  }

  
  /// \brief Retrieve a particular expansion type source info within an
  /// expanded parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::getExpansionTypeSourceInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1308,
   FQN="clang::NonTypeTemplateParmDecl::getExpansionTypeSourceInfo", NM="_ZNK5clang23NonTypeTemplateParmDecl26getExpansionTypeSourceInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang23NonTypeTemplateParmDecl26getExpansionTypeSourceInfoEj")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getExpansionTypeSourceInfo(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, NumExpandedTypes)) : "Out-of-range expansion type index";
    type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ >> /*P*/ TypesAndInfos = (type$ptr<std.pairTypePtr<QualType, TypeSourceInfo /*P*/ >> /*P*/)(type$ptr)getTrailingObjects$Const(std.pairTypePtr.class);
    return TypesAndInfos.$at(I).second;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1316,
   FQN="clang::NonTypeTemplateParmDecl::classof", NM="_ZN5clang23NonTypeTemplateParmDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1317,
   FQN="clang::NonTypeTemplateParmDecl::classofKind", NM="_ZN5clang23NonTypeTemplateParmDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.NonTypeTemplateParm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NonTypeTemplateParmDecl::~NonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1140,
   FQN="clang::NonTypeTemplateParmDecl::~NonTypeTemplateParmDecl", NM="_ZN5clang23NonTypeTemplateParmDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang23NonTypeTemplateParmDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TemplateParmPosition.super.$destroy$TemplateParmPosition();
    TrailingObjects.super.$destroy$TrailingObjects();
  }

  
  private final TemplateParmPosition$Fields TemplateParmPosition$Flds;// use return value of $TemplateParmPosition();
  @Override public final TemplateParmPosition$Fields $TemplateParmPosition$Fields() { return TemplateParmPosition$Flds; }

  @Override
  public type$ptr<?> $TrailingObjects() {
    return $This$Ptr().$add(1); // skip this class
  }
  
  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == std.pairTypePtr.class : "unexpected class " + clazz;
    return 0;
  }

  @Override
  public int getIndex() {
    return TemplateParmPosition.super.getIndex();
  }
  
  @Override public String toString() {
    return "" + "DefaultArgument=" + DefaultArgument // NOI18N
              + ", ParameterPack=" + ParameterPack // NOI18N
              + ", ExpandedParameterPack=" + ExpandedParameterPack // NOI18N
              + ", NumExpandedTypes=" + NumExpandedTypes // NOI18N
              + super.toString(); // NOI18N
  }
}

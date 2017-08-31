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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.java.*;


/// TemplateTemplateParmDecl - Declares a template template parameter,
/// e.g., "T" in
/// @code
/// template <template <typename> class T> class container { };
/// @endcode
/// A template template parameter is a TemplateDecl because it defines the
/// name of a template and the template parameters allowable for substitution.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1327,
 FQN="clang::TemplateTemplateParmDecl", NM="_ZN5clang24TemplateTemplateParmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDeclE")
//</editor-fold>
public final class TemplateTemplateParmDecl extends /*public*/ TemplateDecl implements /*protected*/ TemplateParmPosition, /*private*/ TrailingObjects<TemplateTemplateParmDecl, TemplateParameterList /*P*/ >, Common$TemplateParmDecl<TemplateTemplateParmDecl, TemplateArgumentLoc/*P*/>, Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // TemplateTemplateParmDecl Method Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 596,
   FQN="clang::TemplateTemplateParmDecl::anchor", NM="_ZN5clang24TemplateTemplateParmDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// \brief The default template argument, if any.
  /*typedef DefaultArgStorage<TemplateTemplateParmDecl, TemplateArgumentLoc *> DefArgStorage*/
//  public final class DefArgStorage extends DefArgStorage_TemplateTemplateParmDecl{ };
  private DefArgStorage_TemplateTemplateParmDecl DefaultArgument;
  
  /// \brief Whether this parameter is a parameter pack.
  /*friend*/public boolean ParameterPack;
  
  /// \brief Whether this template template parameter is an "expanded"
  /// parameter pack, meaning that it is a pack expansion and we
  /// already know the set of template parameters that expansion expands to.
  private boolean ExpandedParameterPack;
  
  /// \brief The number of parameters in an expanded parameter pack.
  private /*uint*/int NumExpandedParams;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::TemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1350,
   FQN="clang::TemplateTemplateParmDecl::TemplateTemplateParmDecl", NM="_ZN5clang24TemplateTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationEjjbPNS_14IdentifierInfoEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationEjjbPNS_14IdentifierInfoEPNS_21TemplateParameterListE")
  //</editor-fold>
  private TemplateTemplateParmDecl(DeclContext /*P*/ DC, SourceLocation L, 
      /*uint*/int D, /*uint*/int P, boolean ParameterPack, 
      IdentifierInfo /*P*/ Id, TemplateParameterList /*P*/ Params) {
    // : TemplateDecl(TemplateTemplateParm, DC, L, Id, Params), TemplateParmPosition(D, P), TrailingObjects<TemplateTemplateParmDecl, TemplateParameterList * >(), DefaultArgument(), ParameterPack(ParameterPack), ExpandedParameterPack(false), NumExpandedParams(0) 
    //START JInit
    super(Kind.TemplateTemplateParm, DC, new SourceLocation(L), new DeclarationName(Id), Params);
    this.TemplateParmPosition$Flds = $TemplateParmPosition(D, P);
    $TrailingObjects();
    this.DefaultArgument = new DefArgStorage_TemplateTemplateParmDecl();
    this.ParameterPack = ParameterPack;
    this.ExpandedParameterPack = false;
    this.NumExpandedParams = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::TemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 598,
   FQN="clang::TemplateTemplateParmDecl::TemplateTemplateParmDecl", NM="_ZN5clang24TemplateTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationEjjPNS_14IdentifierInfoEPNS_21TemplateParameterListEN4llvm8ArrayRefIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDeclC1EPNS_11DeclContextENS_14SourceLocationEjjPNS_14IdentifierInfoEPNS_21TemplateParameterListEN4llvm8ArrayRefIS7_EE")
  //</editor-fold>
  private TemplateTemplateParmDecl(DeclContext /*P*/ DC, SourceLocation L, /*uint*/int D, /*uint*/int P, 
      IdentifierInfo /*P*/ Id, TemplateParameterList /*P*/ Params, 
      ArrayRef<TemplateParameterList /*P*/ > Expansions) {
    // : TemplateDecl(TemplateTemplateParm, DC, L, Id, Params), TemplateParmPosition(D, P), TrailingObjects<TemplateTemplateParmDecl, TemplateParameterList * >(), DefaultArgument(), ParameterPack(true), ExpandedParameterPack(true), NumExpandedParams(Expansions.size()) 
    //START JInit
    super(Kind.TemplateTemplateParm, DC, new SourceLocation(L), new DeclarationName(Id), Params);
    this.TemplateParmPosition$Flds = $TemplateParmPosition(D, P);
    $TrailingObjects();
    this.DefaultArgument = new DefArgStorage_TemplateTemplateParmDecl();
    this.ParameterPack = true;
    this.ExpandedParameterPack = true;
    this.NumExpandedParams = Expansions.size();
    //END JInit
    if (!Expansions.empty()) {
      std.uninitialized_copy(Expansions.begin(), Expansions.end(), 
          getTrailingObjects(TemplateParameterList /*P*/.class));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 610,
   FQN="clang::TemplateTemplateParmDecl::Create", NM="_ZN5clang24TemplateTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEjjbPNS_14IdentifierInfoEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEjjbPNS_14IdentifierInfoEPNS_21TemplateParameterListE")
  //</editor-fold>
  public static TemplateTemplateParmDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, /*uint*/int D, /*uint*/int P, 
        boolean ParameterPack, IdentifierInfo /*P*/ Id, 
        TemplateParameterList /*P*/ Params) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new TemplateTemplateParmDecl(DC, new SourceLocation(L), D, P, ParameterPack, Id, 
                Params);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 619,
   FQN="clang::TemplateTemplateParmDecl::Create", NM="_ZN5clang24TemplateTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEjjPNS_14IdentifierInfoEPNS_21TemplateParameterListEN4llvm8ArrayRefISA_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEjjPNS_14IdentifierInfoEPNS_21TemplateParameterListEN4llvm8ArrayRefISA_EE")
  //</editor-fold>
  public static TemplateTemplateParmDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, /*uint*/int D, /*uint*/int P, 
        IdentifierInfo /*P*/ Id, 
        TemplateParameterList /*P*/ Params, 
        ArrayRef<TemplateParameterList /*P*/ > Expansions) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<TemplateParameterList *>(Expansions.size()))*/ Decl.$new(C, DC, TrailingObjects.additionalSizeToAlloc$Same(TemplateParameterList.class, Expansions.size()), (type$ptr<?> Mem)->{
        return new TemplateTemplateParmDecl(DC, new SourceLocation(L), D, P, Id, Params, new ArrayRef<TemplateParameterList /*P*/ >(Expansions));
     },
      new std.pairIntPtr<>(Expansions.size(), ()->null) // for TemplateParameterList *
    );
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 630,
   FQN="clang::TemplateTemplateParmDecl::CreateDeserialized", NM="_ZN5clang24TemplateTemplateParmDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static TemplateTemplateParmDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new TemplateTemplateParmDecl((DeclContext /*P*/ )null, new SourceLocation(), 0, 0, 
                false, (IdentifierInfo /*P*/ )null, (TemplateParameterList /*P*/ )null);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 636,
   FQN="clang::TemplateTemplateParmDecl::CreateDeserialized", NM="_ZN5clang24TemplateTemplateParmDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static TemplateTemplateParmDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID, 
                    /*uint*/int NumExpansions) {
    TemplateTemplateParmDecl /*P*/ TTP = /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<TemplateParameterList *>(NumExpansions))*/ Decl.$new(C, ID, TrailingObjects.additionalSizeToAlloc$Same(TemplateParameterList.class, NumExpansions), (type$ptr<?> Mem)->{
        return new TemplateTemplateParmDecl((DeclContext /*P*/ )null, new SourceLocation(), 0, 0, (IdentifierInfo /*P*/ )null, 
                (TemplateParameterList /*P*/ )null, new ArrayRef<TemplateParameterList /*P*/ >(None, true));
     },
       new std.pairIntPtr<>(NumExpansions, ()->null) // for TemplateParameterList *
    );
    TTP.NumExpandedParams = NumExpansions;
    return TTP;
  }

  
  //JAVA: using TemplateParmPosition::getDepth;
  //JAVA: using TemplateParmPosition::getPosition;
  //JAVA: using TemplateParmPosition::getIndex;
  
  /// \brief Whether this template template parameter is a template
  /// parameter pack.
  ///
  /// \code
  /// template<template <class T> ...MetaFunctions> struct Apply;
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::isParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1392,
   FQN="clang::TemplateTemplateParmDecl::isParameterPack", NM="_ZNK5clang24TemplateTemplateParmDecl15isParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl15isParameterPackEv")
  //</editor-fold>
  public boolean isParameterPack() /*const*/ {
    return ParameterPack;
  }

  
  /// \brief Whether this parameter pack is a pack expansion.
  ///
  /// A template template parameter pack is a pack expansion if its template
  /// parameter list contains an unexpanded parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::isPackExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1398,
   FQN="clang::TemplateTemplateParmDecl::isPackExpansion", NM="_ZNK5clang24TemplateTemplateParmDecl15isPackExpansionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl15isPackExpansionEv")
  //</editor-fold>
  public boolean isPackExpansion() /*const*/ {
    return ParameterPack
       && getTemplateParameters().containsUnexpandedParameterPack();
  }

  
  /// \brief Whether this parameter is a template template parameter pack that
  /// has a known list of different template parameter lists at different
  /// positions.
  ///
  /// A parameter pack is an expanded parameter pack when the original parameter
  /// pack's template parameter list was itself a pack expansion, and that
  /// expansion has already been expanded. For exampe, given:
  ///
  /// \code
  /// template<typename...Types> struct Outer {
  ///   template<template<Types> class...Templates> struct Inner;
  /// };
  /// \endcode
  ///
  /// The parameter pack \c Templates is a pack expansion, which expands the
  /// pack \c Types. When \c Types is supplied with template arguments by
  /// instantiating \c Outer, the instantiation of \c Templates is an expanded
  /// parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::isExpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1421,
   FQN="clang::TemplateTemplateParmDecl::isExpandedParameterPack", NM="_ZNK5clang24TemplateTemplateParmDecl23isExpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl23isExpandedParameterPackEv")
  //</editor-fold>
  public boolean isExpandedParameterPack() /*const*/ {
    return ExpandedParameterPack;
  }

  
  /// \brief Retrieves the number of expansion template parameters in
  /// an expanded parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::getNumExpansionTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1425,
   FQN="clang::TemplateTemplateParmDecl::getNumExpansionTemplateParameters", NM="_ZNK5clang24TemplateTemplateParmDecl33getNumExpansionTemplateParametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl33getNumExpansionTemplateParametersEv")
  //</editor-fold>
  public /*uint*/int getNumExpansionTemplateParameters() /*const*/ {
    assert (ExpandedParameterPack) : "Not an expansion parameter pack";
    return NumExpandedParams;
  }

  
  /// \brief Retrieve a particular expansion type within an expanded parameter
  /// pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::getExpansionTemplateParameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1432,
   FQN="clang::TemplateTemplateParmDecl::getExpansionTemplateParameters", NM="_ZNK5clang24TemplateTemplateParmDecl30getExpansionTemplateParametersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl30getExpansionTemplateParametersEj")
  //</editor-fold>
  public TemplateParameterList /*P*/ getExpansionTemplateParameters(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, NumExpandedParams)) : "Out-of-range expansion type index";
    return getTrailingObjects$Const(TemplateParameterList /*P*/.class).$at(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::getDefaultArgStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1437,
   FQN="clang::TemplateTemplateParmDecl::getDefaultArgStorage", NM="_ZNK5clang24TemplateTemplateParmDecl20getDefaultArgStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl20getDefaultArgStorageEv")
  //</editor-fold>
  @Override public /*const*/DefArgStorage_TemplateTemplateParmDecl/*&*/ getDefaultArgStorage() /*const*/ {
    return DefaultArgument;
  }

  
  /// \brief Determine whether this template parameter has a default
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::hasDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1441,
   FQN="clang::TemplateTemplateParmDecl::hasDefaultArgument", NM="_ZNK5clang24TemplateTemplateParmDecl18hasDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl18hasDefaultArgumentEv")
  //</editor-fold>
  @Override public boolean hasDefaultArgument() /*const*/ {
    return DefaultArgument.isSet();
  }

  
  /// \brief Retrieve the default argument, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::getDefaultArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1444,
   FQN="clang::TemplateTemplateParmDecl::getDefaultArgument", NM="_ZNK5clang24TemplateTemplateParmDecl18getDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl18getDefaultArgumentEv")
  //</editor-fold>
  public /*const*/ TemplateArgumentLoc /*&*/ getDefaultArgument() /*const*/ {
    final/*static*/ /*const*/ TemplateArgumentLoc None = getDefaultArgument$$.None;
    return DefaultArgument.isSet() ? DefaultArgument.get() : None;
  }
  private static final class getDefaultArgument$$ {
    static final/*static*/ /*const*/ TemplateArgumentLoc None/*J*/= new TemplateArgumentLoc();
  }

  
  /// \brief Retrieve the location of the default argument, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::getDefaultArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 647,
   FQN="clang::TemplateTemplateParmDecl::getDefaultArgumentLoc", NM="_ZNK5clang24TemplateTemplateParmDecl21getDefaultArgumentLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl21getDefaultArgumentLocEv")
  //</editor-fold>
  public SourceLocation getDefaultArgumentLoc() /*const*/ {
    return hasDefaultArgument() ? getDefaultArgument().getLocation() : new SourceLocation();
  }

  
  /// \brief Determines whether the default argument was inherited
  /// from a previous declaration of this template.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::defaultArgumentWasInherited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1454,
   FQN="clang::TemplateTemplateParmDecl::defaultArgumentWasInherited", NM="_ZNK5clang24TemplateTemplateParmDecl27defaultArgumentWasInheritedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl27defaultArgumentWasInheritedEv")
  //</editor-fold>
  public boolean defaultArgumentWasInherited() /*const*/ {
    return DefaultArgument.isInherited();
  }

  
  /// \brief Set the default argument for this template parameter, and
  /// whether that default argument was inherited from another
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::setDefaultArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 652,
   FQN="clang::TemplateTemplateParmDecl::setDefaultArgument", NM="_ZN5clang24TemplateTemplateParmDecl18setDefaultArgumentERKNS_10ASTContextERKNS_19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl18setDefaultArgumentERKNS_10ASTContextERKNS_19TemplateArgumentLocE")
  //</editor-fold>
  public void setDefaultArgument(final /*const*/ ASTContext /*&*/ C, final /*const*/ TemplateArgumentLoc /*&*/ DefArg) {
    if (DefArg.getArgument().isNull()) {
      DefaultArgument.set((TemplateArgumentLoc/*P*/)null);
    } else {
      DefaultArgument.set(/*FIXME: NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
          /*new (C)*/ new TemplateArgumentLoc(DefArg));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::setInheritedDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1463,
   FQN="clang::TemplateTemplateParmDecl::setInheritedDefaultArgument", NM="_ZN5clang24TemplateTemplateParmDecl27setInheritedDefaultArgumentERKNS_10ASTContextEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl27setInheritedDefaultArgumentERKNS_10ASTContextEPS0_")
  //</editor-fold>
  public void setInheritedDefaultArgument(final /*const*/ ASTContext /*&*/ C, 
                             TemplateTemplateParmDecl /*P*/ Prev) {
    DefaultArgument.setInherited(C, Prev);
  }

  
  /// \brief Removes the default argument of this template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::removeDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1469,
   FQN="clang::TemplateTemplateParmDecl::removeDefaultArgument", NM="_ZN5clang24TemplateTemplateParmDecl21removeDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl21removeDefaultArgumentEv")
  //</editor-fold>
  public void removeDefaultArgument() {
    DefaultArgument.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1471,
   FQN="clang::TemplateTemplateParmDecl::getSourceRange", NM="_ZNK5clang24TemplateTemplateParmDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24TemplateTemplateParmDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    SourceLocation End = getLocation();
    if (hasDefaultArgument() && !defaultArgumentWasInherited()) {
      End.$assignMove(getDefaultArgument().getSourceRange().getEnd());
    }
    return new SourceRange(getTemplateParameters().getTemplateLoc(), /*NO_COPY*/End);
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1479,
   FQN="clang::TemplateTemplateParmDecl::classof", NM="_ZN5clang24TemplateTemplateParmDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1480,
   FQN="clang::TemplateTemplateParmDecl::classofKind", NM="_ZN5clang24TemplateTemplateParmDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.TemplateTemplateParm;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  /*friend  TrailingObjects<TemplateTemplateParmDecl, TemplateParameterList *>*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTemplateParmDecl::~TemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1327,
   FQN="clang::TemplateTemplateParmDecl::~TemplateTemplateParmDecl", NM="_ZN5clang24TemplateTemplateParmDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24TemplateTemplateParmDeclD0Ev")
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
    assert clazz == TemplateParameterList.class : "unexpected class " + clazz;
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
              + ", NumExpandedParams=" + NumExpandedParams // NOI18N
              + super.toString(); // NOI18N
  }
}

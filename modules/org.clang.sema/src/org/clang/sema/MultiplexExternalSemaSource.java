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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstFunctionPointers.*;


/// \brief An abstract interface that should be implemented by
/// external AST sources that also provide information for semantic
/// analysis.
//<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/MultiplexExternalSemaSource.h", line = 39,
 FQN="clang::MultiplexExternalSemaSource", NM="_ZN5clang27MultiplexExternalSemaSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSourceE")
//</editor-fold>
public class MultiplexExternalSemaSource extends /*public*/ ExternalSemaSource implements Destructors.ClassWithDestructor {
/*private:*/
  private SmallVector<ExternalSemaSource /*P*/ > Sources; // doesn't own them.
/*public:*/
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected MultiplexExternalSemaSource() { /* for derived*/}
  ///\brief Constructs a new multiplexing external sema source and appends the
  /// given element to it.
  ///
  ///\param[in] s1 - A non-null (old) ExternalSemaSource.
  ///\param[in] s2 - A non-null (new) ExternalSemaSource.
  ///
  
  ///\brief Constructs a new multiplexing external sema source and appends the
  /// given element to it.
  ///
  ///\param[in] source - An ExternalSemaSource.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::MultiplexExternalSemaSource">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 24,
   FQN="clang::MultiplexExternalSemaSource::MultiplexExternalSemaSource", NM="_ZN5clang27MultiplexExternalSemaSourceC1ERNS_18ExternalSemaSourceES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSourceC1ERNS_18ExternalSemaSourceES2_")
  //</editor-fold>
  public MultiplexExternalSemaSource(final ExternalSemaSource /*&*/ s1, 
      final ExternalSemaSource /*&*/ s2) {
    super();
    $MultiplexExternalSemaSource(s1, s2);
  }
  public void $MultiplexExternalSemaSource(ExternalSemaSource /*&*/ s1, 
      ExternalSemaSource /*&*/ s2) {
    // : ExternalSemaSource(), Sources() 
    //START JInit
    this.Sources = new SmallVector<ExternalSemaSource /*P*/ >(2, (ExternalSemaSource /*P*/ )null);
    //END JInit
    Sources.push_back($AddrOf(s1));
    Sources.push_back($AddrOf(s2));
  }

  
  
  // pin the vtable here.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::~MultiplexExternalSemaSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 31,
   FQN="clang::MultiplexExternalSemaSource::~MultiplexExternalSemaSource", NM="_ZN5clang27MultiplexExternalSemaSourceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSourceD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    Sources.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  ///\brief Appends new source to the source list.
  ///
  ///\param[in] source - An ExternalSemaSource.
  ///
  
  ///\brief Appends new source to the source list.
  ///
  ///\param[in] source - An ExternalSemaSource.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::addSource">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 37,
   FQN="clang::MultiplexExternalSemaSource::addSource", NM="_ZN5clang27MultiplexExternalSemaSource9addSourceERNS_18ExternalSemaSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource9addSourceERNS_18ExternalSemaSourceE")
  //</editor-fold>
  public void addSource(final ExternalSemaSource /*&*/ source) {
    Sources.push_back($AddrOf(source));
  }

  
  //===--------------------------------------------------------------------===//
  // ExternalASTSource.
  //===--------------------------------------------------------------------===//
  
  /// \brief Resolve a declaration ID into a declaration, potentially
  /// building a new declaration.
  
  //===----------------------------------------------------------------------===//
  // ExternalASTSource.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::GetExternalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 45,
   FQN="clang::MultiplexExternalSemaSource::GetExternalDecl", NM="_ZN5clang27MultiplexExternalSemaSource15GetExternalDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource15GetExternalDeclEj")
  //</editor-fold>
  @Override public Decl /*P*/ GetExternalDecl(/*uint32_t*/long ID)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      {
        Decl /*P*/ Result = Sources.$at(i).GetExternalDecl(ID);
        if (bool$ptr(Result)) {
          return Result;
        }
      }
    }
    return null;
  }

  
  /// \brief Complete the redeclaration chain if it's been extended since the
  /// previous generation of the AST source.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::CompleteRedeclChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 52,
   FQN="clang::MultiplexExternalSemaSource::CompleteRedeclChain", NM="_ZN5clang27MultiplexExternalSemaSource19CompleteRedeclChainEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource19CompleteRedeclChainEPKNS_4DeclE")
  //</editor-fold>
  @Override public void CompleteRedeclChain(/*const*/ Decl /*P*/ D)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).CompleteRedeclChain(D);
    }
  }

  
  /// \brief Resolve a selector ID into a selector.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::GetExternalSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 57,
   FQN="clang::MultiplexExternalSemaSource::GetExternalSelector", NM="_ZN5clang27MultiplexExternalSemaSource19GetExternalSelectorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource19GetExternalSelectorEj")
  //</editor-fold>
  @Override public Selector GetExternalSelector(/*uint32_t*/int ID)/* override*/ {
    Selector Sel/*J*/= new Selector();
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i) {
      Sel.$assignMove(Sources.$at(i).GetExternalSelector(ID));
      if (!Sel.isNull()) {
        return Sel;
      }
    }
    return Sel;
  }

  
  /// \brief Returns the number of selectors known to the external AST
  /// source.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::GetNumExternalSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 67,
   FQN="clang::MultiplexExternalSemaSource::GetNumExternalSelectors", NM="_ZN5clang27MultiplexExternalSemaSource23GetNumExternalSelectorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource23GetNumExternalSelectorsEv")
  //</editor-fold>
  @Override public /*uint32_t*/int GetNumExternalSelectors()/* override*/ {
    /*uint32_t*/int total = 0;
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      total += Sources.$at(i).GetNumExternalSelectors();
    }
    return total;
  }

  
  /// \brief Resolve the offset of a statement in the decl stream into
  /// a statement.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::GetExternalDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 74,
   FQN="clang::MultiplexExternalSemaSource::GetExternalDeclStmt", NM="_ZN5clang27MultiplexExternalSemaSource19GetExternalDeclStmtEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource19GetExternalDeclStmtEy")
  //</editor-fold>
  @Override public Stmt /*P*/ GetExternalDeclStmt(long/*uint64_t*/ Offset)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      {
        Stmt /*P*/ Result = Sources.$at(i).GetExternalDeclStmt(Offset);
        if ((Result != null)) {
          return Result;
        }
      }
    }
    return null;
  }

  
  /// \brief Resolve the offset of a set of C++ base specifiers in the decl
  /// stream into an array of specifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::GetExternalCXXBaseSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 81,
   FQN="clang::MultiplexExternalSemaSource::GetExternalCXXBaseSpecifiers", NM="_ZN5clang27MultiplexExternalSemaSource28GetExternalCXXBaseSpecifiersEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource28GetExternalCXXBaseSpecifiersEy")
  //</editor-fold>
  @Override public type$ptr<CXXBaseSpecifier /*P*/> GetExternalCXXBaseSpecifiers(long/*uint64_t*/ Offset)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      {
        type$ptr<CXXBaseSpecifier /*P*/> R = Sources.$at(i).GetExternalCXXBaseSpecifiers(Offset);
        if (Native.$bool(R)) {
          return R;
        }
      }
    }
    return null;
  }

  
  /// \brief Resolve a handle to a list of ctor initializers into the list of
  /// initializers themselves.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::GetExternalCXXCtorInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 89,
   FQN="clang::MultiplexExternalSemaSource::GetExternalCXXCtorInitializers", NM="_ZN5clang27MultiplexExternalSemaSource30GetExternalCXXCtorInitializersEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource30GetExternalCXXCtorInitializersEy")
  //</editor-fold>
  @Override public type$ptr<CXXCtorInitializer /*P*/ /*P*/> GetExternalCXXCtorInitializers(long/*uint64_t*/ Offset)/* override*/ {
    for (ExternalSemaSource /*P*/ S : Sources)  {
      {
        type$ptr<CXXCtorInitializer /*P*/ /*P*/> R = $tryClone(S.GetExternalCXXCtorInitializers(Offset));
        if (Native.$bool(R)) {
          return R;
        }
      }
    }
    return null;
  }

  
  /// \brief Find all declarations with the given name in the
  /// given context.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::FindExternalVisibleDeclsByName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 97,
   FQN="clang::MultiplexExternalSemaSource::FindExternalVisibleDeclsByName", NM="_ZN5clang27MultiplexExternalSemaSource30FindExternalVisibleDeclsByNameEPKNS_11DeclContextENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource30FindExternalVisibleDeclsByNameEPKNS_11DeclContextENS_15DeclarationNameE")
  //</editor-fold>
  @Override public boolean FindExternalVisibleDeclsByName(/*const*/ DeclContext /*P*/ DC, DeclarationName Name)/* override*/ {
    boolean AnyDeclsFound = false;
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      AnyDeclsFound |= Sources.$at(i).FindExternalVisibleDeclsByName(DC, new DeclarationName(Name));
    }
    return AnyDeclsFound;
  }

  
  /// \brief Ensures that the table of all visible declarations inside this
  /// context is up to date.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::completeVisibleDeclsMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 105,
   FQN="clang::MultiplexExternalSemaSource::completeVisibleDeclsMap", NM="_ZN5clang27MultiplexExternalSemaSource23completeVisibleDeclsMapEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource23completeVisibleDeclsMapEPKNS_11DeclContextE")
  //</editor-fold>
  @Override public void completeVisibleDeclsMap(/*const*/ DeclContext /*P*/ DC)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).completeVisibleDeclsMap(DC);
    }
  }

  
  /// \brief Finds all declarations lexically contained within the given
  /// DeclContext, after applying an optional filter predicate.
  ///
  /// \param IsKindWeWant a predicate function that returns true if the passed
  /// declaration kind is one we are looking for.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::FindExternalLexicalDecls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 110,
   FQN="clang::MultiplexExternalSemaSource::FindExternalLexicalDecls", NM="_ZN5clang27MultiplexExternalSemaSource24FindExternalLexicalDeclsEPKNS_11DeclContextEN4llvm12function_refIFbNS_4Decl4KindEEEERNS4_15SmallVectorImplIPS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource24FindExternalLexicalDeclsEPKNS_11DeclContextEN4llvm12function_refIFbNS_4Decl4KindEEEERNS4_15SmallVectorImplIPS6_EE")
  //</editor-fold>
  @Override public void FindExternalLexicalDecls(/*const*/ DeclContext /*P*/ DC, DeclKind2Bool IsKindWeWant, 
                          final SmallVectorImpl<Decl /*P*/ > /*&*/ Result)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).FindExternalLexicalDecls(DC, IsKindWeWant, Result);
    }
  }

  
  /// \brief Get the decls that are contained in a file in the Offset/Length
  /// range. \p Length can be 0 to indicate a point at \p Offset instead of
  /// a range. 
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::FindFileRegionDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 117,
   FQN="clang::MultiplexExternalSemaSource::FindFileRegionDecls", NM="_ZN5clang27MultiplexExternalSemaSource19FindFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource19FindFileRegionDeclsENS_6FileIDEjjRN4llvm15SmallVectorImplIPNS_4DeclEEE")
  //</editor-fold>
  @Override public void FindFileRegionDecls(FileID File, 
                     /*uint*/int Offset, 
                     /*uint*/int Length, 
                     final SmallVectorImpl<Decl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).FindFileRegionDecls(new FileID(File), Offset, Length, Decls);
    }
  }

  
  /// \brief Gives the external AST source an opportunity to complete
  /// an incomplete type.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::CompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 125,
   FQN="clang::MultiplexExternalSemaSource::CompleteType", NM="_ZN5clang27MultiplexExternalSemaSource12CompleteTypeEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource12CompleteTypeEPNS_7TagDeclE")
  //</editor-fold>
  @Override public void CompleteType(TagDecl /*P*/ Tag)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).CompleteType(Tag);
    }
  }

  
  /// \brief Gives the external AST source an opportunity to complete an
  /// incomplete Objective-C class.
  ///
  /// This routine will only be invoked if the "externally completed" bit is
  /// set on the ObjCInterfaceDecl via the function 
  /// \c ObjCInterfaceDecl::setExternallyCompleted().
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::CompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 130,
   FQN="clang::MultiplexExternalSemaSource::CompleteType", NM="_ZN5clang27MultiplexExternalSemaSource12CompleteTypeEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource12CompleteTypeEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  @Override public void CompleteType(ObjCInterfaceDecl /*P*/ Class)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).CompleteType(Class);
    }
  }

  
  /// \brief Loads comment ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 135,
   FQN="clang::MultiplexExternalSemaSource::ReadComments", NM="_ZN5clang27MultiplexExternalSemaSource12ReadCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource12ReadCommentsEv")
  //</editor-fold>
  @Override public void ReadComments()/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadComments();
    }
  }

  
  /// \brief Notify ExternalASTSource that we started deserialization of
  /// a decl or type so until FinishedDeserializing is called there may be
  /// decls that are initializing. Must be paired with FinishedDeserializing.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::StartedDeserializing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 140,
   FQN="clang::MultiplexExternalSemaSource::StartedDeserializing", NM="_ZN5clang27MultiplexExternalSemaSource20StartedDeserializingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource20StartedDeserializingEv")
  //</editor-fold>
  @Override public void StartedDeserializing()/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).StartedDeserializing();
    }
  }

  
  /// \brief Notify ExternalASTSource that we finished the deserialization of
  /// a decl or type. Must be paired with StartedDeserializing.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::FinishedDeserializing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 145,
   FQN="clang::MultiplexExternalSemaSource::FinishedDeserializing", NM="_ZN5clang27MultiplexExternalSemaSource21FinishedDeserializingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource21FinishedDeserializingEv")
  //</editor-fold>
  @Override public void FinishedDeserializing()/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).FinishedDeserializing();
    }
  }

  
  /// \brief Function that will be invoked when we begin parsing a new
  /// translation unit involving this external AST source.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::StartTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 150,
   FQN="clang::MultiplexExternalSemaSource::StartTranslationUnit", NM="_ZN5clang27MultiplexExternalSemaSource20StartTranslationUnitEPNS_11ASTConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource20StartTranslationUnitEPNS_11ASTConsumerE")
  //</editor-fold>
  @Override public void StartTranslationUnit(ASTConsumer /*P*/ Consumer)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).StartTranslationUnit(Consumer);
    }
  }

  
  /// \brief Print any statistics that have been gathered regarding
  /// the external AST source.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 155,
   FQN="clang::MultiplexExternalSemaSource::PrintStats", NM="_ZN5clang27MultiplexExternalSemaSource10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource10PrintStatsEv")
  //</editor-fold>
  @Override public void PrintStats()/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).PrintStats();
    }
  }

  
  /// \brief Perform layout on the given record.
  ///
  /// This routine allows the external AST source to provide an specific 
  /// layout for a record, overriding the layout that would normally be
  /// constructed. It is intended for clients who receive specific layout
  /// details rather than source code (such as LLDB). The client is expected
  /// to fill in the field offsets, base offsets, virtual base offsets, and
  /// complete object size.
  ///
  /// \param Record The record whose layout is being requested.
  ///
  /// \param Size The final size of the record, in bits.
  ///
  /// \param Alignment The final alignment of the record, in bits.
  ///
  /// \param FieldOffsets The offset of each of the fields within the record,
  /// expressed in bits. All of the fields must be provided with offsets.
  ///
  /// \param BaseOffsets The offset of each of the direct, non-virtual base
  /// classes. If any bases are not given offsets, the bases will be laid 
  /// out according to the ABI.
  ///
  /// \param VirtualBaseOffsets The offset of each of the virtual base classes
  /// (either direct or not). If any bases are not given offsets, the bases will 
  /// be laid out according to the ABI.
  /// 
  /// \returns true if the record layout was provided, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::layoutRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 160,
   FQN="clang::MultiplexExternalSemaSource::layoutRecordType", NM="_ZN5clang27MultiplexExternalSemaSource16layoutRecordTypeEPKNS_10RecordDeclERyS4_RN4llvm8DenseMapIPKNS_9FieldDeclEyNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_yEEEERNS6_IPKNS_13CXXRecordDeclENS_9CharUnitsENSA_ISJ_EENSD_ISJ_SK_EEEESO_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource16layoutRecordTypeEPKNS_10RecordDeclERyS4_RN4llvm8DenseMapIPKNS_9FieldDeclEyNS5_12DenseMapInfoIS9_EENS5_6detail12DenseMapPairIS9_yEEEERNS6_IPKNS_13CXXRecordDeclENS_9CharUnitsENSA_ISJ_EENSD_ISJ_SK_EEEESO_")
  //</editor-fold>
  @Override public boolean layoutRecordType(/*const*/ RecordDecl /*P*/ Record, 
                  final ulong$ref/*uint64_t &*/ Size, 
                  final ulong$ref/*uint64_t &*/ Alignment, 
                  final DenseMapTypeULong</*const*/ FieldDecl /*P*/>/*&*/ FieldOffsets, 
                  final DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ BaseOffsets, 
                  final DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ VirtualBaseOffsets)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      if (Sources.$at(i).layoutRecordType(Record, Size, Alignment, FieldOffsets, 
          BaseOffsets, VirtualBaseOffsets)) {
        return true;
      }
    }
    return false;
  }

  
  /// Return the amount of memory used by memory buffers, breaking down
  /// by heap-backed versus mmap'ed memory.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::getMemoryBufferSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 173,
   FQN="clang::MultiplexExternalSemaSource::getMemoryBufferSizes", NM="_ZNK5clang27MultiplexExternalSemaSource20getMemoryBufferSizesERNS_17ExternalASTSource17MemoryBufferSizesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZNK5clang27MultiplexExternalSemaSource20getMemoryBufferSizesERNS_17ExternalASTSource17MemoryBufferSizesE")
  //</editor-fold>
  @Override public void getMemoryBufferSizes(final MemoryBufferSizes /*&*/ sizes) /*const*//* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at$Const(i).getMemoryBufferSizes(sizes);
    }
  }

  
  //===--------------------------------------------------------------------===//
  // ExternalSemaSource.
  //===--------------------------------------------------------------------===//
  
  /// \brief Initialize the semantic source with the Sema instance
  /// being used to perform semantic analysis on the abstract syntax
  /// tree.
  
  //===----------------------------------------------------------------------===//
  // ExternalSemaSource.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::InitializeSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 185,
   FQN="clang::MultiplexExternalSemaSource::InitializeSema", NM="_ZN5clang27MultiplexExternalSemaSource14InitializeSemaERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource14InitializeSemaERNS_4SemaE")
  //</editor-fold>
  @Override public void InitializeSema(final Sema /*&*/ S)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).InitializeSema(S);
    }
  }

  
  /// \brief Inform the semantic consumer that Sema is no longer available.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ForgetSema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 190,
   FQN="clang::MultiplexExternalSemaSource::ForgetSema", NM="_ZN5clang27MultiplexExternalSemaSource10ForgetSemaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource10ForgetSemaEv")
  //</editor-fold>
  @Override public void ForgetSema()/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ForgetSema();
    }
  }

  
  /// \brief Load the contents of the global method pool for a given
  /// selector.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadMethodPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 195,
   FQN="clang::MultiplexExternalSemaSource::ReadMethodPool", NM="_ZN5clang27MultiplexExternalSemaSource14ReadMethodPoolENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource14ReadMethodPoolENS_8SelectorE")
  //</editor-fold>
  @Override public void ReadMethodPool(Selector Sel)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadMethodPool(new Selector(Sel));
    }
  }

  
  /// Load the contents of the global method pool for a given
  /// selector if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::updateOutOfDateSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 200,
   FQN="clang::MultiplexExternalSemaSource::updateOutOfDateSelector", NM="_ZN5clang27MultiplexExternalSemaSource23updateOutOfDateSelectorENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource23updateOutOfDateSelectorENS_8SelectorE")
  //</editor-fold>
  @Override public void updateOutOfDateSelector(Selector Sel)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).updateOutOfDateSelector(new Selector(Sel));
    }
  }

  
  /// \brief Load the set of namespaces that are known to the external source,
  /// which will be used during typo correction.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadKnownNamespaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 205,
   FQN="clang::MultiplexExternalSemaSource::ReadKnownNamespaces", NM="_ZN5clang27MultiplexExternalSemaSource19ReadKnownNamespacesERN4llvm15SmallVectorImplIPNS_13NamespaceDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource19ReadKnownNamespacesERN4llvm15SmallVectorImplIPNS_13NamespaceDeclEEE")
  //</editor-fold>
  @Override public void ReadKnownNamespaces(final SmallVectorImpl<NamespaceDecl /*P*/ > /*&*/ Namespaces)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadKnownNamespaces(Namespaces);
    }
  }

  
  /// \brief Load the set of used but not defined functions or variables with
  /// internal linkage, or used but not defined inline functions.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadUndefinedButUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 211,
   FQN="clang::MultiplexExternalSemaSource::ReadUndefinedButUsed", NM="_ZN5clang27MultiplexExternalSemaSource20ReadUndefinedButUsedERN4llvm9MapVectorIPNS_9NamedDeclENS_14SourceLocationENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S5_ESaISF_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource20ReadUndefinedButUsedERN4llvm9MapVectorIPNS_9NamedDeclENS_14SourceLocationENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S5_ESaISF_EEEE")
  //</editor-fold>
  @Override public void ReadUndefinedButUsed(final MapVectorPtrType<NamedDecl /*P*/ , SourceLocation> /*&*/ Undefined)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadUndefinedButUsed(Undefined);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadMismatchingDeleteExpressions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 217,
   FQN="clang::MultiplexExternalSemaSource::ReadMismatchingDeleteExpressions", NM="_ZN5clang27MultiplexExternalSemaSource32ReadMismatchingDeleteExpressionsERN4llvm9MapVectorIPNS_9FieldDeclENS1_11SmallVectorISt4pairINS_14SourceLocationEbELj4EEENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorIS6_IS4_S9_ESaISI_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource32ReadMismatchingDeleteExpressionsERN4llvm9MapVectorIPNS_9FieldDeclENS1_11SmallVectorISt4pairINS_14SourceLocationEbELj4EEENS1_8DenseMapIS4_jNS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_jEEEESt6vectorIS6_IS4_S9_ESaISI_EEEE")
  //</editor-fold>
  @Override public void ReadMismatchingDeleteExpressions(final MapVectorPtrType<FieldDecl /*P*/ , SmallVector<std.pairTypeBool<SourceLocation>> > /*&*/ Exprs)/* override*/ {
    for (final ExternalSemaSource /*P*/ /*&*/ Source : Sources)  {
      Source.ReadMismatchingDeleteExpressions(Exprs);
    }
  }

  
  /// \brief Do last resort, unqualified lookup on a LookupResult that
  /// Sema cannot find.
  ///
  /// \param R a LookupResult that is being recovered.
  ///
  /// \param S the Scope of the identifier occurrence.
  ///
  /// \return true to tell Sema to recover using the LookupResult.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::LookupUnqualified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 225,
   FQN="clang::MultiplexExternalSemaSource::LookupUnqualified", NM="_ZN5clang27MultiplexExternalSemaSource17LookupUnqualifiedERNS_12LookupResultEPNS_5ScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource17LookupUnqualifiedERNS_12LookupResultEPNS_5ScopeE")
  //</editor-fold>
  @Override public boolean LookupUnqualified(final LookupResult /*&*/ R, Scope /*P*/ S)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).LookupUnqualified(R, S);
    }
    
    return !R.empty();
  }

  
  /// \brief Read the set of tentative definitions known to the external Sema
  /// source.
  ///
  /// The external source should append its own tentative definitions to the
  /// given vector of tentative definitions. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadTentativeDefinitions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 232,
   FQN="clang::MultiplexExternalSemaSource::ReadTentativeDefinitions", NM="_ZN5clang27MultiplexExternalSemaSource24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIPNS_7VarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIPNS_7VarDeclEEE")
  //</editor-fold>
  @Override public void ReadTentativeDefinitions(final SmallVectorImpl<VarDecl /*P*/ > /*&*/ TentativeDefs)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadTentativeDefinitions(TentativeDefs);
    }
  }

  
  /// \brief Read the set of unused file-scope declarations known to the
  /// external Sema source.
  ///
  /// The external source should append its own unused, filed-scope to the
  /// given vector of declarations. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadUnusedFileScopedDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 238,
   FQN="clang::MultiplexExternalSemaSource::ReadUnusedFileScopedDecls", NM="_ZN5clang27MultiplexExternalSemaSource25ReadUnusedFileScopedDeclsERN4llvm15SmallVectorImplIPKNS_14DeclaratorDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource25ReadUnusedFileScopedDeclsERN4llvm15SmallVectorImplIPKNS_14DeclaratorDeclEEE")
  //</editor-fold>
  @Override public void ReadUnusedFileScopedDecls(final SmallVectorImpl</*const*/ DeclaratorDecl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadUnusedFileScopedDecls(Decls);
    }
  }

  
  /// \brief Read the set of delegating constructors known to the
  /// external Sema source.
  ///
  /// The external source should append its own delegating constructors to the
  /// given vector of declarations. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadDelegatingConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 244,
   FQN="clang::MultiplexExternalSemaSource::ReadDelegatingConstructors", NM="_ZN5clang27MultiplexExternalSemaSource26ReadDelegatingConstructorsERN4llvm15SmallVectorImplIPNS_18CXXConstructorDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource26ReadDelegatingConstructorsERN4llvm15SmallVectorImplIPNS_18CXXConstructorDeclEEE")
  //</editor-fold>
  @Override public void ReadDelegatingConstructors(final SmallVectorImpl<CXXConstructorDecl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadDelegatingConstructors(Decls);
    }
  }

  
  /// \brief Read the set of ext_vector type declarations known to the
  /// external Sema source.
  ///
  /// The external source should append its own ext_vector type declarations to
  /// the given vector of declarations. Note that this routine may be
  /// invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadExtVectorDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 250,
   FQN="clang::MultiplexExternalSemaSource::ReadExtVectorDecls", NM="_ZN5clang27MultiplexExternalSemaSource18ReadExtVectorDeclsERN4llvm15SmallVectorImplIPNS_15TypedefNameDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource18ReadExtVectorDeclsERN4llvm15SmallVectorImplIPNS_15TypedefNameDeclEEE")
  //</editor-fold>
  @Override public void ReadExtVectorDecls(final SmallVectorImpl<TypedefNameDecl /*P*/ > /*&*/ Decls)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadExtVectorDecls(Decls);
    }
  }

  
  /// \brief Read the set of potentially unused typedefs known to the source.
  ///
  /// The external source should append its own potentially unused local
  /// typedefs to the given vector of declarations. Note that this routine may
  /// be invoked multiple times; the external source should take care not to
  /// introduce the same declarations repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadUnusedLocalTypedefNameCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 256,
   FQN="clang::MultiplexExternalSemaSource::ReadUnusedLocalTypedefNameCandidates", NM="_ZN5clang27MultiplexExternalSemaSource36ReadUnusedLocalTypedefNameCandidatesERN4llvm14SmallSetVectorIPKNS_15TypedefNameDeclELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource36ReadUnusedLocalTypedefNameCandidatesERN4llvm14SmallSetVectorIPKNS_15TypedefNameDeclELj4EEE")
  //</editor-fold>
  @Override public void ReadUnusedLocalTypedefNameCandidates(final SmallSetVector</*const*/ TypedefNameDecl /*P*/> /*&*/ Decls)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadUnusedLocalTypedefNameCandidates(Decls);
    }
  }

  
  /// \brief Read the set of referenced selectors known to the
  /// external Sema source.
  ///
  /// The external source should append its own referenced selectors to the 
  /// given vector of selectors. Note that this routine 
  /// may be invoked multiple times; the external source should take care not 
  /// to introduce the same selectors repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadReferencedSelectors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 262,
   FQN="clang::MultiplexExternalSemaSource::ReadReferencedSelectors", NM="_ZN5clang27MultiplexExternalSemaSource23ReadReferencedSelectorsERN4llvm15SmallVectorImplISt4pairINS_8SelectorENS_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource23ReadReferencedSelectorsERN4llvm15SmallVectorImplISt4pairINS_8SelectorENS_14SourceLocationEEEE")
  //</editor-fold>
  @Override public void ReadReferencedSelectors(final SmallVectorImpl<std.pairTypeType<Selector, SourceLocation> > /*&*/ Sels)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadReferencedSelectors(Sels);
    }
  }

  
  /// \brief Read the set of weak, undeclared identifiers known to the
  /// external Sema source.
  ///
  /// The external source should append its own weak, undeclared identifiers to
  /// the given vector. Note that this routine may be invoked multiple times; 
  /// the external source should take care not to introduce the same identifiers
  /// repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadWeakUndeclaredIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 268,
   FQN="clang::MultiplexExternalSemaSource::ReadWeakUndeclaredIdentifiers", NM="_ZN5clang27MultiplexExternalSemaSource29ReadWeakUndeclaredIdentifiersERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoENS_8WeakInfoEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource29ReadWeakUndeclaredIdentifiersERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoENS_8WeakInfoEEEE")
  //</editor-fold>
  @Override public void ReadWeakUndeclaredIdentifiers(final SmallVectorImpl<std.pairPtrType<IdentifierInfo /*P*/ , WeakInfo> > /*&*/ WI)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadWeakUndeclaredIdentifiers(WI);
    }
  }

  
  /// \brief Read the set of used vtables known to the external Sema source.
  ///
  /// The external source should append its own used vtables to the given
  /// vector. Note that this routine may be invoked multiple times; the external
  /// source should take care not to introduce the same vtables repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadUsedVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 274,
   FQN="clang::MultiplexExternalSemaSource::ReadUsedVTables", NM="_ZN5clang27MultiplexExternalSemaSource15ReadUsedVTablesERN4llvm15SmallVectorImplINS_17ExternalVTableUseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource15ReadUsedVTablesERN4llvm15SmallVectorImplINS_17ExternalVTableUseEEE")
  //</editor-fold>
  @Override public void ReadUsedVTables(final SmallVectorImpl<ExternalVTableUse> /*&*/ VTables)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadUsedVTables(VTables);
    }
  }

  
  /// \brief Read the set of pending instantiations known to the external
  /// Sema source.
  ///
  /// The external source should append its own pending instantiations to the
  /// given vector. Note that this routine may be invoked multiple times; the
  /// external source should take care not to introduce the same instantiations
  /// repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadPendingInstantiations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 280,
   FQN="clang::MultiplexExternalSemaSource::ReadPendingInstantiations", NM="_ZN5clang27MultiplexExternalSemaSource25ReadPendingInstantiationsERN4llvm15SmallVectorImplISt4pairIPNS_9ValueDeclENS_14SourceLocationEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource25ReadPendingInstantiationsERN4llvm15SmallVectorImplISt4pairIPNS_9ValueDeclENS_14SourceLocationEEEE")
  //</editor-fold>
  @Override public void ReadPendingInstantiations(final SmallVectorImpl<std.pair<ValueDecl /*P*/ , SourceLocation> > /*&*/ Pending)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadPendingInstantiations(Pending);
    }
  }

  
  /// \brief Read the set of late parsed template functions for this source.
  ///
  /// The external source should insert its own late parsed template functions
  /// into the map. Note that this routine may be invoked multiple times; the
  /// external source should take care not to introduce the same map entries
  /// repeatedly.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::ReadLateParsedTemplates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 287,
   FQN="clang::MultiplexExternalSemaSource::ReadLateParsedTemplates", NM="_ZN5clang27MultiplexExternalSemaSource23ReadLateParsedTemplatesERN4llvm9MapVectorIPKNS_12FunctionDeclEPNS_18LateParsedTemplateENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource23ReadLateParsedTemplatesERN4llvm9MapVectorIPKNS_12FunctionDeclEPNS_18LateParsedTemplateENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE")
  //</editor-fold>
  @Override public void ReadLateParsedTemplates(final MapVectorPtrPtr</*const*/ FunctionDecl /*P*/ , LateParsedTemplate /*P*/ > /*&*/ LPTMap)/* override*/ {
    for (/*size_t*/int i = 0; $less_uint(i, Sources.size()); ++i)  {
      Sources.$at(i).ReadLateParsedTemplates(LPTMap);
    }
  }

  
  /// \copydoc ExternalSemaSource::CorrectTypo
  /// \note Returns the first nonempty correction.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::CorrectTypo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 293,
   FQN="clang::MultiplexExternalSemaSource::CorrectTypo", NM="_ZN5clang27MultiplexExternalSemaSource11CorrectTypoERKNS_19DeclarationNameInfoEiPNS_5ScopeEPNS_12CXXScopeSpecERNS_27CorrectionCandidateCallbackEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource11CorrectTypoERKNS_19DeclarationNameInfoEiPNS_5ScopeEPNS_12CXXScopeSpecERNS_27CorrectionCandidateCallbackEPNS_11DeclContextEbPKNS_21ObjCObjectPointerTypeE")
  //</editor-fold>
  @Override public TypoCorrection CorrectTypo(final /*const*/ DeclarationNameInfo /*&*/ Typo, 
             int LookupKind, Scope /*P*/ S, CXXScopeSpec /*P*/ SS, 
             final CorrectionCandidateCallback /*&*/ CCC, 
             DeclContext /*P*/ MemberContext, 
             boolean EnteringContext, 
             /*const*/ ObjCObjectPointerType /*P*/ OPT)/* override*/ {
    for (/*size_t*/int I = 0, E = Sources.size(); $less_uint(I, E); ++I) {
      {
        TypoCorrection C = null;
        try {
          C = Sources.$at(I).CorrectTypo(Typo, LookupKind, S, SS, CCC, 
              MemberContext, 
              EnteringContext, OPT);
          if (C.$bool()) {
            return new TypoCorrection(JD$Move.INSTANCE, C);
          }
        } finally {
          if (C != null) { C.$destroy(); }
        }
      }
    }
    return new TypoCorrection();
  }

  
  /// \brief Produces a diagnostic note if one of the attached sources
  /// contains a complete definition for \p T. Queries the sources in list
  /// order until the first one claims that a diagnostic was produced.
  ///
  /// \param Loc the location at which a complete type was required but not
  /// provided
  ///
  /// \param T the \c QualType that should have been complete at \p Loc
  ///
  /// \return true if a diagnostic was produced, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::MaybeDiagnoseMissingCompleteType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp", line = 309,
   FQN="clang::MultiplexExternalSemaSource::MaybeDiagnoseMissingCompleteType", NM="_ZN5clang27MultiplexExternalSemaSource32MaybeDiagnoseMissingCompleteTypeENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource32MaybeDiagnoseMissingCompleteTypeENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  @Override public boolean MaybeDiagnoseMissingCompleteType(SourceLocation Loc, QualType T)/* override*/ {
    for (/*size_t*/int I = 0, E = Sources.size(); $less_uint(I, E); ++I) {
      if (Sources.$at(I).MaybeDiagnoseMissingCompleteType(new SourceLocation(Loc), new QualType(T))) {
        return true;
      }
    }
    return false;
  }

  
  // isa/cast/dyn_cast support
  //<editor-fold defaultstate="collapsed" desc="clang::MultiplexExternalSemaSource::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/MultiplexExternalSemaSource.h", line = 351,
   FQN="clang::MultiplexExternalSemaSource::classof", NM="_ZN5clang27MultiplexExternalSemaSource7classofEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/MultiplexExternalSemaSource.cpp -nm=_ZN5clang27MultiplexExternalSemaSource7classofEPKS0_")
  //</editor-fold>
  public static boolean classof(/*const*/ MultiplexExternalSemaSource /*P*/ $Prm0) {
    return true;
  }

  
  @Override public String toString() {
    return "" + "Sources=" + "[SmallVector$ExternalSemaSource]" // NOI18N
              + super.toString(); // NOI18N
  }
//static bool classof(const ExternalSemaSource*) { return true; }
}

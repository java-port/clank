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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;

/// BasePaths - Represents the set of paths from a derived class to
/// one of its (direct or indirect) bases. For example, given the
/// following class hierarchy:
///
/// @code
/// class A { };
/// class B : public A { };
/// class C : public A { };
/// class D : public B, public C{ };
/// @endcode
///
/// There are two potential BasePaths to represent paths from D to a
/// base subobject of type A. One path is (D,0) -> (B,0) -> (A,0)
/// and another is (D,0)->(C,0)->(A,1). These two paths actually
/// refer to two different base class subobjects of the same type,
/// so the BasePaths object refers to an ambiguous path. On the
/// other hand, consider the following class hierarchy:
///
/// @code
/// class A { };
/// class B : public virtual A { };
/// class C : public virtual A { };
/// class D : public B, public C{ };
/// @endcode
///
/// Here, there are two potential BasePaths again, (D, 0) -> (B, 0)
/// -> (A,v) and (D, 0) -> (C, 0) -> (A, v), but since both of them
/// refer to the same base class subobject of type A (the virtual
/// one), there is no ambiguity.
//<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 117,
 FQN="clang::CXXBasePaths", NM="_ZN5clang12CXXBasePathsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePathsE")
//</editor-fold>
public class CXXBasePaths implements Iterable<CXXBasePath>, Destructors.ClassWithDestructor {
  /// \brief The type from which this search originated.
  private CXXRecordDecl /*P*/ Origin;
  
  /// Paths - The actual set of paths that can be taken from the
  /// derived class to the same base class.
   /*friend*/protected/*private*/ std.list<CXXBasePath> Paths;
  
  /// ClassSubobjects - Records the class subobjects for each class
  /// type that we've seen. The first element in the pair says
  /// whether we found a path to a virtual base for that class type,
  /// while the element contains the number of non-virtual base
  /// class subobjects for that class type. The key of the map is
  /// the cv-unqualified canonical type of the base class subobject.
  private SmallDenseMap<QualType, std.pairBoolUInt> ClassSubobjects;
  
  /// FindAmbiguities - Whether Sema::IsDerivedFrom should try find
  /// ambiguous paths while it is looking for a path from a derived
  /// type to a base type.
  private boolean FindAmbiguities;
  
  /// RecordPaths - Whether Sema::IsDerivedFrom should record paths
  /// while it is determining whether there are paths from a derived
  /// type to a base type.
  private boolean RecordPaths;
  
  /// DetectVirtual - Whether Sema::IsDerivedFrom should abort the search
  /// if it finds a path that goes across a virtual base. The virtual class
  /// is also recorded.
  private boolean DetectVirtual;
  
  /// ScratchPath - A BasePath that is used by Sema::lookupInBases
  /// to help build the set of paths.
  private CXXBasePath ScratchPath;
  
  /// DetectedVirtual - The base class that is virtual.
  private /*const*/ RecordType /*P*/ DetectedVirtual;
  
  /// \brief Array of the declarations that have been found. This
  /// array is constructed only if needed, e.g., to iterate over the
  /// results within LookupResult.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private unique_ptr_array<NamedDecl /*P []*/> DeclsFound;
  private /*uint*/int NumDeclsFound;
  
  /*friend  class CXXRecordDecl*/
  
  
  /// \brief Computes the set of declarations referenced by these base
  /// paths.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::ComputeDeclsFound">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 25,
   FQN="clang::CXXBasePaths::ComputeDeclsFound", NM="_ZN5clang12CXXBasePaths17ComputeDeclsFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths17ComputeDeclsFoundEv")
  //</editor-fold>
  private void ComputeDeclsFound() {
    SetVector<NamedDecl> Decls = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (NumDeclsFound == 0 && !DeclsFound.$bool()) : "Already computed the set of declarations";
      
      Decls/*J*/= new SetVector<NamedDecl>((NamedDecl)null);
      for (std.list.iterator<CXXBasePath> Path = begin(), PathEnd = end(); Path.$noteq(PathEnd); Path.$preInc())  {
        Decls.insert(Path.$arrow().Decls.front());
      }
      
      NumDeclsFound = Decls.size();
      $c$.clean(DeclsFound.$assignMove($c$.track(llvm.make_unique(new NamedDecl /*P*/ [NumDeclsFound]))));
      std.copy(Decls.begin(), Decls.end(), create_type$ptr(DeclsFound.get()));
    } finally {
      if (Decls != null) { Decls.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::lookupInBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 178,
   FQN="clang::CXXBasePaths::lookupInBases", NM="_ZN5clang12CXXBasePaths13lookupInBasesERNS_10ASTContextEPKNS_13CXXRecordDeclEN4llvm12function_refIFbPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths13lookupInBasesERNS_10ASTContextEPKNS_13CXXRecordDeclEN4llvm12function_refIFbPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEEEE")
  //</editor-fold>
  /*friend*/protected/*private*/ boolean lookupInBases(final ASTContext /*&*/ Context, /*const*/ CXXRecordDecl /*P*/ Record, 
               BaseMatchesCallback BaseMatches) {
    boolean FoundPath = false;
    
    // The access of the path down to this record.
    AccessSpecifier AccessToHere = ScratchPath.Access;
    boolean IsFirstStep = ScratchPath.empty();
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ BaseSpec : Record.bases$Const()) {
      // Find the record of the base class subobjects for this type.
      QualType BaseType = Context.getCanonicalType(BaseSpec.getType()).getUnqualifiedType().$QualType();
      
      // C++ [temp.dep]p3:
      //   In the definition of a class template or a member of a class template,
      //   if a base class of the class template depends on a template-parameter,
      //   the base class scope is not examined during unqualified name lookup 
      //   either at the point of definition of the class template or member or 
      //   during an instantiation of the class tem- plate or member.
      if (BaseType.$arrow().isDependentType()) {
        continue;
      }
      
      // Determine whether we need to visit this base class at all,
      // updating the count of subobjects appropriately.
      final std.pairBoolUInt /*&*/ Subobjects = ClassSubobjects.$at_T1$C$R(BaseType);
      boolean VisitBase = true;
      boolean SetVirtual = false;
      if (BaseSpec.isVirtual()) {
        VisitBase = !Subobjects.first;
        Subobjects.first = true;
        if (isDetectingVirtual() && DetectedVirtual == null) {
          // If this is the first virtual we find, remember it. If it turns out
          // there is no base path here, we'll reset it later.
          DetectedVirtual = BaseType.$arrow().getAs$RecordType();
          SetVirtual = true;
        }
      } else {
        ++Subobjects.second;
      }
      if (isRecordingPaths()) {
        // Add this base specifier to the current path.
        CXXBasePathElement Element/*J*/= new CXXBasePathElement();
        Element.Base = $AddrOf(BaseSpec);
        Element.Class = Record;
        if (BaseSpec.isVirtual()) {
          Element.SubobjectNumber = 0;
        } else {
          Element.SubobjectNumber = Subobjects.second;
        }
        ScratchPath.push_back(Element);
        
        // Calculate the "top-down" access to this base class.
        // The spec actually describes this bottom-up, but top-down is
        // equivalent because the definition works out as follows:
        // 1. Write down the access along each step in the inheritance
        //    chain, followed by the access of the decl itself.
        //    For example, in
        //      class A { public: int foo; };
        //      class B : protected A {};
        //      class C : public B {};
        //      class D : private C {};
        //    we would write:
        //      private public protected public
        // 2. If 'private' appears anywhere except far-left, access is denied.
        // 3. Otherwise, overall access is determined by the most restrictive
        //    access in the sequence.
        if (IsFirstStep) {
          ScratchPath.Access = BaseSpec.getAccessSpecifier();
        } else {
          ScratchPath.Access = CXXRecordDecl.MergeAccess(AccessToHere, 
              BaseSpec.getAccessSpecifier());
        }
      }
      
      // Track whether there's a path involving this specific base.
      boolean FoundPathThroughBase = false;
      if (BaseMatches.$call($AddrOf(BaseSpec), ScratchPath)) {
        // We've found a path that terminates at this base.
        FoundPath = FoundPathThroughBase = true;
        if (isRecordingPaths()) {
          // We have a path. Make a copy of it before moving on.
          Paths.push_back_T$C$R(ScratchPath);
        } else if (!isFindingAmbiguities()) {
          // We found a path and we don't care about ambiguities;
          // return immediately.
          return FoundPath;
        }
      } else if (VisitBase) {
        CXXRecordDecl /*P*/ BaseRecord = cast_CXXRecordDecl(BaseSpec.getType().$arrow().castAs$RecordType().
    getDecl());
        if (lookupInBases(Context, BaseRecord, /*FuncArg*/BaseMatches)) {
          // C++ [class.member.lookup]p2:
          //   A member name f in one sub-object B hides a member name f in
          //   a sub-object A if A is a base class sub-object of B. Any
          //   declarations that are so hidden are eliminated from
          //   consideration.
          
          // There is a path to a base class that meets the criteria. If we're 
          // not collecting paths or finding ambiguities, we're done.
          FoundPath = FoundPathThroughBase = true;
          if (!isFindingAmbiguities()) {
            return FoundPath;
          }
        }
      }
      
      // Pop this base specifier off the current path (if we're
      // collecting paths).
      if (isRecordingPaths()) {
        ScratchPath.pop_back();
      }
      
      // If we set a virtual earlier, and this isn't a path, forget it again.
      if (SetVirtual && !FoundPathThroughBase) {
        DetectedVirtual = null;
      }
    }
    
    // Reset the scratch path access.
    ScratchPath.Access = AccessToHere;
    
    return FoundPath;
  }

/*public:*/
  /*typedef std::list<CXXBasePath>::iterator paths_iterator*/
//  public final class paths_iterator extends std.list.iterator<CXXBasePath>{ };
  /*typedef std::list<CXXBasePath>::const_iterator const_paths_iterator*/
//  public final class const_paths_iterator extends std.list.iterator<CXXBasePath>{ };
  /*typedef NamedDecl **decl_iterator*/
//  public final class decl_iterator extends type$ptr<NamedDecl /*P*/ /*P*/>{ };
  
  /// BasePaths - Construct a new BasePaths structure to record the
  /// paths for a derived-to-base search.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::CXXBasePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 175,
   FQN="clang::CXXBasePaths::CXXBasePaths", NM="_ZN5clang12CXXBasePathsC1Ebbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePathsC1Ebbb")
  //</editor-fold>
  public /*explicit*/ CXXBasePaths() {
    this(true, true, 
      true);
  }
  public /*explicit*/ CXXBasePaths(boolean FindAmbiguities/*= true*/) {
    this(FindAmbiguities, true, 
      true);
  }
  public /*explicit*/ CXXBasePaths(boolean FindAmbiguities/*= true*/, boolean RecordPaths/*= true*/) {
    this(FindAmbiguities, RecordPaths, 
      true);
  }
  public /*explicit*/ CXXBasePaths(boolean FindAmbiguities/*= true*/, boolean RecordPaths/*= true*/, 
      boolean DetectVirtual/*= true*/) {
    // : Paths(), ClassSubobjects(), FindAmbiguities(FindAmbiguities), RecordPaths(RecordPaths), DetectVirtual(DetectVirtual), ScratchPath(), DetectedVirtual(null), DeclsFound(), NumDeclsFound(0) 
    //START JInit
    this.Paths = new std.list<CXXBasePath>(new CXXBasePath());
    this.ClassSubobjects = new SmallDenseMap<QualType, std.pairBoolUInt>(DenseMapInfoQualType.$Info(), 8, new std.pairBoolUInt());
    this.FindAmbiguities = FindAmbiguities;
    this.RecordPaths = RecordPaths;
    this.DetectVirtual = DetectVirtual;
    this.ScratchPath = new CXXBasePath();
    this.DetectedVirtual = null;
    this.DeclsFound = new unique_ptr_array<NamedDecl /*P []*/>();
    this.NumDeclsFound = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 181,
   FQN="clang::CXXBasePaths::begin", NM="_ZN5clang12CXXBasePaths5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths5beginEv")
  //</editor-fold>
  public std.list.iterator<CXXBasePath> begin() {
    return Paths.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 182,
   FQN="clang::CXXBasePaths::end", NM="_ZN5clang12CXXBasePaths3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths3endEv")
  //</editor-fold>
  public std.list.iterator<CXXBasePath> end() {
    return Paths.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 183,
   FQN="clang::CXXBasePaths::begin", NM="_ZNK5clang12CXXBasePaths5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths5beginEv")
  //</editor-fold>
  public std.list.iterator<CXXBasePath> begin$Const() /*const*/ {
    return Paths.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 184,
   FQN="clang::CXXBasePaths::end", NM="_ZNK5clang12CXXBasePaths3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths3endEv")
  //</editor-fold>
  public std.list.iterator<CXXBasePath> end$Const() /*const*/ {
    return Paths.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 186,
   FQN="clang::CXXBasePaths::front", NM="_ZN5clang12CXXBasePaths5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths5frontEv")
  //</editor-fold>
  public CXXBasePath /*&*/ front() {
    return Paths.front();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 187,
   FQN="clang::CXXBasePaths::front", NM="_ZNK5clang12CXXBasePaths5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths5frontEv")
  //</editor-fold>
  public /*const*/ CXXBasePath /*&*/ front$Const() /*const*/ {
    return Paths.front$Const();
  }

  
  /*typedef llvm::iterator_range<decl_iterator> decl_range*/
//  public final class decl_range extends iterator_range<NamedDecl /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::found_decls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 38,
   FQN="clang::CXXBasePaths::found_decls", NM="_ZN5clang12CXXBasePaths11found_declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths11found_declsEv")
  //</editor-fold>
  public iterator_range<NamedDecl /*P*/ > found_decls() {
    if (NumDeclsFound == 0) {
      ComputeDeclsFound();
    }
    
    return new iterator_range<NamedDecl /*P*/ >(create_type$ptr(DeclsFound.get()), 
        create_type$ptr(DeclsFound.get(), NumDeclsFound));
  }

  
  /// \brief Determine whether the path from the most-derived type to the
  /// given base type is ambiguous (i.e., it refers to multiple subobjects of
  /// the same base type).
  
  /// isAmbiguous - Determines whether the set of paths provided is
  /// ambiguous, i.e., there are two or more paths that refer to
  /// different base class subobjects of the same type. BaseType must be
  /// an unqualified, canonical class type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::isAmbiguous">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 50,
   FQN="clang::CXXBasePaths::isAmbiguous", NM="_ZN5clang12CXXBasePaths11isAmbiguousENS_7CanQualINS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths11isAmbiguousENS_7CanQualINS_4TypeEEE")
  //</editor-fold>
  public boolean isAmbiguous(CanQual<Type> BaseType) {
    BaseType.$assignMove(BaseType.getUnqualifiedType());
    final std.pairBoolUInt /*&*/ Subobjects = ClassSubobjects.$at_T1$RR(BaseType.$QualType());
    return $greater_uint(Subobjects.second + (Subobjects.first ? 1 : 0), 1);
  }

  
  /// \brief Whether we are finding multiple paths to detect ambiguities.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::isFindingAmbiguities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 198,
   FQN="clang::CXXBasePaths::isFindingAmbiguities", NM="_ZNK5clang12CXXBasePaths20isFindingAmbiguitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths20isFindingAmbiguitiesEv")
  //</editor-fold>
  public boolean isFindingAmbiguities() /*const*/ {
    return FindAmbiguities;
  }

  
  /// \brief Whether we are recording paths.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::isRecordingPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 201,
   FQN="clang::CXXBasePaths::isRecordingPaths", NM="_ZNK5clang12CXXBasePaths16isRecordingPathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths16isRecordingPathsEv")
  //</editor-fold>
  public boolean isRecordingPaths() /*const*/ {
    return RecordPaths;
  }

  
  /// \brief Specify whether we should be recording paths or not.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::setRecordingPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 204,
   FQN="clang::CXXBasePaths::setRecordingPaths", NM="_ZN5clang12CXXBasePaths17setRecordingPathsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths17setRecordingPathsEb")
  //</editor-fold>
  public void setRecordingPaths(boolean RP) {
    RecordPaths = RP;
  }

  
  /// \brief Whether we are detecting virtual bases.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::isDetectingVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 207,
   FQN="clang::CXXBasePaths::isDetectingVirtual", NM="_ZNK5clang12CXXBasePaths18isDetectingVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths18isDetectingVirtualEv")
  //</editor-fold>
  public boolean isDetectingVirtual() /*const*/ {
    return DetectVirtual;
  }

  
  /// \brief The virtual base discovered on the path (if we are merely
  /// detecting virtuals).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::getDetectedVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 211,
   FQN="clang::CXXBasePaths::getDetectedVirtual", NM="_ZNK5clang12CXXBasePaths18getDetectedVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths18getDetectedVirtualEv")
  //</editor-fold>
  public /*const*/ RecordType /*P*/ getDetectedVirtual() /*const*/ {
    return DetectedVirtual;
  }

  
  /// \brief Retrieve the type from which this base-paths search
  /// began
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::getOrigin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 217,
   FQN="clang::CXXBasePaths::getOrigin", NM="_ZNK5clang12CXXBasePaths9getOriginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang12CXXBasePaths9getOriginEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getOrigin() /*const*/ {
    return Origin;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::setOrigin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 218,
   FQN="clang::CXXBasePaths::setOrigin", NM="_ZN5clang12CXXBasePaths9setOriginEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths9setOriginEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public void setOrigin(CXXRecordDecl /*P*/ Rec) {
    Origin = Rec;
  }

  
  /// \brief Clear the base-paths results.
  
  /// clear - Clear out all prior path information.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 57,
   FQN="clang::CXXBasePaths::clear", NM="_ZN5clang12CXXBasePaths5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths5clearEv")
  //</editor-fold>
  public void clear() {
    Paths.clear();
    ClassSubobjects.clear();
    ScratchPath.CXXBasePath$clear();
    DetectedVirtual = null;
  }

  
  /// \brief Swap this data structure's contents with another CXXBasePaths 
  /// object.
  
  /// @brief Swaps the contents of this CXXBasePaths structure with the
  /// contents of Other.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::swap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 66,
   FQN="clang::CXXBasePaths::swap", NM="_ZN5clang12CXXBasePaths4swapERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePaths4swapERS0_")
  //</editor-fold>
  public void swap(final CXXBasePaths /*&*/ Other) {
    //std.swap(Origin, Other.Origin);
    CXXRecordDecl tmpCXXRecordDecl = Origin;
    Origin = Other.Origin;
    Other.Origin = tmpCXXRecordDecl;
    std.swap(Paths, Other.Paths);
    ClassSubobjects.swap(Other.ClassSubobjects);
    //std.swap(FindAmbiguities, Other.FindAmbiguities);
    boolean tmpBoolean = FindAmbiguities;
    FindAmbiguities = Other.FindAmbiguities;
    Other.FindAmbiguities = tmpBoolean;
    //std.swap(RecordPaths, Other.RecordPaths);
    tmpBoolean = RecordPaths;
    RecordPaths = Other.RecordPaths;
    Other.RecordPaths = tmpBoolean;
    //std.swap(DetectVirtual, Other.DetectVirtual);
    tmpBoolean = DetectVirtual;
    DetectVirtual = Other.DetectVirtual;
    Other.DetectVirtual = tmpBoolean;
    //std.swap(DetectedVirtual, Other.DetectedVirtual);
    RecordType tmpRecordType = DetectedVirtual;
    DetectedVirtual = Other.DetectedVirtual;
    Other.DetectedVirtual = tmpRecordType;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXBasePaths::~CXXBasePaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 117,
   FQN="clang::CXXBasePaths::~CXXBasePaths", NM="_ZN5clang12CXXBasePathsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang12CXXBasePathsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DeclsFound.$destroy();
    ScratchPath.$destroy();
    ClassSubobjects.$destroy();
    Paths.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<CXXBasePath> iterator() {return new JavaIterator(begin(), end());}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Origin=" + Origin // NOI18N
              + ", Paths=" + Paths // NOI18N
              + ", ClassSubobjects=" + ClassSubobjects // NOI18N
              + ", FindAmbiguities=" + FindAmbiguities // NOI18N
              + ", RecordPaths=" + RecordPaths // NOI18N
              + ", DetectVirtual=" + DetectVirtual // NOI18N
              + ", ScratchPath=" + ScratchPath // NOI18N
              + ", DetectedVirtual=" + DetectedVirtual // NOI18N
              + ", DeclsFound=" + DeclsFound // NOI18N
              + ", NumDeclsFound=" + NumDeclsFound; // NOI18N
  }
}

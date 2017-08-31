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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.AstClangGlobals.$out_DiagnosticBuilder$C_DeclarationName;
import org.clang.ast.llvm.DenseMapInfoDeclarationName;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/// \brief Given an ObjC interface, goes through the modules and links to the
/// interface all the categories for it.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCategoriesVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3579,
 FQN="(anonymous namespace)::ObjCCategoriesVisitor", NM="_ZN12_GLOBAL__N_121ObjCCategoriesVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_121ObjCCategoriesVisitorE")
//</editor-fold>
public class ObjCCategoriesVisitor implements ModuleFile$Ref2Bool, Destructors.ClassWithDestructor {
  private final ASTReader /*&*/ Reader;
  private /*uint32_t*/int InterfaceID;
  private ObjCInterfaceDecl /*P*/ Interface;
  private final SmallPtrSetImpl<ObjCCategoryDecl /*P*/ > /*&*/ Deserialized;
  private /*uint*/int PreviousGeneration;
  private ObjCCategoryDecl /*P*/ Tail;
  private DenseMap<DeclarationName, ObjCCategoryDecl /*P*/ > NameCategoryMap;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCategoriesVisitor::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3588,
   FQN="(anonymous namespace)::ObjCCategoriesVisitor::add", NM="_ZN12_GLOBAL__N_121ObjCCategoriesVisitor3addEPN5clang16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_121ObjCCategoriesVisitor3addEPN5clang16ObjCCategoryDeclE")
  //</editor-fold>
  private void add(ObjCCategoryDecl /*P*/ Cat) {
    // Only process each category once.
    if (!Deserialized.erase(Cat)) {
      return;
    }
    
    // Check for duplicate categories.
    if (Cat.getDeclName().$bool()) {
      final type$ref<ObjCCategoryDecl /*P*/ /*&*/> Existing = NameCategoryMap.ref$at(Cat.getDeclName());
      if ((Existing.$deref() != null)
         && Reader.getOwningModuleFile(Existing.$deref())
         != Reader.getOwningModuleFile(Cat)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: We should not warn for duplicates in diamond:
          //
          //   MT     //
          //  /  \    //
          // ML  MR   //
          //  \  /    //
          //   MB     //
          //
          // If there are duplicates in ML/MR, there will be warning when 
          // creating MB *and* when importing MB. We should not warn when 
          // importing.
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($out_DiagnosticBuilder$C_DeclarationName($c$.track(Reader.Diag(Cat.getLocation(), diag.warn_dup_category_def)), 
                  Interface.getDeclName()), Cat.getDeclName()));
          $c$.clean($c$.track(Reader.Diag(Existing.$deref().getLocation(), diag.note_previous_definition)));
        } finally {
          $c$.$destroy();
        }
      } else if (!(Existing.$deref() != null)) {
        // Record this category.
        Existing.$set(Cat);
      }
    }
    
    // Add this category to the end of the chain.
    if ((Tail != null)) {
      ASTDeclReader.setNextObjCCategory(Tail, Cat);
    } else {
      Interface.setCategoryListRaw(Cat);
    }
    Tail = Cat;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCategoriesVisitor::ObjCCategoriesVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3628,
   FQN="(anonymous namespace)::ObjCCategoriesVisitor::ObjCCategoriesVisitor", NM="_ZN12_GLOBAL__N_121ObjCCategoriesVisitorC1ERN5clang9ASTReaderEjPNS1_17ObjCInterfaceDeclERN4llvm15SmallPtrSetImplIPNS1_16ObjCCategoryDeclEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_121ObjCCategoriesVisitorC1ERN5clang9ASTReaderEjPNS1_17ObjCInterfaceDeclERN4llvm15SmallPtrSetImplIPNS1_16ObjCCategoryDeclEEEj")
  //</editor-fold>
  public ObjCCategoriesVisitor(final ASTReader /*&*/ Reader, 
      /*uint32_t*/int InterfaceID, 
      ObjCInterfaceDecl /*P*/ Interface, 
      final SmallPtrSetImpl<ObjCCategoryDecl /*P*/ > /*&*/ Deserialized, 
      /*uint*/int PreviousGeneration) {
    // : Reader(Reader), InterfaceID(InterfaceID), Interface(Interface), Deserialized(Deserialized), PreviousGeneration(PreviousGeneration), Tail(null), NameCategoryMap() 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this.InterfaceID = InterfaceID;
    this.Interface = Interface;
    this./*&*/Deserialized=/*&*/Deserialized;
    this.PreviousGeneration = PreviousGeneration;
    this.Tail = null;
    this.NameCategoryMap = new DenseMap<DeclarationName, ObjCCategoryDecl /*P*/ >(DenseMapInfoDeclarationName.$Info(), (ObjCCategoryDecl /*P*/ )null);
    //END JInit
    // Populate the name -> category map with the set of known categories.
    for (ObjCCategoryDecl /*P*/ Cat : Interface.known_categories()) {
      if (Cat.getDeclName().$bool()) {
        NameCategoryMap.$set(Cat.getDeclName(), Cat);
      }
      
      // Keep track of the tail of the category list.
      Tail = Cat;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCategoriesVisitor::operator()">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3647,
   FQN="(anonymous namespace)::ObjCCategoriesVisitor::operator()", NM="_ZN12_GLOBAL__N_121ObjCCategoriesVisitorclERN5clang13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_121ObjCCategoriesVisitorclERN5clang13serialization10ModuleFileE")
  //</editor-fold>
  public boolean $call(final ModuleFile /*&*/ M) {
    // If we've loaded all of the category information we care about from
    // this module file, we're done.
    if ($lesseq_uint(M.Generation, PreviousGeneration)) {
      return true;
    }
    
    // Map global ID of the definition down to the local ID used in this 
    // module file. If there is no such mapping, we'll find nothing here
    // (or in any module it imports).
    /*uint32_t*/int LocalID = Reader.mapGlobalIDToModuleFileGlobalID(M, InterfaceID);
    if (!(LocalID != 0)) {
      return true;
    }
    
    // Perform a binary search to find the local redeclarations for this
    // declaration (if any).
    /*const*/ ObjCCategoriesInfo Compare = new ObjCCategoriesInfo(LocalID, 0);
    /*const*/ type$ptr<ObjCCategoriesInfo /*P*/> Result = std.lower_bound(M.ObjCCategoriesMap, 
        M.ObjCCategoriesMap.$add(M.LocalNumObjCCategoriesInMap), 
        Compare);
    if ($eq_ptr(Result, M.ObjCCategoriesMap.$add(M.LocalNumObjCCategoriesInMap))
       || Result.$star().DefinitionID != LocalID) {
      // We didn't find anything. If the class definition is in this module
      // file, then the module files it depends on cannot have any categories,
      // so suppress further lookup.
      return Reader.isDeclIDFromModule(InterfaceID, M);
    }
    
    // We found something. Dig out all of the categories.
    /*uint*/int Offset = Result.$star().Offset;
    /*uint*/int N = $ullong2uint(M.ObjCCategories.$at(Offset));
    M.ObjCCategories.$set(Offset++, $int2ullong(0)); // Don't try to deserialize again
    for (/*uint*/int I = 0; I != N; ++I)  {
      add(cast_or_null_ObjCCategoryDecl(Reader.GetLocalDecl(M, $ullong2uint(M.ObjCCategories.$at(Offset++)))));
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCategoriesVisitor::~ObjCCategoriesVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3579,
   FQN="(anonymous namespace)::ObjCCategoriesVisitor::~ObjCCategoriesVisitor", NM="_ZN12_GLOBAL__N_121ObjCCategoriesVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN12_GLOBAL__N_121ObjCCategoriesVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NameCategoryMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", InterfaceID=" + InterfaceID // NOI18N
              + ", Interface=" + "[ObjCInterfaceDecl]" // NOI18N
              + ", Deserialized=" + "[SmallPtrSetImpl$ObjCCategoryDecl]" // NOI18N
              + ", PreviousGeneration=" + PreviousGeneration // NOI18N
              + ", Tail=" + "[ObjCCategoryDecl]" // NOI18N
              + ", NameCategoryMap=" + "[DenseMap$DeclarationName$ObjCCategoryDecl]"; // NOI18N
  }
}

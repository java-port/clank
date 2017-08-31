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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief This represents clauses with a list of expressions that are mappable.
/// Examples of these clauses are 'map' in
/// '#pragma omp target [enter|exit] [data]...' directives, and  'to' and 'from
/// in '#pragma omp target update...' directives.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2844,
 FQN="clang::OMPMappableExprListClause", NM="_ZN5clang25OMPMappableExprListClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClauseE")
//</editor-fold>
public class OMPMappableExprListClause</*class*/ T extends OMPMappableExprListClause & TrailingObjects$T$T$UInt$T<T, Expr /*P*/ , ValueDecl /*P*/ , /*uint Integer,*/ OMPClauseMappableExprCommon.MappableComponent>>  extends /*public*/ OMPVarListClause<T> implements /*public*/ OMPClauseMappableExprCommon {
  /*friend  class OMPClauseReader*/
  
  /// \brief Number of unique declarations in this clause.
  private /*uint*/int NumUniqueDeclarations;
  
  /// \brief Number of component lists in this clause.
  private /*uint*/int NumComponentLists;
  
  /// \brief Total number of components in this clause.
  private /*uint*/int NumComponents;
/*protected:*/
  /// \brief Get the unique declarations that are in the trailing objects of the
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getUniqueDeclsRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2861,
   FQN="clang::OMPMappableExprListClause::getUniqueDeclsRef", NM="_ZN5clang25OMPMappableExprListClause17getUniqueDeclsRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause17getUniqueDeclsRefEv")
  //</editor-fold>
  protected MutableArrayRef<ValueDecl /*P*/ > getUniqueDeclsRef() {
    return new MutableArrayRef<ValueDecl /*P*/ >(((/*static_cast*/T /*P*/ )this)./*template */<ValueDecl /*P*/ >getTrailingObjects(ValueDecl.class), NumUniqueDeclarations, true);
  }

  
  /// \brief Get the unique declarations that are in the trailing objects of the
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getUniqueDeclsRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2869,
   FQN="clang::OMPMappableExprListClause::getUniqueDeclsRef", NM="_ZNK5clang25OMPMappableExprListClause17getUniqueDeclsRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause17getUniqueDeclsRefEv")
  //</editor-fold>
  protected ArrayRef<ValueDecl /*P*/ > getUniqueDeclsRef$Const() /*const*/ {
    return new ArrayRef<ValueDecl /*P*/ >(((/*static_cast*//*const*/ T /*P*/ )(this))./*template */<ValueDecl /*P*/ >getTrailingObjects(ValueDecl.class), NumUniqueDeclarations);
  }

  
  /// \brief Set the unique declarations that are in the trailing objects of the
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::setUniqueDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2878,
   FQN="clang::OMPMappableExprListClause::setUniqueDecls", NM="_ZN5clang25OMPMappableExprListClause14setUniqueDeclsEN4llvm8ArrayRefIPNS_9ValueDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause14setUniqueDeclsEN4llvm8ArrayRefIPNS_9ValueDeclEEE")
  //</editor-fold>
  /*friend*/public void setUniqueDecls(ArrayRef<ValueDecl /*P*/ > UDs) {
    assert Native.$bool(Native.$eq(UDs.size(), NumUniqueDeclarations)) : "Unexpected amount of unique declarations.";
    std.copy(UDs.begin(), UDs.end(), getUniqueDeclsRef().begin());
  }

  
  /// \brief Get the number of lists per declaration that are in the trailing
  /// objects of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getDeclNumListsRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2886,
   FQN="clang::OMPMappableExprListClause::getDeclNumListsRef", NM="_ZN5clang25OMPMappableExprListClause18getDeclNumListsRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause18getDeclNumListsRefEv")
  //</editor-fold>
  protected MutableArrayRefUInt getDeclNumListsRef() {
    return new MutableArrayRefUInt(((/*static_cast*/T /*P*/ )(this))./*template <uint>*/getTrailingObjects$Uint(), NumUniqueDeclarations);
  }

  
  /// \brief Get the number of lists per declaration that are in the trailing
  /// objects of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getDeclNumListsRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2894,
   FQN="clang::OMPMappableExprListClause::getDeclNumListsRef", NM="_ZNK5clang25OMPMappableExprListClause18getDeclNumListsRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause18getDeclNumListsRefEv")
  //</editor-fold>
  protected ArrayRefUInt getDeclNumListsRef$Const() /*const*/ {
    return new ArrayRefUInt(((/*static_cast*//*const*/ T /*P*/ )(this))./*template <uint>*/getTrailingObjects$Uint(), NumUniqueDeclarations);
  }

  
  /// \brief Set the number of lists per declaration that are in the trailing
  /// objects of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::setDeclNumLists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2902,
   FQN="clang::OMPMappableExprListClause::setDeclNumLists", NM="_ZN5clang25OMPMappableExprListClause15setDeclNumListsEN4llvm8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause15setDeclNumListsEN4llvm8ArrayRefIjEE")
  //</editor-fold>
  /*friend*/public void setDeclNumLists(ArrayRefUInt DNLs) {
    assert Native.$bool(Native.$eq(DNLs.size(), NumUniqueDeclarations)) : "Unexpected amount of list numbers.";
    std.copy(DNLs.begin(), DNLs.end(), getDeclNumListsRef().begin());
  }

  
  /// \brief Get the cumulative component lists sizes that are in the trailing
  /// objects of the class. They are appended after the number of lists.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getComponentListSizesRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2910,
   FQN="clang::OMPMappableExprListClause::getComponentListSizesRef", NM="_ZN5clang25OMPMappableExprListClause24getComponentListSizesRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause24getComponentListSizesRefEv")
  //</editor-fold>
  protected MutableArrayRefUInt getComponentListSizesRef() {
    return new MutableArrayRefUInt(((/*static_cast*/T /*P*/ )(this))./*template <uint>*/getTrailingObjects$Uint().$add(
       + NumUniqueDeclarations), NumComponentLists);
  }

  
  /// \brief Get the cumulative component lists sizes that are in the trailing
  /// objects of the class. They are appended after the number of lists.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getComponentListSizesRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2919,
   FQN="clang::OMPMappableExprListClause::getComponentListSizesRef", NM="_ZNK5clang25OMPMappableExprListClause24getComponentListSizesRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause24getComponentListSizesRefEv")
  //</editor-fold>
  protected ArrayRefUInt getComponentListSizesRef$Const() /*const*/ {
    return new ArrayRefUInt(((/*static_cast*//*const*/ T /*P*/ )(this))./*template <uint>*/getTrailingObjects$Uint().$add(
       + NumUniqueDeclarations), NumComponentLists);
  }

  
  /// \brief Set the cumulative component lists sizes that are in the trailing
  /// objects of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::setComponentListSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2928,
   FQN="clang::OMPMappableExprListClause::setComponentListSizes", NM="_ZN5clang25OMPMappableExprListClause21setComponentListSizesEN4llvm8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause21setComponentListSizesEN4llvm8ArrayRefIjEE")
  //</editor-fold>
  /*friend*/public void setComponentListSizes(ArrayRefUInt CLSs) {
    assert Native.$bool(Native.$eq(CLSs.size(), NumComponentLists)) : "Unexpected amount of component lists.";
    std.copy(CLSs.begin(), CLSs.end(), getComponentListSizesRef().begin());
  }

  
  /// \brief Get the components that are in the trailing objects of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getComponentsRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2935,
   FQN="clang::OMPMappableExprListClause::getComponentsRef", NM="_ZN5clang25OMPMappableExprListClause16getComponentsRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause16getComponentsRefEv")
  //</editor-fold>
  protected MutableArrayRef<MappableComponent> getComponentsRef() {
    return new MutableArrayRef/*<MappableComponent>*/(((/*static_cast*/T /*P*/ )(this))./*template <MappableComponent>*/getTrailingObjects(MappableComponent.class), NumComponents, false);
  }

  
  /// \brief Get the components that are in the trailing objects of the class.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getComponentsRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2943,
   FQN="clang::OMPMappableExprListClause::getComponentsRef", NM="_ZNK5clang25OMPMappableExprListClause16getComponentsRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause16getComponentsRefEv")
  //</editor-fold>
  protected ArrayRef<MappableComponent> getComponentsRef$Const() /*const*/ {
    return new ArrayRef<MappableComponent>(((/*static_cast*//*const*/ T /*P*/ )(this))./*template */<MappableComponent>getTrailingObjects(MappableComponent.class), NumComponents);
  }

  
  /// \brief Set the components that are in the trailing objects of the class.
  /// This requires the list sizes so that it can also fill the original
  /// expressions, which are the first component of each list.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::setComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2953,
   FQN="clang::OMPMappableExprListClause::setComponents", NM="_ZN5clang25OMPMappableExprListClause13setComponentsEN4llvm8ArrayRefINS_27OMPClauseMappableExprCommon17MappableComponentEEENS2_IjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause13setComponentsEN4llvm8ArrayRefINS_27OMPClauseMappableExprCommon17MappableComponentEEENS2_IjEE")
  //</editor-fold>
  /*friend*/public void setComponents(ArrayRef<MappableComponent> Components, 
               ArrayRefUInt CLSs) {
    assert Native.$bool(Native.$eq(Components.size(), NumComponents)) : "Unexpected amount of component lists.";
    assert Native.$bool(Native.$eq(CLSs.size(), NumComponentLists)) : "Unexpected amount of list sizes.";
    std.copy(Components.begin(), Components.end(), getComponentsRef().begin());
  }

  
  /// \brief Fill the clause information from the list of declarations and
  /// associated component lists.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::setClauseInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 2964,
   FQN="clang::OMPMappableExprListClause::setClauseInfo", NM="_ZN5clang25OMPMappableExprListClause13setClauseInfoEN4llvm8ArrayRefIPNS_9ValueDeclEEENS2_INS1_11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause13setClauseInfoEN4llvm8ArrayRefIPNS_9ValueDeclEEENS2_INS1_11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEEEE")
  //</editor-fold>
  protected void setClauseInfo(ArrayRef<ValueDecl /*P*/ > Declarations, 
               ArrayRef<SmallVector<MappableComponent>> ComponentLists) {
    DenseMap<ValueDecl /*P*/ , SmallVector<ArrayRef<MappableComponent>>> ComponentListMap = null;
    try {
      // Perform some checks to make sure the data sizes are consistent with the
      // information available when the clause was created.
      assert Native.$bool(Native.$eq(OMPClauseMappableExprCommon.getUniqueDeclarationsTotalNumber(new ArrayRef<ValueDecl /*P*/ >(Declarations)), NumUniqueDeclarations)) : "Unexpected number of mappable expression info entries!";
      assert Native.$bool(Native.$eq(OMPClauseMappableExprCommon.getComponentsTotalNumber(new ArrayRef<SmallVector<MappableComponent>>(ComponentLists)), NumComponents)) : "Unexpected total number of components!";
      assert (Declarations.size() == ComponentLists.size()) : "Declaration and component lists size is not consistent!";
      assert Native.$bool(Native.$eq(Declarations.size(), NumComponentLists)) : "Unexpected declaration and component lists size!";
      
      // Organize the components by declaration and retrieve the original
      // expression. Original expressions are always the first component of the
      // mappable component list.
      ComponentListMap/*J*/= new DenseMap<ValueDecl /*P*/ , SmallVector<ArrayRef<MappableComponent>>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<ArrayRef<MappableComponent>>(8, new ArrayRef<MappableComponent>()));
      {
        type$ptr</*const*/SmallVector<MappableComponent> /*P*/> CI = $tryClone(ComponentLists.begin());
        for (type$ptr<ValueDecl /*P*/ /*const*/ /*P*/> DI = $tryClone(Declarations.begin()), /*P*/ DE = $tryClone(Declarations.end()); $noteq_ptr(DI, DE);
             DI.$preInc() , CI.$preInc()) {
          assert (!CI./*->*/$star().empty()) : "Invalid component list!";
          ComponentListMap.$at_T1$C$R(DI.$star()).push_back(new ArrayRef<MappableComponent>(CI.$star(), false));
        }
      }
      
      // Iterators of the target storage.
      MutableArrayRef<ValueDecl /*P*/ > UniqueDeclarations = getUniqueDeclsRef();
      type$ptr<ValueDecl /*P*/ > UDI = UniqueDeclarations.begin();
      
      MutableArrayRefUInt DeclNumLists = getDeclNumListsRef();
      uint$ptr DNLI = DeclNumLists.begin();
      
      MutableArrayRefUInt ComponentListSizes = getComponentListSizesRef();
      uint$ptr CLSI = ComponentListSizes.begin();
      
      MutableArrayRef<MappableComponent> Components = getComponentsRef();
      type$ptr<MappableComponent> CI = Components.begin();
      
      // Variable to compute the accumulation of the number of components.
      /*uint*/int PrevSize = 0/*U*/;
      
      // Scan all the declarations and associated component lists.
      for (final std.pair<ValueDecl /*P*/ , SmallVector<ArrayRef<MappableComponent>>> /*&*/ M : ComponentListMap) {
        // The declaration.
        ValueDecl /*P*/ D = M.first;
        // The component lists.
        SmallVector<ArrayRef<MappableComponent>> CL = new SmallVector<ArrayRef<MappableComponent>>(M.second);
        
        // Initialize the entry.
        UDI.$set(D);
        UDI.$preInc();
        
        DNLI.$set(CL.size());
        DNLI.$preInc();
        
        // Obtain the cumulative sizes and concatenate all the components in the
        // reserved storage.
        for (ArrayRef<MappableComponent> C : CL) {
          // Accumulate with the previous size.
          PrevSize += C.size();
          
          // Save the size.
          CLSI.$set(PrevSize);
          CLSI.$preInc();
          
          // Append components after the current components iterator.
          CI = std.copy(C.begin(), C.end(), CI);
        }
      }
    } finally {
      if (ComponentListMap != null) { ComponentListMap.$destroy(); }
    }
  }

  
  /// \brief Build a clause for \a NumUniqueDeclarations declarations, \a
  /// NumComponentLists total component lists, and \a NumComponents total
  /// components.
  ///
  /// \param K Kind of the clause.
  /// \param StartLoc Starting location of the clause (the clause keyword).
  /// \param LParenLoc Location of '('.
  /// \param EndLoc Ending location of the clause.
  /// \param NumVars Number of expressions listed in the clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of component lists in this clause - one
  /// list for each expression in the clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::OMPMappableExprListClause<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3053,
   FQN="clang::OMPMappableExprListClause::OMPMappableExprListClause<T>", NM="_ZN5clang25OMPMappableExprListClauseC1ENS_16OpenMPClauseKindENS_14SourceLocationES2_S2_jjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClauseC1ENS_16OpenMPClauseKindENS_14SourceLocationES2_S2_jjjj")
  //</editor-fold>
  protected OMPMappableExprListClause(OpenMPClauseKind K, SourceLocation StartLoc, 
      SourceLocation LParenLoc, SourceLocation EndLoc, 
      /*uint*/int NumVars, /*uint*/int NumUniqueDeclarations, 
      /*uint*/int NumComponentLists, /*uint*/int NumComponents) {
    // : OMPVarListClause<T>(K, StartLoc, LParenLoc, EndLoc, NumVars), NumUniqueDeclarations(NumUniqueDeclarations), NumComponentLists(NumComponentLists), NumComponents(NumComponents) 
    //START JInit
    /*ParenListExpr*/super(K, StartLoc, LParenLoc, EndLoc, NumVars);
    this.NumUniqueDeclarations = NumUniqueDeclarations;
    this.NumComponentLists = NumComponentLists;
    this.NumComponents = NumComponents;
    //END JInit
  }

/*public:*/
  /// \brief Return the number of unique base declarations in this clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getUniqueDeclarationsNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3063,
   FQN="clang::OMPMappableExprListClause::getUniqueDeclarationsNum", NM="_ZNK5clang25OMPMappableExprListClause24getUniqueDeclarationsNumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause24getUniqueDeclarationsNumEv")
  //</editor-fold>
  public /*uint*/int getUniqueDeclarationsNum() /*const*/ {
    return NumUniqueDeclarations;
  }

  /// \brief Return the number of lists derived from the clause expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getTotalComponentListNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3065,
   FQN="clang::OMPMappableExprListClause::getTotalComponentListNum", NM="_ZNK5clang25OMPMappableExprListClause24getTotalComponentListNumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause24getTotalComponentListNumEv")
  //</editor-fold>
  public /*uint*/int getTotalComponentListNum() /*const*/ {
    return NumComponentLists;
  }

  /// \brief Return the total number of components in all lists derived from the
  /// clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::getTotalComponentsNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3068,
   FQN="clang::OMPMappableExprListClause::getTotalComponentsNum", NM="_ZNK5clang25OMPMappableExprListClause21getTotalComponentsNumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause21getTotalComponentsNumEv")
  //</editor-fold>
  public /*uint*/int getTotalComponentsNum() /*const*/ {
    return NumComponents;
  }

  
  /// \brief Iterator that browse the components by lists. It also allows
  /// browsing components of a single declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::const_component_lists_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3072,
   FQN="clang::OMPMappableExprListClause::const_component_lists_iterator", NM="_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorE")
  //</editor-fold>
  public static class const_component_lists_iterator extends /*public*/ iterator_adaptor_base<const_component_lists_iterator, type$ptr<MappableComponent>, std.forward_iterator_tag, std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> >, std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> >> {
    // The declaration the iterator currently refers to.
    private type$ptr<ValueDecl /*P*/> DeclCur;
    
    // The list number associated with the current declaration.
    private uint$ptr NumListsCur;
    
    // Remaining lists for the current declaration.
    private /*uint*/int RemainingLists;
    
    // The cumulative size of the previous list, or zero if there is no previous
    // list.
    private /*uint*/int PrevListSize;
    
    // The cumulative sizes of the current list - it will delimit the remaining
    // range of interest.
    private uint$ptr ListSizeCur;
    private uint$ptr ListSizeEnd;
    
    // Iterator to the end of the components storage.
    private type$ptr<MappableComponent> End;
  /*public:*/
    /// \brief Construct an iterator that scans all lists.
    //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::const_component_lists_iterator::const_component_lists_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3101,
     FQN="clang::OMPMappableExprListClause::const_component_lists_iterator::const_component_lists_iterator", NM="_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorC1EN4llvm8ArrayRefIPNS_9ValueDeclEEENS3_IjEES7_NS3_INS_27OMPClauseMappableExprCommon17MappableComponentEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorC1EN4llvm8ArrayRefIPNS_9ValueDeclEEENS3_IjEES7_NS3_INS_27OMPClauseMappableExprCommon17MappableComponentEEE")
    //</editor-fold>
    public /*explicit*/ const_component_lists_iterator(ArrayRef<ValueDecl /*P*/ > UniqueDecls, ArrayRefUInt DeclsListNum, 
        ArrayRefUInt CumulativeListSizes, 
        ArrayRef<MappableComponent> Components) {
      // : const_component_lists_iterator::iterator_adaptor_base(Components.begin()), DeclCur(UniqueDecls.begin()), NumListsCur(DeclsListNum.begin()), RemainingLists(0uU), PrevListSize(0uU), ListSizeCur(CumulativeListSizes.begin()), ListSizeEnd(CumulativeListSizes.end()), End(Components.end()) 
      //START JInit
      /*ParenListExpr*/super(Components.begin());
      this.DeclCur = $tryClone(UniqueDecls.begin());
      this.NumListsCur = $tryClone(DeclsListNum.begin());
      this.RemainingLists = 0/*U*/;
      this.PrevListSize = 0/*U*/;
      this.ListSizeCur = $tryClone(CumulativeListSizes.begin());
      this.ListSizeEnd = $tryClone(CumulativeListSizes.end());
      this.End = $tryClone(Components.end());
      //END JInit
      assert (UniqueDecls.size() == DeclsListNum.size()) : "Inconsistent number of declarations and list sizes!";
      if (!DeclsListNum.empty()) {
        RemainingLists = NumListsCur.$star();
      }
    }

    
    /// \brief Construct an iterator that scan lists for a given declaration \a
    /// Declaration.
    //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::const_component_lists_iterator::const_component_lists_iterator">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3119,
     FQN="clang::OMPMappableExprListClause::const_component_lists_iterator::const_component_lists_iterator", NM="_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorC1EPKNS_9ValueDeclEN4llvm8ArrayRefIPS2_EENS6_IjEES9_NS6_INS_27OMPClauseMappableExprCommon17MappableComponentEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorC1EPKNS_9ValueDeclEN4llvm8ArrayRefIPS2_EENS6_IjEES9_NS6_INS_27OMPClauseMappableExprCommon17MappableComponentEEE")
    //</editor-fold>
    public /*explicit*/ const_component_lists_iterator(/*const*/ ValueDecl /*P*/ Declaration, ArrayRef<ValueDecl /*P*/ > UniqueDecls, 
        ArrayRefUInt DeclsListNum, ArrayRefUInt CumulativeListSizes, 
        ArrayRef<MappableComponent> Components) {
      // : const_component_lists_iterator(UniqueDecls, DeclsListNum, CumulativeListSizes, Components) 
      //START JInit
      /*ParenListExpr*/this(UniqueDecls, DeclsListNum, CumulativeListSizes, Components);
      //END JInit
      
      // Look for the desired declaration. While we are looking for it, we
      // update the state so that we know the component where a given list
      // starts.
      for (; Native.$noteq_ptr(DeclCur, UniqueDecls.end()); DeclCur.$preInc() , NumListsCur.$preInc()) {
        if (DeclCur.$star() == Declaration) {
          break;
        }
        assert ($greater_uint(NumListsCur.$star(), 0)) : "No lists associated with declaration??";
        
        // Skip the lists associated with the current declaration, but save the
        // last list size that was skipped.
        std.advance(ListSizeCur, NumListsCur.$star() - 1);
        PrevListSize = ListSizeCur.$star();
        ListSizeCur.$preInc();
      }
      
      // If we didn't find any declaration, advance the iterator to after the
      // last component and set remaining lists to zero.
      if (Native.$eq_ptr(ListSizeCur, CumulativeListSizes.end())) {
        this.I.$assign(End);
        RemainingLists = 0/*U*/;
        return;
      }
      
      // Set the remaining lists with the total number of lists of the current
      // declaration.
      RemainingLists = NumListsCur.$star();
      
      // Adjust the list size end iterator to the end of the relevant range.
      ListSizeEnd = $tryClone(ListSizeCur);
      std.advance(ListSizeEnd, RemainingLists);
      
      // Given that the list sizes are cumulative, the index of the component
      // that start the list is the size of the previous list.
      std.advance(this.I, PrevListSize);
    }

    
    // Return the array with the current list. The sizes are cumulative, so the
    // array size is the difference between the current size and previous one.
    //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::const_component_lists_iterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3165,
     FQN="clang::OMPMappableExprListClause::const_component_lists_iterator::operator*", NM="_ZNK5clang25OMPMappableExprListClause30const_component_lists_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause30const_component_lists_iteratordeEv")
    //</editor-fold>
    public std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > $star() /*const*/ {
      assert Native.$bool(Native.$noteq_ptr(ListSizeCur, ListSizeEnd)) : "Invalid iterator!";
      return std.make_pair_Ptr_T(DeclCur.$star(), 
              new ArrayRef<MappableComponent>(this.I, ListSizeCur.$star() - PrevListSize));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::const_component_lists_iterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3172,
     FQN="clang::OMPMappableExprListClause::const_component_lists_iterator::operator->", NM="_ZNK5clang25OMPMappableExprListClause30const_component_lists_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause30const_component_lists_iteratorptEv")
    //</editor-fold>
    public std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > $arrow() /*const*/ {
      return this.$star();
    }

    
    // Skip the components of the current list.
    //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::const_component_lists_iterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3178,
     FQN="clang::OMPMappableExprListClause::const_component_lists_iterator::operator++", NM="_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang25OMPMappableExprListClause30const_component_lists_iteratorppEv")
    //</editor-fold>
    public const_component_lists_iterator /*&*/ $preInc() {
      assert Native.$bool(Native.$bool(Native.$noteq_ptr(ListSizeCur, ListSizeEnd)) && Native.$bool(RemainingLists)) : "Invalid iterator!";
      
      // If we don't have more lists just skip all the components. Otherwise,
      // advance the iterator by the number of components in the current list.
      if (Native.$eq_ptr(std.next(ListSizeCur), ListSizeEnd)) {
        this.I.$assign(End);
        RemainingLists = 0;
      } else {
        std.advance(this.I, ListSizeCur.$set(PrevListSize));
        PrevListSize = ListSizeCur.$star();
        
        // We are done with a declaration, move to the next one.
        if (Native.$not((--RemainingLists))) {
          DeclCur.$preInc();
          NumListsCur.$preInc();
          RemainingLists = NumListsCur.$star();
          assert Native.$bool(RemainingLists) : "No lists in the following declaration??";
        }
      }
      
      ListSizeCur.$preInc();
      return this;
    }

    public const_component_lists_iterator(const_component_lists_iterator $Prm0) {
      super(JD$BaseOf.INSTANCE, $Prm0);
      this.DeclCur = $tryClone($Prm0.DeclCur);
      this.NumListsCur = $tryClone($Prm0.NumListsCur);
      this.RemainingLists = $Prm0.RemainingLists/*U*/;
      this.PrevListSize = $Prm0.PrevListSize/*U*/;
      this.ListSizeCur = $tryClone($Prm0.ListSizeCur);
      this.ListSizeEnd = $tryClone($Prm0.ListSizeEnd);
      this.End = $tryClone($Prm0.End);
      //END JInit
    }
    
    @Override public const_component_lists_iterator clone() { return new const_component_lists_iterator(this); }
    
    @Override public String toString() {
      return "" + "DeclCur=" + DeclCur // NOI18N
                + ", NumListsCur=" + NumListsCur // NOI18N
                + ", RemainingLists=" + RemainingLists // NOI18N
                + ", PrevListSize=" + PrevListSize // NOI18N
                + ", ListSizeCur=" + ListSizeCur // NOI18N
                + ", ListSizeEnd=" + ListSizeEnd // NOI18N
                + ", End=" + End // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /*typedef llvm::iterator_range<const_component_lists_iterator> const_component_lists_range*/
//  public final class const_component_lists_range extends iterator_range<std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > >{ };
  
  /// \brief Iterators for all component lists.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::component_lists_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3209,
   FQN="clang::OMPMappableExprListClause::component_lists_begin", NM="_ZNK5clang25OMPMappableExprListClause21component_lists_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause21component_lists_beginEv")
  //</editor-fold>
  public const_component_lists_iterator component_lists_begin() /*const*/ {
    return new const_component_lists_iterator(getUniqueDeclsRef(), getDeclNumListsRef(), getComponentListSizesRef(), getComponentsRef());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::component_lists_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3214,
   FQN="clang::OMPMappableExprListClause::component_lists_end", NM="_ZNK5clang25OMPMappableExprListClause19component_lists_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause19component_lists_endEv")
  //</editor-fold>
  public const_component_lists_iterator component_lists_end() /*const*/ {
    return new const_component_lists_iterator(new ArrayRef<ValueDecl /*P*/ >(true), new ArrayRefUInt(), new ArrayRefUInt(), new ArrayRef<MappableComponent>(getComponentsRef().end(), getComponentsRef().end()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::component_lists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3220,
   FQN="clang::OMPMappableExprListClause::component_lists", NM="_ZNK5clang25OMPMappableExprListClause15component_listsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause15component_listsEv")
  //</editor-fold>
  public iterator_range<std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > > component_lists() /*const*/ {
    return /*JAVA:InitListExpr*/new iterator_range<std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > >(component_lists_begin(), component_lists_end());
  }

  
  /// \brief Iterators for component lists associated with the provided
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::decl_component_lists_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3226,
   FQN="clang::OMPMappableExprListClause::decl_component_lists_begin", NM="_ZNK5clang25OMPMappableExprListClause26decl_component_lists_beginEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause26decl_component_lists_beginEPKNS_9ValueDeclE")
  //</editor-fold>
  public const_component_lists_iterator decl_component_lists_begin(/*const*/ ValueDecl /*P*/ VD) /*const*/ {
    return new const_component_lists_iterator(VD, getUniqueDeclsRef(), getDeclNumListsRef(), getComponentListSizesRef(), getComponentsRef());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::decl_component_lists_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3232,
   FQN="clang::OMPMappableExprListClause::decl_component_lists_end", NM="_ZNK5clang25OMPMappableExprListClause24decl_component_lists_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause24decl_component_lists_endEv")
  //</editor-fold>
  public const_component_lists_iterator decl_component_lists_end() /*const*/ {
    return component_lists_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::decl_component_lists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3235,
   FQN="clang::OMPMappableExprListClause::decl_component_lists", NM="_ZNK5clang25OMPMappableExprListClause20decl_component_listsEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause20decl_component_listsEPKNS_9ValueDeclE")
  //</editor-fold>
  public iterator_range<std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > > decl_component_lists(/*const*/ ValueDecl /*P*/ VD) /*const*/ {
    return /*JAVA:InitListExpr*/new iterator_range<std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<MappableComponent> > >(decl_component_lists_begin(VD), decl_component_lists_end());
  }

  
  /// Iterators to access all the declarations, number of lists, list sizes, and
  /// components.
  /*typedef ArrayRef<ValueDecl *>::iterator const_all_decls_iterator*/
//  public final class const_all_decls_iterator extends type$ptr<ValueDecl /*P*/>{ };
  /*typedef llvm::iterator_range<const_all_decls_iterator> const_all_decls_range*/
//  public final class const_all_decls_range extends iterator_range<ValueDecl /*P*/ /*const*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::all_decls">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3243,
   FQN="clang::OMPMappableExprListClause::all_decls", NM="_ZNK5clang25OMPMappableExprListClause9all_declsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause9all_declsEv")
  //</editor-fold>
  public iterator_range<ValueDecl /*P*/ /*const*/> all_decls() /*const*/ {
    MutableArrayRef<ValueDecl /*P*/ > A = getUniqueDeclsRef();
    return new iterator_range<ValueDecl /*P*/ /*const*/>(A.begin(), A.end());
  }

  
  /*typedef ArrayRef<unsigned int>::iterator const_all_num_lists_iterator*/;
  /*typedef llvm::iterator_range<const_all_num_lists_iterator> const_all_num_lists_range*/
//  public final class const_all_num_lists_range extends iterator_range<uint$ptr>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::all_num_lists">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3251,
   FQN="clang::OMPMappableExprListClause::all_num_lists", NM="_ZNK5clang25OMPMappableExprListClause13all_num_listsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause13all_num_listsEv")
  //</editor-fold>
  public iterator_rangeUInt all_num_lists() /*const*/ {
    MutableArrayRefUInt A = getDeclNumListsRef();
    return new iterator_rangeUInt(A.begin(), A.end());
  }

  
  /*typedef ArrayRef<unsigned int>::iterator const_all_lists_sizes_iterator*/;
  /*typedef llvm::iterator_range<const_all_lists_sizes_iterator> const_all_lists_sizes_range*/
//  public final class const_all_lists_sizes_range extends iterator_range<uint$ptr>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::all_lists_sizes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3259,
   FQN="clang::OMPMappableExprListClause::all_lists_sizes", NM="_ZNK5clang25OMPMappableExprListClause15all_lists_sizesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause15all_lists_sizesEv")
  //</editor-fold>
  public iterator_rangeUInt all_lists_sizes() /*const*/ {
    MutableArrayRefUInt A = getComponentListSizesRef();
    return new iterator_rangeUInt(A.begin(), A.end());
  }

  
  /*typedef ArrayRef<MappableComponent>::iterator const_all_components_iterator*/
//  public final class const_all_components_iterator extends type$ptr<MappableComponent>{ };
  /*typedef llvm::iterator_range<const_all_components_iterator> const_all_components_range*/
//  public final class const_all_components_range extends iterator_range</*const*/ MappableComponent>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMappableExprListClause::all_components">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3267,
   FQN="clang::OMPMappableExprListClause::all_components", NM="_ZNK5clang25OMPMappableExprListClause14all_componentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang25OMPMappableExprListClause14all_componentsEv")
  //</editor-fold>
  public iterator_range</*const*/ MappableComponent> all_components() /*const*/ {
    MutableArrayRef<MappableComponent> A = getComponentsRef();
    return new iterator_range</*const*/ MappableComponent>(A.begin(), A.end());
  }

  
  @Override public String toString() {
    return "" + "NumUniqueDeclarations=" + NumUniqueDeclarations // NOI18N
              + ", NumComponentLists=" + NumComponentLists // NOI18N
              + ", NumComponents=" + NumComponents // NOI18N
              + super.toString(); // NOI18N
  }
}

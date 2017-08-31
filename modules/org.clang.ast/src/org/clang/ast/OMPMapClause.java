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
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.support.TrailingObjects.*;


/// \brief This represents clause 'map' in the '#pragma omp ...'
/// directives.
///
/// \code
/// #pragma omp target map(a,b)
/// \endcode
/// In this example directive '#pragma omp target' has clause 'map'
/// with the variables 'a' and 'b'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3282,
 FQN="clang::OMPMapClause", NM="_ZN5clang12OMPMapClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClauseE")
//</editor-fold>
public final class OMPMapClause extends /*public*/ OMPMappableExprListClause<OMPMapClause> implements /*private*/ TrailingObjects$T$T$UInt$T<OMPMapClause, Expr /*P*/ , ValueDecl /*P*/ , /*uint Integer,*/ OMPClauseMappableExprCommon.MappableComponent> {
  /*friend  TrailingObjects<OMPMapClause, Expr *, ValueDecl *, unsigned int, MappableComponent>*/
  /*friend  OMPVarListClause<OMPMapClause>*/
  /*friend  OMPMappableExprListClause<OMPMapClause>*/
  /*friend  class OMPClauseReader*/
  
  /// Define the sizes of each trailing object array except the last one. This
  /// is required for TrailingObjects to work properly.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3293,
   FQN="clang::OMPMapClause::numTrailingObjects", NM="_ZNK5clang12OMPMapClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_4ExprEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$Expr$P(OverloadToken<Expr /*P*/ > $Prm0) /*const*/ {
    return varlist_size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3296,
   FQN="clang::OMPMapClause::numTrailingObjects", NM="_ZNK5clang12OMPMapClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9ValueDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9ValueDeclEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadToken$ValueDecl$P(OverloadToken<ValueDecl /*P*/ > $Prm0) /*const*/ {
    return getUniqueDeclarationsNum();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3299,
   FQN="clang::OMPMapClause::numTrailingObjects", NM="_ZNK5clang12OMPMapClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIjEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects_OverloadTokenUInt(OverloadTokenUInt $Prm0) /*const*/ {
    return getUniqueDeclarationsNum() + getTotalComponentListNum();
  }

  
  /// \brief Map type modifier for the 'map' clause.
  private OpenMPMapClauseKind MapTypeModifier;
  /// \brief Map type for the 'map' clause.
  private OpenMPMapClauseKind MapType;
  /// \brief Is this an implicit map type or not.
  private boolean MapTypeIsImplicit;
  /// \brief Location of the map type.
  private SourceLocation MapLoc;
  /// \brief Colon location.
  private SourceLocation ColonLoc;
  
  /// \brief Set type modifier for the clause.
  ///
  /// \param T Type Modifier for the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::setMapTypeModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3318,
   FQN="clang::OMPMapClause::setMapTypeModifier", NM="_ZN5clang12OMPMapClause18setMapTypeModifierENS_19OpenMPMapClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause18setMapTypeModifierENS_19OpenMPMapClauseKindE")
  //</editor-fold>
  /*friend*/public void setMapTypeModifier(OpenMPMapClauseKind T) {
    MapTypeModifier = T;
  }

  
  /// \brief Set type for the clause.
  ///
  /// \param T Type for the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::setMapType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3324,
   FQN="clang::OMPMapClause::setMapType", NM="_ZN5clang12OMPMapClause10setMapTypeENS_19OpenMPMapClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause10setMapTypeENS_19OpenMPMapClauseKindE")
  //</editor-fold>
  /*friend*/public void setMapType(OpenMPMapClauseKind T) {
    MapType = T;
  }

  
  /// \brief Set type location.
  ///
  /// \param TLoc Type location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::setMapLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3330,
   FQN="clang::OMPMapClause::setMapLoc", NM="_ZN5clang12OMPMapClause9setMapLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause9setMapLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setMapLoc(SourceLocation TLoc) {
    MapLoc.$assign(TLoc);
  }

  
  /// \brief Set colon location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3333,
   FQN="clang::OMPMapClause::setColonLoc", NM="_ZN5clang12OMPMapClause11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setColonLoc(SourceLocation Loc) {
    ColonLoc.$assign(Loc);
  }

  
  /// \brief Build a clause for \a NumVars listed expressions, \a
  /// NumUniqueDeclarations declarations, \a NumComponentLists total component
  /// lists, and \a NumComponents total expression components.
  ///
  /// \param MapTypeModifier Map type modifier.
  /// \param MapType Map type.
  /// \param MapTypeIsImplicit Map type is inferred implicitly.
  /// \param MapLoc Location of the map type.
  /// \param StartLoc Starting location of the clause.
  /// \param EndLoc Ending location of the clause.
  /// \param NumVars Number of expressions listed in this clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of component lists in this clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::OMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3351,
   FQN="clang::OMPMapClause::OMPMapClause", NM="_ZN5clang12OMPMapClauseC1ENS_19OpenMPMapClauseKindES1_bNS_14SourceLocationES2_S2_S2_jjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClauseC1ENS_19OpenMPMapClauseKindES1_bNS_14SourceLocationES2_S2_S2_jjjj")
  //</editor-fold>
  private /*explicit*/ OMPMapClause(OpenMPMapClauseKind MapTypeModifier, 
      OpenMPMapClauseKind MapType, boolean MapTypeIsImplicit, 
      SourceLocation MapLoc, SourceLocation StartLoc, 
      SourceLocation LParenLoc, SourceLocation EndLoc, 
      /*uint*/int NumVars, /*uint*/int NumUniqueDeclarations, 
      /*uint*/int NumComponentLists, /*uint*/int NumComponents) {
    // : OMPMappableExprListClause<OMPMapClause>(OMPC_map, StartLoc, LParenLoc, EndLoc, NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents), TrailingObjects<OMPMapClause, Expr * , ValueDecl * , unsigned int, OMPClauseMappableExprCommon::MappableComponent>(), MapTypeModifier(MapTypeModifier), MapType(MapType), MapTypeIsImplicit(MapTypeIsImplicit), MapLoc(MapLoc), ColonLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_map, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
        NumVars, NumUniqueDeclarations, 
        NumComponentLists, NumComponents);
    $TrailingObjects();
    this.MapTypeModifier = MapTypeModifier;
    this.MapType = MapType;
    this.MapTypeIsImplicit = MapTypeIsImplicit;
    this.MapLoc = new SourceLocation(MapLoc);
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

  
  /// \brief Build an empty clause.
  ///
  /// \param NumVars Number of expressions listed in this clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of component lists in this clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::OMPMapClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3371,
   FQN="clang::OMPMapClause::OMPMapClause", NM="_ZN5clang12OMPMapClauseC1Ejjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClauseC1Ejjjj")
  //</editor-fold>
  private /*explicit*/ OMPMapClause(/*uint*/int NumVars, /*uint*/int NumUniqueDeclarations, 
      /*uint*/int NumComponentLists, /*uint*/int NumComponents) {
    // : OMPMappableExprListClause<OMPMapClause>(OMPC_map, SourceLocation(), SourceLocation(), SourceLocation(), NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents), TrailingObjects<OMPMapClause, Expr * , ValueDecl * , unsigned int, OMPClauseMappableExprCommon::MappableComponent>(), MapTypeModifier(OMPC_MAP_unknown), MapType(OMPC_MAP_unknown), MapTypeIsImplicit(false), MapLoc(), ColonLoc() 
    //START JInit
    super(OpenMPClauseKind.OMPC_map, new SourceLocation(), new SourceLocation(), new SourceLocation(), 
        NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents);
    $TrailingObjects();
    this.MapTypeModifier = OpenMPMapClauseKind.OMPC_MAP_unknown;
    this.MapType = OpenMPMapClauseKind.OMPC_MAP_unknown;
    this.MapTypeIsImplicit = false;
    this.MapLoc = new SourceLocation();
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  /// \brief Creates clause with a list of variables \a VL.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the clause.
  /// \param EndLoc Ending location of the clause.
  /// \param Vars The original expression used in the clause.
  /// \param Declarations Declarations used in the clause.
  /// \param ComponentLists Component lists used in the clause.
  /// \param TypeModifier Map type modifier.
  /// \param Type Map type.
  /// \param TypeIsImplicit Map type is inferred implicitly.
  /// \param TypeLoc Location of the map type.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::Create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 583,
   FQN="clang::OMPMapClause::Create", NM="_ZN5clang12OMPMapClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEENS6_IPNS_9ValueDeclEEENS6_INS5_11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEEEENS_19OpenMPMapClauseKindESI_bS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause6CreateERKNS_10ASTContextENS_14SourceLocationES4_S4_N4llvm8ArrayRefIPNS_4ExprEEENS6_IPNS_9ValueDeclEEENS6_INS5_11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEEEENS_19OpenMPMapClauseKindESI_bS4_")
  //</editor-fold>
  public static OMPMapClause /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, 
        SourceLocation LParenLoc, SourceLocation EndLoc, 
        ArrayRef<Expr /*P*/ > Vars, ArrayRef<ValueDecl /*P*/ > Declarations, 
        ArrayRef<SmallVector<MappableComponent>> ComponentLists, 
        OpenMPMapClauseKind TypeModifier, OpenMPMapClauseKind Type, 
        boolean TypeIsImplicit, SourceLocation TypeLoc) {
    
    /*uint*/int NumVars = Vars.size();
    /*uint*/int NumUniqueDeclarations = OMPClauseMappableExprCommon.getUniqueDeclarationsTotalNumber(new ArrayRef<ValueDecl /*P*/ >(Declarations));
    /*uint*/int NumComponentLists = ComponentLists.size();
    /*uint*/int NumComponents = OMPClauseMappableExprCommon.getComponentsTotalNumber(new ArrayRef<SmallVector<MappableComponent>>(ComponentLists));
    
    // We need to allocate:
    // NumVars x Expr* - we have an original list expression for each clause list
    // entry.
    // NumUniqueDeclarations x ValueDecl* - unique base declarations associated
    // with each component list.
    // (NumUniqueDeclarations + NumComponentLists) x unsigned - we specify the
    // number of lists for each unique declaration and the size of each component
    // list.
    // NumComponents x MappableComponent - the total of all the components in all
    // the lists.
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, ValueDecl.class, int.class, MappableComponent.class, NumVars, NumUniqueDeclarations, NumUniqueDeclarations + NumComponentLists, NumComponents));
    OMPMapClause /*P*/ Clause = /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPMapClause(TypeModifier, Type, TypeIsImplicit, new SourceLocation(TypeLoc), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
                NumVars, NumUniqueDeclarations, NumComponentLists, NumComponents);
     });
    
    Clause.setVarRefs(new ArrayRef<Expr /*P*/ >(Vars));
    Clause.setClauseInfo(new ArrayRef<ValueDecl /*P*/ >(Declarations), new ArrayRef<SmallVector<MappableComponent>>(ComponentLists));
    Clause.setMapTypeModifier(TypeModifier);
    Clause.setMapType(Type);
    Clause.setMapLoc(new SourceLocation(TypeLoc));
    return Clause;
  }

  /// \brief Creates an empty clause with the place for for \a NumVars original
  /// expressions, \a NumUniqueDeclarations declarations, \NumComponentLists
  /// lists, and \a NumComponents expression components.
  ///
  /// \param C AST context.
  /// \param NumVars Number of expressions listed in the clause.
  /// \param NumUniqueDeclarations Number of unique base declarations in this
  /// clause.
  /// \param NumComponentLists Number of unique base declarations in this
  /// clause.
  /// \param NumComponents Total number of expression components in the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp", line = 624,
   FQN="clang::OMPMapClause::CreateEmpty", NM="_ZN5clang12OMPMapClause11CreateEmptyERKNS_10ASTContextEjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause11CreateEmptyERKNS_10ASTContextEjjjj")
  //</editor-fold>
  public static OMPMapClause /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, /*uint*/int NumVars, 
             /*uint*/int NumUniqueDeclarations, 
             /*uint*/int NumComponentLists, 
             /*uint*/int NumComponents) {
    Object/*void P*/ Mem = C.Allocate(TrailingObjects.totalSizeToAlloc$Same(Expr.class, ValueDecl.class, int.class, MappableComponent.class, NumVars, NumUniqueDeclarations, NumUniqueDeclarations + NumComponentLists, NumComponents));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new OMPMapClause(NumVars, NumUniqueDeclarations, 
                NumComponentLists, NumComponents);
     });
  }

  
  /// \brief Fetches mapping kind for the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::getMapType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3419,
   FQN="clang::OMPMapClause::getMapType", NM="_ZNK5clang12OMPMapClause10getMapTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause10getMapTypeEv")
  //</editor-fold>
  public OpenMPMapClauseKind getMapType() /*const*//* __attribute__((pure))*/ {
    return MapType;
  }

  
  /// \brief Is this an implicit map type?
  /// We have to capture 'IsMapTypeImplicit' from the parser for more
  /// informative error messages.  It helps distinguish map(r) from
  /// map(tofrom: r), which is important to print more helpful error
  /// messages for some target directives.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::isImplicitMapType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3426,
   FQN="clang::OMPMapClause::isImplicitMapType", NM="_ZNK5clang12OMPMapClause17isImplicitMapTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause17isImplicitMapTypeEv")
  //</editor-fold>
  public boolean isImplicitMapType() /*const*//* __attribute__((pure))*/ {
    return MapTypeIsImplicit;
  }

  
  /// \brief Fetches the map type modifier for the clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::getMapTypeModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3429,
   FQN="clang::OMPMapClause::getMapTypeModifier", NM="_ZNK5clang12OMPMapClause18getMapTypeModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause18getMapTypeModifierEv")
  //</editor-fold>
  public OpenMPMapClauseKind getMapTypeModifier() /*const*//* __attribute__((pure))*/ {
    return MapTypeModifier;
  }

  
  /// \brief Fetches location of clause mapping kind.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::getMapLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3434,
   FQN="clang::OMPMapClause::getMapLoc", NM="_ZNK5clang12OMPMapClause9getMapLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause9getMapLocEv")
  //</editor-fold>
  public SourceLocation getMapLoc() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(MapLoc);
  }

  
  /// \brief Get colon location.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3437,
   FQN="clang::OMPMapClause::getColonLoc", NM="_ZNK5clang12OMPMapClause11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang12OMPMapClause11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3439,
   FQN="clang::OMPMapClause::classof", NM="_ZN5clang12OMPMapClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_map;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPMapClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3443,
   FQN="clang::OMPMapClause::children", NM="_ZN5clang12OMPMapClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang12OMPMapClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_begin()))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, varlist_end()))));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { return numTrailingObjects_OverloadToken$Expr$P((OverloadToken<Expr /*P*/>)null); }
  
  @Override public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy2() { return numTrailingObjects_OverloadToken$ValueDecl$P((OverloadToken<ValueDecl /*P*/>)null); }
  
  @Override public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy3() { return numTrailingObjects_OverloadTokenUInt((OverloadTokenUInt)null); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "MapTypeModifier=" + MapTypeModifier // NOI18N
              + ", MapType=" + MapType // NOI18N
              + ", MapTypeIsImplicit=" + MapTypeIsImplicit // NOI18N
              + ", MapLoc=" + MapLoc // NOI18N
              + ", ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}

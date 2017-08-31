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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.java.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// Declaration of a redeclarable template.
//<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*instantiations were introduced*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 629,
 FQN="clang::RedeclarableTemplateDecl", NM="_ZN5clang24RedeclarableTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDeclE")
//</editor-fold>
public abstract class RedeclarableTemplateDecl extends /*public*/ TemplateDecl implements /*public*/ Redeclarable<RedeclarableTemplateDecl>, Destructors.ClassWithDestructor {
  /*typedef Redeclarable<RedeclarableTemplateDecl> redeclarable_base*/
//  public final class redeclarable_base extends Redeclarable<RedeclarableTemplateDecl>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getNextRedeclarationImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 633,
   FQN="clang::RedeclarableTemplateDecl::getNextRedeclarationImpl", NM="_ZN5clang24RedeclarableTemplateDecl24getNextRedeclarationImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl24getNextRedeclarationImplEv")
  //</editor-fold>
  @Override protected/*private*/ RedeclarableTemplateDecl /*P*/ getNextRedeclarationImpl()/* override*/ {
    return getNextRedeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getPreviousDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 636,
   FQN="clang::RedeclarableTemplateDecl::getPreviousDeclImpl", NM="_ZN5clang24RedeclarableTemplateDecl19getPreviousDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl19getPreviousDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ RedeclarableTemplateDecl /*P*/ getPreviousDeclImpl()/* override*/ {
    return getPreviousDecl$Redeclarable();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getMostRecentDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 639,
   FQN="clang::RedeclarableTemplateDecl::getMostRecentDeclImpl", NM="_ZN5clang24RedeclarableTemplateDecl21getMostRecentDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21getMostRecentDeclImplEv")
  //</editor-fold>
  @Override protected/*private*/ RedeclarableTemplateDecl /*P*/ getMostRecentDeclImpl()/* override*/ {
    return getMostRecentDecl$Redeclarable();
  }

/*protected:*/
  /*template <typename EntryType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecEntryTraits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*template params and trailing info*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 644,
   FQN="clang::RedeclarableTemplateDecl::SpecEntryTraits", NM="_ZN5clang24RedeclarableTemplateDecl15SpecEntryTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl15SpecEntryTraitsE")
  //</editor-fold>
  public static class/*struct*/ SpecEntryTraits</*typename*/ EntryType extends HasGetTemplateArgs$TemplateArgumentList & Redeclarable/*<EntryType>*/>  implements SpecEntryTraits$Info<EntryType, EntryType> {
    /*typedef EntryType DeclType*/
//    public final class DeclType extends EntryType{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecEntryTraits::getDecl">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 647,
     FQN="clang::RedeclarableTemplateDecl::SpecEntryTraits::getDecl", NM="_ZN5clang24RedeclarableTemplateDecl15SpecEntryTraits7getDeclEPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl15SpecEntryTraits7getDeclEPT_")
    //</editor-fold>
    public EntryType /*P*/ getDecl(EntryType /*P*/ D) {
      return D;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecEntryTraits::getTemplateArgs">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 650,
     FQN="clang::RedeclarableTemplateDecl::SpecEntryTraits::getTemplateArgs", NM="_ZN5clang24RedeclarableTemplateDecl15SpecEntryTraits15getTemplateArgsEPT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl15SpecEntryTraits15getTemplateArgsEPT_")
    //</editor-fold>
    public ArrayRef<TemplateArgument> getTemplateArgs(EntryType /*P*/ D) {
      return D.getTemplateArgs().asArray();
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private SpecEntryTraits() { }
    
    private static final SpecEntryTraits$Info $INFO = new SpecEntryTraits();
    
    public static <EntryType extends HasGetTemplateArgs$TemplateArgumentList & Redeclarable/*<EntryType>*/> SpecEntryTraits$Info<EntryType, EntryType> $Info() { return (SpecEntryTraits$Info<EntryType, EntryType>)$INFO; }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /*template <typename EntryType, typename SETraits = SpecEntryTraits<EntryType>, typename DeclType = typename SETraits::DeclType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*template params and trailing info*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 655,
   FQN="clang::RedeclarableTemplateDecl::SpecIterator", NM="_ZN5clang24RedeclarableTemplateDecl12SpecIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl12SpecIteratorE")
  //</editor-fold>
  public static class/*struct*/ SpecIterator</*typename*/ EntryType, /*, typename SETraits = SpecEntryTraits<EntryType>*/ /*typename*/ DeclType extends Redeclarable/*<DeclType>*//* = typename SETraits::DeclType*/>  extends /**/ iterator_adaptor_base<SpecIterator<EntryType, DeclType>, type$iterator<?, EntryType>,  std.iterator<?, type$iterator<?, EntryType> >, DeclType /*P*/, DeclType /*P*/> {
    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecIterator::SpecIterator<EntryType, SETraits, DeclType>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 664,
     FQN="clang::RedeclarableTemplateDecl::SpecIterator::SpecIterator<EntryType, SETraits, DeclType>", NM="_ZN5clang24RedeclarableTemplateDecl12SpecIteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl12SpecIteratorC1Ev")
    //</editor-fold>
    public SpecIterator(SpecEntryTraits$Info<EntryType, DeclType> Traits) {
      this.SETraits = Traits;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecIterator::SpecIterator<EntryType, SETraits, DeclType>">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 665,
     FQN="clang::RedeclarableTemplateDecl::SpecIterator::SpecIterator<EntryType, SETraits, DeclType>", NM="_ZN5clang24RedeclarableTemplateDecl12SpecIteratorC1EN4llvm16FoldingSetVectorIT_NS2_11SmallVectorIPS4_Lj8EEEE8iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl12SpecIteratorC1EN4llvm16FoldingSetVectorIT_NS2_11SmallVectorIPS4_Lj8EEEE8iteratorE")
    //</editor-fold>
    public /*explicit*/ SpecIterator(type$iterator<?, EntryType> SetIter, SpecEntryTraits$Info<EntryType, DeclType> Traits) {
      // : SpecIterator<EntryType, SETraits, DeclType>::iterator_adaptor_base(std::move(SetIter)) 
      //START JInit
      /*ParenListExpr*/super(std.move(SetIter));
      //END JInit
      this.SETraits = Traits;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecIterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 669,
     FQN="clang::RedeclarableTemplateDecl::SpecIterator::operator*", NM="_ZNK5clang24RedeclarableTemplateDecl12SpecIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl12SpecIteratordeEv")
    //</editor-fold>
    public DeclType /*P*/ $star() /*const*/ {
      return (DeclType)SETraits.getDecl(Native.$addr(this.I.$star())).getMostRecentDecl();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::SpecIterator::operator->">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 672,
     FQN="clang::RedeclarableTemplateDecl::SpecIterator::operator->", NM="_ZNK5clang24RedeclarableTemplateDecl12SpecIteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl12SpecIteratorptEv")
    //</editor-fold>
    public DeclType /*P*/ $arrow() /*const*/ {
      return $star();
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public SpecIterator(SpecIterator $Prm0) { super(JD$BaseOf.INSTANCE, $Prm0); this.SETraits = $Prm0.SETraits; }
    
    @Override public SpecIterator clone() { return new SpecIterator(this); }
    
    private final SpecEntryTraits$Info<EntryType, DeclType> SETraits; // JAVA: moved from template args

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  /*template <typename EntryType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::makeSpecIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 676,
   FQN="clang::RedeclarableTemplateDecl::makeSpecIterator", NM="Tpl__ZN5clang24RedeclarableTemplateDecl16makeSpecIteratorERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl16makeSpecIteratorERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEEb")
  //</editor-fold>
  protected static </*typename*/ EntryType extends FoldingSetImpl.Node & Redeclarable> SpecIterator<EntryType, /*SpecEntryTraits,*/ EntryType> makeSpecIterator(FoldingSetVector<EntryType> /*&*/ Specs, boolean isEnd) {
    return makeSpecIterator(SpecEntryTraits.$Info(), Specs, isEnd);
  }
  protected static </*typename*/ EntryType extends FoldingSetImpl.Node, DeclType extends Redeclarable> SpecIterator<EntryType, DeclType> makeSpecIterator(SpecEntryTraits$Info/*<EntryType, DeclType>*/ Traits, FoldingSetVector<EntryType> /*&*/ Specs, boolean isEnd) {
    return new SpecIterator<EntryType, /*SpecEntryTraits,*/ DeclType>(isEnd ? Specs.end() : Specs.begin(), Traits);
  }

  // JAVA: MOVED TO EXTRA MEMBERS
//  /*template <class EntryType> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
//   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="Tpl__ZN5clang24RedeclarableTemplateDecl22findSpecializationImplERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEENS1_8ArrayRefINS_16TemplateArgumentEEERPv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl22findSpecializationImplERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEENS1_8ArrayRefINS_16TemplateArgumentEEERPv")
//  //</editor-fold>
//  protected </*class*/ EntryType> EntryType/*P*/ findSpecializationImpl(final FoldingSetVector<EntryType> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
//                        final type$ref<type$ptr<Object>>/*void P&*/ InsertPos) {
//    /*typedef SpecEntryTraits<EntryType> SETraits*/
////    final class SETraits extends SpecEntryTraits<EntryType>{ };
//    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
//    EntryType.Profile(ID, Args, getASTContext());
//    EntryType /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
//    return Entry ? SpecEntryTraits.<EntryType>getDecl(Entry).getMostRecentDecl() : null;
//  }

  // JAVA: MOVED TO EXTRA MEMBERS
//  /*template <class Derived, class EntryType> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
//   FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="Tpl__ZN5clang24RedeclarableTemplateDecl21addSpecializationImplERN4llvm16FoldingSetVectorIT0_NS1_11SmallVectorIPS3_Lj8EEEEES5_Pv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl21addSpecializationImplERN4llvm16FoldingSetVectorIT0_NS1_11SmallVectorIPS3_Lj8EEEEES5_Pv")
//  //</editor-fold>
//  protected </*class*/ Derived, /*class*/ EntryType> void addSpecializationImpl(final FoldingSetVector<EntryType> /*&*/ Specializations, EntryType /*P*/ Entry, 
//                       final type$ref<type$ptr<Object>>/*void P&*/ InsertPos) {
//    /*typedef SpecEntryTraits<EntryType> SETraits*/
////    final class SETraits extends SpecEntryTraits<EntryType>{ };
//    if ((InsertPos != null)) {
//      Object/*void P*/ CorrectInsertPos;
//      assert Native.$bool(Native.$not(findSpecializationImpl(Specializations, SpecEntryTraits.<EntryType>getTemplateArgs(Entry), CorrectInsertPos)) && $eq_ptr(InsertPos, CorrectInsertPos)) : "given incorrect InsertPos for specialization";
//      Specializations.InsertNode(Entry, InsertPos);
//    } else {
//      EntryType /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
//      ///*J:(void)*/Existing;
//      assert Native.$bool(SpecEntryTraits.<EntryType>getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
//    }
//    {
//      
//      ASTMutationListener /*P*/ L = getASTMutationListener();
//      if ((L != null)) {
//        L.AddedCXXTemplateSpecialization(cast<Derived>(this), 
//            SpecEntryTraits.<EntryType>getDecl(Entry));
//      }
//    }
//  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::CommonBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 689,
   FQN="clang::RedeclarableTemplateDecl::CommonBase", NM="_ZN5clang24RedeclarableTemplateDecl10CommonBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl10CommonBaseE")
  //</editor-fold>
  /*friend*/public static class/*struct*/ CommonBase {
    //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::CommonBase::CommonBase">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 690,
     FQN="clang::RedeclarableTemplateDecl::CommonBase::CommonBase", NM="_ZN5clang24RedeclarableTemplateDecl10CommonBaseC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl10CommonBaseC1Ev")
    //</editor-fold>
    public CommonBase() {
      // : InstantiatedFromMember(null, false) 
      //START JInit
      this.InstantiatedFromMember = new PointerBoolPair<RedeclarableTemplateDecl /*P*/ >((RedeclarableTemplateDecl /*P*/ )null, false);
      //END JInit
    }

    
    /// \brief The template from which this was most
    /// directly instantiated (or null).
    ///
    /// The boolean value indicates whether this template
    /// was explicitly specialized.
    public PointerBoolPair<RedeclarableTemplateDecl /*P*/ > InstantiatedFromMember;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    /// \brief If non-null, points to an array of specializations (including
    /// partial specializations) known only by their external declaration IDs.
    ///
    /// The first value in the array is the number of of specializations/
    /// partial specializations that follow.
    //JAVA extracted field from paren classes
    public /*uint32_t P*/uint$ptr LazySpecializations;

    public void $destroy() { }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "InstantiatedFromMember=" + InstantiatedFromMember; // NOI18N
    }
  };
  
  /// \brief Pointer to the common data shared by all declarations of this
  /// template.
  /*friend*/public /*mutable */CommonBase /*P*/ Common;
  
  /// \brief Retrieves the "common" pointer shared by all (re-)declarations of
  /// the same template. Calling this routine may implicitly allocate memory
  /// for the common pointer.
  
  //===----------------------------------------------------------------------===//
  // RedeclarableTemplateDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getCommonPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 129,
   FQN="clang::RedeclarableTemplateDecl::getCommonPtr", NM="_ZNK5clang24RedeclarableTemplateDecl12getCommonPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl12getCommonPtrEv")
  //</editor-fold>
  /*friend*/public RedeclarableTemplateDecl.CommonBase /*P*/ getCommonPtr() /*const*/ {
    if ((Common != null)) {
      return Common;
    }
    
    // Walk the previous-declaration chain until we either find a declaration
    // with a common pointer or we run out of previous declarations.
    SmallVector</*const*/ RedeclarableTemplateDecl /*P*/ > PrevDecls/*J*/= new SmallVector</*const*/ RedeclarableTemplateDecl /*P*/ >(2, (/*const*/ RedeclarableTemplateDecl /*P*/ )null);
    for (/*const*/ RedeclarableTemplateDecl /*P*/ Prev = getPreviousDecl$Redeclarable$Const(); (Prev != null);
         Prev = Prev.getPreviousDecl$Redeclarable$Const()) {
      if ((Prev.Common != null)) {
        Common = Prev.Common;
        break;
      }
      
      PrevDecls.push_back(Prev);
    }
    
    // If we never found a common pointer, allocate one now.
    if (!(Common != null)) {
      // FIXME: If any of the declarations is from an AST file, we probably
      // need an update record to add the common data.
      Common = newCommon(getASTContext());
    }
    
    // Update any previous declarations we saw with the common pointer.
    for (/*const*/ RedeclarableTemplateDecl /*P*/ Prev : PrevDecls)  {
      Prev.Common = Common;
    }
    
    return Common;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::newCommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 710,
   FQN="clang::RedeclarableTemplateDecl::newCommon", NM="_ZNK5clang24RedeclarableTemplateDecl9newCommonERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl9newCommonERNS_10ASTContextE")
  //</editor-fold>
  /*friend*/public abstract /*virtual*/ CommonBase /*P*/ newCommon(final ASTContext /*&*/ C) /*const*//* = 0*/;

  
  // Construct a template decl with name, parameters, and templated element.
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::RedeclarableTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 713,
   FQN="clang::RedeclarableTemplateDecl::RedeclarableTemplateDecl", NM="_ZN5clang24RedeclarableTemplateDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDeclC1ENS_4Decl4KindERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameEPNS_21TemplateParameterListEPNS_9NamedDeclE")
  //</editor-fold>
  protected RedeclarableTemplateDecl(Kind DK, final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
      SourceLocation L, DeclarationName Name, 
      TemplateParameterList /*P*/ Params, NamedDecl /*P*/ Decl) {
    // : TemplateDecl(DK, DC, L, Name, Params, Decl), redeclarable_base(C), Common(implicit CommonBase * ()) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(Name), Params, Decl);
    this.Redeclarable$Flds = $Redeclarable(C);
    this.Common = /*implicit-init*/((CommonBase /*P*/ )/*zero-init*/null);
    //END JInit
  }

/*public:*/
  /*friend template <class decl_type> class RedeclarableTemplate*/
  
  /// \brief Retrieves the canonical declaration of this template.
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 723,
   FQN="clang::RedeclarableTemplateDecl::getCanonicalDecl", NM="_ZN5clang24RedeclarableTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public RedeclarableTemplateDecl /*P*/ getCanonicalDecl()/* override*/ {
    return getFirstDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 726,
   FQN="clang::RedeclarableTemplateDecl::getCanonicalDecl", NM="_ZNK5clang24RedeclarableTemplateDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ RedeclarableTemplateDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return getFirstDecl$Const();
  }

  
  /// \brief Determines whether this template was a specialization of a
  /// member template.
  ///
  /// In the following example, the function template \c X<int>::f and the
  /// member template \c X<int>::Inner are member specializations.
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   template<typename U> void f(T, U);
  ///   template<typename U> struct Inner;
  /// };
  ///
  /// template<> template<typename T>
  /// void X<int>::f(int, T);
  /// template<> template<typename T>
  /// struct X<int>::Inner { /* ... */ };
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::isMemberSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 748,
   FQN="clang::RedeclarableTemplateDecl::isMemberSpecialization", NM="_ZNK5clang24RedeclarableTemplateDecl22isMemberSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl22isMemberSpecializationEv")
  //</editor-fold>
  public boolean isMemberSpecialization() /*const*/ {
    return getCommonPtr().InstantiatedFromMember.getInt();
  }

  
  /// \brief Note that this member template is a specialization.
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::setMemberSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 753,
   FQN="clang::RedeclarableTemplateDecl::setMemberSpecialization", NM="_ZN5clang24RedeclarableTemplateDecl23setMemberSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl23setMemberSpecializationEv")
  //</editor-fold>
  public void setMemberSpecialization() {
    assert ((getCommonPtr().InstantiatedFromMember.getPointer() != null)) : "Only member templates can be member template specializations";
    getCommonPtr().InstantiatedFromMember.setInt(true);
  }

  
  /// \brief Retrieve the member template from which this template was
  /// instantiated, or NULL if this template was not instantiated from a 
  /// member template.
  ///
  /// A template is instantiated from a member template when the member 
  /// template itself is part of a class template (or member thereof). For
  /// example, given
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   template<typename U> void f(T, U);
  /// };
  ///
  /// void test(X<int> x) {
  ///   x.f(1, 'a');
  /// };
  /// \endcode
  ///
  /// \c X<int>::f is a FunctionTemplateDecl that describes the function
  /// template
  ///
  /// \code
  /// template<typename U> void X<int>::f(int, U);
  /// \endcode
  ///
  /// which was itself created during the instantiation of \c X<int>. Calling
  /// getInstantiatedFromMemberTemplate() on this FunctionTemplateDecl will
  /// retrieve the FunctionTemplateDecl for the original template \c f within
  /// the class template \c X<T>, i.e.,
  ///
  /// \code
  /// template<typename T>
  /// template<typename U>
  /// void X<T>::f(T, U);
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::getInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 795,
   FQN="clang::RedeclarableTemplateDecl::getInstantiatedFromMemberTemplate", NM="_ZNK5clang24RedeclarableTemplateDecl33getInstantiatedFromMemberTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24RedeclarableTemplateDecl33getInstantiatedFromMemberTemplateEv")
  //</editor-fold>
  public RedeclarableTemplateDecl /*P*/ getInstantiatedFromMemberTemplate() /*const*/ {
    return getCommonPtr().InstantiatedFromMember.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::setInstantiatedFromMemberTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 799,
   FQN="clang::RedeclarableTemplateDecl::setInstantiatedFromMemberTemplate", NM="_ZN5clang24RedeclarableTemplateDecl33setInstantiatedFromMemberTemplateEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl33setInstantiatedFromMemberTemplateEPS0_")
  //</editor-fold>
  public void setInstantiatedFromMemberTemplate(RedeclarableTemplateDecl /*P*/ TD) {
    assert (!(getCommonPtr().InstantiatedFromMember.getPointer() != null));
    getCommonPtr().InstantiatedFromMember.setPointer(TD);
  }

  
  /*typedef redeclarable_base::redecl_range redecl_range*/
//  public final class redecl_range extends iterator_range<redecl_iterator>{ };
  /*typedef redeclarable_base::redecl_iterator redecl_iterator*/
//  public final class redecl_iterator extends Redeclarable.<RedeclarableTemplateDecl>redecl_iterator{ };
  //JAVA: using Redeclarable<RedeclarableTemplateDecl>::redecls_begin;
  //JAVA: using Redeclarable<RedeclarableTemplateDecl>::redecls_end;
  //JAVA: using Redeclarable<RedeclarableTemplateDecl>::redecls;
  //JAVA: using Redeclarable<RedeclarableTemplateDecl>::getPreviousDecl;
  //JAVA: using Redeclarable<RedeclarableTemplateDecl>::getMostRecentDecl;
  //JAVA: using Redeclarable<RedeclarableTemplateDecl>::isFirstDecl;
  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 814,
   FQN="clang::RedeclarableTemplateDecl::classof", NM="_ZN5clang24RedeclarableTemplateDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 815,
   FQN="clang::RedeclarableTemplateDecl::classofKind", NM="_ZN5clang24RedeclarableTemplateDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstRedeclarableTemplate.getValue() && K.getValue() <= Kind.lastRedeclarableTemplate.getValue();
  }

  
  /*friend  class ASTReader*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::~RedeclarableTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 629,
   FQN="clang::RedeclarableTemplateDecl::~RedeclarableTemplateDecl", NM="_ZN5clang24RedeclarableTemplateDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    Redeclarable.super.$destroy$Redeclarable();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public/*derived non-final*/ RedeclarableTemplateDecl getPreviousDecl() { 
    return (RedeclarableTemplateDecl)Redeclarable.super.getPreviousDecl$Redeclarable(); 
  } 
  
  @Override 
  public/*derived non-final*/ RedeclarableTemplateDecl getPreviousDecl$Const() { 
    return (RedeclarableTemplateDecl)Redeclarable.super.getPreviousDecl$Redeclarable$Const(); 
  } 
   
  @Override 
  public/*derived non-final*/ RedeclarableTemplateDecl getMostRecentDecl() { 
    return (RedeclarableTemplateDecl)Redeclarable.super.getMostRecentDecl$Redeclarable(); 
  } 
  
  @Override 
  public/*derived non-final*/ RedeclarableTemplateDecl getMostRecentDecl$Const() { 
    return (RedeclarableTemplateDecl)Redeclarable.super.getMostRecentDecl$Redeclarable$Const(); 
  } 
  
  @Override 
  public final boolean isFirstDecl() { 
    return Redeclarable.super.isFirstDecl$Redeclarable(); 
  } 
  
  /////////////////////////////////////////////////////////////////////////////////
  /// instantiations of clang::RedeclarableTemplateDecl::findSpecializationImpl ///
  
  /*template <class EntryType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="Tpl__ZN5clang24RedeclarableTemplateDecl22findSpecializationImplERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEENS1_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl22findSpecializationImplERN4llvm16FoldingSetVectorIT_NS1_11SmallVectorIPS3_Lj8EEEEENS1_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final </*class*/ EntryType extends FoldingSetImpl.Node> EntryType/*P*/ findSpecializationImpl(final FoldingSetVector<EntryType> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<?>>/*void P&*/ InsertPos) {
    throw new IllegalStateException("Specialized method from EXTRA MEMBERS must be used");
  }
  
  //</*class*/ EntryType/* = FunctionTemplateSpecializationInfo*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_34FunctionTemplateSpecializationInfoEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_34FunctionTemplateSpecializationInfoEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final FunctionDecl /*P*/ findSpecializationImpl$FunctionDecl(final FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>>/*void P&*/ InsertPos) {
    /*typedef SpecEntryTraits<FunctionTemplateSpecializationInfo> SETraits*/
  //  final class SETraits extends SpecEntryTraitsFunctionTemplateSpecializationInfo{ };
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    FunctionTemplateSpecializationInfo.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
    FunctionTemplateSpecializationInfo /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
    return (Entry != null) ? SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Entry).getMostRecentDecl() : null;
  }
  //</*class*/ EntryType/* = ClassTemplateSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_31ClassTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_31ClassTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final ClassTemplateSpecializationDecl /*P*/ findSpecializationImpl$ClassTemplateSpecializationDecl(final FoldingSetVector<ClassTemplateSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    /*typedef SpecEntryTraits<ClassTemplateSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<ClassTemplateSpecializationDecl>{ };
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ClassTemplateSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
    ClassTemplateSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
    return (Entry != null) ? SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
  }
  //</*class*/ EntryType/* = ClassTemplatePartialSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_38ClassTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_38ClassTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final ClassTemplatePartialSpecializationDecl /*P*/ findSpecializationImpl$ClassTemplatePartialSpecializationDecl(final FoldingSetVector<ClassTemplatePartialSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<ClassTemplatePartialSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    /*typedef SpecEntryTraits<ClassTemplatePartialSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<ClassTemplatePartialSpecializationDecl>{ };
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ClassTemplatePartialSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
    ClassTemplatePartialSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
    return (Entry != null) ? SpecEntryTraits.<ClassTemplatePartialSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
  }
  //</*class*/ EntryType/* = VarTemplateSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_29VarTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_29VarTemplateSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final VarTemplateSpecializationDecl /*P*/ findSpecializationImpl$VarTemplateSpecializationDecl(final FoldingSetVector<VarTemplateSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    /*typedef SpecEntryTraits<VarTemplateSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<VarTemplateSpecializationDecl>{ };
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    VarTemplateSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
    VarTemplateSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
    return (Entry != null) ? SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
  }
  //</*class*/ EntryType/* = VarTemplatePartialSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final VarTemplatePartialSpecializationDecl /*P*/ findSpecializationImpl$VarTemplatePartialSpecializationDecl(final FoldingSetVector<VarTemplatePartialSpecializationDecl> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<VarTemplatePartialSpecializationDecl /*P*/>>/*void P&*/ InsertPos) {
    /*typedef SpecEntryTraits<VarTemplatePartialSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<VarTemplatePartialSpecializationDecl>{ };
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    VarTemplatePartialSpecializationDecl.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
    VarTemplatePartialSpecializationDecl /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
    return (Entry != null) ? SpecEntryTraits.<VarTemplatePartialSpecializationDecl>$Info().getDecl(Entry).getMostRecentDecl() : null;
  }
  
  //</*class*/ EntryType/* = FunctionTemplateSpecializationInfo*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::findSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 162,
   FQN="clang::RedeclarableTemplateDecl::findSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl22findSpecializationImplINS_36VarTemplatePartialSpecializationDeclEEEPNS0_15SpecEntryTraitsIT_E8DeclTypeERN4llvm16FoldingSetVectorIS4_NS8_11SmallVectorIPS4_Lj8EEEEENS8_8ArrayRefINS_16TemplateArgumentEEERPv")
  //</editor-fold>
  protected final FunctionDecl /*P*/ findSpecializationImpl$FunctionTemplateSpecializationInfo(final FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ Specs, ArrayRef<TemplateArgument> Args, 
                        final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>>/*void P&*/ InsertPos) {
    /*typedef SpecEntryTraits<VarTemplatePartialSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<VarTemplatePartialSpecializationDecl>{ };
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    FunctionTemplateSpecializationInfo.Profile(ID, new ArrayRef<TemplateArgument>(Args), getASTContext());
    FunctionTemplateSpecializationInfo /*P*/ Entry = Specs.FindNodeOrInsertPos(ID, InsertPos);
    return (Entry != null) ? SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Entry).getMostRecentDecl() : null;
  }
  
  /// end of instantiations clang::RedeclarableTemplateDecl::findSpecializationImpl
  /////////////////////////////////////////////////////////////////////////////////
  
  /////////////////////////////////////////////////////////////////////////////////
  /// instantiations clang::RedeclarableTemplateDecl::addSpecializationImpl
  
  /*template <class Derived, class EntryType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
   FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="Tpl__ZN5clang24RedeclarableTemplateDecl21addSpecializationImplERN4llvm16FoldingSetVectorIT0_NS1_11SmallVectorIPS3_Lj8EEEEES5_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=Tpl__ZN5clang24RedeclarableTemplateDecl21addSpecializationImplERN4llvm16FoldingSetVectorIT0_NS1_11SmallVectorIPS3_Lj8EEEEES5_Pv")
  //</editor-fold>
  protected final </*class*/ Derived, /*class*/ EntryType> void addSpecializationImpl(final FoldingSetVector<?> /*&*/ Specializations, EntryType /*P*/ Entry, 
                       type$ptr<?>/*void P*/ InsertPos) {
    throw new IllegalStateException("Specialized method from EXTRA MEMBERS must be used");
  }
  
  //</*class*/ Derived/* = FunctionTemplateDecl*/, /*class*/ EntryType/* = FunctionTemplateSpecializationInfo*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
   FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_20FunctionTemplateDeclENS_34FunctionTemplateSpecializationInfoEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_20FunctionTemplateDeclENS_34FunctionTemplateSpecializationInfoEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv")
  //</editor-fold>
  protected final void addSpecializationImpl$FunctionTemplateSpecializationInfo(final FoldingSetVector<FunctionTemplateSpecializationInfo> /*&*/ Specializations, FunctionTemplateSpecializationInfo /*P*/ Entry, 
                       type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ InsertPos) {
    /*typedef SpecEntryTraits<FunctionTemplateSpecializationInfo> SETraits*/
  //  final class SETraits extends SpecEntryTraitsFunctionTemplateSpecializationInfo{ };
    if ((InsertPos != null)) {
      final type$ref<type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ > CorrectInsertPos = create_type$ref();
      assert (!(findSpecializationImpl$FunctionDecl(Specializations, SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getTemplateArgs(Entry), CorrectInsertPos) != null) && $eq_ptr(InsertPos, CorrectInsertPos.$deref())) : "given incorrect InsertPos for specialization";
      Specializations.InsertNode(Entry, InsertPos);
    } else {
      FunctionTemplateSpecializationInfo /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
      ///*J:(void)*/Existing;
      assert (SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
    }
    {
  
      ASTMutationListener /*P*/ L = getASTMutationListener();
      if ((L != null)) {
        L.AddedCXXTemplateSpecialization(cast_FunctionTemplateDecl(this), 
            SpecEntryTraitsFunctionTemplateSpecializationInfo.$Info().getDecl(Entry));
      }
    }
  }
  
  //  </*class*/ Derived/* = ClassTemplateDecl*/, /*class*/ EntryType/* = ClassTemplateSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
   FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_17ClassTemplateDeclENS_31ClassTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_17ClassTemplateDeclENS_31ClassTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv")
  //</editor-fold>
  protected final void addSpecializationImpl$ClassTemplateSpecializationDecl(final FoldingSetVector<ClassTemplateSpecializationDecl> /*&*/ Specializations, ClassTemplateSpecializationDecl /*P*/ Entry, 
                       type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos) {
    /*typedef SpecEntryTraits<ClassTemplateSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<ClassTemplateSpecializationDecl>{ };
    if ((InsertPos != null)) {
      final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ > CorrectInsertPos = create_type$ref();
      assert (!(findSpecializationImpl$ClassTemplateSpecializationDecl(Specializations, SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getTemplateArgs(Entry), CorrectInsertPos) != null) && $eq_ptr(InsertPos, CorrectInsertPos.$deref())) : "given incorrect InsertPos for specialization";
      Specializations.InsertNode(Entry, InsertPos);
    } else {
      ClassTemplateSpecializationDecl /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
      ///*J:(void)*/Existing;
      assert (SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
    }
    {
  
      ASTMutationListener /*P*/ L = getASTMutationListener();
      if ((L != null)) {
        L.AddedCXXTemplateSpecialization(cast_ClassTemplateDecl(this), 
            SpecEntryTraits.<ClassTemplateSpecializationDecl>$Info().getDecl(Entry));
      }
    }
  }
  
  //</*class*/ Derived/* = VarTemplateDecl*/, /*class*/ EntryType/* = VarTemplateSpecializationDecl*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::RedeclarableTemplateDecl::addSpecializationImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specialization were generated*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 174,
   FQN="clang::RedeclarableTemplateDecl::addSpecializationImpl", NM="_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_15VarTemplateDeclENS_29VarTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24RedeclarableTemplateDecl21addSpecializationImplINS_15VarTemplateDeclENS_29VarTemplateSpecializationDeclEEEvRN4llvm16FoldingSetVectorIT0_NS4_11SmallVectorIPS6_Lj8EEEEES8_Pv")
  //</editor-fold>
  protected final void addSpecializationImpl$VarTemplateSpecializationDecl(final FoldingSetVector<VarTemplateSpecializationDecl> /*&*/ Specializations, VarTemplateSpecializationDecl /*P*/ Entry, 
                       type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ InsertPos) {
    /*typedef SpecEntryTraits<VarTemplateSpecializationDecl> SETraits*/
  //  final class SETraits extends SpecEntryTraits<VarTemplateSpecializationDecl>{ };
    if ((InsertPos != null)) {
      final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ > CorrectInsertPos = create_type$ref();
      assert (!(findSpecializationImpl$VarTemplateSpecializationDecl(Specializations, SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getTemplateArgs(Entry), CorrectInsertPos) != null) && $eq_ptr(InsertPos, CorrectInsertPos.$deref())) : "given incorrect InsertPos for specialization";
      Specializations.InsertNode(Entry, InsertPos);
    } else {
      VarTemplateSpecializationDecl /*P*/ Existing = Specializations.GetOrInsertNode(Entry);
      ///*J:(void)*/Existing;
      assert (SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getDecl(Existing).isCanonicalDecl()) : "non-canonical specialization?";
    }
    {
  
      ASTMutationListener /*P*/ L = getASTMutationListener();
      if ((L != null)) {
        L.AddedCXXTemplateSpecialization(cast_VarTemplateDecl(this), 
            SpecEntryTraits.<VarTemplateSpecializationDecl>$Info().getDecl(Entry));
      }
    }
  }
  
  /// end of instantiations clang::RedeclarableTemplateDecl::addSpecializationImpl
  /////////////////////////////////////////////////////////////////////////////////

  public void LoadLazySpecializations() /*const*/ {
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  private final Redeclarable$Fields Redeclarable$Flds;// use return value of $Redeclarable();
  @Override public final Redeclarable$Fields $Redeclarable$Fields() { return Redeclarable$Flds; }
  
  @Override public String toString() {
    return "" + "Common=" + Common // NOI18N
              + super.toString(); // NOI18N
  }
}

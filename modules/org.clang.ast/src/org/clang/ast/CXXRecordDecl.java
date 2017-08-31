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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.impl.CXXInheritanceStatics.*;
import static org.clang.ast.impl.DeclCXXStatics.*;
import static org.clang.ast.impl.MicrosoftCXXABIStatics.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import org.clank.java.stdimpl.aliases.StdVector;
import org.llvm.support.sys.fs;


/// \brief Represents a C++ struct/union/class.
//<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 263,
 FQN="clang::CXXRecordDecl", NM="_ZN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDeclE")
//</editor-fold>
public class CXXRecordDecl extends /*public*/ RecordDecl implements Destructors.ClassWithDestructor {
  
  /*friend void startDefinition()*/
  
  /// Values used in DefinitionData fields to represent special members.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::SpecialMemberFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 268,
   FQN="clang::CXXRecordDecl::SpecialMemberFlags", NM="_ZN5clang13CXXRecordDecl18SpecialMemberFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl18SpecialMemberFlagsE")
  //</editor-fold>
  private static final class/*enum*/ SpecialMemberFlags {
    public static final /*uint*/int SMF_DefaultConstructor = 0x1;
    public static final /*uint*/int SMF_CopyConstructor = 0x2;
    public static final /*uint*/int SMF_MoveConstructor = 0x4;
    public static final /*uint*/int SMF_CopyAssignment = 0x8;
    public static final /*uint*/int SMF_MoveAssignment = 0x10;
    public static final /*uint*/int SMF_Destructor = 0x20;
    public static final /*uint*/int SMF_All = 0x3f;
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 278,
   FQN="clang::CXXRecordDecl::DefinitionData", NM="_ZN5clang13CXXRecordDecl14DefinitionDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl14DefinitionDataE")
  //</editor-fold>
  public/*friend*//*private*/ static class/*struct*/ DefinitionData implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::DefinitionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 48,
     FQN="clang::CXXRecordDecl::DefinitionData::DefinitionData", NM="_ZN5clang13CXXRecordDecl14DefinitionDataC1EPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl14DefinitionDataC1EPS0_")
    //</editor-fold>
    public DefinitionData(CXXRecordDecl /*P*/ D) {
      // : UserDeclaredConstructor(false), UserDeclaredSpecialMembers(0), Aggregate(true), PlainOldData(true), Empty(true), Polymorphic(false), Abstract(false), IsStandardLayout(true), HasNoNonEmptyBases(true), HasPrivateFields(false), HasProtectedFields(false), HasPublicFields(false), HasMutableFields(false), HasVariantMembers(false), HasOnlyCMembers(true), HasInClassInitializer(false), HasUninitializedReferenceMember(false), HasUninitializedFields(false), HasInheritedConstructor(false), HasInheritedAssignment(false), NeedOverloadResolutionForMoveConstructor(false), NeedOverloadResolutionForMoveAssignment(false), NeedOverloadResolutionForDestructor(false), DefaultedMoveConstructorIsDeleted(false), DefaultedMoveAssignmentIsDeleted(false), DefaultedDestructorIsDeleted(false), HasTrivialSpecialMembers(SMF_All), DeclaredNonTrivialSpecialMembers(0), HasIrrelevantDestructor(true), HasConstexprNonCopyMoveConstructor(false), HasDefaultedDefaultConstructor(false), DefaultedDefaultConstructorIsConstexpr(true), HasConstexprDefaultConstructor(false), HasNonLiteralTypeFieldsOrBases(false), ComputedVisibleConversions(false), UserProvidedDefaultConstructor(false), DeclaredSpecialMembers(0), ImplicitCopyConstructorHasConstParam(true), ImplicitCopyAssignmentHasConstParam(true), HasDeclaredCopyConstructorWithConstParam(false), HasDeclaredCopyAssignmentWithConstParam(false), IsLambda(false), IsParsingBaseSpecifiers(false), NumBases(0), NumVBases(0), Bases(), VBases(), Conversions(), VisibleConversions(), Definition(D), FirstFriend() 
      //START JInit
      this.UserDeclaredConstructor = false;
      this.UserDeclaredSpecialMembers = $uint2uint_6bits(0);
      this.Aggregate = true;
      this.PlainOldData = true;
      this.Empty = true;
      this.Polymorphic = false;
      this.Abstract = false;
      this.IsStandardLayout = true;
      this.HasNoNonEmptyBases = true;
      this.HasPrivateFields = false;
      this.HasProtectedFields = false;
      this.HasPublicFields = false;
      this.HasMutableFields = false;
      this.HasVariantMembers = false;
      this.HasOnlyCMembers = true;
      this.HasInClassInitializer = false;
      this.HasUninitializedReferenceMember = false;
      this.HasUninitializedFields = false;
      this.HasInheritedConstructor = false;
      this.HasInheritedAssignment = false;
      this.NeedOverloadResolutionForMoveConstructor = false;
      this.NeedOverloadResolutionForMoveAssignment = false;
      this.NeedOverloadResolutionForDestructor = false;
      this.DefaultedMoveConstructorIsDeleted = false;
      this.DefaultedMoveAssignmentIsDeleted = false;
      this.DefaultedDestructorIsDeleted = false;
      this.HasTrivialSpecialMembers = $uint2uint_6bits(SpecialMemberFlags.SMF_All);
      this.DeclaredNonTrivialSpecialMembers = $uint2uint_6bits(0);
      this.HasIrrelevantDestructor = true;
      this.HasConstexprNonCopyMoveConstructor = false;
      this.HasDefaultedDefaultConstructor = false;
      this.DefaultedDefaultConstructorIsConstexpr = true;
      this.HasConstexprDefaultConstructor = false;
      this.HasNonLiteralTypeFieldsOrBases = false;
      this.ComputedVisibleConversions = false;
      this.UserProvidedDefaultConstructor = false;
      this.DeclaredSpecialMembers = $uint2uint_6bits(0);
      this.ImplicitCopyConstructorHasConstParam = true;
      this.ImplicitCopyAssignmentHasConstParam = true;
      this.HasDeclaredCopyConstructorWithConstParam = false;
      this.HasDeclaredCopyAssignmentWithConstParam = false;
      this.IsLambda = false;
      this.IsParsingBaseSpecifiers = false;
      this.NumBases = 0;
      this.NumVBases = 0;
      this.Bases = new LazyCXXBaseSpecifiersPtr();
      this.VBases = new LazyCXXBaseSpecifiersPtr();
      this.Conversions = new LazyASTUnresolvedSet();
      this.VisibleConversions = new LazyASTUnresolvedSet();
      this.Definition = D;
      this.FirstFriend = new LazyDeclPtr();
      //END JInit
    }


    
    /// \brief True if this class has any user-declared constructors.
    public /*JBIT unsigned int*/ boolean UserDeclaredConstructor /*: 1*/;
    
    /// \brief The user-declared special members which this class has.
    public /*JBYTE unsigned int*/ byte UserDeclaredSpecialMembers /*: 6*/;
    
    /// \brief True when this class is an aggregate.
    public /*JBIT unsigned int*/ boolean Aggregate /*: 1*/;
    
    /// \brief True when this class is a POD-type.
    public /*JBIT unsigned int*/ boolean PlainOldData /*: 1*/;
    
    /// true when this class is empty for traits purposes,
    /// i.e. has no data members other than 0-width bit-fields, has no
    /// virtual function/base, and doesn't inherit from a non-empty
    /// class. Doesn't take union-ness into account.
    public /*JBIT unsigned int*/ boolean Empty /*: 1*/;
    
    /// \brief True when this class is polymorphic, i.e., has at
    /// least one virtual member or derives from a polymorphic class.
    public /*JBIT unsigned int*/ boolean Polymorphic /*: 1*/;
    
    /// \brief True when this class is abstract, i.e., has at least
    /// one pure virtual function, (that can come from a base class).
    public /*JBIT unsigned int*/ boolean Abstract /*: 1*/;
    
    /// \brief True when this class has standard layout.
    ///
    /// C++11 [class]p7.  A standard-layout class is a class that:
    /// * has no non-static data members of type non-standard-layout class (or
    ///   array of such types) or reference,
    /// * has no virtual functions (10.3) and no virtual base classes (10.1),
    /// * has the same access control (Clause 11) for all non-static data
    ///   members
    /// * has no non-standard-layout base classes,
    /// * either has no non-static data members in the most derived class and at
    ///   most one base class with non-static data members, or has no base
    ///   classes with non-static data members, and
    /// * has no base classes of the same type as the first non-static data
    ///   member.
    public /*JBIT unsigned int*/ boolean IsStandardLayout /*: 1*/;
    
    /// \brief True when there are no non-empty base classes.
    ///
    /// This is a helper bit of state used to implement IsStandardLayout more
    /// efficiently.
    public /*JBIT unsigned int*/ boolean HasNoNonEmptyBases /*: 1*/;
    
    /// \brief True when there are private non-static data members.
    public /*JBIT unsigned int*/ boolean HasPrivateFields /*: 1*/;
    
    /// \brief True when there are protected non-static data members.
    public /*JBIT unsigned int*/ boolean HasProtectedFields /*: 1*/;
    
    /// \brief True when there are private non-static data members.
    public /*JBIT unsigned int*/ boolean HasPublicFields /*: 1*/;
    
    /// \brief True if this class (or any subobject) has mutable fields.
    public /*JBIT unsigned int*/ boolean HasMutableFields /*: 1*/;
    
    /// \brief True if this class (or any nested anonymous struct or union)
    /// has variant members.
    public /*JBIT unsigned int*/ boolean HasVariantMembers /*: 1*/;
    
    /// \brief True if there no non-field members declared by the user.
    public /*JBIT unsigned int*/ boolean HasOnlyCMembers /*: 1*/;
    
    /// \brief True if any field has an in-class initializer, including those
    /// within anonymous unions or structs.
    public /*JBIT unsigned int*/ boolean HasInClassInitializer /*: 1*/;
    
    /// \brief True if any field is of reference type, and does not have an
    /// in-class initializer.
    ///
    /// In this case, value-initialization of this class is illegal in C++98
    /// even if the class has a trivial default constructor.
    public /*JBIT unsigned int*/ boolean HasUninitializedReferenceMember /*: 1*/;
    
    /// \brief True if any non-mutable field whose type doesn't have a user-
    /// provided default ctor also doesn't have an in-class initializer.
    public /*JBIT unsigned int*/ boolean HasUninitializedFields /*: 1*/;
    
    /// \brief True if there are any member using-declarations that inherit
    /// constructors from a base class.
    public /*JBIT unsigned int*/ boolean HasInheritedConstructor /*: 1*/;
    
    /// \brief True if there are any member using-declarations named
    /// 'operator='.
    public /*JBIT unsigned int*/ boolean HasInheritedAssignment /*: 1*/;
    
    /// \brief These flags are \c true if a defaulted corresponding special
    /// member can't be fully analyzed without performing overload resolution.
    /// @{
    public /*JBIT unsigned int*/ boolean NeedOverloadResolutionForMoveConstructor /*: 1*/;
    public /*JBIT unsigned int*/ boolean NeedOverloadResolutionForMoveAssignment /*: 1*/;
    public /*JBIT unsigned int*/ boolean NeedOverloadResolutionForDestructor /*: 1*/;
    /// @}
    
    /// \brief These flags are \c true if an implicit defaulted corresponding
    /// special member would be defined as deleted.
    /// @{
    public /*JBIT unsigned int*/ boolean DefaultedMoveConstructorIsDeleted /*: 1*/;
    public /*JBIT unsigned int*/ boolean DefaultedMoveAssignmentIsDeleted /*: 1*/;
    public /*JBIT unsigned int*/ boolean DefaultedDestructorIsDeleted /*: 1*/;
    /// @}
    
    /// \brief The trivial special members which this class has, per
    /// C++11 [class.ctor]p5, C++11 [class.copy]p12, C++11 [class.copy]p25,
    /// C++11 [class.dtor]p5, or would have if the member were not suppressed.
    ///
    /// This excludes any user-declared but not user-provided special members
    /// which have been declared but not yet defined.
    public /*JBYTE unsigned int*/ byte HasTrivialSpecialMembers /*: 6*/;
    
    /// \brief The declared special members of this class which are known to be
    /// non-trivial.
    ///
    /// This excludes any user-declared but not user-provided special members
    /// which have been declared but not yet defined, and any implicit special
    /// members which have not yet been declared.
    public /*JBYTE unsigned int*/ byte DeclaredNonTrivialSpecialMembers /*: 6*/;
    
    /// \brief True when this class has a destructor with no semantic effect.
    public /*JBIT unsigned int*/ boolean HasIrrelevantDestructor /*: 1*/;
    
    /// \brief True when this class has at least one user-declared constexpr
    /// constructor which is neither the copy nor move constructor.
    public /*JBIT unsigned int*/ boolean HasConstexprNonCopyMoveConstructor /*: 1*/;
    
    /// \brief True if this class has a (possibly implicit) defaulted default
    /// constructor.
    public /*JBIT unsigned int*/ boolean HasDefaultedDefaultConstructor /*: 1*/;
    
    /// \brief True if a defaulted default constructor for this class would
    /// be constexpr.
    public /*JBIT unsigned int*/ boolean DefaultedDefaultConstructorIsConstexpr /*: 1*/;
    
    /// \brief True if this class has a constexpr default constructor.
    ///
    /// This is true for either a user-declared constexpr default constructor
    /// or an implicitly declared constexpr default constructor.
    public /*JBIT unsigned int*/ boolean HasConstexprDefaultConstructor /*: 1*/;
    
    /// \brief True when this class contains at least one non-static data
    /// member or base class of non-literal or volatile type.
    public /*JBIT unsigned int*/ boolean HasNonLiteralTypeFieldsOrBases /*: 1*/;
    
    /// \brief True when visible conversion functions are already computed
    /// and are available.
    public /*JBIT unsigned int*/ boolean ComputedVisibleConversions /*: 1*/;
    
    /// \brief Whether we have a C++11 user-provided default constructor (not
    /// explicitly deleted or defaulted).
    public /*JBIT unsigned int*/ boolean UserProvidedDefaultConstructor /*: 1*/;
    
    /// \brief The special members which have been declared for this class,
    /// either by the user or implicitly.
    public /*JBYTE unsigned int*/ byte DeclaredSpecialMembers /*: 6*/;
    
    /// \brief Whether an implicit copy constructor would have a const-qualified
    /// parameter.
    public /*JBIT unsigned int*/ boolean ImplicitCopyConstructorHasConstParam /*: 1*/;
    
    /// \brief Whether an implicit copy assignment operator would have a
    /// const-qualified parameter.
    public /*JBIT unsigned int*/ boolean ImplicitCopyAssignmentHasConstParam /*: 1*/;
    
    /// \brief Whether any declared copy constructor has a const-qualified
    /// parameter.
    public /*JBIT unsigned int*/ boolean HasDeclaredCopyConstructorWithConstParam /*: 1*/;
    
    /// \brief Whether any declared copy assignment operator has either a
    /// const-qualified reference parameter or a non-reference parameter.
    public /*JBIT unsigned int*/ boolean HasDeclaredCopyAssignmentWithConstParam /*: 1*/;
    
    /// \brief Whether this class describes a C++ lambda.
    public /*JBIT unsigned int*/ boolean IsLambda /*: 1*/;
    
    /// \brief Whether we are currently parsing base specifiers.
    public /*JBIT unsigned int*/ boolean IsParsingBaseSpecifiers /*: 1*/;
    
    /// \brief The number of base class specifiers in Bases.
    public /*uint*/int NumBases;
    
    /// \brief The number of virtual base class specifiers in VBases.
    public /*uint*/int NumVBases;
    
    /// \brief Base classes of this class.
    ///
    /// FIXME: This is wasted space for a union.
    public LazyCXXBaseSpecifiersPtr Bases;
    
    /// \brief direct and indirect virtual base classes of this class.
    public LazyCXXBaseSpecifiersPtr VBases;
    
    /// \brief The conversion functions of this C++ class (but not its
    /// inherited conversion functions).
    ///
    /// Each of the entries in this overload set is a CXXConversionDecl.
    public LazyASTUnresolvedSet Conversions;
    
    /// \brief The conversion functions of this C++ class and all those
    /// inherited conversion functions that are visible in this class.
    ///
    /// Each of the entries in this overload set is a CXXConversionDecl or a
    /// FunctionTemplateDecl.
    public LazyASTUnresolvedSet VisibleConversions;
    
    /// \brief The declaration which defines this record.
    public CXXRecordDecl /*P*/ Definition;
    
    /// \brief The first friend declaration in this class, or null if there
    /// aren't any. 
    ///
    /// This is actually currently stored in reverse order.
    public LazyDeclPtr FirstFriend;
    
    /// \brief Retrieve the set of direct base classes.
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::getBases">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 499,
     FQN="clang::CXXRecordDecl::DefinitionData::getBases", NM="_ZNK5clang13CXXRecordDecl14DefinitionData8getBasesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14DefinitionData8getBasesEv")
    //</editor-fold>
    public type$ptr<CXXBaseSpecifier /*P*/> getBases() /*const*/ {
      if (!Bases.isOffset()) {
        return Bases.get((ExternalASTSource /*P*/ )null);
      }
      return getBasesSlowCase();
    }

    
    /// \brief Retrieve the set of virtual base classes.
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::getVBases">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 506,
     FQN="clang::CXXRecordDecl::DefinitionData::getVBases", NM="_ZNK5clang13CXXRecordDecl14DefinitionData9getVBasesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14DefinitionData9getVBasesEv")
    //</editor-fold>
    public type$ptr<CXXBaseSpecifier /*P*/> getVBases() /*const*/ {
      if (!VBases.isOffset()) {
        return VBases.get((ExternalASTSource /*P*/ )null);
      }
      return getVBasesSlowCase();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::bases">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 512,
     FQN="clang::CXXRecordDecl::DefinitionData::bases", NM="_ZNK5clang13CXXRecordDecl14DefinitionData5basesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14DefinitionData5basesEv")
    //</editor-fold>
    public ArrayRef<CXXBaseSpecifier> bases() /*const*/ {
      return llvm.makeArrayRef(getBases(), NumBases);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::vbases">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 515,
     FQN="clang::CXXRecordDecl::DefinitionData::vbases", NM="_ZNK5clang13CXXRecordDecl14DefinitionData6vbasesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14DefinitionData6vbasesEv")
    //</editor-fold>
    public ArrayRef<CXXBaseSpecifier> vbases() /*const*/ {
      return llvm.makeArrayRef(getVBases(), NumVBases);
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::getBasesSlowCase">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 77,
     FQN="clang::CXXRecordDecl::DefinitionData::getBasesSlowCase", NM="_ZNK5clang13CXXRecordDecl14DefinitionData16getBasesSlowCaseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl14DefinitionData16getBasesSlowCaseEv")
    //</editor-fold>
    private type$ptr<CXXBaseSpecifier /*P*/> getBasesSlowCase() /*const*/ {
      return Bases.get(Definition.getASTContext().getExternalSource());
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::getVBasesSlowCase">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 81,
     FQN="clang::CXXRecordDecl::DefinitionData::getVBasesSlowCase", NM="_ZNK5clang13CXXRecordDecl14DefinitionData17getVBasesSlowCaseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl14DefinitionData17getVBasesSlowCaseEv")
    //</editor-fold>
    private type$ptr<CXXBaseSpecifier /*P*/> getVBasesSlowCase() /*const*/ {
      return VBases.get(Definition.getASTContext().getExternalSource());
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 278,
     FQN="clang::CXXRecordDecl::DefinitionData::operator=", NM="_ZN5clang13CXXRecordDecl14DefinitionDataaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl14DefinitionDataaSEOS1_")
    //</editor-fold>
    public /*inline*/ DefinitionData /*&*/ $assignMove(final DefinitionData /*&&*/$Prm0) {
      this.UserDeclaredConstructor = $Prm0.UserDeclaredConstructor;
      this.UserDeclaredSpecialMembers = $uint2uint_6bits($Prm0.UserDeclaredSpecialMembers);
      this.Aggregate = $Prm0.Aggregate;
      this.PlainOldData = $Prm0.PlainOldData;
      this.Empty = $Prm0.Empty;
      this.Polymorphic = $Prm0.Polymorphic;
      this.Abstract = $Prm0.Abstract;
      this.IsStandardLayout = $Prm0.IsStandardLayout;
      this.HasNoNonEmptyBases = $Prm0.HasNoNonEmptyBases;
      this.HasPrivateFields = $Prm0.HasPrivateFields;
      this.HasProtectedFields = $Prm0.HasProtectedFields;
      this.HasPublicFields = $Prm0.HasPublicFields;
      this.HasMutableFields = $Prm0.HasMutableFields;
      this.HasVariantMembers = $Prm0.HasVariantMembers;
      this.HasOnlyCMembers = $Prm0.HasOnlyCMembers;
      this.HasInClassInitializer = $Prm0.HasInClassInitializer;
      this.HasUninitializedReferenceMember = $Prm0.HasUninitializedReferenceMember;
      this.HasUninitializedFields = $Prm0.HasUninitializedFields;
      this.HasInheritedConstructor = $Prm0.HasInheritedConstructor;
      this.HasInheritedAssignment = $Prm0.HasInheritedAssignment;
      this.NeedOverloadResolutionForMoveConstructor = $Prm0.NeedOverloadResolutionForMoveConstructor;
      this.NeedOverloadResolutionForMoveAssignment = $Prm0.NeedOverloadResolutionForMoveAssignment;
      this.NeedOverloadResolutionForDestructor = $Prm0.NeedOverloadResolutionForDestructor;
      this.DefaultedMoveConstructorIsDeleted = $Prm0.DefaultedMoveConstructorIsDeleted;
      this.DefaultedMoveAssignmentIsDeleted = $Prm0.DefaultedMoveAssignmentIsDeleted;
      this.DefaultedDestructorIsDeleted = $Prm0.DefaultedDestructorIsDeleted;
      this.HasTrivialSpecialMembers = $uint2uint_6bits($Prm0.HasTrivialSpecialMembers);
      this.DeclaredNonTrivialSpecialMembers = $uint2uint_6bits($Prm0.DeclaredNonTrivialSpecialMembers);
      this.HasIrrelevantDestructor = $Prm0.HasIrrelevantDestructor;
      this.HasConstexprNonCopyMoveConstructor = $Prm0.HasConstexprNonCopyMoveConstructor;
      this.HasDefaultedDefaultConstructor = $Prm0.HasDefaultedDefaultConstructor;
      this.DefaultedDefaultConstructorIsConstexpr = $Prm0.DefaultedDefaultConstructorIsConstexpr;
      this.HasConstexprDefaultConstructor = $Prm0.HasConstexprDefaultConstructor;
      this.HasNonLiteralTypeFieldsOrBases = $Prm0.HasNonLiteralTypeFieldsOrBases;
      this.ComputedVisibleConversions = $Prm0.ComputedVisibleConversions;
      this.UserProvidedDefaultConstructor = $Prm0.UserProvidedDefaultConstructor;
      this.DeclaredSpecialMembers = $uint2uint_6bits($Prm0.DeclaredSpecialMembers);
      this.ImplicitCopyConstructorHasConstParam = $Prm0.ImplicitCopyConstructorHasConstParam;
      this.ImplicitCopyAssignmentHasConstParam = $Prm0.ImplicitCopyAssignmentHasConstParam;
      this.HasDeclaredCopyConstructorWithConstParam = $Prm0.HasDeclaredCopyConstructorWithConstParam;
      this.HasDeclaredCopyAssignmentWithConstParam = $Prm0.HasDeclaredCopyAssignmentWithConstParam;
      this.IsLambda = $Prm0.IsLambda;
      this.IsParsingBaseSpecifiers = $Prm0.IsParsingBaseSpecifiers;
      this.NumBases = $Prm0.NumBases;
      this.NumVBases = $Prm0.NumVBases;
      this.Bases.$assignMove($Prm0.Bases);
      this.VBases.$assignMove($Prm0.VBases);
      this.Conversions.$assignMove($Prm0.Conversions);
      this.VisibleConversions.$assignMove($Prm0.VisibleConversions);
      this.Definition = $Prm0.Definition;
      this.FirstFriend.$assignMove($Prm0.FirstFriend);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::DefinitionData::~DefinitionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 278,
     FQN="clang::CXXRecordDecl::DefinitionData::~DefinitionData", NM="_ZN5clang13CXXRecordDecl14DefinitionDataD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl14DefinitionDataD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      VisibleConversions.$destroy();
      Conversions.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "UserDeclaredConstructor=" + UserDeclaredConstructor // NOI18N
                + ", UserDeclaredSpecialMembers=" + $uchar2uint(UserDeclaredSpecialMembers) // NOI18N
                + ", Aggregate=" + Aggregate // NOI18N
                + ", PlainOldData=" + PlainOldData // NOI18N
                + ", Empty=" + Empty // NOI18N
                + ", Polymorphic=" + Polymorphic // NOI18N
                + ", Abstract=" + Abstract // NOI18N
                + ", IsStandardLayout=" + IsStandardLayout // NOI18N
                + ", HasNoNonEmptyBases=" + HasNoNonEmptyBases // NOI18N
                + ", HasPrivateFields=" + HasPrivateFields // NOI18N
                + ", HasProtectedFields=" + HasProtectedFields // NOI18N
                + ", HasPublicFields=" + HasPublicFields // NOI18N
                + ", HasMutableFields=" + HasMutableFields // NOI18N
                + ", HasVariantMembers=" + HasVariantMembers // NOI18N
                + ", HasOnlyCMembers=" + HasOnlyCMembers // NOI18N
                + ", HasInClassInitializer=" + HasInClassInitializer // NOI18N
                + ", HasUninitializedReferenceMember=" + HasUninitializedReferenceMember // NOI18N
                + ", HasUninitializedFields=" + HasUninitializedFields // NOI18N
                + ", HasInheritedConstructor=" + HasInheritedConstructor // NOI18N
                + ", HasInheritedAssignment=" + HasInheritedAssignment // NOI18N
                + ", NeedOverloadResolutionForMoveConstructor=" + NeedOverloadResolutionForMoveConstructor // NOI18N
                + ", NeedOverloadResolutionForMoveAssignment=" + NeedOverloadResolutionForMoveAssignment // NOI18N
                + ", NeedOverloadResolutionForDestructor=" + NeedOverloadResolutionForDestructor // NOI18N
                + ", DefaultedMoveConstructorIsDeleted=" + DefaultedMoveConstructorIsDeleted // NOI18N
                + ", DefaultedMoveAssignmentIsDeleted=" + DefaultedMoveAssignmentIsDeleted // NOI18N
                + ", DefaultedDestructorIsDeleted=" + DefaultedDestructorIsDeleted // NOI18N
                + ", HasTrivialSpecialMembers=" + $uchar2uint(HasTrivialSpecialMembers) // NOI18N
                + ", DeclaredNonTrivialSpecialMembers=" + $uchar2uint(DeclaredNonTrivialSpecialMembers) // NOI18N
                + ", HasIrrelevantDestructor=" + HasIrrelevantDestructor // NOI18N
                + ", HasConstexprNonCopyMoveConstructor=" + HasConstexprNonCopyMoveConstructor // NOI18N
                + ", HasDefaultedDefaultConstructor=" + HasDefaultedDefaultConstructor // NOI18N
                + ", DefaultedDefaultConstructorIsConstexpr=" + DefaultedDefaultConstructorIsConstexpr // NOI18N
                + ", HasConstexprDefaultConstructor=" + HasConstexprDefaultConstructor // NOI18N
                + ", HasNonLiteralTypeFieldsOrBases=" + HasNonLiteralTypeFieldsOrBases // NOI18N
                + ", ComputedVisibleConversions=" + ComputedVisibleConversions // NOI18N
                + ", UserProvidedDefaultConstructor=" + UserProvidedDefaultConstructor // NOI18N
                + ", DeclaredSpecialMembers=" + $uchar2uint(DeclaredSpecialMembers) // NOI18N
                + ", ImplicitCopyConstructorHasConstParam=" + ImplicitCopyConstructorHasConstParam // NOI18N
                + ", ImplicitCopyAssignmentHasConstParam=" + ImplicitCopyAssignmentHasConstParam // NOI18N
                + ", HasDeclaredCopyConstructorWithConstParam=" + HasDeclaredCopyConstructorWithConstParam // NOI18N
                + ", HasDeclaredCopyAssignmentWithConstParam=" + HasDeclaredCopyAssignmentWithConstParam // NOI18N
                + ", IsLambda=" + IsLambda // NOI18N
                + ", IsParsingBaseSpecifiers=" + IsParsingBaseSpecifiers // NOI18N
                + ", NumBases=" + NumBases // NOI18N
                + ", NumVBases=" + NumVBases // NOI18N
                + ", Bases=" + NativeTrace.getIdentityStr(Bases) // NOI18N
                + ", VBases=" + NativeTrace.getIdentityStr(VBases) // NOI18N
                + ", Conversions=" + NativeTrace.getIdentityStr(Conversions) // NOI18N
                + ", VisibleConversions=" + NativeTrace.getIdentityStr(VisibleConversions) // NOI18N
                + ", Definition=" + NativeTrace.getIdentityStr(Definition) // NOI18N
                + ", FirstFriend=" + NativeTrace.getIdentityStr(FirstFriend); // NOI18N
    }
  };
  
  public/*friend*//*private*/  DefinitionData /*P*/ DefinitionData;
  
  /// \brief Describes a C++ closure type (generated by a lambda expression).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::LambdaDefinitionData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 527,
   FQN="clang::CXXRecordDecl::LambdaDefinitionData", NM="_ZN5clang13CXXRecordDecl20LambdaDefinitionDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl20LambdaDefinitionDataE")
  //</editor-fold>
  /*friend*/public/*private*/ static class/*struct*/ LambdaDefinitionData extends /*public*/ DefinitionData implements Destructors.ClassWithDestructor {
    /*typedef LambdaCapture Capture*/
//    public final class Capture extends LambdaCapture{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::LambdaDefinitionData::LambdaDefinitionData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 530,
     FQN="clang::CXXRecordDecl::LambdaDefinitionData::LambdaDefinitionData", NM="_ZN5clang13CXXRecordDecl20LambdaDefinitionDataC1EPS0_PNS_14TypeSourceInfoEbbNS_20LambdaCaptureDefaultE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl20LambdaDefinitionDataC1EPS0_PNS_14TypeSourceInfoEbbNS_20LambdaCaptureDefaultE")
    //</editor-fold>
    public LambdaDefinitionData(CXXRecordDecl /*P*/ D, TypeSourceInfo /*P*/ Info, 
        boolean Dependent, boolean IsGeneric, 
        LambdaCaptureDefault CaptureDefault) {
      // : DefinitionData(D), Dependent(Dependent), IsGenericLambda(IsGeneric), CaptureDefault(CaptureDefault), NumCaptures(0), NumExplicitCaptures(0), ManglingNumber(0), ContextDecl(null), Captures(null), MethodTyInfo(Info) 
      //START JInit
      super(D);
      this.Dependent = Dependent;
      this.IsGenericLambda = IsGeneric;
      this.CaptureDefault = $uint2uint_2bits(CaptureDefault.getValue());
      this.NumCaptures = $uint2uint_15bits(0);
      this.NumExplicitCaptures = $uint2uint_13bits(0);
      this.ManglingNumber = 0;
      this.ContextDecl = null;
      this.Captures = null;
      this.MethodTyInfo = Info;
      //END JInit
      IsLambda = true;
      
      // C++11 [expr.prim.lambda]p3:
      //   This class type is neither an aggregate nor a literal type.
      Aggregate = false;
      PlainOldData = false;
      HasNonLiteralTypeFieldsOrBases = true;
    }

    
    /// \brief Whether this lambda is known to be dependent, even if its
    /// context isn't dependent.
    /// 
    /// A lambda with a non-dependent context can be dependent if it occurs
    /// within the default argument of a function template, because the
    /// lambda will have been created with the enclosing context as its
    /// declaration context, rather than function. This is an unfortunate
    /// artifact of having to parse the default arguments before. 
    public /*JBIT unsigned int*/ boolean Dependent /*: 1*/;
    
    /// \brief Whether this lambda is a generic lambda.
    public /*JBIT unsigned int*/ boolean IsGenericLambda /*: 1*/;
    
    /// \brief The Default Capture.
    public /*JBYTE unsigned int*/ byte CaptureDefault /*: 2*/;
    
    /// \brief The number of captures in this lambda is limited 2^NumCaptures.
    public /*JCHAR unsigned int*/ char NumCaptures /*: 15*/;
    
    /// \brief The number of explicit captures in this lambda.
    public /*JCHAR unsigned int*/ char NumExplicitCaptures /*: 13*/;
    
    /// \brief The number used to indicate this lambda expression for name 
    /// mangling in the Itanium C++ ABI.
    public /*uint*/int ManglingNumber;
    
    /// \brief The declaration that provides context for this lambda, if the
    /// actual DeclContext does not suffice. This is used for lambdas that
    /// occur within default arguments of function parameters within the class
    /// or within a data member initializer.
    public Decl /*P*/ ContextDecl;
    
    /// \brief The list of captures, both explicit and implicit, for this 
    /// lambda.
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
    public type$ptr<LambdaCapture /*P*/> Captures;
    
    /// \brief The type of the call method.
    public TypeSourceInfo /*P*/ MethodTyInfo;
    
    @Override public String toString() {
      return "" + "Dependent=" + Dependent // NOI18N
                + ", IsGenericLambda=" + IsGenericLambda // NOI18N
                + ", CaptureDefault=" + $uchar2uint(CaptureDefault) // NOI18N
                + ", NumCaptures=" + $ushort2uint(NumCaptures) // NOI18N
                + ", NumExplicitCaptures=" + $ushort2uint(NumExplicitCaptures) // NOI18N
                + ", ManglingNumber=" + ManglingNumber // NOI18N
                + ", ContextDecl=" + ContextDecl // NOI18N
                + ", Captures=" + Captures // NOI18N
                + ", MethodTyInfo=" + MethodTyInfo // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::dataPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 587,
   FQN="clang::CXXRecordDecl::dataPtr", NM="_ZNK5clang13CXXRecordDecl7dataPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl7dataPtrEv")
  //</editor-fold>
  private  DefinitionData /*P*/ dataPtr() /*const*/ {
    // Complete the redecl chain (if necessary).
    getMostRecentDecl$Const();
    return DefinitionData;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::data">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 593,
   FQN="clang::CXXRecordDecl::data", NM="_ZNK5clang13CXXRecordDecl4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl4dataEv")
  //</editor-fold>
  /*friend*/public  DefinitionData /*&*/ data() /*const*/ {
    DefinitionData /*P*/ DD = dataPtr();
    assert ((DD != null)) : "queried property of class with no definition";
    return $Deref(DD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 599,
   FQN="clang::CXXRecordDecl::getLambdaData", NM="_ZNK5clang13CXXRecordDecl13getLambdaDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl13getLambdaDataEv")
  //</editor-fold>
  /*friend*/public/*private*/  LambdaDefinitionData /*&*/ getLambdaData() /*const*/ {
    // No update required: a merged definition cannot change any lambda
    // properties.
    DefinitionData /*P*/ DD = DefinitionData;
    assert ((DD != null) && DD.IsLambda) : "queried lambda property of non-lambda class";
    return ((/*static_cast*/LambdaDefinitionData /*&*/ )($Deref(DD)));
  }

  
  /// \brief The template or declaration that this declaration
  /// describes or was instantiated from, respectively.
  ///
  /// For non-templates, this value will be null. For record
  /// declarations that describe a class template, this will be a
  /// pointer to a ClassTemplateDecl. For member
  /// classes of class template specializations, this will be the
  /// MemberSpecializationInfo referring to the member class that was
  /// instantiated or specialized.
  /*friend*/public PointerUnion<ClassTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ > TemplateOrInstantiation;
  
  /*friend  class DeclContext*/
  /*friend  class LambdaExpr*/
  
  /// \brief Called from setBases and addedMember to notify the class that a
  /// direct or virtual base class or a member of class type has been added.
  
  /// \brief Called from setBases and addedMember to notify the class that a
  /// direct or virtual base class or a member of class type has been added.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::addedClassSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 374,
   FQN="clang::CXXRecordDecl::addedClassSubobject", NM="_ZN5clang13CXXRecordDecl19addedClassSubobjectEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl19addedClassSubobjectEPS0_")
  //</editor-fold>
  private void addedClassSubobject(CXXRecordDecl /*P*/ Subobj) {
    // C++11 [class.copy]p11:
    //   A defaulted copy/move constructor for a class X is defined as
    //   deleted if X has:
    //    -- a direct or virtual base class B that cannot be copied/moved [...]
    //    -- a non-static data member of class type M (or array thereof)
    //       that cannot be copied or moved [...]
    if (!Subobj.hasSimpleMoveConstructor()) {
      data().NeedOverloadResolutionForMoveConstructor = true;
    }
    
    // C++11 [class.copy]p23:
    //   A defaulted copy/move assignment operator for a class X is defined as
    //   deleted if X has:
    //    -- a direct or virtual base class B that cannot be copied/moved [...]
    //    -- a non-static data member of class type M (or array thereof)
    //        that cannot be copied or moved [...]
    if (!Subobj.hasSimpleMoveAssignment()) {
      data().NeedOverloadResolutionForMoveAssignment = true;
    }
    
    // C++11 [class.ctor]p5, C++11 [class.copy]p11, C++11 [class.dtor]p5:
    //   A defaulted [ctor or dtor] for a class X is defined as
    //   deleted if X has:
    //    -- any direct or virtual base class [...] has a type with a destructor
    //       that is deleted or inaccessible from the defaulted [ctor or dtor].
    //    -- any non-static data member has a type with a destructor
    //       that is deleted or inaccessible from the defaulted [ctor or dtor].
    if (!Subobj.hasSimpleDestructor()) {
      data().NeedOverloadResolutionForMoveConstructor = true;
      data().NeedOverloadResolutionForDestructor = true;
    }
  }


  
  /// \brief Notify the class that member has been added.
  ///
  /// This routine helps maintain information about the class based on which
  /// members have been added. It will be invoked by DeclContext::addDecl()
  /// whenever a member is added to this record.
  
  /// \brief Notify the class that member has been added.
  ///
  /// This routine helps maintain information about the class based on which
  /// members have been added. It will be invoked by DeclContext::addDecl()
  /// whenever a member is added to this record.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::addedMember">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 436,
   FQN="clang::CXXRecordDecl::addedMember", NM="_ZN5clang13CXXRecordDecl11addedMemberEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl11addedMemberEPNS_4DeclE")
  //</editor-fold>
  /*friend*/final public /*private*/ void addedMember(Decl /*P*/ D) {
    if (!D.isImplicit()
       && !isa_FieldDecl(D)
       && !isa_IndirectFieldDecl(D)
       && (!isa_TagDecl(D) || cast_TagDecl(D).getTagKind() == TagTypeKind.TTK_Class
       || cast_TagDecl(D).getTagKind() == TagTypeKind.TTK_Interface)) {
      data().HasOnlyCMembers = false;
    }
    
    // Ignore friends and invalid declarations.
    if ((D.getFriendObjectKind().getValue() != 0) || D.isInvalidDecl()) {
      return;
    }
    
    FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(D);
    if ((FunTmpl != null)) {
      D = FunTmpl.getTemplatedDecl();
    }
    
    // FIXME: Pass NamedDecl* to addedMember?
    Decl /*P*/ DUnderlying = D;
    {
      NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DUnderlying);
      if ((ND != null)) {
        DUnderlying = ND.getUnderlyingDecl();
        {
          FunctionTemplateDecl /*P*/ UnderlyingFunTmpl = dyn_cast_FunctionTemplateDecl(DUnderlying);
          if ((UnderlyingFunTmpl != null)) {
            DUnderlying = UnderlyingFunTmpl.getTemplatedDecl();
          }
        }
      }
    }
    {
      
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
      if ((Method != null)) {
        if (Method.isVirtual()) {
          // C++ [dcl.init.aggr]p1:
          //   An aggregate is an array or a class with [...] no virtual functions.
          data().Aggregate = false;
          
          // C++ [class]p4:
          //   A POD-struct is an aggregate class...
          data().PlainOldData = false;
          
          // C++14 [meta.unary.prop]p4:
          //   T is a class type [...] with [...] no virtual member functions...
          data().Empty = false;
          
          // C++ [class.virtual]p1:
          //   A class that declares or inherits a virtual function is called a 
          //   polymorphic class.
          data().Polymorphic = true;
          
          // C++11 [class.ctor]p5, C++11 [class.copy]p12, C++11 [class.copy]p25:
          //   A [default constructor, copy/move constructor, or copy/move
          //   assignment operator for a class X] is trivial [...] if:
          //    -- class X has no virtual functions [...]
          data().HasTrivialSpecialMembers &= $int2uint_6bits(SpecialMemberFlags.SMF_Destructor);
          
          // C++0x [class]p7:
          //   A standard-layout class is a class that: [...]
          //    -- has no virtual functions
          data().IsStandardLayout = false;
        }
      }
    }
    
    // Notify the listener if an implicit member was added after the definition
    // was completed.
    if (!isBeingDefined() && D.isImplicit()) {
      {
        ASTMutationListener /*P*/ L = getASTMutationListener();
        if ((L != null)) {
          L.AddedCXXImplicitMember(data().Definition, D);
        }
      }
    }
    
    // The kind of special member this declaration is, if any.
    /*uint*/int SMKind = 0;
    {
      
      // Handle constructors.
      CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(D);
      if ((Constructor != null)) {
        if (!Constructor.isImplicit()) {
          // Note that we have a user-declared constructor.
          data().UserDeclaredConstructor = true;
          
          // C++ [class]p4:
          //   A POD-struct is an aggregate class [...]
          // Since the POD bit is meant to be C++03 POD-ness, clear it even if the
          // type is technically an aggregate in C++0x since it wouldn't be in 03.
          data().PlainOldData = false;
        }
        if (Constructor.isDefaultConstructor()) {
          SMKind |= SpecialMemberFlags.SMF_DefaultConstructor;
          if (Constructor.isUserProvided()) {
            data().UserProvidedDefaultConstructor = true;
          }
          if (Constructor.isConstexpr()) {
            data().HasConstexprDefaultConstructor = true;
          }
          if (Constructor.isDefaulted()) {
            data().HasDefaultedDefaultConstructor = true;
          }
        }
        if (!(FunTmpl != null)) {
          uint$ref Quals = create_uint$ref();
          if (Constructor.isCopyConstructor(Quals)) {
            SMKind |= SpecialMemberFlags.SMF_CopyConstructor;
            if (((Quals.$deref() & Qualifiers.TQ.Const) != 0)) {
              data().HasDeclaredCopyConstructorWithConstParam = true;
            }
          } else if (Constructor.isMoveConstructor()) {
            SMKind |= SpecialMemberFlags.SMF_MoveConstructor;
          }
        }
      }
    }
    {
      
      // Handle constructors, including those inherited from base classes.
      CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(DUnderlying);
      if ((Constructor != null)) {
        // Record if we see any constexpr constructors which are neither copy
        // nor move constructors.
        // C++1z [basic.types]p10:
        //   [...] has at least one constexpr constructor or constructor template
        //   (possibly inherited from a base class) that is not a copy or move
        //   constructor [...]
        if (Constructor.isConstexpr() && !Constructor.isCopyOrMoveConstructor()) {
          data().HasConstexprNonCopyMoveConstructor = true;
        }
        
        // C++ [dcl.init.aggr]p1:
        //   An aggregate is an array or a class with no user-declared
        //   constructors [...].
        // C++11 [dcl.init.aggr]p1:
        //   An aggregate is an array or a class with no user-provided
        //   constructors [...].
        // C++11 [dcl.init.aggr]p1:
        //   An aggregate is an array or a class with no user-provided
        //   constructors (including those inherited from a base class) [...].
        if (getASTContext().getLangOpts().CPlusPlus11 ? Constructor.isUserProvided() : !Constructor.isImplicit()) {
          data().Aggregate = false;
        }
      }
    }
    {
      
      // Handle destructors.
      CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(D);
      if ((DD != null)) {
        SMKind |= SpecialMemberFlags.SMF_Destructor;
        if (DD.isUserProvided()) {
          data().HasIrrelevantDestructor = false;
        }
        // If the destructor is explicitly defaulted and not trivial or not public
        // or if the destructor is deleted, we clear HasIrrelevantDestructor in
        // finishedDefaultedOrDeletedMember.
        
        // C++11 [class.dtor]p5:
        //   A destructor is trivial if [...] the destructor is not virtual.
        if (DD.isVirtual()) {
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_Destructor);
        }
      }
    }
    {
      
      // Handle member functions.
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
      if ((Method != null)) {
        if (Method.isCopyAssignmentOperator()) {
          SMKind |= SpecialMemberFlags.SMF_CopyAssignment;
          
          /*const*/ ReferenceType /*P*/ ParamTy = Method.getParamDecl(0).getType().$arrow().getAs(ReferenceType.class);
          if (!(ParamTy != null) || ParamTy.getPointeeType().isConstQualified()) {
            data().HasDeclaredCopyAssignmentWithConstParam = true;
          }
        }
        if (Method.isMoveAssignmentOperator()) {
          SMKind |= SpecialMemberFlags.SMF_MoveAssignment;
        }
        {
          
          // Keep the list of conversion functions up-to-date.
          CXXConversionDecl /*P*/ Conversion = dyn_cast_CXXConversionDecl(D);
          if ((Conversion != null)) {
            // FIXME: We use the 'unsafe' accessor for the access specifier here,
            // because Sema may not have set it yet. That's really just a misdesign
            // in Sema. However, LLDB *will* have set the access specifier correctly,
            // and adds declarations after the class is technically completed,
            // so completeDefinition()'s overriding of the access specifiers doesn't
            // work.
            AccessSpecifier AS = Conversion.getAccessUnsafe();
            if ((Conversion.getPrimaryTemplate() != null)) {
              // We don't record specializations.
            } else {
              final ASTContext /*&*/ Ctx = getASTContext();
              final ASTUnresolvedSet /*&*/ Conversions = data().Conversions.get(Ctx);
              NamedDecl /*P*/ Primary = (FunTmpl != null) ? cast_NamedDecl(FunTmpl) : cast_NamedDecl(Conversion);
              if ((Primary.getPreviousDecl() != null)) {
                Conversions.replace(cast_NamedDecl(Primary.getPreviousDecl()), 
                    Primary, AS);
              } else {
                Conversions.addDecl(Ctx, Primary, AS);
              }
            }
          }
        }
        if ((SMKind != 0)) {
          // If this is the first declaration of a special member, we no longer have
          // an implicit trivial special member.
          data().HasTrivialSpecialMembers &= $uint2uint_6bits(data().DeclaredSpecialMembers | $uint2uint_6bits(~SMKind));
          if (!Method.isImplicit() && !Method.isUserProvided()) {
            // This method is user-declared but not user-provided. We can't work out
            // whether it's trivial yet (not until we get to the end of the class).
            // We'll handle this method in finishedDefaultedOrDeletedMember.
          } else if (Method.isTrivial()) {
            data().HasTrivialSpecialMembers |= $uint2uint_6bits(SMKind);
          } else {
            data().DeclaredNonTrivialSpecialMembers |= $uint2uint_6bits(SMKind);
          }
          
          // Note when we have declared a declared special member, and suppress the
          // implicit declaration of this special member.
          data().DeclaredSpecialMembers |= $uint2uint_6bits(SMKind);
          if (!Method.isImplicit()) {
            data().UserDeclaredSpecialMembers |= $uint2uint_6bits(SMKind);
            
            // C++03 [class]p4:
            //   A POD-struct is an aggregate class that has [...] no user-defined
            //   copy assignment operator and no user-defined destructor.
            //
            // Since the POD bit is meant to be C++03 POD-ness, and in C++03,
            // aggregates could not have any constructors, clear it even for an
            // explicitly defaulted or deleted constructor.
            // type is technically an aggregate in C++0x since it wouldn't be in 03.
            //
            // Also, a user-declared move assignment operator makes a class non-POD.
            // This is an extension in C++03.
            data().PlainOldData = false;
          }
        }
        
        return;
      }
    }
    {
      
      // Handle non-static data members.
      FieldDecl /*P*/ Field = dyn_cast_FieldDecl(D);
      if ((Field != null)) {
        // C++ [class.bit]p2:
        //   A declaration for a bit-field that omits the identifier declares an 
        //   unnamed bit-field. Unnamed bit-fields are not members and cannot be 
        //   initialized.
        if (Field.isUnnamedBitfield()) {
          return;
        }
        
        // C++ [dcl.init.aggr]p1:
        //   An aggregate is an array or a class (clause 9) with [...] no
        //   private or protected non-static data members (clause 11).
        //
        // A POD must be an aggregate.    
        if (D.getAccess() == AccessSpecifier.AS_private || D.getAccess() == AccessSpecifier.AS_protected) {
          data().Aggregate = false;
          data().PlainOldData = false;
        }
        
        // C++0x [class]p7:
        //   A standard-layout class is a class that:
        //    [...]
        //    -- has the same access control for all non-static data members,
        switch (D.getAccess()) {
         case AS_private:
          data().HasPrivateFields = true;
          break;
         case AS_protected:
          data().HasProtectedFields = true;
          break;
         case AS_public:
          data().HasPublicFields = true;
          break;
         case AS_none:
          throw new llvm_unreachable("Invalid access specifier");
        }
        /*JSKIP;*/
        if (($bool2uint(data().HasPrivateFields) + $bool2uint(data().HasProtectedFields)
           + $bool2uint(data().HasPublicFields)) > 1) {
          data().IsStandardLayout = false;
        }
        
        // Keep track of the presence of mutable fields.
        if (Field.isMutable()) {
          data().HasMutableFields = true;
        }
        
        // C++11 [class.union]p8, DR1460:
        //   If X is a union, a non-static data member of X that is not an anonymous
        //   union is a variant member of X.
        if (isUnion() && !Field.isAnonymousStructOrUnion()) {
          data().HasVariantMembers = true;
        }
        
        // C++0x [class]p9:
        //   A POD struct is a class that is both a trivial class and a 
        //   standard-layout class, and has no non-static data members of type 
        //   non-POD struct, non-POD union (or array of such types).
        //
        // Automatic Reference Counting: the presence of a member of Objective-C pointer type
        // that does not explicitly have no lifetime makes the class a non-POD.
        final ASTContext /*&*/ Context = getASTContext();
        QualType T = Context.getBaseElementType(Field.getType());
        if (T.$arrow().isObjCRetainableType() || T.isObjCGCStrong()) {
          if (!Context.getLangOpts().ObjCAutoRefCount) {
            setHasObjectMember(true);
          } else if (T.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
            // Objective-C Automatic Reference Counting:
            //   If a class has a non-static data member of Objective-C pointer
            //   type (or array thereof), it is a non-POD type and its
            //   default constructor (if any), copy constructor, move constructor,
            //   copy assignment operator, move assignment operator, and destructor are
            //   non-trivial.
            setHasObjectMember(true);
            final  DefinitionData /*&*/ Data = data();
            Data.PlainOldData = false;
            Data.HasTrivialSpecialMembers = $uint2uint_6bits(0);
            Data.HasIrrelevantDestructor = false;
          }
        } else if (!T.isCXX98PODType(Context)) {
          data().PlainOldData = false;
        }
        if (T.$arrow().isReferenceType()) {
          if (!Field.hasInClassInitializer()) {
            data().HasUninitializedReferenceMember = true;
          }
          
          // C++0x [class]p7:
          //   A standard-layout class is a class that:
          //    -- has no non-static data members of type [...] reference,
          data().IsStandardLayout = false;
        }
        if (!Field.hasInClassInitializer() && !Field.isMutable()) {
          {
            CXXRecordDecl /*P*/ FieldType = Field.getType().$arrow().getAsCXXRecordDecl();
            if ((FieldType != null)) {
              if (FieldType.hasDefinition() && !FieldType.allowConstDefaultInit()) {
                data().HasUninitializedFields = true;
              }
            } else {
              data().HasUninitializedFields = true;
            }
          }
        }
        
        // Record if this field is the first non-literal or volatile field or base.
        if (!T.$arrow().isLiteralType(Context) || T.isVolatileQualified()) {
          data().HasNonLiteralTypeFieldsOrBases = true;
        }
        if (Field.hasInClassInitializer()
           || (Field.isAnonymousStructOrUnion()
           && Field.getType().$arrow().getAsCXXRecordDecl().hasInClassInitializer())) {
          data().HasInClassInitializer = true;
          
          // C++11 [class]p5:
          //   A default constructor is trivial if [...] no non-static data member
          //   of its class has a brace-or-equal-initializer.
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_DefaultConstructor);
          
          // C++11 [dcl.init.aggr]p1:
          //   An aggregate is a [...] class with [...] no
          //   brace-or-equal-initializers for non-static data members.
          //
          // This rule was removed in C++14.
          if (!getASTContext().getLangOpts().CPlusPlus14) {
            data().Aggregate = false;
          }
          
          // C++11 [class]p10:
          //   A POD struct is [...] a trivial class.
          data().PlainOldData = false;
        }
        
        // C++11 [class.copy]p23:
        //   A defaulted copy/move assignment operator for a class X is defined
        //   as deleted if X has:
        //    -- a non-static data member of reference type
        if (T.$arrow().isReferenceType()) {
          data().DefaultedMoveAssignmentIsDeleted = true;
        }
        {
          
          /*const*/ RecordType /*P*/ RecordTy = T.$arrow().<RecordType>getAs$RecordType();
          if ((RecordTy != null)) {
            CXXRecordDecl /*P*/ FieldRec = cast_CXXRecordDecl(RecordTy.getDecl());
            if ((FieldRec.getDefinition() != null)) {
              addedClassSubobject(FieldRec);
              
              // We may need to perform overload resolution to determine whether a
              // field can be moved if it's const or volatile qualified.
              if (((T.getCVRQualifiers() & (Qualifiers.TQ.Const | Qualifiers.TQ.Volatile)) != 0)) {
                data().NeedOverloadResolutionForMoveConstructor = true;
                data().NeedOverloadResolutionForMoveAssignment = true;
              }
              
              // C++11 [class.ctor]p5, C++11 [class.copy]p11:
              //   A defaulted [special member] for a class X is defined as
              //   deleted if:
              //    -- X is a union-like class that has a variant member with a
              //       non-trivial [corresponding special member]
              if (isUnion()) {
                if (FieldRec.hasNonTrivialMoveConstructor()) {
                  data().DefaultedMoveConstructorIsDeleted = true;
                }
                if (FieldRec.hasNonTrivialMoveAssignment()) {
                  data().DefaultedMoveAssignmentIsDeleted = true;
                }
                if (FieldRec.hasNonTrivialDestructor()) {
                  data().DefaultedDestructorIsDeleted = true;
                }
              }
              
              // For an anonymous union member, our overload resolution will perform
              // overload resolution for its members.
              if (Field.isAnonymousStructOrUnion()) {
                data().NeedOverloadResolutionForMoveConstructor |= FieldRec.data().NeedOverloadResolutionForMoveConstructor;
                data().NeedOverloadResolutionForMoveAssignment |= FieldRec.data().NeedOverloadResolutionForMoveAssignment;
                data().NeedOverloadResolutionForDestructor |= FieldRec.data().NeedOverloadResolutionForDestructor;
              }
              
              // C++0x [class.ctor]p5:
              //   A default constructor is trivial [...] if:
              //    -- for all the non-static data members of its class that are of
              //       class type (or array thereof), each such class has a trivial
              //       default constructor.
              if (!FieldRec.hasTrivialDefaultConstructor()) {
                data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_DefaultConstructor);
              }
              
              // C++0x [class.copy]p13:
              //   A copy/move constructor for class X is trivial if [...]
              //    [...]
              //    -- for each non-static data member of X that is of class type (or
              //       an array thereof), the constructor selected to copy/move that
              //       member is trivial;
              if (!FieldRec.hasTrivialCopyConstructor()) {
                data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_CopyConstructor);
              }
              // If the field doesn't have a simple move constructor, we'll eagerly
              // declare the move constructor for this class and we'll decide whether
              // it's trivial then.
              if (!FieldRec.hasTrivialMoveConstructor()) {
                data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_MoveConstructor);
              }
              
              // C++0x [class.copy]p27:
              //   A copy/move assignment operator for class X is trivial if [...]
              //    [...]
              //    -- for each non-static data member of X that is of class type (or
              //       an array thereof), the assignment operator selected to
              //       copy/move that member is trivial;
              if (!FieldRec.hasTrivialCopyAssignment()) {
                data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_CopyAssignment);
              }
              // If the field doesn't have a simple move assignment, we'll eagerly
              // declare the move assignment for this class and we'll decide whether
              // it's trivial then.
              if (!FieldRec.hasTrivialMoveAssignment()) {
                data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_MoveAssignment);
              }
              if (!FieldRec.hasTrivialDestructor()) {
                data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_Destructor);
              }
              if (!FieldRec.hasIrrelevantDestructor()) {
                data().HasIrrelevantDestructor = false;
              }
              if (FieldRec.hasObjectMember()) {
                setHasObjectMember(true);
              }
              if (FieldRec.hasVolatileMember()) {
                setHasVolatileMember(true);
              }
              
              // C++0x [class]p7:
              //   A standard-layout class is a class that:
              //    -- has no non-static data members of type non-standard-layout
              //       class (or array of such types) [...]
              if (!FieldRec.isStandardLayout()) {
                data().IsStandardLayout = false;
              }
              
              // C++0x [class]p7:
              //   A standard-layout class is a class that:
              //    [...]
              //    -- has no base classes of the same type as the first non-static
              //       data member.
              // We don't want to expend bits in the state of the record decl
              // tracking whether this is the first non-static data member so we
              // cheat a bit and use some of the existing state: the empty bit.
              // Virtual bases and virtual methods make a class non-empty, but they
              // also make it non-standard-layout so we needn't check here.
              // A non-empty base class may leave the class standard-layout, but not
              // if we have arrived here, and have at least one non-static data
              // member. If IsStandardLayout remains true, then the first non-static
              // data member must come through here with Empty still true, and Empty
              // will subsequently be set to false below.
              if (data().IsStandardLayout && data().Empty) {
                for (final /*const*/ CXXBaseSpecifier /*&*/ BI : bases()) {
                  if (Context.hasSameUnqualifiedType(BI.getType(), new QualType(T))) {
                    data().IsStandardLayout = false;
                    break;
                  }
                }
              }
              
              // Keep track of the presence of mutable fields.
              if (FieldRec.hasMutableFields()) {
                data().HasMutableFields = true;
              }
              
              // C++11 [class.copy]p13:
              //   If the implicitly-defined constructor would satisfy the
              //   requirements of a constexpr constructor, the implicitly-defined
              //   constructor is constexpr.
              // C++11 [dcl.constexpr]p4:
              //    -- every constructor involved in initializing non-static data
              //       members [...] shall be a constexpr constructor
              if (!Field.hasInClassInitializer()
                 && !FieldRec.hasConstexprDefaultConstructor() && !isUnion()) {
                // The standard requires any in-class initializer to be a constant
                // expression. We consider this to be a defect.
                data().DefaultedDefaultConstructorIsConstexpr = false;
              }
              
              // C++11 [class.copy]p8:
              //   The implicitly-declared copy constructor for a class X will have
              //   the form 'X::X(const X&)' if [...] for all the non-static data
              //   members of X that are of a class type M (or array thereof), each
              //   such class type has a copy constructor whose first parameter is
              //   of type 'const M&' or 'const volatile M&'.
              if (!FieldRec.hasCopyConstructorWithConstParam()) {
                data().ImplicitCopyConstructorHasConstParam = false;
              }
              
              // C++11 [class.copy]p18:
              //   The implicitly-declared copy assignment oeprator for a class X will
              //   have the form 'X& X::operator=(const X&)' if [...] for all the
              //   non-static data members of X that are of a class type M (or array
              //   thereof), each such class type has a copy assignment operator whose
              //   parameter is of type 'const M&', 'const volatile M&' or 'M'.
              if (!FieldRec.hasCopyAssignmentWithConstParam()) {
                data().ImplicitCopyAssignmentHasConstParam = false;
              }
              if (FieldRec.hasUninitializedReferenceMember()
                 && !Field.hasInClassInitializer()) {
                data().HasUninitializedReferenceMember = true;
              }
              
              // C++11 [class.union]p8, DR1460:
              //   a non-static data member of an anonymous union that is a member of
              //   X is also a variant member of X.
              if (FieldRec.hasVariantMembers()
                 && Field.isAnonymousStructOrUnion()) {
                data().HasVariantMembers = true;
              }
            }
          } else {
            // Base element type of field is a non-class type.
            if (!T.$arrow().isLiteralType(Context)
               || (!Field.hasInClassInitializer() && !isUnion())) {
              data().DefaultedDefaultConstructorIsConstexpr = false;
            }
            
            // C++11 [class.copy]p23:
            //   A defaulted copy/move assignment operator for a class X is defined
            //   as deleted if X has:
            //    -- a non-static data member of const non-class type (or array
            //       thereof)
            if (T.isConstQualified()) {
              data().DefaultedMoveAssignmentIsDeleted = true;
            }
          }
        }
        
        // C++0x [class]p7:
        //   A standard-layout class is a class that:
        //    [...]
        //    -- either has no non-static data members in the most derived
        //       class and at most one base class with non-static data members,
        //       or has no base classes with non-static data members, and
        // At this point we know that we have a non-static data member, so the last
        // clause holds.
        if (!data().HasNoNonEmptyBases) {
          data().IsStandardLayout = false;
        }
        
        // C++14 [meta.unary.prop]p4:
        //   T is a class type [...] with [...] no non-static data members other
        //   than bit-fields of length 0...
        if (data().Empty) {
          if (!Field.isBitField()
             || (!Field.getBitWidth().isTypeDependent()
             && !Field.getBitWidth().isValueDependent()
             && Field.getBitWidthValue(Context) != 0)) {
            data().Empty = false;
          }
        }
      }
    }
    {
      
      // Handle using declarations of conversion functions.
      UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(D);
      if ((Shadow != null)) {
        if (Shadow.getDeclName().getNameKind()
           == DeclarationName.NameKind.CXXConversionFunctionName) {
          final ASTContext /*&*/ Ctx = getASTContext();
          data().Conversions.get(Ctx).addDecl(Ctx, Shadow, Shadow.getAccess());
        }
      }
    }
    {
      
      UsingDecl /*P*/ Using = dyn_cast_UsingDecl(D);
      if ((Using != null)) {
        if (Using.getDeclName().getNameKind()
           == DeclarationName.NameKind.CXXConstructorName) {
          data().HasInheritedConstructor = true;
        }
        if (Using.getDeclName().getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Equal) {
          data().HasInheritedAssignment = true;
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::markedVirtualFunctionPure">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 430,
   FQN="clang::CXXRecordDecl::markedVirtualFunctionPure", NM="_ZN5clang13CXXRecordDecl25markedVirtualFunctionPureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl25markedVirtualFunctionPureEv")
  //</editor-fold>
  public/*private*/ void markedVirtualFunctionPure() {
    // C++ [class.abstract]p2: 
    //   A class is abstract if it has at least one pure virtual function.
    data().Abstract = true;
  }


  /*friend void setPure(bool = true)*/
  
  /*friend  class ASTNodeImporter*/
  
  /// \brief Get the head of our list of friend declarations, possibly
  /// deserializing the friends from an external AST source.
  
  /// \brief Get the head of our list of friend declarations, possibly
  /// deserializing the friends from an external AST source.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getFirstFriend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp", line = 65,
   FQN="clang::CXXRecordDecl::getFirstFriend", NM="_ZNK5clang13CXXRecordDecl14getFirstFriendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclFriend.cpp -nm=_ZNK5clang13CXXRecordDecl14getFirstFriendEv")
  //</editor-fold>
  /*friend*/public FriendDecl /*P*/ getFirstFriend() /*const*/ {
    ExternalASTSource /*P*/ Source = getParentASTContext().getExternalSource();
    Decl /*P*/ First = data().FirstFriend.get(Source);
    return (First != null) ? cast_FriendDecl(First) : null;
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::CXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 85,
   FQN="clang::CXXRecordDecl::CXXRecordDecl", NM="_ZN5clang13CXXRecordDeclC1ENS_4Decl4KindENS_11TagTypeKindERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES9_PNS_14IdentifierInfoEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDeclC1ENS_4Decl4KindENS_11TagTypeKindERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES9_PNS_14IdentifierInfoEPS0_")
  //</editor-fold>
  protected CXXRecordDecl(Kind K, TagTypeKind TK, final /*const*/ ASTContext /*&*/ C, 
      DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
      CXXRecordDecl /*P*/ PrevDecl) {
    // : RecordDecl(K, TK, C, DC, StartLoc, IdLoc, Id, PrevDecl), DefinitionData(PrevDecl ? PrevDecl->DefinitionData : null), TemplateOrInstantiation() 
    //START JInit
    super(K, TK, C, DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, PrevDecl);
    this.DefinitionData = (PrevDecl != null) ? PrevDecl.DefinitionData : null;
    this.TemplateOrInstantiation = new PointerUnion<ClassTemplateDecl /*P*/ , MemberSpecializationInfo /*P*/ >(ClassTemplateDecl /*P*/ .class);
    //END JInit
  }


/*public:*/
  /// \brief Iterator that traverses the base classes of a class.
  /*typedef CXXBaseSpecifier *base_class_iterator*/
//  public final class base_class_iterator extends CXXBaseSpecifier /*P*/ { };
  
  /// \brief Iterator that traverses the base classes of a class.
  /*typedef const CXXBaseSpecifier *base_class_const_iterator*/
//  public final class base_class_const_iterator extends /*const*/ CXXBaseSpecifier /*P*/ { };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 654,
   FQN="clang::CXXRecordDecl::getCanonicalDecl", NM="_ZN5clang13CXXRecordDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl16getCanonicalDeclEv")
  //</editor-fold>
  @Override public CXXRecordDecl /*P*/ getCanonicalDecl()/* override*/ {
    return cast_CXXRecordDecl(super.getCanonicalDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getCanonicalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 657,
   FQN="clang::CXXRecordDecl::getCanonicalDecl", NM="_ZNK5clang13CXXRecordDecl16getCanonicalDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl16getCanonicalDeclEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getCanonicalDecl$Const() /*const*/ {
    return ((/*const_cast*/CXXRecordDecl /*P*/ )(this)).getCanonicalDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 661,
   FQN="clang::CXXRecordDecl::getPreviousDecl", NM="_ZN5clang13CXXRecordDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15getPreviousDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getPreviousDecl() {
    return cast_or_null_CXXRecordDecl(/*JCast:RecordDecl * */super.getPreviousDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 665,
   FQN="clang::CXXRecordDecl::getPreviousDecl", NM="_ZNK5clang13CXXRecordDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return ((/*const_cast*/CXXRecordDecl /*P*/ )(this)).getPreviousDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 669,
   FQN="clang::CXXRecordDecl::getMostRecentDecl", NM="_ZN5clang13CXXRecordDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl17getMostRecentDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getMostRecentDecl() {
    return cast_CXXRecordDecl(/*JCast:RecordDecl * */super.getMostRecentDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 674,
   FQN="clang::CXXRecordDecl::getMostRecentDecl", NM="_ZNK5clang13CXXRecordDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/CXXRecordDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 678,
   FQN="clang::CXXRecordDecl::getDefinition", NM="_ZNK5clang13CXXRecordDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl13getDefinitionEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getDefinition() /*const*/ {
    // We only need an update if we don't already know which
    // declaration is the definition.
    DefinitionData /*P*/ DD = (DefinitionData != null) ? DefinitionData : dataPtr();
    return (DD != null) ? DD.Definition : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 685,
   FQN="clang::CXXRecordDecl::hasDefinition", NM="_ZNK5clang13CXXRecordDecl13hasDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl13hasDefinitionEv")
  //</editor-fold>
  public boolean hasDefinition() /*const*/ {
    return (DefinitionData != null) || (dataPtr() != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 94,
   FQN="clang::CXXRecordDecl::Create", NM="_ZN5clang13CXXRecordDecl6CreateERKNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoEPS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl6CreateERKNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoEPS0_b")
  //</editor-fold>
  public static CXXRecordDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, TagTypeKind TK, 
        DeclContext /*P*/ DC, SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id) {
    return Create(C, TK, 
        DC, StartLoc, 
        IdLoc, Id, 
        (CXXRecordDecl /*P*/ )null, 
        false);
  }
  public static CXXRecordDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, TagTypeKind TK, 
        DeclContext /*P*/ DC, SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        CXXRecordDecl /*P*/ PrevDecl/*= null*/) {
    return Create(C, TK, 
        DC, StartLoc, 
        IdLoc, Id, 
        PrevDecl, 
        false);
  }
  public static CXXRecordDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, TagTypeKind TK, 
        DeclContext /*P*/ DC, SourceLocation StartLoc, 
        SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
        CXXRecordDecl /*P*/ PrevDecl/*= null*/, 
        boolean DelayTypeCreation/*= false*/) {
    CXXRecordDecl /*P*/ R = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new CXXRecordDecl(Kind.CXXRecord, TK, C, DC, new SourceLocation(StartLoc), 
                new SourceLocation(IdLoc), Id, PrevDecl);
     });
    R.MayHaveOutOfDateDef = C.getLangOpts().Modules;
    
    // FIXME: DelayTypeCreation seems like such a hack
    if (!DelayTypeCreation) {
      C.getTypeDeclType(R, PrevDecl);
    }
    return R;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::CreateLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 109,
   FQN="clang::CXXRecordDecl::CreateLambda", NM="_ZN5clang13CXXRecordDecl12CreateLambdaERKNS_10ASTContextEPNS_11DeclContextEPNS_14TypeSourceInfoENS_14SourceLocationEbbNS_20LambdaCaptureDefaultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl12CreateLambdaERKNS_10ASTContextEPNS_11DeclContextEPNS_14TypeSourceInfoENS_14SourceLocationEbbNS_20LambdaCaptureDefaultE")
  //</editor-fold>
  public static CXXRecordDecl /*P*/ CreateLambda(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
              TypeSourceInfo /*P*/ Info, SourceLocation Loc, 
              boolean Dependent, boolean IsGeneric, 
              LambdaCaptureDefault CaptureDefault) {
    CXXRecordDecl /*P*/ R = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new CXXRecordDecl(Kind.CXXRecord, TagTypeKind.TTK_Class, C, DC, new SourceLocation(Loc), new SourceLocation(Loc), 
                (IdentifierInfo /*P*/ )null, (CXXRecordDecl /*P*/ )null);
     });
    R.IsBeingDefined = true;
    R.DefinitionData
       = /*FIXME: NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (C)*/ new  LambdaDefinitionData(R, Info, Dependent, IsGeneric, 
        CaptureDefault);
    R.MayHaveOutOfDateDef = false;
    R.setImplicit(true);
    C.getTypeDeclType(R, /*PrevDecl=*/ (/*const*/ TypeDecl /*P*/ )null);
    return R;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 127,
   FQN="clang::CXXRecordDecl::CreateDeserialized", NM="_ZN5clang13CXXRecordDecl18CreateDeserializedERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl18CreateDeserializedERKNS_10ASTContextEj")
  //</editor-fold>
  public static CXXRecordDecl /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ C, /*uint*/int ID) {
    CXXRecordDecl /*P*/ R = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new CXXRecordDecl(Kind.CXXRecord, TagTypeKind.TTK_Struct, C, (DeclContext /*P*/ )null, new SourceLocation(), new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, (CXXRecordDecl /*P*/ )null);
     });
    R.MayHaveOutOfDateDef = false;
    return R;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isDynamicClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 698,
   FQN="clang::CXXRecordDecl::isDynamicClass", NM="_ZNK5clang13CXXRecordDecl14isDynamicClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14isDynamicClassEv")
  //</editor-fold>
  public boolean isDynamicClass() /*const*/ {
    return data().Polymorphic || data().NumVBases != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setIsParsingBaseSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 702,
   FQN="clang::CXXRecordDecl::setIsParsingBaseSpecifiers", NM="_ZN5clang13CXXRecordDecl26setIsParsingBaseSpecifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl26setIsParsingBaseSpecifiersEv")
  //</editor-fold>
  public void setIsParsingBaseSpecifiers() {
    data().IsParsingBaseSpecifiers = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isParsingBaseSpecifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 704,
   FQN="clang::CXXRecordDecl::isParsingBaseSpecifiers", NM="_ZNK5clang13CXXRecordDecl23isParsingBaseSpecifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23isParsingBaseSpecifiersEv")
  //</editor-fold>
  public boolean isParsingBaseSpecifiers() /*const*/ {
    return data().IsParsingBaseSpecifiers;
  }

  
  /// \brief Sets the base classes of this struct or class.
  
  /// \brief Sets the base classes of this struct or class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setBases">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 136,
   FQN="clang::CXXRecordDecl::setBases", NM="_ZN5clang13CXXRecordDecl8setBasesEPKPKNS_16CXXBaseSpecifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl8setBasesEPKPKNS_16CXXBaseSpecifierEj")
  //</editor-fold>
  public void setBases(type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> Bases, 
          /*uint*/int NumBases) {
    final ASTContext /*&*/ C = getASTContext();
    if (!data().Bases.isOffset() && $greater_uint(data().NumBases, 0)) {
      C.Deallocate(data().getBases());
    }
    if ((NumBases != 0)) {
      if (!C.getLangOpts().CPlusPlus1z) {
        // C++ [dcl.init.aggr]p1:
        //   An aggregate is [...] a class with [...] no base classes [...].
        data().Aggregate = false;
      }
      
      // C++ [class]p4:
      //   A POD-struct is an aggregate class...
      data().PlainOldData = false;
    }
    
    // The set of seen virtual base types.
    SmallPtrSet<CanQual<Type>> SeenVBaseTypes/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 8);
    
    // The virtual bases of this class.
    SmallVector</*const*/ CXXBaseSpecifier /*P*/ > VBases/*J*/= new SmallVector</*const*/ CXXBaseSpecifier /*P*/ >(8, (/*const*/ CXXBaseSpecifier /*P*/ )null);
    
    data().Bases.$assign(/*FIXME:NEW_EXPR*//*new (C)*/ create_type$ptr(new CXXBaseSpecifier [NumBases]));
    data().NumBases = NumBases;
    for (/*uint*/int i = 0; $less_uint(i, NumBases); ++i) {
      data().getBases()./*JAVA*/$set(i, $Deref(Bases.$at(i)));
      // Keep track of inherited vbases for this base class.
      /*const*/ CXXBaseSpecifier /*P*/ Base = Bases.$at(i);
      QualType BaseType = Base.getType();
      // Skip dependent types; we can't do any checking on them now.
      if (BaseType.$arrow().isDependentType()) {
        continue;
      }
      CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.$arrow().<RecordType>getAs$RecordType().getDecl());
      if (!BaseClassDecl.isEmpty()) {
        if (!data().Empty) {
          // C++0x [class]p7:
          //   A standard-layout class is a class that:
          //    [...]
          //    -- either has no non-static data members in the most derived
          //       class and at most one base class with non-static data members,
          //       or has no base classes with non-static data members, and
          // If this is the second non-empty base, then neither of these two
          // clauses can be true.
          data().IsStandardLayout = false;
        }
        
        // C++14 [meta.unary.prop]p4:
        //   T is a class type [...] with [...] no base class B for which
        //   is_empty<B>::value is false.
        data().Empty = false;
        data().HasNoNonEmptyBases = false;
      }
      
      // C++1z [dcl.init.agg]p1:
      //   An aggregate is a class with [...] no private or protected base classes
      if (Base.getAccessSpecifier() != AccessSpecifier.AS_public) {
        data().Aggregate = false;
      }
      
      // C++ [class.virtual]p1:
      //   A class that declares or inherits a virtual function is called a 
      //   polymorphic class.
      if (BaseClassDecl.isPolymorphic()) {
        data().Polymorphic = true;
      }
      
      // C++0x [class]p7:
      //   A standard-layout class is a class that: [...]
      //    -- has no non-standard-layout base classes
      if (!BaseClassDecl.isStandardLayout()) {
        data().IsStandardLayout = false;
      }
      
      // Record if this base is the first non-literal field or base.
      if (!hasNonLiteralTypeFieldsOrBases() && !BaseType.$arrow().isLiteralType(C)) {
        data().HasNonLiteralTypeFieldsOrBases = true;
      }
      
      // Now go through all virtual bases of this base and add them.
      for (final /*const*/ CXXBaseSpecifier /*&*/ VBase : BaseClassDecl.vbases()) {
        // Add this base if it's not already in the list.
        if (SeenVBaseTypes.insert(C.getCanonicalType(VBase.getType())).second) {
          VBases.push_back($AddrOf(VBase));
          {
            
            // C++11 [class.copy]p8:
            //   The implicitly-declared copy constructor for a class X will have
            //   the form 'X::X(const X&)' if each [...] virtual base class B of X
            //   has a copy constructor whose first parameter is of type
            //   'const B&' or 'const volatile B&' [...]
            CXXRecordDecl /*P*/ VBaseDecl = VBase.getType().$arrow().getAsCXXRecordDecl();
            if ((VBaseDecl != null)) {
              if (!VBaseDecl.hasCopyConstructorWithConstParam()) {
                data().ImplicitCopyConstructorHasConstParam = false;
              }
            }
          }
          
          // C++1z [dcl.init.agg]p1:
          //   An aggregate is a class with [...] no virtual base classes
          data().Aggregate = false;
        }
      }
      if (Base.isVirtual()) {
        // Add this base if it's not already in the list.
        if (SeenVBaseTypes.insert(C.getCanonicalType(new QualType(BaseType))).second) {
          VBases.push_back(Base);
        }
        
        // C++14 [meta.unary.prop] is_empty:
        //   T is a class type, but not a union type, with ... no virtual base
        //   classes
        data().Empty = false;
        
        // C++1z [dcl.init.agg]p1:
        //   An aggregate is a class with [...] no virtual base classes
        data().Aggregate = false;
        
        // C++11 [class.ctor]p5, C++11 [class.copy]p12, C++11 [class.copy]p25:
        //   A [default constructor, copy/move constructor, or copy/move assignment
        //   operator for a class X] is trivial [...] if:
        //    -- class X has [...] no virtual base classes
        data().HasTrivialSpecialMembers &= $int2uint_6bits(SpecialMemberFlags.SMF_Destructor);
        
        // C++0x [class]p7:
        //   A standard-layout class is a class that: [...]
        //    -- has [...] no virtual base classes
        data().IsStandardLayout = false;
        
        // C++11 [dcl.constexpr]p4:
        //   In the definition of a constexpr constructor [...]
        //    -- the class shall not have any virtual base classes
        data().DefaultedDefaultConstructorIsConstexpr = false;
      } else {
        // C++ [class.ctor]p5:
        //   A default constructor is trivial [...] if:
        //    -- all the direct base classes of its class have trivial default
        //       constructors.
        if (!BaseClassDecl.hasTrivialDefaultConstructor()) {
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_DefaultConstructor);
        }
        
        // C++0x [class.copy]p13:
        //   A copy/move constructor for class X is trivial if [...]
        //    [...]
        //    -- the constructor selected to copy/move each direct base class
        //       subobject is trivial, and
        if (!BaseClassDecl.hasTrivialCopyConstructor()) {
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_CopyConstructor);
        }
        // If the base class doesn't have a simple move constructor, we'll eagerly
        // declare it and perform overload resolution to determine which function
        // it actually calls. If it does have a simple move constructor, this
        // check is correct.
        if (!BaseClassDecl.hasTrivialMoveConstructor()) {
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_MoveConstructor);
        }
        
        // C++0x [class.copy]p27:
        //   A copy/move assignment operator for class X is trivial if [...]
        //    [...]
        //    -- the assignment operator selected to copy/move each direct base
        //       class subobject is trivial, and
        if (!BaseClassDecl.hasTrivialCopyAssignment()) {
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_CopyAssignment);
        }
        // If the base class doesn't have a simple move assignment, we'll eagerly
        // declare it and perform overload resolution to determine which function
        // it actually calls. If it does have a simple move assignment, this
        // check is correct.
        if (!BaseClassDecl.hasTrivialMoveAssignment()) {
          data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_MoveAssignment);
        }
        
        // C++11 [class.ctor]p6:
        //   If that user-written default constructor would satisfy the
        //   requirements of a constexpr constructor, the implicitly-defined
        //   default constructor is constexpr.
        if (!BaseClassDecl.hasConstexprDefaultConstructor()) {
          data().DefaultedDefaultConstructorIsConstexpr = false;
        }
      }
      
      // C++ [class.ctor]p3:
      //   A destructor is trivial if all the direct base classes of its class
      //   have trivial destructors.
      if (!BaseClassDecl.hasTrivialDestructor()) {
        data().HasTrivialSpecialMembers &= $int2uint_6bits(~SpecialMemberFlags.SMF_Destructor);
      }
      if (!BaseClassDecl.hasIrrelevantDestructor()) {
        data().HasIrrelevantDestructor = false;
      }
      
      // C++11 [class.copy]p18:
      //   The implicitly-declared copy assignment oeprator for a class X will
      //   have the form 'X& X::operator=(const X&)' if each direct base class B
      //   of X has a copy assignment operator whose parameter is of type 'const
      //   B&', 'const volatile B&', or 'B' [...]
      if (!BaseClassDecl.hasCopyAssignmentWithConstParam()) {
        data().ImplicitCopyAssignmentHasConstParam = false;
      }
      
      // C++11 [class.copy]p8:
      //   The implicitly-declared copy constructor for a class X will have
      //   the form 'X::X(const X&)' if each direct [...] base class B of X
      //   has a copy constructor whose first parameter is of type
      //   'const B&' or 'const volatile B&' [...]
      if (!BaseClassDecl.hasCopyConstructorWithConstParam()) {
        data().ImplicitCopyConstructorHasConstParam = false;
      }
      
      // A class has an Objective-C object member if... or any of its bases
      // has an Objective-C object member.
      if (BaseClassDecl.hasObjectMember()) {
        setHasObjectMember(true);
      }
      if (BaseClassDecl.hasVolatileMember()) {
        setHasVolatileMember(true);
      }
      
      // Keep track of the presence of mutable fields.
      if (BaseClassDecl.hasMutableFields()) {
        data().HasMutableFields = true;
      }
      if (BaseClassDecl.hasUninitializedReferenceMember()) {
        data().HasUninitializedReferenceMember = true;
      }
      if (!BaseClassDecl.allowConstDefaultInit()) {
        data().HasUninitializedFields = true;
      }
      
      addedClassSubobject(BaseClassDecl);
    }
    if (VBases.empty()) {
      data().IsParsingBaseSpecifiers = false;
      return;
    }
    
    // Create base specifier for any direct or indirect virtual bases.
    data().VBases.$assign(/*FIXME:NEW_EXPR*//*new (C)*/ create_type$ptr(new CXXBaseSpecifier [VBases.size()]));
    data().NumVBases = VBases.size();
    for (int I = 0, E = VBases.size(); I != E; ++I) {
      QualType Type = VBases.$at(I).getType();
      if (!Type.$arrow().isDependentType()) {
        addedClassSubobject(Type.$arrow().getAsCXXRecordDecl());
      }
      data().getVBases().$set(I, $Deref(VBases.$at(I)));
    }
    
    data().IsParsingBaseSpecifiers = false;
  }


  
  /// \brief Retrieves the number of base classes of this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getNumBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 712,
   FQN="clang::CXXRecordDecl::getNumBases", NM="_ZNK5clang13CXXRecordDecl11getNumBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl11getNumBasesEv")
  //</editor-fold>
  public /*uint*/int getNumBases() /*const*/ {
    return data().NumBases;
  }

  
  /*typedef llvm::iterator_range<base_class_iterator> base_class_range*/
//  public final class base_class_range extends iterator_range<CXXBaseSpecifier>{ };
  /*typedef llvm::iterator_range<base_class_const_iterator> base_class_const_range*/
//  public final class base_class_const_range extends iterator_range</*const*/ CXXBaseSpecifier>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::bases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 718,
   FQN="clang::CXXRecordDecl::bases", NM="_ZN5clang13CXXRecordDecl5basesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl5basesEv")
  //</editor-fold>
  public iterator_range<CXXBaseSpecifier> bases() {
    return new iterator_range<CXXBaseSpecifier>(bases_begin(), bases_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::bases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 721,
   FQN="clang::CXXRecordDecl::bases", NM="_ZNK5clang13CXXRecordDecl5basesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl5basesEv")
  //</editor-fold>
  public iterator_range</*const*/ CXXBaseSpecifier> bases$Const() /*const*/ {
    return new iterator_range</*const*/ CXXBaseSpecifier>(bases_begin$Const(), bases_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::bases_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 725,
   FQN="clang::CXXRecordDecl::bases_begin", NM="_ZN5clang13CXXRecordDecl11bases_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl11bases_beginEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ bases_begin() {
    return data().getBases();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::bases_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 726,
   FQN="clang::CXXRecordDecl::bases_begin", NM="_ZNK5clang13CXXRecordDecl11bases_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl11bases_beginEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ bases_begin$Const() /*const*/ {
    return data().getBases();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::bases_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 727,
   FQN="clang::CXXRecordDecl::bases_end", NM="_ZN5clang13CXXRecordDecl9bases_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl9bases_endEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ bases_end() {
    return bases_begin().$add(data().NumBases);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::bases_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 728,
   FQN="clang::CXXRecordDecl::bases_end", NM="_ZNK5clang13CXXRecordDecl9bases_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl9bases_endEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ bases_end$Const() /*const*/ {
    return bases_begin$Const().$add(data().NumBases);
  }

  
  /// \brief Retrieves the number of virtual base classes of this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getNumVBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 733,
   FQN="clang::CXXRecordDecl::getNumVBases", NM="_ZNK5clang13CXXRecordDecl12getNumVBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl12getNumVBasesEv")
  //</editor-fold>
  public /*uint*/int getNumVBases() /*const*/ {
    return data().NumVBases;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::vbases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 735,
   FQN="clang::CXXRecordDecl::vbases", NM="_ZN5clang13CXXRecordDecl6vbasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl6vbasesEv")
  //</editor-fold>
  public iterator_range<CXXBaseSpecifier> vbases() {
    return new iterator_range<CXXBaseSpecifier>(vbases_begin(), vbases_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::vbases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 738,
   FQN="clang::CXXRecordDecl::vbases", NM="_ZNK5clang13CXXRecordDecl6vbasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl6vbasesEv")
  //</editor-fold>
  public iterator_range</*const*/ CXXBaseSpecifier> vbases$Const() /*const*/ {
    return new iterator_range</*const*/ CXXBaseSpecifier>(vbases_begin$Const(), vbases_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::vbases_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 742,
   FQN="clang::CXXRecordDecl::vbases_begin", NM="_ZN5clang13CXXRecordDecl12vbases_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl12vbases_beginEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ vbases_begin() {
    return data().getVBases();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::vbases_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 743,
   FQN="clang::CXXRecordDecl::vbases_begin", NM="_ZNK5clang13CXXRecordDecl12vbases_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl12vbases_beginEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ vbases_begin$Const() /*const*/ {
    return data().getVBases();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::vbases_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 744,
   FQN="clang::CXXRecordDecl::vbases_end", NM="_ZN5clang13CXXRecordDecl10vbases_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl10vbases_endEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ vbases_end() {
    return vbases_begin().$add(data().NumVBases);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::vbases_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 745,
   FQN="clang::CXXRecordDecl::vbases_end", NM="_ZNK5clang13CXXRecordDecl10vbases_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl10vbases_endEv")
  //</editor-fold>
  public type$ptr<CXXBaseSpecifier>/*base_class_iterator*/ vbases_end$Const() /*const*/ {
    return vbases_begin$Const().$add(data().NumVBases);
  }

  
  /// \brief Determine whether this class has any dependent base classes which
  /// are not the current instantiation.
  
  /// \brief Determine whether this class has any dependent base classes which
  /// are not the current instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasAnyDependentBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 406,
   FQN="clang::CXXRecordDecl::hasAnyDependentBases", NM="_ZNK5clang13CXXRecordDecl20hasAnyDependentBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl20hasAnyDependentBasesEv")
  //</editor-fold>
  public boolean hasAnyDependentBases() /*const*/ {
    if (!isDependentContext()) {
      return false;
    }
    
    return !forallBases(/*FuncArg*//*[]*/ (/*const*/ CXXRecordDecl /*P*/ $Prm0) -> {
              return true;
            });
  }


  
  /// Iterator access to method members.  The method iterator visits
  /// all method members of the class, including non-instance methods,
  /// special methods, etc.
  /*typedef specific_decl_iterator<CXXMethodDecl> method_iterator*/
//  public final class method_iterator extends specific_decl_iterator<CXXMethodDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<CXXMethodDecl> > method_range*/
//  public final class method_range extends iterator_range<CXXMethodDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 760,
   FQN="clang::CXXRecordDecl::methods", NM="_ZNK5clang13CXXRecordDecl7methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl7methodsEv")
  //</editor-fold>
  public iterator_range<CXXMethodDecl /*P*/ > methods() /*const*/ {
    return new iterator_range<CXXMethodDecl /*P*/ >(method_begin(), method_end());
  }

  
  /// \brief Method begin iterator.  Iterates in the order the methods
  /// were declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::method_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 766,
   FQN="clang::CXXRecordDecl::method_begin", NM="_ZNK5clang13CXXRecordDecl12method_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl12method_beginEv")
  //</editor-fold>
  public specific_decl_iterator<CXXMethodDecl> method_begin() /*const*/ {
    return new specific_decl_iterator<CXXMethodDecl>(CXXMethodDecl.class, decls_begin());
  }

  /// \brief Method past-the-end iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::method_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 770,
   FQN="clang::CXXRecordDecl::method_end", NM="_ZNK5clang13CXXRecordDecl10method_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl10method_endEv")
  //</editor-fold>
  public specific_decl_iterator<CXXMethodDecl> method_end() /*const*/ {
    return new specific_decl_iterator<CXXMethodDecl>(CXXMethodDecl.class, decls_end());
  }

  
  /// Iterator access to constructor members.
  /*typedef specific_decl_iterator<CXXConstructorDecl> ctor_iterator*/
//  public final class ctor_iterator extends specific_decl_iterator<CXXConstructorDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<CXXConstructorDecl> > ctor_range*/
//  public final class ctor_range extends iterator_range<CXXConstructorDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::ctors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 779,
   FQN="clang::CXXRecordDecl::ctors", NM="_ZNK5clang13CXXRecordDecl5ctorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl5ctorsEv")
  //</editor-fold>
  public iterator_range<CXXConstructorDecl /*P*/ > ctors() /*const*/ {
    return new iterator_range<CXXConstructorDecl /*P*/ >(ctor_begin(), ctor_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::ctor_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 781,
   FQN="clang::CXXRecordDecl::ctor_begin", NM="_ZNK5clang13CXXRecordDecl10ctor_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl10ctor_beginEv")
  //</editor-fold>
  public specific_decl_iterator<CXXConstructorDecl> ctor_begin() /*const*/ {
    return new specific_decl_iterator<CXXConstructorDecl>(CXXConstructorDecl.class, decls_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::ctor_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 784,
   FQN="clang::CXXRecordDecl::ctor_end", NM="_ZNK5clang13CXXRecordDecl8ctor_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl8ctor_endEv")
  //</editor-fold>
  public specific_decl_iterator<CXXConstructorDecl> ctor_end() /*const*/ {
    return new specific_decl_iterator<CXXConstructorDecl>(CXXConstructorDecl.class, decls_end());
  }

  
  /// An iterator over friend declarations.  All of these are defined
  /// in DeclFriend.h.
  
  /// An iterator over the friend declarations of a class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 173,
   FQN="clang::CXXRecordDecl::friend_iterator", NM="_ZN5clang13CXXRecordDecl15friend_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorE")
  //</editor-fold>
  public static class friend_iterator implements type$iterator<friend_iterator, FriendDecl> {
    private FriendDecl /*P*/ Ptr;
    
    /*friend  class CXXRecordDecl*/
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::friend_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 177,
     FQN="clang::CXXRecordDecl::friend_iterator::friend_iterator", NM="_ZN5clang13CXXRecordDecl15friend_iteratorC1EPNS_10FriendDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorC1EPNS_10FriendDeclE")
    //</editor-fold>
    private /*explicit*/ friend_iterator(FriendDecl /*P*/ Ptr) {
      // : Ptr(Ptr) 
      //START JInit
      this.Ptr = Ptr;
      //END JInit
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::friend_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 179,
     FQN="clang::CXXRecordDecl::friend_iterator::friend_iterator", NM="_ZN5clang13CXXRecordDecl15friend_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorC1Ev")
    //</editor-fold>
    public friend_iterator() {
    }

    
    /*typedef FriendDecl *value_type*/
//    public final class value_type extends FriendDecl /*P*/ { };
    /*typedef FriendDecl *reference*/
//    public final class reference extends FriendDecl /*P*/ { };
    /*typedef FriendDecl *pointer*/
//    public final class pointer extends FriendDecl /*P*/ { };
    /*typedef int difference_type*/;
    /*typedef std::forward_iterator_tag iterator_category*/
//    public final class iterator_category extends std.forward_iterator_tag{ };
    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 187,
     FQN="clang::CXXRecordDecl::friend_iterator::operator*", NM="_ZNK5clang13CXXRecordDecl15friend_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl15friend_iteratordeEv")
    //</editor-fold>
    public FriendDecl /*P*/ $star() /*const*/ {
      return Ptr;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 189,
     FQN="clang::CXXRecordDecl::friend_iterator::operator++", NM="_ZN5clang13CXXRecordDecl15friend_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorppEv")
    //</editor-fold>
    public friend_iterator /*&*/ $preInc() {
      assert ((Ptr != null)) : "attempt to increment past end of friend list";
      Ptr = Ptr.getNextFriend();
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 195,
     FQN="clang::CXXRecordDecl::friend_iterator::operator++", NM="_ZN5clang13CXXRecordDecl15friend_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorppEi")
    //</editor-fold>
    public friend_iterator $postInc(int $Prm0) {
      friend_iterator tmp = new friend_iterator(/*Deref*/this);
      $Deref(this.$preInc());
      return tmp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 201,
     FQN="clang::CXXRecordDecl::friend_iterator::operator==", NM="_ZNK5clang13CXXRecordDecl15friend_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl15friend_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ friend_iterator /*&*/ Other) /*const*/ {
      return Ptr == Other.Ptr;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 205,
     FQN="clang::CXXRecordDecl::friend_iterator::operator!=", NM="_ZNK5clang13CXXRecordDecl15friend_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl15friend_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ friend_iterator /*&*/ Other) /*const*/ {
      return Ptr != Other.Ptr;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator+=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 209,
     FQN="clang::CXXRecordDecl::friend_iterator::operator+=", NM="_ZN5clang13CXXRecordDecl15friend_iteratorpLEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorpLEi")
    //</editor-fold>
    public friend_iterator /*&*/ $addassign(int N) {
      assert (N >= 0) : "cannot rewind a CXXRecordDecl::friend_iterator";
      while (((N--) != 0)) {
        $Deref(this.$preInc());
      }
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::operator+">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 216,
     FQN="clang::CXXRecordDecl::friend_iterator::operator+", NM="_ZNK5clang13CXXRecordDecl15friend_iteratorplEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl15friend_iteratorplEi")
    //</editor-fold>
    public friend_iterator $add(int N) /*const*/ {
      friend_iterator tmp = new friend_iterator(/*Deref*/this);
      tmp.$addassign(N);
      return tmp;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::friend_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 173,
     FQN="clang::CXXRecordDecl::friend_iterator::friend_iterator", NM="_ZN5clang13CXXRecordDecl15friend_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ friend_iterator(final /*const*/ friend_iterator /*&*/ $Prm0) {
      // : Ptr(.Ptr) 
      //START JInit
      this.Ptr = $Prm0.Ptr;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_iterator::friend_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 173,
     FQN="clang::CXXRecordDecl::friend_iterator::friend_iterator", NM="_ZN5clang13CXXRecordDecl15friend_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl15friend_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ friend_iterator(JD$Move _dparam, final friend_iterator /*&&*/$Prm0) {
      // : Ptr(static_cast<friend_iterator &&>().Ptr) 
      //START JInit
      this.Ptr = $Prm0.Ptr;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Ptr=" + Ptr; // NOI18N
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public type$ref<FriendDecl> star$ref() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public friend_iterator clone() {
      return new friend_iterator(this);
    }

    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public boolean $eq(Object other) {
      return this.$eq((friend_iterator)other);
    }
  };
  /*typedef llvm::iterator_range<friend_iterator> friend_range*/
//  public final class friend_range extends iterator_range<FriendDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friends">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 231,
   FQN="clang::CXXRecordDecl::friends", NM="_ZNK5clang13CXXRecordDecl7friendsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl7friendsEv")
  //</editor-fold>
  public /*inline*/ iterator_range<FriendDecl /*P*/ > friends() /*const*/ {
    return new iterator_range<FriendDecl /*P*/ >(friend_begin(), friend_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 223,
   FQN="clang::CXXRecordDecl::friend_begin", NM="_ZNK5clang13CXXRecordDecl12friend_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl12friend_beginEv")
  //</editor-fold>
  public /*inline*/ CXXRecordDecl.friend_iterator friend_begin() /*const*/ {
    return new friend_iterator(getFirstFriend());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::friend_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 227,
   FQN="clang::CXXRecordDecl::friend_end", NM="_ZNK5clang13CXXRecordDecl10friend_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl10friend_endEv")
  //</editor-fold>
  public /*inline*/ CXXRecordDecl.friend_iterator friend_end() /*const*/ {
    return new friend_iterator((FriendDecl /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::pushFriendDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclFriend.h", line = 235,
   FQN="clang::CXXRecordDecl::pushFriendDecl", NM="_ZN5clang13CXXRecordDecl14pushFriendDeclEPNS_10FriendDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl14pushFriendDeclEPNS_10FriendDeclE")
  //</editor-fold>
  public /*inline*/ void pushFriendDecl(FriendDecl /*P*/ FD) {
    assert (!FD.NextFriend.$bool()) : "friend already has next friend?";
    FD.NextFriend.$assign(data().FirstFriend);
    data().FirstFriend.$assign(FD);
  }

  
  /// Determines whether this record has any friends.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasFriends">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 799,
   FQN="clang::CXXRecordDecl::hasFriends", NM="_ZNK5clang13CXXRecordDecl10hasFriendsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl10hasFriendsEv")
  //</editor-fold>
  public boolean hasFriends() /*const*/ {
    return data().FirstFriend.isValid();
  }

  
  /// \brief \c true if we know for sure that this class has a single,
  /// accessible, unambiguous move constructor that is not deleted.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasSimpleMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 805,
   FQN="clang::CXXRecordDecl::hasSimpleMoveConstructor", NM="_ZNK5clang13CXXRecordDecl24hasSimpleMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl24hasSimpleMoveConstructorEv")
  //</editor-fold>
  public boolean hasSimpleMoveConstructor() /*const*/ {
    return !hasUserDeclaredMoveConstructor() && hasMoveConstructor()
       && !data().DefaultedMoveConstructorIsDeleted;
  }

  /// \brief \c true if we know for sure that this class has a single,
  /// accessible, unambiguous move assignment operator that is not deleted.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasSimpleMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 811,
   FQN="clang::CXXRecordDecl::hasSimpleMoveAssignment", NM="_ZNK5clang13CXXRecordDecl23hasSimpleMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23hasSimpleMoveAssignmentEv")
  //</editor-fold>
  public boolean hasSimpleMoveAssignment() /*const*/ {
    return !hasUserDeclaredMoveAssignment() && hasMoveAssignment()
       && !data().DefaultedMoveAssignmentIsDeleted;
  }

  /// \brief \c true if we know for sure that this class has an accessible
  /// destructor that is not deleted.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasSimpleDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 817,
   FQN="clang::CXXRecordDecl::hasSimpleDestructor", NM="_ZNK5clang13CXXRecordDecl19hasSimpleDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl19hasSimpleDestructorEv")
  //</editor-fold>
  public boolean hasSimpleDestructor() /*const*/ {
    return !hasUserDeclaredDestructor()
       && !data().DefaultedDestructorIsDeleted;
  }

  
  /// \brief Determine whether this class has any default constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 823,
   FQN="clang::CXXRecordDecl::hasDefaultConstructor", NM="_ZNK5clang13CXXRecordDecl21hasDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl21hasDefaultConstructorEv")
  //</editor-fold>
  public boolean hasDefaultConstructor() /*const*/ {
    return ((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_DefaultConstructor)) != 0)
       || needsImplicitDefaultConstructor();
  }

  
  /// \brief Determine if we need to declare a default constructor for
  /// this class.
  ///
  /// This value is used for lazy creation of default constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsImplicitDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 832,
   FQN="clang::CXXRecordDecl::needsImplicitDefaultConstructor", NM="_ZNK5clang13CXXRecordDecl31needsImplicitDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl31needsImplicitDefaultConstructorEv")
  //</editor-fold>
  public boolean needsImplicitDefaultConstructor() /*const*/ {
    return !data().UserDeclaredConstructor
       && !((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_DefaultConstructor)) != 0)
      // C++14 [expr.prim.lambda]p20:
      //   The closure type associated with a lambda-expression has no
      //   default constructor.
       && !isLambda();
  }

  
  /// \brief Determine whether this class has any user-declared constructors.
  ///
  /// When true, a default constructor will not be implicitly declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 844,
   FQN="clang::CXXRecordDecl::hasUserDeclaredConstructor", NM="_ZNK5clang13CXXRecordDecl26hasUserDeclaredConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl26hasUserDeclaredConstructorEv")
  //</editor-fold>
  public boolean hasUserDeclaredConstructor() /*const*/ {
    return data().UserDeclaredConstructor;
  }

  
  /// \brief Whether this class has a user-provided default constructor
  /// per C++11.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserProvidedDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 850,
   FQN="clang::CXXRecordDecl::hasUserProvidedDefaultConstructor", NM="_ZNK5clang13CXXRecordDecl33hasUserProvidedDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl33hasUserProvidedDefaultConstructorEv")
  //</editor-fold>
  public boolean hasUserProvidedDefaultConstructor() /*const*/ {
    return data().UserProvidedDefaultConstructor;
  }

  
  /// \brief Determine whether this class has a user-declared copy constructor.
  ///
  /// When false, a copy constructor will be implicitly declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 857,
   FQN="clang::CXXRecordDecl::hasUserDeclaredCopyConstructor", NM="_ZNK5clang13CXXRecordDecl30hasUserDeclaredCopyConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl30hasUserDeclaredCopyConstructorEv")
  //</editor-fold>
  public boolean hasUserDeclaredCopyConstructor() /*const*/ {
    return ((data().UserDeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyConstructor)) != 0);
  }

  
  /// \brief Determine whether this class needs an implicit copy
  /// constructor to be lazily declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsImplicitCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 863,
   FQN="clang::CXXRecordDecl::needsImplicitCopyConstructor", NM="_ZNK5clang13CXXRecordDecl28needsImplicitCopyConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl28needsImplicitCopyConstructorEv")
  //</editor-fold>
  public boolean needsImplicitCopyConstructor() /*const*/ {
    return !((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyConstructor)) != 0);
  }

  
  /// \brief Determine whether we need to eagerly declare a defaulted copy
  /// constructor for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsOverloadResolutionForCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 869,
   FQN="clang::CXXRecordDecl::needsOverloadResolutionForCopyConstructor", NM="_ZNK5clang13CXXRecordDecl41needsOverloadResolutionForCopyConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl41needsOverloadResolutionForCopyConstructorEv")
  //</editor-fold>
  public boolean needsOverloadResolutionForCopyConstructor() /*const*/ {
    return data().HasMutableFields;
  }

  
  /// \brief Determine whether an implicit copy constructor for this type
  /// would have a parameter with a const-qualified reference type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::implicitCopyConstructorHasConstParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 875,
   FQN="clang::CXXRecordDecl::implicitCopyConstructorHasConstParam", NM="_ZNK5clang13CXXRecordDecl36implicitCopyConstructorHasConstParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl36implicitCopyConstructorHasConstParamEv")
  //</editor-fold>
  public boolean implicitCopyConstructorHasConstParam() /*const*/ {
    return data().ImplicitCopyConstructorHasConstParam;
  }

  
  /// \brief Determine whether this class has a copy constructor with
  /// a parameter type which is a reference to a const-qualified type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasCopyConstructorWithConstParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 881,
   FQN="clang::CXXRecordDecl::hasCopyConstructorWithConstParam", NM="_ZNK5clang13CXXRecordDecl32hasCopyConstructorWithConstParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl32hasCopyConstructorWithConstParamEv")
  //</editor-fold>
  public boolean hasCopyConstructorWithConstParam() /*const*/ {
    return data().HasDeclaredCopyConstructorWithConstParam
       || (needsImplicitCopyConstructor()
       && implicitCopyConstructorHasConstParam());
  }

  
  /// \brief Whether this class has a user-declared move constructor or
  /// assignment operator.
  ///
  /// When false, a move constructor and assignment operator may be
  /// implicitly declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredMoveOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 892,
   FQN="clang::CXXRecordDecl::hasUserDeclaredMoveOperation", NM="_ZNK5clang13CXXRecordDecl28hasUserDeclaredMoveOperationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl28hasUserDeclaredMoveOperationEv")
  //</editor-fold>
  public boolean hasUserDeclaredMoveOperation() /*const*/ {
    return ((data().UserDeclaredSpecialMembers
       & $int2uint_6bits((SpecialMemberFlags.SMF_MoveConstructor | SpecialMemberFlags.SMF_MoveAssignment))) != 0);
  }

  
  /// \brief Determine whether this class has had a move constructor
  /// declared by the user.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 899,
   FQN="clang::CXXRecordDecl::hasUserDeclaredMoveConstructor", NM="_ZNK5clang13CXXRecordDecl30hasUserDeclaredMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl30hasUserDeclaredMoveConstructorEv")
  //</editor-fold>
  public boolean hasUserDeclaredMoveConstructor() /*const*/ {
    return ((data().UserDeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveConstructor)) != 0);
  }

  
  /// \brief Determine whether this class has a move constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 904,
   FQN="clang::CXXRecordDecl::hasMoveConstructor", NM="_ZNK5clang13CXXRecordDecl18hasMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl18hasMoveConstructorEv")
  //</editor-fold>
  public boolean hasMoveConstructor() /*const*/ {
    return ((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveConstructor)) != 0)
       || needsImplicitMoveConstructor();
  }

  
  /// \brief Set that we attempted to declare an implicitly move
  /// constructor, but overload resolution failed so we deleted it.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setImplicitMoveConstructorIsDeleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 911,
   FQN="clang::CXXRecordDecl::setImplicitMoveConstructorIsDeleted", NM="_ZN5clang13CXXRecordDecl35setImplicitMoveConstructorIsDeletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl35setImplicitMoveConstructorIsDeletedEv")
  //</editor-fold>
  public void setImplicitMoveConstructorIsDeleted() {
    assert ((data().DefaultedMoveConstructorIsDeleted || needsOverloadResolutionForMoveConstructor())) : "move constructor should not be deleted";
    data().DefaultedMoveConstructorIsDeleted = true;
  }

  
  /// \brief Determine whether this class should get an implicit move
  /// constructor or if any existing special member function inhibits this.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsImplicitMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 920,
   FQN="clang::CXXRecordDecl::needsImplicitMoveConstructor", NM="_ZNK5clang13CXXRecordDecl28needsImplicitMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl28needsImplicitMoveConstructorEv")
  //</editor-fold>
  public boolean needsImplicitMoveConstructor() /*const*/ {
    return !((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveConstructor)) != 0)
       && !hasUserDeclaredCopyConstructor()
       && !hasUserDeclaredCopyAssignment()
       && !hasUserDeclaredMoveAssignment()
       && !hasUserDeclaredDestructor();
  }

  
  /// \brief Determine whether we need to eagerly declare a defaulted move
  /// constructor for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsOverloadResolutionForMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 930,
   FQN="clang::CXXRecordDecl::needsOverloadResolutionForMoveConstructor", NM="_ZNK5clang13CXXRecordDecl41needsOverloadResolutionForMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl41needsOverloadResolutionForMoveConstructorEv")
  //</editor-fold>
  public boolean needsOverloadResolutionForMoveConstructor() /*const*/ {
    return data().NeedOverloadResolutionForMoveConstructor;
  }

  
  /// \brief Determine whether this class has a user-declared copy assignment
  /// operator.
  ///
  /// When false, a copy assigment operator will be implicitly declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredCopyAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 938,
   FQN="clang::CXXRecordDecl::hasUserDeclaredCopyAssignment", NM="_ZNK5clang13CXXRecordDecl29hasUserDeclaredCopyAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl29hasUserDeclaredCopyAssignmentEv")
  //</editor-fold>
  public boolean hasUserDeclaredCopyAssignment() /*const*/ {
    return ((data().UserDeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyAssignment)) != 0);
  }

  
  /// \brief Determine whether this class needs an implicit copy
  /// assignment operator to be lazily declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsImplicitCopyAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 944,
   FQN="clang::CXXRecordDecl::needsImplicitCopyAssignment", NM="_ZNK5clang13CXXRecordDecl27needsImplicitCopyAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl27needsImplicitCopyAssignmentEv")
  //</editor-fold>
  public boolean needsImplicitCopyAssignment() /*const*/ {
    return !((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyAssignment)) != 0);
  }

  
  /// \brief Determine whether we need to eagerly declare a defaulted copy
  /// assignment operator for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsOverloadResolutionForCopyAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 950,
   FQN="clang::CXXRecordDecl::needsOverloadResolutionForCopyAssignment", NM="_ZNK5clang13CXXRecordDecl40needsOverloadResolutionForCopyAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl40needsOverloadResolutionForCopyAssignmentEv")
  //</editor-fold>
  public boolean needsOverloadResolutionForCopyAssignment() /*const*/ {
    return data().HasMutableFields;
  }

  
  /// \brief Determine whether an implicit copy assignment operator for this
  /// type would have a parameter with a const-qualified reference type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::implicitCopyAssignmentHasConstParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 956,
   FQN="clang::CXXRecordDecl::implicitCopyAssignmentHasConstParam", NM="_ZNK5clang13CXXRecordDecl35implicitCopyAssignmentHasConstParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl35implicitCopyAssignmentHasConstParamEv")
  //</editor-fold>
  public boolean implicitCopyAssignmentHasConstParam() /*const*/ {
    return data().ImplicitCopyAssignmentHasConstParam;
  }

  
  /// \brief Determine whether this class has a copy assignment operator with
  /// a parameter type which is a reference to a const-qualified type or is not
  /// a reference.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasCopyAssignmentWithConstParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 963,
   FQN="clang::CXXRecordDecl::hasCopyAssignmentWithConstParam", NM="_ZNK5clang13CXXRecordDecl31hasCopyAssignmentWithConstParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl31hasCopyAssignmentWithConstParamEv")
  //</editor-fold>
  public boolean hasCopyAssignmentWithConstParam() /*const*/ {
    return data().HasDeclaredCopyAssignmentWithConstParam
       || (needsImplicitCopyAssignment()
       && implicitCopyAssignmentHasConstParam());
  }

  
  /// \brief Determine whether this class has had a move assignment
  /// declared by the user.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 971,
   FQN="clang::CXXRecordDecl::hasUserDeclaredMoveAssignment", NM="_ZNK5clang13CXXRecordDecl29hasUserDeclaredMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl29hasUserDeclaredMoveAssignmentEv")
  //</editor-fold>
  public boolean hasUserDeclaredMoveAssignment() /*const*/ {
    return ((data().UserDeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveAssignment)) != 0);
  }

  
  /// \brief Determine whether this class has a move assignment operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 976,
   FQN="clang::CXXRecordDecl::hasMoveAssignment", NM="_ZNK5clang13CXXRecordDecl17hasMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl17hasMoveAssignmentEv")
  //</editor-fold>
  public boolean hasMoveAssignment() /*const*/ {
    return ((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveAssignment)) != 0)
       || needsImplicitMoveAssignment();
  }

  
  /// \brief Set that we attempted to declare an implicit move assignment
  /// operator, but overload resolution failed so we deleted it.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setImplicitMoveAssignmentIsDeleted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 983,
   FQN="clang::CXXRecordDecl::setImplicitMoveAssignmentIsDeleted", NM="_ZN5clang13CXXRecordDecl34setImplicitMoveAssignmentIsDeletedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl34setImplicitMoveAssignmentIsDeletedEv")
  //</editor-fold>
  public void setImplicitMoveAssignmentIsDeleted() {
    assert ((data().DefaultedMoveAssignmentIsDeleted || needsOverloadResolutionForMoveAssignment())) : "move assignment should not be deleted";
    data().DefaultedMoveAssignmentIsDeleted = true;
  }

  
  /// \brief Determine whether this class should get an implicit move
  /// assignment operator or if any existing special member function inhibits
  /// this.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsImplicitMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 993,
   FQN="clang::CXXRecordDecl::needsImplicitMoveAssignment", NM="_ZNK5clang13CXXRecordDecl27needsImplicitMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl27needsImplicitMoveAssignmentEv")
  //</editor-fold>
  public boolean needsImplicitMoveAssignment() /*const*/ {
    return !((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveAssignment)) != 0)
       && !hasUserDeclaredCopyConstructor()
       && !hasUserDeclaredCopyAssignment()
       && !hasUserDeclaredMoveConstructor()
       && !hasUserDeclaredDestructor();
  }

  
  /// \brief Determine whether we need to eagerly declare a move assignment
  /// operator for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsOverloadResolutionForMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1003,
   FQN="clang::CXXRecordDecl::needsOverloadResolutionForMoveAssignment", NM="_ZNK5clang13CXXRecordDecl40needsOverloadResolutionForMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl40needsOverloadResolutionForMoveAssignmentEv")
  //</editor-fold>
  public boolean needsOverloadResolutionForMoveAssignment() /*const*/ {
    return data().NeedOverloadResolutionForMoveAssignment;
  }

  
  /// \brief Determine whether this class has a user-declared destructor.
  ///
  /// When false, a destructor will be implicitly declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUserDeclaredDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1010,
   FQN="clang::CXXRecordDecl::hasUserDeclaredDestructor", NM="_ZNK5clang13CXXRecordDecl25hasUserDeclaredDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl25hasUserDeclaredDestructorEv")
  //</editor-fold>
  public boolean hasUserDeclaredDestructor() /*const*/ {
    return ((data().UserDeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_Destructor)) != 0);
  }

  
  /// \brief Determine whether this class needs an implicit destructor to
  /// be lazily declared.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsImplicitDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1016,
   FQN="clang::CXXRecordDecl::needsImplicitDestructor", NM="_ZNK5clang13CXXRecordDecl23needsImplicitDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23needsImplicitDestructorEv")
  //</editor-fold>
  public boolean needsImplicitDestructor() /*const*/ {
    return !((data().DeclaredSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_Destructor)) != 0);
  }

  
  /// \brief Determine whether we need to eagerly declare a destructor for this
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::needsOverloadResolutionForDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1022,
   FQN="clang::CXXRecordDecl::needsOverloadResolutionForDestructor", NM="_ZNK5clang13CXXRecordDecl36needsOverloadResolutionForDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl36needsOverloadResolutionForDestructorEv")
  //</editor-fold>
  public boolean needsOverloadResolutionForDestructor() /*const*/ {
    return data().NeedOverloadResolutionForDestructor;
  }

  
  /// \brief Determine whether this class describes a lambda function object.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1027,
   FQN="clang::CXXRecordDecl::isLambda", NM="_ZNK5clang13CXXRecordDecl8isLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl8isLambdaEv")
  //</editor-fold>
  public boolean isLambda() /*const*/ {
    // An update record can't turn a non-lambda into a lambda.
    DefinitionData /*P*/ DD = DefinitionData;
    return (DD != null) && DD.IsLambda;
  }

  
  /// \brief Determine whether this class describes a generic 
  /// lambda function object (i.e. function call operator is
  /// a template). 
  
  /// \brief Determine whether this class describes a generic 
  /// lambda function object (i.e. function call operator is
  /// a template). 
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isGenericLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1046,
   FQN="clang::CXXRecordDecl::isGenericLambda", NM="_ZNK5clang13CXXRecordDecl15isGenericLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl15isGenericLambdaEv")
  //</editor-fold>
  public boolean isGenericLambda() /*const*/ {
    if (!isLambda()) {
      return false;
    }
    return getLambdaData().IsGenericLambda;
  }


  
  /// \brief Retrieve the lambda call operator of the closure type
  /// if this is a closure type.
  
  /// \brief Retrieve the lambda call operator of the closure type
  /// if this is a closure type.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaCallOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1051,
   FQN="clang::CXXRecordDecl::getLambdaCallOperator", NM="_ZNK5clang13CXXRecordDecl21getLambdaCallOperatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl21getLambdaCallOperatorEv")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getLambdaCallOperator() /*const*/ {
    if (!isLambda()) {
      return null;
    }
    DeclarationName Name = getASTContext().DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Call);
    DeclContextLookupResult Calls = lookup(new DeclarationName(Name));
    assert (!Calls.empty()) : "Missing lambda call operator!";
    assert (Calls.size() == 1) : "More than one lambda call operator!";
    
    NamedDecl /*P*/ CallOp = Calls.front();
    {
      FunctionTemplateDecl /*P*/ CallOpTmpl = dyn_cast_FunctionTemplateDecl(CallOp);
      if ((CallOpTmpl != null)) {
        return cast_CXXMethodDecl(CallOpTmpl.getTemplatedDecl());
      }
    }
    
    return cast_CXXMethodDecl(CallOp);
  }


  
  /// \brief Retrieve the lambda static invoker, the address of which
  /// is returned by the conversion operator, and the body of which
  /// is forwarded to the lambda call operator. 
  
  /// \brief Retrieve the lambda static invoker, the address of which
  /// is returned by the conversion operator, and the body of which
  /// is forwarded to the lambda call operator. 
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaStaticInvoker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1068,
   FQN="clang::CXXRecordDecl::getLambdaStaticInvoker", NM="_ZNK5clang13CXXRecordDecl22getLambdaStaticInvokerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl22getLambdaStaticInvokerEv")
  //</editor-fold>
  public CXXMethodDecl /*P*/ getLambdaStaticInvoker() /*const*/ {
    if (!isLambda()) {
      return null;
    }
    DeclarationName Name = new DeclarationName($AddrOf(getASTContext().Idents.get(getLambdaStaticInvokerName())));
    DeclContextLookupResult Invoker = lookup(new DeclarationName(Name));
    if (Invoker.empty()) {
      return null;
    }
    assert (Invoker.size() == 1) : "More than one static invoker operator!";
    NamedDecl /*P*/ InvokerFun = Invoker.front();
    {
      FunctionTemplateDecl /*P*/ InvokerTemplate = dyn_cast_FunctionTemplateDecl(InvokerFun);
      if ((InvokerTemplate != null)) {
        return cast_CXXMethodDecl(InvokerTemplate.getTemplatedDecl());
      }
    }
    
    return cast_CXXMethodDecl(InvokerFun);
  }


  
  /// \brief Retrieve the generic lambda's template parameter list.
  /// Returns null if the class does not represent a lambda or a generic 
  /// lambda.
  
  /// \brief Retrieve the generic lambda's template parameter list.
  /// Returns null if the class does not represent a lambda or a generic 
  /// lambda.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getGenericLambdaTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1101,
   FQN="clang::CXXRecordDecl::getGenericLambdaTemplateParameterList", NM="_ZNK5clang13CXXRecordDecl37getGenericLambdaTemplateParameterListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl37getGenericLambdaTemplateParameterListEv")
  //</editor-fold>
  public TemplateParameterList /*P*/ getGenericLambdaTemplateParameterList() /*const*/ {
    if (!isLambda()) {
      return null;
    }
    CXXMethodDecl /*P*/ CallOp = getLambdaCallOperator();
    {
      FunctionTemplateDecl /*P*/ Tmpl = CallOp.getDescribedFunctionTemplate();
      if ((Tmpl != null)) {
        return Tmpl.getTemplateParameters();
      }
    }
    return null;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaCaptureDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1052,
   FQN="clang::CXXRecordDecl::getLambdaCaptureDefault", NM="_ZNK5clang13CXXRecordDecl23getLambdaCaptureDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23getLambdaCaptureDefaultEv")
  //</editor-fold>
  public LambdaCaptureDefault getLambdaCaptureDefault() /*const*/ {
    assert (isLambda());
    return /*static_cast*/LambdaCaptureDefault.valueOf(getLambdaData().CaptureDefault);
  }

  
  /// \brief For a closure type, retrieve the mapping from captured
  /// variables and \c this to the non-static data members that store the
  /// values or references of the captures.
  ///
  /// \param Captures Will be populated with the mapping from captured
  /// variables to the corresponding fields.
  ///
  /// \param ThisCapture Will be set to the field declaration for the
  /// \c this capture.
  ///
  /// \note No entries will be added for init-captures, as they do not capture
  /// variables.
  
  /// \brief For a closure type, retrieve the mapping from captured
  /// variables and \c this to the non-static data members that store the
  /// values or references of the captures.
  ///
  /// \param Captures Will be populated with the mapping from captured
  /// variables to the corresponding fields.
  ///
  /// \param ThisCapture Will be set to the field declaration for the
  /// \c this capture.
  ///
  /// \note No entries will be added for init-captures, as they do not capture
  /// variables.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getCaptureFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1083,
   FQN="clang::CXXRecordDecl::getCaptureFields", NM="_ZNK5clang13CXXRecordDecl16getCaptureFieldsERN4llvm8DenseMapIPKNS_7VarDeclEPNS_9FieldDeclENS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_S7_EEEERS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl16getCaptureFieldsERN4llvm8DenseMapIPKNS_7VarDeclEPNS_9FieldDeclENS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_S7_EEEERS7_")
  //</editor-fold>
  public void getCaptureFields(final DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ > /*&*/ Captures, 
                final type$ref<FieldDecl /*P*/ /*&*/> ThisCapture) /*const*/ {
  Captures.clear();
  ThisCapture.$set(null);
  
  final LambdaDefinitionData /*&*/ Lambda = getLambdaData();
  specific_decl_iterator<FieldDecl> Field = field_begin();
    for (type$ptr</*const*/ LambdaCapture /*P*/> C = $tryClone(Lambda.Captures), /*P*/ CEnd = C.$add(Lambda.NumCaptures);
         C.$noteq(CEnd); C.$preInc() , Field.$preInc()) {
      if (C.$star().capturesThis()) {
      ThisCapture.$set(Field.$star());
      } else if (C.$star().capturesVariable()) {
        Captures.$set(C.$star().getCapturedVar(), Field.$star());
    }
  }
    assert ($eq_specific_decl_iterator$SpecificDecl$C(Field, field_end()));
}


  
  /*typedef const LambdaCapture *capture_const_iterator*/
//  public final class capture_const_iterator extends /*const*/ LambdaCapture /*P*/ { };
  /*typedef llvm::iterator_range<capture_const_iterator> capture_const_range*/
//  public final class capture_const_range extends iterator_range</*const*/ LambdaCapture>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::captures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1075,
   FQN="clang::CXXRecordDecl::captures", NM="_ZNK5clang13CXXRecordDecl8capturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl8capturesEv")
  //</editor-fold>
  public iterator_range</*const*/ LambdaCapture> captures() /*const*/ {
    return new iterator_range</*const*/ LambdaCapture>(captures_begin(), captures_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::captures_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1078,
   FQN="clang::CXXRecordDecl::captures_begin", NM="_ZNK5clang13CXXRecordDecl14captures_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14captures_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ LambdaCapture /*P*/ > captures_begin() /*const*/ {
    return isLambda() ? getLambdaData().Captures : null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::captures_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1081,
   FQN="clang::CXXRecordDecl::captures_end", NM="_ZNK5clang13CXXRecordDecl12captures_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl12captures_endEv")
  //</editor-fold>
  public type$ptr</*const*/ LambdaCapture /*P*/ > captures_end() /*const*/ {
    return isLambda() ? captures_begin().$add(getLambdaData().NumCaptures) : null;
  }

  
  /*typedef UnresolvedSetIterator conversion_iterator*/
//  public final class conversion_iterator extends UnresolvedSetIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::conversion_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1087,
   FQN="clang::CXXRecordDecl::conversion_begin", NM="_ZNK5clang13CXXRecordDecl16conversion_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl16conversion_beginEv")
  //</editor-fold>
  public UnresolvedSetIterator conversion_begin() /*const*/ {
    return data().Conversions.get(getASTContext()).begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::conversion_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1090,
   FQN="clang::CXXRecordDecl::conversion_end", NM="_ZNK5clang13CXXRecordDecl14conversion_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl14conversion_endEv")
  //</editor-fold>
  public UnresolvedSetIterator conversion_end() /*const*/ {
    return data().Conversions.get(getASTContext()).end();
  }

  
  /// Removes a conversion function from this class.  The conversion
  /// function must currently be a member of this class.  Furthermore,
  /// this class must currently be in the process of being defined.
  
  /// Removes a conversion function from this class.  The conversion
  /// function must currently be a member of this class.  Furthermore,
  /// this class must currently be in the process of being defined.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::removeConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1256,
   FQN="clang::CXXRecordDecl::removeConversion", NM="_ZN5clang13CXXRecordDecl16removeConversionEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl16removeConversionEPKNS_9NamedDeclE")
  //</editor-fold>
  public void removeConversion(/*const*/ NamedDecl /*P*/ ConvDecl) {
    // This operation is O(N) but extremely rare.  Sema only uses it to
    // remove UsingShadowDecls in a class that were followed by a direct
    // declaration, e.g.:
    //   class A : B {
    //     using B::operator int;
    //     operator int();
    //   };
    // This is uncommon by itself and even more uncommon in conjunction
    // with sufficiently large numbers of directly-declared conversions
    // that asymptotic behavior matters.
    final ASTUnresolvedSet /*&*/ Convs = data().Conversions.get(getASTContext());
    for (/*uint*/int I = 0, E = Convs.size(); I != E; ++I) {
      if (Convs.$at(I).getDecl() == ConvDecl) {
        Convs.erase(I);
        assert (std.find(Convs.begin(), Convs.end(), ConvDecl, true).$eq(Convs.end())) : "conversion was found multiple times in unresolved set";
        return;
      }
    }
    throw new llvm_unreachable("conversion not found in set!");
  }


  
  /// \brief Get all conversion functions visible in current class,
  /// including conversion function templates.
  
  /// \brief Get all conversion functions visible in current class,
  /// including conversion function templates.
  
  /// getVisibleConversionFunctions - get all conversion functions visible
  /// in current class; including conversion function templates.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getVisibleConversionFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1237,
   FQN="clang::CXXRecordDecl::getVisibleConversionFunctions", NM="_ZN5clang13CXXRecordDecl29getVisibleConversionFunctionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl29getVisibleConversionFunctionsEv")
  //</editor-fold>
  public iterator_range<NamedDecl /*P*/ > getVisibleConversionFunctions() {
    final ASTContext /*&*/ Ctx = getASTContext();
    
    ASTUnresolvedSet /*P*/ Set;
    if ($eq_ptr(bases_begin(), bases_end())) {
      // If root class, all conversions are visible.
      Set = $AddrOf(data().Conversions.get(Ctx));
    } else {
      Set = $AddrOf(data().VisibleConversions.get(Ctx));
      // If visible conversion list is not evaluated, evaluate it.
      if (!data().ComputedVisibleConversions) {
        CollectVisibleConversions(Ctx, this, $Deref(Set));
        data().ComputedVisibleConversions = true;
      }
    }
    return llvm.make_range(Set.begin(), Set.end());
  }


  
  /// Determine whether this class is an aggregate (C++ [dcl.init.aggr]),
  /// which is a class with no user-declared constructors, no private
  /// or protected non-static data members, no base classes, and no virtual
  /// functions (C++ [dcl.init.aggr]p1).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isAggregate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1107,
   FQN="clang::CXXRecordDecl::isAggregate", NM="_ZNK5clang13CXXRecordDecl11isAggregateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl11isAggregateEv")
  //</editor-fold>
  public boolean isAggregate() /*const*/ {
    return data().Aggregate;
  }

  
  /// \brief Whether this class has any in-class initializers
  /// for non-static data members (including those in anonymous unions or
  /// structs).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasInClassInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1112,
   FQN="clang::CXXRecordDecl::hasInClassInitializer", NM="_ZNK5clang13CXXRecordDecl21hasInClassInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl21hasInClassInitializerEv")
  //</editor-fold>
  public boolean hasInClassInitializer() /*const*/ {
    return data().HasInClassInitializer;
  }

  
  /// \brief Whether this class or any of its subobjects has any members of
  /// reference type which would make value-initialization ill-formed.
  ///
  /// Per C++03 [dcl.init]p5:
  ///  - if T is a non-union class type without a user-declared constructor,
  ///    then every non-static data member and base-class component of T is
  ///    value-initialized [...] A program that calls for [...]
  ///    value-initialization of an entity of reference type is ill-formed.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasUninitializedReferenceMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1122,
   FQN="clang::CXXRecordDecl::hasUninitializedReferenceMember", NM="_ZNK5clang13CXXRecordDecl31hasUninitializedReferenceMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl31hasUninitializedReferenceMemberEv")
  //</editor-fold>
  public boolean hasUninitializedReferenceMember() /*const*/ {
    return !isUnion() && !hasUserDeclaredConstructor()
       && data().HasUninitializedReferenceMember;
  }

  
  /// \brief Whether this class is a POD-type (C++ [class]p4)
  ///
  /// For purposes of this function a class is POD if it is an aggregate
  /// that has no non-static non-POD data members, no reference data
  /// members, no user-defined copy assignment operator and no
  /// user-defined destructor.
  ///
  /// Note that this is the C++ TR1 definition of POD.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isPOD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1135,
   FQN="clang::CXXRecordDecl::isPOD", NM="_ZNK5clang13CXXRecordDecl5isPODEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl5isPODEv")
  //</editor-fold>
  public boolean isPOD() /*const*/ {
    return data().PlainOldData;
  }

  
  /// \brief True if this class is C-like, without C++-specific features, e.g.
  /// it contains only public fields, no bases, tag kind is not 'class', etc.
  
  /// \brief True if this class is C-like, without C++-specific features, e.g.
  /// it contains only public fields, no bases, tag kind is not 'class', etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isCLike">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1036,
   FQN="clang::CXXRecordDecl::isCLike", NM="_ZNK5clang13CXXRecordDecl7isCLikeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl7isCLikeEv")
  //</editor-fold>
  public boolean isCLike() /*const*/ {
    if (getTagKind() == TagTypeKind.TTK_Class || getTagKind() == TagTypeKind.TTK_Interface
       || !TemplateOrInstantiation.isNull()) {
      return false;
    }
    if (!hasDefinition()) {
      return true;
    }
    
    return isPOD() && data().HasOnlyCMembers;
  }


  
  /// \brief Determine whether this is an empty class in the sense of
  /// (C++11 [meta.unary.prop]).
  ///
  /// The CXXRecordDecl is a class type, but not a union type,
  /// with no non-static data members other than bit-fields of length 0,
  /// no virtual member functions, no virtual base classes,
  /// and no base class B for which is_empty<B>::value is false.
  ///
  /// \note This does NOT include a check for union-ness.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1150,
   FQN="clang::CXXRecordDecl::isEmpty", NM="_ZNK5clang13CXXRecordDecl7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return data().Empty;
  }

  
  /// Whether this class is polymorphic (C++ [class.virtual]),
  /// which means that the class contains or inherits a virtual function.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isPolymorphic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1154,
   FQN="clang::CXXRecordDecl::isPolymorphic", NM="_ZNK5clang13CXXRecordDecl13isPolymorphicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl13isPolymorphicEv")
  //</editor-fold>
  public boolean isPolymorphic() /*const*/ {
    return data().Polymorphic;
  }

  
  /// \brief Determine whether this class has a pure virtual function.
  ///
  /// The class is is abstract per (C++ [class.abstract]p2) if it declares
  /// a pure virtual function or inherits a pure virtual function that is
  /// not overridden.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isAbstract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1161,
   FQN="clang::CXXRecordDecl::isAbstract", NM="_ZNK5clang13CXXRecordDecl10isAbstractEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl10isAbstractEv")
  //</editor-fold>
  public boolean isAbstract() /*const*/ {
    return data().Abstract;
  }

  
  /// \brief Determine whether this class has standard layout per 
  /// (C++ [class]p7)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isStandardLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1165,
   FQN="clang::CXXRecordDecl::isStandardLayout", NM="_ZNK5clang13CXXRecordDecl16isStandardLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl16isStandardLayoutEv")
  //</editor-fold>
  public boolean isStandardLayout() /*const*/ {
    return data().IsStandardLayout;
  }

  
  /// \brief Determine whether this class, or any of its class subobjects,
  /// contains a mutable field.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasMutableFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1169,
   FQN="clang::CXXRecordDecl::hasMutableFields", NM="_ZNK5clang13CXXRecordDecl16hasMutableFieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl16hasMutableFieldsEv")
  //</editor-fold>
  public boolean hasMutableFields() /*const*/ {
    return data().HasMutableFields;
  }

  
  /// \brief Determine whether this class has any variant members.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasVariantMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1172,
   FQN="clang::CXXRecordDecl::hasVariantMembers", NM="_ZNK5clang13CXXRecordDecl17hasVariantMembersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl17hasVariantMembersEv")
  //</editor-fold>
  public boolean hasVariantMembers() /*const*/ {
    return data().HasVariantMembers;
  }

  
  /// \brief Determine whether this class has a trivial default constructor
  /// (C++11 [class.ctor]p5).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasTrivialDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1176,
   FQN="clang::CXXRecordDecl::hasTrivialDefaultConstructor", NM="_ZNK5clang13CXXRecordDecl28hasTrivialDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl28hasTrivialDefaultConstructorEv")
  //</editor-fold>
  public boolean hasTrivialDefaultConstructor() /*const*/ {
    return hasDefaultConstructor()
       && ((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_DefaultConstructor)) != 0);
  }

  
  /// \brief Determine whether this class has a non-trivial default constructor
  /// (C++11 [class.ctor]p5).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonTrivialDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1183,
   FQN="clang::CXXRecordDecl::hasNonTrivialDefaultConstructor", NM="_ZNK5clang13CXXRecordDecl31hasNonTrivialDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl31hasNonTrivialDefaultConstructorEv")
  //</editor-fold>
  public boolean hasNonTrivialDefaultConstructor() /*const*/ {
    return ((data().DeclaredNonTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_DefaultConstructor)) != 0)
       || (needsImplicitDefaultConstructor()
       && !((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_DefaultConstructor)) != 0));
  }

  
  /// \brief Determine whether this class has at least one constexpr constructor
  /// other than the copy or move constructors.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasConstexprNonCopyMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1191,
   FQN="clang::CXXRecordDecl::hasConstexprNonCopyMoveConstructor", NM="_ZNK5clang13CXXRecordDecl34hasConstexprNonCopyMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl34hasConstexprNonCopyMoveConstructorEv")
  //</editor-fold>
  public boolean hasConstexprNonCopyMoveConstructor() /*const*/ {
    return data().HasConstexprNonCopyMoveConstructor
       || (needsImplicitDefaultConstructor()
       && defaultedDefaultConstructorIsConstexpr());
  }

  
  /// \brief Determine whether a defaulted default constructor for this class
  /// would be constexpr.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::defaultedDefaultConstructorIsConstexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1199,
   FQN="clang::CXXRecordDecl::defaultedDefaultConstructorIsConstexpr", NM="_ZNK5clang13CXXRecordDecl38defaultedDefaultConstructorIsConstexprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl38defaultedDefaultConstructorIsConstexprEv")
  //</editor-fold>
  public boolean defaultedDefaultConstructorIsConstexpr() /*const*/ {
    return data().DefaultedDefaultConstructorIsConstexpr
       && (!isUnion() || hasInClassInitializer() || !hasVariantMembers());
  }

  
  /// \brief Determine whether this class has a constexpr default constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasConstexprDefaultConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1205,
   FQN="clang::CXXRecordDecl::hasConstexprDefaultConstructor", NM="_ZNK5clang13CXXRecordDecl30hasConstexprDefaultConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl30hasConstexprDefaultConstructorEv")
  //</editor-fold>
  public boolean hasConstexprDefaultConstructor() /*const*/ {
    return data().HasConstexprDefaultConstructor
       || (needsImplicitDefaultConstructor()
       && defaultedDefaultConstructorIsConstexpr());
  }

  
  /// \brief Determine whether this class has a trivial copy constructor
  /// (C++ [class.copy]p6, C++11 [class.copy]p12)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasTrivialCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1213,
   FQN="clang::CXXRecordDecl::hasTrivialCopyConstructor", NM="_ZNK5clang13CXXRecordDecl25hasTrivialCopyConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl25hasTrivialCopyConstructorEv")
  //</editor-fold>
  public boolean hasTrivialCopyConstructor() /*const*/ {
    return ((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyConstructor)) != 0);
  }

  
  /// \brief Determine whether this class has a non-trivial copy constructor
  /// (C++ [class.copy]p6, C++11 [class.copy]p12)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonTrivialCopyConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1219,
   FQN="clang::CXXRecordDecl::hasNonTrivialCopyConstructor", NM="_ZNK5clang13CXXRecordDecl28hasNonTrivialCopyConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl28hasNonTrivialCopyConstructorEv")
  //</editor-fold>
  public boolean hasNonTrivialCopyConstructor() /*const*/ {
    return ((data().DeclaredNonTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyConstructor)) != 0)
       || !hasTrivialCopyConstructor();
  }

  
  /// \brief Determine whether this class has a trivial move constructor
  /// (C++11 [class.copy]p12)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasTrivialMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1226,
   FQN="clang::CXXRecordDecl::hasTrivialMoveConstructor", NM="_ZNK5clang13CXXRecordDecl25hasTrivialMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl25hasTrivialMoveConstructorEv")
  //</editor-fold>
  public boolean hasTrivialMoveConstructor() /*const*/ {
    return hasMoveConstructor()
       && ((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveConstructor)) != 0);
  }

  
  /// \brief Determine whether this class has a non-trivial move constructor
  /// (C++11 [class.copy]p12)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonTrivialMoveConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1233,
   FQN="clang::CXXRecordDecl::hasNonTrivialMoveConstructor", NM="_ZNK5clang13CXXRecordDecl28hasNonTrivialMoveConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl28hasNonTrivialMoveConstructorEv")
  //</editor-fold>
  public boolean hasNonTrivialMoveConstructor() /*const*/ {
    return ((data().DeclaredNonTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveConstructor)) != 0)
       || (needsImplicitMoveConstructor()
       && !((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveConstructor)) != 0));
  }

  
  /// \brief Determine whether this class has a trivial copy assignment operator
  /// (C++ [class.copy]p11, C++11 [class.copy]p25)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasTrivialCopyAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1241,
   FQN="clang::CXXRecordDecl::hasTrivialCopyAssignment", NM="_ZNK5clang13CXXRecordDecl24hasTrivialCopyAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl24hasTrivialCopyAssignmentEv")
  //</editor-fold>
  public boolean hasTrivialCopyAssignment() /*const*/ {
    return ((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyAssignment)) != 0);
  }

  
  /// \brief Determine whether this class has a non-trivial copy assignment
  /// operator (C++ [class.copy]p11, C++11 [class.copy]p25)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonTrivialCopyAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1247,
   FQN="clang::CXXRecordDecl::hasNonTrivialCopyAssignment", NM="_ZNK5clang13CXXRecordDecl27hasNonTrivialCopyAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl27hasNonTrivialCopyAssignmentEv")
  //</editor-fold>
  public boolean hasNonTrivialCopyAssignment() /*const*/ {
    return ((data().DeclaredNonTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_CopyAssignment)) != 0)
       || !hasTrivialCopyAssignment();
  }

  
  /// \brief Determine whether this class has a trivial move assignment operator
  /// (C++11 [class.copy]p25)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasTrivialMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1254,
   FQN="clang::CXXRecordDecl::hasTrivialMoveAssignment", NM="_ZNK5clang13CXXRecordDecl24hasTrivialMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl24hasTrivialMoveAssignmentEv")
  //</editor-fold>
  public boolean hasTrivialMoveAssignment() /*const*/ {
    return hasMoveAssignment()
       && ((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveAssignment)) != 0);
  }

  
  /// \brief Determine whether this class has a non-trivial move assignment
  /// operator (C++11 [class.copy]p25)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonTrivialMoveAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1261,
   FQN="clang::CXXRecordDecl::hasNonTrivialMoveAssignment", NM="_ZNK5clang13CXXRecordDecl27hasNonTrivialMoveAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl27hasNonTrivialMoveAssignmentEv")
  //</editor-fold>
  public boolean hasNonTrivialMoveAssignment() /*const*/ {
    return ((data().DeclaredNonTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveAssignment)) != 0)
       || (needsImplicitMoveAssignment()
       && !((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_MoveAssignment)) != 0));
  }

  
  /// \brief Determine whether this class has a trivial destructor
  /// (C++ [class.dtor]p3)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasTrivialDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1269,
   FQN="clang::CXXRecordDecl::hasTrivialDestructor", NM="_ZNK5clang13CXXRecordDecl20hasTrivialDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl20hasTrivialDestructorEv")
  //</editor-fold>
  public boolean hasTrivialDestructor() /*const*/ {
    return ((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_Destructor)) != 0);
  }

  
  /// \brief Determine whether this class has a non-trivial destructor
  /// (C++ [class.dtor]p3)
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonTrivialDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1275,
   FQN="clang::CXXRecordDecl::hasNonTrivialDestructor", NM="_ZNK5clang13CXXRecordDecl23hasNonTrivialDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23hasNonTrivialDestructorEv")
  //</editor-fold>
  public boolean hasNonTrivialDestructor() /*const*/ {
    return !((data().HasTrivialSpecialMembers & $int2uint_6bits(SpecialMemberFlags.SMF_Destructor)) != 0);
  }

  
  /// \brief Determine whether declaring a const variable with this type is ok
  /// per core issue 253.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::allowConstDefaultInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1281,
   FQN="clang::CXXRecordDecl::allowConstDefaultInit", NM="_ZNK5clang13CXXRecordDecl21allowConstDefaultInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl21allowConstDefaultInitEv")
  //</editor-fold>
  public boolean allowConstDefaultInit() /*const*/ {
    return !data().HasUninitializedFields
       || !(data().HasDefaultedDefaultConstructor
       || needsImplicitDefaultConstructor());
  }

  
  /// \brief Determine whether this class has a destructor which has no
  /// semantic effect.
  ///
  /// Any such destructor will be trivial, public, defaulted and not deleted,
  /// and will call only irrelevant destructors.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasIrrelevantDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1292,
   FQN="clang::CXXRecordDecl::hasIrrelevantDestructor", NM="_ZNK5clang13CXXRecordDecl23hasIrrelevantDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23hasIrrelevantDestructorEv")
  //</editor-fold>
  public boolean hasIrrelevantDestructor() /*const*/ {
    return data().HasIrrelevantDestructor;
  }

  
  /// \brief Determine whether this class has a non-literal or/ volatile type
  /// non-static data member or base class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasNonLiteralTypeFieldsOrBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1298,
   FQN="clang::CXXRecordDecl::hasNonLiteralTypeFieldsOrBases", NM="_ZNK5clang13CXXRecordDecl30hasNonLiteralTypeFieldsOrBasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl30hasNonLiteralTypeFieldsOrBasesEv")
  //</editor-fold>
  public boolean hasNonLiteralTypeFieldsOrBases() /*const*/ {
    return data().HasNonLiteralTypeFieldsOrBases;
  }

  
  /// \brief Determine whether this class has a using-declaration that names
  /// a user-declared base class constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasInheritedConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1304,
   FQN="clang::CXXRecordDecl::hasInheritedConstructor", NM="_ZNK5clang13CXXRecordDecl23hasInheritedConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23hasInheritedConstructorEv")
  //</editor-fold>
  public boolean hasInheritedConstructor() /*const*/ {
    return data().HasInheritedConstructor;
  }

  
  /// \brief Determine whether this class has a using-declaration that names
  /// a base class assignment operator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::hasInheritedAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1310,
   FQN="clang::CXXRecordDecl::hasInheritedAssignment", NM="_ZNK5clang13CXXRecordDecl22hasInheritedAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl22hasInheritedAssignmentEv")
  //</editor-fold>
  public boolean hasInheritedAssignment() /*const*/ {
    return data().HasInheritedAssignment;
  }

  
  /// \brief Determine whether this class is considered trivially copyable per
  /// (C++11 [class]p6).
  
  /// \brief Determine whether this class is considered trivially copyable per
  /// (C++11 [class]p6).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isTriviallyCopyable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 413,
   FQN="clang::CXXRecordDecl::isTriviallyCopyable", NM="_ZNK5clang13CXXRecordDecl19isTriviallyCopyableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl19isTriviallyCopyableEv")
  //</editor-fold>
  public boolean isTriviallyCopyable() /*const*/ {
    // C++0x [class]p5:
    //   A trivially copyable class is a class that:
    //   -- has no non-trivial copy constructors,
    if (hasNonTrivialCopyConstructor()) {
      return false;
    }
    //   -- has no non-trivial move constructors,
    if (hasNonTrivialMoveConstructor()) {
      return false;
    }
    //   -- has no non-trivial copy assignment operators,
    if (hasNonTrivialCopyAssignment()) {
      return false;
    }
    //   -- has no non-trivial move assignment operators, and
    if (hasNonTrivialMoveAssignment()) {
      return false;
    }
    //   -- has a trivial destructor.
    if (!hasTrivialDestructor()) {
      return false;
    }
    
    return true;
  }


  
  /// \brief Determine whether this class is considered trivial.
  ///
  /// C++11 [class]p6:
  ///    "A trivial class is a class that has a trivial default constructor and
  ///    is trivially copiable."
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isTrivial">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1323,
   FQN="clang::CXXRecordDecl::isTrivial", NM="_ZNK5clang13CXXRecordDecl9isTrivialEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl9isTrivialEv")
  //</editor-fold>
  public boolean isTrivial() /*const*/ {
    return isTriviallyCopyable() && hasTrivialDefaultConstructor();
  }

  
  /// \brief Determine whether this class is a literal type.
  ///
  /// C++11 [basic.types]p10:
  ///   A class type that has all the following properties:
  ///     - it has a trivial destructor
  ///     - every constructor call and full-expression in the
  ///       brace-or-equal-intializers for non-static data members (if any) is
  ///       a constant expression.
  ///     - it is an aggregate type or has at least one constexpr constructor
  ///       or constructor template that is not a copy or move constructor, and
  ///     - all of its non-static data members and base classes are of literal
  ///       types
  ///
  /// We resolve DR1361 by ignoring the second bullet. We resolve DR1452 by
  /// treating types with trivial default constructors as literal types.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1342,
   FQN="clang::CXXRecordDecl::isLiteral", NM="_ZNK5clang13CXXRecordDecl9isLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl9isLiteralEv")
  //</editor-fold>
  public boolean isLiteral() /*const*/ {
    return hasTrivialDestructor()
       && (isAggregate() || hasConstexprNonCopyMoveConstructor()
       || hasTrivialDefaultConstructor())
       && !hasNonLiteralTypeFieldsOrBases();
  }

  
  /// \brief If this record is an instantiation of a member class,
  /// retrieves the member class from which it was instantiated.
  ///
  /// This routine will return non-null for (non-templated) member
  /// classes of class templates. For example, given:
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   struct A { };
  /// };
  /// \endcode
  ///
  /// The declaration for X<int>::A is a (non-templated) CXXRecordDecl
  /// whose parent is the class template specialization X<int>. For
  /// this declaration, getInstantiatedFromMemberClass() will return
  /// the CXXRecordDecl X<T>::A. When a complete definition of
  /// X<int>::A is required, it will be instantiated from the
  /// declaration returned by getInstantiatedFromMemberClass().
  
  /// \brief If this record is an instantiation of a member class,
  /// retrieves the member class from which it was instantiated.
  ///
  /// This routine will return non-null for (non-templated) member
  /// classes of class templates. For example, given:
  ///
  /// \code
  /// template<typename T>
  /// struct X {
  ///   struct A { };
  /// };
  /// \endcode
  ///
  /// The declaration for X<int>::A is a (non-templated) CXXRecordDecl
  /// whose parent is the class template specialization X<int>. For
  /// this declaration, getInstantiatedFromMemberClass() will return
  /// the CXXRecordDecl X<T>::A. When a complete definition of
  /// X<int>::A is required, it will be instantiated from the
  /// declaration returned by getInstantiatedFromMemberClass().
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getInstantiatedFromMemberClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1281,
   FQN="clang::CXXRecordDecl::getInstantiatedFromMemberClass", NM="_ZNK5clang13CXXRecordDecl30getInstantiatedFromMemberClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl30getInstantiatedFromMemberClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getInstantiatedFromMemberClass() /*const*/ {
    {
      MemberSpecializationInfo /*P*/ MSInfo = getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        return cast_CXXRecordDecl(MSInfo.getInstantiatedFrom());
      }
    }
    
    return null;
  }


  
  /// \brief If this class is an instantiation of a member class of a
  /// class template specialization, retrieves the member specialization
  /// information.
  
  /// \brief If this class is an instantiation of a member class of a
  /// class template specialization, retrieves the member specialization
  /// information.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getMemberSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1288,
   FQN="clang::CXXRecordDecl::getMemberSpecializationInfo", NM="_ZNK5clang13CXXRecordDecl27getMemberSpecializationInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl27getMemberSpecializationInfoEv")
  //</editor-fold>
  public MemberSpecializationInfo /*P*/ getMemberSpecializationInfo() /*const*/ {
    return TemplateOrInstantiation.dyn_cast(MemberSpecializationInfo /*P*/.class);
  }


  
  /// \brief Specify that this record is an instantiation of the
  /// member class \p RD.
  
  /// \brief Specify that this record is an instantiation of the
  /// member class \p RD.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setInstantiationOfMemberClass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1292,
   FQN="clang::CXXRecordDecl::setInstantiationOfMemberClass", NM="_ZN5clang13CXXRecordDecl29setInstantiationOfMemberClassEPS0_NS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl29setInstantiationOfMemberClassEPS0_NS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setInstantiationOfMemberClass(CXXRecordDecl /*P*/ RD, 
                               TemplateSpecializationKind TSK) {
    assert (TemplateOrInstantiation.isNull()) : "Previous template or instantiation?";
    assert (!isa_ClassTemplatePartialSpecializationDecl(this));
    TemplateOrInstantiation.$assign_T1$C$R(MemberSpecializationInfo/*P*/.class,
        /*FIXME:NEW_EXPR*//*new (getASTContext())*/ new MemberSpecializationInfo(RD, TSK)
    );
  }


  
  /// \brief Retrieves the class template that is described by this
  /// class declaration.
  ///
  /// Every class template is represented as a ClassTemplateDecl and a
  /// CXXRecordDecl. The former contains template properties (such as
  /// the template parameter lists) while the latter contains the
  /// actual description of the template's
  /// contents. ClassTemplateDecl::getTemplatedDecl() retrieves the
  /// CXXRecordDecl that from a ClassTemplateDecl, while
  /// getDescribedClassTemplate() retrieves the ClassTemplateDecl from
  /// a CXXRecordDecl.
  
  /// \brief Retrieves the class template that is described by this
  /// class declaration.
  ///
  /// Every class template is represented as a ClassTemplateDecl and a
  /// CXXRecordDecl. The former contains template properties (such as
  /// the template parameter lists) while the latter contains the
  /// actual description of the template's
  /// contents. ClassTemplateDecl::getTemplatedDecl() retrieves the
  /// CXXRecordDecl that from a ClassTemplateDecl, while
  /// getDescribedClassTemplate() retrieves the ClassTemplateDecl from
  /// a CXXRecordDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getDescribedClassTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1302,
   FQN="clang::CXXRecordDecl::getDescribedClassTemplate", NM="_ZNK5clang13CXXRecordDecl25getDescribedClassTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl25getDescribedClassTemplateEv")
  //</editor-fold>
  public ClassTemplateDecl /*P*/ getDescribedClassTemplate() /*const*/ {
    return TemplateOrInstantiation.dyn_cast(ClassTemplateDecl /*P*/.class);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setDescribedClassTemplate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1306,
   FQN="clang::CXXRecordDecl::setDescribedClassTemplate", NM="_ZN5clang13CXXRecordDecl25setDescribedClassTemplateEPNS_17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl25setDescribedClassTemplateEPNS_17ClassTemplateDeclE")
  //</editor-fold>
  public void setDescribedClassTemplate(ClassTemplateDecl /*P*/ Template) {
    TemplateOrInstantiation.$assign_T$C$R(ClassTemplateDecl /*P*/.class, Template);
  }


  
  /// \brief Determine whether this particular class is a specialization or
  /// instantiation of a class template or member class of a class template,
  /// and how it was instantiated or specialized.
  
  /// \brief Determine whether this particular class is a specialization or
  /// instantiation of a class template or member class of a class template,
  /// and how it was instantiated or specialized.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1310,
   FQN="clang::CXXRecordDecl::getTemplateSpecializationKind", NM="_ZNK5clang13CXXRecordDecl29getTemplateSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl29getTemplateSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getTemplateSpecializationKind() /*const*/ {
    {
      /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(this);
      if ((Spec != null)) {
        return Spec.getSpecializationKind();
      }
    }
    {
      
      MemberSpecializationInfo /*P*/ MSInfo = getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        return MSInfo.getTemplateSpecializationKind();
      }
    }
    
    return TemplateSpecializationKind.TSK_Undeclared;
  }


  
  /// \brief Set the kind of specialization or template instantiation this is.
  
  /// \brief Set the kind of specialization or template instantiation this is.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1321,
   FQN="clang::CXXRecordDecl::setTemplateSpecializationKind", NM="_ZN5clang13CXXRecordDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl29setTemplateSpecializationKindENS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK) {
    {
      ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(this);
      if ((Spec != null)) {
        Spec.setSpecializationKind(TSK);
        return;
      }
    }
    {
      
      MemberSpecializationInfo /*P*/ MSInfo = getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        MSInfo.setTemplateSpecializationKind(TSK);
        return;
      }
    }
    throw new llvm_unreachable("Not a class template or member class specialization");
  }


  
  /// \brief Retrieve the record declaration from which this record could be
  /// instantiated. Returns null if this class is not a template instantiation.
  
  /// \brief Retrieve the record declaration from which this record could be
  /// instantiated. Returns null if this class is not a template instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getTemplateInstantiationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1337,
   FQN="clang::CXXRecordDecl::getTemplateInstantiationPattern", NM="_ZNK5clang13CXXRecordDecl31getTemplateInstantiationPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl31getTemplateInstantiationPatternEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getTemplateInstantiationPattern$Const() /*const*/ {
    {
      // If it's a class template specialization, find the template or partial
      // specialization from which it was instantiated.
      /*const*/ ClassTemplateSpecializationDecl /*P*/ TD = dyn_cast_ClassTemplateSpecializationDecl(this);
      if ((TD != null)) {
        PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > From = TD.getInstantiatedFrom();
        {
          ClassTemplateDecl /*P*/ CTD = From.dyn_cast(ClassTemplateDecl /*P*/.class);
          if ((CTD != null)) {
            {
              ClassTemplateDecl /*P*/ NewCTD;
              while (((/*P*/ NewCTD = CTD.getInstantiatedFromMemberTemplate()) != null)) {
                if (NewCTD.isMemberSpecialization()) {
                  break;
                }
                CTD = NewCTD;
              }
            }
            return CTD.getTemplatedDecl().getDefinition();
          }
        }
        {
          ClassTemplatePartialSpecializationDecl /*P*/ CTPSD = From.dyn_cast(ClassTemplatePartialSpecializationDecl /*P*/.class);
          if ((CTPSD != null)) {
            {
              ClassTemplatePartialSpecializationDecl /*P*/ NewCTPSD;
              while (((/*P*/ NewCTPSD = CTPSD.getInstantiatedFromMember()) != null)) {
                if (NewCTPSD.isMemberSpecialization()) {
                  break;
                }
                CTPSD = NewCTPSD;
              }
            }
            return CTPSD.getDefinition();
          }
        }
      }
    }
    {
      
      MemberSpecializationInfo /*P*/ MSInfo = getMemberSpecializationInfo();
      if ((MSInfo != null)) {
        if (isTemplateInstantiation(MSInfo.getTemplateSpecializationKind())) {
          /*const*/ CXXRecordDecl /*P*/ RD = this;
          {
            CXXRecordDecl /*P*/ NewRD;
            while (((/*P*/ NewRD = RD.getInstantiatedFromMemberClass()) != null)) {
              RD = NewRD;
            }
          }
          return RD.getDefinition();
        }
      }
    }
    assert (!isTemplateInstantiation(this.getTemplateSpecializationKind())) : "couldn't find pattern for class template instantiation";
    return null;
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getTemplateInstantiationPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1407,
   FQN="clang::CXXRecordDecl::getTemplateInstantiationPattern", NM="_ZN5clang13CXXRecordDecl31getTemplateInstantiationPatternEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl31getTemplateInstantiationPatternEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getTemplateInstantiationPattern() {
    return ((/*const_cast*/CXXRecordDecl /*P*/ )(((/*const_cast*//*const*/ CXXRecordDecl /*P*/ )(this)).
        getTemplateInstantiationPattern$Const()));
  }

  
  /// \brief Returns the destructor decl for this class.
  
  /// \brief Returns the destructor decl for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1375,
   FQN="clang::CXXRecordDecl::getDestructor", NM="_ZNK5clang13CXXRecordDecl13getDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl13getDestructorEv")
  //</editor-fold>
  public CXXDestructorDecl /*P*/ getDestructor() /*const*/ {
    final ASTContext /*&*/ Context = getASTContext();
    QualType ClassType = Context.getTypeDeclType(this);
    
    DeclarationName Name = Context.DeclarationNames.getCXXDestructorName(Context.getCanonicalType(new QualType(ClassType)));
    
    DeclContextLookupResult R = lookup(new DeclarationName(Name));
    if (R.empty()) {
      return null;
    }
    
    CXXDestructorDecl /*P*/ Dtor = cast_CXXDestructorDecl(R.front());
    return Dtor;
  }


  
  /// \brief Returns true if the class destructor, or any implicitly invoked
  /// destructors are marked noreturn.
  
  /// \brief Returns true if the class destructor, or any implicitly invoked
  /// destructors are marked noreturn.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isAnyDestructorNoReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1391,
   FQN="clang::CXXRecordDecl::isAnyDestructorNoReturn", NM="_ZNK5clang13CXXRecordDecl23isAnyDestructorNoReturnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl23isAnyDestructorNoReturnEv")
  //</editor-fold>
  public boolean isAnyDestructorNoReturn() /*const*/ {
    {
      // Destructor is noreturn.
      /*const*/ CXXDestructorDecl /*P*/ Destructor = getDestructor();
      if ((Destructor != null)) {
        if (Destructor.isNoReturn()) {
          return true;
        }
      }
    }
    
    // Check base classes destructor for noreturn.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : bases$Const())  {
      if (Base.getType().$arrow().getAsCXXRecordDecl().isAnyDestructorNoReturn()) {
        return true;
      }
    }
    
    // Check fields for noreturn.
    for (/*const*/ FieldDecl /*P*/ Field : fields())  {
      {
        /*const*/ CXXRecordDecl /*P*/ RD = Field.getType().$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
        if ((RD != null)) {
          if (RD.isAnyDestructorNoReturn()) {
            return true;
          }
        }
      }
    }
    
    // All destructors are not noreturn.
    return false;
  }


  
  /// \brief If the class is a local class [class.local], returns
  /// the enclosing function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isLocalClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1421,
   FQN="clang::CXXRecordDecl::isLocalClass", NM="_ZNK5clang13CXXRecordDecl12isLocalClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl12isLocalClassEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ isLocalClass$Const() /*const*/ {
    {
      /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(getDeclContext$Const());
      if ((RD != null)) {
        return RD.isLocalClass$Const();
      }
    }
    
    return dyn_cast_FunctionDecl(getDeclContext$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isLocalClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1428,
   FQN="clang::CXXRecordDecl::isLocalClass", NM="_ZN5clang13CXXRecordDecl12isLocalClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl12isLocalClassEv")
  //</editor-fold>
  public FunctionDecl /*P*/ isLocalClass() {
    return ((/*const_cast*/FunctionDecl /*P*/ )(((/*const_cast*//*const*/ CXXRecordDecl /*P*/ )(this)).isLocalClass$Const()));
  }

  
  /// \brief Determine whether this dependent class is a current instantiation,
  /// when viewed from within the given context.
  
  /// \brief Determine whether this dependent class is a current instantiation,
  /// when viewed from within the given context.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isCurrentInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 126,
   FQN="clang::CXXRecordDecl::isCurrentInstantiation", NM="_ZNK5clang13CXXRecordDecl22isCurrentInstantiationEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl22isCurrentInstantiationEPKNS_11DeclContextE")
  //</editor-fold>
  public boolean isCurrentInstantiation(/*const*/ DeclContext /*P*/ CurContext) /*const*/ {
    assert (isDependentContext());
    
    for (; !CurContext.isFileContext(); CurContext = CurContext.getParent$Const())  {
      if (CurContext.Equals(this)) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Determine whether this class is derived from the class \p Base.
  ///
  /// This routine only determines whether this class is derived from \p Base,
  /// but does not account for factors that may make a Derived -> Base class
  /// ill-formed, such as private/protected inheritance or multiple, ambiguous
  /// base class subobjects.
  ///
  /// \param Base the base class we are searching for.
  ///
  /// \returns true if this class is derived from Base, false otherwise.
  
  /// \brief Determine whether this class is derived from the class \p Base.
  ///
  /// This routine only determines whether this class is derived from \p Base,
  /// but does not account for factors that may make a Derived -> Base class
  /// ill-formed, such as private/protected inheritance or multiple, ambiguous
  /// base class subobjects.
  ///
  /// \param Base the base class we are searching for.
  ///
  /// \returns true if this class is derived from Base, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isDerivedFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 76,
   FQN="clang::CXXRecordDecl::isDerivedFrom", NM="_ZNK5clang13CXXRecordDecl13isDerivedFromEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl13isDerivedFromEPKS0_")
  //</editor-fold>
  public boolean isDerivedFrom(/*const*/ CXXRecordDecl /*P*/ Base) /*const*/ {
    CXXBasePaths Paths = null;
    try {
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ false, /*RecordPaths=*/ false, 
          /*DetectVirtual=*/ false);
      return isDerivedFrom(Base, Paths);
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }


  
  /// \brief Determine whether this class is derived from the type \p Base.
  ///
  /// This routine only determines whether this class is derived from \p Base,
  /// but does not account for factors that may make a Derived -> Base class
  /// ill-formed, such as private/protected inheritance or multiple, ambiguous
  /// base class subobjects.
  ///
  /// \param Base the base class we are searching for.
  ///
  /// \param Paths will contain the paths taken from the current class to the
  /// given \p Base class.
  ///
  /// \returns true if this class is derived from \p Base, false otherwise.
  ///
  /// \todo add a separate parameter to configure IsDerivedFrom, rather than
  /// tangling input and output in \p Paths
  
  /// \brief Determine whether this class is derived from the type \p Base.
  ///
  /// This routine only determines whether this class is derived from \p Base,
  /// but does not account for factors that may make a Derived -> Base class
  /// ill-formed, such as private/protected inheritance or multiple, ambiguous
  /// base class subobjects.
  ///
  /// \param Base the base class we are searching for.
  ///
  /// \param Paths will contain the paths taken from the current class to the
  /// given \p Base class.
  ///
  /// \returns true if this class is derived from \p Base, false otherwise.
  ///
  /// \todo add a separate parameter to configure IsDerivedFrom, rather than
  /// tangling input and output in \p Paths
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isDerivedFrom">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 82,
   FQN="clang::CXXRecordDecl::isDerivedFrom", NM="_ZNK5clang13CXXRecordDecl13isDerivedFromEPKS0_RNS_12CXXBasePathsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl13isDerivedFromEPKS0_RNS_12CXXBasePathsE")
  //</editor-fold>
  public boolean isDerivedFrom(/*const*/ CXXRecordDecl /*P*/ Base, 
               final CXXBasePaths /*&*/ Paths) /*const*/ {
    if (getCanonicalDecl$Const() == Base.getCanonicalDecl$Const()) {
      return false;
    }
    
    Paths.setOrigin(((/*const_cast*/CXXRecordDecl /*P*/ )(this)));
    
    /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getCanonicalDecl$Const();
    final CXXRecordDecl L$BaseDecl = BaseDecl;
    // FIXME: Capturing 'this' is a workaround for name lookup bugs in GCC 4.7.
    return lookupInBases(/*FuncArg*//*[this, =L$BaseDecl(BaseDecl)]*/ (/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ Path) -> {
              return FindBaseClass(Specifier, Path, L$BaseDecl);
            }, 
        Paths);
  }


  
  /// \brief Determine whether this class is virtually derived from
  /// the class \p Base.
  ///
  /// This routine only determines whether this class is virtually
  /// derived from \p Base, but does not account for factors that may
  /// make a Derived -> Base class ill-formed, such as
  /// private/protected inheritance or multiple, ambiguous base class
  /// subobjects.
  ///
  /// \param Base the base class we are searching for.
  ///
  /// \returns true if this class is virtually derived from Base,
  /// false otherwise.
  
  /// \brief Determine whether this class is virtually derived from
  /// the class \p Base.
  ///
  /// This routine only determines whether this class is virtually
  /// derived from \p Base, but does not account for factors that may
  /// make a Derived -> Base class ill-formed, such as
  /// private/protected inheritance or multiple, ambiguous base class
  /// subobjects.
  ///
  /// \param Base the base class we are searching for.
  ///
  /// \returns true if this class is virtually derived from Base,
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isVirtuallyDerivedFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 98,
   FQN="clang::CXXRecordDecl::isVirtuallyDerivedFrom", NM="_ZNK5clang13CXXRecordDecl22isVirtuallyDerivedFromEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl22isVirtuallyDerivedFromEPKS0_")
  //</editor-fold>
  public boolean isVirtuallyDerivedFrom(/*const*/ CXXRecordDecl /*P*/ Base) /*const*/ {
    CXXBasePaths Paths = null;
    try {
      if (!(getNumVBases() != 0)) {
        return false;
      }
      
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ false, /*RecordPaths=*/ false, 
          /*DetectVirtual=*/ false);
      if (getCanonicalDecl$Const() == Base.getCanonicalDecl$Const()) {
        return false;
      }
      
      Paths.setOrigin(((/*const_cast*/CXXRecordDecl /*P*/ )(this)));
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getCanonicalDecl$Const();
      final CXXRecordDecl L$BaseDecl = BaseDecl;
      // FIXME: Capturing 'this' is a workaround for name lookup bugs in GCC 4.7.
      return lookupInBases(/*FuncArg*//*[this, =L$BaseDecl(BaseDecl)]*/ (/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ Path) -> {
                return FindVirtualBaseClass(Specifier, Path, L$BaseDecl);
              }, 
          Paths);
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }


  
  /// \brief Determine whether this class is provably not derived from
  /// the type \p Base.
  
  /// \brief Determine whether this class is provably not derived from
  /// the type \p Base.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isProvablyNotDerivedFrom">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 119,
   FQN="clang::CXXRecordDecl::isProvablyNotDerivedFrom", NM="_ZNK5clang13CXXRecordDecl24isProvablyNotDerivedFromEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl24isProvablyNotDerivedFromEPKS0_")
  //</editor-fold>
  public boolean isProvablyNotDerivedFrom(/*const*/ CXXRecordDecl /*P*/ Base) /*const*/ {
    /*const*/ CXXRecordDecl /*P*/ TargetDecl = Base.getCanonicalDecl$Const();
    final CXXRecordDecl L$TargetDecl = TargetDecl;
    return forallBases(/*FuncArg*//*[=L$TargetDecl(TargetDecl)]*/ (/*const*/ CXXRecordDecl /*P*/ Base$1) -> {
              return Base$1.getCanonicalDecl$Const() != L$TargetDecl;
            });
  }


  
  /// \brief Function type used by forallBases() as a callback.
  ///
  /// \param BaseDefinition the definition of the base class
  ///
  /// \returns true if this base matched the search criteria
  /*typedef llvm::function_ref<bool (const CXXRecordDecl *)> ForallBasesCallback*/
//  public final class ForallBasesCallback extends CXXRecordDecl2Bool{ };
  
  /// \brief Determines if the given callback holds for all the direct
  /// or indirect base classes of this type.
  ///
  /// The class itself does not count as a base class.  This routine
  /// returns false if the class has non-computable base classes.
  ///
  /// \param BaseMatches Callback invoked for each (direct or indirect) base
  /// class of this type, or if \p AllowShortCircuit is true then until a call
  /// returns false.
  ///
  /// \param AllowShortCircuit if false, forces the callback to be called
  /// for every base class, even if a dependent or non-matching base was
  /// found.
  
  /// \brief Determines if the given callback holds for all the direct
  /// or indirect base classes of this type.
  ///
  /// The class itself does not count as a base class.  This routine
  /// returns false if the class has non-computable base classes.
  ///
  /// \param BaseMatches Callback invoked for each (direct or indirect) base
  /// class of this type, or if \p AllowShortCircuit is true then until a call
  /// returns false.
  ///
  /// \param AllowShortCircuit if false, forces the callback to be called
  /// for every base class, even if a dependent or non-matching base was
  /// found.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::forallBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 137,
   FQN="clang::CXXRecordDecl::forallBases", NM="_ZNK5clang13CXXRecordDecl11forallBasesEN4llvm12function_refIFbPKS0_EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl11forallBasesEN4llvm12function_refIFbPKS0_EEEb")
  //</editor-fold>
  public boolean forallBases(ForallBasesCallback BaseMatches) /*const*/ {
    return forallBases(BaseMatches, 
             true);
  }
  public boolean forallBases(ForallBasesCallback BaseMatches, 
             boolean AllowShortCircuit/*= true*/) /*const*/ {
    SmallVector</*const*/ CXXRecordDecl /*P*/ > Queue/*J*/= new SmallVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ )null);
    
    /*const*/ CXXRecordDecl /*P*/ Record = this;
    boolean AllMatches = true;
    while (true) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : Record.bases$Const()) {
        /*const*/ RecordType /*P*/ Ty = I.getType().$arrow().<RecordType>getAs$RecordType();
        if (!(Ty != null)) {
          if (AllowShortCircuit) {
            return false;
          }
          AllMatches = false;
          continue;
        }
        
        CXXRecordDecl /*P*/ Base = cast_or_null_CXXRecordDecl(Ty.getDecl().getDefinition());
        if (!(Base != null)
           || (Base.isDependentContext()
           && !Base.isCurrentInstantiation(Record))) {
          if (AllowShortCircuit) {
            return false;
          }
          AllMatches = false;
          continue;
        }
        
        Queue.push_back(Base);
        if (!BaseMatches.$call(Base)) {
          if (AllowShortCircuit) {
            return false;
          }
          AllMatches = false;
          continue;
        }
      }
      if (Queue.empty()) {
        break;
      }
      Record = Queue.pop_back_val(); // not actually a queue.
    }
    
    return AllMatches;
  }


  
  /// \brief Function type used by lookupInBases() to determine whether a
  /// specific base class subobject matches the lookup criteria.
  ///
  /// \param Specifier the base-class specifier that describes the inheritance
  /// from the base class we are trying to match.
  ///
  /// \param Path the current path, from the most-derived class down to the
  /// base named by the \p Specifier.
  ///
  /// \returns true if this base matched the search criteria, false otherwise.
  /*typedef llvm::function_ref<bool (const CXXBaseSpecifier *, CXXBasePath &)> BaseMatchesCallback*/
//  public final class BaseMatchesCallback extends CXXBaseSpecifierCXXBasePath2Bool{ };
  
  /// \brief Look for entities within the base classes of this C++ class,
  /// transitively searching all base class subobjects.
  ///
  /// This routine uses the callback function \p BaseMatches to find base
  /// classes meeting some search criteria, walking all base class subobjects
  /// and populating the given \p Paths structure with the paths through the
  /// inheritance hierarchy that resulted in a match. On a successful search,
  /// the \p Paths structure can be queried to retrieve the matching paths and
  /// to determine if there were any ambiguities.
  ///
  /// \param BaseMatches callback function used to determine whether a given
  /// base matches the user-defined search criteria.
  ///
  /// \param Paths used to record the paths from this class to its base class
  /// subobjects that match the search criteria.
  ///
  /// \returns true if there exists any path from this class to a base class
  /// subobject that matches the search criteria.
  
  /// \brief Look for entities within the base classes of this C++ class,
  /// transitively searching all base class subobjects.
  ///
  /// This routine uses the callback function \p BaseMatches to find base
  /// classes meeting some search criteria, walking all base class subobjects
  /// and populating the given \p Paths structure with the paths through the
  /// inheritance hierarchy that resulted in a match. On a successful search,
  /// the \p Paths structure can be queried to retrieve the matching paths and
  /// to determine if there were any ambiguities.
  ///
  /// \param BaseMatches callback function used to determine whether a given
  /// base matches the user-defined search criteria.
  ///
  /// \param Paths used to record the paths from this class to its base class
  /// subobjects that match the search criteria.
  ///
  /// \returns true if there exists any path from this class to a base class
  /// subobject that matches the search criteria.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::lookupInBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 302,
   FQN="clang::CXXRecordDecl::lookupInBases", NM="_ZNK5clang13CXXRecordDecl13lookupInBasesEN4llvm12function_refIFbPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEEEERNS_12CXXBasePathsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl13lookupInBasesEN4llvm12function_refIFbPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEEEERNS_12CXXBasePathsE")
  //</editor-fold>
  public boolean lookupInBases(BaseMatchesCallback BaseMatches, 
               final CXXBasePaths /*&*/ Paths) /*const*/ {
    // If we didn't find anything, report that.
    if (!Paths.lookupInBases(getASTContext(), this, /*FuncArg*/BaseMatches)) {
      return false;
    }
    
    // If we're not recording paths or we won't ever find ambiguities,
    // we're done.
    if (!Paths.isRecordingPaths() || !Paths.isFindingAmbiguities()) {
      return true;
    }
    
    // C++ [class.member.lookup]p6:
    //   When virtual base classes are used, a hidden declaration can be
    //   reached along a path through the sub-object lattice that does
    //   not pass through the hiding declaration. This is not an
    //   ambiguity. The identical use with nonvirtual base classes is an
    //   ambiguity; in that case there is no unique instance of the name
    //   that hides all the others.
    //
    // FIXME: This is an O(N^2) algorithm, but DPG doesn't see an easy
    // way to make it any faster.
    Paths.Paths.remove_if(/*[&Paths]*/ (final /*const*/ CXXBasePath /*&*/ Path) -> {
              for (final /*const*/ CXXBasePathElement /*&*/ PE : Path) {
                if (!PE.Base.isVirtual()) {
                  continue;
                }
                
                CXXRecordDecl /*P*/ VBase = (CXXRecordDecl /*P*/ )null;
                {
                  /*const*/ RecordType /*P*/ Record = PE.Base.getType().$arrow().<RecordType>getAs$RecordType();
                  if ((Record != null)) {
                    VBase = cast_CXXRecordDecl(Record.getDecl());
                  }
                }
                if (!(VBase != null)) {
                  break;
                }
                
                // The declaration(s) we found along this path were found in a
                // subobject of a virtual base. Check whether this virtual
                // base is a subobject of any other path; if so, then the
                // declaration in this path are hidden by that patch.
                for (final /*const*/ CXXBasePath /*&*/ HidingP : Paths) {
                  CXXRecordDecl /*P*/ HidingClass = (CXXRecordDecl /*P*/ )null;
                  {
                    /*const*/ RecordType /*P*/ Record = HidingP.back$Const().Base.getType().$arrow().<RecordType>getAs$RecordType();
                    if ((Record != null)) {
                      HidingClass = cast_CXXRecordDecl(Record.getDecl());
                    }
                  }
                  if (!(HidingClass != null)) {
                    break;
                  }
                  if (HidingClass.isVirtuallyDerivedFrom(VBase)) {
                    return true;
                  }
                }
              }
              return false;
            });
    
    return true;
  }


  
  /// \brief Base-class lookup callback that determines whether the given
  /// base class specifier refers to a specific class declaration.
  ///
  /// This callback can be used with \c lookupInBases() to determine whether
  /// a given derived class has is a base class subobject of a particular type.
  /// The base record pointer should refer to the canonical CXXRecordDecl of the
  /// base class that we are searching for.
  
  /// \brief Base-class lookup callback that determines whether the given
  /// base class specifier refers to a specific class declaration.
  ///
  /// This callback can be used with \c lookupInBases() to determine whether
  /// a given derived class has is a base class subobject of a particular type.
  /// The base record pointer should refer to the canonical CXXRecordDecl of the
  /// base class that we are searching for.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::FindBaseClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 356,
   FQN="clang::CXXRecordDecl::FindBaseClass", NM="_ZN5clang13CXXRecordDecl13FindBaseClassEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang13CXXRecordDecl13FindBaseClassEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEPKS0_")
  //</editor-fold>
  public static boolean FindBaseClass(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
               final CXXBasePath /*&*/ Path, 
               /*const*/ CXXRecordDecl /*P*/ BaseRecord) {
    assert (BaseRecord.getCanonicalDecl$Const() == BaseRecord) : "User data for FindBaseClass is not canonical!";
    return Specifier.getType().$arrow().<RecordType>castAs$RecordType().getDecl().
        getCanonicalDecl() == BaseRecord;
  }


  
  /// \brief Base-class lookup callback that determines whether the
  /// given base class specifier refers to a specific class
  /// declaration and describes virtual derivation.
  ///
  /// This callback can be used with \c lookupInBases() to determine
  /// whether a given derived class has is a virtual base class
  /// subobject of a particular type.  The base record pointer should
  /// refer to the canonical CXXRecordDecl of the base class that we
  /// are searching for.
  
  /// \brief Base-class lookup callback that determines whether the
  /// given base class specifier refers to a specific class
  /// declaration and describes virtual derivation.
  ///
  /// This callback can be used with \c lookupInBases() to determine
  /// whether a given derived class has is a virtual base class
  /// subobject of a particular type.  The base record pointer should
  /// refer to the canonical CXXRecordDecl of the base class that we
  /// are searching for.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::FindVirtualBaseClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 365,
   FQN="clang::CXXRecordDecl::FindVirtualBaseClass", NM="_ZN5clang13CXXRecordDecl20FindVirtualBaseClassEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang13CXXRecordDecl20FindVirtualBaseClassEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathEPKS0_")
  //</editor-fold>
  public static boolean FindVirtualBaseClass(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
                      final CXXBasePath /*&*/ Path, 
                      /*const*/ CXXRecordDecl /*P*/ BaseRecord) {
    assert (BaseRecord.getCanonicalDecl$Const() == BaseRecord) : "User data for FindBaseClass is not canonical!";
    return Specifier.isVirtual()
       && Specifier.getType().$arrow().<RecordType>castAs$RecordType().getDecl().
        getCanonicalDecl() == BaseRecord;
  }


  
  /// \brief Base-class lookup callback that determines whether there exists
  /// a tag with the given name.
  ///
  /// This callback can be used with \c lookupInBases() to find tag members
  /// of the given name within a C++ class hierarchy.
  
  /// \brief Base-class lookup callback that determines whether there exists
  /// a tag with the given name.
  ///
  /// This callback can be used with \c lookupInBases() to find tag members
  /// of the given name within a C++ class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::FindTagMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 375,
   FQN="clang::CXXRecordDecl::FindTagMember", NM="_ZN5clang13CXXRecordDecl13FindTagMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang13CXXRecordDecl13FindTagMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE")
  //</editor-fold>
  public static boolean FindTagMember(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
               final CXXBasePath /*&*/ Path, 
               DeclarationName Name) {
    RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    
    for (Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name)));
         !Path.Decls.empty();
         Path.Decls.$assignMove(Path.Decls.slice(1))) {
      if (Path.Decls.front().isInIdentifierNamespace(IdentifierNamespace.IDNS_Tag)) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Base-class lookup callback that determines whether there exists
  /// a member with the given name.
  ///
  /// This callback can be used with \c lookupInBases() to find members
  /// of the given name within a C++ class hierarchy.
  
  /// \brief Base-class lookup callback that determines whether there exists
  /// a member with the given name.
  ///
  /// This callback can be used with \c lookupInBases() to find members
  /// of the given name within a C++ class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::FindOrdinaryMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 391,
   FQN="clang::CXXRecordDecl::FindOrdinaryMember", NM="_ZN5clang13CXXRecordDecl18FindOrdinaryMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang13CXXRecordDecl18FindOrdinaryMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE")
  //</editor-fold>
  public static boolean FindOrdinaryMember(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
                    final CXXBasePath /*&*/ Path, 
                    DeclarationName Name) {
    RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    
    /*const*//*uint*/int IDNS = IdentifierNamespace.IDNS_Ordinary | IdentifierNamespace.IDNS_Tag | IdentifierNamespace.IDNS_Member;
    for (Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name)));
         !Path.Decls.empty();
         Path.Decls.$assignMove(Path.Decls.slice(1))) {
      if (Path.Decls.front().isInIdentifierNamespace(IDNS)) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Base-class lookup callback that determines whether there exists
  /// an OpenMP declare reduction member with the given name.
  ///
  /// This callback can be used with \c lookupInBases() to find members
  /// of the given name within a C++ class hierarchy.
  
  /// \brief Base-class lookup callback that determines whether there exists
  /// an OpenMP declare reduction member with the given name.
  ///
  /// This callback can be used with \c lookupInBases() to find members
  /// of the given name within a C++ class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::FindOMPReductionMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 408,
   FQN="clang::CXXRecordDecl::FindOMPReductionMember", NM="_ZN5clang13CXXRecordDecl22FindOMPReductionMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang13CXXRecordDecl22FindOMPReductionMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE")
  //</editor-fold>
  public static boolean FindOMPReductionMember(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
                        final CXXBasePath /*&*/ Path, 
                        DeclarationName Name) {
    RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    
    for (Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name))); !Path.Decls.empty();
         Path.Decls.$assignMove(Path.Decls.slice(1))) {
      if (Path.Decls.front().isInIdentifierNamespace(IdentifierNamespace.IDNS_OMPReduction)) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Base-class lookup callback that determines whether there exists
  /// a member with the given name that can be used in a nested-name-specifier.
  ///
  /// This callback can be used with \c lookupInBases() to find members of
  /// the given name within a C++ class hierarchy that can occur within
  /// nested-name-specifiers.
  
  /// \brief Base-class lookup callback that determines whether there exists
  /// a member with the given name that can be used in a nested-name-specifier.
  ///
  /// This callback can be used with \c lookupInBases() to find members of
  /// the given name within a C++ class hierarchy that can occur within
  /// nested-name-specifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::FindNestedNameSpecifierMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 423,
   FQN="clang::CXXRecordDecl::FindNestedNameSpecifierMember", NM="_ZN5clang13CXXRecordDecl29FindNestedNameSpecifierMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang13CXXRecordDecl29FindNestedNameSpecifierMemberEPKNS_16CXXBaseSpecifierERNS_11CXXBasePathENS_15DeclarationNameE")
  //</editor-fold>
  public static boolean FindNestedNameSpecifierMember(/*const*/ CXXBaseSpecifier /*P*/ Specifier, 
                               final CXXBasePath /*&*/ Path, 
                               DeclarationName Name) {
    RecordDecl /*P*/ BaseRecord = Specifier.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    
    for (Path.Decls.$assignMove(BaseRecord.lookup(new DeclarationName(Name)));
         !Path.Decls.empty();
         Path.Decls.$assignMove(Path.Decls.slice(1))) {
      // FIXME: Refactor the "is it a nested-name-specifier?" check
      if (isa_TypedefNameDecl(Path.Decls.front())
         || Path.Decls.front().isInIdentifierNamespace(IdentifierNamespace.IDNS_Tag)) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief Retrieve the final overriders for each virtual member
  /// function in the class hierarchy where this class is the
  /// most-derived class in the class hierarchy.
  
  /// \brief Retrieve the final overriders for each virtual member
  /// function in the class hierarchy where this class is the
  /// most-derived class in the class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getFinalOverriders">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 623,
   FQN="clang::CXXRecordDecl::getFinalOverriders", NM="_ZNK5clang13CXXRecordDecl18getFinalOverridersERNS_20CXXFinalOverriderMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl18getFinalOverridersERNS_20CXXFinalOverriderMapE")
  //</editor-fold>
  public void getFinalOverriders(final CXXFinalOverriderMap /*&*/ FinalOverriders) /*const*/ {
    FinalOverriderCollector Collector = null;
    try {
      Collector/*J*/= new FinalOverriderCollector();
      Collector.Collect(this, false, (/*const*/ CXXRecordDecl /*P*/ )null, FinalOverriders);
      
      // Weed out any final overriders that come from virtual base class
      // subobjects that were hidden by other subobjects along any path.
      // This is the final-overrider variant of C++ [class.member.lookup]p10.
      for (final pair</*const*/ CXXMethodDecl /*P*/ , OverridingMethods> /*&*/ OM : FinalOverriders) {
        for (final std.pairUIntType<SmallVector<UniqueVirtualMethod>> /*&*/ SO : OM.second) {
          final SmallVectorImpl<UniqueVirtualMethod> /*&*/ Overriding = SO.second;
          if ($less_uint(Overriding.size(), 2)) {
            continue;
          }
          
          UniqueVirtualMethod2Bool IsHidden = /*[&Overriding]*/ (final /*const*/ UniqueVirtualMethod /*&*/ M) -> {
                if (!(M.InVirtualSubobject != null)) {
                  return false;
                }
                
                // We have an overriding method in a virtual base class
                // subobject (or non-virtual base class subobject thereof);
                // determine whether there exists an other overriding method
                // in a base class subobject that hides the virtual base class
                // subobject.
                for (final /*const*/ UniqueVirtualMethod /*&*/ OP : Overriding)  {
                  if ($AddrOf(M) != $AddrOf(OP)
                     && OP.Method.getParent().isVirtuallyDerivedFrom(M.InVirtualSubobject)) {
                    return true;
                  }
                }
                return false;
              };
          
          Overriding.erase(std.remove_if(Overriding.begin(), Overriding.end(), IsHidden), 
              Overriding.end());
        }
      }
    } finally {
      if (Collector != null) { Collector.$destroy(); }
    }
  }


  
  /// \brief Get the indirect primary bases for this class.
  
  /// \brief Get the indirect primary bases for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getIndirectPrimaryBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 684,
   FQN="clang::CXXRecordDecl::getIndirectPrimaryBases", NM="_ZNK5clang13CXXRecordDecl23getIndirectPrimaryBasesERNS_25CXXIndirectPrimaryBaseSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang13CXXRecordDecl23getIndirectPrimaryBasesERNS_25CXXIndirectPrimaryBaseSetE")
  //</editor-fold>
  public void getIndirectPrimaryBases(final CXXIndirectPrimaryBaseSet /*&*/ Bases) /*const*/ {
    final ASTContext /*&*/ Context = getASTContext();
    if (!(getNumVBases() != 0)) {
      return;
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : bases$Const()) {
      assert (!I.getType().$arrow().isDependentType()) : "Cannot get indirect primary bases for class with dependent bases.";
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(I.getType().$arrow().<RecordType>castAs$RecordType().getDecl());
      
      // Only bases with virtual bases participate in computing the
      // indirect primary virtual base classes.
      if ((BaseDecl.getNumVBases() != 0)) {
        AddIndirectPrimaryBases(BaseDecl, Context, Bases);
      }
    }
  }


  
  /// Renders and displays an inheritance diagram
  /// for this C++ class and all of its base classes (transitively) using
  /// GraphViz.
  
  /// Renders and displays an inheritance diagram
  /// for this C++ class and all of its base classes (transitively) using
  /// GraphViz.
  
  /// viewInheritance - Display the inheritance hierarchy of this C++
  /// class using GraphViz.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::viewInheritance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp", line = 137,
   FQN="clang::CXXRecordDecl::viewInheritance", NM="_ZNK5clang13CXXRecordDecl15viewInheritanceERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/InheritViz.cpp -nm=_ZNK5clang13CXXRecordDecl15viewInheritanceERNS_10ASTContextE")
  //</editor-fold>
  public void viewInheritance(final ASTContext /*&*/ Context) /*const*/ {
    raw_fd_ostream O = null;
    InheritanceHierarchyWriter Writer = null;
    try {
      QualType Self = Context.getTypeDeclType(this);
      
      int$ref FD = create_int$ref();
      SmallString/*128*/ Filename/*J*/= new SmallString/*128*/(128);
      {
        std.error_code EC = fs.createTemporaryFile(new Twine(Self.getAsString()), new StringRef(/*KEEP_STR*/"dot"), FD, Filename);
        if (EC.$bool()) {
          llvm.errs().$out(/*KEEP_STR*/"Error: ").$out(EC.message()).$out(/*KEEP_STR*/$LF);
          return;
        }
      }
      
      llvm.errs().$out(/*KEEP_STR*/"Writing '").$out(Filename).$out(/*KEEP_STR*/"'... ");
      
      O/*J*/= new raw_fd_ostream(FD.$deref(), true);
      
      Writer/*J*/= new InheritanceHierarchyWriter(Context, O);
      Writer.WriteGraph(new QualType(Self));
      llvm.errs().$out(/*KEEP_STR*/" done. \n");
      
      O.close();
      
      // Display the graph
      DisplayGraph(Filename.$StringRef());
    } finally {
      if (Writer != null) { Writer.$destroy(); }
      if (O != null) { O.$destroy(); }
    }
  }


  
  /// \brief Calculates the access of a decl that is reached
  /// along a path.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::MergeAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1616,
   FQN="clang::CXXRecordDecl::MergeAccess", NM="_ZN5clang13CXXRecordDecl11MergeAccessENS_15AccessSpecifierES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl11MergeAccessENS_15AccessSpecifierES1_")
  //</editor-fold>
  public static AccessSpecifier MergeAccess(AccessSpecifier PathAccess, 
             AccessSpecifier DeclAccess) {
    assert (DeclAccess != AccessSpecifier.AS_none);
    if (DeclAccess == AccessSpecifier.AS_private) {
      return AccessSpecifier.AS_none;
    }
    return (PathAccess.getValue() > DeclAccess.getValue() ? PathAccess : DeclAccess);
  }

  
  /// \brief Indicates that the declaration of a defaulted or deleted special
  /// member function is now complete.
  
  /// \brief Indicates that the declaration of a defaulted or deleted special
  /// member function is now complete.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::finishedDefaultedOrDeletedMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1000,
   FQN="clang::CXXRecordDecl::finishedDefaultedOrDeletedMember", NM="_ZN5clang13CXXRecordDecl32finishedDefaultedOrDeletedMemberEPNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl32finishedDefaultedOrDeletedMemberEPNS_13CXXMethodDeclE")
  //</editor-fold>
  public void finishedDefaultedOrDeletedMember(CXXMethodDecl /*P*/ D) {
    assert (!D.isImplicit() && !D.isUserProvided());
    
    // The kind of special member this declaration is, if any.
    /*uint*/int SMKind = 0;
    {
      
      CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(D);
      if ((Constructor != null)) {
        if (Constructor.isDefaultConstructor()) {
          SMKind |= SpecialMemberFlags.SMF_DefaultConstructor;
          if (Constructor.isConstexpr()) {
            data().HasConstexprDefaultConstructor = true;
          }
        }
        if (Constructor.isCopyConstructor()) {
          SMKind |= SpecialMemberFlags.SMF_CopyConstructor;
        } else if (Constructor.isMoveConstructor()) {
          SMKind |= SpecialMemberFlags.SMF_MoveConstructor;
        } else if (Constructor.isConstexpr()) {
          // We may now know that the constructor is constexpr.
          data().HasConstexprNonCopyMoveConstructor = true;
        }
      } else if (isa_CXXDestructorDecl(D)) {
        SMKind |= SpecialMemberFlags.SMF_Destructor;
        if (!D.isTrivial() || D.getAccess() != AccessSpecifier.AS_public || D.isDeleted()) {
          data().HasIrrelevantDestructor = false;
        }
      } else if (D.isCopyAssignmentOperator()) {
        SMKind |= SpecialMemberFlags.SMF_CopyAssignment;
      } else if (D.isMoveAssignmentOperator()) {
        SMKind |= SpecialMemberFlags.SMF_MoveAssignment;
      }
    }
    
    // Update which trivial / non-trivial special members we have.
    // addedMember will have skipped this step for this member.
    if (D.isTrivial()) {
      data().HasTrivialSpecialMembers |= $uint2uint_6bits(SMKind);
    } else {
      data().DeclaredNonTrivialSpecialMembers |= $uint2uint_6bits(SMKind);
    }
  }


  
  /// \brief Indicates that the definition of this class is now complete.
  
  /// \brief Indicates that the definition of this class is now complete.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::completeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1413,
   FQN="clang::CXXRecordDecl::completeDefinition", NM="_ZN5clang13CXXRecordDecl18completeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl18completeDefinitionEv")
  //</editor-fold>
  @Override public void completeDefinition()/* override*/ {
    completeDefinition((CXXFinalOverriderMap /*P*/ )null);
  }


  
  /// \brief Indicates that the definition of this class is now complete,
  /// and provides a final overrider map to help determine
  ///
  /// \param FinalOverriders The final overrider map for this class, which can
  /// be provided as an optimization for abstract-class checking. If NULL,
  /// final overriders will be computed if they are needed to complete the
  /// definition.
  
  /// \brief Indicates that the definition of this class is now complete,
  /// and provides a final overrider map to help determine
  ///
  /// \param FinalOverriders The final overrider map for this class, which can
  /// be provided as an optimization for abstract-class checking. If NULL,
  /// final overriders will be computed if they are needed to complete the
  /// definition.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::completeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1417,
   FQN="clang::CXXRecordDecl::completeDefinition", NM="_ZN5clang13CXXRecordDecl18completeDefinitionEPNS_20CXXFinalOverriderMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang13CXXRecordDecl18completeDefinitionEPNS_20CXXFinalOverriderMapE")
  //</editor-fold>
  public void completeDefinition(CXXFinalOverriderMap /*P*/ FinalOverriders) {
    super.completeDefinition();
    
    // If the class may be abstract (but hasn't been marked as such), check for
    // any pure final overriders.
    if (mayBeAbstract()) {
      CXXFinalOverriderMap MyFinalOverriders = null;
      try {
        MyFinalOverriders/*J*/= new CXXFinalOverriderMap();
        if (!(FinalOverriders != null)) {
          getFinalOverriders(MyFinalOverriders);
          FinalOverriders = $AddrOf(MyFinalOverriders);
        }
        
        boolean Done = false;
        for (StdVector.iterator<std.pairPtrType<CXXMethodDecl, OverridingMethods>> M = FinalOverriders.begin(), 
            MEnd = FinalOverriders.end();
             $noteq___normal_iterator$C(M, MEnd) && !Done; M.$preInc()) {
          for (StdVector.iterator<pairUIntType<SmallVector<UniqueVirtualMethod>>> SO = M.$arrow().second.begin(), 
              SOEnd = M.$arrow().second.end();
               $noteq___normal_iterator$C(SO, SOEnd) && !Done; SO.$preInc()) {
            assert ($greater_uint(SO.$arrow().second.size(), 0)) : "All virtual functions have overridding virtual functions";
            
            // C++ [class.abstract]p4:
            //   A class is abstract if it contains or inherits at least one
            //   pure virtual function for which the final overrider is pure
            //   virtual.
            if (SO.$arrow().second.front().Method.isPure()) {
              data().Abstract = true;
              Done = true;
              break;
            }
          }
        }
      } finally {
        if (MyFinalOverriders != null) { MyFinalOverriders.$destroy(); }
      }
    }
    
    // Set access bits correctly on the directly-declared conversions.
    for (UnresolvedSetIterator I = conversion_begin(), E = conversion_end();
         I.$noteq(E); I.$preInc())  {
      I.setAccess((I.$star()).getAccess());
    }
  }


  
  /// \brief Determine whether this class may end up being abstract, even though
  /// it is not yet known to be abstract.
  ///
  /// \returns true if this class is not known to be abstract but has any
  /// base classes that are abstract. In this case, \c completeDefinition()
  /// will need to compute final overriders to determine whether the class is
  /// actually abstract.
  
  /// \brief Determine whether this class may end up being abstract, even though
  /// it is not yet known to be abstract.
  ///
  /// \returns true if this class is not known to be abstract but has any
  /// base classes that are abstract. In this case, \c completeDefinition()
  /// will need to compute final overriders to determine whether the class is
  /// actually abstract.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::mayBeAbstract">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1458,
   FQN="clang::CXXRecordDecl::mayBeAbstract", NM="_ZNK5clang13CXXRecordDecl13mayBeAbstractEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang13CXXRecordDecl13mayBeAbstractEv")
  //</editor-fold>
  public boolean mayBeAbstract() /*const*/ {
    if (data().Abstract || isInvalidDecl() || !data().Polymorphic
       || isDependentContext()) {
      return false;
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : bases$Const()) {
      CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(B.getType().$arrow().<RecordType>getAs$RecordType().getDecl());
      if (BaseDecl.isAbstract()) {
        return true;
      }
    }
    
    return false;
  }


  
  /// \brief If this is the closure type of a lambda expression, retrieve the
  /// number to be used for name mangling in the Itanium C++ ABI.
  ///
  /// Zero indicates that this closure type has internal linkage, so the 
  /// mangling number does not matter, while a non-zero value indicates which
  /// lambda expression this is in this particular context.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1654,
   FQN="clang::CXXRecordDecl::getLambdaManglingNumber", NM="_ZNK5clang13CXXRecordDecl23getLambdaManglingNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl23getLambdaManglingNumberEv")
  //</editor-fold>
  public /*uint*/int getLambdaManglingNumber() /*const*/ {
    assert (isLambda()) : "Not a lambda closure type!";
    return getLambdaData().ManglingNumber;
  }

  
  /// \brief Retrieve the declaration that provides additional context for a 
  /// lambda, when the normal declaration context is not specific enough.
  ///
  /// Certain contexts (default arguments of in-class function parameters and 
  /// the initializers of data members) have separate name mangling rules for
  /// lambdas within the Itanium C++ ABI. For these cases, this routine provides
  /// the declaration in which the lambda occurs, e.g., the function parameter 
  /// or the non-static data member. Otherwise, it returns NULL to imply that
  /// the declaration context suffices.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaContextDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1668,
   FQN="clang::CXXRecordDecl::getLambdaContextDecl", NM="_ZNK5clang13CXXRecordDecl20getLambdaContextDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl20getLambdaContextDeclEv")
  //</editor-fold>
  public Decl /*P*/ getLambdaContextDecl() /*const*/ {
    assert (isLambda()) : "Not a lambda closure type!";
    return getLambdaData().ContextDecl;
  }

  
  /// \brief Set the mangling number and context declaration for a lambda
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::setLambdaMangling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1675,
   FQN="clang::CXXRecordDecl::setLambdaMangling", NM="_ZN5clang13CXXRecordDecl17setLambdaManglingEjPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl17setLambdaManglingEjPNS_4DeclE")
  //</editor-fold>
  public void setLambdaMangling(/*uint*/int ManglingNumber, Decl /*P*/ ContextDecl) {
    getLambdaData().ManglingNumber = ManglingNumber;
    getLambdaData().ContextDecl = ContextDecl;
  }

  
  /// \brief Returns the inheritance model used for this record.
  
  /// \brief Returns the inheritance model used for this record.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getMSInheritanceModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 179,
   FQN="clang::CXXRecordDecl::getMSInheritanceModel", NM="_ZNK5clang13CXXRecordDecl21getMSInheritanceModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK5clang13CXXRecordDecl21getMSInheritanceModelEv")
  //</editor-fold>
  public MSInheritanceAttr.Spelling getMSInheritanceModel() /*const*/ {
    MSInheritanceAttr /*P*/ IA = getAttr(MSInheritanceAttr.class);
    assert ((IA != null)) : "Expected MSInheritanceAttr on the CXXRecordDecl!";
    return IA.getSemanticSpelling();
  }


  /// \brief Calculate what the inheritance model would be for this class.
  /// \brief Calculate what the inheritance model would be for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::calculateInheritanceModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 169,
   FQN="clang::CXXRecordDecl::calculateInheritanceModel", NM="_ZNK5clang13CXXRecordDecl25calculateInheritanceModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK5clang13CXXRecordDecl25calculateInheritanceModelEv")
  //</editor-fold>
  public MSInheritanceAttr.Spelling calculateInheritanceModel() /*const*/ {
    if (!hasDefinition() || isParsingBaseSpecifiers()) {
      return MSInheritanceAttr.Spelling.Keyword_unspecified_inheritance;
    }
    if ($greater_uint(getNumVBases(), 0)) {
      return MSInheritanceAttr.Spelling.Keyword_virtual_inheritance;
    }
    if (usesMultipleInheritanceModel(this)) {
      return MSInheritanceAttr.Spelling.Keyword_multiple_inheritance;
    }
    return MSInheritanceAttr.Spelling.Keyword_single_inheritance;
  }


  
  /// In the Microsoft C++ ABI, use zero for the field offset of a null data
  /// member pointer if we can guarantee that zero is not a valid field offset,
  /// or if the member pointer has multiple fields.  Polymorphic classes have a
  /// vfptr at offset zero, so we can use zero for null.  If there are multiple
  /// fields, we can use zero even if it is a valid field offset because
  /// null-ness testing will check the other fields.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::nullFieldOffsetIsZero">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1691,
   FQN="clang::CXXRecordDecl::nullFieldOffsetIsZero", NM="_ZNK5clang13CXXRecordDecl21nullFieldOffsetIsZeroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl21nullFieldOffsetIsZeroEv")
  //</editor-fold>
  public boolean nullFieldOffsetIsZero() /*const*/ {
    return !MSInheritanceAttr.hasOnlyOneField(/*IsMemberFunction=*/ false, 
        getMSInheritanceModel())
       || (hasDefinition() && isPolymorphic());
  }

  
  /// \brief Controls when vtordisps will be emitted if this record is used as a
  /// virtual base.
  
  /// \brief Controls when vtordisps will be emitted if this record is used as a
  /// virtual base.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getMSVtorDispMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 186,
   FQN="clang::CXXRecordDecl::getMSVtorDispMode", NM="_ZNK5clang13CXXRecordDecl17getMSVtorDispModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK5clang13CXXRecordDecl17getMSVtorDispModeEv")
  //</editor-fold>
  public MSVtorDispAttr.Mode getMSVtorDispMode() /*const*/ {
    {
      MSVtorDispAttr /*P*/ VDA = getAttr(MSVtorDispAttr.class);
      if ((VDA != null)) {
        return VDA.getVtorDispMode();
      }
    }
    return MSVtorDispAttr.Mode.valueOf(getASTContext().getLangOpts().VtorDispMode);
  }


  
  /// \brief Determine whether this lambda expression was known to be dependent
  /// at the time it was created, even if its context does not appear to be
  /// dependent.
  ///
  /// This flag is a workaround for an issue with parsing, where default
  /// arguments are parsed before their enclosing function declarations have
  /// been created. This means that any lambda expressions within those
  /// default arguments will have as their DeclContext the context enclosing
  /// the function declaration, which may be non-dependent even when the
  /// function declaration itself is dependent. This flag indicates when we
  /// know that the lambda is dependent despite that.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::isDependentLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1712,
   FQN="clang::CXXRecordDecl::isDependentLambda", NM="_ZNK5clang13CXXRecordDecl17isDependentLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl17isDependentLambdaEv")
  //</editor-fold>
  public boolean isDependentLambda() /*const*/ {
    return isLambda() && getLambdaData().Dependent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::getLambdaTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1716,
   FQN="clang::CXXRecordDecl::getLambdaTypeInfo", NM="_ZNK5clang13CXXRecordDecl17getLambdaTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZNK5clang13CXXRecordDecl17getLambdaTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getLambdaTypeInfo() /*const*/ {
    return getLambdaData().MethodTyInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1720,
   FQN="clang::CXXRecordDecl::classof", NM="_ZN5clang13CXXRecordDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 1721,
   FQN="clang::CXXRecordDecl::classofKind", NM="_ZN5clang13CXXRecordDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstCXXRecord.getValue() && K.getValue() <= Kind.lastCXXRecord.getValue();
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  /*friend  class ASTRecordWriter*/
  /*friend  class ASTReader*/
  /*friend  class ASTWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXRecordDecl::~CXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 263,
   FQN="clang::CXXRecordDecl::~CXXRecordDecl", NM="_ZN5clang13CXXRecordDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZN5clang13CXXRecordDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return " as$CXXRecordDecl{" + "DefinitionData=" + DefinitionData // NOI18N
              + ", TemplateOrInstantiation=" + TemplateOrInstantiation +"}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}

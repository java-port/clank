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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.basic.BasicClangGlobals.*;


/// RecordDecl - Represents a struct/union/class.  For example:
///   struct X;                  // Forward declaration, no "body".
///   union Y { int A, B; };     // Has body with members A and B (FieldDecls).
/// This decl will be marked invalid if *any* members are invalid.
///
//<editor-fold defaultstate="collapsed" desc="clang::RecordDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3253,
 FQN="clang::RecordDecl", NM="_ZN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDeclE")
//</editor-fold>
public class RecordDecl extends /*public*/ TagDecl implements Destructors.ClassWithDestructor {
  // FIXME: This can be packed into the bitfields in Decl.
  /// HasFlexibleArrayMember - This is true if this struct ends with a flexible
  /// array member (e.g. int X[]) or if this union contains a struct that does.
  /// If so, this cannot be contained in arrays or other structs as a member.
  private /*JBIT bool*/ boolean HasFlexibleArrayMember /*: 1*/;
  
  /// AnonymousStructOrUnion - Whether this is the type of an anonymous struct
  /// or union.
  private /*JBIT bool*/ boolean AnonymousStructOrUnion /*: 1*/;
  
  /// HasObjectMember - This is true if this struct has at least one member
  /// containing an Objective-C object pointer type.
  private /*JBIT bool*/ boolean HasObjectMember /*: 1*/;
  
  /// HasVolatileMember - This is true if struct has at least one member of
  /// 'volatile' type.
  private /*JBIT bool*/ boolean HasVolatileMember /*: 1*/;
  
  /// \brief Whether the field declarations of this record have been loaded
  /// from external storage. To avoid unnecessary deserialization of
  /// methods/nested types we allow deserialization of just the fields
  /// when needed.
  /*friend*/protected/*private*/ /*mutable *//*JBIT bool*/ boolean LoadedFieldsFromExternalStorage /*: 1*/;
  /*friend  class DeclContext*/
/*protected:*/
  
  //===----------------------------------------------------------------------===//
  // RecordDecl Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::RecordDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3716,
   FQN="clang::RecordDecl::RecordDecl", NM="_ZN5clang10RecordDeclC1ENS_4Decl4KindENS_11TagTypeKindERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES9_PNS_14IdentifierInfoEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDeclC1ENS_4Decl4KindENS_11TagTypeKindERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES9_PNS_14IdentifierInfoEPS0_")
  //</editor-fold>
  protected RecordDecl(Kind DK, TagTypeKind TK, final /*const*/ ASTContext /*&*/ C, 
      DeclContext /*P*/ DC, SourceLocation StartLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
      RecordDecl /*P*/ PrevDecl) {
    // : TagDecl(DK, TK, C, DC, IdLoc, Id, PrevDecl, StartLoc) 
    //START JInit
    super(DK, TK, C, DC, new SourceLocation(IdLoc), Id, PrevDecl, new SourceLocation(StartLoc));
    //END JInit
    HasFlexibleArrayMember = false;
    AnonymousStructOrUnion = false;
    HasObjectMember = false;
    HasVolatileMember = false;
    LoadedFieldsFromExternalStorage = false;
    assert (classof((Decl)this)) : "Invalid Kind!";
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3729,
   FQN="clang::RecordDecl::Create", NM="_ZN5clang10RecordDecl6CreateERKNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl6CreateERKNS_10ASTContextENS_11TagTypeKindEPNS_11DeclContextENS_14SourceLocationES7_PNS_14IdentifierInfoEPS0_")
  //</editor-fold>
  public static RecordDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, TagTypeKind TK, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation IdLoc, 
        IdentifierInfo /*P*/ Id) {
    return Create(C, TK, DC, 
        StartLoc, IdLoc, 
        Id, (RecordDecl /*P*/ )null);
  }
  public static RecordDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, TagTypeKind TK, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, SourceLocation IdLoc, 
        IdentifierInfo /*P*/ Id, RecordDecl /*P*/ PrevDecl/*= null*/) {
    RecordDecl /*P*/ R = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new RecordDecl(Kind.Record, TK, C, DC, 
                new SourceLocation(StartLoc), new SourceLocation(IdLoc), Id, PrevDecl);
     });
    R.MayHaveOutOfDateDef = C.getLangOpts().Modules;
    
    C.getTypeDeclType(R, PrevDecl);
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3740,
   FQN="clang::RecordDecl::CreateDeserialized", NM="_ZN5clang10RecordDecl18CreateDeserializedERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl18CreateDeserializedERKNS_10ASTContextEj")
  //</editor-fold>
  public static RecordDecl /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ C, /*uint*/int ID) {
    RecordDecl /*P*/ R = /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new RecordDecl(Kind.Record, TagTypeKind.TTK_Struct, C, (DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, (RecordDecl /*P*/ )null);
     });
    R.MayHaveOutOfDateDef = C.getLangOpts().Modules;
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3290,
   FQN="clang::RecordDecl::getPreviousDecl", NM="_ZN5clang10RecordDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl15getPreviousDeclEv")
  //</editor-fold>
  public RecordDecl /*P*/ getPreviousDecl() {
    return cast_or_null_RecordDecl(/*JCast:TagDecl * */super.getPreviousDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::getPreviousDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3294,
   FQN="clang::RecordDecl::getPreviousDecl", NM="_ZNK5clang10RecordDecl15getPreviousDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl15getPreviousDeclEv")
  //</editor-fold>
  public /*const*/ RecordDecl /*P*/ getPreviousDecl$Const() /*const*/ {
    return ((/*const_cast*/RecordDecl /*P*/ )(this)).getPreviousDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3298,
   FQN="clang::RecordDecl::getMostRecentDecl", NM="_ZN5clang10RecordDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl17getMostRecentDeclEv")
  //</editor-fold>
  public RecordDecl /*P*/ getMostRecentDecl() {
    return cast_RecordDecl(/*JCast:TagDecl * */super.getMostRecentDecl$Redeclarable());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3301,
   FQN="clang::RecordDecl::getMostRecentDecl", NM="_ZNK5clang10RecordDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ RecordDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/RecordDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::hasFlexibleArrayMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3305,
   FQN="clang::RecordDecl::hasFlexibleArrayMember", NM="_ZNK5clang10RecordDecl22hasFlexibleArrayMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl22hasFlexibleArrayMemberEv")
  //</editor-fold>
  public boolean hasFlexibleArrayMember() /*const*/ {
    return HasFlexibleArrayMember;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::setHasFlexibleArrayMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3306,
   FQN="clang::RecordDecl::setHasFlexibleArrayMember", NM="_ZN5clang10RecordDecl25setHasFlexibleArrayMemberEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl25setHasFlexibleArrayMemberEb")
  //</editor-fold>
  public void setHasFlexibleArrayMember(boolean V) {
    HasFlexibleArrayMember = V;
  }

  
  /// isAnonymousStructOrUnion - Whether this is an anonymous struct
  /// or union. To be an anonymous struct or union, it must have been
  /// declared without a name and there must be no objects of this
  /// type declared, e.g.,
  /// @code
  ///   union { int i; float f; };
  /// @endcode
  /// is an anonymous union but neither of the following are:
  /// @code
  ///  union X { int i; float f; };
  ///  union { int i; float f; } obj;
  /// @endcode
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::isAnonymousStructOrUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3320,
   FQN="clang::RecordDecl::isAnonymousStructOrUnion", NM="_ZNK5clang10RecordDecl24isAnonymousStructOrUnionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl24isAnonymousStructOrUnionEv")
  //</editor-fold>
  public boolean isAnonymousStructOrUnion() /*const*/ {
    return AnonymousStructOrUnion;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::setAnonymousStructOrUnion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3321,
   FQN="clang::RecordDecl::setAnonymousStructOrUnion", NM="_ZN5clang10RecordDecl25setAnonymousStructOrUnionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl25setAnonymousStructOrUnionEb")
  //</editor-fold>
  public void setAnonymousStructOrUnion(boolean Anon) {
    AnonymousStructOrUnion = Anon;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::hasObjectMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3325,
   FQN="clang::RecordDecl::hasObjectMember", NM="_ZNK5clang10RecordDecl15hasObjectMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl15hasObjectMemberEv")
  //</editor-fold>
  public boolean hasObjectMember() /*const*/ {
    return HasObjectMember;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::setHasObjectMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3326,
   FQN="clang::RecordDecl::setHasObjectMember", NM="_ZN5clang10RecordDecl18setHasObjectMemberEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl18setHasObjectMemberEb")
  //</editor-fold>
  public void setHasObjectMember(boolean val) {
    HasObjectMember = val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::hasVolatileMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3328,
   FQN="clang::RecordDecl::hasVolatileMember", NM="_ZNK5clang10RecordDecl17hasVolatileMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl17hasVolatileMemberEv")
  //</editor-fold>
  public boolean hasVolatileMember() /*const*/ {
    return HasVolatileMember;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::setHasVolatileMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3329,
   FQN="clang::RecordDecl::setHasVolatileMember", NM="_ZN5clang10RecordDecl20setHasVolatileMemberEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl20setHasVolatileMemberEb")
  //</editor-fold>
  public void setHasVolatileMember(boolean val) {
    HasVolatileMember = val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::hasLoadedFieldsFromExternalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3331,
   FQN="clang::RecordDecl::hasLoadedFieldsFromExternalStorage", NM="_ZNK5clang10RecordDecl34hasLoadedFieldsFromExternalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl34hasLoadedFieldsFromExternalStorageEv")
  //</editor-fold>
  public boolean hasLoadedFieldsFromExternalStorage() /*const*/ {
    return LoadedFieldsFromExternalStorage;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::setHasLoadedFieldsFromExternalStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3334,
   FQN="clang::RecordDecl::setHasLoadedFieldsFromExternalStorage", NM="_ZN5clang10RecordDecl37setHasLoadedFieldsFromExternalStorageEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl37setHasLoadedFieldsFromExternalStorageEb")
  //</editor-fold>
  public void setHasLoadedFieldsFromExternalStorage(boolean val) {
    LoadedFieldsFromExternalStorage = val;
  }

  
  /// \brief Determines whether this declaration represents the
  /// injected class name.
  ///
  /// The injected class name in C++ is the name of the class that
  /// appears inside the class itself. For example:
  ///
  /// \code
  /// struct C {
  ///   // C is implicitly declared here as a synonym for the class name.
  /// };
  ///
  /// C::C c; // same as "C c;"
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::isInjectedClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3748,
   FQN="clang::RecordDecl::isInjectedClassName", NM="_ZNK5clang10RecordDecl19isInjectedClassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl19isInjectedClassNameEv")
  //</editor-fold>
  public boolean isInjectedClassName() /*const*/ {
    return isImplicit() && getDeclName().$bool() && getDeclContext$Const().isRecord()
       && $eq_DeclarationName(cast_RecordDecl(getDeclContext$Const()).getDeclName(), getDeclName());
  }

  
  /// \brief Determine whether this record is a class describing a lambda
  /// function object.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::isLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3753,
   FQN="clang::RecordDecl::isLambda", NM="_ZNK5clang10RecordDecl8isLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl8isLambdaEv")
  //</editor-fold>
  public boolean isLambda() /*const*/ {
    {
      /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(this);
      if ((RD != null)) {
        return RD.isLambda();
      }
    }
    return false;
  }

  
  /// \brief Determine whether this record is a record for captured variables in
  /// CapturedStmt construct.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::isCapturedRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3759,
   FQN="clang::RecordDecl::isCapturedRecord", NM="_ZNK5clang10RecordDecl16isCapturedRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl16isCapturedRecordEv")
  //</editor-fold>
  public boolean isCapturedRecord() /*const*/ {
    return hasAttr(CapturedRecordAttr.class);
  }

  /// \brief Mark the record as a record for captured variables in CapturedStmt
  /// construct.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::setCapturedRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3763,
   FQN="clang::RecordDecl::setCapturedRecord", NM="_ZN5clang10RecordDecl17setCapturedRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl17setCapturedRecordEv")
  //</editor-fold>
  public void setCapturedRecord() {
    addAttr(CapturedRecordAttr.CreateImplicit(getASTContext()));
  }

  
  /// getDefinition - Returns the RecordDecl that actually defines
  ///  this struct/union/class.  When determining whether or not a
  ///  struct/union/class is completely defined, one should use this
  ///  method as opposed to 'isCompleteDefinition'.
  ///  'isCompleteDefinition' indicates whether or not a specific
  ///  RecordDecl is a completed definition, not whether or not the
  ///  record type is defined.  This method returns NULL if there is
  ///  no RecordDecl that defines the struct/union/tag.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::getDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3372,
   FQN="clang::RecordDecl::getDefinition", NM="_ZNK5clang10RecordDecl13getDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl13getDefinitionEv")
  //</editor-fold>
  public RecordDecl /*P*/ getDefinition() /*const*/ {
    return cast_or_null_RecordDecl(super.getDefinition());
  }

  
  // Iterator access to field members. The field iterator only visits
  // the non-static data members of this class, ignoring any static
  // data members, functions, constructors, destructors, etc.
  /*typedef specific_decl_iterator<FieldDecl> field_iterator*/
//  public final class field_iterator extends specific_decl_iterator<FieldDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<FieldDecl> > field_range*/
//  public final class field_range extends iterator_range<FieldDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::fields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3382,
   FQN="clang::RecordDecl::fields", NM="_ZNK5clang10RecordDecl6fieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl6fieldsEv")
  //</editor-fold>
  public iterator_range<FieldDecl /*P*/ > fields() /*const*/ {
    return new iterator_range<FieldDecl /*P*/ >(field_begin(), field_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::field_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3767,
   FQN="clang::RecordDecl::field_begin", NM="_ZNK5clang10RecordDecl11field_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl11field_beginEv")
  //</editor-fold>
  public specific_decl_iterator<FieldDecl> field_begin() /*const*/ {
    if (hasExternalLexicalStorage() && !LoadedFieldsFromExternalStorage) {
      LoadFieldsFromExternalStorage();
    }
    
    return new specific_decl_iterator<FieldDecl>(FieldDecl.class, new decl_iterator($DeclContext$Fields().FirstDecl));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::field_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3385,
   FQN="clang::RecordDecl::field_end", NM="_ZNK5clang10RecordDecl9field_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl9field_endEv")
  //</editor-fold>
  public specific_decl_iterator<FieldDecl> field_end() /*const*/ {
    return new specific_decl_iterator<FieldDecl>(FieldDecl.class, new decl_iterator());
  }

  
  // field_empty - Whether there are any fields (non-static data
  // members) in this record.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::field_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3391,
   FQN="clang::RecordDecl::field_empty", NM="_ZNK5clang10RecordDecl11field_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl11field_emptyEv")
  //</editor-fold>
  public boolean field_empty() /*const*/ {
    return $eq_specific_decl_iterator$SpecificDecl$C(field_begin(), field_end());
  }

  
  /// completeDefinition - Notes that the definition of this type is
  /// now complete.
  
  /// completeDefinition - Notes that the definition of this type is now
  /// complete.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::completeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3776,
   FQN="clang::RecordDecl::completeDefinition", NM="_ZN5clang10RecordDecl18completeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl18completeDefinitionEv")
  //</editor-fold>
  public void completeDefinition() {
    assert (!isCompleteDefinition()) : "Cannot redefine record!";
    super.completeDefinition();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3399,
   FQN="clang::RecordDecl::classof", NM="_ZN5clang10RecordDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3400,
   FQN="clang::RecordDecl::classofKind", NM="_ZN5clang10RecordDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstRecord.getValue() && K.getValue() <= Kind.lastRecord.getValue();
  }

  
  /// isMsStrust - Get whether or not this is an ms_struct which can
  /// be turned on with an attribute, pragma, or -mms-bitfields
  /// commandline option.
  
  /// isMsStruct - Get whether or not this record uses ms_struct layout.
  /// This which can be turned on with an attribute, pragma, or the
  /// -mms-bitfields command-line option.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::isMsStruct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3784,
   FQN="clang::RecordDecl::isMsStruct", NM="_ZNK5clang10RecordDecl10isMsStructERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl10isMsStructERKNS_10ASTContextE")
  //</editor-fold>
  public boolean isMsStruct(final /*const*/ ASTContext /*&*/ C) /*const*/ {
    return hasAttr(MSStructAttr.class) || C.getLangOpts().MSBitfields == true;
  }

  
  /// \brief Whether we are allowed to insert extra padding between fields.
  /// These padding are added to help AddressSanitizer detect
  /// intra-object-overflow bugs.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::mayInsertExtraPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3814,
   FQN="clang::RecordDecl::mayInsertExtraPadding", NM="_ZNK5clang10RecordDecl21mayInsertExtraPaddingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl21mayInsertExtraPaddingEb")
  //</editor-fold>
  public boolean mayInsertExtraPadding() /*const*/ {
    return mayInsertExtraPadding(false);
  }
  public boolean mayInsertExtraPadding(boolean EmitRemark/*= false*/) /*const*/ {
    final ASTContext /*&*/ Context = getASTContext();
    if (!Context.getLangOpts().Sanitize.hasOneOf(SanitizerKind.Address | SanitizerKind.KernelAddress)
       || !(Context.getLangOpts().SanitizeAddressFieldPadding != 0)) {
      return false;
    }
    final /*const*/ SanitizerBlacklist /*&*/ Blacklist = Context.getSanitizerBlacklist();
    /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(this);
    // We may be able to relax some of these requirements.
    int ReasonToReject = -1;
    if (!(CXXRD != null) || CXXRD.isExternCContext()) {
      ReasonToReject = 0; // is not C++.
    } else if (CXXRD.hasAttr(PackedAttr.class)) {
      ReasonToReject = 1; // is packed.
    } else if (CXXRD.isUnion()) {
      ReasonToReject = 2; // is a union.
    } else if (CXXRD.isTriviallyCopyable()) {
      ReasonToReject = 3; // is trivially copyable.
    } else if (CXXRD.hasTrivialDestructor()) {
      ReasonToReject = 4; // has trivial destructor.
    } else if (CXXRD.isStandardLayout()) {
      ReasonToReject = 5; // is standard layout.
    } else if (Blacklist.isBlacklistedLocation(getLocation(), new StringRef(/*KEEP_STR*/"field-padding"))) {
      ReasonToReject = 6; // is in a blacklisted file.
    } else if (Blacklist.isBlacklistedType(new StringRef(getQualifiedNameAsString()), 
        new StringRef(/*KEEP_STR*/"field-padding"))) {
      ReasonToReject = 7; // is blacklisted.
    }
    if (EmitRemark) {
      if (ReasonToReject >= 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef($c$.track(Context.getDiagnostics().Report(getLocation(), 
                      diag.remark_sanitize_address_insert_extra_padding_rejected)), 
                  new StringRef(getQualifiedNameAsString())), ReasonToReject));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Context.getDiagnostics().Report(getLocation(), 
                  diag.remark_sanitize_address_insert_extra_padding_accepted)), 
              new StringRef(getQualifiedNameAsString())));
        } finally {
          $c$.$destroy();
        }
      }
    }
    return ReasonToReject < 0;
  }

  
  /// Finds the first data member which has a name.
  /// nullptr is returned if no named data member exists.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::findFirstNamedDataMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3857,
   FQN="clang::RecordDecl::findFirstNamedDataMember", NM="_ZNK5clang10RecordDecl24findFirstNamedDataMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl24findFirstNamedDataMemberEv")
  //</editor-fold>
  public /*const*/ FieldDecl /*P*/ findFirstNamedDataMember() /*const*/ {
    for (/*const*/ FieldDecl /*P*/ I : fields()) {
      if ((I.getIdentifier() != null)) {
        return I;
      }
      {
        
        /*const*/ RecordType /*P*/ RT = I.getType().$arrow().<RecordType>getAs$RecordType();
        if ((RT != null)) {
          {
            /*const*/ FieldDecl /*P*/ NamedDataMember = RT.getDecl().findFirstNamedDataMember();
            if ((NamedDataMember != null)) {
              return NamedDataMember;
            }
          }
        }
      }
    }
    
    // We didn't find a named data member.
    return null;
  }

/*private:*/
  /// \brief Deserialize just the fields.
  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::LoadFieldsFromExternalStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*unfold tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3788,
   FQN="clang::RecordDecl::LoadFieldsFromExternalStorage", NM="_ZNK5clang10RecordDecl29LoadFieldsFromExternalStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10RecordDecl29LoadFieldsFromExternalStorageEv")
  //</editor-fold>
  private void LoadFieldsFromExternalStorage() /*const*/ {
    ExternalASTSource.Deserializing TheFields = null;
    try {
      ExternalASTSource /*P*/ Source = getASTContext().getExternalSource();
      assert (hasExternalLexicalStorage() && (Source != null)) : "No external storage?";
      
      // Notify that we have a RecordDecl doing some initialization.
      TheFields/*J*/= new ExternalASTSource.Deserializing(Source);
      
      SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(64, null);
      LoadedFieldsFromExternalStorage = true;
      Source.FindExternalLexicalDecls(this, /*FuncArg*//*[]*/ (Decl.Kind K) -> {
                return FieldDecl.classofKind(K) || IndirectFieldDecl.classofKind(K);
              }, Decls);
      // Check that all decls we got were FieldDecls.
      for (/*uint*/int i = 0, e = Decls.size(); i != e; ++i)  {
        assert (isa_FieldDecl(Decls.$at(i)) || isa_IndirectFieldDecl(Decls.$at(i)));
      }
      if (Decls.empty()) {
        return;
      }

      // JAVA: unfold tie
//      std.tie($DeclContext$Fields().FirstDecl, $DeclContext$Fields().LastDecl).$assign(DeclContext.BuildDeclChain(new ArrayRef<Decl /*P*/ >(Decls, true), 
//              /*FieldsAlreadyLoaded=*/ false));
      pair<Decl, Decl> $BuildDeclChain = DeclContext.BuildDeclChain(new ArrayRef<Decl /*P*/ >(Decls, true), 
              /*FieldsAlreadyLoaded=*/ false);
      $DeclContext$Fields().FirstDecl = $BuildDeclChain.first;
      $DeclContext$Fields().LastDecl = $BuildDeclChain.second;
    } finally {
      if (TheFields != null) { TheFields.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RecordDecl::~RecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3253,
   FQN="clang::RecordDecl::~RecordDecl", NM="_ZN5clang10RecordDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10RecordDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return " as$RecordDecl{" + "HasFlexibleArrayMember=" + HasFlexibleArrayMember // NOI18N
              + ", AnonymousStructOrUnion=" + AnonymousStructOrUnion // NOI18N
              + ", HasObjectMember=" + HasObjectMember // NOI18N
              + ", HasVolatileMember=" + HasVolatileMember // NOI18N
              + ", LoadedFieldsFromExternalStorage=" + LoadedFieldsFromExternalStorage + "}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}

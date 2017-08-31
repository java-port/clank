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

package org.clang.ast.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.ItaniumMangleStatics.*;
import org.clang.basic.llvm.DenseMapInfoIdentifierInfo$Ptr;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 126,
 FQN="(anonymous namespace)::ItaniumMangleContextImpl", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImplE")
//</editor-fold>
public class ItaniumMangleContextImpl extends /*public*/ ItaniumMangleContext implements Destructors.ClassWithDestructor {
  /*typedef std::pair<const DeclContext *, IdentifierInfo *> DiscriminatorKeyTy*/
//  public final class DiscriminatorKeyTy extends std.pair</*const*/ DeclContext /*P*/ , IdentifierInfo /*P*/ >{ };
  private DenseMapTypeUInt<std.pair</*const*/ DeclContext /*P*/ , IdentifierInfo /*P*/ >> Discriminator;
  private DenseMapTypeUInt</*const*/ NamedDecl /*P*/ > Uniquifier;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::ItaniumMangleContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 132,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::ItaniumMangleContextImpl", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImplC1ERN5clang10ASTContextERNS1_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImplC1ERN5clang10ASTContextERNS1_17DiagnosticsEngineE")
  //</editor-fold>
  public /*explicit*/ ItaniumMangleContextImpl(final ASTContext /*&*/ Context, 
      final DiagnosticsEngine /*&*/ Diags) {
    // : ItaniumMangleContext(Context, Diags), Discriminator(), Uniquifier() 
    //START JInit
    super(Context, Diags);
    this.Discriminator = new DenseMapTypeUInt<std.pair</*const*/ DeclContext /*P*/ , IdentifierInfo /*P*/ >>(
            new DenseMapInfoPair(DenseMapInfo$LikePtr.$Info(), DenseMapInfoIdentifierInfo$Ptr.$Info()), 0);
    this.Uniquifier = new DenseMapTypeUInt</*const*/ NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }

  
  /// @name Mangler Entry Points
  /// @{
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::shouldMangleCXXName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 569,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::shouldMangleCXXName", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19shouldMangleCXXNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19shouldMangleCXXNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  @Override public boolean shouldMangleCXXName(/*const*/ NamedDecl /*P*/ D)/* override*/ {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      LanguageLinkage L = FD.getLanguageLinkage();
      // Overloadable functions need mangling.
      if (FD.hasAttr(OverloadableAttr.class)) {
        return true;
      }
      
      // "main" is not mangled.
      if (FD.isMain()) {
        return false;
      }
      
      // C++ functions and those whose names are not a simple identifier need
      // mangling.
      if (!FD.getDeclName().isIdentifier() || L == LanguageLinkage.CXXLanguageLinkage) {
        return true;
      }
      
      // C functions are not mangled.
      if (L == LanguageLinkage.CLanguageLinkage) {
        return false;
      }
    }
    
    // Otherwise, no mangling is done outside C++ mode.
    if (!getASTContext().getLangOpts().CPlusPlus) {
      return false;
    }
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      // C variables are not mangled.
      if (VD.isExternC()) {
        return false;
      }
      
      // Variables at global scope with non-internal linkage are not mangled
      /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(D);
      // Check for extern variable declared locally.
      if (DC.isFunctionOrMethod() && D.hasLinkage()) {
        while (!DC.isNamespace() && !DC.isTranslationUnit()) {
          DC = getEffectiveParentContext(DC);
        }
      }
      if (DC.isTranslationUnit() && D.getFormalLinkage() != Linkage.InternalLinkage
         && !CXXNameMangler.shouldHaveAbiTags(/*Deref*/this, VD)
         && !isa_VarTemplateSpecializationDecl(D)) {
        return false;
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::shouldMangleStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 140,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::shouldMangleStringLiteral", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl25shouldMangleStringLiteralEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl25shouldMangleStringLiteralEPKN5clang13StringLiteralE")
  //</editor-fold>
  @Override public boolean shouldMangleStringLiteral(/*const*/ StringLiteral /*P*/ $Prm0)/* override*/ {
    return false;
  }

  
  //
  
  /// Mangles the name of the declaration D and emits that name to the given
  /// output stream.
  ///
  /// If the declaration D requires a mangled name, this routine will emit that
  /// mangled name to \p os and return true. Otherwise, \p os will be unchanged
  /// and this routine will return false. In this case, the caller should just
  /// emit the identifier of the declaration (\c D->getIdentifier()) as its
  /// name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4461,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXName", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXNameEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXNameEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXName(/*const*/ NamedDecl /*P*/ D, 
               final raw_ostream /*&*/ Out)/* override*/ {
    PrettyStackTraceDecl CrashInfo = null;
    CXXNameMangler Mangler = null;
    try {
      assert ((isa_FunctionDecl(D) || isa_VarDecl(D))) : "Invalid mangleName() call, argument is not a variable or function!";
      assert (!isa_CXXConstructorDecl(D) && !isa_CXXDestructorDecl(D)) : "Invalid mangleName() call on 'structor decl!";
      
      CrashInfo/*J*/= new PrettyStackTraceDecl(D, new SourceLocation(), 
          getASTContext().getSourceManager(), 
          $("Mangling declaration"));
      
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out, D);
      Mangler.mangle(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4502,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleThunk", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl11mangleThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl11mangleThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
             final /*const*/ ThunkInfo /*&*/ Thunk, 
             final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      //  <special-name> ::= T <call-offset> <base encoding>
      //                      # base is the nominal target function of thunk
      //  <special-name> ::= Tc <call-offset> <call-offset> <base encoding>
      //                      # base is the nominal target function of thunk
      //                      # first call-offset is 'this' adjustment
      //                      # second call-offset is result adjustment
      assert (!isa_CXXDestructorDecl(MD)) : "Use mangleCXXDtor for destructor decls!";
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZT");
      if (!Thunk.Return.isEmpty()) {
        Mangler.getStream().$out_char($$c);
      }
      
      // Mangle the 'this' pointer adjustment.
      Mangler.mangleCallOffset(Thunk.This.NonVirtual, 
          Thunk.This.Virtual.Itanium.VCallOffsetOffset);
      
      // Mangle the return pointer adjustment if there is one.
      if (!Thunk.Return.isEmpty()) {
        Mangler.mangleCallOffset(Thunk.Return.NonVirtual, 
            Thunk.Return.Virtual.Itanium.VBaseOffsetOffset);
      }
      
      Mangler.mangleFunctionEncoding(MD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXDtorThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4531,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXDtorThunk", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl18mangleCXXDtorThunkEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERKNS1_14ThisAdjustmentERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl18mangleCXXDtorThunkEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERKNS1_14ThisAdjustmentERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXDtorThunk(/*const*/ CXXDestructorDecl /*P*/ DD, CXXDtorType Type, 
                    final /*const*/ ThisAdjustment /*&*/ $ThisAdjustment, final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      //  <special-name> ::= T <call-offset> <base encoding>
      //                      # base is the nominal target function of thunk
      Mangler/*J*/= new CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, /*Deref*/this, Out, DD, Type);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZT");
      
      // Mangle the 'this' pointer adjustment.
      Mangler.mangleCallOffset($ThisAdjustment.NonVirtual, 
          $ThisAdjustment.Virtual.Itanium.VCallOffsetOffset);
      
      Mangler.mangleFunctionEncoding(DD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleReferenceTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4614,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleReferenceTemporary", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl24mangleReferenceTemporaryEPKN5clang7VarDeclEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl24mangleReferenceTemporaryEPKN5clang7VarDeclEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleReferenceTemporary(/*const*/ VarDecl /*P*/ D, 
                          /*uint*/int ManglingNumber, 
                          final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // We match the GCC mangling here.
      //  <special-name> ::= GR <object name>
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZGR");
      Mangler.mangleName(D);
      assert ($greater_uint(ManglingNumber, 0)) : "Reference temporary mangling number is zero!";
      Mangler.mangleSeqID(ManglingNumber - 1);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4626,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXVTable", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl15mangleCXXVTableEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl15mangleCXXVTableEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXVTable(/*const*/ CXXRecordDecl /*P*/ RD, 
                 final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // <special-name> ::= TV <type>  # virtual table
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTV");
      Mangler.mangleNameOrStandardSubstitution(RD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXVTT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4634,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXVTT", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl12mangleCXXVTTEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl12mangleCXXVTTEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXVTT(/*const*/ CXXRecordDecl /*P*/ RD, 
              final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // <special-name> ::= TT <type>  # VTT structure
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTT");
      Mangler.mangleNameOrStandardSubstitution(RD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXCtorVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4642,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXCtorVTable", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleCXXCtorVTableEPKN5clang13CXXRecordDeclExS4_RN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleCXXCtorVTableEPKN5clang13CXXRecordDeclExS4_RN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXCtorVTable(/*const*/ CXXRecordDecl /*P*/ RD, 
                     long/*int64_t*/ Offset, 
                     /*const*/ CXXRecordDecl /*P*/ Type, 
                     final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // <special-name> ::= TC <type> <offset number> _ <base type>
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTC");
      Mangler.mangleNameOrStandardSubstitution(RD);
      Mangler.getStream().$out_llong(Offset);
      Mangler.getStream().$out_char($$UNDERSCORE);
      Mangler.mangleNameOrStandardSubstitution(Type);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXRTTI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4655,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXRTTI", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXRTTIEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXRTTIEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTI(QualType Ty, final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // <special-name> ::= TI <type>  # typeinfo structure
      assert (!Ty.hasQualifiers()) : "RTTI info cannot have top-level qualifiers";
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTI");
      Mangler.mangleType(new QualType(Ty));
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXRTTIName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4663,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXRTTIName", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl17mangleCXXRTTINameEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl17mangleCXXRTTINameEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTIName(QualType Ty, 
                   final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // <special-name> ::= TS <type>  # typeinfo name (null terminated byte string)
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTS");
      Mangler.mangleType(new QualType(Ty));
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4671,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleTypeName", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl14mangleTypeNameEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl14mangleTypeNameEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleTypeName(QualType Ty, final raw_ostream /*&*/ Out)/* override*/ {
    mangleCXXRTTIName(new QualType(Ty), Out);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4476,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXCtor", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXCtorEPKN5clang18CXXConstructorDeclENS1_11CXXCtorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXCtorEPKN5clang18CXXConstructorDeclENS1_11CXXCtorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXCtor(/*const*/ CXXConstructorDecl /*P*/ D, 
               CXXCtorType Type, 
               final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, /*Deref*/this, Out, D, Type);
      Mangler.mangle(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4483,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXDtor", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXDtorEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl13mangleCXXDtorEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXDtor(/*const*/ CXXDestructorDecl /*P*/ D, 
               CXXDtorType Type, 
               final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, /*Deref*/this, Out, D, Type);
      Mangler.mangle(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXCtorComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4490,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXCtorComdat", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleCXXCtorComdatEPKN5clang18CXXConstructorDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleCXXCtorComdatEPKN5clang18CXXConstructorDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXCtorComdat(/*const*/ CXXConstructorDecl /*P*/ D, 
                     final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, /*Deref*/this, Out, D, CXXCtorType.Ctor_Comdat);
      Mangler.mangle(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXDtorComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4496,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleCXXDtorComdat", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleCXXDtorComdatEPKN5clang17CXXDestructorDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleCXXDtorComdatEPKN5clang17CXXDestructorDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXDtorComdat(/*const*/ CXXDestructorDecl /*P*/ D, 
                     final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new CXXNameMangler(JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, /*Deref*/this, Out, D, CXXDtorType.Dtor_Comdat);
      Mangler.mangle(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  
  /// Returns the mangled name for a guard variable for the passed in VarDecl.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleStaticGuardVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4547,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleStaticGuardVariable", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl25mangleStaticGuardVariableEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl25mangleStaticGuardVariableEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleStaticGuardVariable(/*const*/ VarDecl /*P*/ D, 
                           final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      //  <special-name> ::= GV <object name>       # Guard variable for one-time
      //                                            # initialization
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      // GCC 5.3.0 doesn't emit derived ABI tags for local names but that seems to
      // be a bug that is fixed in trunk.
      Mangler.getStream().$out(/*KEEP_STR*/"_ZGV");
      Mangler.mangleName(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleDynamicInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4558,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleDynamicInitializer", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl24mangleDynamicInitializerEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl24mangleDynamicInitializerEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleDynamicInitializer(/*const*/ VarDecl /*P*/ MD, 
                          final raw_ostream /*&*/ Out)/* override*/ {
    // These symbols are internal in the Itanium ABI, so the names don't matter.
    // Clang has traditionally used this symbol and allowed LLVM to adjust it to
    // avoid duplicate symbols.
    Out.$out(/*KEEP_STR*/"__cxx_global_var_init");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleDynamicAtExitDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4566,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleDynamicAtExitDestructor", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl29mangleDynamicAtExitDestructorEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl29mangleDynamicAtExitDestructorEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleDynamicAtExitDestructor(/*const*/ VarDecl /*P*/ D, 
                               final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      // Prefix the mangling of D with __dtor_.
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"__dtor_");
      if (shouldMangleDeclName(D)) {
        Mangler.mangle(D);
      } else {
        Mangler.getStream().$out(D.getName());
      }
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleSEHFilterExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4577,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleSEHFilterExpression", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl25mangleSEHFilterExpressionEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl25mangleSEHFilterExpressionEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleSEHFilterExpression(/*const*/ NamedDecl /*P*/ EnclosingDecl, final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"__filt_");
      if (shouldMangleDeclName(EnclosingDecl)) {
        Mangler.mangle(EnclosingDecl);
      } else {
        Mangler.getStream().$out(EnclosingDecl.getName());
      }
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleSEHFinallyBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4587,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleSEHFinallyBlock", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl21mangleSEHFinallyBlockEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl21mangleSEHFinallyBlockEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleSEHFinallyBlock(/*const*/ NamedDecl /*P*/ EnclosingDecl, final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"__fin_");
      if (shouldMangleDeclName(EnclosingDecl)) {
        Mangler.mangle(EnclosingDecl);
      } else {
        Mangler.getStream().$out(EnclosingDecl.getName());
      }
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleItaniumThreadLocalInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4597,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleItaniumThreadLocalInit", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl28mangleItaniumThreadLocalInitEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl28mangleItaniumThreadLocalInitEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleItaniumThreadLocalInit(/*const*/ VarDecl /*P*/ D, 
                              final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      //  <special-name> ::= TH <object name>
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTH");
      Mangler.mangleName(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleItaniumThreadLocalWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4605,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleItaniumThreadLocalWrapper", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl31mangleItaniumThreadLocalWrapperEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl31mangleItaniumThreadLocalWrapperEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleItaniumThreadLocalWrapper(/*const*/ VarDecl /*P*/ D, 
                                 final raw_ostream /*&*/ Out)/* override*/ {
    CXXNameMangler Mangler = null;
    try {
      //  <special-name> ::= TW <object name>
      Mangler/*J*/= new CXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_ZTW");
      Mangler.mangleName(D);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::mangleStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4675,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::mangleStringLiteral", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleStringLiteralEPKN5clang13StringLiteralERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl19mangleStringLiteralEPKN5clang13StringLiteralERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleStringLiteral(/*const*/ StringLiteral /*P*/ $Prm0, final raw_ostream /*&*/ $Prm1)/* override*/ {
    throw new llvm_unreachable("Can't mangle string literals");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::getNextDiscriminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 179,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::getNextDiscriminator", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImpl20getNextDiscriminatorEPKN5clang9NamedDeclERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImpl20getNextDiscriminatorEPKN5clang9NamedDeclERj")
  //</editor-fold>
  public boolean getNextDiscriminator(/*const*/ NamedDecl /*P*/ ND, final uint$ref/*uint &*/ disc) {
    // Lambda closure types are already numbered.
    if (isLambda(ND)) {
      return false;
    }
    {
      
      // Anonymous tags are already numbered.
      /*const*/ TagDecl /*P*/ Tag = dyn_cast_TagDecl(ND);
      if ((Tag != null)) {
        if (Tag.getName().empty() && !(Tag.getTypedefNameForAnonDecl() != null)) {
          return false;
        }
      }
    }
    
    // Use the canonical number for externally visible decls.
    if (ND.isExternallyVisible()) {
      /*uint*/int discriminator = getASTContext().getManglingNumber(ND);
      if (discriminator == 1) {
        return false;
      }
      disc.$set(discriminator - 2);
      return true;
    }
    
    // Make up a reasonable number for internal decls.
    final uint$ref/*uint &*/ discriminator = Uniquifier.ref$at(ND);
    if (!(discriminator.$deref() != 0)) {
      /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(ND);
      discriminator.$set(Discriminator.ref$at(std.make_pair_Ptr_Ptr(DC, ND.getIdentifier())).$set$preDec());
    }
    if (discriminator.$deref() == 1) {
      return false;
    }
    disc.$set(discriminator.$deref() - 2);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumMangleContextImpl::~ItaniumMangleContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 126,
   FQN="(anonymous namespace)::ItaniumMangleContextImpl::~ItaniumMangleContextImpl", NM="_ZN12_GLOBAL__N_124ItaniumMangleContextImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_124ItaniumMangleContextImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Uniquifier.$destroy();
    Discriminator.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Discriminator=" + Discriminator // NOI18N
              + ", Uniquifier=" + Uniquifier // NOI18N
              + super.toString(); // NOI18N
  }
/// @}
}

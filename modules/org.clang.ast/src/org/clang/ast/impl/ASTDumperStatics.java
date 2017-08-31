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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTDumperStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEPKN5clang12RedeclarableIT_EE;Tpl__ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEPKN5clang9MergeableIT_EE;_ZL12dumpBasePathRN4llvm11raw_ostreamEPKN5clang8CastExprE;_ZL16dumpPreviousDeclRN4llvm11raw_ostreamEPKN5clang4DeclE;_ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEz;_ZN12_GLOBAL__N_1L10ValueColorE;_ZN12_GLOBAL__N_1L11IndentColorE;_ZN12_GLOBAL__N_1L12AddressColorE;_ZN12_GLOBAL__N_1L12CommentColorE;_ZN12_GLOBAL__N_1L13DeclNameColorE;_ZN12_GLOBAL__N_1L13LocationColorE;_ZN12_GLOBAL__N_1L14ValueKindColorE;_ZN12_GLOBAL__N_1L15ObjectKindColorE;_ZN12_GLOBAL__N_1L17DeclKindNameColorE;_ZN12_GLOBAL__N_1L19UndeserializedColorE;_ZN12_GLOBAL__N_1L9AttrColorE;_ZN12_GLOBAL__N_1L9CastColorE;_ZN12_GLOBAL__N_1L9NullColorE;_ZN12_GLOBAL__N_1L9StmtColorE;_ZN12_GLOBAL__N_1L9TypeColorE; -static-type=ASTDumperStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ASTDumperStatics {


// Red           - CastColor
// Green         - TypeColor
// Bold Green    - DeclKindNameColor, UndeserializedColor
// Yellow        - AddressColor, LocationColor
// Blue          - CommentColor, NullColor, IndentColor
// Bold Blue     - AttrColor
// Bold Magenta  - StmtColor
// Cyan          - ValueKindColor, ObjectKindColor
// Bold Cyan     - ValueColor, DeclNameColor

// Decl kind names (VarDecl, FunctionDecl, etc)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclKindNameColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 57,
 FQN="(anonymous namespace)::DeclKindNameColor", NM="_ZN12_GLOBAL__N_1L17DeclKindNameColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L17DeclKindNameColorE")
//</editor-fold>
public static /*const*/ TerminalColor DeclKindNameColor = new TerminalColor(raw_ostream.Colors.GREEN, true);
// Attr names (CleanupAttr, GuardedByAttr, etc)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AttrColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 59,
 FQN="(anonymous namespace)::AttrColor", NM="_ZN12_GLOBAL__N_1L9AttrColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L9AttrColorE")
//</editor-fold>
public static /*const*/ TerminalColor AttrColor = new TerminalColor(raw_ostream.Colors.BLUE, true);
// Statement names (DeclStmt, ImplicitCastExpr, etc)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StmtColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 61,
 FQN="(anonymous namespace)::StmtColor", NM="_ZN12_GLOBAL__N_1L9StmtColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L9StmtColorE")
//</editor-fold>
public static /*const*/ TerminalColor StmtColor = new TerminalColor(raw_ostream.Colors.MAGENTA, true);
// Comment names (FullComment, ParagraphComment, TextComment, etc)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommentColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 63,
 FQN="(anonymous namespace)::CommentColor", NM="_ZN12_GLOBAL__N_1L12CommentColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L12CommentColorE")
//</editor-fold>
public static /*const*/ TerminalColor CommentColor = new TerminalColor(raw_ostream.Colors.BLUE, false);

// Type names (int, float, etc, plus user defined types)
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 66,
 FQN="(anonymous namespace)::TypeColor", NM="_ZN12_GLOBAL__N_1L9TypeColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L9TypeColorE")
//</editor-fold>
public static /*const*/ TerminalColor TypeColor = new TerminalColor(raw_ostream.Colors.GREEN, false);

// Pointer address
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddressColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 69,
 FQN="(anonymous namespace)::AddressColor", NM="_ZN12_GLOBAL__N_1L12AddressColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L12AddressColorE")
//</editor-fold>
public static /*const*/ TerminalColor AddressColor = new TerminalColor(raw_ostream.Colors.YELLOW, false);
// Source locations
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocationColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 71,
 FQN="(anonymous namespace)::LocationColor", NM="_ZN12_GLOBAL__N_1L13LocationColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L13LocationColorE")
//</editor-fold>
public static /*const*/ TerminalColor LocationColor = new TerminalColor(raw_ostream.Colors.YELLOW, false);

// lvalue/xvalue
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ValueKindColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 74,
 FQN="(anonymous namespace)::ValueKindColor", NM="_ZN12_GLOBAL__N_1L14ValueKindColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L14ValueKindColorE")
//</editor-fold>
public static /*const*/ TerminalColor ValueKindColor = new TerminalColor(raw_ostream.Colors.CYAN, false);
// bitfield/objcproperty/objcsubscript/vectorcomponent
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectKindColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 76,
 FQN="(anonymous namespace)::ObjectKindColor", NM="_ZN12_GLOBAL__N_1L15ObjectKindColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L15ObjectKindColorE")
//</editor-fold>
public static /*const*/ TerminalColor ObjectKindColor = new TerminalColor(raw_ostream.Colors.CYAN, false);

// Null statements
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NullColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 79,
 FQN="(anonymous namespace)::NullColor", NM="_ZN12_GLOBAL__N_1L9NullColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L9NullColorE")
//</editor-fold>
public static /*const*/ TerminalColor NullColor = new TerminalColor(raw_ostream.Colors.BLUE, false);

// Undeserialized entities
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndeserializedColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 82,
 FQN="(anonymous namespace)::UndeserializedColor", NM="_ZN12_GLOBAL__N_1L19UndeserializedColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L19UndeserializedColorE")
//</editor-fold>
public static /*const*/ TerminalColor UndeserializedColor = new TerminalColor(raw_ostream.Colors.GREEN, true);

// CastKind from CastExpr's
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 85,
 FQN="(anonymous namespace)::CastColor", NM="_ZN12_GLOBAL__N_1L9CastColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L9CastColorE")
//</editor-fold>
public static /*const*/ TerminalColor CastColor = new TerminalColor(raw_ostream.Colors.RED, false);

// Value of the statement
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ValueColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 88,
 FQN="(anonymous namespace)::ValueColor", NM="_ZN12_GLOBAL__N_1L10ValueColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L10ValueColorE")
//</editor-fold>
public static /*const*/ TerminalColor ValueColor = new TerminalColor(raw_ostream.Colors.CYAN, true);
// Decl names
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclNameColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 90,
 FQN="(anonymous namespace)::DeclNameColor", NM="_ZN12_GLOBAL__N_1L13DeclNameColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L13DeclNameColorE")
//</editor-fold>
public static /*const*/ TerminalColor DeclNameColor = new TerminalColor(raw_ostream.Colors.CYAN, true);

// Indents ( `, -. | )
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IndentColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 93,
 FQN="(anonymous namespace)::IndentColor", NM="_ZN12_GLOBAL__N_1L11IndentColorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN12_GLOBAL__N_1L11IndentColorE")
//</editor-fold>
public static /*const*/ TerminalColor IndentColor = new TerminalColor(raw_ostream.Colors.BLUE, false);
//<editor-fold defaultstate="collapsed" desc="dumpPreviousDeclImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 858,
 FQN="dumpPreviousDeclImpl", NM="_ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEz",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEz")
//</editor-fold>
public static void dumpPreviousDeclImpl(final raw_ostream /*&*/ OS, Object ... $VarArg) {
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="dumpPreviousDeclImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*instantiation prints Hex*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 861,
 FQN="dumpPreviousDeclImpl", NM="Tpl__ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEPKN5clang9MergeableIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEPKN5clang9MergeableIT_EE")
//</editor-fold>
public static </*typename*/ T extends NamedDecl & Mergeable> void dumpPreviousDeclImpl$T(final raw_ostream /*&*/ OS, /*const*/ Mergeable<T> /*P*/ D) {
  /*const*/ T /*P*/ First = D.getFirstDecl();
  if (Native.$noteq(First, D)) {
     OS.$out(/*KEEP_STR*/" prev ").$out(First);
  }
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="dumpPreviousDeclImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*instantiation prints Hex*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 868,
 FQN="dumpPreviousDeclImpl", NM="Tpl__ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEPKN5clang12RedeclarableIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=Tpl__ZL20dumpPreviousDeclImplRN4llvm11raw_ostreamEPKN5clang12RedeclarableIT_EE")
//</editor-fold>
public static </*typename*/ T extends NamedDecl & Redeclarable> void dumpPreviousDeclImpl$T(final raw_ostream /*&*/ OS, /*const*/ Redeclarable<T> /*P*/ D) {
  /*const*/ T /*P*/ Prev = D.getPreviousDecl();
  if (Prev != null) {
     OS.$out(/*KEEP_STR*/" prev ").$out(Prev);
  }
}


/// Dump the previous declaration in the redeclaration chain for a declaration,
/// if any.
//<editor-fold defaultstate="collapsed" desc="dumpPreviousDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 876,
 FQN="dumpPreviousDecl", NM="_ZL16dumpPreviousDeclRN4llvm11raw_ostreamEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZL16dumpPreviousDeclRN4llvm11raw_ostreamEPKN5clang4DeclE")
//</editor-fold>
public static void dumpPreviousDecl(final raw_ostream /*&*/ OS, /*const*/ Decl /*P*/ D) {
  switch (D.getKind()) {
   case AccessSpec:
    dumpPreviousDeclImpl(OS, cast_AccessSpecDecl(D));
    /*JAVA:return*/return;
   case Block:
    dumpPreviousDeclImpl(OS, cast_BlockDecl(D));
    /*JAVA:return*/return;
   case Captured:
    dumpPreviousDeclImpl(OS, cast_CapturedDecl(D));
    /*JAVA:return*/return;
   case ClassScopeFunctionSpecialization:
    dumpPreviousDeclImpl(OS, cast_ClassScopeFunctionSpecializationDecl(D));
    /*JAVA:return*/return;
   case Empty:
    dumpPreviousDeclImpl(OS, cast_EmptyDecl(D));
    /*JAVA:return*/return;
   case ExternCContext:
    dumpPreviousDeclImpl(OS, cast_ExternCContextDecl(D));
    /*JAVA:return*/return;
   case FileScopeAsm:
    dumpPreviousDeclImpl(OS, cast_FileScopeAsmDecl(D));
    /*JAVA:return*/return;
   case Friend:
    dumpPreviousDeclImpl(OS, cast_FriendDecl(D));
    /*JAVA:return*/return;
   case FriendTemplate:
    dumpPreviousDeclImpl(OS, cast_FriendTemplateDecl(D));
    /*JAVA:return*/return;
   case Import:
    dumpPreviousDeclImpl(OS, cast_ImportDecl(D));
    /*JAVA:return*/return;
   case LinkageSpec:
    dumpPreviousDeclImpl(OS, cast_LinkageSpecDecl(D));
    /*JAVA:return*/return;
   case Label:
    dumpPreviousDeclImpl(OS, cast_LabelDecl(D));
    /*JAVA:return*/return;
   case Namespace:
    dumpPreviousDeclImpl$T(OS, cast_NamespaceDecl(D));
    /*JAVA:return*/return;
   case NamespaceAlias:
    dumpPreviousDeclImpl$T(OS, cast_NamespaceAliasDecl(D));
    /*JAVA:return*/return;
   case ObjCCompatibleAlias:
    dumpPreviousDeclImpl(OS, cast_ObjCCompatibleAliasDecl(D));
    /*JAVA:return*/return;
   case ObjCCategory:
    dumpPreviousDeclImpl(OS, cast_ObjCCategoryDecl(D));
    /*JAVA:return*/return;
   case ObjCCategoryImpl:
    dumpPreviousDeclImpl(OS, cast_ObjCCategoryImplDecl(D));
    /*JAVA:return*/return;
   case ObjCImplementation:
    dumpPreviousDeclImpl(OS, cast_ObjCImplementationDecl(D));
    /*JAVA:return*/return;
   case ObjCInterface:
    dumpPreviousDeclImpl$T(OS, cast_ObjCInterfaceDecl(D));
    /*JAVA:return*/return;
   case ObjCProtocol:
    dumpPreviousDeclImpl$T(OS, cast_ObjCProtocolDecl(D));
    /*JAVA:return*/return;
   case ObjCMethod:
    dumpPreviousDeclImpl(OS, cast_ObjCMethodDecl(D));
    /*JAVA:return*/return;
   case ObjCProperty:
    dumpPreviousDeclImpl(OS, cast_ObjCPropertyDecl(D));
    /*JAVA:return*/return;
   case BuiltinTemplate:
    dumpPreviousDeclImpl(OS, cast_BuiltinTemplateDecl(D));
    /*JAVA:return*/return;
   case ClassTemplate:
    dumpPreviousDeclImpl$T(OS, cast_ClassTemplateDecl(D));
    /*JAVA:return*/return;
   case FunctionTemplate:
    dumpPreviousDeclImpl$T(OS, cast_FunctionTemplateDecl(D));
    /*JAVA:return*/return;
   case TypeAliasTemplate:
    dumpPreviousDeclImpl$T(OS, cast_TypeAliasTemplateDecl(D));
    /*JAVA:return*/return;
   case VarTemplate:
    dumpPreviousDeclImpl$T(OS, cast_VarTemplateDecl(D));
    /*JAVA:return*/return;
   case TemplateTemplateParm:
    dumpPreviousDeclImpl(OS, cast_TemplateTemplateParmDecl(D));
    /*JAVA:return*/return;
   case Enum:
    dumpPreviousDeclImpl$T(OS, cast_EnumDecl(D));
    /*JAVA:return*/return;
   case Record:
    dumpPreviousDeclImpl$T(OS, cast_RecordDecl(D));
    /*JAVA:return*/return;
   case CXXRecord:
    dumpPreviousDeclImpl$T(OS, cast_CXXRecordDecl(D));
    /*JAVA:return*/return;
   case ClassTemplateSpecialization:
    dumpPreviousDeclImpl$T(OS, cast_ClassTemplateSpecializationDecl(D));
    /*JAVA:return*/return;
   case ClassTemplatePartialSpecialization:
    dumpPreviousDeclImpl$T(OS, cast_ClassTemplatePartialSpecializationDecl(D));
    /*JAVA:return*/return;
   case TemplateTypeParm:
    dumpPreviousDeclImpl(OS, cast_TemplateTypeParmDecl(D));
    /*JAVA:return*/return;
   case ObjCTypeParam:
    dumpPreviousDeclImpl$T(OS, cast_ObjCTypeParamDecl(D));
    /*JAVA:return*/return;
   case TypeAlias:
    dumpPreviousDeclImpl$T(OS, cast_TypeAliasDecl(D));
    /*JAVA:return*/return;
   case Typedef:
    dumpPreviousDeclImpl$T(OS, cast_TypedefDecl(D));
    /*JAVA:return*/return;
   case UnresolvedUsingTypename:
    dumpPreviousDeclImpl$T(OS, cast_UnresolvedUsingTypenameDecl(D));
    /*JAVA:return*/return;
   case Using:
    dumpPreviousDeclImpl$T(OS, cast_UsingDecl(D));
    /*JAVA:return*/return;
   case UsingDirective:
    dumpPreviousDeclImpl(OS, cast_UsingDirectiveDecl(D));
    /*JAVA:return*/return;
   case UsingShadow:
    dumpPreviousDeclImpl$T(OS, cast_UsingShadowDecl(D));
    /*JAVA:return*/return;
   case ConstructorUsingShadow:
    dumpPreviousDeclImpl$T(OS, cast_ConstructorUsingShadowDecl(D));
    /*JAVA:return*/return;
   case Field:
    dumpPreviousDeclImpl$T(OS, cast_FieldDecl(D));
    /*JAVA:return*/return;
   case ObjCAtDefsField:
    dumpPreviousDeclImpl$T(OS, cast_ObjCAtDefsFieldDecl(D));
    /*JAVA:return*/return;
   case ObjCIvar:
    dumpPreviousDeclImpl$T(OS, cast_ObjCIvarDecl(D));
    /*JAVA:return*/return;
   case Function:
    dumpPreviousDeclImpl$T(OS, cast_FunctionDecl(D));
    /*JAVA:return*/return;
   case CXXMethod:
    dumpPreviousDeclImpl$T(OS, cast_CXXMethodDecl(D));
    /*JAVA:return*/return;
   case CXXConstructor:
    dumpPreviousDeclImpl$T(OS, cast_CXXConstructorDecl(D));
    /*JAVA:return*/return;
   case CXXConversion:
    dumpPreviousDeclImpl$T(OS, cast_CXXConversionDecl(D));
    /*JAVA:return*/return;
   case CXXDestructor:
    dumpPreviousDeclImpl$T(OS, cast_CXXDestructorDecl(D));
    /*JAVA:return*/return;
   case MSProperty:
    dumpPreviousDeclImpl(OS, cast_MSPropertyDecl(D));
    /*JAVA:return*/return;
   case NonTypeTemplateParm:
    dumpPreviousDeclImpl(OS, cast_NonTypeTemplateParmDecl(D));
    /*JAVA:return*/return;
   case Var:
    dumpPreviousDeclImpl$T(OS, cast_VarDecl(D));
    /*JAVA:return*/return;
   case ImplicitParam:
    dumpPreviousDeclImpl$T(OS, cast_ImplicitParamDecl(D));
    /*JAVA:return*/return;
   case OMPCapturedExpr:
    dumpPreviousDeclImpl$T(OS, cast_OMPCapturedExprDecl(D));
    /*JAVA:return*/return;
   case ParmVar:
    dumpPreviousDeclImpl$T(OS, cast_ParmVarDecl(D));
    /*JAVA:return*/return;
   case VarTemplateSpecialization:
    dumpPreviousDeclImpl$T(OS, cast_VarTemplateSpecializationDecl(D));
    /*JAVA:return*/return;
   case VarTemplatePartialSpecialization:
    dumpPreviousDeclImpl$T(OS, cast_VarTemplatePartialSpecializationDecl(D));
    /*JAVA:return*/return;
   case EnumConstant:
    dumpPreviousDeclImpl$T(OS, cast_EnumConstantDecl(D));
    /*JAVA:return*/return;
   case IndirectField:
    dumpPreviousDeclImpl$T(OS, cast_IndirectFieldDecl(D));
    /*JAVA:return*/return;
   case OMPDeclareReduction:
    dumpPreviousDeclImpl(OS, cast_OMPDeclareReductionDecl(D));
    /*JAVA:return*/return;
   case UnresolvedUsingValue:
    dumpPreviousDeclImpl$T(OS, cast_UnresolvedUsingValueDecl(D));
    /*JAVA:return*/return;
   case OMPThreadPrivate:
    dumpPreviousDeclImpl(OS, cast_OMPThreadPrivateDecl(D));
    /*JAVA:return*/return;
   case ObjCPropertyImpl:
    dumpPreviousDeclImpl(OS, cast_ObjCPropertyImplDecl(D));
    /*JAVA:return*/return;
   case PragmaComment:
    dumpPreviousDeclImpl(OS, cast_PragmaCommentDecl(D));
    /*JAVA:return*/return;
   case PragmaDetectMismatch:
    dumpPreviousDeclImpl(OS, cast_PragmaDetectMismatchDecl(D));
    /*JAVA:return*/return;
   case StaticAssert:
    dumpPreviousDeclImpl(OS, cast_StaticAssertDecl(D));
    /*JAVA:return*/return;
   case TranslationUnit:
    dumpPreviousDeclImpl(OS, cast_TranslationUnitDecl(D));
    /*JAVA:return*/return;
  }
  throw new llvm_unreachable("Decl that isn't part of DeclNodes.inc!");
}

//<editor-fold defaultstate="collapsed" desc="dumpBasePath">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 1886,
 FQN="dumpBasePath", NM="_ZL12dumpBasePathRN4llvm11raw_ostreamEPKN5clang8CastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZL12dumpBasePathRN4llvm11raw_ostreamEPKN5clang8CastExprE")
//</editor-fold>
public static void dumpBasePath(final raw_ostream /*&*/ OS, /*const*/ CastExpr /*P*/ Node) {
  if (Node.path_empty()) {
    return;
  }
  
  OS.$out(/*KEEP_STR*/" (");
  boolean First = true;
  for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> I = $tryClone(Node.path_begin$Const()), 
       E = $tryClone(Node.path_end$Const());
       $noteq_ptr(I, E); I.$preInc()) {
    /*const*/ CXXBaseSpecifier /*P*/ Base = I.$star();
    if (!First) {
      OS.$out(/*KEEP_STR*/" -> ");
    }
    
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(Base.getType().$arrow().<RecordType>getAs$RecordType().getDecl());
    if (Base.isVirtual()) {
      OS.$out(/*KEEP_STR*/"virtual ");
    }
    OS.$out(RD.getName());
    First = false;
  }
  
  OS.$out_char($$RPAREN);
}

} // END OF class ASTDumperStatics

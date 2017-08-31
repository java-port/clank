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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.ASTImporterStatics.*;
import static org.clang.ast.java.AstManualRTTI.cast_or_null_CXXCtorInitializer;

//<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 28,
 FQN="clang::ASTNodeImporter", NM="_ZN5clang15ASTNodeImporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporterE")
//</editor-fold>
public class ASTNodeImporter implements /*public*/ TypeVisitor<ASTNodeImporter, QualType>, /*public*/ DeclVisitor<ASTNodeImporter, Decl /*P*/ >, /*public*/ StmtVisitor<ASTNodeImporter, Stmt /*P*/ > {
  private final ASTImporter /*&*/ Importer;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ASTNodeImporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 34,
   FQN="clang::ASTNodeImporter::ASTNodeImporter", NM="_ZN5clang15ASTNodeImporterC1ERNS_11ASTImporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporterC1ERNS_11ASTImporterE")
  //</editor-fold>
  public /*explicit*/ ASTNodeImporter(final ASTImporter /*&*/ Importer) {
    // : TypeVisitor<ASTNodeImporter, QualType>(), DeclVisitor<ASTNodeImporter, Decl * >(), StmtVisitor<ASTNodeImporter, Stmt * >(), Importer(Importer) 
    //START JInit
    $TypeVisitor();
    $DeclVisitor();
    $StmtVisitor();
    this./*&*/Importer=/*&*/Importer;
    //END JInit
  }

  
  //JAVA: using TypeVisitor<ASTNodeImporter, QualType>::Visit;
  //JAVA: using DeclVisitor<ASTNodeImporter, Decl /*P*/ >::Visit;
  //JAVA: using StmtVisitor<ASTNodeImporter, Stmt /*P*/ >::Visit;
  
  // Importing types
  
  //----------------------------------------------------------------------------
  // Import Types
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1546,
   FQN="clang::ASTNodeImporter::VisitType", NM="_ZN5clang15ASTNodeImporter9VisitTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter9VisitTypeEPKNS_4TypeE")
  //</editor-fold>
  public QualType VisitType(/*const*/ Type /*P*/ T) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Importer.FromDiag(new SourceLocation(), diag.err_unsupported_ast_node)), 
          T.getTypeClassName()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitBuiltinType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1552,
   FQN="clang::ASTNodeImporter::VisitBuiltinType", NM="_ZN5clang15ASTNodeImporter16VisitBuiltinTypeEPKNS_11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitBuiltinTypeEPKNS_11BuiltinTypeE")
  //</editor-fold>
  public QualType VisitBuiltinType(/*const*/ BuiltinType /*P*/ T) {
    switch (T.getKind()) {
     case OCLImage1dRO:
      return Importer.getToContext().OCLImage1dROTy.$QualType();
     case OCLImage1dArrayRO:
      return Importer.getToContext().OCLImage1dArrayROTy.$QualType();
     case OCLImage1dBufferRO:
      return Importer.getToContext().OCLImage1dBufferROTy.$QualType();
     case OCLImage2dRO:
      return Importer.getToContext().OCLImage2dROTy.$QualType();
     case OCLImage2dArrayRO:
      return Importer.getToContext().OCLImage2dArrayROTy.$QualType();
     case OCLImage2dDepthRO:
      return Importer.getToContext().OCLImage2dDepthROTy.$QualType();
     case OCLImage2dArrayDepthRO:
      return Importer.getToContext().OCLImage2dArrayDepthROTy.$QualType();
     case OCLImage2dMSAARO:
      return Importer.getToContext().OCLImage2dMSAAROTy.$QualType();
     case OCLImage2dArrayMSAARO:
      return Importer.getToContext().OCLImage2dArrayMSAAROTy.$QualType();
     case OCLImage2dMSAADepthRO:
      return Importer.getToContext().OCLImage2dMSAADepthROTy.$QualType();
     case OCLImage2dArrayMSAADepthRO:
      return Importer.getToContext().OCLImage2dArrayMSAADepthROTy.$QualType();
     case OCLImage3dRO:
      return Importer.getToContext().OCLImage3dROTy.$QualType();
     case OCLImage1dWO:
      return Importer.getToContext().OCLImage1dWOTy.$QualType();
     case OCLImage1dArrayWO:
      return Importer.getToContext().OCLImage1dArrayWOTy.$QualType();
     case OCLImage1dBufferWO:
      return Importer.getToContext().OCLImage1dBufferWOTy.$QualType();
     case OCLImage2dWO:
      return Importer.getToContext().OCLImage2dWOTy.$QualType();
     case OCLImage2dArrayWO:
      return Importer.getToContext().OCLImage2dArrayWOTy.$QualType();
     case OCLImage2dDepthWO:
      return Importer.getToContext().OCLImage2dDepthWOTy.$QualType();
     case OCLImage2dArrayDepthWO:
      return Importer.getToContext().OCLImage2dArrayDepthWOTy.$QualType();
     case OCLImage2dMSAAWO:
      return Importer.getToContext().OCLImage2dMSAAWOTy.$QualType();
     case OCLImage2dArrayMSAAWO:
      return Importer.getToContext().OCLImage2dArrayMSAAWOTy.$QualType();
     case OCLImage2dMSAADepthWO:
      return Importer.getToContext().OCLImage2dMSAADepthWOTy.$QualType();
     case OCLImage2dArrayMSAADepthWO:
      return Importer.getToContext().OCLImage2dArrayMSAADepthWOTy.$QualType();
     case OCLImage3dWO:
      return Importer.getToContext().OCLImage3dWOTy.$QualType();
     case OCLImage1dRW:
      return Importer.getToContext().OCLImage1dRWTy.$QualType();
     case OCLImage1dArrayRW:
      return Importer.getToContext().OCLImage1dArrayRWTy.$QualType();
     case OCLImage1dBufferRW:
      return Importer.getToContext().OCLImage1dBufferRWTy.$QualType();
     case OCLImage2dRW:
      return Importer.getToContext().OCLImage2dRWTy.$QualType();
     case OCLImage2dArrayRW:
      return Importer.getToContext().OCLImage2dArrayRWTy.$QualType();
     case OCLImage2dDepthRW:
      return Importer.getToContext().OCLImage2dDepthRWTy.$QualType();
     case OCLImage2dArrayDepthRW:
      return Importer.getToContext().OCLImage2dArrayDepthRWTy.$QualType();
     case OCLImage2dMSAARW:
      return Importer.getToContext().OCLImage2dMSAARWTy.$QualType();
     case OCLImage2dArrayMSAARW:
      return Importer.getToContext().OCLImage2dArrayMSAARWTy.$QualType();
     case OCLImage2dMSAADepthRW:
      return Importer.getToContext().OCLImage2dMSAADepthRWTy.$QualType();
     case OCLImage2dArrayMSAADepthRW:
      return Importer.getToContext().OCLImage2dArrayMSAADepthRWTy.$QualType();
     case OCLImage3dRW:
      return Importer.getToContext().OCLImage3dRWTy.$QualType();
     case Void:
      
      //===- Builtin Types ------------------------------------------------------===//
      
      // void
      return Importer.getToContext().VoidTy.$QualType();
     case Bool:
      
      //===- Unsigned Types -----------------------------------------------------===//
      
      // 'bool' in C++, '_Bool' in C99
      return Importer.getToContext().BoolTy.$QualType();
     case UChar:
      
      // 'unsigned char', explicitly qualified
      return Importer.getToContext().UnsignedCharTy.$QualType();
     case Char16:
      
      // 'char16_t' in C++
      return Importer.getToContext().Char16Ty.$QualType();
     case Char32:
      
      // 'char32_t' in C++
      return Importer.getToContext().Char32Ty.$QualType();
     case UShort:
      
      // 'unsigned short'
      return Importer.getToContext().UnsignedShortTy.$QualType();
     case UInt:
      
      // 'unsigned int'
      return Importer.getToContext().UnsignedIntTy.$QualType();
     case ULong:
      
      // 'unsigned long'
      return Importer.getToContext().UnsignedLongTy.$QualType();
     case ULongLong:
      
      // 'unsigned long long'
      return Importer.getToContext().UnsignedLongLongTy.$QualType();
     case UInt128:
      
      // '__uint128_t'
      return Importer.getToContext().UnsignedInt128Ty.$QualType();
     case SChar:
      
      // 'signed char', explicitly qualified
      return Importer.getToContext().SignedCharTy.$QualType();
     case Short:
      
      // 'short' or 'signed short'
      return Importer.getToContext().ShortTy.$QualType();
     case Int:
      
      // 'int' or 'signed int'
      return Importer.getToContext().IntTy.$QualType();
     case Long:
      
      // 'long' or 'signed long'
      return Importer.getToContext().LongTy.$QualType();
     case LongLong:
      
      // 'long long' or 'signed long long'
      return Importer.getToContext().LongLongTy.$QualType();
     case Int128:
      
      // '__int128_t'
      return Importer.getToContext().Int128Ty.$QualType();
     case Half:
      
      //===- Floating point types -----------------------------------------------===//
      
      // 'half' in OpenCL, '__fp16' in ARM NEON.
      return Importer.getToContext().HalfTy.$QualType();
     case Float:
      
      // 'float'
      return Importer.getToContext().FloatTy.$QualType();
     case Double:
      
      // 'double'
      return Importer.getToContext().DoubleTy.$QualType();
     case LongDouble:
      
      // 'long double'
      return Importer.getToContext().LongDoubleTy.$QualType();
     case Float128:
      
      // '__float128'
      return Importer.getToContext().Float128Ty.$QualType();
     case NullPtr:
      
      //===- Language-specific types --------------------------------------------===//
      
      // This is the type of C++0x 'nullptr'.
      return Importer.getToContext().NullPtrTy.$QualType();
     case ObjCId:
      
      // The primitive Objective C 'id' type.  The user-visible 'id'
      // type is a typedef of an ObjCObjectPointerType to an
      // ObjCObjectType with this as its base.  In fact, this only ever
      // shows up in an AST as the base type of an ObjCObjectType.
      return Importer.getToContext().ObjCBuiltinIdTy.$QualType();
     case ObjCClass:
      
      // The primitive Objective C 'Class' type.  The user-visible
      // 'Class' type is a typedef of an ObjCObjectPointerType to an
      // ObjCObjectType with this as its base.  In fact, this only ever
      // shows up in an AST as the base type of an ObjCObjectType.
      return Importer.getToContext().ObjCBuiltinClassTy.$QualType();
     case ObjCSel:
      
      // The primitive Objective C 'SEL' type.  The user-visible 'SEL'
      // type is a typedef of a PointerType to this.
      return Importer.getToContext().ObjCBuiltinSelTy.$QualType();
     case OCLSampler:
      
      // OpenCL sampler_t.
      return Importer.getToContext().OCLSamplerTy.$QualType();
     case OCLEvent:
      
      // OpenCL event_t.
      return Importer.getToContext().OCLEventTy.$QualType();
     case OCLClkEvent:
      
      // OpenCL clk_event_t.
      return Importer.getToContext().OCLClkEventTy.$QualType();
     case OCLQueue:
      
      // OpenCL queue_t.
      return Importer.getToContext().OCLQueueTy.$QualType();
     case OCLNDRange:
      
      // OpenCL ndrange_t.
      return Importer.getToContext().OCLNDRangeTy.$QualType();
     case OCLReserveID:
      
      // OpenCL reserve_id_t.
      return Importer.getToContext().OCLReserveIDTy.$QualType();
     case Dependent:
      
      // This represents the type of an expression whose type is
      // totally unknown, e.g. 'T::foo'.  It is permitted for this to
      // appear in situations where the structure of the type is
      // theoretically deducible.
      return Importer.getToContext().DependentTy.$QualType();
     case Overload:
      
      // The type of an unresolved overload set.  A placeholder type.
      // Expressions with this type have one of the following basic
      // forms, with parentheses generally permitted:
      //   foo          # possibly qualified, not if an implicit access
      //   foo          # possibly qualified, not if an implicit access
      //   &foo         # possibly qualified, not if an implicit access
      //   x->foo       # only if might be a static member function
      //   &x->foo      # only if might be a static member function
      //   &Class::foo  # when a pointer-to-member; sub-expr also has this type
      // OverloadExpr::find can be used to analyze the expression.
      //
      // Overload should be the first placeholder type, or else change
      // BuiltinType::isNonOverloadPlaceholderType()
      return Importer.getToContext().OverloadTy.$QualType();
     case BoundMember:
      
      // The type of a bound C++ non-static member function.
      // A placeholder type.  Expressions with this type have one of the
      // following basic forms:
      //   foo          # if an implicit access
      //   x->foo       # if only contains non-static members
      return Importer.getToContext().BoundMemberTy.$QualType();
     case PseudoObject:
      
      // The type of an expression which refers to a pseudo-object,
      // such as those introduced by Objective C's @property or
      // VS.NET's __property declarations.  A placeholder type.  The
      // pseudo-object is actually accessed by emitting a call to
      // some sort of function or method;  typically there is a pair
      // of a setter and a getter, with the setter used if the
      // pseudo-object reference is used syntactically as the
      // left-hand-side of an assignment operator.
      //
      // A pseudo-object reference naming an Objective-C @property is
      // always a dot access with a base of object-pointer type,
      // e.g. 'x.foo'.
      //
      // In VS.NET, a __property declaration creates an implicit
      // member with an associated name, which can then be named
      // in any of the normal ways an ordinary member could be.
      return Importer.getToContext().PseudoObjectTy.$QualType();
     case UnknownAny:
      
      // __builtin_any_type.  A placeholder type.  Useful for clients
      // like debuggers that don't know what type to give something.
      // Only a small number of operations are valid on expressions of
      // unknown type, most notably explicit casts.
      return Importer.getToContext().UnknownAnyTy.$QualType();
     case BuiltinFn:
      return Importer.getToContext().BuiltinFnTy.$QualType();
     case ARCUnbridgedCast:
      
      // The type of a cast which, in ARC, would normally require a
      // __bridge, but which might be okay depending on the immediate
      // context.
      return Importer.getToContext().ARCUnbridgedCastTy.$QualType();
     case OMPArraySection:
      
      // A placeholder type for OpenMP array sections.
      return Importer.getToContext().OMPArraySectionTy.$QualType();
     case Char_U:
      // The context we're importing from has an unsigned 'char'. If we're 
      // importing into a context with a signed 'char', translate to 
      // 'unsigned char' instead.
      if (Importer.getToContext().getLangOpts().CharIsSigned) {
        return Importer.getToContext().UnsignedCharTy.$QualType();
      }
      
      return Importer.getToContext().CharTy.$QualType();
     case Char_S:
      // The context we're importing from has an unsigned 'char'. If we're 
      // importing into a context with a signed 'char', translate to 
      // 'unsigned char' instead.
      if (!Importer.getToContext().getLangOpts().CharIsSigned) {
        return Importer.getToContext().SignedCharTy.$QualType();
      }
      
      return Importer.getToContext().CharTy.$QualType();
     case WChar_S:
     case WChar_U:
      // FIXME: If not in C++, shall we translate to the C equivalent of
      // wchar_t?
      return Importer.getToContext().WCharTy.$QualType();
    }
    throw new llvm_unreachable("Invalid BuiltinType Kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitComplexType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1597,
   FQN="clang::ASTNodeImporter::VisitComplexType", NM="_ZN5clang15ASTNodeImporter16VisitComplexTypeEPKNS_11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitComplexTypeEPKNS_11ComplexTypeE")
  //</editor-fold>
  public QualType VisitComplexType(/*const*/ ComplexType /*P*/ T) {
    QualType ToElementType = Importer.Import(T.getElementType());
    if (ToElementType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getComplexType(/*NO_COPY*/ToElementType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1605,
   FQN="clang::ASTNodeImporter::VisitPointerType", NM="_ZN5clang15ASTNodeImporter16VisitPointerTypeEPKNS_11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitPointerTypeEPKNS_11PointerTypeE")
  //</editor-fold>
  public QualType VisitPointerType(/*const*/ PointerType /*P*/ T) {
    QualType ToPointeeType = Importer.Import(T.getPointeeType());
    if (ToPointeeType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getPointerType(/*NO_COPY*/ToPointeeType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitBlockPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1613,
   FQN="clang::ASTNodeImporter::VisitBlockPointerType", NM="_ZN5clang15ASTNodeImporter21VisitBlockPointerTypeEPKNS_16BlockPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitBlockPointerTypeEPKNS_16BlockPointerTypeE")
  //</editor-fold>
  public QualType VisitBlockPointerType(/*const*/ BlockPointerType /*P*/ T) {
    // FIXME: Check for blocks support in "to" context.
    QualType ToPointeeType = Importer.Import(T.getPointeeType());
    if (ToPointeeType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getBlockPointerType(new QualType(ToPointeeType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitLValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1622,
   FQN="clang::ASTNodeImporter::VisitLValueReferenceType", NM="_ZN5clang15ASTNodeImporter24VisitLValueReferenceTypeEPKNS_19LValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitLValueReferenceTypeEPKNS_19LValueReferenceTypeE")
  //</editor-fold>
  public QualType VisitLValueReferenceType(/*const*/ LValueReferenceType /*P*/ T) {
    // FIXME: Check for C++ support in "to" context.
    QualType ToPointeeType = Importer.Import(T.getPointeeTypeAsWritten());
    if (ToPointeeType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getLValueReferenceType(new QualType(ToPointeeType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitRValueReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1632,
   FQN="clang::ASTNodeImporter::VisitRValueReferenceType", NM="_ZN5clang15ASTNodeImporter24VisitRValueReferenceTypeEPKNS_19RValueReferenceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitRValueReferenceTypeEPKNS_19RValueReferenceTypeE")
  //</editor-fold>
  public QualType VisitRValueReferenceType(/*const*/ RValueReferenceType /*P*/ T) {
    // FIXME: Check for C++0x support in "to" context.
    QualType ToPointeeType = Importer.Import(T.getPointeeTypeAsWritten());
    if (ToPointeeType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getRValueReferenceType(new QualType(ToPointeeType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1642,
   FQN="clang::ASTNodeImporter::VisitMemberPointerType", NM="_ZN5clang15ASTNodeImporter22VisitMemberPointerTypeEPKNS_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitMemberPointerTypeEPKNS_17MemberPointerTypeE")
  //</editor-fold>
  public QualType VisitMemberPointerType(/*const*/ MemberPointerType /*P*/ T) {
    // FIXME: Check for C++ support in "to" context.
    QualType ToPointeeType = Importer.Import(T.getPointeeType());
    if (ToPointeeType.isNull()) {
      return new QualType();
    }
    
    QualType ClassType = Importer.Import(new QualType(T.__getClass(), 0));
    return Importer.getToContext().getMemberPointerType(new QualType(ToPointeeType), 
        ClassType.getTypePtr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitConstantArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1653,
   FQN="clang::ASTNodeImporter::VisitConstantArrayType", NM="_ZN5clang15ASTNodeImporter22VisitConstantArrayTypeEPKNS_17ConstantArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitConstantArrayTypeEPKNS_17ConstantArrayTypeE")
  //</editor-fold>
  public QualType VisitConstantArrayType(/*const*/ ConstantArrayType /*P*/ T) {
    QualType ToElementType = Importer.Import(T.getElementType());
    if (ToElementType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getConstantArrayType(new QualType(ToElementType), 
        T.getSize(), 
        T.getSizeModifier(), 
        T.getIndexTypeCVRQualifiers());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitIncompleteArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1664,
   FQN="clang::ASTNodeImporter::VisitIncompleteArrayType", NM="_ZN5clang15ASTNodeImporter24VisitIncompleteArrayTypeEPKNS_19IncompleteArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitIncompleteArrayTypeEPKNS_19IncompleteArrayTypeE")
  //</editor-fold>
  public QualType VisitIncompleteArrayType(/*const*/ IncompleteArrayType /*P*/ T) {
    QualType ToElementType = Importer.Import(T.getElementType());
    if (ToElementType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getIncompleteArrayType(new QualType(ToElementType), 
        T.getSizeModifier(), 
        T.getIndexTypeCVRQualifiers());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitVariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1675,
   FQN="clang::ASTNodeImporter::VisitVariableArrayType", NM="_ZN5clang15ASTNodeImporter22VisitVariableArrayTypeEPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitVariableArrayTypeEPKNS_17VariableArrayTypeE")
  //</editor-fold>
  public QualType VisitVariableArrayType(/*const*/ VariableArrayType /*P*/ T) {
    QualType ToElementType = Importer.Import(T.getElementType());
    if (ToElementType.isNull()) {
      return new QualType();
    }
    
    Expr /*P*/ Size = Importer.Import(T.getSizeExpr());
    if (!(Size != null)) {
      return new QualType();
    }
    
    SourceRange Brackets = Importer.Import(T.getBracketsRange());
    return Importer.getToContext().getVariableArrayType(new QualType(ToElementType), Size, 
        T.getSizeModifier(), 
        T.getIndexTypeCVRQualifiers(), 
        new SourceRange(Brackets));
  }

  // FIXME: DependentSizedArrayType
  // FIXME: DependentSizedExtVectorType
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1691,
   FQN="clang::ASTNodeImporter::VisitVectorType", NM="_ZN5clang15ASTNodeImporter15VisitVectorTypeEPKNS_10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitVectorTypeEPKNS_10VectorTypeE")
  //</editor-fold>
  public QualType VisitVectorType(/*const*/ VectorType /*P*/ T) {
    QualType ToElementType = Importer.Import(T.getElementType());
    if (ToElementType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getVectorType(new QualType(ToElementType), 
        T.getNumElements(), 
        T.getVectorKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitExtVectorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1701,
   FQN="clang::ASTNodeImporter::VisitExtVectorType", NM="_ZN5clang15ASTNodeImporter18VisitExtVectorTypeEPKNS_13ExtVectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitExtVectorTypeEPKNS_13ExtVectorTypeE")
  //</editor-fold>
  public QualType VisitExtVectorType(/*const*/ ExtVectorType /*P*/ T) {
    QualType ToElementType = Importer.Import(T.getElementType());
    if (ToElementType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getExtVectorType(new QualType(ToElementType), 
        T.getNumElements());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitFunctionNoProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1710,
   FQN="clang::ASTNodeImporter::VisitFunctionNoProtoType", NM="_ZN5clang15ASTNodeImporter24VisitFunctionNoProtoTypeEPKNS_19FunctionNoProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitFunctionNoProtoTypeEPKNS_19FunctionNoProtoTypeE")
  //</editor-fold>
  public QualType VisitFunctionNoProtoType(/*const*/ FunctionNoProtoType /*P*/ T) {
    // FIXME: What happens if we're importing a function without a prototype 
    // into C++? Should we make it variadic?
    QualType ToResultType = Importer.Import(T.getReturnType());
    if (ToResultType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getFunctionNoProtoType(new QualType(ToResultType), 
        T.getExtInfo());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1722,
   FQN="clang::ASTNodeImporter::VisitFunctionProtoType", NM="_ZN5clang15ASTNodeImporter22VisitFunctionProtoTypeEPKNS_17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitFunctionProtoTypeEPKNS_17FunctionProtoTypeE")
  //</editor-fold>
  public QualType VisitFunctionProtoType(/*const*/ FunctionProtoType /*P*/ T) {
    QualType ToResultType = Importer.Import(T.getReturnType());
    if (ToResultType.isNull()) {
      return new QualType();
    }
    
    // Import argument types
    SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(4, new QualType());
    for (final /*const*/ QualType /*&*/ A : T.param_types()) {
      QualType ArgType = Importer.Import(new QualType(A));
      if (ArgType.isNull()) {
        return new QualType();
      }
      ArgTypes.push_back(ArgType);
    }
    
    // Import exception types
    SmallVector<QualType> ExceptionTypes/*J*/= new SmallVector<QualType>(4, new QualType());
    for (final /*const*/ QualType /*&*/ E : T.exceptions()) {
      QualType ExceptionType = Importer.Import(new QualType(E));
      if (ExceptionType.isNull()) {
        return new QualType();
      }
      ExceptionTypes.push_back(ExceptionType);
    }
    
    FunctionProtoType.ExtProtoInfo FromEPI = T.getExtProtoInfo();
    FunctionProtoType.ExtProtoInfo ToEPI/*J*/= new FunctionProtoType.ExtProtoInfo();
    
    ToEPI.ExtInfo.$assign(FromEPI.ExtInfo);
    ToEPI.Variadic = FromEPI.Variadic;
    ToEPI.HasTrailingReturn = FromEPI.HasTrailingReturn;
    ToEPI.TypeQuals = FromEPI.TypeQuals;
    ToEPI.RefQualifier = FromEPI.RefQualifier;
    ToEPI.ExceptionSpec.Type = FromEPI.ExceptionSpec.Type;
    ToEPI.ExceptionSpec.Exceptions.$assignMove(new ArrayRef<QualType>(ExceptionTypes, false));
    ToEPI.ExceptionSpec.NoexceptExpr
       = Importer.Import(FromEPI.ExceptionSpec.NoexceptExpr);
    ToEPI.ExceptionSpec.SourceDecl = cast_or_null_FunctionDecl(Importer.Import(FromEPI.ExceptionSpec.SourceDecl));
    ToEPI.ExceptionSpec.SourceTemplate = cast_or_null_FunctionDecl(Importer.Import(FromEPI.ExceptionSpec.SourceTemplate));
    
    return Importer.getToContext().getFunctionType(new QualType(ToResultType), new ArrayRef<QualType>(ArgTypes, false), ToEPI);
  }

  // FIXME: UnresolvedUsingType
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1765,
   FQN="clang::ASTNodeImporter::VisitParenType", NM="_ZN5clang15ASTNodeImporter14VisitParenTypeEPKNS_9ParenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitParenTypeEPKNS_9ParenTypeE")
  //</editor-fold>
  public QualType VisitParenType(/*const*/ ParenType /*P*/ T) {
    QualType ToInnerType = Importer.Import(T.getInnerType());
    if (ToInnerType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getParenType(new QualType(ToInnerType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTypedefType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1773,
   FQN="clang::ASTNodeImporter::VisitTypedefType", NM="_ZN5clang15ASTNodeImporter16VisitTypedefTypeEPKNS_11TypedefTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitTypedefTypeEPKNS_11TypedefTypeE")
  //</editor-fold>
  public QualType VisitTypedefType(/*const*/ TypedefType /*P*/ T) {
    TypedefNameDecl /*P*/ ToDecl = dyn_cast_or_null_TypedefNameDecl(Importer.Import(T.getDecl()));
    if (!(ToDecl != null)) {
      return new QualType();
    }
    
    return Importer.getToContext().getTypeDeclType(ToDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTypeOfExprType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1782,
   FQN="clang::ASTNodeImporter::VisitTypeOfExprType", NM="_ZN5clang15ASTNodeImporter19VisitTypeOfExprTypeEPKNS_14TypeOfExprTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitTypeOfExprTypeEPKNS_14TypeOfExprTypeE")
  //</editor-fold>
  public QualType VisitTypeOfExprType(/*const*/ TypeOfExprType /*P*/ T) {
    Expr /*P*/ ToExpr = Importer.Import(T.getUnderlyingExpr());
    if (!(ToExpr != null)) {
      return new QualType();
    }
    
    return Importer.getToContext().getTypeOfExprType(ToExpr);
  }

  // FIXME: DependentTypeOfExprType
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1790,
   FQN="clang::ASTNodeImporter::VisitTypeOfType", NM="_ZN5clang15ASTNodeImporter15VisitTypeOfTypeEPKNS_10TypeOfTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitTypeOfTypeEPKNS_10TypeOfTypeE")
  //</editor-fold>
  public QualType VisitTypeOfType(/*const*/ TypeOfType /*P*/ T) {
    QualType ToUnderlyingType = Importer.Import(T.getUnderlyingType());
    if (ToUnderlyingType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getTypeOfType(new QualType(ToUnderlyingType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1798,
   FQN="clang::ASTNodeImporter::VisitDecltypeType", NM="_ZN5clang15ASTNodeImporter17VisitDecltypeTypeEPKNS_12DecltypeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitDecltypeTypeEPKNS_12DecltypeTypeE")
  //</editor-fold>
  public QualType VisitDecltypeType(/*const*/ DecltypeType /*P*/ T) {
    // FIXME: Make sure that the "to" context supports C++0x!
    Expr /*P*/ ToExpr = Importer.Import(T.getUnderlyingExpr());
    if (!(ToExpr != null)) {
      return new QualType();
    }
    
    QualType UnderlyingType = Importer.Import(T.getUnderlyingType());
    if (UnderlyingType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getDecltypeType(ToExpr, new QualType(UnderlyingType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitUnaryTransformType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1811,
   FQN="clang::ASTNodeImporter::VisitUnaryTransformType", NM="_ZN5clang15ASTNodeImporter23VisitUnaryTransformTypeEPKNS_18UnaryTransformTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23VisitUnaryTransformTypeEPKNS_18UnaryTransformTypeE")
  //</editor-fold>
  public QualType VisitUnaryTransformType(/*const*/ UnaryTransformType /*P*/ T) {
    QualType ToBaseType = Importer.Import(T.getBaseType());
    QualType ToUnderlyingType = Importer.Import(T.getUnderlyingType());
    if (ToBaseType.isNull() || ToUnderlyingType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getUnaryTransformType(new QualType(ToBaseType), 
        new QualType(ToUnderlyingType), 
        T.getUTTKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitAutoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1822,
   FQN="clang::ASTNodeImporter::VisitAutoType", NM="_ZN5clang15ASTNodeImporter13VisitAutoTypeEPKNS_8AutoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitAutoTypeEPKNS_8AutoTypeE")
  //</editor-fold>
  public QualType VisitAutoType(/*const*/ AutoType /*P*/ T) {
    // FIXME: Make sure that the "to" context supports C++11!
    QualType FromDeduced = T.getDeducedType();
    QualType ToDeduced/*J*/= new QualType();
    if (!FromDeduced.isNull()) {
      ToDeduced.$assignMove(Importer.Import(new QualType(FromDeduced)));
      if (ToDeduced.isNull()) {
        return new QualType();
      }
    }
    
    return Importer.getToContext().getAutoType(new QualType(ToDeduced), T.getKeyword(), 
        /*IsDependent*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitInjectedClassNameType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1836,
   FQN="clang::ASTNodeImporter::VisitInjectedClassNameType", NM="_ZN5clang15ASTNodeImporter26VisitInjectedClassNameTypeEPKNS_21InjectedClassNameTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter26VisitInjectedClassNameTypeEPKNS_21InjectedClassNameTypeE")
  //</editor-fold>
  public QualType VisitInjectedClassNameType(/*const*/ InjectedClassNameType /*P*/ T) {
    CXXRecordDecl /*P*/ D = cast_or_null_CXXRecordDecl(Importer.Import(T.getDecl()));
    if (!(D != null)) {
      return new QualType();
    }
    
    QualType InjType = Importer.Import(T.getInjectedSpecializationType());
    if (InjType.isNull()) {
      return new QualType();
    }
    
    // FIXME: ASTContext::getInjectedClassNameType is not suitable for AST reading
    // See comments in InjectedClassNameType definition for details
    // return Importer.getToContext().getInjectedClassNameType(D, InjType);
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int TypeAlignmentInBits = 4;
      final /*uint*/int TypeAlignment = 1 << TypeAlignmentInBits;
    /*}*/;
    
    return new QualType(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
        /*new (Importer.getToContext(), TypeAlignment)*/ $new_uint_ASTContext$C_uint(Importer.getToContext(), TypeAlignment, (type$ptr<?> New$Mem)->{
            return new InjectedClassNameType(D, new QualType(InjType));
         }), 0);
  }

  // FIXME: DependentDecltypeType
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1858,
   FQN="clang::ASTNodeImporter::VisitRecordType", NM="_ZN5clang15ASTNodeImporter15VisitRecordTypeEPKNS_10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitRecordTypeEPKNS_10RecordTypeE")
  //</editor-fold>
  public QualType VisitRecordType(/*const*/ RecordType /*P*/ T) {
    RecordDecl /*P*/ ToDecl = dyn_cast_or_null_RecordDecl(Importer.Import(T.getDecl()));
    if (!(ToDecl != null)) {
      return new QualType();
    }
    
    return Importer.getToContext().getTagDeclType(ToDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitEnumType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1867,
   FQN="clang::ASTNodeImporter::VisitEnumType", NM="_ZN5clang15ASTNodeImporter13VisitEnumTypeEPKNS_8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitEnumTypeEPKNS_8EnumTypeE")
  //</editor-fold>
  public QualType VisitEnumType(/*const*/ EnumType /*P*/ T) {
    EnumDecl /*P*/ ToDecl = dyn_cast_or_null_EnumDecl(Importer.Import(T.getDecl()));
    if (!(ToDecl != null)) {
      return new QualType();
    }
    
    return Importer.getToContext().getTagDeclType(ToDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitAttributedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1876,
   FQN="clang::ASTNodeImporter::VisitAttributedType", NM="_ZN5clang15ASTNodeImporter19VisitAttributedTypeEPKNS_14AttributedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitAttributedTypeEPKNS_14AttributedTypeE")
  //</editor-fold>
  public QualType VisitAttributedType(/*const*/ AttributedType /*P*/ T) {
    QualType FromModifiedType = T.getModifiedType();
    QualType FromEquivalentType = T.getEquivalentType();
    QualType ToModifiedType/*J*/= new QualType();
    QualType ToEquivalentType/*J*/= new QualType();
    if (!FromModifiedType.isNull()) {
      ToModifiedType.$assignMove(Importer.Import(new QualType(FromModifiedType)));
      if (ToModifiedType.isNull()) {
        return new QualType();
      }
    }
    if (!FromEquivalentType.isNull()) {
      ToEquivalentType.$assignMove(Importer.Import(new QualType(FromEquivalentType)));
      if (ToEquivalentType.isNull()) {
        return new QualType();
      }
    }
    
    return Importer.getToContext().getAttributedType(T.getAttrKind(), 
        new QualType(ToModifiedType), new QualType(ToEquivalentType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTemplateTypeParmType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1898,
   FQN="clang::ASTNodeImporter::VisitTemplateTypeParmType", NM="_ZN5clang15ASTNodeImporter25VisitTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter25VisitTemplateTypeParmTypeEPKNS_20TemplateTypeParmTypeE")
  //</editor-fold>
  public QualType VisitTemplateTypeParmType(/*const*/ TemplateTypeParmType /*P*/ T) {
    TemplateTypeParmDecl /*P*/ ParmDecl = cast_or_null_TemplateTypeParmDecl(Importer.Import(T.getDecl()));
    if (!(ParmDecl != null) && (T.getDecl() != null)) {
      return new QualType();
    }
    
    return Importer.getToContext().getTemplateTypeParmType(T.getDepth(), T.getIndex(), T.isParameterPack(), ParmDecl);
  }

  // FIXME: SubstTemplateTypeParmType
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTemplateSpecializationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1909,
   FQN="clang::ASTNodeImporter::VisitTemplateSpecializationType", NM="_ZN5clang15ASTNodeImporter31VisitTemplateSpecializationTypeEPKNS_26TemplateSpecializationTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter31VisitTemplateSpecializationTypeEPKNS_26TemplateSpecializationTypeE")
  //</editor-fold>
  public QualType VisitTemplateSpecializationType(/*const*/ TemplateSpecializationType /*P*/ T) {
    TemplateName ToTemplate = Importer.Import(T.getTemplateName());
    if (ToTemplate.isNull()) {
      return new QualType();
    }
    
    SmallVector<TemplateArgument> ToTemplateArgs/*J*/= new SmallVector<TemplateArgument>(2, new TemplateArgument());
    if (ImportTemplateArguments(T.getArgs(), T.getNumArgs(), ToTemplateArgs)) {
      return new QualType();
    }
    
    QualType ToCanonType/*J*/= new QualType();
    if (!new QualType(T, 0).isCanonical()) {
      QualType FromCanonType = Importer.getFromContext().getCanonicalType(new QualType(T, 0)).$QualType();
      ToCanonType.$assignMove(Importer.Import(new QualType(FromCanonType)));
      if (ToCanonType.isNull()) {
        return new QualType();
      }
    }
    return Importer.getToContext().getTemplateSpecializationType(new TemplateName(ToTemplate), 
        new ArrayRef<TemplateArgument>(ToTemplateArgs, false), 
        new QualType(ToCanonType));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitElaboratedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1932,
   FQN="clang::ASTNodeImporter::VisitElaboratedType", NM="_ZN5clang15ASTNodeImporter19VisitElaboratedTypeEPKNS_14ElaboratedTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitElaboratedTypeEPKNS_14ElaboratedTypeE")
  //</editor-fold>
  public QualType VisitElaboratedType(/*const*/ ElaboratedType /*P*/ T) {
    NestedNameSpecifier /*P*/ ToQualifier = null;
    // Note: the qualifier in an ElaboratedType is optional.
    if ((T.getQualifier() != null)) {
      ToQualifier = Importer.Import(T.getQualifier());
      if (!(ToQualifier != null)) {
        return new QualType();
      }
    }
    
    QualType ToNamedType = Importer.Import(T.getNamedType());
    if (ToNamedType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getElaboratedType(T.getKeyword(), 
        ToQualifier, new QualType(ToNamedType));
  }

  // FIXME: DependentNameType
  // FIXME: DependentTemplateSpecializationType
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1949,
   FQN="clang::ASTNodeImporter::VisitObjCInterfaceType", NM="_ZN5clang15ASTNodeImporter22VisitObjCInterfaceTypeEPKNS_17ObjCInterfaceTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitObjCInterfaceTypeEPKNS_17ObjCInterfaceTypeE")
  //</editor-fold>
  public QualType VisitObjCInterfaceType(/*const*/ ObjCInterfaceType /*P*/ T) {
    ObjCInterfaceDecl /*P*/ Class = dyn_cast_or_null_ObjCInterfaceDecl(Importer.Import(T.getDecl()));
    if (!(Class != null)) {
      return new QualType();
    }
    
    return Importer.getToContext().getObjCInterfaceType(Class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1958,
   FQN="clang::ASTNodeImporter::VisitObjCObjectType", NM="_ZN5clang15ASTNodeImporter19VisitObjCObjectTypeEPKNS_14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitObjCObjectTypeEPKNS_14ObjCObjectTypeE")
  //</editor-fold>
  public QualType VisitObjCObjectType(/*const*/ ObjCObjectType /*P*/ T) {
    QualType ToBaseType = Importer.Import(T.getBaseType());
    if (ToBaseType.isNull()) {
      return new QualType();
    }
    
    SmallVector<QualType> TypeArgs/*J*/= new SmallVector<QualType>(4, new QualType());
    for (QualType TypeArg : T.getTypeArgsAsWritten()) {
      QualType ImportedTypeArg = Importer.Import(new QualType(TypeArg));
      if (ImportedTypeArg.isNull()) {
        return new QualType();
      }
      
      TypeArgs.push_back(ImportedTypeArg);
    }
    
    SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(4, (ObjCProtocolDecl /*P*/ )null);
    for (ObjCProtocolDecl /*P*/ P : T.quals()) {
      ObjCProtocolDecl /*P*/ Protocol = dyn_cast_or_null_ObjCProtocolDecl(Importer.Import(P));
      if (!(Protocol != null)) {
        return new QualType();
      }
      Protocols.push_back(Protocol);
    }
    
    return Importer.getToContext().getObjCObjectType(new QualType(ToBaseType), new ArrayRef<QualType>(TypeArgs, false), 
        new ArrayRef<ObjCProtocolDecl /*P*/ >(Protocols, true), 
        T.isKindOfTypeAsWritten());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1986,
   FQN="clang::ASTNodeImporter::VisitObjCObjectPointerType", NM="_ZN5clang15ASTNodeImporter26VisitObjCObjectPointerTypeEPKNS_21ObjCObjectPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter26VisitObjCObjectPointerTypeEPKNS_21ObjCObjectPointerTypeE")
  //</editor-fold>
  public QualType VisitObjCObjectPointerType(/*const*/ ObjCObjectPointerType /*P*/ T) {
    QualType ToPointeeType = Importer.Import(T.getPointeeType());
    if (ToPointeeType.isNull()) {
      return new QualType();
    }
    
    return Importer.getToContext().getObjCObjectPointerType(new QualType(ToPointeeType));
  }

  
  // Importing declarations                            
  
  //----------------------------------------------------------------------------
  // Import Declarations
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDeclParts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1998,
   FQN="clang::ASTNodeImporter::ImportDeclParts", NM="_ZN5clang15ASTNodeImporter15ImportDeclPartsEPNS_9NamedDeclERPNS_11DeclContextES5_RNS_15DeclarationNameERS2_RNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15ImportDeclPartsEPNS_9NamedDeclERPNS_11DeclContextES5_RNS_15DeclarationNameERS2_RNS_14SourceLocationE")
  //</editor-fold>
  public boolean ImportDeclParts(NamedDecl /*P*/ D, final type$ref<DeclContext /*P*/ /*&*/> DC, 
                 final type$ref<DeclContext /*P*/ /*&*/> LexicalDC, 
                 final DeclarationName /*&*/ Name, 
                 final type$ref<NamedDecl /*P*/ /*&*/> ToD, 
                 final SourceLocation /*&*/ Loc) {
    // Import the context of this declaration.
    DC.$set(Importer.ImportContext(D.getDeclContext()));
    if (!(DC.$deref() != null)) {
      return true;
    }
    
    LexicalDC.$set(DC.$deref());
    if (D.getDeclContext() != D.getLexicalDeclContext()) {
      LexicalDC.$set(Importer.ImportContext(D.getLexicalDeclContext()));
      if (!(LexicalDC.$deref() != null)) {
        return true;
      }
    }
    
    // Import the name of this declaration.
    Name.$assignMove(Importer.Import(D.getDeclName()));
    if (D.getDeclName().$bool() && !Name.$bool()) {
      return true;
    }
    
    // Import the location of this declaration.
    Loc.$assignMove(Importer.Import(D.getLocation()));
    ToD.$set(cast_or_null_NamedDecl(Importer.GetAlreadyImportedOrNull(D)));
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinitionIfNeeded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2026,
   FQN="clang::ASTNodeImporter::ImportDefinitionIfNeeded", NM="_ZN5clang15ASTNodeImporter24ImportDefinitionIfNeededEPNS_4DeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24ImportDefinitionIfNeededEPNS_4DeclES2_")
  //</editor-fold>
  public void ImportDefinitionIfNeeded(Decl /*P*/ FromD) {
    ImportDefinitionIfNeeded(FromD, (Decl /*P*/ )null);
  }
  public void ImportDefinitionIfNeeded(Decl /*P*/ FromD, Decl /*P*/ ToD/*= null*/) {
    if (!(FromD != null)) {
      return;
    }
    if (!(ToD != null)) {
      ToD = Importer.Import(FromD);
      if (!(ToD != null)) {
        return;
      }
    }
    {
      
      RecordDecl /*P*/ FromRecord = dyn_cast_RecordDecl(FromD);
      if ((FromRecord != null)) {
        {
          RecordDecl /*P*/ ToRecord = cast_or_null_RecordDecl(ToD);
          if ((ToRecord != null)) {
            if ((FromRecord.getDefinition() != null) && FromRecord.isCompleteDefinition() && !(ToRecord.getDefinition() != null)) {
              ImportDefinition(FromRecord, ToRecord);
            }
          }
        }
        return;
      }
    }
    {
      
      EnumDecl /*P*/ FromEnum = dyn_cast_EnumDecl(FromD);
      if ((FromEnum != null)) {
        {
          EnumDecl /*P*/ ToEnum = cast_or_null_EnumDecl(ToD);
          if ((ToEnum != null)) {
            if ((FromEnum.getDefinition() != null) && !(ToEnum.getDefinition() != null)) {
              ImportDefinition(FromEnum, ToEnum);
            }
          }
        }
        return;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDeclarationNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2055,
   FQN="clang::ASTNodeImporter::ImportDeclarationNameLoc", NM="_ZN5clang15ASTNodeImporter24ImportDeclarationNameLocERKNS_19DeclarationNameInfoERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24ImportDeclarationNameLocERKNS_19DeclarationNameInfoERS1_")
  //</editor-fold>
  public void ImportDeclarationNameLoc(final /*const*/ DeclarationNameInfo /*&*/ From, 
                          final DeclarationNameInfo /*&*/ To) {
    // NOTE: To.Name and To.Loc are already imported.
    // We only have to import To.LocInfo.
    switch (To.getName().getNameKind()) {
     case Identifier:
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
     case CXXUsingDirective:
      return;
     case CXXOperatorName:
      {
        SourceRange Range = From.getCXXOperatorNameRange();
        To.setCXXOperatorNameRange(Importer.Import(new SourceRange(Range)));
        return;
      }
     case CXXLiteralOperatorName:
      {
        SourceLocation Loc = From.getCXXLiteralOperatorNameLoc();
        To.setCXXLiteralOperatorNameLoc(Importer.Import(new SourceLocation(Loc)));
        return;
      }
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
      {
        TypeSourceInfo /*P*/ FromTInfo = From.getNamedTypeInfo();
        To.setNamedTypeInfo(Importer.Import(FromTInfo));
        return;
      }
    }
    throw new llvm_unreachable("Unknown name kind.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2089,
   FQN="clang::ASTNodeImporter::ImportDeclContext", NM="_ZN5clang15ASTNodeImporter17ImportDeclContextEPNS_11DeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17ImportDeclContextEPNS_11DeclContextEb")
  //</editor-fold>
  public void ImportDeclContext(DeclContext /*P*/ FromDC) {
    ImportDeclContext(FromDC, false);
  }
  public void ImportDeclContext(DeclContext /*P*/ FromDC, boolean ForceImport/*= false*/) {
    if (Importer.isMinimalImport() && !ForceImport) {
      Importer.ImportContext(FromDC);
      return;
    }
    
    for (Decl /*P*/ From : FromDC.decls())  {
      Importer.Import(From);
    }
  }

  
  /*typedef DesignatedInitExpr::Designator Designator*/
//  public final class Designator extends DesignatedInitExpr.Designator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5419,
   FQN="clang::ASTNodeImporter::ImportDesignator", NM="_ZN5clang15ASTNodeImporter16ImportDesignatorERKNS_18DesignatedInitExpr10DesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16ImportDesignatorERKNS_18DesignatedInitExpr10DesignatorE")
  //</editor-fold>
  public DesignatedInitExpr.Designator ImportDesignator(final /*const*/ DesignatedInitExpr.Designator /*&*/ D) {
    if (D.isFieldDesignator()) {
      IdentifierInfo /*P*/ ToFieldName = Importer.Import(D.getFieldName());
      // Caller checks for import error
      return new DesignatedInitExpr.Designator(ToFieldName, Importer.Import(D.getDotLoc()), 
          Importer.Import(D.getFieldLoc()));
    }
    if (D.isArrayDesignator()) {
      return new DesignatedInitExpr.Designator(D.getFirstExprIndex(), 
          Importer.Import(D.getLBracketLoc()), 
          Importer.Import(D.getRBracketLoc()));
    }
    assert (D.isArrayRangeDesignator());
    return new DesignatedInitExpr.Designator(D.getFirstExprIndex(), 
        Importer.Import(D.getLBracketLoc()), 
        Importer.Import(D.getEllipsisLoc()), 
        Importer.Import(D.getRBracketLoc()));
  }

  
  /// \brief What we should import from the definition.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinitionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 96,
   FQN="clang::ASTNodeImporter::ImportDefinitionKind", NM="_ZN5clang15ASTNodeImporter20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20ImportDefinitionKindE")
  //</editor-fold>
  public enum ImportDefinitionKind implements Native.ComparableLower {
    /// \brief Import the default subset of the definition, which might be
    /// nothing (if minimal import is set) or might be everything (if minimal
    /// import is not set).
    IDK_Default(0),
    /// \brief Import everything.
    IDK_Everything(IDK_Default.getValue() + 1),
    /// \brief Import only the bare bones needed to establish a valid
    /// DeclContext.
    IDK_Basic(IDK_Everything.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ImportDefinitionKind valueOf(int val) {
      ImportDefinitionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ImportDefinitionKind[] VALUES;
      private static final ImportDefinitionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ImportDefinitionKind kind : ImportDefinitionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ImportDefinitionKind[min < 0 ? (1-min) : 0];
        VALUES = new ImportDefinitionKind[max >= 0 ? (1+max) : 0];
        for (ImportDefinitionKind kind : ImportDefinitionKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private ImportDefinitionKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ImportDefinitionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ImportDefinitionKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::shouldForceImportDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 108,
   FQN="clang::ASTNodeImporter::shouldForceImportDeclContext", NM="_ZN5clang15ASTNodeImporter28shouldForceImportDeclContextENS0_20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter28shouldForceImportDeclContextENS0_20ImportDefinitionKindE")
  //</editor-fold>
  public boolean shouldForceImportDeclContext(ImportDefinitionKind IDK) {
    return IDK == ImportDefinitionKind.IDK_Everything
       || (IDK == ImportDefinitionKind.IDK_Default && !Importer.isMinimalImport());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2099,
   FQN="clang::ASTNodeImporter::ImportDefinition", NM="_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_10RecordDeclES2_NS0_20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_10RecordDeclES2_NS0_20ImportDefinitionKindE")
  //</editor-fold>
  public boolean ImportDefinition(RecordDecl /*P*/ From, RecordDecl /*P*/ To) {
    return ImportDefinition(From, To, 
                  ImportDefinitionKind.IDK_Default);
  }
  public boolean ImportDefinition(RecordDecl /*P*/ From, RecordDecl /*P*/ To, 
                  ImportDefinitionKind Kind/*= IDK_Default*/) {
    if ((To.getDefinition() != null) || To.isBeingDefined()) {
      if (Kind == ImportDefinitionKind.IDK_Everything) {
        ImportDeclContext(From, /*ForceImport=*/ true);
      }
      
      return false;
    }
    
    To.startDefinition();
    {
      
      // Add base classes.
      CXXRecordDecl /*P*/ ToCXX = dyn_cast_CXXRecordDecl(To);
      if ((ToCXX != null)) {
        CXXRecordDecl /*P*/ FromCXX = cast_CXXRecordDecl(From);
        
        final  CXXRecordDecl.DefinitionData /*&*/ ToData = ToCXX.data();
        final  CXXRecordDecl.DefinitionData /*&*/ FromData = FromCXX.data();
        ToData.UserDeclaredConstructor = FromData.UserDeclaredConstructor;
        ToData.UserDeclaredSpecialMembers = $uint2uint_6bits(FromData.UserDeclaredSpecialMembers);
        ToData.Aggregate = FromData.Aggregate;
        ToData.PlainOldData = FromData.PlainOldData;
        ToData.Empty = FromData.Empty;
        ToData.Polymorphic = FromData.Polymorphic;
        ToData.Abstract = FromData.Abstract;
        ToData.IsStandardLayout = FromData.IsStandardLayout;
        ToData.HasNoNonEmptyBases = FromData.HasNoNonEmptyBases;
        ToData.HasPrivateFields = FromData.HasPrivateFields;
        ToData.HasProtectedFields = FromData.HasProtectedFields;
        ToData.HasPublicFields = FromData.HasPublicFields;
        ToData.HasMutableFields = FromData.HasMutableFields;
        ToData.HasVariantMembers = FromData.HasVariantMembers;
        ToData.HasOnlyCMembers = FromData.HasOnlyCMembers;
        ToData.HasInClassInitializer = FromData.HasInClassInitializer;
        ToData.HasUninitializedReferenceMember
           = FromData.HasUninitializedReferenceMember;
        ToData.HasUninitializedFields = FromData.HasUninitializedFields;
        ToData.HasInheritedConstructor = FromData.HasInheritedConstructor;
        ToData.HasInheritedAssignment = FromData.HasInheritedAssignment;
        ToData.NeedOverloadResolutionForMoveConstructor
           = FromData.NeedOverloadResolutionForMoveConstructor;
        ToData.NeedOverloadResolutionForMoveAssignment
           = FromData.NeedOverloadResolutionForMoveAssignment;
        ToData.NeedOverloadResolutionForDestructor
           = FromData.NeedOverloadResolutionForDestructor;
        ToData.DefaultedMoveConstructorIsDeleted
           = FromData.DefaultedMoveConstructorIsDeleted;
        ToData.DefaultedMoveAssignmentIsDeleted
           = FromData.DefaultedMoveAssignmentIsDeleted;
        ToData.DefaultedDestructorIsDeleted = FromData.DefaultedDestructorIsDeleted;
        ToData.HasTrivialSpecialMembers = $uint2uint_6bits(FromData.HasTrivialSpecialMembers);
        ToData.HasIrrelevantDestructor = FromData.HasIrrelevantDestructor;
        ToData.HasConstexprNonCopyMoveConstructor
           = FromData.HasConstexprNonCopyMoveConstructor;
        ToData.HasDefaultedDefaultConstructor
           = FromData.HasDefaultedDefaultConstructor;
        ToData.DefaultedDefaultConstructorIsConstexpr
           = FromData.DefaultedDefaultConstructorIsConstexpr;
        ToData.HasConstexprDefaultConstructor
           = FromData.HasConstexprDefaultConstructor;
        ToData.HasNonLiteralTypeFieldsOrBases
           = FromData.HasNonLiteralTypeFieldsOrBases;
        // ComputedVisibleConversions not imported.
        ToData.UserProvidedDefaultConstructor
           = FromData.UserProvidedDefaultConstructor;
        ToData.DeclaredSpecialMembers = $uint2uint_6bits(FromData.DeclaredSpecialMembers);
        ToData.ImplicitCopyConstructorHasConstParam
           = FromData.ImplicitCopyConstructorHasConstParam;
        ToData.ImplicitCopyAssignmentHasConstParam
           = FromData.ImplicitCopyAssignmentHasConstParam;
        ToData.HasDeclaredCopyConstructorWithConstParam
           = FromData.HasDeclaredCopyConstructorWithConstParam;
        ToData.HasDeclaredCopyAssignmentWithConstParam
           = FromData.HasDeclaredCopyAssignmentWithConstParam;
        ToData.IsLambda = FromData.IsLambda;
        
        SmallVector<CXXBaseSpecifier /*P*/> Bases/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
        for (final /*const*/ CXXBaseSpecifier /*&*/ Base1 : FromCXX.bases()) {
          QualType T = Importer.Import(Base1.getType());
          if (T.isNull()) {
            return true;
          }
          
          SourceLocation EllipsisLoc/*J*/= new SourceLocation();
          if (Base1.isPackExpansion()) {
            EllipsisLoc.$assignMove(Importer.Import(Base1.getEllipsisLoc()));
          }
          
          // Ensure that we have a definition for the base.
          ImportDefinitionIfNeeded(Base1.getType().$arrow().getAsCXXRecordDecl());
          
          Bases.push_back(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
              /*new (Importer.getToContext())*/ $new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
                  return new CXXBaseSpecifier(Importer.Import(Base1.getSourceRange()), 
                          Base1.isVirtual(), 
                          Base1.isBaseOfClass(), 
                          Base1.getAccessSpecifierAsWritten(), 
                          Importer.Import(Base1.getTypeSourceInfo()), 
                          new SourceLocation(EllipsisLoc));
               }));
        }
        if (!Bases.empty()) {
          ToCXX.setBases(Bases.data(), Bases.size());
        }
      }
    }
    if (shouldForceImportDeclContext(Kind)) {
      ImportDeclContext(From, /*ForceImport=*/ true);
    }
    
    To.completeDefinition();
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2207,
   FQN="clang::ASTNodeImporter::ImportDefinition", NM="_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_7VarDeclES2_NS0_20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_7VarDeclES2_NS0_20ImportDefinitionKindE")
  //</editor-fold>
  public boolean ImportDefinition(VarDecl /*P*/ From, VarDecl /*P*/ To) {
    return ImportDefinition(From, To, 
                  ImportDefinitionKind.IDK_Default);
  }
  public boolean ImportDefinition(VarDecl /*P*/ From, VarDecl /*P*/ To, 
                  ImportDefinitionKind Kind/*= IDK_Default*/) {
    if ((To.getAnyInitializer() != null)) {
      return false;
    }
    
    // FIXME: Can we really import any initializer? Alternatively, we could force
    // ourselves to import every declaration of a variable and then only use
    // getInit() here.
    To.setInit(Importer.Import(((/*const_cast*/Expr /*P*/ )(From.getAnyInitializer()))));
    
    // FIXME: Other bits to merge?
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2222,
   FQN="clang::ASTNodeImporter::ImportDefinition", NM="_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_8EnumDeclES2_NS0_20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_8EnumDeclES2_NS0_20ImportDefinitionKindE")
  //</editor-fold>
  public boolean ImportDefinition(EnumDecl /*P*/ From, EnumDecl /*P*/ To) {
    return ImportDefinition(From, To, 
                  ImportDefinitionKind.IDK_Default);
  }
  public boolean ImportDefinition(EnumDecl /*P*/ From, EnumDecl /*P*/ To, 
                  ImportDefinitionKind Kind/*= IDK_Default*/) {
    if ((To.getDefinition() != null) || To.isBeingDefined()) {
      if (Kind == ImportDefinitionKind.IDK_Everything) {
        ImportDeclContext(From, /*ForceImport=*/ true);
      }
      return false;
    }
    
    To.startDefinition();
    
    QualType T = Importer.Import(Importer.getFromContext().getTypeDeclType(From));
    if (T.isNull()) {
      return true;
    }
    
    QualType ToPromotionType = Importer.Import(From.getPromotionType());
    if (ToPromotionType.isNull()) {
      return true;
    }
    if (shouldForceImportDeclContext(Kind)) {
      ImportDeclContext(From, /*ForceImport=*/ true);
    }
    
    // FIXME: we might need to merge the number of positive or negative bits
    // if the enumerator lists don't match.
    To.completeDefinition(new QualType(T), new QualType(ToPromotionType), 
        From.getNumPositiveBits(), 
        From.getNumNegativeBits());
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3891,
   FQN="clang::ASTNodeImporter::ImportDefinition", NM="_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_17ObjCInterfaceDeclES2_NS0_20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_17ObjCInterfaceDeclES2_NS0_20ImportDefinitionKindE")
  //</editor-fold>
  public boolean ImportDefinition(ObjCInterfaceDecl /*P*/ From, 
                  ObjCInterfaceDecl /*P*/ To) {
    return ImportDefinition(From, 
                  To, 
                  ImportDefinitionKind.IDK_Default);
  }
  public boolean ImportDefinition(ObjCInterfaceDecl /*P*/ From, 
                  ObjCInterfaceDecl /*P*/ To, 
                  ImportDefinitionKind Kind/*= IDK_Default*/) {
    if ((To.getDefinition() != null)) {
      // Check consistency of superclass.
      ObjCInterfaceDecl /*P*/ FromSuper = From.getSuperClass();
      if ((FromSuper != null)) {
        FromSuper = cast_or_null_ObjCInterfaceDecl(Importer.Import(FromSuper));
        if (!(FromSuper != null)) {
          return true;
        }
      }
      
      ObjCInterfaceDecl /*P*/ ToSuper = To.getSuperClass();
      if ((boolean)(FromSuper != null) != (boolean)(ToSuper != null)
         || ((FromSuper != null) && !declaresSameEntity(FromSuper, ToSuper))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(To.getLocation(), 
                  diag.err_odr_objc_superclass_inconsistent)), 
              To.getDeclName()));
          if ((ToSuper != null)) {
            $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(To.getSuperClassLoc(), diag.note_odr_objc_superclass)), 
                To.getSuperClass().getDeclName()));
          } else {
            $c$.clean($c$.track(Importer.ToDiag(To.getLocation(), 
                diag.note_odr_objc_missing_superclass)));
          }
          if ((From.getSuperClass() != null)) {
            $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.FromDiag(From.getSuperClassLoc(), 
                    diag.note_odr_objc_superclass)), 
                From.getSuperClass().getDeclName()));
          } else {
            $c$.clean($c$.track(Importer.FromDiag(From.getLocation(), 
                diag.note_odr_objc_missing_superclass)));
          }
        } finally {
          $c$.$destroy();
        }
      }
      if (shouldForceImportDeclContext(Kind)) {
        ImportDeclContext(From);
      }
      return false;
    }
    
    // Start the definition.
    To.startDefinition();
    
    // If this class has a superclass, import it.
    if ((From.getSuperClass() != null)) {
      TypeSourceInfo /*P*/ SuperTInfo = Importer.Import(From.getSuperClassTInfo());
      if (!(SuperTInfo != null)) {
        return true;
      }
      
      To.setSuperClass(SuperTInfo);
    }
    
    // Import protocols
    SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(4, (ObjCProtocolDecl /*P*/ )null);
    SmallVector<SourceLocation> ProtocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    /*const*/type$ptr<SourceLocation> /*P*/ FromProtoLoc = $tryClone(From.protocol_loc_begin());
    
    for (type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> FromProto = $tryClone(From.protocol_begin()), 
        /*P*/ /*const*/ /*P*/ FromProtoEnd = $tryClone(From.protocol_end());
         $noteq_ptr(FromProto, FromProtoEnd);
         FromProto.$preInc() , FromProtoLoc.$preInc()) {
      ObjCProtocolDecl /*P*/ ToProto = cast_or_null_ObjCProtocolDecl(Importer.Import(FromProto.$star()));
      if (!(ToProto != null)) {
        return true;
      }
      Protocols.push_back(ToProto);
      ProtocolLocs.push_back(Importer.Import(new SourceLocation(FromProtoLoc.$star())));
    }
    
    // FIXME: If we're merging, make sure that the protocol list is the same.
    To.setProtocolList(Protocols.data(), Protocols.size(), 
        ProtocolLocs.data(), Importer.getToContext());
    
    // Import categories. When the categories themselves are imported, they'll
    // hook themselves into this interface.
    for (ObjCCategoryDecl /*P*/ Cat : From.known_categories())  {
      Importer.Import(Cat);
    }
    
    // If we have an @implementation, import it as well.
    if ((From.getImplementation() != null)) {
      ObjCImplementationDecl /*P*/ Impl = cast_or_null_ObjCImplementationDecl(Importer.Import(From.getImplementation()));
      if (!(Impl != null)) {
        return true;
      }
      
      To.setImplementation(Impl);
    }
    if (shouldForceImportDeclContext(Kind)) {
      // Import all of the members of this class.
      ImportDeclContext(From, /*ForceImport=*/ true);
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3769,
   FQN="clang::ASTNodeImporter::ImportDefinition", NM="_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_16ObjCProtocolDeclES2_NS0_20ImportDefinitionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16ImportDefinitionEPNS_16ObjCProtocolDeclES2_NS0_20ImportDefinitionKindE")
  //</editor-fold>
  public boolean ImportDefinition(ObjCProtocolDecl /*P*/ From, 
                  ObjCProtocolDecl /*P*/ To) {
    return ImportDefinition(From, 
                  To, 
                  ImportDefinitionKind.IDK_Default);
  }
  public boolean ImportDefinition(ObjCProtocolDecl /*P*/ From, 
                  ObjCProtocolDecl /*P*/ To, 
                  ImportDefinitionKind Kind/*= IDK_Default*/) {
    if ((To.getDefinition() != null)) {
      if (shouldForceImportDeclContext(Kind)) {
        ImportDeclContext(From);
      }
      return false;
    }
    
    // Start the protocol definition
    To.startDefinition();
    
    // Import protocols
    SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(4, (ObjCProtocolDecl /*P*/ )null);
    SmallVector<SourceLocation> ProtocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    /*const*/type$ptr<SourceLocation> /*P*/ FromProtoLoc = $tryClone(From.protocol_loc_begin());
    for (type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> FromProto = $tryClone(From.protocol_begin()), 
        /*P*/ /*const*/ /*P*/ FromProtoEnd = $tryClone(From.protocol_end());
         $noteq_ptr(FromProto, FromProtoEnd);
         FromProto.$preInc() , FromProtoLoc.$preInc()) {
      ObjCProtocolDecl /*P*/ ToProto = cast_or_null_ObjCProtocolDecl(Importer.Import(FromProto.$star()));
      if (!(ToProto != null)) {
        return true;
      }
      Protocols.push_back(ToProto);
      ProtocolLocs.push_back(Importer.Import(new SourceLocation(FromProtoLoc.$star())));
    }
    
    // FIXME: If we're merging, make sure that the protocol list is the same.
    To.setProtocolList(Protocols.data(), Protocols.size(), 
        ProtocolLocs.data(), Importer.getToContext());
    if (shouldForceImportDeclContext(Kind)) {
      // Import all of the members of this protocol.
      ImportDeclContext(From, /*ForceImport=*/ true);
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportTemplateParameterList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2251,
   FQN="clang::ASTNodeImporter::ImportTemplateParameterList", NM="_ZN5clang15ASTNodeImporter27ImportTemplateParameterListEPNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter27ImportTemplateParameterListEPNS_21TemplateParameterListE")
  //</editor-fold>
  public TemplateParameterList /*P*/ ImportTemplateParameterList(TemplateParameterList /*P*/ Params) {
    SmallVector<NamedDecl /*P*/ > ToParams/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
    ToParams.reserve(Params.size());
    for (type$ptr<NamedDecl /*P*/ /*P*/> P = $tryClone(Params.begin()), 
        /*P*/ /*P*/ PEnd = $tryClone(Params.end());
         $noteq_ptr(P, PEnd); P.$preInc()) {
      Decl /*P*/ To = Importer.Import(P.$star());
      if (!(To != null)) {
        return null;
      }
      
      ToParams.push_back(cast_NamedDecl(To));
    }
    
    return TemplateParameterList.Create(Importer.getToContext(), 
        Importer.Import(Params.getTemplateLoc()), 
        Importer.Import(Params.getLAngleLoc()), 
        new ArrayRef<NamedDecl /*P*/ >(ToParams, true), 
        Importer.Import(Params.getRAngleLoc()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportTemplateArgument">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2272,
   FQN="clang::ASTNodeImporter::ImportTemplateArgument", NM="_ZN5clang15ASTNodeImporter22ImportTemplateArgumentERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22ImportTemplateArgumentERKNS_16TemplateArgumentE")
  //</editor-fold>
  public TemplateArgument ImportTemplateArgument(final /*const*/ TemplateArgument /*&*/ From) {
    switch (From.getKind()) {
     case Null:
      return new TemplateArgument();
     case Type:
      {
        QualType ToType = Importer.Import(From.getAsType());
        if (ToType.isNull()) {
          return new TemplateArgument();
        }
        return new TemplateArgument(new QualType(ToType));
      }
     case Integral:
      {
        QualType ToType = Importer.Import(From.getIntegralType());
        if (ToType.isNull()) {
          return new TemplateArgument();
        }
        return new TemplateArgument(From, new QualType(ToType));
      }
     case Declaration:
      {
        ValueDecl /*P*/ To = cast_or_null_ValueDecl(Importer.Import(From.getAsDecl()));
        QualType ToType = Importer.Import(From.getParamTypeForDecl());
        if (!(To != null) || ToType.isNull()) {
          return new TemplateArgument();
        }
        return new TemplateArgument(To, new QualType(ToType));
      }
     case NullPtr:
      {
        QualType ToType = Importer.Import(From.getNullPtrType());
        if (ToType.isNull()) {
          return new TemplateArgument();
        }
        return new TemplateArgument(new QualType(ToType), /*isNullPtr*/ true);
      }
     case Template:
      {
        TemplateName ToTemplate = Importer.Import(From.getAsTemplate());
        if (ToTemplate.isNull()) {
          return new TemplateArgument();
        }
        
        return new TemplateArgument(new TemplateName(ToTemplate));
      }
     case TemplateExpansion:
      {
        TemplateName ToTemplate = Importer.Import(From.getAsTemplateOrTemplatePattern());
        if (ToTemplate.isNull()) {
          return new TemplateArgument();
        }
        
        return new TemplateArgument(new TemplateName(ToTemplate), From.getNumTemplateExpansions());
      }
     case Expression:
      {
        Expr /*P*/ ToExpr = Importer.Import(From.getAsExpr());
        if ((ToExpr != null)) {
          return new TemplateArgument(ToExpr);
        }
      }
      return new TemplateArgument();
     case Pack:
      {
        SmallVector<TemplateArgument> ToPack/*J*/= new SmallVector<TemplateArgument>(2, new TemplateArgument());
        ToPack.reserve(From.pack_size());
        if (ImportTemplateArguments(From.pack_begin(), From.pack_size(), ToPack)) {
          return new TemplateArgument();
        }

        return new TemplateArgument(llvm.makeArrayRef(ToPack).copy(TemplateArgument.class, Importer.getToContext()));
      }
    }
    throw new llvm_unreachable("Invalid template argument kind");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2343,
   FQN="clang::ASTNodeImporter::ImportTemplateArguments", NM="_ZN5clang15ASTNodeImporter23ImportTemplateArgumentsEPKNS_16TemplateArgumentEjRN4llvm15SmallVectorImplIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23ImportTemplateArgumentsEPKNS_16TemplateArgumentEjRN4llvm15SmallVectorImplIS1_EE")
  //</editor-fold>
  public boolean ImportTemplateArguments(/*const*/type$ptr<TemplateArgument/*P*/> FromArgs, 
                         /*uint*/int NumFromArgs, 
                         final SmallVectorImpl<TemplateArgument> /*&*/ ToArgs) {
    for (/*uint*/int I = 0; I != NumFromArgs; ++I) {
      TemplateArgument To = ImportTemplateArgument(FromArgs.$at(I));
      if (To.isNull() && !FromArgs.$at(I).isNull()) {
        return true;
      }
      
      ToArgs.push_back(To);
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::IsStructuralMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2357,
   FQN="clang::ASTNodeImporter::IsStructuralMatch", NM="_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_10RecordDeclES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_10RecordDeclES2_b")
  //</editor-fold>
  public boolean IsStructuralMatch(RecordDecl /*P*/ FromRecord, 
                   RecordDecl /*P*/ ToRecord) {
    return IsStructuralMatch(FromRecord, 
                   ToRecord, true);
  }
  public boolean IsStructuralMatch(RecordDecl /*P*/ FromRecord, 
                   RecordDecl /*P*/ ToRecord, boolean Complain/*= true*/) {
    StructuralEquivalenceContext Ctx = null;
    try {
      // Eliminate a potential failure point where we attempt to re-import
      // something we're trying to import while completing ToRecord.
      Decl /*P*/ ToOrigin = Importer.GetOriginalDecl(ToRecord);
      if ((ToOrigin != null)) {
        RecordDecl /*P*/ ToOriginRecord = dyn_cast_RecordDecl(ToOrigin);
        if ((ToOriginRecord != null)) {
          ToRecord = ToOriginRecord;
        }
      }
      
      Ctx/*J*/= new StructuralEquivalenceContext(Importer.getFromContext(), 
          ToRecord.getASTContext(), 
          Importer.getNonEquivalentDecls(), 
          false, Complain);
      return Ctx.IsStructurallyEquivalent(FromRecord, ToRecord);
    } finally {
      if (Ctx != null) { Ctx.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::IsStructuralMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2375,
   FQN="clang::ASTNodeImporter::IsStructuralMatch", NM="_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_7VarDeclES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_7VarDeclES2_b")
  //</editor-fold>
  public boolean IsStructuralMatch(VarDecl /*P*/ FromVar, VarDecl /*P*/ ToVar) {
    return IsStructuralMatch(FromVar, ToVar, 
                   true);
  }
  public boolean IsStructuralMatch(VarDecl /*P*/ FromVar, VarDecl /*P*/ ToVar, 
                   boolean Complain/*= true*/) {
    StructuralEquivalenceContext Ctx = null;
    try {
      Ctx/*J*/= new StructuralEquivalenceContext(Importer.getFromContext(), Importer.getToContext(), 
          Importer.getNonEquivalentDecls(), false, Complain);
      return Ctx.IsStructurallyEquivalent(FromVar, ToVar);
    } finally {
      if (Ctx != null) { Ctx.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::IsStructuralMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2383,
   FQN="clang::ASTNodeImporter::IsStructuralMatch", NM="_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_8EnumDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_8EnumDeclES2_")
  //</editor-fold>
  public boolean IsStructuralMatch(EnumDecl /*P*/ FromEnum, EnumDecl /*P*/ ToEnum) {
    StructuralEquivalenceContext Ctx = null;
    try {
      Ctx/*J*/= new StructuralEquivalenceContext(Importer.getFromContext(), 
          Importer.getToContext(), 
          Importer.getNonEquivalentDecls());
      return Ctx.IsStructurallyEquivalent(FromEnum, ToEnum);
    } finally {
      if (Ctx != null) { Ctx.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::IsStructuralMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2390,
   FQN="clang::ASTNodeImporter::IsStructuralMatch", NM="_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_16EnumConstantDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_16EnumConstantDeclES2_")
  //</editor-fold>
  public boolean IsStructuralMatch(EnumConstantDecl /*P*/ FromEC, 
                   EnumConstantDecl /*P*/ ToEC) {
    final /*const*/ APSInt /*&*/ FromVal = FromEC.getInitVal();
    final /*const*/ APSInt /*&*/ ToVal = ToEC.getInitVal();
    
    return FromVal.isSigned() == ToVal.isSigned()
       && FromVal.getBitWidth() == ToVal.getBitWidth()
       && FromVal.$eq(ToVal);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::IsStructuralMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2401,
   FQN="clang::ASTNodeImporter::IsStructuralMatch", NM="_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_17ClassTemplateDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_17ClassTemplateDeclES2_")
  //</editor-fold>
  public boolean IsStructuralMatch(ClassTemplateDecl /*P*/ From, 
                   ClassTemplateDecl /*P*/ To) {
    StructuralEquivalenceContext Ctx = null;
    try {
      Ctx/*J*/= new StructuralEquivalenceContext(Importer.getFromContext(), 
          Importer.getToContext(), 
          Importer.getNonEquivalentDecls());
      return Ctx.IsStructurallyEquivalent(From, To);
    } finally {
      if (Ctx != null) { Ctx.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::IsStructuralMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2409,
   FQN="clang::ASTNodeImporter::IsStructuralMatch", NM="_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_15VarTemplateDeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17IsStructuralMatchEPNS_15VarTemplateDeclES2_")
  //</editor-fold>
  public boolean IsStructuralMatch(VarTemplateDecl /*P*/ From, 
                   VarTemplateDecl /*P*/ To) {
    StructuralEquivalenceContext Ctx = null;
    try {
      Ctx/*J*/= new StructuralEquivalenceContext(Importer.getFromContext(), 
          Importer.getToContext(), 
          Importer.getNonEquivalentDecls());
      return Ctx.IsStructurallyEquivalent(From, To);
    } finally {
      if (Ctx != null) { Ctx.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2417,
   FQN="clang::ASTNodeImporter::VisitDecl", NM="_ZN5clang15ASTNodeImporter9VisitDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter9VisitDeclEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ VisitDecl(Decl /*P*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Importer.FromDiag(D.getLocation(), diag.err_unsupported_ast_node)), 
          D.getDeclKindName()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitAccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2432,
   FQN="clang::ASTNodeImporter::VisitAccessSpecDecl", NM="_ZN5clang15ASTNodeImporter19VisitAccessSpecDeclEPNS_14AccessSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitAccessSpecDeclEPNS_14AccessSpecDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitAccessSpecDecl(AccessSpecDecl /*P*/ D) {
    
    SourceLocation Loc = Importer.Import(D.getLocation());
    SourceLocation ColonLoc = Importer.Import(D.getColonLoc());
    
    // Import the context of this declaration.
    DeclContext /*P*/ DC = Importer.ImportContext(D.getDeclContext());
    if (!(DC != null)) {
      return null;
    }
    
    AccessSpecDecl /*P*/ accessSpecDecl = AccessSpecDecl.Create(Importer.getToContext(), D.getAccess(), 
        DC, new SourceLocation(Loc), new SourceLocation(ColonLoc));
    if (!(accessSpecDecl != null)) {
      return null;
    }
    
    // Lexical DeclContext and Semantic DeclContext
    // is always the same for the accessSpec.
    accessSpecDecl.setLexicalDeclContext(DC);
    DC.addDeclInternal(accessSpecDecl);
    
    return accessSpecDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2423,
   FQN="clang::ASTNodeImporter::VisitTranslationUnitDecl", NM="_ZN5clang15ASTNodeImporter24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTranslationUnitDecl(TranslationUnitDecl /*P*/ D) {
    TranslationUnitDecl /*P*/ ToD = Importer.getToContext().getTranslationUnitDecl();
    
    Importer.Imported(D, ToD);
    
    return ToD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2457,
   FQN="clang::ASTNodeImporter::VisitNamespaceDecl", NM="_ZN5clang15ASTNodeImporter18VisitNamespaceDeclEPNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitNamespaceDeclEPNS_13NamespaceDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitNamespaceDecl(NamespaceDecl /*P*/ D) {
    // Import the major distinguishing characteristics of this namespace.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    NamespaceDecl /*P*/ MergeWithNamespace = null;
    if (!Name.$bool()) {
      {
        // This is an anonymous namespace. Adopt an existing anonymous
        // namespace if we can.
        // FIXME: Not testable.
        TranslationUnitDecl /*P*/ TU = dyn_cast_TranslationUnitDecl(DC.$deref());
        if ((TU != null)) {
          MergeWithNamespace = TU.getAnonymousNamespace();
        } else {
          MergeWithNamespace = cast_NamespaceDecl(DC.$deref()).getAnonymousNamespace();
        }
      }
    } else {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_Namespace)) {
          continue;
        }
        {
          
          NamespaceDecl /*P*/ FoundNS = dyn_cast_NamespaceDecl(FoundDecls.$at(I));
          if ((FoundNS != null)) {
            MergeWithNamespace = FoundNS;
            ConflictingDecls.clear();
            break;
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), Decl.IdentifierNamespace.IDNS_Namespace, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
      }
    }
    
    // Create the "to" namespace, if needed.
    NamespaceDecl /*P*/ ToNamespace = MergeWithNamespace;
    if (!(ToNamespace != null)) {
      ToNamespace = NamespaceDecl.Create(Importer.getToContext(), DC.$deref(), 
          D.isInline(), 
          Importer.Import(D.getLocStart()), 
          new SourceLocation(Loc), Name.getAsIdentifierInfo(), 
          /*PrevDecl=*/ (NamespaceDecl /*P*/ )null);
      ToNamespace.setLexicalDeclContext(LexicalDC.$deref());
      LexicalDC.$deref().addDeclInternal(ToNamespace);
      
      // If this is an anonymous namespace, register it as the anonymous
      // namespace within its context.
      if (!Name.$bool()) {
        {
          TranslationUnitDecl /*P*/ TU = dyn_cast_TranslationUnitDecl(DC.$deref());
          if ((TU != null)) {
            TU.setAnonymousNamespace(ToNamespace);
          } else {
            cast_NamespaceDecl(DC.$deref()).setAnonymousNamespace(ToNamespace);
          }
        }
      }
    }
    Importer.Imported(D, ToNamespace);
    
    ImportDeclContext(D);
    
    return ToNamespace;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2528,
   FQN="clang::ASTNodeImporter::VisitTypedefNameDecl", NM="_ZN5clang15ASTNodeImporter20VisitTypedefNameDeclEPNS_15TypedefNameDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitTypedefNameDeclEPNS_15TypedefNameDeclEb")
  //</editor-fold>
  public Decl /*P*/ VisitTypedefNameDecl(TypedefNameDecl /*P*/ D, boolean IsAlias) {
    // Import the major distinguishing characteristics of this typedef.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // If this typedef is not in block scope, determine whether we've
    // seen a typedef with the same name (that we can merge with) or any
    // other entity by that name (which name lookup could conflict with).
    if (!DC.$deref().isFunctionOrMethod()) {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(IDNS)) {
          continue;
        }
        {
          TypedefNameDecl /*P*/ FoundTypedef = dyn_cast_TypedefNameDecl(FoundDecls.$at(I));
          if ((FoundTypedef != null)) {
            if (Importer.IsStructurallyEquivalent(D.getUnderlyingType(), 
                FoundTypedef.getUnderlyingType())) {
              return Importer.Imported(D, FoundTypedef);
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), IDNS, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
        if (!Name.$bool()) {
          return null;
        }
      }
    }
    
    // Import the underlying type of this typedef;
    QualType T = Importer.Import(D.getUnderlyingType());
    if (T.isNull()) {
      return null;
    }
    
    // Create the new typedef node.
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    SourceLocation StartL = Importer.Import(D.getLocStart());
    TypedefNameDecl /*P*/ ToTypedef;
    if (IsAlias) {
      ToTypedef = TypeAliasDecl.Create(Importer.getToContext(), DC.$deref(), 
          new SourceLocation(StartL), new SourceLocation(Loc), 
          Name.getAsIdentifierInfo(), 
          TInfo);
    } else {
      ToTypedef = TypedefDecl.Create(Importer.getToContext(), DC.$deref(), 
          new SourceLocation(StartL), new SourceLocation(Loc), 
          Name.getAsIdentifierInfo(), 
          TInfo);
    }
    
    ToTypedef.setAccess(D.getAccess());
    ToTypedef.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, ToTypedef);
    LexicalDC.$deref().addDeclInternal(ToTypedef);
    
    return ToTypedef;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2597,
   FQN="clang::ASTNodeImporter::VisitTypedefDecl", NM="_ZN5clang15ASTNodeImporter16VisitTypedefDeclEPNS_11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitTypedefDeclEPNS_11TypedefDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTypedefDecl(TypedefDecl /*P*/ D) {
    return VisitTypedefNameDecl(D, /*IsAlias=*/ false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2601,
   FQN="clang::ASTNodeImporter::VisitTypeAliasDecl", NM="_ZN5clang15ASTNodeImporter18VisitTypeAliasDeclEPNS_13TypeAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitTypeAliasDeclEPNS_13TypeAliasDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTypeAliasDecl(TypeAliasDecl /*P*/ D) {
    return VisitTypedefNameDecl(D, /*IsAlias=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitLabelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2605,
   FQN="clang::ASTNodeImporter::VisitLabelDecl", NM="_ZN5clang15ASTNodeImporter14VisitLabelDeclEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitLabelDeclEPNS_9LabelDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitLabelDecl(LabelDecl /*P*/ D) {
    // Import the major distinguishing characteristics of this label.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    assert (LexicalDC.$deref().isFunctionOrMethod());
    
    LabelDecl /*P*/ ToLabel = D.isGnuLocal() ? LabelDecl.Create(Importer.getToContext(), 
        DC.$deref(), Importer.Import(D.getLocation()), 
        Name.getAsIdentifierInfo(), 
        Importer.Import(D.getLocStart())) : LabelDecl.Create(Importer.getToContext(), 
        DC.$deref(), Importer.Import(D.getLocation()), 
        Name.getAsIdentifierInfo());
    Importer.Imported(D, ToLabel);
    
    LabelStmt /*P*/ Label = cast_or_null_LabelStmt(Importer.Import(D.getStmt()));
    if (!(Label != null)) {
      return null;
    }
    
    ToLabel.setStmt(Label);
    ToLabel.setLexicalDeclContext(LexicalDC.$deref());
    LexicalDC.$deref().addDeclInternal(ToLabel);
    return ToLabel;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitEnumDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2638,
   FQN="clang::ASTNodeImporter::VisitEnumDecl", NM="_ZN5clang15ASTNodeImporter13VisitEnumDeclEPNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitEnumDeclEPNS_8EnumDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitEnumDecl(EnumDecl /*P*/ D) {
    // Import the major distinguishing characteristics of this enum.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Figure out what enum name we're looking for.
    /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Tag;
    DeclarationName SearchName = new DeclarationName(Name);
    if (!SearchName.$bool() && (D.getTypedefNameForAnonDecl() != null)) {
      SearchName.$assignMove(Importer.Import(D.getTypedefNameForAnonDecl().getDeclName()));
      IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
    } else if (Importer.getToContext().getLangOpts().CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Ordinary;
    }
    
    // We may already have an enum of the same name; try to find and match it.
    if (!DC.$deref().isFunctionOrMethod() && SearchName.$bool()) {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(IDNS)) {
          continue;
        }
        
        Decl /*P*/ Found = FoundDecls.$at(I);
        {
          TypedefNameDecl /*P*/ Typedef = dyn_cast_TypedefNameDecl(Found);
          if ((Typedef != null)) {
            {
              /*const*/ TagType /*P*/ Tag = Typedef.getUnderlyingType().$arrow().getAs(TagType.class);
              if ((Tag != null)) {
                Found = Tag.getDecl();
              }
            }
          }
        }
        {
          
          EnumDecl /*P*/ FoundEnum = dyn_cast_EnumDecl(Found);
          if ((FoundEnum != null)) {
            if (IsStructuralMatch(D, FoundEnum)) {
              return Importer.Imported(D, FoundEnum);
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), IDNS, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
      }
    }
    
    // Create the enum declaration.
    EnumDecl /*P*/ D2 = EnumDecl.Create(Importer.getToContext(), DC.$deref(), 
        Importer.Import(D.getLocStart()), 
        new SourceLocation(Loc), Name.getAsIdentifierInfo(), (EnumDecl /*P*/ )null, 
        D.isScoped(), D.isScopedUsingClassTag(), 
        D.isFixed());
    // Import the qualifier, if any.
    D2.setQualifierInfo(Importer.Import(D.getQualifierLoc()));
    D2.setAccess(D.getAccess());
    D2.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, D2);
    LexicalDC.$deref().addDeclInternal(D2);
    
    // Import the integer type.
    QualType ToIntegerType = Importer.Import(D.getIntegerType());
    if (ToIntegerType.isNull()) {
      return null;
    }
    D2.setIntegerType(new QualType(ToIntegerType));
    
    // Import the definition
    if (D.isCompleteDefinition() && ImportDefinition(D, D2)) {
      return null;
    }
    
    return D2;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2714,
   FQN="clang::ASTNodeImporter::VisitRecordDecl", NM="_ZN5clang15ASTNodeImporter15VisitRecordDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitRecordDeclEPNS_10RecordDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitRecordDecl(RecordDecl /*P*/ D) {
    // If this record has a definition in the translation unit we're coming from,
    // but this particular declaration is not that definition, import the
    // definition and map to that.
    TagDecl /*P*/ Definition = D.getDefinition();
    if ((Definition != null) && Definition != D) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition);
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    // Import the major distinguishing characteristics of this record.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Figure out what structure name we're looking for.
    /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Tag;
    DeclarationName SearchName = new DeclarationName(Name);
    if (!SearchName.$bool() && (D.getTypedefNameForAnonDecl() != null)) {
      SearchName.$assignMove(Importer.Import(D.getTypedefNameForAnonDecl().getDeclName()));
      IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
    } else if (Importer.getToContext().getLangOpts().CPlusPlus) {
      IDNS |= Decl.IdentifierNamespace.IDNS_Ordinary;
    }
    
    // We may already have a record of the same name; try to find and match it.
    RecordDecl /*P*/ AdoptDecl = null;
    if (!DC.$deref().isFunctionOrMethod()) {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(IDNS)) {
          continue;
        }
        
        Decl /*P*/ Found = FoundDecls.$at(I);
        {
          TypedefNameDecl /*P*/ Typedef = dyn_cast_TypedefNameDecl(Found);
          if ((Typedef != null)) {
            {
              /*const*/ TagType /*P*/ Tag = Typedef.getUnderlyingType().$arrow().getAs(TagType.class);
              if ((Tag != null)) {
                Found = Tag.getDecl();
              }
            }
          }
        }
        {
          
          RecordDecl /*P*/ FoundRecord = dyn_cast_RecordDecl(Found);
          if ((FoundRecord != null)) {
            if (D.isAnonymousStructOrUnion()
               && FoundRecord.isAnonymousStructOrUnion()) {
              {
                // If both anonymous structs/unions are in a record context, make sure
                // they occur in the same location in the context records.
                OptionalUInt Index1 = findUntaggedStructOrUnionIndex(D);
                if (Index1.$bool()) {
                  {
                    OptionalUInt Index2 = findUntaggedStructOrUnionIndex(FoundRecord);
                    if (Index2.$bool()) {
                      if (Index1.$star() != Index2.$star()) {
                        continue;
                      }
                    }
                  }
                }
              }
            }
            {
              
              RecordDecl /*P*/ FoundDef = FoundRecord.getDefinition();
              if ((FoundDef != null)) {
                if ((SearchName.$bool() && !D.isCompleteDefinition())
                   || (D.isCompleteDefinition()
                   && D.isAnonymousStructOrUnion()
                   == FoundDef.isAnonymousStructOrUnion()
                   && IsStructuralMatch(D, FoundDef))) {
                  // The record types structurally match, or the "from" translation
                  // unit only had a forward declaration anyway; call it the same
                  // function.
                  // FIXME: For C++, we should also merge methods here.
                  return Importer.Imported(D, FoundDef);
                }
              } else if (!D.isCompleteDefinition()) {
                // We have a forward declaration of this type, so adopt that forward
                // declaration rather than building a new one.
                
                // If one or both can be completed from external storage then try one
                // last time to complete and compare them before doing this.
                if (FoundRecord.hasExternalLexicalStorage()
                   && !FoundRecord.isCompleteDefinition()) {
                  FoundRecord.getASTContext().getExternalSource().CompleteType(FoundRecord);
                }
                if (D.hasExternalLexicalStorage()) {
                  D.getASTContext().getExternalSource().CompleteType(D);
                }
                if (FoundRecord.isCompleteDefinition()
                   && D.isCompleteDefinition()
                   && !IsStructuralMatch(D, FoundRecord)) {
                  continue;
                }
                
                AdoptDecl = FoundRecord;
                continue;
              } else if (!SearchName.$bool()) {
                continue;
              }
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty() && SearchName.$bool()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), IDNS, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
      }
    }
    
    // Create the record declaration.
    RecordDecl /*P*/ D2 = AdoptDecl;
    SourceLocation StartLoc = Importer.Import(D.getLocStart());
    if (!(D2 != null)) {
      CXXRecordDecl /*P*/ D2CXX = null;
      {
        CXXRecordDecl /*P*/ DCXX = dyn_cast_CXXRecordDecl(D);
        if ((DCXX != null)) {
          if (DCXX.isLambda()) {
            TypeSourceInfo /*P*/ TInfo = Importer.Import(DCXX.getLambdaTypeInfo());
            D2CXX = CXXRecordDecl.CreateLambda(Importer.getToContext(), 
                DC.$deref(), TInfo, new SourceLocation(Loc), 
                DCXX.isDependentLambda(), 
                DCXX.isGenericLambda(), 
                DCXX.getLambdaCaptureDefault());
            Decl /*P*/ CDecl = Importer.Import(DCXX.getLambdaContextDecl());
            if ((DCXX.getLambdaContextDecl() != null) && !(CDecl != null)) {
              return null;
            }
            D2CXX.setLambdaMangling(DCXX.getLambdaManglingNumber(), CDecl);
          } else if (DCXX.isInjectedClassName()) {
            // We have to be careful to do a similar dance to the one in                            
            // Sema::ActOnStartCXXMemberDeclarations                                                
            CXXRecordDecl /*P*/ /*const*/ PrevDecl = null;
            /*const*/boolean DelayTypeCreation = true;
            D2CXX = CXXRecordDecl.Create(Importer.getToContext(), D.getTagKind(), DC.$deref(), new SourceLocation(StartLoc), new SourceLocation(Loc), 
                Name.getAsIdentifierInfo(), PrevDecl, DelayTypeCreation);
            Importer.getToContext().getTypeDeclType(D2CXX, dyn_cast_CXXRecordDecl(DC.$deref()));
          } else {
            D2CXX = CXXRecordDecl.Create(Importer.getToContext(), 
                D.getTagKind(), 
                DC.$deref(), new SourceLocation(StartLoc), new SourceLocation(Loc), 
                Name.getAsIdentifierInfo());
          }
          D2 = D2CXX;
          D2.setAccess(D.getAccess());
        } else {
          D2 = RecordDecl.Create(Importer.getToContext(), D.getTagKind(), 
              DC.$deref(), new SourceLocation(StartLoc), new SourceLocation(Loc), Name.getAsIdentifierInfo());
        }
      }
      
      D2.setQualifierInfo(Importer.Import(D.getQualifierLoc()));
      D2.setLexicalDeclContext(LexicalDC.$deref());
      LexicalDC.$deref().addDeclInternal(D2);
      if (D.isAnonymousStructOrUnion()) {
        D2.setAnonymousStructOrUnion(true);
      }
    }
    
    Importer.Imported(D, D2);
    if (D.isCompleteDefinition() && ImportDefinition(D, D2, ImportDefinitionKind.IDK_Default)) {
      return null;
    }
    
    return D2;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2879,
   FQN="clang::ASTNodeImporter::VisitEnumConstantDecl", NM="_ZN5clang15ASTNodeImporter21VisitEnumConstantDeclEPNS_16EnumConstantDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitEnumConstantDeclEPNS_16EnumConstantDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitEnumConstantDecl(EnumConstantDecl /*P*/ D) {
    // Import the major distinguishing characteristics of this enumerator.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    // Determine whether there are any other declarations with the same name and 
    // in the same context.
    if (!LexicalDC.$deref().isFunctionOrMethod()) {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(IDNS)) {
          continue;
        }
        {
          
          EnumConstantDecl /*P*/ FoundEnumConstant = dyn_cast_EnumConstantDecl(FoundDecls.$at(I));
          if ((FoundEnumConstant != null)) {
            if (IsStructuralMatch(D, FoundEnumConstant)) {
              return Importer.Imported(D, FoundEnumConstant);
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), IDNS, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
        if (!Name.$bool()) {
          return null;
        }
      }
    }
    
    Expr /*P*/ Init = Importer.Import(D.getInitExpr());
    if ((D.getInitExpr() != null) && !(Init != null)) {
      return null;
    }
    
    EnumConstantDecl /*P*/ ToEnumerator = EnumConstantDecl.Create(Importer.getToContext(), cast_EnumDecl(DC.$deref()), new SourceLocation(Loc), 
        Name.getAsIdentifierInfo(), new QualType(T), 
        Init, D.getInitVal());
    ToEnumerator.setAccess(D.getAccess());
    ToEnumerator.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, ToEnumerator);
    LexicalDC.$deref().addDeclInternal(ToEnumerator);
    return ToEnumerator;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 2938,
   FQN="clang::ASTNodeImporter::VisitFunctionDecl", NM="_ZN5clang15ASTNodeImporter17VisitFunctionDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitFunctionDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFunctionDecl(FunctionDecl /*P*/ D) {
    // Import the major distinguishing characteristics of this function.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Try to find a function in our own ("to") context with the same name, same
    // type, and in the same context as the function we're importing.
    if (!LexicalDC.$deref().isFunctionOrMethod()) {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(IDNS)) {
          continue;
        }
        {
          
          FunctionDecl /*P*/ FoundFunction = dyn_cast_FunctionDecl(FoundDecls.$at(I));
          if ((FoundFunction != null)) {
            if (FoundFunction.hasExternalFormalLinkage()
               && D.hasExternalFormalLinkage()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if (Importer.IsStructurallyEquivalent(D.getType(), 
                    FoundFunction.getType())) {
                  // FIXME: Actually try to merge the body and other attributes.
                  return Importer.Imported(D, FoundFunction);
                }
                
                // FIXME: Check for overloading more carefully, e.g., by boosting
                // Sema::IsOverload out to the AST library.
                
                // Function overloading is okay in C++.
                if (Importer.getToContext().getLangOpts().CPlusPlus) {
                  continue;
                }
                
                // Complain about inconsistent function types.
                $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_function_type_inconsistent)), 
                            /*NO_COPY*/Name), D.getType()), FoundFunction.getType()));
                $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag(FoundFunction.getLocation(), 
                        diag.note_odr_value_here)), 
                    FoundFunction.getType()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), IDNS, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
        if (!Name.$bool()) {
          return null;
        }
      }
    }
    
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(Loc));
    // Import additional name location/type info.
    ImportDeclarationNameLoc(D.getNameInfo(), NameInfo);
    
    QualType FromTy = D.getType();
    boolean usedDifferentExceptionSpec = false;
    {
      
      /*const*/ FunctionProtoType /*P*/ FromFPT = D.getType().$arrow().getAs(FunctionProtoType.class);
      if ((FromFPT != null)) {
        FunctionProtoType.ExtProtoInfo FromEPI = FromFPT.getExtProtoInfo();
        // FunctionProtoType::ExtProtoInfo's ExceptionSpecDecl can point to the
        // FunctionDecl that we are importing the FunctionProtoType for.
        // To avoid an infinite recursion when importing, create the FunctionDecl
        // with a simplified function type and update it afterwards.
        if ((FromEPI.ExceptionSpec.SourceDecl != null)
           || (FromEPI.ExceptionSpec.SourceTemplate != null)
           || (FromEPI.ExceptionSpec.NoexceptExpr != null)) {
          FunctionProtoType.ExtProtoInfo DefaultEPI/*J*/= new FunctionProtoType.ExtProtoInfo();
          FromTy.$assignMove(Importer.getFromContext().getFunctionType(FromFPT.getReturnType(), FromFPT.getParamTypes(), DefaultEPI));
          usedDifferentExceptionSpec = true;
        }
      }
    }
    
    // Import the type.
    QualType T = Importer.Import(new QualType(FromTy));
    if (T.isNull()) {
      return null;
    }
    
    // Import the function parameters.
    SmallVector<ParmVarDecl /*P*/ > Parameters/*J*/= new SmallVector<ParmVarDecl /*P*/ >(8, (ParmVarDecl /*P*/ )null);
    for (ParmVarDecl /*P*/ P : D.parameters()) {
      ParmVarDecl /*P*/ ToP = cast_or_null_ParmVarDecl(Importer.Import(P));
      if (!(ToP != null)) {
        return null;
      }
      
      Parameters.push_back(ToP);
    }
    
    // Create the imported function.
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    FunctionDecl /*P*/ ToFunction = null;
    SourceLocation InnerLocStart = Importer.Import(D.getInnerLocStart());
    {
      CXXConstructorDecl /*P*/ FromConstructor = dyn_cast_CXXConstructorDecl(D);
      if ((FromConstructor != null)) {
        ToFunction = CXXConstructorDecl.Create(Importer.getToContext(), 
            cast_CXXRecordDecl(DC.$deref()), 
            new SourceLocation(InnerLocStart), 
            NameInfo, new QualType(T), TInfo, 
            FromConstructor.isExplicit(), 
            D.isInlineSpecified(), 
            D.isImplicit(), 
            D.isConstexpr());
        {
          /*uint*/int NumInitializers = FromConstructor.getNumCtorInitializers();
          if ((NumInitializers != 0)) {
            SmallVector<CXXCtorInitializer /*P*/ > CtorInitializers/*J*/= new SmallVector<CXXCtorInitializer /*P*/ >(4, (CXXCtorInitializer /*P*/ )null);
            for (CXXCtorInitializer /*P*/ I : FromConstructor.inits()) {
              CXXCtorInitializer /*P*/ ToI = cast_or_null_CXXCtorInitializer(Importer.Import(I));
              if (!(ToI != null) && (I != null)) {
                return null;
              }
              CtorInitializers.push_back(ToI);
            }
            type$ptr<CXXCtorInitializer /*P*/ /*P*/> Memory = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
            /*new (Importer.getToContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new CXXCtorInitializer /*P*/ [NumInitializers]);
            std.copy(CtorInitializers.begin(), CtorInitializers.end(), Memory);
            CXXConstructorDecl /*P*/ ToCtor = cast_CXXConstructorDecl(ToFunction);
            ToCtor.setCtorInitializers(Memory);
            ToCtor.setNumCtorInitializers(NumInitializers);
          }
        }
      } else if (isa_CXXDestructorDecl(D)) {
        ToFunction = CXXDestructorDecl.Create(Importer.getToContext(), 
            cast_CXXRecordDecl(DC.$deref()), 
            new SourceLocation(InnerLocStart), 
            NameInfo, new QualType(T), TInfo, 
            D.isInlineSpecified(), 
            D.isImplicit());
      } else {
        CXXConversionDecl /*P*/ FromConversion = dyn_cast_CXXConversionDecl(D);
        if ((FromConversion != null)) {
          ToFunction = CXXConversionDecl.Create(Importer.getToContext(), 
              cast_CXXRecordDecl(DC.$deref()), 
              new SourceLocation(InnerLocStart), 
              NameInfo, new QualType(T), TInfo, 
              D.isInlineSpecified(), 
              FromConversion.isExplicit(), 
              D.isConstexpr(), 
              Importer.Import(D.getLocEnd()));
        } else {
          CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
          if ((Method != null)) {
            ToFunction = CXXMethodDecl.Create(Importer.getToContext(), 
                cast_CXXRecordDecl(DC.$deref()), 
                new SourceLocation(InnerLocStart), 
                NameInfo, new QualType(T), TInfo, 
                Method.getStorageClass(), 
                Method.isInlineSpecified(), 
                D.isConstexpr(), 
                Importer.Import(D.getLocEnd()));
          } else {
            ToFunction = FunctionDecl.Create(Importer.getToContext(), DC.$deref(), 
                new SourceLocation(InnerLocStart), 
                NameInfo, new QualType(T), TInfo, D.getStorageClass(), 
                D.isInlineSpecified(), 
                D.hasWrittenPrototype(), 
                D.isConstexpr());
          }
        }
      }
    }
    
    // Import the qualifier, if any.
    ToFunction.setQualifierInfo(Importer.Import(D.getQualifierLoc()));
    ToFunction.setAccess(D.getAccess());
    ToFunction.setLexicalDeclContext(LexicalDC.$deref());
    ToFunction.setVirtualAsWritten(D.isVirtualAsWritten());
    ToFunction.setTrivial(D.isTrivial());
    ToFunction.setPure(D.isPure());
    Importer.Imported(D, ToFunction);
    
    // Set the parameters.
    for (/*uint*/int I = 0, N = Parameters.size(); I != N; ++I) {
      Parameters.$at(I).setOwningFunction(ToFunction);
      ToFunction.addDeclInternal(Parameters.$at(I));
    }
    ToFunction.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Parameters, true));
    if (usedDifferentExceptionSpec) {
      // Update FunctionProtoType::ExtProtoInfo.
      QualType T$1 = Importer.Import(D.getType());
      if (T$1.isNull()) {
        return null;
      }
      ToFunction.setType(new QualType(T$1));
    }
    {
      
      // Import the body, if any.
      Stmt /*P*/ FromBody = D.getBody();
      if ((FromBody != null)) {
        {
          Stmt /*P*/ ToBody = Importer.Import(FromBody);
          if ((ToBody != null)) {
            ToFunction.setBody(ToBody);
          }
        }
      }
    }
    
    // FIXME: Other bits to merge?
    
    // Add this function to the lexical context.
    LexicalDC.$deref().addDeclInternal(ToFunction);
    
    return ToFunction;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3139,
   FQN="clang::ASTNodeImporter::VisitCXXMethodDecl", NM="_ZN5clang15ASTNodeImporter18VisitCXXMethodDeclEPNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitCXXMethodDeclEPNS_13CXXMethodDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXMethodDecl(CXXMethodDecl /*P*/ D) {
    return VisitFunctionDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXConstructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3143,
   FQN="clang::ASTNodeImporter::VisitCXXConstructorDecl", NM="_ZN5clang15ASTNodeImporter23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXConstructorDecl(CXXConstructorDecl /*P*/ D) {
    return VisitCXXMethodDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3147,
   FQN="clang::ASTNodeImporter::VisitCXXDestructorDecl", NM="_ZN5clang15ASTNodeImporter22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXDestructorDecl(CXXDestructorDecl /*P*/ D) {
    return VisitCXXMethodDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXConversionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3151,
   FQN="clang::ASTNodeImporter::VisitCXXConversionDecl", NM="_ZN5clang15ASTNodeImporter22VisitCXXConversionDeclEPNS_17CXXConversionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitCXXConversionDeclEPNS_17CXXConversionDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitCXXConversionDecl(CXXConversionDecl /*P*/ D) {
    return VisitCXXMethodDecl(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3172,
   FQN="clang::ASTNodeImporter::VisitFieldDecl", NM="_ZN5clang15ASTNodeImporter14VisitFieldDeclEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitFieldDeclEPNS_9FieldDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitFieldDecl(FieldDecl /*P*/ D) {
    // Import the major distinguishing characteristics of a variable.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Determine whether we've already imported this field. 
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      {
        FieldDecl /*P*/ FoundField = dyn_cast_FieldDecl(FoundDecls.$at(I));
        if ((FoundField != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // For anonymous fields, match up by index.
            if (!Name.$bool() && getFieldIndex(D) != getFieldIndex(FoundField)) {
              continue;
            }
            if (Importer.IsStructurallyEquivalent(D.getType(), 
                FoundField.getType())) {
              Importer.Imported(D, FoundField);
              return FoundField;
            }
            
            $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_field_type_inconsistent)), 
                        /*NO_COPY*/Name), D.getType()), FoundField.getType()));
            $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag(FoundField.getLocation(), diag.note_odr_value_here)), 
                FoundField.getType()));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Import the type.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    Expr /*P*/ BitWidth = Importer.Import(D.getBitWidth());
    if (!(BitWidth != null) && (D.getBitWidth() != null)) {
      return null;
    }
    
    FieldDecl /*P*/ ToField = FieldDecl.Create(Importer.getToContext(), DC.$deref(), 
        Importer.Import(D.getInnerLocStart()), 
        new SourceLocation(Loc), Name.getAsIdentifierInfo(), 
        new QualType(T), TInfo, BitWidth, D.isMutable(), 
        D.getInClassInitStyle());
    ToField.setAccess(D.getAccess());
    ToField.setLexicalDeclContext(LexicalDC.$deref());
    {
      Expr /*P*/ FromInitializer = D.getInClassInitializer();
      if ((FromInitializer != null)) {
        Expr /*P*/ ToInitializer = Importer.Import(FromInitializer);
        if ((ToInitializer != null)) {
          ToField.setInClassInitializer(ToInitializer);
        } else {
          return null;
        }
      }
    }
    ToField.setImplicit(D.isImplicit());
    Importer.Imported(D, ToField);
    LexicalDC.$deref().addDeclInternal(ToField);
    return ToField;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitIndirectFieldDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3236,
   FQN="clang::ASTNodeImporter::VisitIndirectFieldDecl", NM="_ZN5clang15ASTNodeImporter22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitIndirectFieldDecl(IndirectFieldDecl /*P*/ D) {
    // Import the major distinguishing characteristics of a variable.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Determine whether we've already imported this field. 
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      {
        IndirectFieldDecl /*P*/ FoundField = dyn_cast_IndirectFieldDecl(FoundDecls.$at(I));
        if ((FoundField != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // For anonymous indirect fields, match up by index.
            if (!Name.$bool() && getFieldIndex(D) != getFieldIndex(FoundField)) {
              continue;
            }
            if (Importer.IsStructurallyEquivalent(D.getType(), 
                FoundField.getType(), 
                !Name.isEmpty())) {
              Importer.Imported(D, FoundField);
              return FoundField;
            }
            
            // If there are more anonymous fields to check, continue.
            if (!Name.$bool() && $less_uint(I, N - 1)) {
              continue;
            }
            
            $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_field_type_inconsistent)), 
                        /*NO_COPY*/Name), D.getType()), FoundField.getType()));
            $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag(FoundField.getLocation(), diag.note_odr_value_here)), 
                FoundField.getType()));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Import the type.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    type$ptr<NamedDecl /*P*/ /*P*/> NamedChain = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Importer.getToContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new NamedDecl /*P*/ [D.getChainingSize()]);
    
    /*uint*/int i = 0;
    for (NamedDecl /*P*/ PI : D.chain()) {
      Decl /*P*/ D$1 = Importer.Import(PI);
      if (!(D$1 != null)) {
        return null;
      }
      NamedChain.$set(i++, cast_NamedDecl(D$1));
    }
    
    IndirectFieldDecl /*P*/ ToIndirectField = IndirectFieldDecl.Create(Importer.getToContext(), DC.$deref(), new SourceLocation(Loc), Name.getAsIdentifierInfo(), new QualType(T), 
        /*{ */new MutableArrayRef<NamedDecl /*P*/ >(NamedChain, D.getChainingSize(), true)/* }*/);
    
    for (/*const*/ Attr /*P*/ $Attr : D.attrs())  {
      ToIndirectField.addAttr($Attr.clone(Importer.getToContext()));
    }
    
    ToIndirectField.setAccess(D.getAccess());
    ToIndirectField.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, ToIndirectField);
    LexicalDC.$deref().addDeclInternal(ToIndirectField);
    return ToIndirectField;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3306,
   FQN="clang::ASTNodeImporter::VisitObjCIvarDecl", NM="_ZN5clang15ASTNodeImporter17VisitObjCIvarDeclEPNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitObjCIvarDeclEPNS_12ObjCIvarDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCIvarDecl(ObjCIvarDecl /*P*/ D) {
    // Import the major distinguishing characteristics of an ivar.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Determine whether we've already imported this ivar 
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      {
        ObjCIvarDecl /*P*/ FoundIvar = dyn_cast_ObjCIvarDecl(FoundDecls.$at(I));
        if ((FoundIvar != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (Importer.IsStructurallyEquivalent(D.getType(), 
                FoundIvar.getType())) {
              Importer.Imported(D, FoundIvar);
              return FoundIvar;
            }
            
            $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_ivar_type_inconsistent)), 
                        /*NO_COPY*/Name), D.getType()), FoundIvar.getType()));
            $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag(FoundIvar.getLocation(), diag.note_odr_value_here)), 
                FoundIvar.getType()));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Import the type.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    Expr /*P*/ BitWidth = Importer.Import(D.getBitWidth());
    if (!(BitWidth != null) && (D.getBitWidth() != null)) {
      return null;
    }
    
    ObjCIvarDecl /*P*/ ToIvar = ObjCIvarDecl.Create(Importer.getToContext(), 
        cast_ObjCContainerDecl(DC.$deref()), 
        Importer.Import(D.getInnerLocStart()), 
        new SourceLocation(Loc), Name.getAsIdentifierInfo(), 
        new QualType(T), TInfo, D.getAccessControl(), 
        BitWidth, D.getSynthesize());
    ToIvar.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, ToIvar);
    LexicalDC.$deref().addDeclInternal(ToIvar);
    return ToIvar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3359,
   FQN="clang::ASTNodeImporter::VisitVarDecl", NM="_ZN5clang15ASTNodeImporter12VisitVarDeclEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter12VisitVarDeclEPNS_7VarDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarDecl(VarDecl /*P*/ D) {
    // Import the major distinguishing characteristics of a variable.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Try to find a variable in our own ("to") context with the same name and
    // in the same context as the variable we're importing.
    if (D.isFileVarDecl()) {
      VarDecl /*P*/ MergeWithVar = null;
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      /*uint*/int IDNS = Decl.IdentifierNamespace.IDNS_Ordinary;
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(IDNS)) {
          continue;
        }
        {
          
          VarDecl /*P*/ FoundVar = dyn_cast_VarDecl(FoundDecls.$at(I));
          if ((FoundVar != null)) {
            // We have found a variable that we may need to merge with. Check it.
            if (FoundVar.hasExternalFormalLinkage()
               && D.hasExternalFormalLinkage()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if (Importer.IsStructurallyEquivalent(D.getType(), 
                    FoundVar.getType())) {
                  MergeWithVar = FoundVar;
                  break;
                }
                
                /*const*/ ArrayType /*P*/ FoundArray = Importer.getToContext().getAsArrayType(FoundVar.getType());
                /*const*/ ArrayType /*P*/ TArray = Importer.getToContext().getAsArrayType(D.getType());
                if ((FoundArray != null) && (TArray != null)) {
                  if (isa_IncompleteArrayType(FoundArray)
                     && isa_ConstantArrayType(TArray)) {
                    // Import the type.
                    QualType T = Importer.Import(D.getType());
                    if (T.isNull()) {
                      return null;
                    }
                    
                    FoundVar.setType(new QualType(T));
                    MergeWithVar = FoundVar;
                    break;
                  } else if (isa_IncompleteArrayType(TArray)
                     && isa_ConstantArrayType(FoundArray)) {
                    MergeWithVar = FoundVar;
                    break;
                  }
                }
                
                $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_variable_type_inconsistent)), 
                            /*NO_COPY*/Name), D.getType()), FoundVar.getType()));
                $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag(FoundVar.getLocation(), diag.note_odr_value_here)), 
                    FoundVar.getType()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if ((MergeWithVar != null)) {
        // An equivalent variable with external linkage has been found. Link 
        // the two declarations, then merge them.
        Importer.Imported(D, MergeWithVar);
        {
          
          VarDecl /*P*/ DDef = D.getDefinition();
          if ((DDef != null)) {
            {
              VarDecl /*P*/ ExistingDef = MergeWithVar.getDefinition();
              if ((ExistingDef != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(ExistingDef.getLocation(), 
                          diag.err_odr_variable_multiple_def)), 
                      /*NO_COPY*/Name));
                  $c$.clean($c$.track(Importer.FromDiag(DDef.getLocation(), diag.note_odr_defined_here)));
                } finally {
                  $c$.$destroy();
                }
              } else {
                Expr /*P*/ Init = Importer.Import(DDef.getInit());
                MergeWithVar.setInit(Init);
                if (DDef.isInitKnownICE()) {
                  EvaluatedStmt /*P*/ Eval = MergeWithVar.ensureEvaluatedStmt();
                  Eval.CheckedICE = true;
                  Eval.IsICE = DDef.isInitICE();
                }
              }
            }
          }
        }
        
        return MergeWithVar;
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), IDNS, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
        if (!Name.$bool()) {
          return null;
        }
      }
    }
    
    // Import the type.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    // Create the imported variable.
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    VarDecl /*P*/ ToVar = VarDecl.Create(Importer.getToContext(), DC.$deref(), 
        Importer.Import(D.getInnerLocStart()), 
        new SourceLocation(Loc), Name.getAsIdentifierInfo(), 
        new QualType(T), TInfo, 
        D.getStorageClass());
    ToVar.setQualifierInfo(Importer.Import(D.getQualifierLoc()));
    ToVar.setAccess(D.getAccess());
    ToVar.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, ToVar);
    LexicalDC.$deref().addDeclInternal(ToVar);
    if (!D.isFileVarDecl()
       && D.isUsed()) {
      ToVar.setIsUsed();
    }
    
    // Merge the initializer.
    if (ImportDefinition(D, ToVar)) {
      return null;
    }
    
    return ToVar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitImplicitParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3487,
   FQN="clang::ASTNodeImporter::VisitImplicitParamDecl", NM="_ZN5clang15ASTNodeImporter22VisitImplicitParamDeclEPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitImplicitParamDeclEPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitImplicitParamDecl(ImplicitParamDecl /*P*/ D) {
    // Parameters are created in the translation unit's context, then moved
    // into the function declaration's context afterward.
    DeclContext /*P*/ DC = Importer.getToContext().getTranslationUnitDecl();
    
    // Import the name of this declaration.
    DeclarationName Name = Importer.Import(D.getDeclName());
    if (D.getDeclName().$bool() && !Name.$bool()) {
      return null;
    }
    
    // Import the location of this declaration.
    SourceLocation Loc = Importer.Import(D.getLocation());
    
    // Import the parameter's type.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    // Create the imported parameter.
    ImplicitParamDecl /*P*/ ToParm = ImplicitParamDecl.Create(Importer.getToContext(), DC, 
        new SourceLocation(Loc), Name.getAsIdentifierInfo(), 
        new QualType(T));
    return Importer.Imported(D, ToParm);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3513,
   FQN="clang::ASTNodeImporter::VisitParmVarDecl", NM="_ZN5clang15ASTNodeImporter16VisitParmVarDeclEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitParmVarDeclEPNS_11ParmVarDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitParmVarDecl(ParmVarDecl /*P*/ D) {
    // Parameters are created in the translation unit's context, then moved
    // into the function declaration's context afterward.
    DeclContext /*P*/ DC = Importer.getToContext().getTranslationUnitDecl();
    
    // Import the name of this declaration.
    DeclarationName Name = Importer.Import(D.getDeclName());
    if (D.getDeclName().$bool() && !Name.$bool()) {
      return null;
    }
    
    // Import the location of this declaration.
    SourceLocation Loc = Importer.Import(D.getLocation());
    
    // Import the parameter's type.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    // Create the imported parameter.
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    ParmVarDecl /*P*/ ToParm = ParmVarDecl.Create(Importer.getToContext(), DC, 
        Importer.Import(D.getInnerLocStart()), 
        new SourceLocation(Loc), Name.getAsIdentifierInfo(), 
        new QualType(T), TInfo, D.getStorageClass(), 
        /*FIXME: Default argument*/ (Expr /*P*/ )null);
    ToParm.setHasInheritedDefaultArg(D.hasInheritedDefaultArg());
    if (D.isUsed()) {
      ToParm.setIsUsed();
    }
    
    return Importer.Imported(D, ToParm);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3546,
   FQN="clang::ASTNodeImporter::VisitObjCMethodDecl", NM="_ZN5clang15ASTNodeImporter19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCMethodDecl(ObjCMethodDecl /*P*/ D) {
    // Import the major distinguishing characteristics of a method.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      {
        ObjCMethodDecl /*P*/ FoundMethod = dyn_cast_ObjCMethodDecl(FoundDecls.$at(I));
        if ((FoundMethod != null)) {
          if (FoundMethod.isInstanceMethod() != D.isInstanceMethod()) {
            continue;
          }
          
          // Check return types.
          if (!Importer.IsStructurallyEquivalent(D.getReturnType(), 
              FoundMethod.getReturnType())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_objc_method_result_type_inconsistent)), 
                              D.isInstanceMethod()), /*NO_COPY*/Name), D.getReturnType()), 
                  FoundMethod.getReturnType()));
              $c$.clean($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.ToDiag(FoundMethod.getLocation(), 
                          diag.note_odr_objc_method_here)), 
                      D.isInstanceMethod()), /*NO_COPY*/Name));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          
          // Check the number of parameters.
          if (D.param_size() != FoundMethod.param_size()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_objc_method_num_params_inconsistent)), 
                              D.isInstanceMethod()), /*NO_COPY*/Name), 
                      D.param_size()), FoundMethod.param_size()));
              $c$.clean($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.ToDiag(FoundMethod.getLocation(), 
                          diag.note_odr_objc_method_here)), 
                      D.isInstanceMethod()), /*NO_COPY*/Name));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          
          // Check parameter types.
          for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> P = $tryClone(D.param_begin()), 
              /*P*/ /*const*/ /*P*/ PEnd = $tryClone(D.param_end()), /*P*/ /*const*/ /*P*/ FoundP = $tryClone(FoundMethod.param_begin());
               $noteq_ptr(P, PEnd); P.$preInc() , FoundP.$preInc()) {
            if (!Importer.IsStructurallyEquivalent((P.$star()).getType(), 
                (FoundP.$star()).getType())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.FromDiag((P.$star()).getLocation(), 
                                    diag.err_odr_objc_method_param_type_inconsistent)), 
                                D.isInstanceMethod()), /*NO_COPY*/Name), 
                        (P.$star()).getType()), (FoundP.$star()).getType()));
                $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag((FoundP.$star()).getLocation(), diag.note_odr_value_here)), 
                    (FoundP.$star()).getType()));
                return null;
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          // Check variadic/non-variadic.
          // Check the number of parameters.
          if (D.isVariadic() != FoundMethod.isVariadic()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_objc_method_variadic_inconsistent)), 
                      D.isInstanceMethod()), /*NO_COPY*/Name));
              $c$.clean($out_DiagnosticBuilder$C_DeclarationName($out$Same2Bool($c$.track(Importer.ToDiag(FoundMethod.getLocation(), 
                          diag.note_odr_objc_method_here)), 
                      D.isInstanceMethod()), /*NO_COPY*/Name));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          
          // FIXME: Any other bits we need to merge?
          return Importer.Imported(D, FoundMethod);
        }
      }
    }
    
    // Import the result type.
    QualType ResultTy = Importer.Import(D.getReturnType());
    if (ResultTy.isNull()) {
      return null;
    }
    
    TypeSourceInfo /*P*/ ReturnTInfo = Importer.Import(D.getReturnTypeSourceInfo());
    
    ObjCMethodDecl /*P*/ ToMethod = ObjCMethodDecl.Create(Importer.getToContext(), new SourceLocation(Loc), Importer.Import(D.getLocEnd()), 
        Name.getObjCSelector(), new QualType(ResultTy), ReturnTInfo, DC.$deref(), D.isInstanceMethod(), 
        D.isVariadic(), D.isPropertyAccessor(), D.isImplicit(), D.isDefined(), 
        D.getImplementationControl(), D.hasRelatedResultType());
    
    // FIXME: When we decide to merge method definitions, we'll need to
    // deal with implicit parameters.
    
    // Import the parameters
    SmallVector<ParmVarDecl /*P*/ > ToParams/*J*/= new SmallVector<ParmVarDecl /*P*/ >(5, (ParmVarDecl /*P*/ )null);
    for (ParmVarDecl /*P*/ FromP : D.parameters()) {
      ParmVarDecl /*P*/ ToP = cast_or_null_ParmVarDecl(Importer.Import(FromP));
      if (!(ToP != null)) {
        return null;
      }
      
      ToParams.push_back(ToP);
    }
    
    // Set the parameters.
    for (/*uint*/int I = 0, N = ToParams.size(); I != N; ++I) {
      ToParams.$at(I).setOwningFunction(ToMethod);
      ToMethod.addDeclInternal(ToParams.$at(I));
    }
    SmallVector<SourceLocation> SelLocs/*J*/= new SmallVector<SourceLocation>(12, new SourceLocation());
    D.getSelectorLocs(SelLocs);
    ToMethod.setMethodParams(Importer.getToContext(), new ArrayRef<ParmVarDecl /*P*/ >(ToParams, true), new ArrayRef<SourceLocation>(SelLocs, false));
    
    ToMethod.setLexicalDeclContext(LexicalDC.$deref());
    Importer.Imported(D, ToMethod);
    LexicalDC.$deref().addDeclInternal(ToMethod);
    return ToMethod;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3660,
   FQN="clang::ASTNodeImporter::VisitObjCTypeParamDecl", NM="_ZN5clang15ASTNodeImporter22VisitObjCTypeParamDeclEPNS_17ObjCTypeParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitObjCTypeParamDeclEPNS_17ObjCTypeParamDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCTypeParamDecl(ObjCTypeParamDecl /*P*/ D) {
    // Import the major distinguishing characteristics of a category.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    TypeSourceInfo /*P*/ BoundInfo = Importer.Import(D.getTypeSourceInfo());
    if (!(BoundInfo != null)) {
      return null;
    }
    
    ObjCTypeParamDecl /*P*/ Result = ObjCTypeParamDecl.Create(Importer.getToContext(), DC.$deref(), 
        D.getVariance(), 
        Importer.Import(D.getVarianceLoc()), 
        D.getIndex(), 
        Importer.Import(D.getLocation()), 
        Name.getAsIdentifierInfo(), 
        Importer.Import(D.getColonLoc()), 
        BoundInfo);
    Importer.Imported(D, Result);
    Result.setLexicalDeclContext(LexicalDC.$deref());
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3689,
   FQN="clang::ASTNodeImporter::VisitObjCCategoryDecl", NM="_ZN5clang15ASTNodeImporter21VisitObjCCategoryDeclEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitObjCCategoryDeclEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCCategoryDecl(ObjCCategoryDecl /*P*/ D) {
    // Import the major distinguishing characteristics of a category.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    ObjCInterfaceDecl /*P*/ ToInterface = cast_or_null_ObjCInterfaceDecl(Importer.Import(D.getClassInterface()));
    if (!(ToInterface != null)) {
      return null;
    }
    
    // Determine if we've already encountered this category.
    ObjCCategoryDecl /*P*/ MergeWithCategory = ToInterface.FindCategoryDeclaration(Name.getAsIdentifierInfo());
    ObjCCategoryDecl /*P*/ ToCategory = MergeWithCategory;
    if (!(ToCategory != null)) {
      ToCategory = ObjCCategoryDecl.Create(Importer.getToContext(), DC.$deref(), 
          Importer.Import(D.getAtStartLoc()), 
          new SourceLocation(Loc), 
          Importer.Import(D.getCategoryNameLoc()), 
          Name.getAsIdentifierInfo(), 
          ToInterface, 
          /*TypeParamList=*/ (ObjCTypeParamList /*P*/ )null, 
          Importer.Import(D.getIvarLBraceLoc()), 
          Importer.Import(D.getIvarRBraceLoc()));
      ToCategory.setLexicalDeclContext(LexicalDC.$deref());
      LexicalDC.$deref().addDeclInternal(ToCategory);
      Importer.Imported(D, ToCategory);
      // Import the type parameter list after calling Imported, to avoid
      // loops when bringing in their DeclContext.
      ToCategory.setTypeParamList(ImportObjCTypeParamList(D.getTypeParamList()));
      
      // Import protocols
      SmallVector<ObjCProtocolDecl /*P*/ > Protocols/*J*/= new SmallVector<ObjCProtocolDecl /*P*/ >(4, (ObjCProtocolDecl /*P*/ )null);
      SmallVector<SourceLocation> ProtocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
      /*const*/type$ptr<SourceLocation> /*P*/ FromProtoLoc = $tryClone(D.protocol_loc_begin());
      for (type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> FromProto = $tryClone(D.protocol_begin()), 
          /*P*/ /*const*/ /*P*/ FromProtoEnd = $tryClone(D.protocol_end());
           $noteq_ptr(FromProto, FromProtoEnd);
           FromProto.$preInc() , FromProtoLoc.$preInc()) {
        ObjCProtocolDecl /*P*/ ToProto = cast_or_null_ObjCProtocolDecl(Importer.Import(FromProto.$star()));
        if (!(ToProto != null)) {
          return null;
        }
        Protocols.push_back(ToProto);
        ProtocolLocs.push_back(Importer.Import(new SourceLocation(FromProtoLoc.$star())));
      }
      
      // FIXME: If we're merging, make sure that the protocol list is the same.
      ToCategory.setProtocolList(Protocols.data(), Protocols.size(), 
          ProtocolLocs.data(), Importer.getToContext());
    } else {
      Importer.Imported(D, ToCategory);
    }
    
    // Import all of the members of this category.
    ImportDeclContext(D);
    
    // If we have an implementation, import it as well.
    if ((D.getImplementation() != null)) {
      ObjCCategoryImplDecl /*P*/ Impl = cast_or_null_ObjCCategoryImplDecl(Importer.Import(D.getImplementation()));
      if (!(Impl != null)) {
        return null;
      }
      
      ToCategory.setImplementation(Impl);
    }
    
    return ToCategory;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3809,
   FQN="clang::ASTNodeImporter::VisitObjCProtocolDecl", NM="_ZN5clang15ASTNodeImporter21VisitObjCProtocolDeclEPNS_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitObjCProtocolDeclEPNS_16ObjCProtocolDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCProtocolDecl(ObjCProtocolDecl /*P*/ D) {
    // If this protocol has a definition in the translation unit we're coming 
    // from, but this particular declaration is not that definition, import the
    // definition and map to that.
    ObjCProtocolDecl /*P*/ Definition = D.getDefinition();
    if ((Definition != null) && Definition != D) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition);
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    // Import the major distinguishing characteristics of a protocol.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    ObjCProtocolDecl /*P*/ MergeWithProtocol = null;
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      if (!FoundDecls.$at(I).isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_ObjCProtocol)) {
        continue;
      }
      if (((MergeWithProtocol = dyn_cast_ObjCProtocolDecl(FoundDecls.$at(I))) != null)) {
        break;
      }
    }
    
    ObjCProtocolDecl /*P*/ ToProto = MergeWithProtocol;
    if (!(ToProto != null)) {
      ToProto = ObjCProtocolDecl.Create(Importer.getToContext(), DC.$deref(), 
          Name.getAsIdentifierInfo(), new SourceLocation(Loc), 
          Importer.Import(D.getAtStartLoc()), 
          /*PrevDecl=*/ (ObjCProtocolDecl /*P*/ )null);
      ToProto.setLexicalDeclContext(LexicalDC.$deref());
      LexicalDC.$deref().addDeclInternal(ToProto);
    }
    
    Importer.Imported(D, ToProto);
    if (D.isThisDeclarationADefinition() && ImportDefinition(D, ToProto)) {
      return null;
    }
    
    return ToProto;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitLinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3861,
   FQN="clang::ASTNodeImporter::VisitLinkageSpecDecl", NM="_ZN5clang15ASTNodeImporter20VisitLinkageSpecDeclEPNS_15LinkageSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitLinkageSpecDeclEPNS_15LinkageSpecDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitLinkageSpecDecl(LinkageSpecDecl /*P*/ D) {
    DeclContext /*P*/ DC = Importer.ImportContext(D.getDeclContext());
    DeclContext /*P*/ LexicalDC = Importer.ImportContext(D.getLexicalDeclContext());
    
    SourceLocation ExternLoc = Importer.Import(D.getExternLoc());
    SourceLocation LangLoc = Importer.Import(D.getLocation());
    
    boolean HasBraces = D.hasBraces();
    
    LinkageSpecDecl /*P*/ ToLinkageSpec = LinkageSpecDecl.Create(Importer.getToContext(), 
        DC, 
        new SourceLocation(ExternLoc), 
        new SourceLocation(LangLoc), 
        D.getLanguage(), 
        HasBraces);
    if (HasBraces) {
      SourceLocation RBraceLoc = Importer.Import(D.getRBraceLoc());
      ToLinkageSpec.setRBraceLoc(new SourceLocation(RBraceLoc));
    }
    
    ToLinkageSpec.setLexicalDeclContext(LexicalDC);
    LexicalDC.addDeclInternal(ToLinkageSpec);
    
    Importer.Imported(D, ToLinkageSpec);
    
    return ToLinkageSpec;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportObjCTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3985,
   FQN="clang::ASTNodeImporter::ImportObjCTypeParamList", NM="_ZN5clang15ASTNodeImporter23ImportObjCTypeParamListEPNS_17ObjCTypeParamListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23ImportObjCTypeParamListEPNS_17ObjCTypeParamListE")
  //</editor-fold>
  public ObjCTypeParamList /*P*/ ImportObjCTypeParamList(ObjCTypeParamList /*P*/ list) {
    if (!(list != null)) {
      return null;
    }
    
    SmallVector<ObjCTypeParamDecl /*P*/ > toTypeParams/*J*/= new SmallVector<ObjCTypeParamDecl /*P*/ >(4, (ObjCTypeParamDecl /*P*/ )null);
    for (ObjCTypeParamDecl /*P*/ fromTypeParam : $Deref(list)) {
      ObjCTypeParamDecl /*P*/ toTypeParam = cast_or_null_ObjCTypeParamDecl(Importer.Import(fromTypeParam));
      if (!(toTypeParam != null)) {
        return null;
      }
      
      toTypeParams.push_back(toTypeParam);
    }
    
    return ObjCTypeParamList.create(Importer.getToContext(), 
        Importer.Import(list.getLAngleLoc()), 
        new ArrayRef<ObjCTypeParamDecl /*P*/ >(toTypeParams, true), 
        Importer.Import(list.getRAngleLoc()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4006,
   FQN="clang::ASTNodeImporter::VisitObjCInterfaceDecl", NM="_ZN5clang15ASTNodeImporter22VisitObjCInterfaceDeclEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitObjCInterfaceDeclEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCInterfaceDecl(ObjCInterfaceDecl /*P*/ D) {
    // If this class has a definition in the translation unit we're coming from,
    // but this particular declaration is not that definition, import the
    // definition and map to that.
    ObjCInterfaceDecl /*P*/ Definition = D.getDefinition();
    if ((Definition != null) && Definition != D) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition);
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    // Import the major distinguishing characteristics of an @interface.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Look for an existing interface with the same name.
    ObjCInterfaceDecl /*P*/ MergeWithIface = null;
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      if (!FoundDecls.$at(I).isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_Ordinary)) {
        continue;
      }
      if (((MergeWithIface = dyn_cast_ObjCInterfaceDecl(FoundDecls.$at(I))) != null)) {
        break;
      }
    }
    
    // Create an interface declaration, if one does not already exist.
    ObjCInterfaceDecl /*P*/ ToIface = MergeWithIface;
    if (!(ToIface != null)) {
      ToIface = ObjCInterfaceDecl.Create(Importer.getToContext(), DC.$deref(), 
          Importer.Import(D.getAtStartLoc()), 
          Name.getAsIdentifierInfo(), 
          /*TypeParamList=*/ (ObjCTypeParamList /*P*/ )null, 
          /*PrevDecl=*/ (ObjCInterfaceDecl /*P*/ )null, new SourceLocation(Loc), 
          D.isImplicitInterfaceDecl());
      ToIface.setLexicalDeclContext(LexicalDC.$deref());
      LexicalDC.$deref().addDeclInternal(ToIface);
    }
    Importer.Imported(D, ToIface);
    // Import the type parameter list after calling Imported, to avoid
    // loops when bringing in their DeclContext.
    ToIface.setTypeParamList(ImportObjCTypeParamList(D.getTypeParamListAsWritten()));
    if (D.isThisDeclarationADefinition() && ImportDefinition(D, ToIface)) {
      return null;
    }
    
    return ToIface;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4065,
   FQN="clang::ASTNodeImporter::VisitObjCCategoryImplDecl", NM="_ZN5clang15ASTNodeImporter25VisitObjCCategoryImplDeclEPNS_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter25VisitObjCCategoryImplDeclEPNS_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ D) {
    ObjCCategoryDecl /*P*/ Category = cast_or_null_ObjCCategoryDecl(Importer.Import(D.getCategoryDecl()));
    if (!(Category != null)) {
      return null;
    }
    
    ObjCCategoryImplDecl /*P*/ ToImpl = Category.getImplementation();
    if (!(ToImpl != null)) {
      DeclContext /*P*/ DC = Importer.ImportContext(D.getDeclContext());
      if (!(DC != null)) {
        return null;
      }
      
      SourceLocation CategoryNameLoc = Importer.Import(D.getCategoryNameLoc());
      ToImpl = ObjCCategoryImplDecl.Create(Importer.getToContext(), DC, 
          Importer.Import(D.getIdentifier()), 
          Category.getClassInterface(), 
          Importer.Import(D.getLocation()), 
          Importer.Import(D.getAtStartLoc()), 
          new SourceLocation(CategoryNameLoc));
      
      DeclContext /*P*/ LexicalDC = DC;
      if (D.getDeclContext() != D.getLexicalDeclContext()) {
        LexicalDC = Importer.ImportContext(D.getLexicalDeclContext());
        if (!(LexicalDC != null)) {
          return null;
        }
        
        ToImpl.setLexicalDeclContext(LexicalDC);
      }
      
      LexicalDC.addDeclInternal(ToImpl);
      Category.setImplementation(ToImpl);
    }
    
    Importer.Imported(D, ToImpl);
    ImportDeclContext(D);
    return ToImpl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCImplementationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4103,
   FQN="clang::ASTNodeImporter::VisitObjCImplementationDecl", NM="_ZN5clang15ASTNodeImporter27VisitObjCImplementationDeclEPNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter27VisitObjCImplementationDeclEPNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCImplementationDecl(ObjCImplementationDecl /*P*/ D) {
    // Find the corresponding interface.
    ObjCInterfaceDecl /*P*/ Iface = cast_or_null_ObjCInterfaceDecl(Importer.Import(D.getClassInterface()));
    if (!(Iface != null)) {
      return null;
    }
    
    // Import the superclass, if any.
    ObjCInterfaceDecl /*P*/ Super = null;
    if ((D.getSuperClass() != null)) {
      Super = cast_or_null_ObjCInterfaceDecl(Importer.Import(D.getSuperClass()));
      if (!(Super != null)) {
        return null;
      }
    }
    
    ObjCImplementationDecl /*P*/ Impl = Iface.getImplementation();
    if (!(Impl != null)) {
      // We haven't imported an implementation yet. Create a new @implementation
      // now.
      Impl = ObjCImplementationDecl.Create(Importer.getToContext(), 
          Importer.ImportContext(D.getDeclContext()), 
          Iface, Super, 
          Importer.Import(D.getLocation()), 
          Importer.Import(D.getAtStartLoc()), 
          Importer.Import(D.getSuperClassLoc()), 
          Importer.Import(D.getIvarLBraceLoc()), 
          Importer.Import(D.getIvarRBraceLoc()));
      if (D.getDeclContext() != D.getLexicalDeclContext()) {
        DeclContext /*P*/ LexicalDC = Importer.ImportContext(D.getLexicalDeclContext());
        if (!(LexicalDC != null)) {
          return null;
        }
        Impl.setLexicalDeclContext(LexicalDC);
      }
      
      // Associate the implementation with the class it implements.
      Iface.setImplementation(Impl);
      Importer.Imported(D, Iface.getImplementation());
    } else {
      Importer.Imported(D, Iface.getImplementation());
      
      // Verify that the existing @implementation has the same superclass.
      if (((Super != null) && !(Impl.getSuperClass() != null))
         || (!(Super != null) && (Impl.getSuperClass() != null))
         || ((Super != null) && (Impl.getSuperClass() != null)
         && !declaresSameEntity(Super.getCanonicalDecl(), 
          Impl.getSuperClass()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(Impl.getLocation(), 
                  diag.err_odr_objc_superclass_inconsistent)), 
              Iface.getDeclName()));
          // FIXME: It would be nice to have the location of the superclass
          // below.
          if ((Impl.getSuperClass() != null)) {
            $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(Impl.getLocation(), 
                    diag.note_odr_objc_superclass)), 
                Impl.getSuperClass().getDeclName()));
          } else {
            $c$.clean($c$.track(Importer.ToDiag(Impl.getLocation(), 
                diag.note_odr_objc_missing_superclass)));
          }
          if ((D.getSuperClass() != null)) {
            $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.FromDiag(D.getLocation(), 
                    diag.note_odr_objc_superclass)), 
                D.getSuperClass().getDeclName()));
          } else {
            $c$.clean($c$.track(Importer.FromDiag(D.getLocation(), 
                diag.note_odr_objc_missing_superclass)));
          }
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Import all of the members of this @implementation.
    ImportDeclContext(D);
    
    return Impl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4181,
   FQN="clang::ASTNodeImporter::VisitObjCPropertyDecl", NM="_ZN5clang15ASTNodeImporter21VisitObjCPropertyDeclEPNS_16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitObjCPropertyDeclEPNS_16ObjCPropertyDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCPropertyDecl(ObjCPropertyDecl /*P*/ D) {
    // Import the major distinguishing characteristics of an @property.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // Check whether we have already imported this property.
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      {
        ObjCPropertyDecl /*P*/ FoundProp = dyn_cast_ObjCPropertyDecl(FoundDecls.$at(I));
        if ((FoundProp != null)) {
          // Check property types.
          if (!Importer.IsStructurallyEquivalent(D.getType(), 
              FoundProp.getType())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(new SourceLocation(Loc), diag.err_odr_objc_property_type_inconsistent)), 
                          /*NO_COPY*/Name), D.getType()), FoundProp.getType()));
              $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Importer.ToDiag(FoundProp.getLocation(), diag.note_odr_value_here)), 
                  FoundProp.getType()));
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          
          // FIXME: Check property attributes, getters, setters, etc.?
          
          // Consider these properties to be equivalent.
          Importer.Imported(D, FoundProp);
          return FoundProp;
        }
      }
    }
    
    // Import the type.
    TypeSourceInfo /*P*/ TSI = Importer.Import(D.getTypeSourceInfo());
    if (!(TSI != null)) {
      return null;
    }
    
    // Create the new property.
    ObjCPropertyDecl /*P*/ ToProperty = ObjCPropertyDecl.Create(Importer.getToContext(), DC.$deref(), new SourceLocation(Loc), 
        Name.getAsIdentifierInfo(), 
        Importer.Import(D.getAtLoc()), 
        Importer.Import(D.getLParenLoc()), 
        Importer.Import(D.getType()), 
        TSI, 
        D.getPropertyImplementation());
    Importer.Imported(D, ToProperty);
    ToProperty.setLexicalDeclContext(LexicalDC.$deref());
    LexicalDC.$deref().addDeclInternal(ToProperty);
    
    ToProperty.setPropertyAttributes(D.getPropertyAttributes());
    ToProperty.setPropertyAttributesAsWritten(D.getPropertyAttributesAsWritten());
    ToProperty.setGetterName(Importer.Import(D.getGetterName()));
    ToProperty.setSetterName(Importer.Import(D.getSetterName()));
    ToProperty.setGetterMethodDecl(cast_or_null_ObjCMethodDecl(Importer.Import(D.getGetterMethodDecl())));
    ToProperty.setSetterMethodDecl(cast_or_null_ObjCMethodDecl(Importer.Import(D.getSetterMethodDecl())));
    ToProperty.setPropertyIvarDecl(cast_or_null_ObjCIvarDecl(Importer.Import(D.getPropertyIvarDecl())));
    return ToProperty;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4248,
   FQN="clang::ASTNodeImporter::VisitObjCPropertyImplDecl", NM="_ZN5clang15ASTNodeImporter25VisitObjCPropertyImplDeclEPNS_20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter25VisitObjCPropertyImplDeclEPNS_20ObjCPropertyImplDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitObjCPropertyImplDecl(ObjCPropertyImplDecl /*P*/ D) {
    ObjCPropertyDecl /*P*/ Property = cast_or_null_ObjCPropertyDecl(Importer.Import(D.getPropertyDecl()));
    if (!(Property != null)) {
      return null;
    }
    
    DeclContext /*P*/ DC = Importer.ImportContext(D.getDeclContext());
    if (!(DC != null)) {
      return null;
    }
    
    // Import the lexical declaration context.
    DeclContext /*P*/ LexicalDC = DC;
    if (D.getDeclContext() != D.getLexicalDeclContext()) {
      LexicalDC = Importer.ImportContext(D.getLexicalDeclContext());
      if (!(LexicalDC != null)) {
        return null;
      }
    }
    
    ObjCImplDecl /*P*/ InImpl = dyn_cast_ObjCImplDecl(LexicalDC);
    if (!(InImpl != null)) {
      return null;
    }
    
    // Import the ivar (for an @synthesize).
    ObjCIvarDecl /*P*/ Ivar = null;
    if ((D.getPropertyIvarDecl() != null)) {
      Ivar = cast_or_null_ObjCIvarDecl(Importer.Import(D.getPropertyIvarDecl()));
      if (!(Ivar != null)) {
        return null;
      }
    }
    
    ObjCPropertyImplDecl /*P*/ ToImpl = InImpl.FindPropertyImplDecl(Property.getIdentifier(), 
        Property.getQueryKind());
    if (!(ToImpl != null)) {
      ToImpl = ObjCPropertyImplDecl.Create(Importer.getToContext(), DC, 
          Importer.Import(D.getLocStart()), 
          Importer.Import(D.getLocation()), 
          Property, 
          D.getPropertyImplementation(), 
          Ivar, 
          Importer.Import(D.getPropertyIvarDeclLoc()));
      ToImpl.setLexicalDeclContext(LexicalDC);
      Importer.Imported(D, ToImpl);
      LexicalDC.addDeclInternal(ToImpl);
    } else {
      // Check that we have the same kind of property implementation (@synthesize
      // vs. @dynamic).
      if (D.getPropertyImplementation() != ToImpl.getPropertyImplementation()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(ToImpl.getLocation(), 
                      diag.err_odr_objc_property_impl_kind_inconsistent)), 
                  Property.getDeclName()), 
              (ToImpl.getPropertyImplementation()
                 == ObjCPropertyImplDecl.Kind.Dynamic)));
          $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.FromDiag(D.getLocation(), 
                      diag.note_odr_objc_property_impl_kind)), 
                  D.getPropertyDecl().getDeclName()), 
              (D.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Dynamic)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // For @synthesize, check that we have the same 
      if (D.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Synthesize
         && Ivar != ToImpl.getPropertyIvarDecl()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($out_DiagnosticBuilder$C_DeclarationName($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.ToDiag(ToImpl.getPropertyIvarDeclLoc(), 
                          diag.err_odr_objc_synthesize_ivar_inconsistent)), 
                      Property.getDeclName()), 
                  ToImpl.getPropertyIvarDecl().getDeclName()), 
              Ivar.getDeclName()));
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Importer.FromDiag(D.getPropertyIvarDeclLoc(), 
                  diag.note_odr_objc_synthesize_ivar_here)), 
              D.getPropertyIvarDecl().getDeclName()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Merge the existing implementation with the new implementation.
      Importer.Imported(D, ToImpl);
    }
    
    return ToImpl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4330,
   FQN="clang::ASTNodeImporter::VisitTemplateTypeParmDecl", NM="_ZN5clang15ASTNodeImporter25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTemplateTypeParmDecl(TemplateTypeParmDecl /*P*/ D) {
    // For template arguments, we adopt the translation unit as our declaration
    // context. This context will be fixed when the actual template declaration
    // is created.
    
    // FIXME: Import default argument.
    return TemplateTypeParmDecl.Create(Importer.getToContext(), 
        Importer.getToContext().getTranslationUnitDecl(), 
        Importer.Import(D.getLocStart()), 
        Importer.Import(D.getLocation()), 
        D.getDepth(), 
        D.getIndex(), 
        Importer.Import(D.getIdentifier()), 
        D.wasDeclaredWithTypename(), 
        D.isParameterPack());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitNonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4347,
   FQN="clang::ASTNodeImporter::VisitNonTypeTemplateParmDecl", NM="_ZN5clang15ASTNodeImporter28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitNonTypeTemplateParmDecl(NonTypeTemplateParmDecl /*P*/ D) {
    // Import the name of this declaration.
    DeclarationName Name = Importer.Import(D.getDeclName());
    if (D.getDeclName().$bool() && !Name.$bool()) {
      return null;
    }
    
    // Import the location of this declaration.
    SourceLocation Loc = Importer.Import(D.getLocation());
    
    // Import the type of this declaration.
    QualType T = Importer.Import(D.getType());
    if (T.isNull()) {
      return null;
    }
    
    // Import type-source information.
    TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
    if ((D.getTypeSourceInfo() != null) && !(TInfo != null)) {
      return null;
    }
    
    // FIXME: Import default argument.
    return NonTypeTemplateParmDecl.Create(Importer.getToContext(), 
        Importer.getToContext().getTranslationUnitDecl(), 
        Importer.Import(D.getInnerLocStart()), 
        new SourceLocation(Loc), D.getDepth(), D.getPosition(), 
        Name.getAsIdentifierInfo(), 
        new QualType(T), D.isParameterPack(), TInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4377,
   FQN="clang::ASTNodeImporter::VisitTemplateTemplateParmDecl", NM="_ZN5clang15ASTNodeImporter29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitTemplateTemplateParmDecl(TemplateTemplateParmDecl /*P*/ D) {
    // Import the name of this declaration.
    DeclarationName Name = Importer.Import(D.getDeclName());
    if (D.getDeclName().$bool() && !Name.$bool()) {
      return null;
    }
    
    // Import the location of this declaration.
    SourceLocation Loc = Importer.Import(D.getLocation());
    
    // Import template parameters.
    TemplateParameterList /*P*/ TemplateParams = ImportTemplateParameterList(D.getTemplateParameters());
    if (!(TemplateParams != null)) {
      return null;
    }
    
    // FIXME: Import default argument.
    return TemplateTemplateParmDecl.Create(Importer.getToContext(), 
        Importer.getToContext().getTranslationUnitDecl(), 
        new SourceLocation(Loc), D.getDepth(), D.getPosition(), 
        D.isParameterPack(), 
        Name.getAsIdentifierInfo(), 
        TemplateParams);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4403,
   FQN="clang::ASTNodeImporter::VisitClassTemplateDecl", NM="_ZN5clang15ASTNodeImporter22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitClassTemplateDecl(ClassTemplateDecl /*P*/ D) {
    // If this record has a definition in the translation unit we're coming from,
    // but this particular declaration is not that definition, import the
    // definition and map to that.
    CXXRecordDecl /*P*/ Definition = cast_or_null_CXXRecordDecl(D.getTemplatedDecl().getDefinition());
    if ((Definition != null) && Definition != D.getTemplatedDecl()) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition.getDescribedClassTemplate());
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    // Import the major distinguishing characteristics of this class template.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // We may already have a template of the same name; try to find and match it.
    if (!DC.$deref().isFunctionOrMethod()) {
      SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
      SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
      DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
      for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
        if (!FoundDecls.$at(I).isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_Ordinary)) {
          continue;
        }
        
        Decl /*P*/ Found = FoundDecls.$at(I);
        {
          ClassTemplateDecl /*P*/ FoundTemplate = dyn_cast_ClassTemplateDecl(Found);
          if ((FoundTemplate != null)) {
            if (IsStructuralMatch(D, FoundTemplate)) {
              // The class templates structurally match; call it the same template.
              // FIXME: We may be filling in a forward declaration here. Handle
              // this case!
              Importer.Imported(D.getTemplatedDecl(), 
                  FoundTemplate.getTemplatedDecl());
              return Importer.Imported(D, FoundTemplate);
            }
          }
        }
        
        ConflictingDecls.push_back(FoundDecls.$at(I));
      }
      if (!ConflictingDecls.empty()) {
        Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), Decl.IdentifierNamespace.IDNS_Ordinary, 
                ConflictingDecls.data(), 
                ConflictingDecls.size()));
      }
      if (!Name.$bool()) {
        return null;
      }
    }
    
    CXXRecordDecl /*P*/ DTemplated = D.getTemplatedDecl();
    
    // Create the declaration that is being templated.
    // Create the declaration that is being templated.
    CXXRecordDecl /*P*/ D2Templated = cast_or_null_CXXRecordDecl(Importer.Import(DTemplated));
    if (!(D2Templated != null)) {
      return null;
    }
    {
      
      // Resolve possible cyclic import.
      Decl /*P*/ AlreadyImported = Importer.GetAlreadyImportedOrNull(D);
      if ((AlreadyImported != null)) {
        return AlreadyImported;
      }
    }
    
    // Create the class template declaration itself.
    TemplateParameterList /*P*/ TemplateParams = ImportTemplateParameterList(D.getTemplateParameters());
    if (!(TemplateParams != null)) {
      return null;
    }
    
    ClassTemplateDecl /*P*/ D2 = ClassTemplateDecl.Create(Importer.getToContext(), DC.$deref(), 
        new SourceLocation(Loc), new DeclarationName(Name), TemplateParams, 
        D2Templated, 
        /*PrevDecl=*/ (ClassTemplateDecl /*P*/ )null);
    D2Templated.setDescribedClassTemplate(D2);
    
    D2.setAccess(D.getAccess());
    D2.setLexicalDeclContext(LexicalDC.$deref());
    LexicalDC.$deref().addDeclInternal(D2);
    
    // Note the relationship between the class templates.
    Importer.Imported(D, D2);
    Importer.Imported(DTemplated, D2Templated);
    if (DTemplated.isCompleteDefinition()
       && !D2Templated.isCompleteDefinition()) {
      // FIXME: Import definition!
    }
    
    return D2;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4504,
   FQN="clang::ASTNodeImporter::VisitClassTemplateSpecializationDecl", NM="_ZN5clang15ASTNodeImporter36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitClassTemplateSpecializationDecl(ClassTemplateSpecializationDecl /*P*/ D) {
    // If this record has a definition in the translation unit we're coming from,
    // but this particular declaration is not that definition, import the
    // definition and map to that.
    TagDecl /*P*/ Definition = D.getDefinition();
    if ((Definition != null) && Definition != D) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition);
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    ClassTemplateDecl /*P*/ ClassTemplate = cast_or_null_ClassTemplateDecl(Importer.Import(D.getSpecializedTemplate()));
    if (!(ClassTemplate != null)) {
      return null;
    }
    
    // Import the context of this declaration.
    DeclContext /*P*/ DC = ClassTemplate.getDeclContext();
    if (!(DC != null)) {
      return null;
    }
    
    DeclContext /*P*/ LexicalDC = DC;
    if (D.getDeclContext() != D.getLexicalDeclContext()) {
      LexicalDC = Importer.ImportContext(D.getLexicalDeclContext());
      if (!(LexicalDC != null)) {
        return null;
      }
    }
    
    // Import the location of this declaration.
    SourceLocation StartLoc = Importer.Import(D.getLocStart());
    SourceLocation IdLoc = Importer.Import(D.getLocation());
    
    // Import template arguments.
    SmallVector<TemplateArgument> TemplateArgs/*J*/= new SmallVector<TemplateArgument>(2, new TemplateArgument());
    if (ImportTemplateArguments(D.getTemplateArgs().data(), 
        D.getTemplateArgs().size(), 
        TemplateArgs)) {
      return null;
    }
    
    // Try to find an existing specialization with these template arguments.
    type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    ClassTemplateSpecializationDecl /*P*/ D2 = ClassTemplate.findSpecialization(new ArrayRef<TemplateArgument>(TemplateArgs, false), InsertPos);
    if ((D2 != null)) {
      {
        // We already have a class template specialization with these template
        // arguments.
        
        // FIXME: Check for specialization vs. instantiation errors.
        RecordDecl /*P*/ FoundDef = D2.getDefinition();
        if ((FoundDef != null)) {
          if (!D.isCompleteDefinition() || IsStructuralMatch(D, FoundDef)) {
            // The record types structurally match, or the "from" translation
            // unit only had a forward declaration anyway; call it the same
            // function.
            return Importer.Imported(D, FoundDef);
          }
        }
      }
    } else {
      // Create a new specialization.
      D2 = ClassTemplateSpecializationDecl.Create(Importer.getToContext(), 
          D.getTagKind(), DC, 
          new SourceLocation(StartLoc), new SourceLocation(IdLoc), 
          ClassTemplate, 
          new ArrayRef<TemplateArgument>(TemplateArgs, false), 
          /*PrevDecl=*/ (ClassTemplateSpecializationDecl /*P*/ )null);
      D2.setSpecializationKind(D.getSpecializationKind());
      
      // Add this specialization to the class template.
      ClassTemplate.AddSpecialization(D2, InsertPos.$deref());
      
      // Import the qualifier, if any.
      D2.setQualifierInfo(Importer.Import(D.getQualifierLoc()));
      
      // Add the specialization to this context.
      D2.setLexicalDeclContext(LexicalDC);
      LexicalDC.addDeclInternal(D2);
    }
    Importer.Imported(D, D2);
    if (D.isCompleteDefinition() && ImportDefinition(D, D2)) {
      return null;
    }
    
    return D2;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitVarTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4593,
   FQN="clang::ASTNodeImporter::VisitVarTemplateDecl", NM="_ZN5clang15ASTNodeImporter20VisitVarTemplateDeclEPNS_15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitVarTemplateDeclEPNS_15VarTemplateDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarTemplateDecl(VarTemplateDecl /*P*/ D) {
    // If this variable has a definition in the translation unit we're coming
    // from,
    // but this particular declaration is not that definition, import the
    // definition and map to that.
    VarDecl /*P*/ Definition = cast_or_null_VarDecl(D.getTemplatedDecl().getDefinition());
    if ((Definition != null) && Definition != D.getTemplatedDecl()) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition.getDescribedVarTemplate());
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    // Import the major distinguishing characteristics of this variable template.
    type$ref<DeclContext /*P*/ > DC = create_type$ref();
    type$ref<DeclContext /*P*/ > LexicalDC = create_type$ref();
    DeclarationName Name/*J*/= new DeclarationName();
    SourceLocation Loc/*J*/= new SourceLocation();
    type$ref<NamedDecl /*P*/ > ToD = create_type$ref();
    if (ImportDeclParts(D, DC, LexicalDC, Name, ToD, Loc)) {
      return null;
    }
    if ((ToD.$deref() != null)) {
      return ToD.$deref();
    }
    
    // We may already have a template of the same name; try to find and match it.
    assert (!DC.$deref().isFunctionOrMethod()) : "Variable templates cannot be declared at function scope";
    SmallVector<NamedDecl /*P*/ > ConflictingDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(4, (NamedDecl /*P*/ )null);
    SmallVector<NamedDecl /*P*/ > FoundDecls/*J*/= new SmallVector<NamedDecl /*P*/ >(2, (NamedDecl /*P*/ )null);
    DC.$deref().getRedeclContext().localUncachedLookup(new DeclarationName(Name), FoundDecls);
    for (/*uint*/int I = 0, N = FoundDecls.size(); I != N; ++I) {
      if (!FoundDecls.$at(I).isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_Ordinary)) {
        continue;
      }
      
      Decl /*P*/ Found = FoundDecls.$at(I);
      {
        VarTemplateDecl /*P*/ FoundTemplate = dyn_cast_VarTemplateDecl(Found);
        if ((FoundTemplate != null)) {
          if (IsStructuralMatch(D, FoundTemplate)) {
            // The variable templates structurally match; call it the same template.
            Importer.Imported(D.getTemplatedDecl(), 
                FoundTemplate.getTemplatedDecl());
            return Importer.Imported(D, FoundTemplate);
          }
        }
      }
      
      ConflictingDecls.push_back(FoundDecls.$at(I));
    }
    if (!ConflictingDecls.empty()) {
      Name.$assignMove(Importer.HandleNameConflict(new DeclarationName(Name), DC.$deref(), Decl.IdentifierNamespace.IDNS_Ordinary, 
              ConflictingDecls.data(), 
              ConflictingDecls.size()));
    }
    if (!Name.$bool()) {
      return null;
    }
    
    VarDecl /*P*/ DTemplated = D.getTemplatedDecl();
    
    // Import the type.
    QualType T = Importer.Import(DTemplated.getType());
    if (T.isNull()) {
      return null;
    }
    
    // Create the declaration that is being templated.
    SourceLocation StartLoc = Importer.Import(DTemplated.getLocStart());
    SourceLocation IdLoc = Importer.Import(DTemplated.getLocation());
    TypeSourceInfo /*P*/ TInfo = Importer.Import(DTemplated.getTypeSourceInfo());
    VarDecl /*P*/ D2Templated = VarDecl.Create(Importer.getToContext(), DC.$deref(), new SourceLocation(StartLoc), 
        new SourceLocation(IdLoc), Name.getAsIdentifierInfo(), new QualType(T), 
        TInfo, DTemplated.getStorageClass());
    D2Templated.setAccess(DTemplated.getAccess());
    D2Templated.setQualifierInfo(Importer.Import(DTemplated.getQualifierLoc()));
    D2Templated.setLexicalDeclContext(LexicalDC.$deref());
    
    // Importer.Imported(DTemplated, D2Templated);
    // LexicalDC->addDeclInternal(D2Templated);
    
    // Merge the initializer.
    if (ImportDefinition(DTemplated, D2Templated)) {
      return null;
    }
    
    // Create the variable template declaration itself.
    TemplateParameterList /*P*/ TemplateParams = ImportTemplateParameterList(D.getTemplateParameters());
    if (!(TemplateParams != null)) {
      return null;
    }
    
    VarTemplateDecl /*P*/ D2 = VarTemplateDecl.Create(Importer.getToContext(), DC.$deref(), new SourceLocation(Loc), new DeclarationName(Name), TemplateParams, D2Templated);
    D2Templated.setDescribedVarTemplate(D2);
    
    D2.setAccess(D.getAccess());
    D2.setLexicalDeclContext(LexicalDC.$deref());
    LexicalDC.$deref().addDeclInternal(D2);
    
    // Note the relationship between the variable templates.
    Importer.Imported(D, D2);
    Importer.Imported(DTemplated, D2Templated);
    if ((DTemplated.isThisDeclarationADefinition().getValue() != 0)
       && !(D2Templated.isThisDeclarationADefinition().getValue() != 0)) {
      // FIXME: Import definition!
    }
    
    return D2;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4701,
   FQN="clang::ASTNodeImporter::VisitVarTemplateSpecializationDecl", NM="_ZN5clang15ASTNodeImporter34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public Decl /*P*/ VisitVarTemplateSpecializationDecl(VarTemplateSpecializationDecl /*P*/ D) {
    // If this record has a definition in the translation unit we're coming from,
    // but this particular declaration is not that definition, import the
    // definition and map to that.
    VarDecl /*P*/ Definition = D.getDefinition();
    if ((Definition != null) && Definition != D) {
      Decl /*P*/ ImportedDef = Importer.Import(Definition);
      if (!(ImportedDef != null)) {
        return null;
      }
      
      return Importer.Imported(D, ImportedDef);
    }
    
    VarTemplateDecl /*P*/ VarTemplate = cast_or_null_VarTemplateDecl(Importer.Import(D.getSpecializedTemplate()));
    if (!(VarTemplate != null)) {
      return null;
    }
    
    // Import the context of this declaration.
    DeclContext /*P*/ DC = VarTemplate.getDeclContext();
    if (!(DC != null)) {
      return null;
    }
    
    DeclContext /*P*/ LexicalDC = DC;
    if (D.getDeclContext() != D.getLexicalDeclContext()) {
      LexicalDC = Importer.ImportContext(D.getLexicalDeclContext());
      if (!(LexicalDC != null)) {
        return null;
      }
    }
    
    // Import the location of this declaration.
    SourceLocation StartLoc = Importer.Import(D.getLocStart());
    SourceLocation IdLoc = Importer.Import(D.getLocation());
    
    // Import template arguments.
    SmallVector<TemplateArgument> TemplateArgs/*J*/= new SmallVector<TemplateArgument>(2, new TemplateArgument());
    if (ImportTemplateArguments(D.getTemplateArgs().data(), 
        D.getTemplateArgs().size(), TemplateArgs)) {
      return null;
    }
    
    // Try to find an existing specialization with these template arguments.
    type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    VarTemplateSpecializationDecl /*P*/ D2 = VarTemplate.findSpecialization(new ArrayRef<TemplateArgument>(TemplateArgs, false), InsertPos);
    if ((D2 != null)) {
      {
        // We already have a variable template specialization with these template
        // arguments.
        
        // FIXME: Check for specialization vs. instantiation errors.
        VarDecl /*P*/ FoundDef = D2.getDefinition();
        if ((FoundDef != null)) {
          if (!(D.isThisDeclarationADefinition().getValue() != 0)
             || IsStructuralMatch(D, FoundDef)) {
            // The record types structurally match, or the "from" translation
            // unit only had a forward declaration anyway; call it the same
            // variable.
            return Importer.Imported(D, FoundDef);
          }
        }
      }
    } else {
      
      // Import the type.
      QualType T = Importer.Import(D.getType());
      if (T.isNull()) {
        return null;
      }
      TypeSourceInfo /*P*/ TInfo = Importer.Import(D.getTypeSourceInfo());
      
      // Create a new specialization.
      D2 = VarTemplateSpecializationDecl.Create(Importer.getToContext(), DC, new SourceLocation(StartLoc), new SourceLocation(IdLoc), VarTemplate, new QualType(T), TInfo, 
          D.getStorageClass(), new ArrayRef<TemplateArgument>(TemplateArgs, false));
      D2.setSpecializationKind(D.getSpecializationKind());
      D2.setTemplateArgsInfo(D.getTemplateArgsInfo());
      
      // Add this specialization to the class template.
      VarTemplate.AddSpecialization(D2, InsertPos.$deref());
      
      // Import the qualifier, if any.
      D2.setQualifierInfo(Importer.Import(D.getQualifierLoc()));
      
      // Add the specialization to this context.
      D2.setLexicalDeclContext(LexicalDC);
      LexicalDC.addDeclInternal(D2);
    }
    Importer.Imported(D, D2);
    if ((D.isThisDeclarationADefinition().getValue() != 0) && ImportDefinition(D, D2)) {
      return null;
    }
    
    return D2;
  }

  
  // Importing statements
  
  //----------------------------------------------------------------------------
  // Import Statements
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportDeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4798,
   FQN="clang::ASTNodeImporter::ImportDeclGroup", NM="_ZN5clang15ASTNodeImporter15ImportDeclGroupENS_12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15ImportDeclGroupENS_12DeclGroupRefE")
  //</editor-fold>
  public DeclGroupRef ImportDeclGroup(DeclGroupRef DG) {
    if (DG.isNull()) {
      return DeclGroupRef.Create(Importer.getToContext(), (type$ptr<Decl /*P*/ /*P*/>)null, 0);
    }
    /*size_t*/int NumDecls = DG.end().$sub(DG.begin());
    SmallVector<Decl /*P*/> ToDecls/*J*/= new SmallVector<Decl /*P*/>(JD$UInt_T$C$R.INSTANCE, 1, NumDecls, null);
    final ASTImporter /*&*/ _Importer = this.Importer;
    std.transform(DG.begin(), DG.end(), ToDecls.begin(), 
        /*[&_Importer]*/ (Decl /*P*/ D) -> {
              return _Importer.Import(D);
            });
    return DeclGroupRef.Create(Importer.getToContext(), 
        ToDecls.begin(), 
        NumDecls);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4813,
   FQN="clang::ASTNodeImporter::VisitStmt", NM="_ZN5clang15ASTNodeImporter9VisitStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter9VisitStmtEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitStmt(Stmt /*P*/ S) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Importer.FromDiag(S.getLocStart(), diag.err_unsupported_ast_node)), 
          S.getStmtClassName()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitGCCAsmStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4820,
   FQN="clang::ASTNodeImporter::VisitGCCAsmStmt", NM="_ZN5clang15ASTNodeImporter15VisitGCCAsmStmtEPNS_10GCCAsmStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitGCCAsmStmtEPNS_10GCCAsmStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitGCCAsmStmt(GCCAsmStmt /*P*/ S) {
    SmallVector<IdentifierInfo /*P*/> Names/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    for (/*uint*/int I = 0, E = S.getNumOutputs(); I != E; I++) {
      IdentifierInfo /*P*/ ToII = Importer.Import(S.getOutputIdentifier(I));
      if (!(ToII != null)) {
        return null;
      }
      Names.push_back(ToII);
    }
    for (/*uint*/int I = 0, E = S.getNumInputs(); I != E; I++) {
      IdentifierInfo /*P*/ ToII = Importer.Import(S.getInputIdentifier(I));
      if (!(ToII != null)) {
        return null;
      }
      Names.push_back(ToII);
    }
    
    SmallVector<StringLiteral /*P*/ > Clobbers/*J*/= new SmallVector<StringLiteral /*P*/ >(4, (StringLiteral /*P*/ )null);
    for (/*uint*/int I = 0, E = S.getNumClobbers(); I != E; I++) {
      StringLiteral /*P*/ Clobber = cast_or_null_StringLiteral(Importer.Import(S.getClobberStringLiteral(I)));
      if (!(Clobber != null)) {
        return null;
      }
      Clobbers.push_back(Clobber);
    }
    
    SmallVector<StringLiteral /*P*/ > Constraints/*J*/= new SmallVector<StringLiteral /*P*/ >(4, (StringLiteral /*P*/ )null);
    for (/*uint*/int I = 0, E = S.getNumOutputs(); I != E; I++) {
      StringLiteral /*P*/ Output = cast_or_null_StringLiteral(Importer.Import(S.getOutputConstraintLiteral(I)));
      if (!(Output != null)) {
        return null;
      }
      Constraints.push_back(Output);
    }
    
    for (/*uint*/int I = 0, E = S.getNumInputs(); I != E; I++) {
      StringLiteral /*P*/ Input = cast_or_null_StringLiteral(Importer.Import(S.getInputConstraintLiteral(I)));
      if (!(Input != null)) {
        return null;
      }
      Constraints.push_back(Input);
    }
    
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, S.getNumOutputs() + S.getNumInputs(), (Expr /*P*/ )null);
    if (ImportArrayChecked(S.begin_outputs(), S.end_outputs(), Exprs.begin())) {
      return null;
    }
    if (ImportArrayChecked(S.begin_inputs(), S.end_inputs(), 
        Exprs.begin().$add(S.getNumOutputs()))) {
      return null;
    }
    
    StringLiteral /*P*/ AsmStr = cast_or_null_StringLiteral(Importer.Import(S.getAsmString()));
    if (!(AsmStr != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new GCCAsmStmt(Importer.getToContext(), 
                Importer.Import(S.getAsmLoc()), 
                S.isSimple(), 
                S.isVolatile(), 
                S.getNumOutputs(), 
                S.getNumInputs(), 
                Names.data(), 
                Constraints.data(), 
                Exprs.data(), 
                AsmStr, 
                S.getNumClobbers(), 
                Clobbers.data(), 
                Importer.Import(S.getRParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4890,
   FQN="clang::ASTNodeImporter::VisitDeclStmt", NM="_ZN5clang15ASTNodeImporter13VisitDeclStmtEPNS_8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitDeclStmtEPNS_8DeclStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitDeclStmt(DeclStmt /*P*/ S) {
    DeclGroupRef ToDG = ImportDeclGroup(S.getDeclGroup());
    for (Decl /*P*/ ToD : ToDG) {
      if (!(ToD != null)) {
        return null;
      }
    }
    SourceLocation ToStartLoc = Importer.Import(S.getStartLoc());
    SourceLocation ToEndLoc = Importer.Import(S.getEndLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new DeclStmt(new DeclGroupRef(ToDG), new SourceLocation(ToStartLoc), new SourceLocation(ToEndLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitNullStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4901,
   FQN="clang::ASTNodeImporter::VisitNullStmt", NM="_ZN5clang15ASTNodeImporter13VisitNullStmtEPNS_8NullStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitNullStmtEPNS_8NullStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitNullStmt(NullStmt /*P*/ S) {
    SourceLocation ToSemiLoc = Importer.Import(S.getSemiLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new NullStmt(new SourceLocation(ToSemiLoc), 
                S.hasLeadingEmptyMacro());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCompoundStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4907,
   FQN="clang::ASTNodeImporter::VisitCompoundStmt", NM="_ZN5clang15ASTNodeImporter17VisitCompoundStmtEPNS_12CompoundStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitCompoundStmtEPNS_12CompoundStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitCompoundStmt(CompoundStmt /*P*/ S) {
    SmallVector<Stmt /*P*/ > ToStmts/*J*/= new SmallVector<Stmt /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, S.size(), (Stmt /*P*/ )null);
    if (ImportArrayCheckedStmt(S.body_begin(), S.body_end(), ToStmts.begin())) {
      return null;
    }
    
    SourceLocation ToLBraceLoc = Importer.Import(S.getLBracLoc());
    SourceLocation ToRBraceLoc = Importer.Import(S.getRBracLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CompoundStmt(Importer.getToContext(), 
                new ArrayRef<Stmt /*P*/ >(ToStmts, true), 
                new SourceLocation(ToLBraceLoc), new SourceLocation(ToRBraceLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCaseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4920,
   FQN="clang::ASTNodeImporter::VisitCaseStmt", NM="_ZN5clang15ASTNodeImporter13VisitCaseStmtEPNS_8CaseStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitCaseStmtEPNS_8CaseStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitCaseStmt(CaseStmt /*P*/ S) {
    Expr /*P*/ ToLHS = Importer.Import(S.getLHS());
    if (!(ToLHS != null)) {
      return null;
    }
    Expr /*P*/ ToRHS = Importer.Import(S.getRHS());
    if (!(ToRHS != null) && (S.getRHS() != null)) {
      return null;
    }
    SourceLocation ToCaseLoc = Importer.Import(S.getCaseLoc());
    SourceLocation ToEllipsisLoc = Importer.Import(S.getEllipsisLoc());
    SourceLocation ToColonLoc = Importer.Import(S.getColonLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CaseStmt(ToLHS, ToRHS, 
                new SourceLocation(ToCaseLoc), new SourceLocation(ToEllipsisLoc), 
                new SourceLocation(ToColonLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDefaultStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4935,
   FQN="clang::ASTNodeImporter::VisitDefaultStmt", NM="_ZN5clang15ASTNodeImporter16VisitDefaultStmtEPNS_11DefaultStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitDefaultStmtEPNS_11DefaultStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitDefaultStmt(DefaultStmt /*P*/ S) {
    SourceLocation ToDefaultLoc = Importer.Import(S.getDefaultLoc());
    SourceLocation ToColonLoc = Importer.Import(S.getColonLoc());
    Stmt /*P*/ ToSubStmt = Importer.Import(S.getSubStmt());
    if (!(ToSubStmt != null) && (S.getSubStmt() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new DefaultStmt(new SourceLocation(ToDefaultLoc), new SourceLocation(ToColonLoc), 
                ToSubStmt);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4945,
   FQN="clang::ASTNodeImporter::VisitLabelStmt", NM="_ZN5clang15ASTNodeImporter14VisitLabelStmtEPNS_9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitLabelStmtEPNS_9LabelStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitLabelStmt(LabelStmt /*P*/ S) {
    SourceLocation ToIdentLoc = Importer.Import(S.getIdentLoc());
    LabelDecl /*P*/ ToLabelDecl = cast_or_null_LabelDecl(Importer.Import(S.getDecl()));
    if (!(ToLabelDecl != null) && (S.getDecl() != null)) {
      return null;
    }
    Stmt /*P*/ ToSubStmt = Importer.Import(S.getSubStmt());
    if (!(ToSubStmt != null) && (S.getSubStmt() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new LabelStmt(new SourceLocation(ToIdentLoc), ToLabelDecl, 
                ToSubStmt);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitAttributedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4958,
   FQN="clang::ASTNodeImporter::VisitAttributedStmt", NM="_ZN5clang15ASTNodeImporter19VisitAttributedStmtEPNS_14AttributedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitAttributedStmtEPNS_14AttributedStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitAttributedStmt(AttributedStmt /*P*/ S) {
    SourceLocation ToAttrLoc = Importer.Import(S.getAttrLoc());
    ArrayRef</*const*/ Attr /*P*/ > FromAttrs/*J*/= S.getAttrs();
    SmallVector</*const*/ Attr /*P*/ > ToAttrs/*J*/= new SmallVector</*const*/ Attr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 1, FromAttrs.size(), (/*const*/ Attr /*P*/ )null);
    final ASTContext /*&*/ _ToContext = Importer.getToContext();
    std.transform(FromAttrs.begin(), FromAttrs.end(), ToAttrs.begin(), 
        /*[&_ToContext]*/ (/*const*/ Attr /*P*/ A) -> {
              return A.clone(_ToContext);
            });
    for (/*const*/ Attr /*P*/ ToA : ToAttrs) {
      if (!(ToA != null)) {
        return null;
      }
    }
    Stmt /*P*/ ToSubStmt = Importer.Import(S.getSubStmt());
    if (!(ToSubStmt != null) && (S.getSubStmt() != null)) {
      return null;
    }
    return AttributedStmt.Create(Importer.getToContext(), new SourceLocation(ToAttrLoc), 
        new ArrayRef</*const*/ Attr /*P*/ >(ToAttrs, true), ToSubStmt);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitIfStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 4978,
   FQN="clang::ASTNodeImporter::VisitIfStmt", NM="_ZN5clang15ASTNodeImporter11VisitIfStmtEPNS_6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter11VisitIfStmtEPNS_6IfStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitIfStmt(IfStmt /*P*/ S) {
    SourceLocation ToIfLoc = Importer.Import(S.getIfLoc());
    Stmt /*P*/ ToInit = Importer.Import(S.getInit());
    if (!(ToInit != null) && (S.getInit() != null)) {
      return null;
    }
    VarDecl /*P*/ ToConditionVariable = null;
    {
      VarDecl /*P*/ FromConditionVariable = S.getConditionVariable();
      if ((FromConditionVariable != null)) {
        ToConditionVariable
           = dyn_cast_or_null_VarDecl(Importer.Import(FromConditionVariable));
        if (!(ToConditionVariable != null)) {
          return null;
        }
      }
    }
    Expr /*P*/ ToCondition = Importer.Import(S.getCond());
    if (!(ToCondition != null) && (S.getCond() != null)) {
      return null;
    }
    Stmt /*P*/ ToThenStmt = Importer.Import(S.getThen());
    if (!(ToThenStmt != null) && (S.getThen() != null)) {
      return null;
    }
    SourceLocation ToElseLoc = Importer.Import(S.getElseLoc());
    Stmt /*P*/ ToElseStmt = Importer.Import(S.getElse());
    if (!(ToElseStmt != null) && (S.getElse() != null)) {
      return null;
    }
    VarDecl $ToConditionVariable = ToConditionVariable;
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new IfStmt(Importer.getToContext(), 
                new SourceLocation(ToIfLoc), S.isConstexpr(), 
                ToInit, 
                $ToConditionVariable, 
                ToCondition, ToThenStmt, 
                new SourceLocation(ToElseLoc), ToElseStmt);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5008,
   FQN="clang::ASTNodeImporter::VisitSwitchStmt", NM="_ZN5clang15ASTNodeImporter15VisitSwitchStmtEPNS_10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitSwitchStmtEPNS_10SwitchStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitSwitchStmt(SwitchStmt /*P*/ S) {
    Stmt /*P*/ ToInit = Importer.Import(S.getInit());
    if (!(ToInit != null) && (S.getInit() != null)) {
      return null;
    }
    VarDecl /*P*/ ToConditionVariable = null;
    {
      VarDecl /*P*/ FromConditionVariable = S.getConditionVariable();
      if ((FromConditionVariable != null)) {
        ToConditionVariable
           = dyn_cast_or_null_VarDecl(Importer.Import(FromConditionVariable));
        if (!(ToConditionVariable != null)) {
          return null;
        }
      }
    }
    Expr /*P*/ ToCondition = Importer.Import(S.getCond());
    if (!(ToCondition != null) && (S.getCond() != null)) {
      return null;
    }
    VarDecl $ToConditionVariable = ToConditionVariable;
    SwitchStmt /*P*/ ToStmt = /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new SwitchStmt(Importer.getToContext(), ToInit, 
                $ToConditionVariable, ToCondition);
     });
    Stmt /*P*/ ToBody = Importer.Import(S.getBody());
    if (!(ToBody != null) && (S.getBody() != null)) {
      return null;
    }
    ToStmt.setBody(ToBody);
    ToStmt.setSwitchLoc(Importer.Import(S.getSwitchLoc()));
    // Now we have to re-chain the cases.
    SwitchCase /*P*/ LastChainedSwitchCase = null;
    for (SwitchCase /*P*/ SC = S.getSwitchCaseList(); SC != null;
         SC = SC.getNextSwitchCase()) {
      SwitchCase /*P*/ ToSC = dyn_cast_or_null_SwitchCase(Importer.Import(SC));
      if (!(ToSC != null)) {
        return null;
      }
      if ((LastChainedSwitchCase != null)) {
        LastChainedSwitchCase.setNextSwitchCase(ToSC);
      } else {
        ToStmt.setSwitchCaseList(ToSC);
      }
      LastChainedSwitchCase = ToSC;
    }
    return ToStmt;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitWhileStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5046,
   FQN="clang::ASTNodeImporter::VisitWhileStmt", NM="_ZN5clang15ASTNodeImporter14VisitWhileStmtEPNS_9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitWhileStmtEPNS_9WhileStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitWhileStmt(WhileStmt /*P*/ S) {
    VarDecl /*P*/ ToConditionVariable = null;
    {
      VarDecl /*P*/ FromConditionVariable = S.getConditionVariable();
      if ((FromConditionVariable != null)) {
        ToConditionVariable
           = dyn_cast_or_null_VarDecl(Importer.Import(FromConditionVariable));
        if (!(ToConditionVariable != null)) {
          return null;
        }
      }
    }
    Expr /*P*/ ToCondition = Importer.Import(S.getCond());
    if (!(ToCondition != null) && (S.getCond() != null)) {
      return null;
    }
    Stmt /*P*/ ToBody = Importer.Import(S.getBody());
    if (!(ToBody != null) && (S.getBody() != null)) {
      return null;
    }
    SourceLocation ToWhileLoc = Importer.Import(S.getWhileLoc());
    VarDecl $ToConditionVariable = ToConditionVariable;
    Expr $ToCondition = ToCondition;
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new WhileStmt(Importer.getToContext(), 
                $ToConditionVariable, 
                ToCondition, ToBody, 
                new SourceLocation(ToWhileLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5067,
   FQN="clang::ASTNodeImporter::VisitDoStmt", NM="_ZN5clang15ASTNodeImporter11VisitDoStmtEPNS_6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter11VisitDoStmtEPNS_6DoStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitDoStmt(DoStmt /*P*/ S) {
    Stmt /*P*/ ToBody = Importer.Import(S.getBody());
    if (!(ToBody != null) && (S.getBody() != null)) {
      return null;
    }
    Expr /*P*/ ToCondition = Importer.Import(S.getCond());
    if (!(ToCondition != null) && (S.getCond() != null)) {
      return null;
    }
    SourceLocation ToDoLoc = Importer.Import(S.getDoLoc());
    SourceLocation ToWhileLoc = Importer.Import(S.getWhileLoc());
    SourceLocation ToRParenLoc = Importer.Import(S.getRParenLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new DoStmt(ToBody, ToCondition, 
                new SourceLocation(ToDoLoc), new SourceLocation(ToWhileLoc), 
                new SourceLocation(ToRParenLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitForStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5082,
   FQN="clang::ASTNodeImporter::VisitForStmt", NM="_ZN5clang15ASTNodeImporter12VisitForStmtEPNS_7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter12VisitForStmtEPNS_7ForStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitForStmt(ForStmt /*P*/ S) {
    Stmt /*P*/ ToInit = Importer.Import(S.getInit());
    if (!(ToInit != null) && (S.getInit() != null)) {
      return null;
    }
    Expr /*P*/ ToCondition = Importer.Import(S.getCond());
    if (!(ToCondition != null) && (S.getCond() != null)) {
      return null;
    }
    VarDecl /*P*/ ToConditionVariable = null;
    {
      VarDecl /*P*/ FromConditionVariable = S.getConditionVariable();
      if ((FromConditionVariable != null)) {
        ToConditionVariable
           = dyn_cast_or_null_VarDecl(Importer.Import(FromConditionVariable));
        if (!(ToConditionVariable != null)) {
          return null;
        }
      }
    }
    Expr /*P*/ ToInc = Importer.Import(S.getInc());
    if (!(ToInc != null) && (S.getInc() != null)) {
      return null;
    }
    Stmt /*P*/ ToBody = Importer.Import(S.getBody());
    if (!(ToBody != null) && (S.getBody() != null)) {
      return null;
    }
    SourceLocation ToForLoc = Importer.Import(S.getForLoc());
    SourceLocation ToLParenLoc = Importer.Import(S.getLParenLoc());
    SourceLocation ToRParenLoc = Importer.Import(S.getRParenLoc());
    VarDecl $ToConditionVariable = ToConditionVariable;
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ForStmt(Importer.getToContext(), 
                ToInit, ToCondition, 
                $ToConditionVariable, 
                ToInc, ToBody, 
                new SourceLocation(ToForLoc), new SourceLocation(ToLParenLoc), 
                new SourceLocation(ToRParenLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitGotoStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5113,
   FQN="clang::ASTNodeImporter::VisitGotoStmt", NM="_ZN5clang15ASTNodeImporter13VisitGotoStmtEPNS_8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitGotoStmtEPNS_8GotoStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitGotoStmt(GotoStmt /*P*/ S) {
    LabelDecl /*P*/ ToLabel = null;
    {
      LabelDecl /*P*/ FromLabel = S.getLabel();
      if ((FromLabel != null)) {
        ToLabel = dyn_cast_or_null_LabelDecl(Importer.Import(FromLabel));
        if (!(ToLabel != null)) {
          return null;
        }
      }
    }
    SourceLocation ToGotoLoc = Importer.Import(S.getGotoLoc());
    SourceLocation ToLabelLoc = Importer.Import(S.getLabelLoc());
    LabelDecl $ToLabel = ToLabel;
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new GotoStmt($ToLabel, 
                new SourceLocation(ToGotoLoc), new SourceLocation(ToLabelLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitIndirectGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5126,
   FQN="clang::ASTNodeImporter::VisitIndirectGotoStmt", NM="_ZN5clang15ASTNodeImporter21VisitIndirectGotoStmtEPNS_16IndirectGotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitIndirectGotoStmtEPNS_16IndirectGotoStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitIndirectGotoStmt(IndirectGotoStmt /*P*/ S) {
    SourceLocation ToGotoLoc = Importer.Import(S.getGotoLoc());
    SourceLocation ToStarLoc = Importer.Import(S.getStarLoc());
    Expr /*P*/ ToTarget = Importer.Import(S.getTarget());
    if (!(ToTarget != null) && (S.getTarget() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new IndirectGotoStmt(new SourceLocation(ToGotoLoc), new SourceLocation(ToStarLoc), 
                ToTarget);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5136,
   FQN="clang::ASTNodeImporter::VisitContinueStmt", NM="_ZN5clang15ASTNodeImporter17VisitContinueStmtEPNS_12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitContinueStmtEPNS_12ContinueStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitContinueStmt(ContinueStmt /*P*/ S) {
    SourceLocation ToContinueLoc = Importer.Import(S.getContinueLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ContinueStmt(new SourceLocation(ToContinueLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5141,
   FQN="clang::ASTNodeImporter::VisitBreakStmt", NM="_ZN5clang15ASTNodeImporter14VisitBreakStmtEPNS_9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitBreakStmtEPNS_9BreakStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitBreakStmt(BreakStmt /*P*/ S) {
    SourceLocation ToBreakLoc = Importer.Import(S.getBreakLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new BreakStmt(new SourceLocation(ToBreakLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5146,
   FQN="clang::ASTNodeImporter::VisitReturnStmt", NM="_ZN5clang15ASTNodeImporter15VisitReturnStmtEPNS_10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitReturnStmtEPNS_10ReturnStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitReturnStmt(ReturnStmt /*P*/ S) {
    SourceLocation ToRetLoc = Importer.Import(S.getReturnLoc());
    Expr /*P*/ ToRetExpr = Importer.Import(S.getRetValue());
    if (!(ToRetExpr != null) && (S.getRetValue() != null)) {
      return null;
    }
    VarDecl /*P*/ NRVOCandidate = ((/*const_cast*/VarDecl /*P*/ )(S.getNRVOCandidate()));
    VarDecl /*P*/ ToNRVOCandidate = cast_or_null_VarDecl(Importer.Import(NRVOCandidate));
    if (!(ToNRVOCandidate != null) && (NRVOCandidate != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ReturnStmt(new SourceLocation(ToRetLoc), ToRetExpr, 
                ToNRVOCandidate);
     });
  }

  // FIXME: MSAsmStmt
  // FIXME: SEHExceptStmt
  // FIXME: SEHFinallyStmt
  // FIXME: SEHTryStmt
  // FIXME: SEHLeaveStmt
  // FIXME: CapturedStmt
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5159,
   FQN="clang::ASTNodeImporter::VisitCXXCatchStmt", NM="_ZN5clang15ASTNodeImporter17VisitCXXCatchStmtEPNS_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitCXXCatchStmtEPNS_12CXXCatchStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitCXXCatchStmt(CXXCatchStmt /*P*/ S) {
    SourceLocation ToCatchLoc = Importer.Import(S.getCatchLoc());
    VarDecl /*P*/ ToExceptionDecl = null;
    {
      VarDecl /*P*/ FromExceptionDecl = S.getExceptionDecl();
      if ((FromExceptionDecl != null)) {
        ToExceptionDecl
           = dyn_cast_or_null_VarDecl(Importer.Import(FromExceptionDecl));
        if (!(ToExceptionDecl != null)) {
          return null;
        }
      }
    }
    Stmt /*P*/ ToHandlerBlock = Importer.Import(S.getHandlerBlock());
    if (!(ToHandlerBlock != null) && (S.getHandlerBlock() != null)) {
      return null;
    }
    VarDecl $ToExceptionDecl = ToExceptionDecl;
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CXXCatchStmt(new SourceLocation(ToCatchLoc), 
                $ToExceptionDecl, 
                ToHandlerBlock);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5176,
   FQN="clang::ASTNodeImporter::VisitCXXTryStmt", NM="_ZN5clang15ASTNodeImporter15VisitCXXTryStmtEPNS_10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitCXXTryStmtEPNS_10CXXTryStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitCXXTryStmt(CXXTryStmt /*P*/ S) {
    SourceLocation ToTryLoc = Importer.Import(S.getTryLoc());
    Stmt /*P*/ ToTryBlock = Importer.Import(S.getTryBlock());
    if (!(ToTryBlock != null) && (S.getTryBlock() != null)) {
      return null;
    }
    SmallVector<Stmt /*P*/ > ToHandlers/*J*/= new SmallVector<Stmt /*P*/ >(JD$UInt_T$C$R.INSTANCE, 1, S.getNumHandlers(), (Stmt /*P*/ )null);
    for (/*uint*/int HI = 0, HE = S.getNumHandlers(); HI != HE; ++HI) {
      CXXCatchStmt /*P*/ FromHandler = S.getHandler(HI);
      {
        Stmt /*P*/ ToHandler = Importer.Import(FromHandler);
        if ((ToHandler != null)) {
          ToHandlers.$set(HI, ToHandler);
        } else {
          return null;
        }
      }
    }
    return CXXTryStmt.Create(Importer.getToContext(), new SourceLocation(ToTryLoc), ToTryBlock, 
        new ArrayRef<Stmt /*P*/ >(ToHandlers, true));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5193,
   FQN="clang::ASTNodeImporter::VisitCXXForRangeStmt", NM="_ZN5clang15ASTNodeImporter20VisitCXXForRangeStmtEPNS_15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitCXXForRangeStmtEPNS_15CXXForRangeStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitCXXForRangeStmt(CXXForRangeStmt /*P*/ S) {
    DeclStmt /*P*/ ToRange = dyn_cast_or_null_DeclStmt(Importer.Import(S.getRangeStmt()));
    if (!(ToRange != null) && (S.getRangeStmt() != null)) {
      return null;
    }
    DeclStmt /*P*/ ToBegin = dyn_cast_or_null_DeclStmt(Importer.Import(S.getBeginStmt()));
    if (!(ToBegin != null) && (S.getBeginStmt() != null)) {
      return null;
    }
    DeclStmt /*P*/ ToEnd = dyn_cast_or_null_DeclStmt(Importer.Import(S.getEndStmt()));
    if (!(ToEnd != null) && (S.getEndStmt() != null)) {
      return null;
    }
    Expr /*P*/ ToCond = Importer.Import(S.getCond());
    if (!(ToCond != null) && (S.getCond() != null)) {
      return null;
    }
    Expr /*P*/ ToInc = Importer.Import(S.getInc());
    if (!(ToInc != null) && (S.getInc() != null)) {
      return null;
    }
    DeclStmt /*P*/ ToLoopVar = dyn_cast_or_null_DeclStmt(Importer.Import(S.getLoopVarStmt()));
    if (!(ToLoopVar != null) && (S.getLoopVarStmt() != null)) {
      return null;
    }
    Stmt /*P*/ ToBody = Importer.Import(S.getBody());
    if (!(ToBody != null) && (S.getBody() != null)) {
      return null;
    }
    SourceLocation ToForLoc = Importer.Import(S.getForLoc());
    SourceLocation ToCoawaitLoc = Importer.Import(S.getCoawaitLoc());
    SourceLocation ToColonLoc = Importer.Import(S.getColonLoc());
    SourceLocation ToRParenLoc = Importer.Import(S.getRParenLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CXXForRangeStmt(ToRange, ToBegin, ToEnd, 
                ToCond, ToInc, 
                ToLoopVar, ToBody, 
                new SourceLocation(ToForLoc), new SourceLocation(ToCoawaitLoc), 
                new SourceLocation(ToColonLoc), new SourceLocation(ToRParenLoc));
     });
  }

  // FIXME: MSDependentExistsStmt
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5230,
   FQN="clang::ASTNodeImporter::VisitObjCForCollectionStmt", NM="_ZN5clang15ASTNodeImporter26VisitObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter26VisitObjCForCollectionStmtEPNS_21ObjCForCollectionStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCForCollectionStmt(ObjCForCollectionStmt /*P*/ S) {
    Stmt /*P*/ ToElem = Importer.Import(S.getElement());
    if (!(ToElem != null) && (S.getElement() != null)) {
      return null;
    }
    Expr /*P*/ ToCollect = Importer.Import(S.getCollection());
    if (!(ToCollect != null) && (S.getCollection() != null)) {
      return null;
    }
    Stmt /*P*/ ToBody = Importer.Import(S.getBody());
    if (!(ToBody != null) && (S.getBody() != null)) {
      return null;
    }
    SourceLocation ToForLoc = Importer.Import(S.getForLoc());
    SourceLocation ToRParenLoc = Importer.Import(S.getRParenLoc());
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ObjCForCollectionStmt(ToElem, 
                ToCollect, 
                ToBody, new SourceLocation(ToForLoc), 
                new SourceLocation(ToRParenLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCAtCatchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5248,
   FQN="clang::ASTNodeImporter::VisitObjCAtCatchStmt", NM="_ZN5clang15ASTNodeImporter20VisitObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitObjCAtCatchStmtEPNS_15ObjCAtCatchStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCAtCatchStmt(ObjCAtCatchStmt /*P*/ S) {
    SourceLocation ToAtCatchLoc = Importer.Import(S.getAtCatchLoc());
    SourceLocation ToRParenLoc = Importer.Import(S.getRParenLoc());
    VarDecl /*P*/ ToExceptionDecl = null;
    {
      VarDecl /*P*/ FromExceptionDecl = S.getCatchParamDecl();
      if ((FromExceptionDecl != null)) {
        ToExceptionDecl
           = dyn_cast_or_null_VarDecl(Importer.Import(FromExceptionDecl));
        if (!(ToExceptionDecl != null)) {
          return null;
        }
      }
    }
    Stmt /*P*/ ToBody = Importer.Import(S.getCatchBody());
    if (!(ToBody != null) && (S.getCatchBody() != null)) {
      return null;
    }
    VarDecl $ToExceptionDecl = ToExceptionDecl;
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ObjCAtCatchStmt(new SourceLocation(ToAtCatchLoc), 
                new SourceLocation(ToRParenLoc), 
                $ToExceptionDecl, 
                ToBody);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCAtFinallyStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5267,
   FQN="clang::ASTNodeImporter::VisitObjCAtFinallyStmt", NM="_ZN5clang15ASTNodeImporter22VisitObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitObjCAtFinallyStmtEPNS_17ObjCAtFinallyStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCAtFinallyStmt(ObjCAtFinallyStmt /*P*/ S) {
    SourceLocation ToAtFinallyLoc = Importer.Import(S.getAtFinallyLoc());
    Stmt /*P*/ ToAtFinallyStmt = Importer.Import(S.getFinallyBody());
    if (!(ToAtFinallyStmt != null) && (S.getFinallyBody() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ObjCAtFinallyStmt(new SourceLocation(ToAtFinallyLoc), 
                ToAtFinallyStmt);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCAtTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5276,
   FQN="clang::ASTNodeImporter::VisitObjCAtTryStmt", NM="_ZN5clang15ASTNodeImporter18VisitObjCAtTryStmtEPNS_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitObjCAtTryStmtEPNS_13ObjCAtTryStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCAtTryStmt(ObjCAtTryStmt /*P*/ S) {
    SourceLocation ToAtTryLoc = Importer.Import(S.getAtTryLoc());
    Stmt /*P*/ ToAtTryStmt = Importer.Import(S.getTryBody());
    if (!(ToAtTryStmt != null) && (S.getTryBody() != null)) {
      return null;
    }
    SmallVector<Stmt /*P*/ > ToCatchStmts/*J*/= new SmallVector<Stmt /*P*/ >(JD$UInt_T$C$R.INSTANCE, 1, S.getNumCatchStmts(), (Stmt /*P*/ )null);
    for (/*uint*/int CI = 0, CE = S.getNumCatchStmts(); CI != CE; ++CI) {
      ObjCAtCatchStmt /*P*/ FromCatchStmt = S.getCatchStmt(CI);
      {
        Stmt /*P*/ ToCatchStmt = Importer.Import(FromCatchStmt);
        if ((ToCatchStmt != null)) {
          ToCatchStmts.$set(CI, ToCatchStmt);
        } else {
          return null;
        }
      }
    }
    Stmt /*P*/ ToAtFinallyStmt = Importer.Import(S.getFinallyStmt());
    if (!(ToAtFinallyStmt != null) && (S.getFinallyStmt() != null)) {
      return null;
    }
    return ObjCAtTryStmt.Create(Importer.getToContext(), 
        new SourceLocation(ToAtTryLoc), ToAtTryStmt, 
        ToCatchStmts.begin(), ToCatchStmts.size(), 
        ToAtFinallyStmt);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5298,
   FQN="clang::ASTNodeImporter::VisitObjCAtSynchronizedStmt", NM="_ZN5clang15ASTNodeImporter27VisitObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter27VisitObjCAtSynchronizedStmtEPNS_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCAtSynchronizedStmt(ObjCAtSynchronizedStmt /*P*/ S) {
    SourceLocation ToAtSynchronizedLoc = Importer.Import(S.getAtSynchronizedLoc());
    Expr /*P*/ ToSynchExpr = Importer.Import(S.getSynchExpr());
    if (!(ToSynchExpr != null) && (S.getSynchExpr() != null)) {
      return null;
    }
    Stmt /*P*/ ToSynchBody = Importer.Import(S.getSynchBody());
    if (!(ToSynchBody != null) && (S.getSynchBody() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ObjCAtSynchronizedStmt(new SourceLocation(ToAtSynchronizedLoc), ToSynchExpr, ToSynchBody);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCAtThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5312,
   FQN="clang::ASTNodeImporter::VisitObjCAtThrowStmt", NM="_ZN5clang15ASTNodeImporter20VisitObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitObjCAtThrowStmtEPNS_15ObjCAtThrowStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCAtThrowStmt(ObjCAtThrowStmt /*P*/ S) {
    SourceLocation ToAtThrowLoc = Importer.Import(S.getThrowLoc());
    Expr /*P*/ ToThrow = Importer.Import(S.getThrowExpr());
    if (!(ToThrow != null) && (S.getThrowExpr() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ObjCAtThrowStmt(new SourceLocation(ToAtThrowLoc), ToThrow);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitObjCAutoreleasePoolStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5320,
   FQN="clang::ASTNodeImporter::VisitObjCAutoreleasePoolStmt", NM="_ZN5clang15ASTNodeImporter28VisitObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter28VisitObjCAutoreleasePoolStmtEPNS_23ObjCAutoreleasePoolStmtE")
  //</editor-fold>
  public Stmt /*P*/ VisitObjCAutoreleasePoolStmt(ObjCAutoreleasePoolStmt /*P*/ S) {
    SourceLocation ToAtLoc = Importer.Import(S.getAtLoc());
    Stmt /*P*/ ToSubStmt = Importer.Import(S.getSubStmt());
    if (!(ToSubStmt != null) && (S.getSubStmt() != null)) {
      return null;
    }
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ObjCAutoreleasePoolStmt(new SourceLocation(ToAtLoc), 
                ToSubStmt);
     });
  }

  
  // Importing expressions
  
  //----------------------------------------------------------------------------
  // Import Expressions
  //----------------------------------------------------------------------------
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5333,
   FQN="clang::ASTNodeImporter::VisitExpr", NM="_ZN5clang15ASTNodeImporter9VisitExprEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter9VisitExprEPNS_4ExprE")
  //</editor-fold>
  public Expr /*P*/ VisitExpr(Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Importer.FromDiag(E.getLocStart(), diag.err_unsupported_ast_node)), 
          E.getStmtClassName()));
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5339,
   FQN="clang::ASTNodeImporter::VisitVAArgExpr", NM="_ZN5clang15ASTNodeImporter14VisitVAArgExprEPNS_9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitVAArgExprEPNS_9VAArgExprE")
  //</editor-fold>
  public Expr /*P*/ VisitVAArgExpr(VAArgExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ SubExpr = Importer.Import(E.getSubExpr());
    if (!(SubExpr != null) && (E.getSubExpr() != null)) {
      return null;
    }
    
    TypeSourceInfo /*P*/ TInfo = Importer.Import(E.getWrittenTypeInfo());
    if (!(TInfo != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new VAArgExpr(Importer.Import(E.getBuiltinLoc()), SubExpr, TInfo, 
                Importer.Import(E.getRParenLoc()), new QualType(T), E.isMicrosoftABI());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5358,
   FQN="clang::ASTNodeImporter::VisitGNUNullExpr", NM="_ZN5clang15ASTNodeImporter16VisitGNUNullExprEPNS_11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitGNUNullExprEPNS_11GNUNullExprE")
  //</editor-fold>
  public Expr /*P*/ VisitGNUNullExpr(GNUNullExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new GNUNullExpr(new QualType(T), Importer.Import(E.getExprLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5367,
   FQN="clang::ASTNodeImporter::VisitPredefinedExpr", NM="_ZN5clang15ASTNodeImporter19VisitPredefinedExprEPNS_14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitPredefinedExprEPNS_14PredefinedExprE")
  //</editor-fold>
  public Expr /*P*/ VisitPredefinedExpr(PredefinedExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    StringLiteral /*P*/ SL = cast_or_null_StringLiteral(Importer.Import(E.getFunctionName()));
    if (!(SL != null) && (E.getFunctionName() != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new PredefinedExpr(Importer.Import(E.getExprLoc()), new QualType(T), E.getIdentType(), SL);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5381,
   FQN="clang::ASTNodeImporter::VisitDeclRefExpr", NM="_ZN5clang15ASTNodeImporter16VisitDeclRefExprEPNS_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitDeclRefExprEPNS_11DeclRefExprE")
  //</editor-fold>
  public Expr /*P*/ VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    ValueDecl /*P*/ ToD = cast_or_null_ValueDecl(Importer.Import(E.getDecl()));
    if (!(ToD != null)) {
      return null;
    }
    
    NamedDecl /*P*/ FoundD = null;
    if (E.getDecl() != E.getFoundDecl()) {
      FoundD = cast_or_null_NamedDecl(Importer.Import(E.getFoundDecl()));
      if (!(FoundD != null)) {
        return null;
      }
    }
    
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    DeclRefExpr /*P*/ DRE = DeclRefExpr.Create(Importer.getToContext(), 
        Importer.Import(E.getQualifierLoc()), 
        Importer.Import(E.getTemplateKeywordLoc()), 
        ToD, 
        E.refersToEnclosingVariableOrCapture(), 
        Importer.Import(E.getLocation()), 
        new QualType(T), E.getValueKind(), 
        FoundD, 
        /*FIXME:TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null);
    if (E.hadMultipleCandidates()) {
      DRE.setHadMultipleCandidates(true);
    }
    return DRE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5411,
   FQN="clang::ASTNodeImporter::VisitImplicitValueInitExpr", NM="_ZN5clang15ASTNodeImporter26VisitImplicitValueInitExprEPNS_21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter26VisitImplicitValueInitExprEPNS_21ImplicitValueInitExprE")
  //</editor-fold>
  public Expr /*P*/ VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ImplicitValueInitExpr(new QualType(T));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitDesignatedInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5440,
   FQN="clang::ASTNodeImporter::VisitDesignatedInitExpr", NM="_ZN5clang15ASTNodeImporter23VisitDesignatedInitExprEPNS_18DesignatedInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23VisitDesignatedInitExprEPNS_18DesignatedInitExprE")
  //</editor-fold>
  public Expr /*P*/ VisitDesignatedInitExpr(DesignatedInitExpr /*P*/ DIE) {
    Expr /*P*/ Init = cast_or_null_Expr(Importer.Import(DIE.getInit()));
    if (!(Init != null)) {
      return null;
    }
    
    SmallVector<Expr /*P*/ > IndexExprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, DIE.getNumSubExprs() - 1, (Expr /*P*/ )null);
    // List elements from the second, the first is Init itself
    for (/*uint*/int I = 1, E = DIE.getNumSubExprs(); $less_uint(I, E); I++) {
      {
        Expr /*P*/ Arg = cast_or_null_Expr(Importer.Import(DIE.getSubExpr(I)));
        if ((Arg != null)) {
          IndexExprs.$set(I - 1, Arg);
        } else {
          return null;
        }
      }
    }
    
    SmallVector<DesignatedInitExpr.Designator> Designators/*J*/= new SmallVector<DesignatedInitExpr.Designator>(JD$UInt_T$C$R.INSTANCE, 4, DIE.size(), new DesignatedInitExpr.Designator());
    llvm.transform(DIE.designators(), Designators.begin(), 
        /*[this]*/ (final /*const*/ DesignatedInitExpr.Designator /*&*/ D) -> {
              return ImportDesignator(D);
            });
    
    for (final /*const*/ DesignatedInitExpr.Designator /*&*/ D : DIE.designators())  {
      if (D.isFieldDesignator() && !(D.getFieldName() != null)) {
        return null;
      }
    }
    
    return DesignatedInitExpr.Create(Importer.getToContext(), new ArrayRef<DesignatedInitExpr.Designator>(Designators, false), 
        new ArrayRef<Expr /*P*/ >(IndexExprs, true), Importer.Import(DIE.getEqualOrColonLoc()), 
        DIE.usesGNUSyntax(), Init);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5470,
   FQN="clang::ASTNodeImporter::VisitCXXNullPtrLiteralExpr", NM="_ZN5clang15ASTNodeImporter26VisitCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter26VisitCXXNullPtrLiteralExprEPNS_21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXNullPtrLiteralExpr(CXXNullPtrLiteralExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CXXNullPtrLiteralExpr(new QualType(T), Importer.Import(E.getLocation()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5479,
   FQN="clang::ASTNodeImporter::VisitIntegerLiteral", NM="_ZN5clang15ASTNodeImporter19VisitIntegerLiteralEPNS_14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitIntegerLiteralEPNS_14IntegerLiteralE")
  //</editor-fold>
  public Expr /*P*/ VisitIntegerLiteral(IntegerLiteral /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return IntegerLiteral.Create(Importer.getToContext(), 
        E.getValue(), new QualType(T), 
        Importer.Import(E.getLocation()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5489,
   FQN="clang::ASTNodeImporter::VisitFloatingLiteral", NM="_ZN5clang15ASTNodeImporter20VisitFloatingLiteralEPNS_15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitFloatingLiteralEPNS_15FloatingLiteralE")
  //</editor-fold>
  public Expr /*P*/ VisitFloatingLiteral(FloatingLiteral /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return FloatingLiteral.Create(Importer.getToContext(), 
        E.getValue(), E.isExact(), new QualType(T), 
        Importer.Import(E.getLocation()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5499,
   FQN="clang::ASTNodeImporter::VisitCharacterLiteral", NM="_ZN5clang15ASTNodeImporter21VisitCharacterLiteralEPNS_16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitCharacterLiteralEPNS_16CharacterLiteralE")
  //</editor-fold>
  public Expr /*P*/ VisitCharacterLiteral(CharacterLiteral /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CharacterLiteral(E.getValue(), 
                E.getKind(), new QualType(T), 
                Importer.Import(E.getLocation()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5509,
   FQN="clang::ASTNodeImporter::VisitStringLiteral", NM="_ZN5clang15ASTNodeImporter18VisitStringLiteralEPNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitStringLiteralEPNS_13StringLiteralE")
  //</editor-fold>
  public Expr /*P*/ VisitStringLiteral(StringLiteral /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    SmallVector<SourceLocation> Locations/*J*/= new SmallVector<SourceLocation>(JD$UInt_T$C$R.INSTANCE, 4, E.getNumConcatenated(), new SourceLocation());
    ImportArray(E.tokloc_begin(), E.tokloc_end(), Locations.begin());
    
    return StringLiteral.Create(Importer.getToContext(), E.getBytes(), 
        E.getKind(), E.isPascal(), new QualType(T), 
        Locations.data(), Locations.size());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5522,
   FQN="clang::ASTNodeImporter::VisitCompoundLiteralExpr", NM="_ZN5clang15ASTNodeImporter24VisitCompoundLiteralExprEPNS_19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitCompoundLiteralExprEPNS_19CompoundLiteralExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    TypeSourceInfo /*P*/ TInfo = Importer.Import(E.getTypeSourceInfo());
    if (!(TInfo != null)) {
      return null;
    }
    
    Expr /*P*/ Init = Importer.Import(E.getInitializer());
    if (!(Init != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CompoundLiteralExpr(Importer.Import(E.getLParenLoc()), TInfo, new QualType(T), E.getValueKind(), 
                Init, E.isFileScope());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5540,
   FQN="clang::ASTNodeImporter::VisitAtomicExpr", NM="_ZN5clang15ASTNodeImporter15VisitAtomicExprEPNS_10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitAtomicExprEPNS_10AtomicExprE")
  //</editor-fold>
  public Expr /*P*/ VisitAtomicExpr(AtomicExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 6, E.getNumSubExprs(), (Expr /*P*/ )null);
    if (ImportArrayChecked(E.getSubExprs(), E.getSubExprs().$add(E.getNumSubExprs()), 
        Exprs.begin())) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new AtomicExpr(Importer.Import(E.getBuiltinLoc()), new ArrayRef<Expr /*P*/ >(Exprs, true), new QualType(T), E.getOp(), 
                Importer.Import(E.getRParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5556,
   FQN="clang::ASTNodeImporter::VisitAddrLabelExpr", NM="_ZN5clang15ASTNodeImporter18VisitAddrLabelExprEPNS_13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitAddrLabelExprEPNS_13AddrLabelExprE")
  //</editor-fold>
  public Expr /*P*/ VisitAddrLabelExpr(AddrLabelExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    LabelDecl /*P*/ ToLabel = cast_or_null_LabelDecl(Importer.Import(E.getLabel()));
    if (!(ToLabel != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new AddrLabelExpr(Importer.Import(E.getAmpAmpLoc()), Importer.Import(E.getLabelLoc()), 
                ToLabel, new QualType(T));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5570,
   FQN="clang::ASTNodeImporter::VisitParenExpr", NM="_ZN5clang15ASTNodeImporter14VisitParenExprEPNS_9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter14VisitParenExprEPNS_9ParenExprE")
  //</editor-fold>
  public Expr /*P*/ VisitParenExpr(ParenExpr /*P*/ E) {
    Expr /*P*/ SubExpr = Importer.Import(E.getSubExpr());
    if (!(SubExpr != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ParenExpr(Importer.Import(E.getLParen()), 
                Importer.Import(E.getRParen()), 
                SubExpr);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitParenListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5581,
   FQN="clang::ASTNodeImporter::VisitParenListExpr", NM="_ZN5clang15ASTNodeImporter18VisitParenListExprEPNS_13ParenListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitParenListExprEPNS_13ParenListExprE")
  //</editor-fold>
  public Expr /*P*/ VisitParenListExpr(ParenListExpr /*P*/ E) {
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, E.getNumExprs(), (Expr /*P*/ )null);
    if (ImportArrayChecked(E.getExprs(), E.getExprs().$add(E.getNumExprs()), Exprs.begin())) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ParenListExpr(Importer.getToContext(), Importer.Import(E.getLParenLoc()), 
                new ArrayRef<Expr /*P*/ >(Exprs, true), Importer.Import(E.getLParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5592,
   FQN="clang::ASTNodeImporter::VisitStmtExpr", NM="_ZN5clang15ASTNodeImporter13VisitStmtExprEPNS_8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitStmtExprEPNS_8StmtExprE")
  //</editor-fold>
  public Expr /*P*/ VisitStmtExpr(StmtExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    CompoundStmt /*P*/ ToSubStmt = cast_or_null_CompoundStmt(Importer.Import(E.getSubStmt()));
    if (!(ToSubStmt != null) && (E.getSubStmt() != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new StmtExpr(ToSubStmt, new QualType(T), 
                Importer.Import(E.getLParenLoc()), Importer.Import(E.getRParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5606,
   FQN="clang::ASTNodeImporter::VisitUnaryOperator", NM="_ZN5clang15ASTNodeImporter18VisitUnaryOperatorEPNS_13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18VisitUnaryOperatorEPNS_13UnaryOperatorE")
  //</editor-fold>
  public Expr /*P*/ VisitUnaryOperator(UnaryOperator /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ SubExpr = Importer.Import(E.getSubExpr());
    if (!(SubExpr != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new UnaryOperator(SubExpr, E.getOpcode(), 
                new QualType(T), E.getValueKind(), 
                E.getObjectKind(), 
                Importer.Import(E.getOperatorLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5621,
   FQN="clang::ASTNodeImporter::VisitUnaryExprOrTypeTraitExpr", NM="_ZN5clang15ASTNodeImporter29VisitUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter29VisitUnaryExprOrTypeTraitExprEPNS_24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public Expr /*P*/ VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ E) {
    QualType ResultType = Importer.Import(E.getType());
    if (E.isArgumentType()) {
      TypeSourceInfo /*P*/ TInfo = Importer.Import(E.getArgumentTypeInfo());
      if (!(TInfo != null)) {
        return null;
      }
      
      return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
          return new UnaryExprOrTypeTraitExpr(E.getKind(), 
                  TInfo, new QualType(ResultType), 
                  Importer.Import(E.getOperatorLoc()), 
                  Importer.Import(E.getRParenLoc()));
       });
    }
    
    Expr /*P*/ SubExpr = Importer.Import(E.getArgumentExpr());
    if (!(SubExpr != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new UnaryExprOrTypeTraitExpr(E.getKind(), 
                SubExpr, new QualType(ResultType), 
                Importer.Import(E.getOperatorLoc()), 
                Importer.Import(E.getRParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5646,
   FQN="clang::ASTNodeImporter::VisitBinaryOperator", NM="_ZN5clang15ASTNodeImporter19VisitBinaryOperatorEPNS_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitBinaryOperatorEPNS_14BinaryOperatorE")
  //</editor-fold>
  public Expr /*P*/ VisitBinaryOperator(BinaryOperator /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ LHS = Importer.Import(E.getLHS());
    if (!(LHS != null)) {
      return null;
    }
    
    Expr /*P*/ RHS = Importer.Import(E.getRHS());
    if (!(RHS != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new BinaryOperator(LHS, RHS, E.getOpcode(), 
                new QualType(T), E.getValueKind(), 
                E.getObjectKind(), 
                Importer.Import(E.getOperatorLoc()), 
                E.isFPContractable());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5666,
   FQN="clang::ASTNodeImporter::VisitConditionalOperator", NM="_ZN5clang15ASTNodeImporter24VisitConditionalOperatorEPNS_19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter24VisitConditionalOperatorEPNS_19ConditionalOperatorE")
  //</editor-fold>
  public Expr /*P*/ VisitConditionalOperator(ConditionalOperator /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ ToLHS = Importer.Import(E.getLHS());
    if (!(ToLHS != null)) {
      return null;
    }
    
    Expr /*P*/ ToRHS = Importer.Import(E.getRHS());
    if (!(ToRHS != null)) {
      return null;
    }
    
    Expr /*P*/ ToCond = Importer.Import(E.getCond());
    if (!(ToCond != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new ConditionalOperator(ToCond, Importer.Import(E.getQuestionLoc()), 
                ToLHS, Importer.Import(E.getColonLoc()), 
                ToRHS, new QualType(T), E.getValueKind(), E.getObjectKind());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5689,
   FQN="clang::ASTNodeImporter::VisitBinaryConditionalOperator", NM="_ZN5clang15ASTNodeImporter30VisitBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter30VisitBinaryConditionalOperatorEPNS_25BinaryConditionalOperatorE")
  //</editor-fold>
  public Expr /*P*/ VisitBinaryConditionalOperator(BinaryConditionalOperator /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ Common = Importer.Import(E.getCommon());
    if (!(Common != null)) {
      return null;
    }
    
    Expr /*P*/ Cond = Importer.Import(E.getCond());
    if (!(Cond != null)) {
      return null;
    }
    
    OpaqueValueExpr /*P*/ OpaqueValue = cast_or_null_OpaqueValueExpr(Importer.Import(E.getOpaqueValue()));
    if (!(OpaqueValue != null)) {
      return null;
    }
    
    Expr /*P*/ TrueExpr = Importer.Import(E.getTrueExpr());
    if (!(TrueExpr != null)) {
      return null;
    }
    
    Expr /*P*/ FalseExpr = Importer.Import(E.getFalseExpr());
    if (!(FalseExpr != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new BinaryConditionalOperator(Common, OpaqueValue, Cond, TrueExpr, FalseExpr, 
                Importer.Import(E.getQuestionLoc()), Importer.Import(E.getColonLoc()), 
                new QualType(T), E.getValueKind(), E.getObjectKind());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5722,
   FQN="clang::ASTNodeImporter::VisitOpaqueValueExpr", NM="_ZN5clang15ASTNodeImporter20VisitOpaqueValueExprEPNS_15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter20VisitOpaqueValueExprEPNS_15OpaqueValueExprE")
  //</editor-fold>
  public Expr /*P*/ VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ SourceExpr = Importer.Import(E.getSourceExpr());
    if (!(SourceExpr != null) && (E.getSourceExpr() != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new OpaqueValueExpr(Importer.Import(E.getExprLoc()), new QualType(T), E.getValueKind(), 
                E.getObjectKind(), SourceExpr);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5736,
   FQN="clang::ASTNodeImporter::VisitCompoundAssignOperator", NM="_ZN5clang15ASTNodeImporter27VisitCompoundAssignOperatorEPNS_22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter27VisitCompoundAssignOperatorEPNS_22CompoundAssignOperatorE")
  //</editor-fold>
  public Expr /*P*/ VisitCompoundAssignOperator(CompoundAssignOperator /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    QualType CompLHSType = Importer.Import(E.getComputationLHSType());
    if (CompLHSType.isNull()) {
      return null;
    }
    
    QualType CompResultType = Importer.Import(E.getComputationResultType());
    if (CompResultType.isNull()) {
      return null;
    }
    
    Expr /*P*/ LHS = Importer.Import(E.getLHS());
    if (!(LHS != null)) {
      return null;
    }
    
    Expr /*P*/ RHS = Importer.Import(E.getRHS());
    if (!(RHS != null)) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CompoundAssignOperator(LHS, RHS, E.getOpcode(), 
                new QualType(T), E.getValueKind(), 
                E.getObjectKind(), 
                new QualType(CompLHSType), new QualType(CompResultType), 
                Importer.Import(E.getOperatorLoc()), 
                E.isFPContractable());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5773,
   FQN="clang::ASTNodeImporter::VisitImplicitCastExpr", NM="_ZN5clang15ASTNodeImporter21VisitImplicitCastExprEPNS_16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitImplicitCastExprEPNS_16ImplicitCastExprE")
  //</editor-fold>
  public Expr /*P*/ VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ SubExpr = Importer.Import(E.getSubExpr());
    if (!(SubExpr != null)) {
      return null;
    }
    
    SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
    if (ImportCastPath(E, BasePath)) {
      return null;
    }
    
    return ImplicitCastExpr.Create(Importer.getToContext(), new QualType(T), E.getCastKind(), 
        SubExpr, $AddrOf(BasePath), E.getValueKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCStyleCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5790,
   FQN="clang::ASTNodeImporter::VisitCStyleCastExpr", NM="_ZN5clang15ASTNodeImporter19VisitCStyleCastExprEPNS_14CStyleCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter19VisitCStyleCastExprEPNS_14CStyleCastExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCStyleCastExpr(CStyleCastExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ SubExpr = Importer.Import(E.getSubExpr());
    if (!(SubExpr != null)) {
      return null;
    }
    
    TypeSourceInfo /*P*/ TInfo = Importer.Import(E.getTypeInfoAsWritten());
    if (!(TInfo != null) && (E.getTypeInfoAsWritten() != null)) {
      return null;
    }
    
    SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
    if (ImportCastPath(E, BasePath)) {
      return null;
    }
    
    return CStyleCastExpr.Create(Importer.getToContext(), new QualType(T), 
        E.getValueKind(), E.getCastKind(), 
        SubExpr, $AddrOf(BasePath), TInfo, 
        Importer.Import(E.getLParenLoc()), 
        Importer.Import(E.getRParenLoc()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5814,
   FQN="clang::ASTNodeImporter::VisitCXXConstructExpr", NM="_ZN5clang15ASTNodeImporter21VisitCXXConstructExprEPNS_16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitCXXConstructExprEPNS_16CXXConstructExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    CXXConstructorDecl /*P*/ ToCCD = dyn_cast_or_null_CXXConstructorDecl(Importer.Import(E.getConstructor()));
    if (!(ToCCD != null)) {
      return null;
    }
    
    SmallVector<Expr /*P*/ > ToArgs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 6, E.getNumArgs(), (Expr /*P*/ )null);
    if (ImportArrayChecked(E.getArgs(), E.getArgs().$add(E.getNumArgs()), 
        ToArgs.begin())) {
      return null;
    }
    
    return CXXConstructExpr.Create(Importer.getToContext(), new QualType(T), 
        Importer.Import(E.getLocation()), 
        ToCCD, E.isElidable(), 
        new ArrayRef<Expr /*P*/ >(ToArgs, true), E.hadMultipleCandidates(), 
        E.isListInitialization(), 
        E.isStdInitListInitialization(), 
        E.requiresZeroInitialization(), 
        E.getConstructionKind(), 
        Importer.Import(E.getParenOrBraceRange()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5840,
   FQN="clang::ASTNodeImporter::VisitCXXMemberCallExpr", NM="_ZN5clang15ASTNodeImporter22VisitCXXMemberCallExprEPNS_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter22VisitCXXMemberCallExprEPNS_17CXXMemberCallExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXMemberCallExpr(CXXMemberCallExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ ToFn = Importer.Import(E.getCallee());
    if (!(ToFn != null)) {
      return null;
    }
    
    SmallVector<Expr /*P*/ > ToArgs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, E.getNumArgs(), (Expr /*P*/ )null);
    if (ImportArrayChecked(E.arg_begin(), E.arg_end(), ToArgs.begin())) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CXXMemberCallExpr(Importer.getToContext(), ToFn, new ArrayRef<Expr /*P*/ >(ToArgs, true), new QualType(T), E.getValueKind(), 
                Importer.Import(E.getRParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5859,
   FQN="clang::ASTNodeImporter::VisitCXXThisExpr", NM="_ZN5clang15ASTNodeImporter16VisitCXXThisExprEPNS_11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter16VisitCXXThisExprEPNS_11CXXThisExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXThisExpr(CXXThisExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CXXThisExpr(Importer.Import(E.getLocation()), new QualType(T), E.isImplicit());
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5868,
   FQN="clang::ASTNodeImporter::VisitCXXBoolLiteralExpr", NM="_ZN5clang15ASTNodeImporter23VisitCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23VisitCXXBoolLiteralExprEPNS_18CXXBoolLiteralExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CXXBoolLiteralExpr(E.getValue(), new QualType(T), Importer.Import(E.getLocation()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5878,
   FQN="clang::ASTNodeImporter::VisitMemberExpr", NM="_ZN5clang15ASTNodeImporter15VisitMemberExprEPNS_10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter15VisitMemberExprEPNS_10MemberExprE")
  //</editor-fold>
  public Expr /*P*/ VisitMemberExpr(MemberExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ ToBase = Importer.Import(E.getBase());
    if (!(ToBase != null) && (E.getBase() != null)) {
      return null;
    }
    
    ValueDecl /*P*/ ToMember = dyn_cast_ValueDecl(Importer.Import(E.getMemberDecl()));
    if (!(ToMember != null) && (E.getMemberDecl() != null)) {
      return null;
    }
    
    DeclAccessPair ToFoundDecl = DeclAccessPair.make(dyn_cast_NamedDecl(Importer.Import(E.getFoundDecl().getDecl())), 
        E.getFoundDecl().getAccess());
    
    DeclarationNameInfo ToMemberNameInfo/*J*/= new DeclarationNameInfo(Importer.Import(E.getMemberNameInfo().getName()), 
        Importer.Import(E.getMemberNameInfo().getLoc()));
    if (E.hasExplicitTemplateArgs()) {
      return null; // FIXME: handle template arguments
    }
    
    return MemberExpr.Create(Importer.getToContext(), ToBase, 
        E.isArrow(), 
        Importer.Import(E.getOperatorLoc()), 
        Importer.Import(E.getQualifierLoc()), 
        Importer.Import(E.getTemplateKeywordLoc()), 
        ToMember, new DeclAccessPair(ToFoundDecl), new DeclarationNameInfo(ToMemberNameInfo), 
        (/*const*/ TemplateArgumentListInfo /*P*/ )null, new QualType(T), E.getValueKind(), 
        E.getObjectKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5913,
   FQN="clang::ASTNodeImporter::VisitCallExpr", NM="_ZN5clang15ASTNodeImporter13VisitCallExprEPNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter13VisitCallExprEPNS_8CallExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCallExpr(CallExpr /*P*/ E) {
    QualType T = Importer.Import(E.getType());
    if (T.isNull()) {
      return null;
    }
    
    Expr /*P*/ ToCallee = Importer.Import(E.getCallee());
    if (!(ToCallee != null) && (E.getCallee() != null)) {
      return null;
    }
    
    /*uint*/int NumArgs = E.getNumArgs();
    
    SmallVector<Expr /*P*/ > ToArgs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 2, NumArgs, (Expr /*P*/ )null);
    
    for (/*uint*/int ai = 0, ae = NumArgs; ai != ae; ++ai) {
      Expr /*P*/ FromArg = E.getArg(ai);
      Expr /*P*/ ToArg = Importer.Import(FromArg);
      if (!(ToArg != null)) {
        return null;
      }
      ToArgs.$set(ai, ToArg);
    }
    
    type$ptr<Expr /*P*/ /*P*/> ToArgs_Copied = create_const_type$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
    /*new (Importer.getToContext())*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new Expr /*P*/ [NumArgs]);
    
    for (/*uint*/int ai = 0, ae = NumArgs; ai != ae; ++ai)  {
      ToArgs_Copied.$set(ai, ToArgs.$at(ai));
    }
    
    return /*NEW_EXPR [Stmt::new]*//*new (Importer.getToContext())*/ Stmt.$new_uint_ASTContext$C_uint(Importer.getToContext(), (type$ptr<?> New$Mem)->{
        return new CallExpr(Importer.getToContext(), ToCallee, 
                llvm.makeArrayRef(ToArgs_Copied, NumArgs), new QualType(T), E.getValueKind(), 
                Importer.Import(E.getRParenLoc()));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5946,
   FQN="clang::ASTNodeImporter::VisitInitListExpr", NM="_ZN5clang15ASTNodeImporter17VisitInitListExprEPNS_12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter17VisitInitListExprEPNS_12InitListExprE")
  //</editor-fold>
  public Expr /*P*/ VisitInitListExpr(InitListExpr /*P*/ ILE) {
    QualType T = Importer.Import(ILE.getType());
    if (T.isNull()) {
      return null;
    }
    
    SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, ILE.getNumInits(), (Expr /*P*/ )null);
    if (ImportArrayChecked(ILE.getInits(), ILE.getInits().$add(ILE.getNumInits()), Exprs.begin())) {
      return null;
    }
    
    final ASTContext /*&*/ ToCtx = Importer.getToContext();
    InitListExpr /*P*/ To = /*NEW_EXPR [Stmt::new]*//*new (ToCtx)*/ Stmt.$new_uint_ASTContext$C_uint(ToCtx, (type$ptr<?> New$Mem)->{
        return new InitListExpr(ToCtx, Importer.Import(ILE.getLBraceLoc()), 
                new ArrayRef<Expr /*P*/ >(Exprs, true), Importer.Import(ILE.getLBraceLoc()));
     });
    To.setType(new QualType(T));
    if (ILE.hasArrayFiller()) {
      Expr /*P*/ Filler = Importer.Import(ILE.getArrayFiller());
      if (!(Filler != null)) {
        return null;
      }
      To.setArrayFiller(Filler);
    }
    {
      
      FieldDecl /*P*/ FromFD = ILE.getInitializedFieldInUnion();
      if ((FromFD != null)) {
        FieldDecl /*P*/ ToFD = cast_or_null_FieldDecl(Importer.Import(FromFD));
        if (!(ToFD != null)) {
          return null;
        }
        To.setInitializedFieldInUnion(ToFD);
      }
    }
    {
      
      InitListExpr /*P*/ SyntForm = ILE.getSyntacticForm();
      if ((SyntForm != null)) {
        InitListExpr /*P*/ ToSyntForm = cast_or_null_InitListExpr(Importer.Import(SyntForm));
        if (!(ToSyntForm != null)) {
          return null;
        }
        To.setSyntacticForm(ToSyntForm);
      }
    }
    
    To.sawArrayRangeDesignator(ILE.hadArrayRangeDesignator());
    To.setValueDependent(ILE.isValueDependent());
    To.setInstantiationDependent(ILE.isInstantiationDependent());
    
    return To;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5991,
   FQN="clang::ASTNodeImporter::VisitCXXDefaultInitExpr", NM="_ZN5clang15ASTNodeImporter23VisitCXXDefaultInitExprEPNS_18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter23VisitCXXDefaultInitExprEPNS_18CXXDefaultInitExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ DIE) {
    FieldDecl /*P*/ ToField = dyn_cast_or_null_FieldDecl(Importer.Import(DIE.getField()));
    if (!(ToField != null) && (DIE.getField() != null)) {
      return null;
    }
    
    return CXXDefaultInitExpr.Create(Importer.getToContext(), Importer.Import(DIE.getLocStart()), ToField);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::VisitCXXNamedCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6001,
   FQN="clang::ASTNodeImporter::VisitCXXNamedCastExpr", NM="_ZN5clang15ASTNodeImporter21VisitCXXNamedCastExprEPNS_16CXXNamedCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter21VisitCXXNamedCastExprEPNS_16CXXNamedCastExprE")
  //</editor-fold>
  public Expr /*P*/ VisitCXXNamedCastExpr(CXXNamedCastExpr /*P*/ E) {
    QualType ToType = Importer.Import(E.getType());
    if (ToType.isNull() && !E.getType().isNull()) {
      return null;
    }
    ExprValueKind VK = E.getValueKind();
    CastKind CK = E.getCastKind();
    Expr /*P*/ ToOp = Importer.Import(E.getSubExpr());
    if (!(ToOp != null) && (E.getSubExpr() != null)) {
      return null;
    }
    SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
    if (ImportCastPath(E, BasePath)) {
      return null;
    }
    TypeSourceInfo /*P*/ ToWritten = Importer.Import(E.getTypeInfoAsWritten());
    SourceLocation ToOperatorLoc = Importer.Import(E.getOperatorLoc());
    SourceLocation ToRParenLoc = Importer.Import(E.getRParenLoc());
    SourceRange ToAngleBrackets = Importer.Import(E.getAngleBrackets());
    if (isa_CXXStaticCastExpr(E)) {
      return CXXStaticCastExpr.Create(Importer.getToContext(), new QualType(ToType), VK, CK, ToOp, $AddrOf(BasePath), 
          ToWritten, new SourceLocation(ToOperatorLoc), new SourceLocation(ToRParenLoc), new SourceRange(ToAngleBrackets));
    } else if (isa_CXXDynamicCastExpr(E)) {
      return CXXDynamicCastExpr.Create(Importer.getToContext(), new QualType(ToType), VK, CK, ToOp, $AddrOf(BasePath), 
          ToWritten, new SourceLocation(ToOperatorLoc), new SourceLocation(ToRParenLoc), new SourceRange(ToAngleBrackets));
    } else if (isa_CXXReinterpretCastExpr(E)) {
      return CXXReinterpretCastExpr.Create(Importer.getToContext(), new QualType(ToType), VK, CK, ToOp, $AddrOf(BasePath), 
          ToWritten, new SourceLocation(ToOperatorLoc), new SourceLocation(ToRParenLoc), new SourceRange(ToAngleBrackets));
    } else {
      return null;
    }
  }

  
  /*template <typename IIter, typename OIter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTNodeImporter::ImportArray">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 259,
   FQN="clang::ASTNodeImporter::ImportArray", NM="_ZN5clang15ASTNodeImporter11ImportArrayIPKNS_14SourceLocationEPS2_EEvT_S6_T0_",
   //cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter11ImportArrayIPKNS_14SourceLocationEPS2_EEvT_S6_T0_")
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=Tpl__ZN5clang15ASTNodeImporter18ImportArrayCheckedET_S1_T0_")
  //</editor-fold>
  public void ImportArray(/*const*/type$ptr<SourceLocation> /*P*/ Ibegin, /*const*/type$ptr<SourceLocation> /*P*/ Iend, type$ptr<SourceLocation> /*P*/ Obegin) {
    /*typedef typename std::remove_reference<decltype(*Obegin)>::type ItemT*/
  //  final class ItemT extends SourceLocation{ };
    final ASTImporter /*&*/ ImporterRef = Importer;
    std.transform(Ibegin, Iend, Obegin, 
        /*[&ImporterRef]*/ (SourceLocation From) -> {
              return ImporterRef.Import(new SourceLocation(From));
            });
  }

  @Converted(kind = Converted.Kind.INSTANTIATION,
          source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 269,
          FQN = "clang::ASTNodeImporter::ImportArrayChecked", NM = "_ZN5clang15ASTNodeImporter18ImportArrayCheckedINS_4Stmt12ExprIteratorEPPNS_4ExprEEEbT_S7_T0_",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18ImportArrayCheckedINS_4Stmt12ExprIteratorEPPNS_4ExprEEEbT_S7_T0_")
//</editor-fold>
  public boolean ImportArrayChecked(Stmt.ExprIterator Ibegin, Stmt.ExprIterator Iend, type$ptr<Expr /*P*/ /*P*/> Obegin) {
    /*typedef typename std::remove_reference<decltype(**Obegin)>::type ItemT*/
//  final class ItemT extends Expr{ };
    final ASTImporter /*&*/ ImporterRef = Importer;
    bool$ref Failed = create_bool$ref(false);
    std.transform(new Stmt.ExprIterator(Ibegin), new Stmt.ExprIterator(Iend), Obegin,
            /*[&ImporterRef, &Failed]*/ (Expr /*P*/ From) -> {
              Expr /*P*/ To = ImporterRef.Import(From);
              if (!(To != null) && (From != null)) {
                Failed.$set(true);
              }
              return To;
            });
    return Failed.$deref();
  }

  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 269,
   FQN="clang::ASTNodeImporter::ImportArrayChecked", NM="_ZN5clang15ASTNodeImporter18ImportArrayCheckedIPPNS_4StmtES4_EEbT_S5_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18ImportArrayCheckedIPPNS_4StmtES4_EEbT_S5_T0_")
  //</editor-fold>
  public boolean ImportArrayCheckedStmt(type$ptr<Stmt /*P*/ /*P*/> Ibegin, type$ptr<Stmt /*P*/ /*P*/> Iend, type$ptr<Stmt /*P*/ /*P*/> Obegin) {
    /*typedef typename std::remove_reference<decltype(**Obegin)>::type ItemT*/
//  final class ItemT extends Stmt{ };
    final ASTImporter /*&*/ ImporterRef = Importer;
    bool$ref Failed = create_bool$ref(false);
    std.transform(Ibegin, Iend, Obegin,
            /*[&ImporterRef, &Failed]*/ (Stmt /*P*/ From) -> {
              Stmt /*P*/ To = ImporterRef.Import(From);
              if (!(To != null) && (From != null)) {
                Failed.$set(true);
              }
              return To;
            });
    return Failed.$deref();
  }

  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 269,
   FQN="clang::ASTNodeImporter::ImportArrayChecked", NM="_ZN5clang15ASTNodeImporter18ImportArrayCheckedIPPNS_4ExprES4_EEbT_S5_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang15ASTNodeImporter18ImportArrayCheckedIPPNS_4ExprES4_EEbT_S5_T0_")
  //</editor-fold>
  public boolean ImportArrayChecked(type$ptr<Expr /*P*/ /*P*/> Ibegin, type$ptr<Expr /*P*/ /*P*/> Iend, type$ptr<Expr /*P*/ /*P*/> Obegin) {
    /*typedef typename std::remove_reference<decltype(**Obegin)>::type ItemT*/
//  final class ItemT extends Expr{ };
    final ASTImporter /*&*/ ImporterRef = Importer;
    bool$ref Failed = create_bool$ref(false);
    std.transform(Ibegin, Iend, Obegin,
            /*[&ImporterRef, &Failed]*/ (Expr /*P*/ From) -> {
              Expr /*P*/ To = ImporterRef.Import(From);
              if (!(To != null) && (From != null)) {
                Failed.$set(true);
              }
              return To;
            });
    return Failed.$deref();
  }

  @Override public String toString() {
    return "" + "Importer=" + Importer // NOI18N
              + super.toString(); // NOI18N
  }
}

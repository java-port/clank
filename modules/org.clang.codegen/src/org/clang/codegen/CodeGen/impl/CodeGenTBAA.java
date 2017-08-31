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

package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.llvm.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.impl.CodeGenTBAAStatics.*;


/// CodeGenTBAA - This class organizes the cross-module state that is used
/// while lowering AST types to LLVM types.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.h", line = 45,
 FQN="clang::CodeGen::CodeGenTBAA", NM="_ZN5clang7CodeGen11CodeGenTBAAE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAAE")
//</editor-fold>
public class CodeGenTBAA implements Destructors.ClassWithDestructor {
  private final ASTContext /*&*/ Context;
  private final /*const*/ CodeGenOptions /*&*/ CodeGenOpts;
  private final /*const*/ LangOptions /*&*/ Features;
  private final MangleContext /*&*/ MContext;
  
  // MDHelper - Helper for creating metadata.
  private MDBuilder MDHelper;
  
  /// MetadataCache - This maps clang::Types to scalar llvm::MDNodes describing
  /// them.
  private DenseMap</*const*/ org.clang.ast.Type /*P*/ , MDNode /*P*/ > MetadataCache;
  /// This maps clang::Types to a struct node in the type DAG.
  private DenseMap</*const*/ org.clang.ast.Type /*P*/ , MDNode /*P*/ > StructTypeMetadataCache;
  /// This maps TBAAPathTags to a tag node.
  private DenseMap<TBAAPathTag, MDNode /*P*/ > StructTagMetadataCache;
  /// This maps a scalar type to a scalar tag node.
  private DenseMap</*const*/ MDNode /*P*/ , MDNode /*P*/ > ScalarTagMetadataCache;
  
  /// StructMetadataCache - This maps clang::Types to llvm::MDNodes describing
  /// them for struct assignments.
  private DenseMap</*const*/ org.clang.ast.Type /*P*/ , MDNode /*P*/ > StructMetadataCache;
  
  private MDNode /*P*/ Root;
  private MDNode /*P*/ Char;
  
  /// getRoot - This is the mdnode for the root of the metadata type graph
  /// for this translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 42,
   FQN="clang::CodeGen::CodeGenTBAA::getRoot", NM="_ZN5clang7CodeGen11CodeGenTBAA7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA7getRootEv")
  //</editor-fold>
  private MDNode /*P*/ getRoot() {
    // Define the root of the tree. This identifies the tree, so that
    // if our LLVM IR is linked with LLVM IR from a different front-end
    // (or a different version of this front-end), their TBAA trees will
    // remain distinct, and the optimizer will treat them conservatively.
    if (!(Root != null)) {
      if (Features.CPlusPlus) {
        Root = MDHelper.createTBAARoot(new StringRef(/*KEEP_STR*/"Simple C++ TBAA"));
      } else {
        Root = MDHelper.createTBAARoot(new StringRef(/*KEEP_STR*/"Simple C/C++ TBAA"));
      }
    }
    
    return Root;
  }

  
  /// getChar - This is the mdnode for "char", which is special, and any types
  /// considered to be equivalent to it.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getChar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 64,
   FQN="clang::CodeGen::CodeGenTBAA::getChar", NM="_ZN5clang7CodeGen11CodeGenTBAA7getCharEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA7getCharEv")
  //</editor-fold>
  private MDNode /*P*/ getChar() {
    // Define the root of the tree for user-accessible memory. C and C++
    // give special powers to char and certain similar types. However,
    // these special powers only cover user-accessible memory, and doesn't
    // include things like vtables.
    if (!(Char != null)) {
      Char = createTBAAScalarType(new StringRef(/*KEEP_STR*/"omnipotent char"), getRoot());
    }
    
    return Char;
  }

  
  /// CollectFields - Collect information about the fields of a type for
  /// !tbaa.struct metadata formation. Return false for an unsupported type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::CollectFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 173,
   FQN="clang::CodeGen::CodeGenTBAA::CollectFields", NM="_ZN5clang7CodeGen11CodeGenTBAA13CollectFieldsEyNS_8QualTypeERN4llvm15SmallVectorImplINS3_9MDBuilder15TBAAStructFieldEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA13CollectFieldsEyNS_8QualTypeERN4llvm15SmallVectorImplINS3_9MDBuilder15TBAAStructFieldEEEb")
  //</editor-fold>
  private boolean CollectFields(long/*uint64_t*/ BaseOffset, 
               QualType QTy, 
               final SmallVectorImpl<MDBuilder.TBAAStructField> /*&*/ Fields, 
               boolean MayAlias) {
    {
      /* Things not handled yet include: C++ base classes, bitfields, */
      /*const*/ RecordType /*P*/ TTy = QTy.$arrow().getAs$RecordType();
      if ((TTy != null)) {
        /*const*/ RecordDecl /*P*/ RD = TTy.getDecl().getDefinition();
        if (RD.hasFlexibleArrayMember()) {
          return false;
        }
        {
          
          // TODO: Handle C++ base classes.
          /*const*/ CXXRecordDecl /*P*/ Decl = dyn_cast_CXXRecordDecl(RD);
          if ((Decl != null)) {
            if ($noteq_ptr(Decl.bases_begin$Const(), Decl.bases_end$Const())) {
              return false;
            }
          }
        }
        
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
        
        /*uint*/int idx = 0;
        for (specific_decl_iterator<FieldDecl> i = RD.field_begin(), 
            e = RD.field_end(); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc() , ++idx) {
          long/*uint64_t*/ Offset = BaseOffset
             + $div_ulong(Layout.getFieldOffset(idx), Context.getCharWidth());
          QualType FieldQTy = i.$arrow().getType();
          if (!CollectFields(Offset, new QualType(FieldQTy), Fields, 
              MayAlias || TypeHasMayAlias(new QualType(FieldQTy)))) {
            return false;
          }
        }
        return true;
      }
    }
    
    /* Otherwise, treat whatever it is as a field. */
    long/*uint64_t*/ Offset = BaseOffset;
    long/*uint64_t*/ Size = Context.getTypeSizeInChars(/*NO_COPY*/QTy).getQuantity();
    MDNode /*P*/ TBAAInfo = MayAlias ? getChar() : getTBAAInfo(new QualType(QTy));
    MDNode /*P*/ TBAATag = getTBAAScalarTagInfo(TBAAInfo);
    Fields.push_back(new MDBuilder.TBAAStructField(Offset, Size, TBAATag));
    return true;
  }

  
  /// A wrapper function to create a scalar type. For struct-path aware TBAA,
  /// the scalar type has the same format as the struct type: name, offset,
  /// pointer to another node in the type DAG.
  
  // For both scalar TBAA and struct-path aware TBAA, the scalar type has the
  // same format: name, parent node, and offset.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::createTBAAScalarType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 59,
   FQN="clang::CodeGen::CodeGenTBAA::createTBAAScalarType", NM="_ZN5clang7CodeGen11CodeGenTBAA20createTBAAScalarTypeEN4llvm9StringRefEPNS2_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA20createTBAAScalarTypeEN4llvm9StringRefEPNS2_6MDNodeE")
  //</editor-fold>
  private MDNode /*P*/ createTBAAScalarType(StringRef Name, 
                      MDNode /*P*/ Parent) {
    return MDHelper.createTBAAScalarTypeNode(new StringRef(Name), Parent);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::CodeGenTBAA">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 32,
   FQN="clang::CodeGen::CodeGenTBAA::CodeGenTBAA", NM="_ZN5clang7CodeGen11CodeGenTBAAC1ERNS_10ASTContextERN4llvm11LLVMContextERKNS_14CodeGenOptionsERKNS_11LangOptionsERNS_13MangleContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAAC1ERNS_10ASTContextERN4llvm11LLVMContextERKNS_14CodeGenOptionsERKNS_11LangOptionsERNS_13MangleContextE")
  //</editor-fold>
  public CodeGenTBAA(final ASTContext /*&*/ Ctx, final LLVMContext /*&*/ VMContext, 
      final /*const*/ CodeGenOptions /*&*/ CGO, 
      final /*const*/ LangOptions /*&*/ Features, final MangleContext /*&*/ MContext) {
    // : Context(Ctx), CodeGenOpts(CGO), Features(Features), MContext(MContext), MDHelper(VMContext), MetadataCache(), StructTypeMetadataCache(), StructTagMetadataCache(), ScalarTagMetadataCache(), StructMetadataCache(), Root(null), Char(null) 
    //START JInit
    this./*&*/Context=/*&*/Ctx;
    this./*&*/CodeGenOpts=/*&*/CGO;
    this./*&*/Features=/*&*/Features;
    this./*&*/MContext=/*&*/MContext;
    this.MDHelper = new MDBuilder(VMContext);
    this.MetadataCache = new DenseMap</*const*/ org.clang.ast.Type /*P*/ , MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MDNode /*P*/ )null);
    this.StructTypeMetadataCache = new DenseMap</*const*/ org.clang.ast.Type /*P*/ , MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MDNode /*P*/ )null);
    this.StructTagMetadataCache = new DenseMap<TBAAPathTag, MDNode /*P*/ >(DenseMapInfoTBAAPathTag.$Info(), (MDNode /*P*/ )null);
    this.ScalarTagMetadataCache = new DenseMap</*const*/ MDNode /*P*/ , MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MDNode /*P*/ )null);
    this.StructMetadataCache = new DenseMap</*const*/ org.clang.ast.Type /*P*/ , MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MDNode /*P*/ )null);
    this.Root = null;
    this.Char = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::~CodeGenTBAA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 39,
   FQN="clang::CodeGen::CodeGenTBAA::~CodeGenTBAA", NM="_ZN5clang7CodeGen11CodeGenTBAAD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAAD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    StructMetadataCache.$destroy();
    ScalarTagMetadataCache.$destroy();
    StructTagMetadataCache.$destroy();
    StructTypeMetadataCache.$destroy();
    MetadataCache.$destroy();
    //END JDestroy
  }

  
  /// getTBAAInfo - Get the TBAA MDNode to be used for a dereference
  /// of the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getTBAAInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 91,
   FQN="clang::CodeGen::CodeGenTBAA::getTBAAInfo", NM="_ZN5clang7CodeGen11CodeGenTBAA11getTBAAInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA11getTBAAInfoENS_8QualTypeE")
  //</editor-fold>
  public MDNode /*P*/ getTBAAInfo(QualType QTy) {
    // At -O0 or relaxed aliasing, TBAA is not emitted for regular types.
    if ($2bits_uint2uint(CodeGenOpts.OptimizationLevel) == 0 || CodeGenOpts.RelaxedAliasing) {
      return null;
    }
    
    // If the type has the may_alias attribute (even on a typedef), it is
    // effectively in the general char alias class.
    if (TypeHasMayAlias(new QualType(QTy))) {
      return getChar();
    }
    
    /*const*/ org.clang.ast.Type /*P*/ Ty = Context.getCanonicalType(/*NO_COPY*/QTy).getTypePtr();
    {
      
      MDNode /*P*/ N = MetadataCache.$at_T1$C$R(Ty);
      if ((N != null)) {
        return N;
      }
    }
    {
      
      // Handle builtin types.
      /*const*/ BuiltinType /*P*/ BTy = dyn_cast_BuiltinType(Ty);
      if ((BTy != null)) {
        switch (BTy.getKind()) {
         case Char_U:
         case Char_S:
         case UChar:
         case SChar:
          // Character types are special and can alias anything.
          // In C++, this technically only includes "char" and "unsigned char",
          // and not "signed char". In C, it includes all three. For now,
          // the risk of exploiting this detail in C++ seems likely to outweigh
          // the benefit.
          return getChar();
         case UShort:
          
          // Unsigned types can alias their corresponding signed types.
          return getTBAAInfo(Context.ShortTy.$QualType());
         case UInt:
          return getTBAAInfo(Context.IntTy.$QualType());
         case ULong:
          return getTBAAInfo(Context.LongTy.$QualType());
         case ULongLong:
          return getTBAAInfo(Context.LongLongTy.$QualType());
         case UInt128:
          return getTBAAInfo(Context.Int128Ty.$QualType());
         default:
          
          // Treat all other builtin types as distinct types. This includes
          // treating wchar_t, char16_t, and char32_t as distinct from their
          // "underlying types".
          return MetadataCache.$set(Ty, 
            createTBAAScalarType(BTy.getName(new PrintingPolicy(Features)), getChar()));
        }
      }
    }
    
    // Handle pointers.
    // TODO: Implement C++'s type "similarity" and consider dis-"similar"
    // pointers distinct.
    if (Ty.isPointerType()) {
      return MetadataCache.$set(Ty, createTBAAScalarType(new StringRef(/*KEEP_STR*/"any pointer"), 
          getChar()));
    }
    {
      
      // Enum types are distinct types. In C++ they have "underlying types",
      // however they aren't related for TBAA.
      /*const*/ EnumType /*P*/ ETy = dyn_cast_EnumType(Ty);
      if ((ETy != null)) {
        raw_svector_ostream Out = null;
        try {
          // In C++ mode, types have linkage, so we can rely on the ODR and
          // on their mangled names, if they're external.
          // TODO: Is there a way to get a program-wide unique name for a
          // decl with local linkage or no linkage?
          if (!Features.CPlusPlus || !ETy.getDecl().isExternallyVisible()) {
            return MetadataCache.$set(Ty, getChar());
          }
          
          SmallString/*256*/ OutName/*J*/= new SmallString/*256*/(256);
          Out/*J*/= new raw_svector_ostream(OutName);
          MContext.mangleTypeName(new QualType(ETy, 0), Out);
          return MetadataCache.$set(Ty, createTBAAScalarType(OutName.$StringRef(), getChar()));
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
    }
    
    // For now, handle any other kind of type conservatively.
    return MetadataCache.$set(Ty, getChar());
  }

  
  /// getTBAAInfoForVTablePtr - Get the TBAA MDNode to be used for a
  /// dereference of a vtable pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getTBAAInfoForVTablePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 169,
   FQN="clang::CodeGen::CodeGenTBAA::getTBAAInfoForVTablePtr", NM="_ZN5clang7CodeGen11CodeGenTBAA23getTBAAInfoForVTablePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA23getTBAAInfoForVTablePtrEv")
  //</editor-fold>
  public MDNode /*P*/ getTBAAInfoForVTablePtr() {
    return createTBAAScalarType(new StringRef(/*KEEP_STR*/"vtable pointer"), getRoot());
  }

  
  /// getTBAAStructInfo - Get the TBAAStruct MDNode to be used for a memcpy of
  /// the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getTBAAStructInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 215,
   FQN="clang::CodeGen::CodeGenTBAA::getTBAAStructInfo", NM="_ZN5clang7CodeGen11CodeGenTBAA17getTBAAStructInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA17getTBAAStructInfoENS_8QualTypeE")
  //</editor-fold>
  public MDNode /*P*/ getTBAAStructInfo(QualType QTy) {
    /*const*/ org.clang.ast.Type /*P*/ Ty = Context.getCanonicalType(/*NO_COPY*/QTy).getTypePtr();
    {
      
      MDNode /*P*/ N = StructMetadataCache.$at_T1$C$R(Ty);
      if ((N != null)) {
        return N;
      }
    }
    
    SmallVector<MDBuilder.TBAAStructField> Fields/*J*/= new SmallVector<MDBuilder.TBAAStructField>(4, new MDBuilder.TBAAStructField());
    if (CollectFields($int2ulong(0), new QualType(QTy), Fields, TypeHasMayAlias(new QualType(QTy)))) {
      return MDHelper.createTBAAStructNode(new ArrayRef<MDBuilder.TBAAStructField>(Fields, false));
    }
    
    // For now, handle any other kind of type conservatively.
    return StructMetadataCache.$set(Ty, null);
  }

  
  /// Get the MDNode in the type DAG for given struct type QType.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getTBAAStructTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 244,
   FQN="clang::CodeGen::CodeGenTBAA::getTBAAStructTypeInfo", NM="_ZN5clang7CodeGen11CodeGenTBAA21getTBAAStructTypeInfoENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA21getTBAAStructTypeInfoENS_8QualTypeE")
  //</editor-fold>
  public MDNode /*P*/ getTBAAStructTypeInfo(QualType QTy) {
    /*const*/ org.clang.ast.Type /*P*/ Ty = Context.getCanonicalType(/*NO_COPY*/QTy).getTypePtr();
    assert (isTBAAPathStruct(new QualType(QTy)));
    {
      
      MDNode /*P*/ N = StructTypeMetadataCache.$at_T1$C$R(Ty);
      if ((N != null)) {
        return N;
      }
    }
    {
      
      /*const*/ RecordType /*P*/ TTy = QTy.$arrow().getAs$RecordType();
      if ((TTy != null)) {
        /*const*/ RecordDecl /*P*/ RD = TTy.getDecl().getDefinition();
        
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
        SmallVector<std.pairPtrULong<MDNode /*P*/ >> Fields/*J*/= new SmallVector<std.pairPtrULong<MDNode /*P*/ >>(4, new std.pairPtrULong<MDNode /*P*/ >());
        /*uint*/int idx = 0;
        for (specific_decl_iterator<FieldDecl> i = RD.field_begin(), 
            e = RD.field_end(); specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc() , ++idx) {
          QualType FieldQTy = i.$arrow().getType();
          MDNode /*P*/ FieldNode;
          if (isTBAAPathStruct(new QualType(FieldQTy))) {
            FieldNode = getTBAAStructTypeInfo(new QualType(FieldQTy));
          } else {
            FieldNode = getTBAAInfo(new QualType(FieldQTy));
          }
          if (!(FieldNode != null)) {
            return StructTypeMetadataCache.$set(Ty, null);
          }
          Fields.push_back(std.make_pair_Ptr_ulong(FieldNode, $div_ulong(Layout.getFieldOffset(idx), Context.getCharWidth())));
        }
        
        SmallString/*256*/ OutName/*J*/= new SmallString/*256*/(256);
        if (Features.CPlusPlus) {
          raw_svector_ostream Out = null;
          try {
            // Don't use the mangler for C code.
            Out/*J*/= new raw_svector_ostream(OutName);
            MContext.mangleTypeName(new QualType(Ty, 0), Out);
          } finally {
            if (Out != null) { Out.$destroy(); }
          }
        } else {
          OutName.$assign(RD.getName());
        }
        // Create the struct type node with a vector of pairs (offset, type).
        return StructTypeMetadataCache.$set(Ty, 
          MDHelper.createTBAAStructTypeNode(OutName.$StringRef(), new ArrayRef<std.pairPtrULong<MDNode /*P*/ >>(Fields)));
      }
    }
    
    return StructMetadataCache.$set(Ty, null);
  }

  /// Get the tag MDNode for a given base type, the actual scalar access MDNode
  /// and offset into the base type.
  
  /// Return a TBAA tag node for both scalar TBAA and struct-path aware TBAA.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getTBAAStructTagInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 289,
   FQN="clang::CodeGen::CodeGenTBAA::getTBAAStructTagInfo", NM="_ZN5clang7CodeGen11CodeGenTBAA20getTBAAStructTagInfoENS_8QualTypeEPN4llvm6MDNodeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA20getTBAAStructTagInfoENS_8QualTypeEPN4llvm6MDNodeEy")
  //</editor-fold>
  public MDNode /*P*/ getTBAAStructTagInfo(QualType BaseQTy, MDNode /*P*/ AccessNode, 
                      long/*uint64_t*/ Offset) {
    if (!(AccessNode != null)) {
      return null;
    }
    if (!CodeGenOpts.StructPathTBAA) {
      return getTBAAScalarTagInfo(AccessNode);
    }
    
    /*const*/ org.clang.ast.Type /*P*/ BTy = Context.getCanonicalType(/*NO_COPY*/BaseQTy).getTypePtr();
    TBAAPathTag PathTag = new TBAAPathTag(BTy, AccessNode, Offset);
    {
      MDNode /*P*/ N = StructTagMetadataCache.$at_T1$C$R(PathTag);
      if ((N != null)) {
        return N;
      }
    }
    
    MDNode /*P*/ BNode = null;
    if (isTBAAPathStruct(new QualType(BaseQTy))) {
      BNode = getTBAAStructTypeInfo(new QualType(BaseQTy));
    }
    if (!(BNode != null)) {
      return StructTagMetadataCache.$set(PathTag, 
        MDHelper.createTBAAStructTagNode(AccessNode, AccessNode, $int2ulong(0)));
    }
    
    return StructTagMetadataCache.$set(PathTag, 
      MDHelper.createTBAAStructTagNode(BNode, AccessNode, Offset));
  }

  
  /// Get the scalar tag MDNode for a given scalar type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTBAA::getTBAAScalarTagInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp", line = 314,
   FQN="clang::CodeGen::CodeGenTBAA::getTBAAScalarTagInfo", NM="_ZN5clang7CodeGen11CodeGenTBAA20getTBAAScalarTagInfoEPN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTBAA.cpp -nm=_ZN5clang7CodeGen11CodeGenTBAA20getTBAAScalarTagInfoEPN4llvm6MDNodeE")
  //</editor-fold>
  public MDNode /*P*/ getTBAAScalarTagInfo(MDNode /*P*/ AccessNode) {
    if (!(AccessNode != null)) {
      return null;
    }
    {
      MDNode /*P*/ N = ScalarTagMetadataCache.$at_T1$RR(AccessNode);
      if ((N != null)) {
        return N;
      }
    }
    
    return ScalarTagMetadataCache.$set(AccessNode, 
      MDHelper.createTBAAStructTagNode(AccessNode, AccessNode, $int2ulong(0)));
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", Features=" + Features // NOI18N
              + ", MContext=" + "[MangleContext]" // NOI18N
              + ", MDHelper=" + "[MDBuilder]" // NOI18N
              + ", MetadataCache=" + MetadataCache // NOI18N
              + ", StructTypeMetadataCache=" + StructTypeMetadataCache // NOI18N
              + ", StructTagMetadataCache=" + StructTagMetadataCache // NOI18N
              + ", ScalarTagMetadataCache=" + ScalarTagMetadataCache // NOI18N
              + ", StructMetadataCache=" + StructMetadataCache // NOI18N
              + ", Root=" + Root // NOI18N
              + ", Char=" + Char; // NOI18N
  }
}

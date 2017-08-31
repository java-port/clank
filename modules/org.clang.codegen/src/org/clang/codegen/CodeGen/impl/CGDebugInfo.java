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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.llvm.ir.*;
import org.clang.basic.Module;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.basic.CallingConv;
import org.clang.ast.ArrayType;
import org.clang.ast.FunctionType;
import org.clang.ast.PointerType;
import org.clang.ast.VectorType;
import org.clang.ast.Type;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import org.clang.basic.llvm.impl.DenseMapInfoStringRef;
import org.clang.codegen.impl.CGDebugInfoStatics;
import org.llvm.support.dwarf.*;
import static org.clang.codegen.impl.CGDebugInfoStatics.*;
import org.llvm.support.sys.fs;
import static org.llvm.support.sys.fs.*;
import org.llvm.support.sys.path;
import static org.llvm.support.sys.path.*;
import org.llvm.target.target.DebuggerKind;


/// This class gathers all debug information during compilation and is
/// responsible for emitting to llvm globals or pass directly to the
/// backend.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 52,
 FQN="clang::CodeGen::CGDebugInfo", NM="_ZN5clang7CodeGen11CGDebugInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfoE")
//</editor-fold>
public class CGDebugInfo implements Destructors.ClassWithDestructor {
  /*friend  class ApplyDebugLocation*/
  /*friend  class SaveAndRestoreLocation*/
  private final CodeGenModule /*&*/ CGM;
  private /*const*/ DebugInfoKind DebugKind;
  private boolean DebugTypeExtRefs;
  private DIBuilder DBuilder;
  private DICompileUnit /*P*/ TheCU/* = null*/;
  private ModuleMap /*P*/ ClangModuleMap/* = null*/;
  private ExternalASTSource.ASTSourceDescriptor PCHDescriptor;
  private SourceLocation CurLoc;
  private DIType /*P*/ VTablePtrType/* = null*/;
  private DIType /*P*/ ClassTy/* = null*/;
  private final type$ref<DICompositeType /*P*/> ObjTy/* = null*/;
  private DIType /*P*/ SelTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dArrayROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dBufferROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dDepthROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayDepthROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dMSAAROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayMSAAROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dMSAADepthROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayMSAADepthROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage3dROTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dArrayWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dBufferWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dDepthWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayDepthWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dMSAAWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayMSAAWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dMSAADepthWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayMSAADepthWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage3dWOTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dArrayRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage1dBufferRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dDepthRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayDepthRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dMSAARWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayMSAARWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dMSAADepthRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage2dArrayMSAADepthRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLImage3dRWTy/* = null*/;
  private final type$ref<DIType /*P*/> OCLEventDITy/* = null*/;
  private final type$ref<DIType /*P*/> OCLClkEventDITy/* = null*/;
  private final type$ref<DIType /*P*/> OCLQueueDITy/* = null*/;
  private final type$ref<DIType /*P*/> OCLNDRangeDITy/* = null*/;
  private final type$ref<DIType /*P*/> OCLReserveIDDITy/* = null*/;
  
  /// Cache of previously constructed Types.
  private DenseMap</*const*/Object/*void P*/ , TrackingMDRef> TypeCache;
  
  private SmallDenseMap<StringRef, StringRef> DebugPrefixMap;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::ObjCInterfaceCacheEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 81,
   FQN="clang::CodeGen::CGDebugInfo::ObjCInterfaceCacheEntry", NM="_ZN5clang7CodeGen11CGDebugInfo23ObjCInterfaceCacheEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo23ObjCInterfaceCacheEntryE")
  //</editor-fold>
  private static class/*struct*/ ObjCInterfaceCacheEntry implements NativePOD<ObjCInterfaceCacheEntry> {
    public /*const*/ ObjCInterfaceType /*P*/ Type;
    public DIType /*P*/ Decl;
    public DIFile /*P*/ Unit;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::ObjCInterfaceCacheEntry::ObjCInterfaceCacheEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 85,
     FQN="clang::CodeGen::CGDebugInfo::ObjCInterfaceCacheEntry::ObjCInterfaceCacheEntry", NM="_ZN5clang7CodeGen11CGDebugInfo23ObjCInterfaceCacheEntryC1EPKNS_17ObjCInterfaceTypeEPN4llvm6DITypeEPNS6_6DIFileE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo23ObjCInterfaceCacheEntryC1EPKNS_17ObjCInterfaceTypeEPN4llvm6DITypeEPNS6_6DIFileE")
    //</editor-fold>
    public ObjCInterfaceCacheEntry(/*const*/ ObjCInterfaceType /*P*/ Type, DIType /*P*/ Decl, 
        DIFile /*P*/ Unit) {
      // : Type(Type), Decl(Decl), Unit(Unit) 
      //START JInit
      this.Type = Type;
      this.Decl = Decl;
      this.Unit = Unit;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::ObjCInterfaceCacheEntry::ObjCInterfaceCacheEntry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 81,
     FQN="clang::CodeGen::CGDebugInfo::ObjCInterfaceCacheEntry::ObjCInterfaceCacheEntry", NM="_ZN5clang7CodeGen11CGDebugInfo23ObjCInterfaceCacheEntryC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo23ObjCInterfaceCacheEntryC1ERKS2_")
    //</editor-fold>
    public /*inline*/ ObjCInterfaceCacheEntry(final /*const*/ ObjCInterfaceCacheEntry /*&*/ $Prm0) {
      // : Type(.Type), Decl(.Decl), Unit(.Unit) 
      //START JInit
      this.Type = $Prm0.Type;
      this.Decl = $Prm0.Decl;
      this.Unit = $Prm0.Unit;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public ObjCInterfaceCacheEntry() { }

    @Override
    public ObjCInterfaceCacheEntry $assign(ObjCInterfaceCacheEntry $Prm0) {
      this.Type = $Prm0.Type;
      this.Decl = $Prm0.Decl;
      this.Unit = $Prm0.Unit;
      return this;
    }

    @Override
    public ObjCInterfaceCacheEntry clone() {
      return new ObjCInterfaceCacheEntry(this);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", Decl=" + Decl // NOI18N
                + ", Unit=" + Unit; // NOI18N
    }
  };
  
  /// Cache of previously constructed interfaces which may change.
  private SmallVector<ObjCInterfaceCacheEntry> ObjCInterfaceCache;
  
  /// Cache of references to clang modules and precompiled headers.
  private DenseMap</*const*/ Module /*P*/ , TrackingMDRef> ModuleCache;
  
  /// List of interfaces we want to keep even if orphaned.
  private std.vector<Object/*void P*/ > RetainedTypes;
  
  /// Cache of forward declared types to RAUW at the end of
  /// compilation.
  private std.vector<std.pair</*const*/ TagType /*P*/ , TrackingMDRef>> ReplaceMap;
  
  /// Cache of replaceable forward declarations (functions and
  /// variables) to RAUW at the end of compilation.
  private std.vector<std.pair</*const*/ DeclaratorDecl /*P*/ , TrackingMDRef>> FwdDeclReplaceMap;
  
  /// Keep track of our current nested lexical block.
  /*friend*/public/*private*/ std.vector<TypedTrackingMDRef<DIScope>> LexicalBlockStack;
  private DenseMap</*const*/ Decl /*P*/ , TrackingMDRef> RegionMap;
  /// Keep track of LexicalBlockStack counter at the beginning of a
  /// function. This is used to pop unbalanced regions at the end of a
  /// function.
  private std.vectorUInt/*uint*/ FnBeginRegionCount;
  
  /// This is a storage for names that are constructed on demand. For
  /// example, C++ destructors, C++ operators etc..
  private BumpPtrAllocatorImpl DebugInfoNames;
  private StringRef CWDName;
  
  private DenseMap</*const*/char$ptr/*char P*/, TrackingMDRef> DIFileCache;
  private DenseMap</*const*/ FunctionDecl /*P*/ , TrackingMDRef> SPCache;
  /// Cache declarations relevant to DW_TAG_imported_declarations (C++
  /// using declarations) that aren't covered by other more specific caches.
  private DenseMap</*const*/ Decl /*P*/ , TrackingMDRef> DeclCache;
  private DenseMap</*const*/ NamespaceDecl /*P*/ , TrackingMDRef> NameSpaceCache;
  private DenseMap</*const*/ NamespaceAliasDecl /*P*/ , TrackingMDRef> NamespaceAliasCache;
  private DenseMap</*const*/ Decl /*P*/ , TypedTrackingMDRef<DIDerivedType>> StaticDataMemberCache;
  
  /// Helper functions for getOrCreateType.
  /// @{
  /// Currently the checksum of an interface includes the number of
  /// ivars and property accessors.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 460,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11BuiltinTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11BuiltinTypeE")
  //</editor-fold>
  private DIType /*P*/ CreateType(/*const*/ BuiltinType /*P*/ BT) {
    /*TypeKind*//*uint*/int Encoding = 0;
    StringRef BTName/*J*/= new StringRef();
    switch (BT.getKind()) {
     case Overload:
     case BoundMember:
     case PseudoObject:
     case UnknownAny:
     case BuiltinFn:
     case ARCUnbridgedCast:
     case OMPArraySection:
     case Dependent:
      throw new llvm_unreachable("Unexpected builtin type");
     case NullPtr:
      return DBuilder.createNullPtrType();
     case Void:
      return null;
     case ObjCClass:
      if (!(ClassTy != null)) {
        ClassTy = DBuilder.createForwardDecl($ushort2uint(Tag.DW_TAG_structure_type), 
            new StringRef(/*KEEP_STR*/"objc_class"), TheCU, 
            getOrCreateMainFile(), 0);
      }
      return ClassTy;
     case ObjCId:
      {
        // typedef struct objc_class *Class;
        // typedef struct objc_object {
        //  Class isa;
        // } *id;
        if ((ObjTy.$deref() != null)) {
          return ObjTy.$deref();
        }
        if (!(ClassTy != null)) {
          ClassTy = DBuilder.createForwardDecl($ushort2uint(Tag.DW_TAG_structure_type), 
              new StringRef(/*KEEP_STR*/"objc_class"), TheCU, 
              getOrCreateMainFile(), 0);
        }
        
        /*uint*/int Size = $ulong2uint(CGM.getContext().getTypeSize(CGM.getContext().VoidPtrTy.$QualType()));
        
        DIDerivedType /*P*/ ISATy = DBuilder.createPointerType(ClassTy, $uint2ulong(Size));
        
        ObjTy.$set(DBuilder.createStructType(TheCU, new StringRef(/*KEEP_STR*/"objc_object"), getOrCreateMainFile(), 
            0, $int2ulong(0), $int2ulong(0), 0, (DIType /*P*/ )null, new MDTupleTypedArrayWrapper<DINode>(DINode.class)));
        
        DBuilder.replaceArrays(ObjTy, 
            DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(/*AddrOf*//*Deref*/DBuilder.createMemberType(ObjTy.$deref(), new StringRef(/*KEEP_STR*/"isa"), getOrCreateMainFile(), 0, $uint2ulong(Size), $int2ulong(0), $int2ulong(0), 0, ISATy), true)));
        return ObjTy.$deref();
      }
     case ObjCSel:
      {
        if (!(SelTy != null)) {
          SelTy = DBuilder.createForwardDecl($ushort2uint(Tag.DW_TAG_structure_type), 
              new StringRef(/*KEEP_STR*/"objc_selector"), TheCU, 
              getOrCreateMainFile(), 0);
        }
        return SelTy;
      }
     case OCLImage1dRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_ro_t"), OCLImage1dROTy);
     case OCLImage1dArrayRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_array_ro_t"), OCLImage1dArrayROTy);
     case OCLImage1dBufferRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_buffer_ro_t"), OCLImage1dBufferROTy);
     case OCLImage2dRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_ro_t"), OCLImage2dROTy);
     case OCLImage2dArrayRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_ro_t"), OCLImage2dArrayROTy);
     case OCLImage2dDepthRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_depth_ro_t"), OCLImage2dDepthROTy);
     case OCLImage2dArrayDepthRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_depth_ro_t"), OCLImage2dArrayDepthROTy);
     case OCLImage2dMSAARO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_msaa_ro_t"), OCLImage2dMSAAROTy);
     case OCLImage2dArrayMSAARO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_msaa_ro_t"), OCLImage2dArrayMSAAROTy);
     case OCLImage2dMSAADepthRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_msaa_depth_ro_t"), OCLImage2dMSAADepthROTy);
     case OCLImage2dArrayMSAADepthRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_msaa_depth_ro_t"), OCLImage2dArrayMSAADepthROTy);
     case OCLImage3dRO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image3d_ro_t"), OCLImage3dROTy);
     case OCLImage1dWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_wo_t"), OCLImage1dWOTy);
     case OCLImage1dArrayWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_array_wo_t"), OCLImage1dArrayWOTy);
     case OCLImage1dBufferWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_buffer_wo_t"), OCLImage1dBufferWOTy);
     case OCLImage2dWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_wo_t"), OCLImage2dWOTy);
     case OCLImage2dArrayWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_wo_t"), OCLImage2dArrayWOTy);
     case OCLImage2dDepthWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_depth_wo_t"), OCLImage2dDepthWOTy);
     case OCLImage2dArrayDepthWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_depth_wo_t"), OCLImage2dArrayDepthWOTy);
     case OCLImage2dMSAAWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_msaa_wo_t"), OCLImage2dMSAAWOTy);
     case OCLImage2dArrayMSAAWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_msaa_wo_t"), OCLImage2dArrayMSAAWOTy);
     case OCLImage2dMSAADepthWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_msaa_depth_wo_t"), OCLImage2dMSAADepthWOTy);
     case OCLImage2dArrayMSAADepthWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_msaa_depth_wo_t"), OCLImage2dArrayMSAADepthWOTy);
     case OCLImage3dWO:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image3d_wo_t"), OCLImage3dWOTy);
     case OCLImage1dRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_rw_t"), OCLImage1dRWTy);
     case OCLImage1dArrayRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_array_rw_t"), OCLImage1dArrayRWTy);
     case OCLImage1dBufferRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image1d_buffer_rw_t"), OCLImage1dBufferRWTy);
     case OCLImage2dRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_rw_t"), OCLImage2dRWTy);
     case OCLImage2dArrayRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_rw_t"), OCLImage2dArrayRWTy);
     case OCLImage2dDepthRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_depth_rw_t"), OCLImage2dDepthRWTy);
     case OCLImage2dArrayDepthRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_depth_rw_t"), OCLImage2dArrayDepthRWTy);
     case OCLImage2dMSAARW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_msaa_rw_t"), OCLImage2dMSAARWTy);
     case OCLImage2dArrayMSAARW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_msaa_rw_t"), OCLImage2dArrayMSAARWTy);
     case OCLImage2dMSAADepthRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_msaa_depth_rw_t"), OCLImage2dMSAADepthRWTy);
     case OCLImage2dArrayMSAADepthRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image2d_array_msaa_depth_rw_t"), OCLImage2dArrayMSAADepthRWTy);
     case OCLImage3dRW:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_image3d_rw_t"), OCLImage3dRWTy);
     case OCLSampler:
      return DBuilder.createBasicType(new StringRef(/*KEEP_STR*/"opencl_sampler_t"), CGM.getContext().getTypeSize(BT), 
          $uint2ulong(CGM.getContext().getTypeAlign(BT)), TypeKind.DW_ATE_unsigned);
     case OCLEvent:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_event_t"), OCLEventDITy);
     case OCLClkEvent:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_clk_event_t"), OCLClkEventDITy);
     case OCLQueue:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_queue_t"), OCLQueueDITy);
     case OCLNDRange:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_ndrange_t"), OCLNDRangeDITy);
     case OCLReserveID:
      return getOrCreateStructPtrType(new StringRef(/*KEEP_STR*/"opencl_reserve_id_t"), OCLReserveIDDITy);
     case UChar:
     case Char_U:
      Encoding = TypeKind.DW_ATE_unsigned_char;
      break;
     case Char_S:
     case SChar:
      Encoding = TypeKind.DW_ATE_signed_char;
      break;
     case Char16:
     case Char32:
      Encoding = TypeKind.DW_ATE_UTF;
      break;
     case UShort:
     case UInt:
     case UInt128:
     case ULong:
     case WChar_U:
     case ULongLong:
      Encoding = TypeKind.DW_ATE_unsigned;
      break;
     case Short:
     case Int:
     case Int128:
     case Long:
     case WChar_S:
     case LongLong:
      Encoding = TypeKind.DW_ATE_signed;
      break;
     case Bool:
      Encoding = TypeKind.DW_ATE_boolean;
      break;
     case Half:
     case Float:
     case LongDouble:
     case Float128:
     case Double:
      // FIXME: For targets where long double and __float128 have the same size,
      // they are currently indistinguishable in the debugger without some
      // special treatment. However, there is currently no consensus on encoding
      // and this should be updated once a DWARF encoding exists for distinct
      // floating point types of the same size.
      Encoding = TypeKind.DW_ATE_float;
      break;
    }
    switch (BT.getKind()) {
     case Long:
      BTName.$assignMove(/*STRINGREF_STR*/$long_int);
      break;
     case LongLong:
      BTName.$assignMove(/*STRINGREF_STR*/$long_long_int);
      break;
     case ULong:
      BTName.$assignMove(/*STRINGREF_STR*/$long_unsigned_int);
      break;
     case ULongLong:
      BTName.$assignMove(/*STRINGREF_STR*/$long_long_unsigned_int);
      break;
     default:
      BTName.$assignMove(BT.getName(new PrintingPolicy(CGM.getLangOpts())));
      break;
    }
    // Bit size, align and offset of the type.
    long/*uint64_t*/ Size = CGM.getContext().getTypeSize(BT);
    long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(BT));
    return DBuilder.createBasicType(new StringRef(BTName), Size, Align, Encoding);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 603,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11ComplexTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11ComplexTypeE")
  //</editor-fold>
  private DIType /*P*/ CreateType(/*const*/ ComplexType /*P*/ Ty) {
    // Bit size, align and offset of the type.
    /*TypeKind*//*uint*/int Encoding = TypeKind.DW_ATE_complex_float;
    if (Ty.isComplexIntegerType()) {
      Encoding = TypeKind.DW_ATE_lo_user;
    }
    
    long/*uint64_t*/ Size = CGM.getContext().getTypeSize(Ty);
    long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
    return DBuilder.createBasicType(new StringRef(/*KEEP_STR*/"complex"), Size, Align, Encoding);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateQualifiedType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 614,
   FQN="clang::CodeGen::CGDebugInfo::CreateQualifiedType", NM="_ZN5clang7CodeGen11CGDebugInfo19CreateQualifiedTypeENS_8QualTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo19CreateQualifiedTypeENS_8QualTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateQualifiedType(QualType Ty, 
                     DIFile /*P*/ Unit) {
    QualifierCollector Qc/*J*/= new QualifierCollector();
    /*const*/ org.clang.ast.Type /*P*/ T = Qc.strip(new QualType(Ty));
    
    // Ignore these qualifiers for now.
    Qc.removeObjCGCAttr();
    Qc.removeAddressSpace();
    Qc.removeObjCLifetime();
    
    // We will create one Derived type for one qualifier and recurse to handle any
    // additional ones.
    /*Tag*//*uint16_t*/char Tag_;
    if (Qc.hasConst()) {
      Tag_ = Tag.DW_TAG_const_type;
      Qc.removeConst();
    } else if (Qc.hasVolatile()) {
      Tag_ = Tag.DW_TAG_volatile_type;
      Qc.removeVolatile();
    } else if (Qc.hasRestrict()) {
      Tag_ = Tag.DW_TAG_restrict_type;
      Qc.removeRestrict();
    } else {
      assert (Qc.empty()) : "Unknown type qualifier for debug info";
      return getOrCreateType(new QualType(T, 0), Unit);
    }
    
    DIType /*P*/ FromTy = getOrCreateType(Qc.apply(CGM.getContext(), T), Unit);
    
    // No need to fill in the Name, Line, Size, Alignment, Offset in case of
    // CVR derived types.
    return DBuilder.createQualifiedType($ushort2uint(Tag_), FromTy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 855,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11TypedefTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11TypedefTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_TypedefType$C$P_DIFile$P(/*const*/ TypedefType /*P*/ Ty, 
                                     DIFile /*P*/ Unit) {
    // We don't set size information, but do specify where the typedef was
    // declared.
    SourceLocation Loc = Ty.getDecl().getLocation();
    
    // Typedefs are derived from some other type.
    return DBuilder.createTypedef(getOrCreateType(Ty.getDecl().getUnderlyingType(), Unit), 
        Ty.getDecl().getName(), getOrCreateFile(new SourceLocation(Loc)), getLineNumber(new SourceLocation(Loc)), 
        getDeclContextDescriptor(Ty.getDecl()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 832,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_26TemplateSpecializationTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_26TemplateSpecializationTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_TemplateSpecializationType$C$P_DIFile$P(/*const*/ TemplateSpecializationType /*P*/ Ty, 
                                                    DIFile /*P*/ Unit) {
    raw_svector_ostream OS = null;
    try {
      assert (Ty.isTypeAlias());
      DIType /*P*/ Src = getOrCreateType(Ty.getAliasedType(), Unit);
      
      SmallString/*<128>*/ NS/*J*/= new SmallString/*<128>*/(128);
      OS/*J*/= new raw_svector_ostream(NS);
      Ty.getTemplateName().print(OS, CGM.getContext().getPrintingPolicy(), 
          /*qualified*/ false);
      
      TemplateSpecializationType.PrintTemplateArgumentList1(OS, Ty.template_arguments(), 
          CGM.getContext().getPrintingPolicy());
      
      TypeAliasDecl /*P*/ AliasDecl = cast_TypeAliasTemplateDecl(Ty.getTemplateName().getAsTemplateDecl()).getTemplatedDecl();
      
      SourceLocation Loc = AliasDecl.getLocation();
      return DBuilder.createTypedef(Src, OS.str(), getOrCreateFile(new SourceLocation(Loc)), 
          getLineNumber(new SourceLocation(Loc)), 
          getDeclContextDescriptor(AliasDecl));
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 648,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_21ObjCObjectPointerTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_21ObjCObjectPointerTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_ObjCObjectPointerType$C$P_DIFile$P(/*const*/ ObjCObjectPointerType /*P*/ Ty, 
                                               DIFile /*P*/ Unit) {
    
    // The frontend treats 'id' as a typedef to an ObjCObjectType,
    // whereas 'id<protocol>' is treated as an ObjCPointerType. For the
    // debug info, we want to emit 'id' in both cases.
    if (Ty.isObjCQualifiedIdType()) {
      return getOrCreateType(CGM.getContext().getObjCIdType(), Unit);
    }
    
    return CreatePointerLikeType(Tag.DW_TAG_pointer_type, Ty, 
        Ty.getPointeeType(), Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 661,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11PointerTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_11PointerTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_PointerType$C$P_DIFile$P(/*const*/ org.clang.ast.PointerType /*P*/ Ty, 
                                     DIFile /*P*/ Unit) {
    return CreatePointerLikeType(Tag.DW_TAG_pointer_type, Ty, 
        Ty.getPointeeType(), Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 774,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_16BlockPointerTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_16BlockPointerTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_BlockPointerType$C$P_DIFile$P(/*const*/ BlockPointerType /*P*/ Ty, 
                                          DIFile /*P*/ Unit) {
    SmallVector<Metadata /*P*/ > EltTys/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
    QualType FType/*J*/= new QualType();
    long/*uint64_t*/ FieldSize;
    ulong$ptr FieldOffset = create_ulong$ptr();
    /*uint*/int FieldAlign;
    MDTupleTypedArrayWrapper<DINode> Elements/*J*/= new MDTupleTypedArrayWrapper<DINode>(DINode.class);
    
    FieldOffset.$set($int2ulong(0));
    FType.$assignMove(CGM.getContext().UnsignedLongTy.$QualType());
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"reserved"), $AddrOf(FieldOffset)));
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"Size"), $AddrOf(FieldOffset)));
    
    Elements.$assignMove(DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(EltTys, true)));
    EltTys.clear();
    
    /*uint*/int Flags = DINode.DIFlags.FlagAppleBlock;
    /*uint*/int LineNo = 0;
    
    DICompositeType /*P*/ EltTy = DBuilder.createStructType(Unit, new StringRef(/*KEEP_STR*/"__block_descriptor"), (DIFile /*P*/ )null, LineNo, 
        FieldOffset.$star(), $int2ulong(0), Flags, (DIType /*P*/ )null, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, Elements));
    
    // Bit size, align and offset of the type.
    long/*uint64_t*/ Size = CGM.getContext().getTypeSize(Ty);
    
    DIDerivedType /*P*/ DescTy = DBuilder.createPointerType(EltTy, Size);
    
    FieldOffset.$set($int2ulong(0));
    FType.$assignMove(CGM.getContext().getPointerType(/*NO_COPY*/CGM.getContext().VoidTy).$QualType());
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__isa"), $AddrOf(FieldOffset)));
    FType.$assignMove(CGM.getContext().IntTy.$QualType());
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__flags"), $AddrOf(FieldOffset)));
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__reserved"), $AddrOf(FieldOffset)));
    FType.$assignMove(CGM.getContext().getPointerType(Ty.getPointeeType()));
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__FuncPtr"), $AddrOf(FieldOffset)));
    
    FType.$assignMove(CGM.getContext().getPointerType(/*NO_COPY*/CGM.getContext().VoidTy).$QualType());
    FieldSize = CGM.getContext().getTypeSize(Ty);
    FieldAlign = CGM.getContext().getTypeAlign(Ty);
    EltTys.push_back(DBuilder.createMemberType(Unit, new StringRef(/*KEEP_STR*/"__descriptor"), (DIFile /*P*/ )null, LineNo, 
            FieldSize, $uint2ulong(FieldAlign), FieldOffset.$star(), 
            0, DescTy));
    
    FieldOffset.$inc((int)FieldSize);
    Elements.$assignMove(DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(EltTys, true)));
    
    // The __block_literal_generic structs are marked with a special
    // DW_AT_APPLE_BLOCK attribute and are an implementation detail only
    // the debugger needs to know about. To allow type uniquing, emit
    // them without a name or a location.
    EltTy
       = DBuilder.createStructType(Unit, new StringRef(/*KEEP_STR*/$EMPTY), (DIFile /*P*/ )null, LineNo, 
        FieldOffset.$star(), $int2ulong(0), Flags, (DIType /*P*/ )null, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, Elements));
    
    return DBuilder.createPointerType(EltTy, Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 901,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_12FunctionTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_12FunctionTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_FunctionType$C$P_DIFile$P(/*const*/ org.clang.ast.FunctionType /*P*/ Ty, 
                                      DIFile /*P*/ Unit) {
    SmallVector<Metadata /*P*/ > EltTys/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    
    // Add the result type at least.
    EltTys.push_back(getOrCreateType(Ty.getReturnType(), Unit));
    
    // Set up remainder of arguments if there is a prototype.
    // otherwise emit it as a variadic function.
    if (isa_FunctionNoProtoType(Ty)) {
      EltTys.push_back(DBuilder.createUnspecifiedParameter());
    } else {
      /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(Ty);
      if ((FPT != null)) {
        for (final /*const*/ QualType /*&*/ ParamType : FPT.param_types())  {
          EltTys.push_back(getOrCreateType(new QualType(ParamType), Unit));
        }
        if (FPT.isVariadic()) {
          EltTys.push_back(DBuilder.createUnspecifiedParameter());
        }
      }
    }
    
    DITypeRefArray EltTypeArray = DBuilder.getOrCreateTypeArray(new ArrayRef<Metadata /*P*/ >(EltTys, true));
    return DBuilder.createSubroutineType(new DITypeRefArray(EltTypeArray), 0, 
        CGDebugInfoStatics.getDwarfCC(Ty.getCallConv()));
  }

  /// Get structure or union type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1686,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_10RecordTypeE")
  //</editor-fold>
  private DIType /*P*/ CreateType(/*const*/ RecordType /*P*/ Ty) {
    RecordDecl /*P*/ RD = Ty.getDecl();
    DIType /*P*/ T = cast_or_null_DIType(getTypeOrNull(new QualType(Ty, 0)));
    if ((T != null) || CGDebugInfoStatics.shouldOmitDefinition(DebugKind, DebugTypeExtRefs, RD, 
        CGM.getLangOpts())) {
      if (!(T != null)) {
        T = getOrCreateRecordFwdDecl(Ty, getDeclContextDescriptor(RD));
      }
      return T;
    }
    
    return CreateTypeDefinition(Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateTypeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1699,
   FQN="clang::CodeGen::CGDebugInfo::CreateTypeDefinition", NM="_ZN5clang7CodeGen11CGDebugInfo20CreateTypeDefinitionEPKNS_10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20CreateTypeDefinitionEPKNS_10RecordTypeE")
  //</editor-fold>
  private DIType /*P*/ CreateTypeDefinition(/*const*/ RecordType /*P*/ Ty) {
    RecordDecl /*P*/ RD = Ty.getDecl();
    
    // Get overall information about the record type for the debug info.
    DIFile /*P*/ DefUnit = getOrCreateFile(RD.getLocation());
    
    // Records and classes and unions can all be recursive.  To handle them, we
    // first generate a debug descriptor for the struct as a forward declaration.
    // Then (if it is a definition) we go through and get debug info for all of
    // its members.  Finally, we create a descriptor for the complete type (which
    // may refer to the forward decl if the struct is recursive) and replace all
    // uses of the forward declaration with the final definition.
    type$ref<DICompositeType /*P*/ > FwdDecl = create_type$ref(getOrCreateLimitedType(Ty, DefUnit));
    
    /*const*/ RecordDecl /*P*/ D = RD.getDefinition();
    if (!(D != null) || !D.isCompleteDefinition()) {
      return FwdDecl.$deref();
    }
    {
      
      /*const*/ CXXRecordDecl /*P*/ CXXDecl = dyn_cast_CXXRecordDecl(RD);
      if ((CXXDecl != null)) {
        CollectContainingType(CXXDecl, FwdDecl);
      }
    }
    
    // Push the struct on region stack.
    LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>($AddrOf($Deref(FwdDecl.$deref()))));
    RegionMap.$at_T1$RR(Ty.getDecl()).reset(FwdDecl.$deref());
    
    // Convert all the elements.
    SmallVector<Metadata /*P*/ > EltTys/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    // what about nested types?
    
    // Note: The split of CXXDecl information here is intentional, the
    // gdb tests will depend on a certain ordering at printout. The debug
    // information offsets are still correct if we merge them all together
    // though.
    /*const*/ CXXRecordDecl /*P*/ CXXDecl = dyn_cast_CXXRecordDecl(RD);
    if ((CXXDecl != null)) {
      CollectCXXBases(CXXDecl, DefUnit, EltTys, FwdDecl.$deref());
      CollectVTableInfo(CXXDecl, DefUnit, EltTys);
    }
    
    // Collect data fields (including static variables and any initializers).
    CollectRecordFields(RD, DefUnit, EltTys, FwdDecl.$deref());
    if ((CXXDecl != null)) {
      CollectCXXMemberFunctions(CXXDecl, DefUnit, EltTys, FwdDecl.$deref());
    }
    
    LexicalBlockStack.pop_back();
    RegionMap.erase(Ty.getDecl());
    
    MDTupleTypedArrayWrapper<DINode> Elements = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(EltTys, true));
    DBuilder.replaceArrays(FwdDecl, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, Elements));
    if (FwdDecl.$deref().isTemporary()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(FwdDecl.$set(MDNode.replaceWithPermanent$BaseOfMDNode($c$.track(new std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/>(FwdDecl.$deref())))));
      } finally {
        $c$.$destroy();
      }
    }
    
    RegionMap.$at_T1$RR(Ty.getDecl()).reset(FwdDecl.$deref());
    return FwdDecl.$deref();
  }

  
  // TODO: Currently used for context chains when limiting debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateLimitedType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2497,
   FQN="clang::CodeGen::CGDebugInfo::CreateLimitedType", NM="_ZN5clang7CodeGen11CGDebugInfo17CreateLimitedTypeEPKNS_10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17CreateLimitedTypeEPKNS_10RecordTypeE")
  //</editor-fold>
  private DICompositeType /*P*/ CreateLimitedType(/*const*/ RecordType /*P*/ Ty) {
    RecordDecl /*P*/ RD = Ty.getDecl();
    
    // Get overall information about the record type for the debug info.
    DIFile /*P*/ DefUnit = getOrCreateFile(RD.getLocation());
    /*uint*/int Line = getLineNumber(RD.getLocation());
    StringRef RDName = getClassName(RD);
    
    DIScope /*P*/ RDContext = getDeclContextDescriptor(RD);
    
    // If we ended up creating the type during the context chain construction,
    // just return that.
    DICompositeType /*P*/ T = cast_or_null_DICompositeType(getTypeOrNull(CGM.getContext().getRecordType(RD)));
    if ((T != null) && (!T.isForwardDecl() || !(RD.getDefinition() != null))) {
      return T;
    }
    
    // If this is just a forward or incomplete declaration, construct an
    // appropriately marked node and just return it.
    /*const*/ RecordDecl /*P*/ D = RD.getDefinition();
    if (!(D != null) || !D.isCompleteDefinition()) {
      return getOrCreateRecordFwdDecl(Ty, RDContext);
    }
    
    long/*uint64_t*/ Size = CGM.getContext().getTypeSize(Ty);
    long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
    
    SmallString/*<256>*/ FullName = CGDebugInfoStatics.getUniqueTagTypeName(Ty, CGM, TheCU);
    
    type$ref<DICompositeType /*P*/ > RealDecl = create_type$ref(DBuilder.createReplaceableCompositeType($ushort2uint(CGDebugInfoStatics.getTagForRecord(RD)), new StringRef(RDName), RDContext, DefUnit, Line, 0, Size, Align, 0, 
        FullName.$StringRef()));
    
    // Elements of composite types usually have back to the type, creating
    // uniquing cycles.  Distinct nodes are more efficient.
    switch (RealDecl.$deref().getTag()) {
     default:
      throw new llvm_unreachable("invalid composite type tag");
     case Tag.DW_TAG_array_type:
     case Tag.DW_TAG_enumeration_type:
      // Array elements and most enumeration elements don't have back references,
      // so they don't tend to be involved in uniquing cycles and there is some
      // chance of merging them when linking together two modules.  Only make
      // them distinct if they are ODR-uniqued.
      if (FullName.empty()) {
        break;
      }
     case Tag.DW_TAG_structure_type:
     case Tag.DW_TAG_union_type:
     case Tag.DW_TAG_class_type:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Immediatley resolve to a distinct node.
          $c$.clean(RealDecl.$set(MDNode.replaceWithDistinct$BaseOfMDNode($c$.track(new std.unique_ptr_with_deleter<DICompositeType /*, TempMDNodeDeleter*/>(RealDecl.$deref())))));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    RegionMap.$at_T1$RR(Ty.getDecl()).reset(RealDecl.$deref());
    TypeCache.$at_T1$RR(new QualType(Ty, 0).getAsOpaquePtr()).reset(RealDecl.$deref());
    {
      
      /*const*/ ClassTemplateSpecializationDecl /*P*/ TSpecial = dyn_cast_ClassTemplateSpecializationDecl(RD);
      if ((TSpecial != null)) {
        DBuilder.replaceArrays(RealDecl, new MDTupleTypedArrayWrapper<DINode>(DINode.class), 
            CollectCXXTemplateParams(TSpecial, DefUnit));
      }
    }
    return RealDecl.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectContainingType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2562,
   FQN="clang::CodeGen::CGDebugInfo::CollectContainingType", NM="_ZN5clang7CodeGen11CGDebugInfo21CollectContainingTypeEPKNS_13CXXRecordDeclEPN4llvm15DICompositeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21CollectContainingTypeEPKNS_13CXXRecordDeclEPN4llvm15DICompositeTypeE")
  //</editor-fold>
  private void CollectContainingType(/*const*/ CXXRecordDecl /*P*/ RD, 
                       type$ref<DICompositeType /*P*/> RealDecl) {
    // A class's primary base or the class itself contains the vtable.
    DICompositeType /*P*/ ContainingType = null;
    final /*const*/ ASTRecordLayout /*&*/ RL = CGM.getContext().getASTRecordLayout(RD);
    {
      /*const*/ CXXRecordDecl /*P*/ PBase = RL.getPrimaryBase();
      if ((PBase != null)) {
        // Seek non-virtual primary base root.
        while (true) {
          final /*const*/ ASTRecordLayout /*&*/ BRL = CGM.getContext().getASTRecordLayout(PBase);
          /*const*/ CXXRecordDecl /*P*/ PBT = BRL.getPrimaryBase();
          if ((PBT != null) && !BRL.isPrimaryBaseVirtual()) {
            PBase = PBT;
          } else {
            break;
          }
        }
        ContainingType = cast_DICompositeType(getOrCreateType(new QualType(PBase.getTypeForDecl(), 0), 
    getOrCreateFile(RD.getLocation())));
      } else if (RD.isDynamicClass()) {
        ContainingType = RealDecl.$deref();
      }
    }
    
    DBuilder.replaceVTableHolder(RealDecl, ContainingType);
  }

  /// Get Objective-C interface type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1787,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_17ObjCInterfaceTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_17ObjCInterfaceTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_ObjCInterfaceType$C$P_DIFile$P(/*const*/ ObjCInterfaceType /*P*/ Ty, 
                                           DIFile /*P*/ Unit) {
    ObjCInterfaceDecl /*P*/ ID = Ty.getDecl();
    if (!(ID != null)) {
      return null;
    }
    
    // Return a forward declaration if this type was imported from a clang module,
    // and this is not the compile unit with the implementation of the type (which
    // may contain hidden ivars).
    if (DebugTypeExtRefs && ID.isFromASTFile() && (ID.getDefinition() != null)
       && !(ID.getImplementation() != null)) {
      return DBuilder.createForwardDecl($ushort2uint(Tag.DW_TAG_structure_type), 
          ID.getName(), 
          getDeclContextDescriptor(ID), Unit, 0);
    }
    
    // Get overall information about the record type for the debug info.
    DIFile /*P*/ DefUnit = getOrCreateFile(ID.getLocation());
    /*uint*/int Line = getLineNumber(ID.getLocation());
    /*SourceLanguage*//*uint*/int RuntimeLang = ((/*static_cast*//*SourceLanguage*//*uint*/int)(TheCU.getSourceLanguage()));
    
    // If this is just a forward declaration return a special forward-declaration
    // debug type since we won't be able to lay out the entire type.
    ObjCInterfaceDecl /*P*/ Def = ID.getDefinition();
    if (!(Def != null) || !(Def.getImplementation() != null)) {
      DIScope /*P*/ Mod = getParentModuleOrNull(ID);
      DIType /*P*/ FwdDecl = DBuilder.createReplaceableCompositeType($ushort2uint(Tag.DW_TAG_structure_type), ID.getName(), (Mod != null) ? Mod : TheCU, 
          DefUnit, Line, RuntimeLang);
      ObjCInterfaceCache.push_back(new ObjCInterfaceCacheEntry(Ty, FwdDecl, Unit));
      return FwdDecl;
    }
    
    return CreateTypeDefinition(Ty, Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateTypeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1881,
   FQN="clang::CodeGen::CGDebugInfo::CreateTypeDefinition", NM="_ZN5clang7CodeGen11CGDebugInfo20CreateTypeDefinitionEPKNS_17ObjCInterfaceTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20CreateTypeDefinitionEPKNS_17ObjCInterfaceTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateTypeDefinition(/*const*/ ObjCInterfaceType /*P*/ Ty, 
                      DIFile /*P*/ Unit) {
    ObjCInterfaceDecl /*P*/ ID = Ty.getDecl();
    DIFile /*P*/ DefUnit = getOrCreateFile(ID.getLocation());
    /*uint*/int Line = getLineNumber(ID.getLocation());
    /*uint*/int RuntimeLang = TheCU.getSourceLanguage();
    
    // Bit size, align and offset of the type.
    long/*uint64_t*/ Size = CGM.getContext().getTypeSize(Ty);
    long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
    
    /*uint*/int Flags = 0;
    if ((ID.getImplementation() != null)) {
      Flags |= DINode.DIFlags.FlagObjcClassComplete;
    }
    
    DIScope /*P*/ Mod = getParentModuleOrNull(ID);
    type$ref<DICompositeType /*P*/ > RealDecl = create_type$ref(DBuilder.createStructType((Mod != null) ? Mod : Unit, ID.getName(), DefUnit, Line, Size, Align, Flags, 
        (DIType /*P*/ )null, new MDTupleTypedArrayWrapper<DINode>(DINode.class), RuntimeLang));
    
    QualType QTy/*J*/= new QualType(Ty, 0);
    TypeCache.$at_T1$RR(QTy.getAsOpaquePtr()).reset(RealDecl.$deref());
    
    // Push the struct on region stack.
    LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>(RealDecl.$deref()));
    RegionMap.$at_T1$RR(Ty.getDecl()).reset(RealDecl.$deref());
    
    // Convert all the elements.
    SmallVector<Metadata /*P*/ > EltTys/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    
    ObjCInterfaceDecl /*P*/ SClass = ID.getSuperClass();
    if ((SClass != null)) {
      DIType /*P*/ SClassTy = getOrCreateType(CGM.getContext().getObjCInterfaceType(SClass), Unit);
      if (!(SClassTy != null)) {
        return null;
      }
      
      DIType /*P*/ InhTag = DBuilder.createInheritance(RealDecl.$deref(), SClassTy, $int2ulong(0), 0);
      EltTys.push_back(InhTag);
    }
    
    // Create entries for all of the properties.
    ObjCPropertyDecl2Void AddProperty = /*[&, this, &EltTys]*/ (/*const*/ ObjCPropertyDecl /*P*/ PD) -> {
          SourceLocation Loc = PD.getLocation();
          DIFile /*P*/ PUnit = getOrCreateFile(new SourceLocation(Loc));
          /*uint*/int PLine = getLineNumber(new SourceLocation(Loc));
          ObjCMethodDecl /*P*/ Getter = PD.getGetterMethodDecl();
          ObjCMethodDecl /*P*/ Setter = PD.getSetterMethodDecl();
          MDNode /*P*/ PropertyNode = DBuilder.createObjCProperty(PD.getName(), PUnit, PLine, 
              CGDebugInfoStatics.hasDefaultGetterName(PD, Getter) ? new StringRef(/*KEEP_STR*/$EMPTY) : getSelectorName(PD.getGetterName()), 
              CGDebugInfoStatics.hasDefaultSetterName(PD, Setter) ? new StringRef(/*KEEP_STR*/$EMPTY) : getSelectorName(PD.getSetterName()), 
              PD.getPropertyAttributes(), getOrCreateType(PD.getType(), PUnit));
          EltTys.push_back(PropertyNode);
        };
    {
      SmallPtrSet</*const*/ IdentifierInfo /*P*/ > PropertySet/*J*/= new SmallPtrSet</*const*/ IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
      for (/*const*/ ObjCCategoryDecl /*P*/ ClassExt : ID.known_extensions())  {
        for (ObjCPropertyDecl /*P*/ PD : ClassExt.properties()) {
          PropertySet.insert(PD.getIdentifier());
          AddProperty.$call(PD);
        }
      }
      for (/*const*/ ObjCPropertyDecl /*P*/ PD : ID.properties()) {
        // Don't emit duplicate metadata for properties that were already in a
        // class extension.
        if (!PropertySet.insert(PD.getIdentifier()).second) {
          continue;
        }
        AddProperty.$call(PD);
      }
    }
    
    final /*const*/ ASTRecordLayout /*&*/ RL = CGM.getContext().getASTObjCInterfaceLayout(ID);
    /*uint*/int FieldNo = 0;
    for (ObjCIvarDecl /*P*/ Field = ID.all_declared_ivar_begin(); (Field != null);
         Field = Field.getNextIvar() , ++FieldNo) {
      DIType /*P*/ FieldTy = getOrCreateType(Field.getType(), Unit);
      if (!(FieldTy != null)) {
        return null;
      }
      
      StringRef FieldName = Field.getName();
      
      // Ignore unnamed fields.
      if (FieldName.empty()) {
        continue;
      }
      
      // Get the location for the field.
      DIFile /*P*/ FieldDefUnit = getOrCreateFile(Field.getLocation());
      /*uint*/int FieldLine = getLineNumber(Field.getLocation());
      QualType FType = Field.getType();
      long/*uint64_t*/ FieldSize = $int2ulong(0);
      /*uint*/int FieldAlign = 0;
      if (!FType.$arrow().isIncompleteArrayType()) {
        
        // Bit size, align and offset of the type.
        FieldSize = Field.isBitField() ? $uint2ullong(Field.getBitWidthValue(CGM.getContext())) : CGM.getContext().getTypeSize(new QualType(FType));
        FieldAlign = CGM.getContext().getTypeAlign(new QualType(FType));
      }
      
      long/*uint64_t*/ FieldOffset;
      if (CGM.getLangOpts().ObjCRuntime.isNonFragile()) {
        // We don't know the runtime offset of an ivar if we're using the
        // non-fragile ABI.  For bitfields, use the bit offset into the first
        // byte of storage of the bitfield.  For other fields, use zero.
        if (Field.isBitField()) {
          FieldOffset
             = $uint2ulong(CGM.getObjCRuntime().ComputeBitfieldBitOffset(CGM, ID, Field));
          FieldOffset = $rem_ulong(FieldOffset, CGM.getContext().getCharWidth());
        } else {
          FieldOffset = $int2ulong(0);
        }
      } else {
        FieldOffset = RL.getFieldOffset(FieldNo);
      }
      
      /*uint*/int Flags$1 = 0;
      if (Field.getAccessControl() == ObjCIvarDecl.AccessControl.Protected) {
        Flags$1 = DINode.DIFlags.FlagProtected;
      } else if (Field.getAccessControl() == ObjCIvarDecl.AccessControl.Private) {
        Flags$1 = DINode.DIFlags.FlagPrivate;
      } else if (Field.getAccessControl() == ObjCIvarDecl.AccessControl.Public) {
        Flags$1 = DINode.DIFlags.FlagPublic;
      }
      
      MDNode /*P*/ PropertyNode = null;
      {
        ObjCImplementationDecl /*P*/ ImpD = ID.getImplementation();
        if ((ImpD != null)) {
          {
            ObjCPropertyImplDecl /*P*/ PImpD = ImpD.FindPropertyImplIvarDecl(Field.getIdentifier());
            if ((PImpD != null)) {
              {
                ObjCPropertyDecl /*P*/ PD = PImpD.getPropertyDecl();
                if ((PD != null)) {
                  SourceLocation Loc = PD.getLocation();
                  DIFile /*P*/ PUnit = getOrCreateFile(new SourceLocation(Loc));
                  /*uint*/int PLine = getLineNumber(new SourceLocation(Loc));
                  ObjCMethodDecl /*P*/ Getter = PD.getGetterMethodDecl();
                  ObjCMethodDecl /*P*/ Setter = PD.getSetterMethodDecl();
                  PropertyNode = DBuilder.createObjCProperty(PD.getName(), PUnit, PLine, 
                      CGDebugInfoStatics.hasDefaultGetterName(PD, Getter) ? new StringRef(/*KEEP_STR*/$EMPTY) : getSelectorName(PD.getGetterName()), 
                      CGDebugInfoStatics.hasDefaultSetterName(PD, Setter) ? new StringRef(/*KEEP_STR*/$EMPTY) : getSelectorName(PD.getSetterName()), 
                      PD.getPropertyAttributes(), 
                      getOrCreateType(PD.getType(), PUnit));
                }
              }
            }
          }
        }
      }
      FieldTy = DBuilder.createObjCIVar(new StringRef(FieldName), FieldDefUnit, FieldLine, 
          FieldSize, $uint2ulong(FieldAlign), FieldOffset, Flags$1, 
          FieldTy, PropertyNode);
      EltTys.push_back(FieldTy);
    }
    
    MDTupleTypedArrayWrapper<DINode> Elements = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(EltTys, true));
    DBuilder.replaceArrays(RealDecl, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, Elements));
    
    LexicalBlockStack.pop_back();
    return RealDecl.$deref();
  }

  /// Get Objective-C object type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1757,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_14ObjCObjectTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_14ObjCObjectTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_ObjCObjectType$C$P_DIFile$P(/*const*/ ObjCObjectType /*P*/ Ty, 
                                        DIFile /*P*/ Unit) {
    // Ignore protocols.
    return getOrCreateType(Ty.getBaseType(), Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2042,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_10VectorTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_10VectorTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_VectorType$C$P_DIFile$P(/*const*/ org.clang.ast.VectorType /*P*/ Ty, 
                                    DIFile /*P*/ Unit) {
    DIType /*P*/ ElementTy = getOrCreateType(Ty.getElementType(), Unit);
    long/*int64_t*/ Count = $uint2long(Ty.getNumElements());
    if (Count == 0) {
      // If number of elements are not known then this is an unbounded array.
      // Use Count == -1 to express such arrays.
      Count = -1;
    }
    
    Metadata /*P*/ Subscript = DBuilder.getOrCreateSubrange(0, Count);
    MDTupleTypedArrayWrapper<DINode> SubscriptArray = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(Subscript, true));
    
    long/*uint64_t*/ Size = CGM.getContext().getTypeSize(Ty);
    long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
    
    return DBuilder.createVectorType(Size, Align, ElementTy, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, SubscriptArray));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2060,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_9ArrayTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_9ArrayTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_ArrayType$C$P_DIFile$P(/*const*/ org.clang.ast.ArrayType /*P*/ Ty, DIFile /*P*/ Unit) {
    long/*uint64_t*/ Size;
    long/*uint64_t*/ Align;
    {
      
      // FIXME: make getTypeAlign() aware of VLAs and incomplete array types
      /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_VariableArrayType(Ty);
      if ((VAT != null)) {
        Size = $int2ulong(0);
        Align
           = $uint2ulong(CGM.getContext().getTypeAlign(CGM.getContext().getBaseElementType(VAT)));
      } else if (Ty.isIncompleteArrayType()) {
        Size = $int2ulong(0);
        if (Ty.getElementType().$arrow().isIncompleteType()) {
          Align = $int2ulong(0);
        } else {
          Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty.getElementType()));
        }
      } else if (Ty.isIncompleteType()) {
        Size = $int2ulong(0);
        Align = $int2ulong(0);
      } else {
        // Size and align of the whole array, not the element type.
        Size = CGM.getContext().getTypeSize(Ty);
        Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
      }
    }
    
    // Add the dimensions of the array.  FIXME: This loses CV qualifiers from
    // interior arrays, do we care?  Why aren't nested arrays represented the
    // obvious/recursive way?
    SmallVector<Metadata /*P*/ > Subscripts/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
    QualType EltTy/*J*/= new QualType(Ty, 0);
    while (((Ty = dyn_cast_ArrayType(EltTy)) != null)) {
      // If the number of elements is known, then count is that number. Otherwise,
      // it's -1. This allows us to represent a subrange with an array of 0
      // elements, like this:
      //
      //   struct foo {
      //     int x[0];
      //   };
      long/*int64_t*/ Count = -1; // Count == -1 is an unbounded array.
      {
        /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(Ty);
        if ((CAT != null)) {
          Count = CAT.getSize().getZExtValue();
        }
      }
      
      // FIXME: Verify this is right for VLAs.
      Subscripts.push_back(DBuilder.getOrCreateSubrange(0, Count));
      EltTy.$assignMove(Ty.getElementType());
    }
    
    MDTupleTypedArrayWrapper<DINode> SubscriptArray = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(Subscripts, true));
    
    return DBuilder.createArrayType(Size, Align, getOrCreateType(new QualType(EltTy), Unit), 
        new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, SubscriptArray));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2112,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_19LValueReferenceTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_19LValueReferenceTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_LValueReferenceType$C$P_DIFile$P(/*const*/ LValueReferenceType /*P*/ Ty, 
                                             DIFile /*P*/ Unit) {
    return CreatePointerLikeType(Tag.DW_TAG_reference_type, Ty, 
        Ty.getPointeeType(), Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2118,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_19RValueReferenceTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_19RValueReferenceTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_RValueReferenceType$C$P_DIFile$P(/*const*/ RValueReferenceType /*P*/ Ty, 
                                             DIFile /*P*/ Unit) {
    return CreatePointerLikeType(Tag.DW_TAG_rvalue_reference_type, Ty, 
        Ty.getPointeeType(), Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2124,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_17MemberPointerTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_17MemberPointerTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_MemberPointerType$C$P_DIFile$P(/*const*/ MemberPointerType /*P*/ Ty, 
                                           DIFile /*P*/ U) {
    /*uint*/int Flags = 0;
    long/*uint64_t*/ Size = $int2ulong(0);
    if (!Ty.isIncompleteType()) {
      Size = CGM.getContext().getTypeSize(Ty);
      
      // Set the MS inheritance model. There is no flag for the unspecified model.
      if (CGM.getTarget().getCXXABI().isMicrosoft()) {
        switch (Ty.getMostRecentCXXRecordDecl().getMSInheritanceModel()) {
         case Keyword_single_inheritance:
          Flags |= DINode.DIFlags.FlagSingleInheritance;
          break;
         case Keyword_multiple_inheritance:
          Flags |= DINode.DIFlags.FlagMultipleInheritance;
          break;
         case Keyword_virtual_inheritance:
          Flags |= DINode.DIFlags.FlagVirtualInheritance;
          break;
         case Keyword_unspecified_inheritance:
          break;
        }
      }
    }
    
    DIType /*P*/ ClassType = getOrCreateType(new QualType(Ty.__getClass(), 0), U);
    if (Ty.isMemberDataPointerType()) {
      return DBuilder.createMemberPointerType(getOrCreateType(Ty.getPointeeType(), U), ClassType, Size, /*Align=*/ $int2ulong(0), 
          Flags);
    }
    
    /*const*/ FunctionProtoType /*P*/ FPT = Ty.getPointeeType().$arrow().getAs(FunctionProtoType.class);
    return DBuilder.createMemberPointerType(getOrCreateInstanceMethodType(CGM.getContext().getPointerType(new QualType(Ty.__getClass(), FPT.getTypeQuals())), 
            FPT, U), 
        ClassType, Size, /*Align=*/ $int2ulong(0), Flags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2165,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_10AtomicTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_10AtomicTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_AtomicType$C$P_DIFile$P(/*const*/ AtomicType /*P*/ Ty, DIFile /*P*/ U) {
    // Ignore the atomic wrapping
    // FIXME: What is the correct representation?
    return getOrCreateType(Ty.getValueType(), U);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2171,
   FQN="clang::CodeGen::CGDebugInfo::CreateType", NM="_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_8PipeTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo10CreateTypeEPKNS_8PipeTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateType_PipeType$C$P_DIFile$P(/*const*/ PipeType /*P*/ Ty, 
                                  DIFile /*P*/ U) {
    return getOrCreateType(Ty.getElementType(), U);
  }

  /// Get enumeration type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateEnumType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2176,
   FQN="clang::CodeGen::CGDebugInfo::CreateEnumType", NM="_ZN5clang7CodeGen11CGDebugInfo14CreateEnumTypeEPKNS_8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo14CreateEnumTypeEPKNS_8EnumTypeE")
  //</editor-fold>
  private DIType /*P*/ CreateEnumType(/*const*/ EnumType /*P*/ Ty) {
    /*const*/ EnumDecl /*P*/ ED = Ty.getDecl();
    
    long/*uint64_t*/ Size = $int2ulong(0);
    long/*uint64_t*/ Align = $int2ulong(0);
    if (!ED.getTypeForDecl().isIncompleteType()) {
      Size = CGM.getContext().getTypeSize(ED.getTypeForDecl());
      Align = $uint2ulong(CGM.getContext().getTypeAlign(ED.getTypeForDecl()));
    }
    
    SmallString/*<256>*/ FullName = CGDebugInfoStatics.getUniqueTagTypeName(Ty, CGM, TheCU);
    
    boolean isImportedFromModule = DebugTypeExtRefs && ED.isFromASTFile() && (ED.getDefinition() != null);
    
    // If this is just a forward declaration, construct an appropriately
    // marked node and just return it.
    if (isImportedFromModule || !(ED.getDefinition() != null)) {
      std.unique_ptr_with_deleter<DIScope /*, TempMDNodeDeleter*/> TmpContext = null;
      try {
        // Note that it is possible for enums to be created as part of
        // their own declcontext. In this case a FwdDecl will be created
        // twice. This doesn't cause a problem because both FwdDecls are
        // entered into the ReplaceMap: finalize() will replace the first
        // FwdDecl with the second and then replace the second with
        // complete type.
        DIScope /*P*/ EDContext = getDeclContextDescriptor(ED);
        DIFile /*P*/ DefUnit = getOrCreateFile(ED.getLocation());
        TmpContext/*J*/= new std.unique_ptr_with_deleter<DIScope /*, TempMDNodeDeleter*/>(DBuilder.createReplaceableCompositeType($ushort2uint(Tag.DW_TAG_enumeration_type), new StringRef(/*KEEP_STR*/$EMPTY), TheCU, DefUnit, 0));
        
        /*uint*/int Line = getLineNumber(ED.getLocation());
        StringRef EDName = ED.getName();
        DIType /*P*/ RetTy = DBuilder.createReplaceableCompositeType($ushort2uint(Tag.DW_TAG_enumeration_type), new StringRef(EDName), EDContext, DefUnit, Line, 
            0, Size, Align, DINode.DIFlags.FlagFwdDecl, FullName.$StringRef());
        
        ReplaceMap.emplace_back(new std.pairPtrType</*const*/ TagType /*P*/ , TrackingMDRef>(Ty, 
            new TrackingMDRef((/*static_cast*/Metadata /*P*/ )(RetTy))));
        return RetTy;
      } finally {
        if (TmpContext != null) { TmpContext.$destroy(); }
      }
    }
    
    return CreateTypeDefinition(Ty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateTypeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2220,
   FQN="clang::CodeGen::CGDebugInfo::CreateTypeDefinition", NM="_ZN5clang7CodeGen11CGDebugInfo20CreateTypeDefinitionEPKNS_8EnumTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20CreateTypeDefinitionEPKNS_8EnumTypeE")
  //</editor-fold>
  private DIType /*P*/ CreateTypeDefinition(/*const*/ EnumType /*P*/ Ty) {
    /*const*/ EnumDecl /*P*/ ED = Ty.getDecl();
    long/*uint64_t*/ Size = $int2ulong(0);
    long/*uint64_t*/ Align = $int2ulong(0);
    if (!ED.getTypeForDecl().isIncompleteType()) {
      Size = CGM.getContext().getTypeSize(ED.getTypeForDecl());
      Align = $uint2ulong(CGM.getContext().getTypeAlign(ED.getTypeForDecl()));
    }
    
    SmallString/*<256>*/ FullName = CGDebugInfoStatics.getUniqueTagTypeName(Ty, CGM, TheCU);
    
    // Create elements for each enumerator.
    SmallVector<Metadata /*P*/ > Enumerators/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    ED = ED.getDefinition();
    for (/*const*/ EnumConstantDecl /*P*/ Enum : ED.enumerators()) {
      Enumerators.push_back(DBuilder.createEnumerator(Enum.getName(), Enum.getInitVal().getSExtValue()));
    }
    
    // Return a CompositeType for the enum itself.
    MDTupleTypedArrayWrapper<DINode> EltArray = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(Enumerators, true));
    
    DIFile /*P*/ DefUnit = getOrCreateFile(ED.getLocation());
    /*uint*/int Line = getLineNumber(ED.getLocation());
    DIScope /*P*/ EnumContext = getDeclContextDescriptor(ED);
    DIType /*P*/ ClassTy = ED.isFixed() ? getOrCreateType(ED.getIntegerType(), DefUnit) : null;
    return DBuilder.createEnumerationType(EnumContext, ED.getName(), DefUnit, 
        Line, Size, Align, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, EltArray), ClassTy,
        FullName.$StringRef());
  }

  /// Look up the completed type for a self pointer in the TypeCache and
  /// create a copy of it with the ObjectPointer and Artificial flags
  /// set. If the type is not cached, a new one is created. This should
  /// never happen though, since creating a type for the implicit self
  /// argument implies that we already parsed the interface definition
  /// and the ivar declarations in the implementation.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateSelfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3246,
   FQN="clang::CodeGen::CGDebugInfo::CreateSelfType", NM="_ZN5clang7CodeGen11CGDebugInfo14CreateSelfTypeERKNS_8QualTypeEPN4llvm6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo14CreateSelfTypeERKNS_8QualTypeEPN4llvm6DITypeE")
  //</editor-fold>
  private DIType /*P*/ CreateSelfType(final /*const*/ QualType /*&*/ QualTy, 
                DIType /*P*/ Ty) {
    DIType /*P*/ CachedTy = getTypeOrNull(new QualType(QualTy));
    if ((CachedTy != null)) {
      Ty = CachedTy;
    }
    return DBuilder.createObjectPointerType(Ty);
  }

  /// @}
  
  /// Get the type from the cache or return null type if it doesn't
  /// exist.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getTypeOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2307,
   FQN="clang::CodeGen::CGDebugInfo::getTypeOrNull", NM="_ZN5clang7CodeGen11CGDebugInfo13getTypeOrNullENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo13getTypeOrNullENS_8QualTypeE")
  //</editor-fold>
  private DIType /*P*/ getTypeOrNull(QualType Ty) {
    
    // Unwrap the type as needed for debug information.
    Ty.$assignMove(CGDebugInfoStatics.UnwrapTypeForDebugInfo(new QualType(Ty), CGM.getContext()));
    
    DenseMapIterator</*const*/Object/*void P*/ , TrackingMDRef> it = TypeCache.find(Ty.getAsOpaquePtr());
    if (it.$noteq(/*NO_ITER_COPY*/TypeCache.end())) {
      {
        // Verify that the debug info still exists.
        Metadata /*P*/ V = it.$arrow().second.$Metadata$P();
        if ((V != null)) {
          return cast_DIType(V);
        }
      }
    }
    
    return null;
  }

  /// Return the debug type for a C++ method.
  /// \arg CXXMethodDecl is of FunctionType. This function type is
  /// not updated to include implicit \c this pointer. Use this routine
  /// to get a method type which includes \c this pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateMethodType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1133,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateMethodType", NM="_ZN5clang7CodeGen11CGDebugInfo21getOrCreateMethodTypeEPKNS_13CXXMethodDeclEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21getOrCreateMethodTypeEPKNS_13CXXMethodDeclEPN4llvm6DIFileE")
  //</editor-fold>
  private DISubroutineType /*P*/ getOrCreateMethodType(/*const*/ CXXMethodDecl /*P*/ Method, 
                       DIFile /*P*/ Unit) {
    /*const*/ FunctionProtoType /*P*/ Func = Method.getType().$arrow().getAs(FunctionProtoType.class);
    if (Method.isStatic()) {
      return cast_or_null_DISubroutineType(getOrCreateType(new QualType(Func, 0), Unit));
    }
    return getOrCreateInstanceMethodType(Method.getThisType(CGM.getContext()), 
        Func, Unit);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateInstanceMethodType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1144,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateInstanceMethodType", NM="_ZN5clang7CodeGen11CGDebugInfo29getOrCreateInstanceMethodTypeENS_8QualTypeEPKNS_17FunctionProtoTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo29getOrCreateInstanceMethodTypeENS_8QualTypeEPKNS_17FunctionProtoTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DISubroutineType /*P*/ getOrCreateInstanceMethodType(QualType ThisPtr, /*const*/ FunctionProtoType /*P*/ Func, DIFile /*P*/ Unit) {
    // Add "this" pointer.
    DITypeRefArray Args/*J*/= cast_DISubroutineType(getOrCreateType(new QualType(Func, 0), Unit)).
        getTypeArray();
    assert ((Args.size() != 0)) : "Invalid number of arguments!";
    
    SmallVector<Metadata /*P*/ > Elts/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    
    // First element is always return type. For 'void' functions it is NULL.
    Elts.push_back(Args.$at(0).$Metadata$P());
    
    // "this" pointer is always first argument.
    /*const*/ CXXRecordDecl /*P*/ RD = ThisPtr.$arrow().getPointeeCXXRecordDecl();
    if (isa_ClassTemplateSpecializationDecl(RD)) {
      // Create pointer type directly in this case.
      /*const*/ org.clang.ast.PointerType /*P*/ ThisPtrTy = cast_PointerType(ThisPtr);
      QualType PointeeTy = ThisPtrTy.getPointeeType();
      /*uint*/int AS = CGM.getContext().getTargetAddressSpace(new QualType(PointeeTy));
      long/*uint64_t*/ Size = CGM.getTarget().getPointerWidth(AS);
      long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(ThisPtrTy));
      DIType /*P*/ PointeeType = getOrCreateType(new QualType(PointeeTy), Unit);
      DIType /*P*/ ThisPtrType = DBuilder.createPointerType(PointeeType, Size, Align);
      TypeCache.$at_T1$RR(ThisPtr.getAsOpaquePtr()).reset(ThisPtrType);
      // TODO: This and the artificial type below are misleading, the
      // types aren't artificial the argument is, but the current
      // metadata doesn't represent that.
      ThisPtrType = DBuilder.createObjectPointerType(ThisPtrType);
      Elts.push_back(ThisPtrType);
    } else {
      DIType /*P*/ ThisPtrType = getOrCreateType(new QualType(ThisPtr), Unit);
      TypeCache.$at_T1$RR(ThisPtr.getAsOpaquePtr()).reset(ThisPtrType);
      ThisPtrType = DBuilder.createObjectPointerType(ThisPtrType);
      Elts.push_back(ThisPtrType);
    }
    
    // Copy rest of the arguments.
    for (/*uint*/int i = 1, e = Args.size(); i != e; ++i)  {
      Elts.push_back(Args.$at(i).$Metadata$P());
    }
    
    DITypeRefArray EltTypeArray = DBuilder.getOrCreateTypeArray(new ArrayRef<Metadata /*P*/ >(Elts, true));
    
    /*uint*/int Flags = 0;
    if (Func.getExtProtoInfo().RefQualifier == RefQualifierKind.RQ_LValue) {
      Flags |= DINode.DIFlags.FlagLValueReference;
    }
    if (Func.getExtProtoInfo().RefQualifier == RefQualifierKind.RQ_RValue) {
      Flags |= DINode.DIFlags.FlagRValueReference;
    }
    
    return DBuilder.createSubroutineType(new DITypeRefArray(EltTypeArray), Flags, 
        CGDebugInfoStatics.getDwarfCC(Func.getCallConv()));
  }

  
  // getOrCreateFunctionType - Construct type. If it is a c++ method, include
  // implicit parameter "this".
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateFunctionType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2790,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateFunctionType", NM="_ZN5clang7CodeGen11CGDebugInfo23getOrCreateFunctionTypeEPKNS_4DeclENS_8QualTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo23getOrCreateFunctionTypeEPKNS_4DeclENS_8QualTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DISubroutineType /*P*/ getOrCreateFunctionType(/*const*/ Decl /*P*/ D, 
                         QualType FnType, 
                         DIFile /*P*/ F) {
    if (!(D != null) || DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      // Create fake but valid subroutine type. Otherwise -verify would fail, and
      // subprogram DIE will miss DW_AT_decl_file and DW_AT_decl_line fields.
      return DBuilder.createSubroutineType(DBuilder.getOrCreateTypeArray(new ArrayRef<Metadata /*P*/ >(None, true)));
    }
    {
      
      /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
      if ((Method != null)) {
        return getOrCreateMethodType(Method, F);
      }
    }
    
    /*const*/ org.clang.ast.FunctionType /*P*/ FTy = FnType.$arrow().getAs(org.clang.ast.FunctionType.class);
    org.clang.basic.CallingConv CC = (FTy != null) ? FTy.getCallConv() : org.clang.basic.CallingConv.CC_C;
    {
      
      /*const*/ ObjCMethodDecl /*P*/ OMethod = dyn_cast_ObjCMethodDecl(D);
      if ((OMethod != null)) {
        // Add "self" and "_cmd"
        SmallVector<Metadata /*P*/ > Elts/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
        
        // First element is always return type. For 'void' functions it is NULL.
        QualType ResultTy = OMethod.getReturnType();
        
        // Replace the instancetype keyword with the actual type.
        if (QualType.$eq_QualType$C(ResultTy, CGM.getContext().getObjCInstanceType())) {
          ResultTy.$assignMove(CGM.getContext().getPointerType(new QualType(OMethod.getClassInterface$Const().getTypeForDecl(), 0)));
        }
        
        Elts.push_back(getOrCreateType(new QualType(ResultTy), F));
        // "self" pointer is always first argument.
        QualType SelfDeclTy/*J*/= new QualType();
        {
          ImplicitParamDecl /*P*/ SelfDecl = OMethod.getSelfDecl();
          if ((SelfDecl != null)) {
            SelfDeclTy.$assignMove(SelfDecl.getType());
          } else {
            /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FnType);
            if ((FPT != null)) {
              if ($greater_uint(FPT.getNumParams(), 1)) {
                SelfDeclTy.$assignMove(FPT.getParamType(0));
              }
            }
          }
        }
        if (!SelfDeclTy.isNull()) {
          Elts.push_back(CreateSelfType(SelfDeclTy, getOrCreateType(new QualType(SelfDeclTy), F)));
        }
        // "_cmd" pointer is always second argument.
        Elts.push_back(DBuilder.createArtificialType(getOrCreateType(CGM.getContext().getObjCSelType(), F)));
        // Get rest of the arguments.
        for (/*const*/ ParmVarDecl /*P*/ PI : OMethod.parameters())  {
          Elts.push_back(getOrCreateType(PI.getType(), F));
        }
        // Variadic methods need a special marker at the end of the type list.
        if (OMethod.isVariadic()) {
          Elts.push_back(DBuilder.createUnspecifiedParameter());
        }
        
        DITypeRefArray EltTypeArray = DBuilder.getOrCreateTypeArray(new ArrayRef<Metadata /*P*/ >(Elts, true));
        return DBuilder.createSubroutineType(new DITypeRefArray(EltTypeArray), 0, CGDebugInfoStatics.getDwarfCC(CC));
      }
    }
    {
      
      // Handle variadic function types; they need an additional
      // unspecified parameter.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        if (FD.isVariadic()) {
          SmallVector<Metadata /*P*/ > EltTys/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
          EltTys.push_back(getOrCreateType(FD.getReturnType(), F));
          {
            /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FnType);
            if ((FPT != null)) {
              for (QualType ParamType : FPT.param_types())  {
                EltTys.push_back(getOrCreateType(new QualType(ParamType), F));
              }
            }
          }
          EltTys.push_back(DBuilder.createUnspecifiedParameter());
          DITypeRefArray EltTypeArray = DBuilder.getOrCreateTypeArray(new ArrayRef<Metadata /*P*/ >(EltTys, true));
          return DBuilder.createSubroutineType(new DITypeRefArray(EltTypeArray), 0, CGDebugInfoStatics.getDwarfCC(CC));
        }
      }
    }
    
    return cast_DISubroutineType(getOrCreateType(new QualType(FnType), F));
  }

  /// \return debug info descriptor for vtable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateVTablePtrType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1511,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateVTablePtrType", NM="_ZN5clang7CodeGen11CGDebugInfo24getOrCreateVTablePtrTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24getOrCreateVTablePtrTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ getOrCreateVTablePtrType(DIFile /*P*/ Unit) {
    if ((VTablePtrType != null)) {
      return VTablePtrType;
    }
    
    final ASTContext /*&*/ Context = CGM.getContext();
    
    /* Function type */
    Metadata /*P*/ STy = getOrCreateType(Context.IntTy.$QualType(), Unit);
    DITypeRefArray SElements = DBuilder.getOrCreateTypeArray(new ArrayRef<Metadata /*P*/ >(STy, true));
    DIType /*P*/ SubTy = DBuilder.createSubroutineType(new DITypeRefArray(SElements));
    /*uint*/int Size = $ulong2uint(Context.getTypeSize(Context.VoidPtrTy.$QualType()));
    DIType /*P*/ vtbl_ptr_type = DBuilder.createPointerType(SubTy, $uint2ulong(Size), $int2ulong(0), new StringRef(/*KEEP_STR*/"__vtbl_ptr_type"));
    VTablePtrType = DBuilder.createPointerType(vtbl_ptr_type, $uint2ulong(Size));
    return VTablePtrType;
  }

  /// \return namespace descriptor for the given namespace decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateNameSpace">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3693,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateNameSpace", NM="_ZN5clang7CodeGen11CGDebugInfo20getOrCreateNameSpaceEPKNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20getOrCreateNameSpaceEPKNS_13NamespaceDeclE")
  //</editor-fold>
  private DINamespace /*P*/ getOrCreateNameSpace(/*const*/ NamespaceDecl /*P*/ NSDecl) {
    NSDecl = NSDecl.getCanonicalDecl$Const();
    DenseMapIterator</*const*/ NamespaceDecl /*P*/ , TrackingMDRef> I = NameSpaceCache.find(NSDecl);
    if (I.$noteq(/*NO_ITER_COPY*/NameSpaceCache.end())) {
      return cast_DINamespace(I.$arrow().second.$arrow());
    }
    
    /*uint*/int LineNo = getLineNumber(NSDecl.getLocation());
    DIFile /*P*/ FileD = getOrCreateFile(NSDecl.getLocation());
    DIScope /*P*/ Context = getDeclContextDescriptor(NSDecl);
    DINamespace /*P*/ NS = DBuilder.createNameSpace(Context, NSDecl.getName(), FileD, LineNo);
    NameSpaceCache.$at_T1$C$R(NSDecl).reset(NS);
    return NS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreatePointerLikeType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 743,
   FQN="clang::CodeGen::CGDebugInfo::CreatePointerLikeType", NM="_ZN5clang7CodeGen11CGDebugInfo21CreatePointerLikeTypeEN4llvm5dwarf3TagEPKNS_4TypeENS_8QualTypeEPNS2_6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21CreatePointerLikeTypeEN4llvm5dwarf3TagEPKNS_4TypeENS_8QualTypeEPNS2_6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreatePointerLikeType(/*Tag*//*uint16_t*/char Tag_, 
                       /*const*/ org.clang.ast.Type /*P*/ Ty, 
                       QualType PointeeTy, 
                       DIFile /*P*/ Unit) {
    // Bit size, align and offset of the type.
    // Size is always the size of a pointer. We can't use getTypeSize here
    // because that does not return the correct value for references.
    /*uint*/int AS = CGM.getContext().getTargetAddressSpace(new QualType(PointeeTy));
    long/*uint64_t*/ Size = CGM.getTarget().getPointerWidth(AS);
    long/*uint64_t*/ Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
    if (Tag_ == Tag.DW_TAG_reference_type
       || Tag_ == Tag.DW_TAG_rvalue_reference_type) {
      return DBuilder.createReferenceType($ushort2uint(Tag_), getOrCreateType(new QualType(PointeeTy), Unit), 
          Size, Align);
    } else {
      return DBuilder.createPointerType(getOrCreateType(new QualType(PointeeTy), Unit), Size, 
          Align);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateStructPtrType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 763,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateStructPtrType", NM="_ZN5clang7CodeGen11CGDebugInfo24getOrCreateStructPtrTypeEN4llvm9StringRefERPNS2_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24getOrCreateStructPtrTypeEN4llvm9StringRefERPNS2_6DITypeE")
  //</editor-fold>
  private DIType /*P*/ getOrCreateStructPtrType(StringRef Name, 
                          final type$ref<DIType /*P*/ /*&*/> Cache) {
    if ((Cache.$deref() != null)) {
      return Cache.$deref();
    }
    Cache.$set(DBuilder.createForwardDecl($ushort2uint(Tag.DW_TAG_structure_type), new StringRef(Name), 
        TheCU, getOrCreateMainFile(), 0));
    /*uint*/int Size = $ulong2uint(CGM.getContext().getTypeSize(CGM.getContext().VoidPtrTy.$QualType()));
    Cache.$set(DBuilder.createPointerType(Cache.$deref(), $uint2ulong(Size)));
    return Cache.$deref();
  }

  
  /// A helper function to create a subprogram for a single member
  /// function GlobalDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateCXXMemberFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1208,
   FQN="clang::CodeGen::CGDebugInfo::CreateCXXMemberFunction", NM="_ZN5clang7CodeGen11CGDebugInfo23CreateCXXMemberFunctionEPKNS_13CXXMethodDeclEPN4llvm6DIFileEPNS5_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo23CreateCXXMemberFunctionEPKNS_13CXXMethodDeclEPN4llvm6DIFileEPNS5_6DITypeE")
  //</editor-fold>
  private DISubprogram /*P*/ CreateCXXMemberFunction(/*const*/ CXXMethodDecl /*P*/ Method, DIFile /*P*/ Unit, DIType /*P*/ RecordTy) {
    boolean IsCtorOrDtor = isa_CXXConstructorDecl(Method) || isa_CXXDestructorDecl(Method);
    
    StringRef MethodName = getFunctionName(Method);
    DISubroutineType /*P*/ MethodTy = getOrCreateMethodType(Method, Unit);
    
    // Since a single ctor/dtor corresponds to multiple functions, it doesn't
    // make sense to give a single ctor/dtor a linkage name.
    StringRef MethodLinkageName/*J*/= new StringRef();
    // FIXME: 'isFunctionLocalClass' seems like an arbitrary/unintentional
    // property to use here. It may've been intended to model "is non-external
    // type" but misses cases of non-function-local but non-external classes such
    // as those in anonymous namespaces as well as the reverse - external types
    // that are function local, such as those in (non-local) inline functions.
    if (!IsCtorOrDtor && !CGDebugInfoStatics.isFunctionLocalClass(Method.getParent$Const())) {
      MethodLinkageName.$assignMove(CGM.getMangledName(new GlobalDecl(Method)));
    }
    
    // Get the location for the method.
    DIFile /*P*/ MethodDefUnit = null;
    /*uint*/int MethodLine = 0;
    if (!Method.isImplicit()) {
      MethodDefUnit = getOrCreateFile(Method.getLocation());
      MethodLine = getLineNumber(Method.getLocation());
    }
    
    // Collect virtual method info.
    DIType /*P*/ ContainingType = null;
    /*uint*/int Virtuality = 0;
    /*uint*/int VIndex = 0;
    /*uint*/int Flags = 0;
    int ThisAdjustment = 0;
    if (Method.isVirtual()) {
      if (Method.isPure()) {
        Virtuality = VirtualityAttribute.DW_VIRTUALITY_pure_virtual;
      } else {
        Virtuality = VirtualityAttribute.DW_VIRTUALITY_virtual;
      }
      if (CGM.getTarget().getCXXABI().isItaniumFamily()) {
        // It doesn't make sense to give a virtual destructor a vtable index,
        // since a single destructor has two entries in the vtable.
        if (!isa_CXXDestructorDecl(Method)) {
          VIndex = $ulong2uint(CGM.getItaniumVTableContext().getMethodVTableIndex(new GlobalDecl(Method)));
        }
      } else {
        // Emit MS ABI vftable information.  There is only one entry for the
        // deleting dtor.
        /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(Method);
        GlobalDecl GD = (DD != null) ? new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Deleting) : new GlobalDecl(Method);
        MicrosoftVTableContext.MethodVFTableLocation ML = new MicrosoftVTableContext.MethodVFTableLocation(CGM.getMicrosoftVTableContext().getMethodVFTableLocation(new GlobalDecl(GD)));
        VIndex = $ulong2uint(ML.Index);
        
        // CodeView only records the vftable offset in the class that introduces
        // the virtual method. This is possible because, unlike Itanium, the MS
        // C++ ABI does not include all virtual methods from non-primary bases in
        // the vtable for the most derived class. For example, if C inherits from
        // A and B, C's primary vftable will not include B's virtual methods.
        if ($eq_ptr(Method.begin_overridden_methods(), Method.end_overridden_methods())) {
          Flags |= DINode.DIFlags.FlagIntroducedVirtual;
        }
        
        // The 'this' adjustment accounts for both the virtual and non-virtual
        // portions of the adjustment. Presumably the debugger only uses it when
        // it knows the dynamic type of an object.
        ThisAdjustment = (int)CGM.getCXXABI().
            getVirtualFunctionPrologueThisAdjustment(new GlobalDecl(GD)).
            getQuantity();
      }
      ContainingType = RecordTy;
    }
    if (Method.isImplicit()) {
      Flags |= DINode.DIFlags.FlagArtificial;
    }
    Flags |= CGDebugInfoStatics.getAccessFlag(Method.getAccess(), Method.getParent$Const());
    {
      /*const*/ CXXConstructorDecl /*P*/ CXXC = dyn_cast_CXXConstructorDecl(Method);
      if ((CXXC != null)) {
        if (CXXC.isExplicit()) {
          Flags |= DINode.DIFlags.FlagExplicit;
        }
      } else {
        /*const*/ CXXConversionDecl /*P*/ CXXC$1 = dyn_cast_CXXConversionDecl(Method);
        if ((CXXC$1 != null)) {
          if (CXXC$1.isExplicit()) {
            Flags |= DINode.DIFlags.FlagExplicit;
          }
        }
      }
    }
    if (Method.hasPrototype()) {
      Flags |= DINode.DIFlags.FlagPrototyped;
    }
    if (Method.getRefQualifier() == RefQualifierKind.RQ_LValue) {
      Flags |= DINode.DIFlags.FlagLValueReference;
    }
    if (Method.getRefQualifier() == RefQualifierKind.RQ_RValue) {
      Flags |= DINode.DIFlags.FlagRValueReference;
    }
    
    MDTupleTypedArrayWrapper<DINode> TParamsArray = CollectFunctionTemplateParams(Method, Unit);
    DISubprogram /*P*/ SP = DBuilder.createMethod(RecordTy, new StringRef(MethodName), new StringRef(MethodLinkageName), MethodDefUnit, MethodLine, 
        MethodTy, /*isLocalToUnit=*/ false, /*isDefinition=*/ false, Virtuality, 
        VIndex, ThisAdjustment, ContainingType, Flags, CGM.getLangOpts().Optimize, 
        new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, TParamsArray.get()));
    
    SPCache.$at_T1$RR(Method.getCanonicalDecl$Const()).reset(SP);
    
    return SP;
  }

  
  /// A helper function to collect debug info for C++ member
  /// functions. This is used while creating debug info entry for a
  /// Record.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectCXXMemberFunctions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1309,
   FQN="clang::CodeGen::CGDebugInfo::CollectCXXMemberFunctions", NM="_ZN5clang7CodeGen11CGDebugInfo25CollectCXXMemberFunctionsEPKNS_13CXXRecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo25CollectCXXMemberFunctionsEPKNS_13CXXRecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeE")
  //</editor-fold>
  private void CollectCXXMemberFunctions(/*const*/ CXXRecordDecl /*P*/ RD, DIFile /*P*/ Unit, 
                           final SmallVectorImpl<Metadata /*P*/ > /*&*/ EltTys, DIType /*P*/ RecordTy) {
    
    // Since we want more than just the individual member decls if we
    // have templated functions iterate over every declaration to gather
    // the functions.
    for (/*const*/ Decl /*P*/ I : RD.decls()) {
      /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(I);
      // If the member is implicit, don't add it to the member list. This avoids
      // the member being added to type units by LLVM, while still allowing it
      // to be emitted into the type declaration/reference inside the compile
      // unit.
      // Ditto 'nodebug' methods, for consistency with CodeGenFunction.cpp.
      // FIXME: Handle Using(Shadow?)Decls here to create
      // DW_TAG_imported_declarations inside the class for base decls brought into
      // derived classes. GDB doesn't seem to notice/leverage these when I tried
      // it, so I'm not rushing to fix this. (GCC seems to produce them, if
      // referenced)
      if (!(Method != null) || Method.isImplicit() || Method.hasAttr(NoDebugAttr.class)) {
        continue;
      }
      if ((Method.getType().$arrow().getAs(FunctionProtoType.class).getContainedAutoType() != null)) {
        continue;
      }
      
      // Reuse the existing member function declaration if it exists.
      // It may be associated with the declaration of the type & should be
      // reused as we're building the definition.
      //
      // This situation can arise in the vtable-based debug info reduction where
      // implicit members are emitted in a non-vtable TU.
      DenseMapIterator</*const*/ FunctionDecl /*P*/ , TrackingMDRef> MI = SPCache.find(Method.getCanonicalDecl$Const());
      EltTys.push_back(MI.$eq(/*NO_ITER_COPY*/SPCache.end()) ? CreateCXXMemberFunction(Method, Unit, RecordTy) : ((/*static_cast*/Metadata /*P*/ )(MI.$arrow().second.$Metadata$P())));
    }
  }

  
  /// A helper function to collect debug info for C++ base
  /// classes. This is used while creating debug info entry for a
  /// Record.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectCXXBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1347,
   FQN="clang::CodeGen::CGDebugInfo::CollectCXXBases", NM="_ZN5clang7CodeGen11CGDebugInfo15CollectCXXBasesEPKNS_13CXXRecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15CollectCXXBasesEPKNS_13CXXRecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeE")
  //</editor-fold>
  private void CollectCXXBases(/*const*/ CXXRecordDecl /*P*/ RD, DIFile /*P*/ Unit, 
                 final SmallVectorImpl<Metadata /*P*/ > /*&*/ EltTys, 
                 DIType /*P*/ RecordTy) {
    final /*const*/ ASTRecordLayout /*&*/ RL = CGM.getContext().getASTRecordLayout(RD);
    for (final /*const*/ CXXBaseSpecifier /*&*/ BI : RD.bases$Const()) {
      /*uint*/int BFlags = 0;
      long/*uint64_t*/ BaseOffset;
      
      /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(BI.getType().$arrow().getAs$RecordType().getDecl());
      if (BI.isVirtual()) {
        if (CGM.getTarget().getCXXABI().isItaniumFamily()) {
          // virtual base offset offset is -ve. The code generator emits dwarf
          // expression where it expects +ve number.
          BaseOffset = 0 - CGM.getItaniumVTableContext().
              getVirtualBaseOffsetOffset(RD, Base).
              getQuantity();
        } else {
          // In the MS ABI, store the vbtable offset, which is analogous to the
          // vbase offset offset in Itanium.
          BaseOffset
             = $uint2ulong(4 * CGM.getMicrosoftVTableContext().getVBTableIndex(RD, Base));
        }
        BFlags = DINode.DIFlags.FlagVirtual;
      } else {
        BaseOffset = CGM.getContext().toBits(RL.getBaseClassOffset(Base));
      }
      // FIXME: Inconsistent units for BaseOffset. It is in bytes when
      // BI->isVirtual() and bits when not.
      BFlags |= CGDebugInfoStatics.getAccessFlag(BI.getAccessSpecifier(), RD);
      DIType /*P*/ DTy = DBuilder.createInheritance(RecordTy, getOrCreateType(BI.getType(), Unit), BaseOffset, BFlags);
      EltTys.push_back(DTy);
    }
  }

  
  /// A helper function to collect template parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1384,
   FQN="clang::CodeGen::CGDebugInfo::CollectTemplateParams", NM="_ZN5clang7CodeGen11CGDebugInfo21CollectTemplateParamsEPKNS_21TemplateParameterListEN4llvm8ArrayRefINS_16TemplateArgumentEEEPNS5_6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21CollectTemplateParamsEPKNS_21TemplateParameterListEN4llvm8ArrayRefINS_16TemplateArgumentEEEPNS5_6DIFileE")
  //</editor-fold>
  private MDTupleTypedArrayWrapper<DINode> CollectTemplateParams(/*const*/ TemplateParameterList /*P*/ TPList, 
                       ArrayRef<TemplateArgument> TAList, 
                       DIFile /*P*/ Unit) {
    SmallVector<Metadata /*P*/ > TemplateParams/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
    for (/*uint*/int i = 0, e = TAList.size(); i != e; ++i) {
      final /*const*/ TemplateArgument /*&*/ TA = TAList.$at(i);
      StringRef Name/*J*/= new StringRef();
      if ((TPList != null)) {
        Name.$assignMove(TPList.getParam$Const(i).getName());
      }
      switch (TA.getKind()) {
       case Type:
        {
          DIType /*P*/ TTy = getOrCreateType(TA.getAsType(), Unit);
          TemplateParams.push_back(DBuilder.createTemplateTypeParameter(TheCU, new StringRef(Name), TTy));
        }
        break;
       case Integral:
        {
          DIType /*P*/ TTy = getOrCreateType(TA.getIntegralType(), Unit);
          TemplateParams.push_back(DBuilder.createTemplateValueParameter(TheCU, new StringRef(Name), TTy, 
                  ConstantInt.get(CGM.getLLVMContext(), TA.getAsIntegral())));
        }
        break;
       case Declaration:
        {
          /*const*/ ValueDecl /*P*/ D = TA.getAsDecl();
          QualType T = TA.getParamTypeForDecl().getDesugaredType(CGM.getContext());
          DIType /*P*/ TTy = getOrCreateType(new QualType(T), Unit);
          Constant /*P*/ V = null;
          /*const*/ CXXMethodDecl /*P*/ MD;
          {
            // Variable pointer template parameters have a value that is the address
            // of the variable.
            /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
            if ((VD != null)) {
              V = CGM.GetAddrOfGlobalVar(VD);
            } else // Member function pointers have special support for building them, though
            // this is currently unsupported in LLVM CodeGen.
            if (((MD = dyn_cast_CXXMethodDecl(D)) != null) && MD.isInstance()) {
              V = CGM.getCXXABI().EmitMemberFunctionPointer(MD);
            } else {
              /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
              if ((FD != null)) {
                V = CGM.GetAddrOfFunction(new GlobalDecl(FD));
              } else {
                // Member data pointers have special handling too to compute the fixed
                // offset within the object.
                /*const*/ MemberPointerType /*P*/ MPT = dyn_cast_MemberPointerType(T.getTypePtr());
                if ((MPT != null)) {
                  // These five lines (& possibly the above member function pointer
                  // handling) might be able to be refactored to use similar code in
                  // CodeGenModule::getMemberPointerConstant
                  long/*uint64_t*/ fieldOffset = CGM.getContext().getFieldOffset(D);
                  CharUnits chars = CGM.getContext().toCharUnitsFromBits((long/*int64_t*/)fieldOffset);
                  V = CGM.getCXXABI().EmitMemberDataPointer(MPT, new CharUnits(chars));
                }
              }
            }
          }
          TemplateParams.push_back(DBuilder.createTemplateValueParameter(TheCU, new StringRef(Name), TTy, 
                  cast_or_null_Constant(V.stripPointerCasts())));
        }
        break;
       case NullPtr:
        {
          QualType T = TA.getNullPtrType();
          DIType /*P*/ TTy = getOrCreateType(new QualType(T), Unit);
          Constant /*P*/ V = null;
          {
            // Special case member data pointer null values since they're actually -1
            // instead of zero.
            /*const*/ MemberPointerType /*P*/ MPT = dyn_cast_MemberPointerType(T.getTypePtr());
            if ((MPT != null)) {
              // But treat member function pointers as simple zero integers because
              // it's easier than having a special case in LLVM's CodeGen. If LLVM
              // CodeGen grows handling for values of non-null member function
              // pointers then perhaps we could remove this special case and rely on
              // EmitNullMemberPointer for member function pointers.
              if (MPT.isMemberDataPointer()) {
                V = CGM.getCXXABI().EmitNullMemberPointer(MPT);
              }
            }
          }
          if (!(V != null)) {
            V = ConstantInt.get(CGM.Int8Ty, $int2ulong(0));
          }
          TemplateParams.push_back(DBuilder.createTemplateValueParameter(TheCU, new StringRef(Name), TTy, V));
        }
        break;
       case Template:
        TemplateParams.push_back(DBuilder.createTemplateTemplateParameter(TheCU, new StringRef(Name), (DIType /*P*/ )null, 
                new StringRef(TA.getAsTemplate().getAsTemplateDecl().getQualifiedNameAsString())));
        break;
       case Pack:
        TemplateParams.push_back(DBuilder.createTemplateParameterPack(TheCU, new StringRef(Name), (DIType /*P*/ )null, 
                CollectTemplateParams((/*const*/ TemplateParameterList /*P*/ )null, TA.getPackAsArray(), Unit)));
        break;
       case Expression:
        {
          /*const*/ Expr /*P*/ E = TA.getAsExpr();
          QualType T = E.getType();
          if (E.isGLValue()) {
            T.$assignMove(CGM.getContext().getLValueReferenceType(new QualType(T)));
          }
          Constant /*P*/ V = CGM.EmitConstantExpr(E, new QualType(T));
          assert ((V != null)) : "Expression in template argument isn't constant";
          DIType /*P*/ TTy = getOrCreateType(new QualType(T), Unit);
          TemplateParams.push_back(DBuilder.createTemplateValueParameter(TheCU, new StringRef(Name), TTy, V.stripPointerCasts()));
        }
        break;
       case TemplateExpansion:
       case Null:
        // And the following should never occur:
        throw new llvm_unreachable("These argument types shouldn't exist in concrete types");
      }
    }
    return DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(TemplateParams, true));
  }

  /// A helper function to collect debug info for function template
  /// parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectFunctionTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1487,
   FQN="clang::CodeGen::CGDebugInfo::CollectFunctionTemplateParams", NM="_ZN5clang7CodeGen11CGDebugInfo29CollectFunctionTemplateParamsEPKNS_12FunctionDeclEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo29CollectFunctionTemplateParamsEPKNS_12FunctionDeclEPN4llvm6DIFileE")
  //</editor-fold>
  private MDTupleTypedArrayWrapper<DINode> CollectFunctionTemplateParams(/*const*/ FunctionDecl /*P*/ FD, 
                               DIFile /*P*/ Unit) {
    if (FD.getTemplatedKind()
       == FunctionDecl.TemplatedKind.TK_FunctionTemplateSpecialization) {
      /*const*/ TemplateParameterList /*P*/ TList = FD.getTemplateSpecializationInfo().
          getTemplate().
          getTemplateParameters();
      return CollectTemplateParams(TList, FD.getTemplateSpecializationArgs().asArray(), Unit);
    }
    return new MDTupleTypedArrayWrapper<DINode>(DINode.class);
  }

  
  /// A helper function to collect debug info for template
  /// parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectCXXTemplateParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1501,
   FQN="clang::CodeGen::CGDebugInfo::CollectCXXTemplateParams", NM="_ZN5clang7CodeGen11CGDebugInfo24CollectCXXTemplateParamsEPKNS_31ClassTemplateSpecializationDeclEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24CollectCXXTemplateParamsEPKNS_31ClassTemplateSpecializationDeclEPN4llvm6DIFileE")
  //</editor-fold>
  private MDTupleTypedArrayWrapper<DINode> CollectCXXTemplateParams(/*const*/ ClassTemplateSpecializationDecl /*P*/ TSpecial, DIFile /*P*/ Unit) {
    // Always get the full list of parameters, not just the ones from
    // the specialization.
    TemplateParameterList /*P*/ TPList = TSpecial.getSpecializedTemplate().getTemplateParameters();
    final /*const*/ TemplateArgumentList /*&*/ TAList = TSpecial.getTemplateArgs();
    return CollectTemplateParams(TPList, TAList.asArray(), Unit);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::createFieldType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 977,
   FQN="clang::CodeGen::CGDebugInfo::createFieldType", NM="_ZN5clang7CodeGen11CGDebugInfo15createFieldTypeEN4llvm9StringRefENS_8QualTypeENS_14SourceLocationENS_15AccessSpecifierEyPNS2_6DIFileEPNS2_7DIScopeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15createFieldTypeEN4llvm9StringRefENS_8QualTypeENS_14SourceLocationENS_15AccessSpecifierEyPNS2_6DIFileEPNS2_7DIScopeEPKNS_10RecordDeclE")
  //</editor-fold>
  private DIType /*P*/ createFieldType(StringRef name, QualType type, SourceLocation loc, 
                 AccessSpecifier AS, long/*uint64_t*/ offsetInBits, 
                 DIFile /*P*/ tunit, DIScope /*P*/ scope) {
    return createFieldType(name, type, loc, 
                 AS, offsetInBits, 
                 tunit, scope, 
                 (/*const*/ RecordDecl /*P*/ )null);
  }
  private DIType /*P*/ createFieldType(StringRef name, QualType type, SourceLocation loc, 
                 AccessSpecifier AS, long/*uint64_t*/ offsetInBits, 
                 DIFile /*P*/ tunit, DIScope /*P*/ scope, 
                 /*const*/ RecordDecl /*P*/ RD/*= null*/) {
    DIType /*P*/ debugType = getOrCreateType(new QualType(type), tunit);
    
    // Get the location for the field.
    DIFile /*P*/ file = getOrCreateFile(new SourceLocation(loc));
    /*uint*/int line = getLineNumber(new SourceLocation(loc));
    
    long/*uint64_t*/ SizeInBits = $int2ulong(0);
    /*uint*/int AlignInBits = 0;
    if (!type.$arrow().isIncompleteArrayType()) {
      TypeInfo TI = CGM.getContext().getTypeInfo(new QualType(type));
      SizeInBits = TI.Width;
      AlignInBits = TI.Align;
    }
    
    /*uint*/int flags = CGDebugInfoStatics.getAccessFlag(AS, RD);
    return DBuilder.createMemberType(scope, new StringRef(name), file, line, SizeInBits, 
        $uint2ulong(AlignInBits), offsetInBits, flags, debugType);
  }

  
  /// Create new bit field member.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::createBitFieldType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 950,
   FQN="clang::CodeGen::CGDebugInfo::createBitFieldType", NM="_ZN5clang7CodeGen11CGDebugInfo18createBitFieldTypeEPKNS_9FieldDeclEPN4llvm7DIScopeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo18createBitFieldTypeEPKNS_9FieldDeclEPN4llvm7DIScopeEPKNS_10RecordDeclE")
  //</editor-fold>
  private DIType /*P*/ createBitFieldType(/*const*/ FieldDecl /*P*/ BitFieldDecl, 
                    DIScope /*P*/ RecordTy, 
                    /*const*/ RecordDecl /*P*/ RD) {
    StringRef Name = BitFieldDecl.getName();
    QualType Ty = BitFieldDecl.getType();
    SourceLocation Loc = BitFieldDecl.getLocation();
    DIFile /*P*/ VUnit = getOrCreateFile(new SourceLocation(Loc));
    DIType /*P*/ DebugType = getOrCreateType(new QualType(Ty), VUnit);
    
    // Get the location for the field.
    DIFile /*P*/ File = getOrCreateFile(new SourceLocation(Loc));
    /*uint*/int Line = getLineNumber(new SourceLocation(Loc));
    
    final /*const*/ CGBitFieldInfo /*&*/ BitFieldInfo = CGM.getTypes().getCGRecordLayout(RD).getBitFieldInfo(BitFieldDecl);
    long/*uint64_t*/ SizeInBits = $uint2ulong($15bits_uint2uint(BitFieldInfo.Size));
    assert ($greater_ulong_ullong(SizeInBits, $int2ullong(0))) : "found named 0-width bitfield";
    /*uint*/int AlignInBits = CGM.getContext().getTypeAlign(new QualType(Ty));
    long/*uint64_t*/ StorageOffsetInBits = CGM.getContext().toBits(new CharUnits(BitFieldInfo.StorageOffset));
    long/*uint64_t*/ OffsetInBits = StorageOffsetInBits + $uint2ullong($16bits_uint2uint(BitFieldInfo.Offset));
    /*uint*/int Flags = CGDebugInfoStatics.getAccessFlag(BitFieldDecl.getAccess(), RD);
    return DBuilder.createBitFieldMemberType(RecordTy, new StringRef(Name), File, Line, SizeInBits, $uint2ulong(AlignInBits), OffsetInBits, 
        StorageOffsetInBits, Flags, DebugType);
  }

  
  /// Helpers for collecting fields of a record.
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectRecordLambdaFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1001,
   FQN="clang::CodeGen::CGDebugInfo::CollectRecordLambdaFields", NM="_ZN5clang7CodeGen11CGDebugInfo25CollectRecordLambdaFieldsEPKNS_13CXXRecordDeclERN4llvm15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo25CollectRecordLambdaFieldsEPKNS_13CXXRecordDeclERN4llvm15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeE")
  //</editor-fold>
  private void CollectRecordLambdaFields(/*const*/ CXXRecordDecl /*P*/ CXXDecl, final SmallVectorImpl<Metadata /*P*/ > /*&*/ elements, 
                           DIType /*P*/ RecordTy) {
    // For C++11 Lambdas a Field will be the same as a Capture, but the Capture
    // has the name and the location of the variable so we should iterate over
    // both concurrently.
    final /*const*/ ASTRecordLayout /*&*/ layout = CGM.getContext().getASTRecordLayout(CXXDecl);
    DeclContext.specific_decl_iterator<FieldDecl> Field = CXXDecl.field_begin();
    /*uint*/int fieldno = 0;
    for (type$ptr</*const*/ LambdaCapture /*P*/ > I = $tryClone(CXXDecl.captures_begin()), 
        /*P*/ E = $tryClone(CXXDecl.captures_end());
         $noteq_ptr(I, E); I.$preInc() , Field.$preInc() , ++fieldno) {
      final /*const*/ LambdaCapture /*&*/ C = I.$star();
      if (C.capturesVariable()) {
        SourceLocation Loc = C.getLocation();
        assert (!Field.$arrow().isBitField()) : "lambdas don't have bitfield members!";
        VarDecl /*P*/ V = C.getCapturedVar();
        StringRef VName = V.getName();
        DIFile /*P*/ VUnit = getOrCreateFile(new SourceLocation(Loc));
        DIType /*P*/ FieldType = createFieldType(new StringRef(VName), Field.$arrow().getType(), new SourceLocation(Loc), Field.$arrow().getAccess(), 
            layout.getFieldOffset(fieldno), VUnit, RecordTy, CXXDecl);
        elements.push_back(FieldType);
      } else if (C.capturesThis()) {
        // TODO: Need to handle 'this' in some way by probably renaming the
        // this of the lambda class and having a field member of 'this' or
        // by using AT_object_pointer for the function and having that be
        // used as 'this' for semantic references.
        FieldDecl /*P*/ f = Field.$star();
        DIFile /*P*/ VUnit = getOrCreateFile(f.getLocation());
        QualType type = f.getType();
        DIType /*P*/ fieldType = createFieldType(new StringRef(/*KEEP_STR*/$this), new QualType(type), f.getLocation(), f.getAccess(), 
            layout.getFieldOffset(fieldno), VUnit, RecordTy, CXXDecl);
        
        elements.push_back(fieldType);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateRecordStaticField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1041,
   FQN="clang::CodeGen::CGDebugInfo::CreateRecordStaticField", NM="_ZN5clang7CodeGen11CGDebugInfo23CreateRecordStaticFieldEPKNS_7VarDeclEPN4llvm6DITypeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo23CreateRecordStaticFieldEPKNS_7VarDeclEPN4llvm6DITypeEPKNS_10RecordDeclE")
  //</editor-fold>
  private DIDerivedType /*P*/ CreateRecordStaticField(/*const*/ VarDecl /*P*/ Var, DIType /*P*/ RecordTy, 
                         /*const*/ RecordDecl /*P*/ RD) {
    // Create the descriptor for the static variable, with or without
    // constant initializers.
    Var = Var.getCanonicalDecl$Const();
    DIFile /*P*/ VUnit = getOrCreateFile(Var.getLocation());
    DIType /*P*/ VTy = getOrCreateType(Var.getType(), VUnit);
    
    /*uint*/int LineNumber = getLineNumber(Var.getLocation());
    StringRef VName = Var.getName();
    Constant /*P*/ C = null;
    if ((Var.getInit$Const() != null)) {
      /*const*/ APValue /*P*/ Value = Var.evaluateValue();
      if ((Value != null)) {
        if (Value.isInt()) {
          C = ConstantInt.get(CGM.getLLVMContext(), Value.getInt$Const());
        }
        if (Value.isFloat()) {
          C = ConstantFP.get(CGM.getLLVMContext(), Value.getFloat$Const());
        }
      }
    }
    
    /*uint*/int Flags = CGDebugInfoStatics.getAccessFlag(Var.getAccess(), RD);
    DIDerivedType /*P*/ GV = DBuilder.createStaticMemberType(RecordTy, new StringRef(VName), VUnit, LineNumber, VTy, Flags, C);
    StaticDataMemberCache.$at_T1$RR(Var.getCanonicalDecl$Const()).reset(GV);
    return GV;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectRecordNormalField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1070,
   FQN="clang::CodeGen::CGDebugInfo::CollectRecordNormalField", NM="_ZN5clang7CodeGen11CGDebugInfo24CollectRecordNormalFieldEPKNS_9FieldDeclEyPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24CollectRecordNormalFieldEPKNS_9FieldDeclEyPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_6DITypeEPKNS_10RecordDeclE")
  //</editor-fold>
  private void CollectRecordNormalField(/*const*/ FieldDecl /*P*/ field, long/*uint64_t*/ OffsetInBits, DIFile /*P*/ tunit, 
                          final SmallVectorImpl<Metadata /*P*/ > /*&*/ elements, DIType /*P*/ RecordTy, 
                          /*const*/ RecordDecl /*P*/ RD) {
    StringRef name = field.getName();
    QualType type = field.getType();
    
    // Ignore unnamed fields unless they're anonymous structs/unions.
    if (name.empty() && !type.$arrow().isRecordType()) {
      return;
    }
    
    DIType /*P*/ FieldType;
    if (field.isBitField()) {
      FieldType = createBitFieldType(field, RecordTy, RD);
    } else {
      FieldType
         = createFieldType(new StringRef(name), new QualType(type), field.getLocation(), field.getAccess(), 
          OffsetInBits, tunit, RecordTy, RD);
    }
    
    elements.push_back(FieldType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectRecordFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1093,
   FQN="clang::CodeGen::CGDebugInfo::CollectRecordFields", NM="_ZN5clang7CodeGen11CGDebugInfo19CollectRecordFieldsEPKNS_10RecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_15DICompositeTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo19CollectRecordFieldsEPKNS_10RecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEEPNS5_15DICompositeTypeE")
  //</editor-fold>
  private void CollectRecordFields(/*const*/ RecordDecl /*P*/ record, DIFile /*P*/ tunit, 
                     final SmallVectorImpl<Metadata /*P*/ > /*&*/ elements, 
                     DICompositeType /*P*/ RecordTy) {
    /*const*/ CXXRecordDecl /*P*/ CXXDecl = dyn_cast_CXXRecordDecl(record);
    if ((CXXDecl != null) && CXXDecl.isLambda()) {
      CollectRecordLambdaFields(CXXDecl, elements, RecordTy);
    } else {
      final /*const*/ ASTRecordLayout /*&*/ layout = CGM.getContext().getASTRecordLayout(record);
      
      // Field number for non-static fields.
      /*uint*/int fieldNo = 0;
      
      // Static and non-static members should appear in the same order as
      // the corresponding declarations in the source program.
      for (/*const*/ Decl /*P*/ I : record.decls())  {
        {
          /*const*/ VarDecl /*P*/ V = dyn_cast_VarDecl(I);
          if ((V != null)) {
            if (V.hasAttr(NoDebugAttr.class)) {
              continue;
            }
            // Reuse the existing static member declaration if one exists
            DenseMapIterator</*const*/ Decl /*P*/ , TypedTrackingMDRef<DIDerivedType>> MI = StaticDataMemberCache.find(V.getCanonicalDecl$Const());
            if (MI.$noteq(/*NO_ITER_COPY*/StaticDataMemberCache.end())) {
              assert (((MI.$arrow().second.$T$P()) != null)) : "Static data member declaration should still exist";
              elements.push_back(MI.$arrow().second.$T$P());
            } else {
              DIDerivedType /*P*/ Field = CreateRecordStaticField(V, RecordTy, record);
              elements.push_back(Field);
            }
          } else {
            /*const*/ FieldDecl /*P*/ field = dyn_cast_FieldDecl(I);
            if ((field != null)) {
              CollectRecordNormalField(field, layout.getFieldOffset(fieldNo), tunit, 
                  elements, RecordTy, record);
              
              // Bump field number for next field.
              ++fieldNo;
            }
          }
        }
      }
    }
  }

  
  /// If the C++ class has vtable info then insert appropriate debug
  /// info entry in EltTys vector.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectVTableInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1533,
   FQN="clang::CodeGen::CGDebugInfo::CollectVTableInfo", NM="_ZN5clang7CodeGen11CGDebugInfo17CollectVTableInfoEPKNS_13CXXRecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17CollectVTableInfoEPKNS_13CXXRecordDeclEPN4llvm6DIFileERNS5_15SmallVectorImplIPNS5_8MetadataEEE")
  //</editor-fold>
  private void CollectVTableInfo(/*const*/ CXXRecordDecl /*P*/ RD, DIFile /*P*/ Unit, 
                   final SmallVectorImpl<Metadata /*P*/ > /*&*/ EltTys) {
    final /*const*/ ASTRecordLayout /*&*/ RL = CGM.getContext().getASTRecordLayout(RD);
    
    // If there is a primary base then it will hold vtable info.
    if ((RL.getPrimaryBase() != null)) {
      return;
    }
    
    // If this class is not dynamic then there is not any vtable info to collect.
    if (!RD.isDynamicClass()) {
      return;
    }
    
    /*uint*/int Size = $ulong2uint(CGM.getContext().getTypeSize(CGM.getContext().VoidPtrTy.$QualType()));
    DIType /*P*/ VPTR = DBuilder.createMemberType(Unit, getVTableName(RD), Unit, 0, $uint2ulong(Size), $int2ulong(0), $int2ulong(0), 
        DINode.DIFlags.FlagArtificial, getOrCreateVTablePtrType(Unit));
    EltTys.push_back(VPTR);
  }

  /// @}
  
  /// Create a new lexical block node and push it on the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateLexicalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2987,
   FQN="clang::CodeGen::CGDebugInfo::CreateLexicalBlock", NM="_ZN5clang7CodeGen11CGDebugInfo18CreateLexicalBlockENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo18CreateLexicalBlockENS_14SourceLocationE")
  //</editor-fold>
  private void CreateLexicalBlock(SourceLocation Loc) {
    MDNode /*P*/ Back = null;
    if (!LexicalBlockStack.empty()) {
      Back = LexicalBlockStack.back().get();
    }
    LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>(DBuilder.createLexicalBlock(cast_DIScope(Back), getOrCreateFile(new SourceLocation(CurLoc)), getLineNumber(new SourceLocation(CurLoc)), 
            getColumnNumber(new SourceLocation(CurLoc)))));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CGDebugInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 47,
   FQN="clang::CodeGen::CGDebugInfo::CGDebugInfo", NM="_ZN5clang7CodeGen11CGDebugInfoC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfoC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CGDebugInfo(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), DebugKind(CGM.getCodeGenOpts().getDebugInfo()), DebugTypeExtRefs(CGM.getCodeGenOpts().DebugTypeExtRefs), DBuilder(CGM.getModule()), TheCU(null), ClangModuleMap(null), PCHDescriptor(), CurLoc(), VTablePtrType(null), ClassTy(null), ObjTy(null), SelTy(null), OCLImage1dROTy(null), OCLImage1dArrayROTy(null), OCLImage1dBufferROTy(null), OCLImage2dROTy(null), OCLImage2dArrayROTy(null), OCLImage2dDepthROTy(null), OCLImage2dArrayDepthROTy(null), OCLImage2dMSAAROTy(null), OCLImage2dArrayMSAAROTy(null), OCLImage2dMSAADepthROTy(null), OCLImage2dArrayMSAADepthROTy(null), OCLImage3dROTy(null), OCLImage1dWOTy(null), OCLImage1dArrayWOTy(null), OCLImage1dBufferWOTy(null), OCLImage2dWOTy(null), OCLImage2dArrayWOTy(null), OCLImage2dDepthWOTy(null), OCLImage2dArrayDepthWOTy(null), OCLImage2dMSAAWOTy(null), OCLImage2dArrayMSAAWOTy(null), OCLImage2dMSAADepthWOTy(null), OCLImage2dArrayMSAADepthWOTy(null), OCLImage3dWOTy(null), OCLImage1dRWTy(null), OCLImage1dArrayRWTy(null), OCLImage1dBufferRWTy(null), OCLImage2dRWTy(null), OCLImage2dArrayRWTy(null), OCLImage2dDepthRWTy(null), OCLImage2dArrayDepthRWTy(null), OCLImage2dMSAARWTy(null), OCLImage2dArrayMSAARWTy(null), OCLImage2dMSAADepthRWTy(null), OCLImage2dArrayMSAADepthRWTy(null), OCLImage3dRWTy(null), OCLEventDITy(null), OCLClkEventDITy(null), OCLQueueDITy(null), OCLNDRangeDITy(null), OCLReserveIDDITy(null), TypeCache(), DebugPrefixMap(), ObjCInterfaceCache(), ModuleCache(), RetainedTypes(), ReplaceMap(), FwdDeclReplaceMap(), LexicalBlockStack(), RegionMap(), FnBeginRegionCount(), DebugInfoNames(), CWDName(), DIFileCache(), SPCache(), DeclCache(), NameSpaceCache(), NamespaceAliasCache(), StaticDataMemberCache() 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.DebugKind = CGM.getCodeGenOpts().getDebugInfo();
    this.DebugTypeExtRefs = CGM.getCodeGenOpts().DebugTypeExtRefs;
    this.DBuilder = new DIBuilder(CGM.getModule());
    /*InClass*/this.TheCU = null;
    /*InClass*/this.ClangModuleMap = null;
    this.PCHDescriptor = new ExternalASTSource.ASTSourceDescriptor();
    this.CurLoc = new SourceLocation();
    /*InClass*/this.VTablePtrType = null;
    /*InClass*/this.ClassTy = null;
    /*InClass*/this.ObjTy = create_type$null$ref();
    /*InClass*/this.SelTy = null;
    /*InClass*/this.OCLImage1dROTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dArrayROTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dBufferROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dDepthROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayDepthROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dMSAAROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayMSAAROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dMSAADepthROTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayMSAADepthROTy = create_type$null$ref();
    /*InClass*/this.OCLImage3dROTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dArrayWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dBufferWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dDepthWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayDepthWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dMSAAWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayMSAAWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dMSAADepthWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayMSAADepthWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage3dWOTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dArrayRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage1dBufferRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dDepthRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayDepthRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dMSAARWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayMSAARWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dMSAADepthRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage2dArrayMSAADepthRWTy = create_type$null$ref();
    /*InClass*/this.OCLImage3dRWTy = create_type$null$ref();
    /*InClass*/this.OCLEventDITy = create_type$null$ref();
    /*InClass*/this.OCLClkEventDITy = create_type$null$ref();
    /*InClass*/this.OCLQueueDITy = create_type$null$ref();
    /*InClass*/this.OCLNDRangeDITy = create_type$null$ref();
    /*InClass*/this.OCLReserveIDDITy = create_type$null$ref();
    this.TypeCache = new DenseMap</*const*/Object/*void P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.DebugPrefixMap = new SmallDenseMap<StringRef, StringRef>(new DenseMapInfoStringRef(), new StringRef());
    this.ObjCInterfaceCache = new SmallVector<ObjCInterfaceCacheEntry>(32, new ObjCInterfaceCacheEntry());
    this.ModuleCache = new DenseMap</*const*/ org.clang.basic.Module /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.RetainedTypes = new std.vector<Object/*void P*/ >((Object/*void P*/ )null);
    this.ReplaceMap = new std.vector<std.pair</*const*/ TagType /*P*/ , TrackingMDRef>>(new std.pairPtrType</*const*/ TagType /*P*/ , TrackingMDRef>(null, new TrackingMDRef()));
    this.FwdDeclReplaceMap = new std.vector<std.pair</*const*/ DeclaratorDecl /*P*/ , TrackingMDRef>>(new std.pairPtrType</*const*/ DeclaratorDecl /*P*/ , TrackingMDRef>(null, new TrackingMDRef()));
    this.LexicalBlockStack = new std.vector<TypedTrackingMDRef<DIScope>>(new TypedTrackingMDRef<DIScope>());
    this.RegionMap = new DenseMap</*const*/ Decl /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.FnBeginRegionCount = new std.vectorUInt/*uint*/();
    this.DebugInfoNames = new BumpPtrAllocatorImpl();
    this.CWDName = new StringRef();
    this.DIFileCache = new DenseMap</*const*/char$ptr/*char P*/, TrackingMDRef>(DenseMapInfoVoid$Ptr.$Info(), new TrackingMDRef());
    this.SPCache = new DenseMap</*const*/ FunctionDecl /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.DeclCache = new DenseMap</*const*/ Decl /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.NameSpaceCache = new DenseMap</*const*/ NamespaceDecl /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.NamespaceAliasCache = new DenseMap</*const*/ NamespaceAliasDecl /*P*/ , TrackingMDRef>(DenseMapInfo$LikePtr.$Info(), new TrackingMDRef());
    this.StaticDataMemberCache = new DenseMap</*const*/ Decl /*P*/ , TypedTrackingMDRef<DIDerivedType>>(DenseMapInfo$LikePtr.$Info(), new TypedTrackingMDRef<DIDerivedType>());
    //END JInit
    for (final /*const*/ std.pair</*const*/std.string, std.string> /*&*/ KV : CGM.getCodeGenOpts().DebugPrefixMap)  {
      DebugPrefixMap.$at_T1$RR(new StringRef(KV.first)).$assignMove(new StringRef(KV.second));
    }
    CreateCompileUnit();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::~CGDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 56,
   FQN="clang::CodeGen::CGDebugInfo::~CGDebugInfo", NM="_ZN5clang7CodeGen11CGDebugInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (LexicalBlockStack.empty()) : "Region stack mismatch, stack not empty!";
    //START JDestroy
    StaticDataMemberCache.$destroy();
    NamespaceAliasCache.$destroy();
    NameSpaceCache.$destroy();
    DeclCache.$destroy();
    SPCache.$destroy();
    DIFileCache.$destroy();
    DebugInfoNames.$destroy();
    FnBeginRegionCount.$destroy();
    RegionMap.$destroy();
    LexicalBlockStack.$destroy();
    FwdDeclReplaceMap.$destroy();
    ReplaceMap.$destroy();
    RetainedTypes.$destroy();
    ModuleCache.$destroy();
    ObjCInterfaceCache.$destroy();
    DebugPrefixMap.$destroy();
    TypeCache.$destroy();
    DBuilder.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::finalize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3715,
   FQN="clang::CodeGen::CGDebugInfo::finalize", NM="_ZN5clang7CodeGen11CGDebugInfo8finalizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo8finalizeEv")
  //</editor-fold>
  public void finalize() {
    // Creating types might create further types - invalidating the current
    // element and the size(), so don't cache/reference them.
    for (/*size_t*/int i = 0; i != ObjCInterfaceCache.size(); ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ObjCInterfaceCacheEntry E = new ObjCInterfaceCacheEntry(ObjCInterfaceCache.$at(i));
        DIType /*P*/ Ty = (E.Type.getDecl().getDefinition() != null) ? CreateTypeDefinition(E.Type, E.Unit) : E.Decl;
        $c$.clean(DBuilder.replaceTemporary($c$.track(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(new std.unique_ptr_with_deleter<DIType /*, TempMDNodeDeleter*/>(E.Decl)))), Ty));
      } finally {
        $c$.$destroy();
      }
    }
    
    for (std.pair</*const*/ TagType /*P*/ , TrackingMDRef> p : ReplaceMap) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert Native.$bool((p.second).$Metadata$P());
        DIType /*P*/ Ty = cast_DIType(p.second.$star());
        assert (Ty.isForwardDecl());
        
        DenseMapIterator</*const*/Object/*void P*/ , TrackingMDRef> it = TypeCache.find(p.first);
        assert (it.$noteq(/*NO_ITER_COPY*/TypeCache.end()));
        assert Native.$bool((it.$arrow().second).$Metadata$P());
        
        $c$.clean(DBuilder.replaceTemporary($c$.track(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(new std.unique_ptr_with_deleter<DIType /*, TempMDNodeDeleter*/>(Ty)))), 
            cast_DIType(it.$arrow().second.$star())));
      } finally {
        $c$.$destroy();
      }
    }
    
    for (final /*const*/ std.pair</*const*/ DeclaratorDecl /*P*/ , TrackingMDRef> /*&*/ p : FwdDeclReplaceMap) {
      std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/> FwdDecl = null;
      try {
        assert Native.$bool((p.second).$Metadata$P());
        FwdDecl/*J*/= new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(cast_MDNode(p.second.$star()));
        Metadata /*P*/ Repl;
        
        DenseMapIterator</*const*/ Decl /*P*/ , TrackingMDRef> it = DeclCache.find(p.first);
        // If there has been no definition for the declaration, call RAUW
        // with ourselves, that will destroy the temporary MDNode and
        // replace it with a standard one, avoiding leaking memory.
        if (it.$eq(/*NO_ITER_COPY*/DeclCache.end())) {
          Repl = p.second.$Metadata$P();
        } else {
          Repl = it.$arrow().second.$Metadata$P();
        }
        
        DBuilder.replaceTemporary(std.move(FwdDecl), cast_MDNode(Repl));
      } finally {
        if (FwdDecl != null) { FwdDecl.$destroy(); }
      }
    }
    
    // We keep our own list of retained types, because we need to look
    // up the final type in the type cache.
    for (Object/*void P&*/ RT : RetainedTypes)  {
      {
        TrackingMDRef MD = null;
        try {
          MD = new TrackingMDRef(TypeCache.$at_T1$RR(RT));
          if (((MD.$Metadata$P()) != null)) {
            DBuilder.retainType(cast_DIType(MD.$star()));
          }
        } finally {
          if (MD != null) { MD.$destroy(); }
        }
      }
    }
    
    DBuilder.finalize();
  }

  
  /// Module debugging: Support for building PCMs.
  /// @{
  /// Set the main CU's DwoId field to \p Signature.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::setDwoId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3709,
   FQN="clang::CodeGen::CGDebugInfo::setDwoId", NM="_ZN5clang7CodeGen11CGDebugInfo8setDwoIdEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo8setDwoIdEy")
  //</editor-fold>
  public void setDwoId(long/*uint64_t*/ Signature) {
    assert ((TheCU != null)) : "no main compile unit";
    TheCU.setDWOId(Signature);
  }

  
  /// When generating debug information for a clang module or
  /// precompiled header, this module map will be used to determine
  /// the module of origin of each Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::setModuleMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 284,
   FQN="clang::CodeGen::CGDebugInfo::setModuleMap", NM="_ZN5clang7CodeGen11CGDebugInfo12setModuleMapERNS_9ModuleMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo12setModuleMapERNS_9ModuleMapE")
  //</editor-fold>
  public void setModuleMap(final ModuleMap /*&*/ MMap) {
    ClangModuleMap = $AddrOf(MMap);
  }

  
  /// When generating debug information for a clang module or
  /// precompiled header, this module map will be used to determine
  /// the module of origin of each Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::setPCHDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 289,
   FQN="clang::CodeGen::CGDebugInfo::setPCHDescriptor", NM="_ZN5clang7CodeGen11CGDebugInfo16setPCHDescriptorENS_17ExternalASTSource19ASTSourceDescriptorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo16setPCHDescriptorENS_17ExternalASTSource19ASTSourceDescriptorE")
  //</editor-fold>
  public void setPCHDescriptor(ExternalASTSource.ASTSourceDescriptor PCH) {
    PCHDescriptor.$assign(PCH);
  }

  /// @}
  
  /// Update the current source location. If \arg loc is invalid it is
  /// ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::setLocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 122,
   FQN="clang::CodeGen::CGDebugInfo::setLocation", NM="_ZN5clang7CodeGen11CGDebugInfo11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation Loc) {
    // If the new location isn't valid return.
    if (Loc.isInvalid()) {
      return;
    }
    
    CurLoc.$assignMove(CGM.getContext().getSourceManager().getExpansionLoc(/*NO_COPY*/Loc));
    
    // If we've changed files in the middle of a lexical scope go ahead
    // and create a new lexical scope with file node if it's different
    // from the one in the scope.
    if (LexicalBlockStack.empty()) {
      return;
    }
    
    final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
    DIScope /*P*/ Scope = cast_DIScope(LexicalBlockStack.back().$star());
    PresumedLoc PCLoc = SM.getPresumedLoc(/*NO_COPY*/CurLoc);
    if (PCLoc.isInvalid() || $eq_StringRef(Scope.getFilename(), /*STRINGREF_STR*/PCLoc.getFilename())) {
      return;
    }
    {
      
      DILexicalBlockFile /*P*/ LBF = dyn_cast_DILexicalBlockFile(Scope);
      if ((LBF != null)) {
        LexicalBlockStack.pop_back();
        LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>(DBuilder.createLexicalBlockFile(LBF.getScope(), getOrCreateFile(new SourceLocation(CurLoc)))));
      } else if (isa_DILexicalBlock(Scope)
         || isa_DISubprogram(Scope)) {
        LexicalBlockStack.pop_back();
        LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>(DBuilder.createLexicalBlockFile(Scope, getOrCreateFile(new SourceLocation(CurLoc)))));
      }
    }
  }

  
  /// Emit metadata to indicate a change in line/column information in
  /// the source file. If the location is invalid, the previous
  /// location will be reused.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2975,
   FQN="clang::CodeGen::CGDebugInfo::EmitLocation", NM="_ZN5clang7CodeGen11CGDebugInfo12EmitLocationERNS0_11CGBuilderTyENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo12EmitLocationERNS0_11CGBuilderTyENS_14SourceLocationE")
  //</editor-fold>
  public void EmitLocation(final CGBuilderTy /*&*/ Builder, SourceLocation Loc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Update our current location
      setLocation(new SourceLocation(Loc));
      if (CurLoc.isInvalid() || CurLoc.isMacroID()) {
        return;
      }
      
      MDNode /*P*/ Scope = LexicalBlockStack.back().$T$P();
      Builder.SetCurrentDebugLocation($c$.track(DebugLoc.get(getLineNumber(new SourceLocation(CurLoc)), getColumnNumber(new SourceLocation(CurLoc)), Scope))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Emit a call to llvm.dbg.function.start to indicate
  /// start of a new function.
  /// \param Loc       The location of the function header.
  /// \param ScopeLoc  The location of the function body.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitFunctionStart">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2857,
   FQN="clang::CodeGen::CGDebugInfo::EmitFunctionStart", NM="_ZN5clang7CodeGen11CGDebugInfo17EmitFunctionStartENS_10GlobalDeclENS_14SourceLocationES3_NS_8QualTypeEPN4llvm8FunctionERNS0_11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17EmitFunctionStartENS_10GlobalDeclENS_14SourceLocationES3_NS_8QualTypeEPN4llvm8FunctionERNS0_11CGBuilderTyE")
  //</editor-fold>
  public void EmitFunctionStart(GlobalDecl GD, SourceLocation Loc, 
                   SourceLocation ScopeLoc, QualType FnType, 
                   Function /*P*/ Fn, final CGBuilderTy /*&*/ Builder) {
    
    StringRef Name/*J*/= new StringRef();
    StringRef LinkageName/*J*/= new StringRef();
    
    FnBeginRegionCount.push_back_T$RR(LexicalBlockStack.size());
    
    /*const*/ Decl /*P*/ D = GD.getDecl();
    boolean HasDecl = (D != null);
    
    uint$ref Flags = create_uint$ref(0);
    DIFile /*P*/ Unit = getOrCreateFile(new SourceLocation(Loc));
    type$ref<DIScope /*P*/ > FDContext = create_type$ref(Unit);
    MDTupleTypedArrayWrapper<DINode> TParamsArray/*J*/= new MDTupleTypedArrayWrapper<DINode>(DINode.class);
    if (!HasDecl) {
      // Use llvm function name.
      LinkageName.$assignMove(Fn.getName());
    } else {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        // If there is a subprogram for this function available then use it.
        DenseMapIterator</*const*/ FunctionDecl /*P*/ , TrackingMDRef> FI = SPCache.find(FD.getCanonicalDecl$Const());
        if (FI.$noteq(/*NO_ITER_COPY*/SPCache.end())) {
          DISubprogram /*P*/ SP = dyn_cast_or_null_DISubprogram(FI.$arrow().second.$star());
          if ((SP != null) && SP.isDefinition()) {
            LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>(SP));
            RegionMap.$at_T1$C$R(D).reset(SP);
            return;
          }
        }
        collectFunctionDeclProps(new GlobalDecl(GD), Unit, Name, LinkageName, FDContext, 
            TParamsArray, Flags);
      } else {
        /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(D);
        if ((OMD != null)) {
          Name.$assignMove(getObjCMethodName(OMD));
          Flags.$set$orassign(DINode.DIFlags.FlagPrototyped);
        } else {
          // Use llvm function name.
          Name.$assignMove(Fn.getName());
          Flags.$set$orassign(DINode.DIFlags.FlagPrototyped);
        }
      }
    }
    if (Name.startswith(/*STRINGREF_STR*/"\001")) {
      Name.$assignMove(Name.substr(1));
    }
    if (!HasDecl || D.isImplicit()) {
      Flags.$set$orassign(DINode.DIFlags.FlagArtificial);
      // Artificial functions without a location should not silently reuse CurLoc.
      if (Loc.isInvalid()) {
        CurLoc.$assignMove(new SourceLocation());
      }
    }
    /*uint*/int LineNo = getLineNumber(new SourceLocation(Loc));
    /*uint*/int ScopeLine = getLineNumber(new SourceLocation(ScopeLoc));
    
    // FIXME: The function declaration we're constructing here is mostly reusing
    // declarations from CXXMethodDecl and not constructing new ones for arbitrary
    // FunctionDecls. When/if we fix this we can have FDContext be TheCU/null for
    // all subprograms instead of the actual context since subprogram definitions
    // are emitted as CU level entities by the backend.
    DISubprogram /*P*/ SP = DBuilder.createFunction(FDContext.$deref(), new StringRef(Name), new StringRef(LinkageName), Unit, LineNo, 
        getOrCreateFunctionType(D, new QualType(FnType), Unit), Fn.hasLocalLinkage(), 
        true/*definition*/, ScopeLine, Flags.$deref(), CGM.getLangOpts().Optimize, 
        new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, TParamsArray.get()), getFunctionDeclaration(D));
    Fn.setSubprogram(SP);
    // We might get here with a VarDecl in the case we're generating
    // code for the initialization of globals. Do not record these decls
    // as they will overwrite the actual VarDecl Decl in the cache.
    if (HasDecl && isa_FunctionDecl(D)) {
      DeclCache.$at_T1$RR(D.getCanonicalDecl$Const()).reset(SP);
    }
    
    // Push the function onto the lexical block stack.
    LexicalBlockStack.emplace_back(new TypedTrackingMDRef<DIScope>(SP));
    if (HasDecl) {
      RegionMap.$at_T1$C$R(D).reset(SP);
    }
  }

  
  /// Emit debug info for a function declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2933,
   FQN="clang::CodeGen::CGDebugInfo::EmitFunctionDecl", NM="_ZN5clang7CodeGen11CGDebugInfo16EmitFunctionDeclENS_10GlobalDeclENS_14SourceLocationENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo16EmitFunctionDeclENS_10GlobalDeclENS_14SourceLocationENS_8QualTypeE")
  //</editor-fold>
  public void EmitFunctionDecl(GlobalDecl GD, SourceLocation Loc, 
                  QualType FnType) {
    StringRef Name/*J*/= new StringRef();
    StringRef LinkageName/*J*/= new StringRef();
    
    /*const*/ Decl /*P*/ D = GD.getDecl();
    if (!(D != null)) {
      return;
    }
    
    uint$ref Flags = create_uint$ref(0);
    DIFile /*P*/ Unit = getOrCreateFile(new SourceLocation(Loc));
    type$ref<DIScope /*P*/ > FDContext = create_type$ref(getDeclContextDescriptor(D));
    MDTupleTypedArrayWrapper<DINode> TParamsArray/*J*/= new MDTupleTypedArrayWrapper<DINode>(DINode.class);
    if (isa_FunctionDecl(D)) {
      // If there is a DISubprogram for this function available then use it.
      collectFunctionDeclProps(new GlobalDecl(GD), Unit, Name, LinkageName, FDContext, 
          TParamsArray, Flags);
    } else {
      /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(D);
      if ((OMD != null)) {
        Name.$assignMove(getObjCMethodName(OMD));
        Flags.$set$orassign(DINode.DIFlags.FlagPrototyped);
      } else {
        throw new llvm_unreachable("not a function or ObjC method");
      }
    }
    if (!Name.empty() && Name.$at(0) == $$SOH) {
      Name.$assignMove(Name.substr(1));
    }
    if (D.isImplicit()) {
      Flags.$set$orassign(DINode.DIFlags.FlagArtificial);
      // Artificial functions without a location should not silently reuse CurLoc.
      if (Loc.isInvalid()) {
        CurLoc.$assignMove(new SourceLocation());
      }
    }
    /*uint*/int LineNo = getLineNumber(new SourceLocation(Loc));
    /*uint*/int ScopeLine = 0;
    
    DBuilder.retainType(DBuilder.createFunction(FDContext.$deref(), new StringRef(Name), new StringRef(LinkageName), Unit, LineNo, 
            getOrCreateFunctionType(D, new QualType(FnType), Unit), false/*internalLinkage*/, 
            false/*definition*/, ScopeLine, Flags.$deref(), CGM.getLangOpts().Optimize, 
            new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, TParamsArray.get()), getFunctionDeclaration(D)));
  }

  
  /// Constructs the debug code for exiting a function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitFunctionEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3025,
   FQN="clang::CodeGen::CGDebugInfo::EmitFunctionEnd", NM="_ZN5clang7CodeGen11CGDebugInfo15EmitFunctionEndERNS0_11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15EmitFunctionEndERNS0_11CGBuilderTyE")
  //</editor-fold>
  public void EmitFunctionEnd(final CGBuilderTy /*&*/ Builder) {
    assert (!LexicalBlockStack.empty()) : "Region stack mismatch, stack empty!";
    /*uint*/int RCount = FnBeginRegionCount.back();
    assert ($lesseq_uint(RCount, LexicalBlockStack.size())) : "Region stack mismatch";
    
    // Pop all regions for this function.
    while (LexicalBlockStack.size() != RCount) {
      // Provide an entry in the line table for the end of the block.
      EmitLocation(Builder, new SourceLocation(CurLoc));
      LexicalBlockStack.pop_back();
    }
    FnBeginRegionCount.pop_back();
  }

  
  /// Emit metadata to indicate the beginning of a new lexical block
  /// and push the block onto the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitLexicalBlockStart">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2996,
   FQN="clang::CodeGen::CGDebugInfo::EmitLexicalBlockStart", NM="_ZN5clang7CodeGen11CGDebugInfo21EmitLexicalBlockStartERNS0_11CGBuilderTyENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21EmitLexicalBlockStartERNS0_11CGBuilderTyENS_14SourceLocationE")
  //</editor-fold>
  public void EmitLexicalBlockStart(final CGBuilderTy /*&*/ Builder, 
                       SourceLocation Loc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Set our current location.
      setLocation(new SourceLocation(Loc));
      
      // Emit a line table change for the current location inside the new scope.
      Builder.SetCurrentDebugLocation($c$.track(DebugLoc.get(getLineNumber(new SourceLocation(Loc)), getColumnNumber(new SourceLocation(Loc)), LexicalBlockStack.back().$T$P()))); $c$.clean();
      if (DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
        return;
      }
      
      // Create a new lexical block and push it on the stack.
      CreateLexicalBlock(new SourceLocation(Loc));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Emit metadata to indicate the end of a new lexical block and pop
  /// the current block.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitLexicalBlockEnd">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3012,
   FQN="clang::CodeGen::CGDebugInfo::EmitLexicalBlockEnd", NM="_ZN5clang7CodeGen11CGDebugInfo19EmitLexicalBlockEndERNS0_11CGBuilderTyENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo19EmitLexicalBlockEndERNS0_11CGBuilderTyENS_14SourceLocationE")
  //</editor-fold>
  public void EmitLexicalBlockEnd(final CGBuilderTy /*&*/ Builder, 
                     SourceLocation Loc) {
    assert (!LexicalBlockStack.empty()) : "Region stack mismatch, stack empty!";
    
    // Provide an entry in the line table for the end of the block.
    EmitLocation(Builder, new SourceLocation(Loc));
    if (DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      return;
    }
    
    LexicalBlockStack.pop_back();
  }

  
  /// Emit call to \c llvm.dbg.declare for an automatic variable
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitDeclareOfAutoVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3239,
   FQN="clang::CodeGen::CGDebugInfo::EmitDeclareOfAutoVariable", NM="_ZN5clang7CodeGen11CGDebugInfo25EmitDeclareOfAutoVariableEPKNS_7VarDeclEPN4llvm5ValueERNS0_11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo25EmitDeclareOfAutoVariableEPKNS_7VarDeclEPN4llvm5ValueERNS0_11CGBuilderTyE")
  //</editor-fold>
  public void EmitDeclareOfAutoVariable(/*const*/ VarDecl /*P*/ VD, 
                           Value /*P*/ Storage, 
                           final CGBuilderTy /*&*/ Builder) {
    assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
    EmitDeclare(VD, Storage, new OptionalUInt(llvm.None), Builder);
  }

  
  /// Emit call to \c llvm.dbg.declare for an imported variable
  /// declaration in a block.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitDeclareOfBlockDeclRefVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3254,
   FQN="clang::CodeGen::CGDebugInfo::EmitDeclareOfBlockDeclRefVariable", NM="_ZN5clang7CodeGen11CGDebugInfo33EmitDeclareOfBlockDeclRefVariableEPKNS_7VarDeclEPN4llvm5ValueERNS0_11CGBuilderTyERKNS0_11CGBlockInfoEPNS5_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo33EmitDeclareOfBlockDeclRefVariableEPKNS_7VarDeclEPN4llvm5ValueERNS0_11CGBuilderTyERKNS0_11CGBlockInfoEPNS5_11InstructionE")
  //</editor-fold>
  public void EmitDeclareOfBlockDeclRefVariable(/*const*/ VarDecl /*P*/ VD, Value /*P*/ Storage, final CGBuilderTy /*&*/ Builder, 
                                   final /*const*/ CGBlockInfo /*&*/ blockInfo) {
    EmitDeclareOfBlockDeclRefVariable(VD, Storage, Builder, 
                                   blockInfo, (Instruction /*P*/ )null);
  }
  public void EmitDeclareOfBlockDeclRefVariable(/*const*/ VarDecl /*P*/ VD, Value /*P*/ Storage, final CGBuilderTy /*&*/ Builder, 
                                   final /*const*/ CGBlockInfo /*&*/ blockInfo, Instruction /*P*/ InsertPoint/*= null*/) {
    DebugLoc DL = null;
    try {
      assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
      assert (!LexicalBlockStack.empty()) : "Region stack mismatch, stack empty!";
      if (Builder.GetInsertBlock() == null) {
        return;
      }
      if (VD.hasAttr(NoDebugAttr.class)) {
        return;
      }
      
      boolean isByRef = VD.hasAttr(BlocksAttr.class);
      
      ulong$ptr XOffset = create_ulong$ptr($int2ulong(0));
      DIFile /*P*/ Unit = getOrCreateFile(VD.getLocation());
      DIType /*P*/ Ty;
      if (isByRef) {
        Ty = EmitTypeForVarWithBlocksAttr(VD, $AddrOf(XOffset));
      } else {
        Ty = getOrCreateType(VD.getType(), Unit);
      }
      
      // Self is passed along as an implicit non-arg variable in a
      // block. Mark it as the object pointer.
      if (isa_ImplicitParamDecl(VD) && $eq_StringRef(VD.getName(), /*STRINGREF_STR*/"self")) {
        Ty = CreateSelfType(VD.getType(), Ty);
      }
      
      // Get location information.
      /*uint*/int Line = getLineNumber(VD.getLocation());
      /*uint*/int Column = getColumnNumber(VD.getLocation());
      
      final /*const*/ DataLayout /*&*/ target = CGM.getDataLayout();
      
      CharUnits offset = CharUnits.fromQuantity(target.getStructLayout(blockInfo.StructureType).
              getElementOffset(blockInfo.getCapture$Const(VD).getIndex()));
      
      SmallVectorLong addr/*J*/= new SmallVectorLong(9, (long/*int64_t*/)0);
      if (isa_AllocaInst(Storage)) {
        addr.push_back($uint2llong(LocationAtom.DW_OP_deref));
      }
      addr.push_back($uint2llong(LocationAtom.DW_OP_plus));
      addr.push_back(offset.getQuantity());
      if (isByRef) {
        addr.push_back($uint2llong(LocationAtom.DW_OP_deref));
        addr.push_back($uint2llong(LocationAtom.DW_OP_plus));
        // offset of __forwarding field
        offset.$assignMove(
            CGM.getContext().toCharUnitsFromBits($uint2long(target.getPointerSizeInBits(0)))
        );
        addr.push_back(offset.getQuantity());
        addr.push_back($uint2llong(LocationAtom.DW_OP_deref));
        addr.push_back($uint2llong(LocationAtom.DW_OP_plus));
        // offset of x field
        offset.$assignMove(CGM.getContext().toCharUnitsFromBits(XOffset.$star()));
        addr.push_back(offset.getQuantity());
      }
      
      // Create the descriptor for the variable.
      DILocalVariable /*P*/ D = DBuilder.createAutoVariable(cast_DILocalScope(LexicalBlockStack.back().$star()), VD.getName(), Unit, 
          Line, Ty);
      
      // Insert an llvm.dbg.declare into the current block.
      DL = DebugLoc.get(Line, Column, LexicalBlockStack.back().$T$P());
      if ((InsertPoint != null)) {
        DBuilder.insertDeclare_2(Storage, D, DBuilder.createExpression(new ArrayRefLong(addr)), DL.$DILocation$P(), 
            InsertPoint);
      } else {
        DBuilder.insertDeclare_1(Storage, D, DBuilder.createExpression(new ArrayRefLong(addr)), DL.$DILocation$P(), 
            Builder.GetInsertBlock());
      }
    } finally {
      if (DL != null) { DL.$destroy(); }
    }
  }

  
  /// Emit call to \c llvm.dbg.declare for an argument variable
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitDeclareOfArgVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3324,
   FQN="clang::CodeGen::CGDebugInfo::EmitDeclareOfArgVariable", NM="_ZN5clang7CodeGen11CGDebugInfo24EmitDeclareOfArgVariableEPKNS_7VarDeclEPN4llvm5ValueEjRNS0_11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24EmitDeclareOfArgVariableEPKNS_7VarDeclEPN4llvm5ValueEjRNS0_11CGBuilderTyE")
  //</editor-fold>
  public void EmitDeclareOfArgVariable(/*const*/ VarDecl /*P*/ VD, Value /*P*/ AI, 
                          /*uint*/int ArgNo, 
                          final CGBuilderTy /*&*/ Builder) {
    assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
    EmitDeclare(VD, AI, new OptionalUInt(JD$T$C$R.INSTANCE, ArgNo), Builder);
  }

  
  /// Emit call to \c llvm.dbg.declare for the block-literal argument
  /// to a block invocation function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitDeclareOfBlockLiteralArgVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3341,
   FQN="clang::CodeGen::CGDebugInfo::EmitDeclareOfBlockLiteralArgVariable", NM="_ZN5clang7CodeGen11CGDebugInfo36EmitDeclareOfBlockLiteralArgVariableERKNS0_11CGBlockInfoEPN4llvm5ValueEjS7_RNS0_11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo36EmitDeclareOfBlockLiteralArgVariableERKNS0_11CGBlockInfoEPN4llvm5ValueEjS7_RNS0_11CGBuilderTyE")
  //</editor-fold>
  public void EmitDeclareOfBlockLiteralArgVariable(final /*const*/ CGBlockInfo /*&*/ block, 
                                      Value /*P*/ Arg, 
                                      /*uint*/int ArgNo, 
                                      Value /*P*/ LocalAddr, 
                                      final CGBuilderTy /*&*/ Builder) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
      final ASTContext /*&*/ C = CGM.getContext();
      /*const*/ BlockDecl /*P*/ blockDecl = block.getBlockDecl();
      
      // Collect some general information about the block's location.
      SourceLocation loc = blockDecl.getCaretLocation();
      DIFile /*P*/ tunit = getOrCreateFile(new SourceLocation(loc));
      /*uint*/int line = getLineNumber(new SourceLocation(loc));
      /*uint*/int column = getColumnNumber(new SourceLocation(loc));
      
      // Build the debug-info type for the block literal.
      getDeclContextDescriptor(blockDecl);
      
      /*const*/ StructLayout /*P*/ blockLayout = CGM.getDataLayout().getStructLayout(block.StructureType);
      
      SmallVector<Metadata /*P*/ > fields/*J*/= new SmallVector<Metadata /*P*/ >(16, (Metadata /*P*/ )null);
      fields.push_back(createFieldType(new StringRef(/*KEEP_STR*/"__isa"), C.VoidPtrTy.$QualType(), new SourceLocation(loc), AccessSpecifier.AS_public, 
              blockLayout.getElementOffsetInBits(0), 
              tunit, tunit));
      fields.push_back(createFieldType(new StringRef(/*KEEP_STR*/"__flags"), C.IntTy.$QualType(), new SourceLocation(loc), AccessSpecifier.AS_public, 
              blockLayout.getElementOffsetInBits(1), 
              tunit, tunit));
      fields.push_back(createFieldType(new StringRef(/*KEEP_STR*/"__reserved"), C.IntTy.$QualType(), new SourceLocation(loc), AccessSpecifier.AS_public, 
              blockLayout.getElementOffsetInBits(2), 
              tunit, tunit));
      /*const*/ FunctionProtoType /*P*/ FnTy = block.getBlockExpr().getFunctionType();
      QualType FnPtrType = CGM.getContext().getPointerType(FnTy.desugar());
      fields.push_back(createFieldType(new StringRef(/*KEEP_STR*/"__FuncPtr"), new QualType(FnPtrType), new SourceLocation(loc), AccessSpecifier.AS_public, 
              blockLayout.getElementOffsetInBits(3), 
              tunit, tunit));
      fields.push_back(createFieldType(new StringRef(/*KEEP_STR*/"__descriptor"), C.getPointerType(block.NeedsCopyDispose ? C.getBlockDescriptorExtendedType() : C.getBlockDescriptorType()), 
              new SourceLocation(loc), AccessSpecifier.AS_public, blockLayout.getElementOffsetInBits(4), tunit, tunit));
      
      // We want to sort the captures by offset, not because DWARF
      // requires this, but because we're paranoid about debuggers.
      SmallVector<BlockLayoutChunk> chunks/*J*/= new SmallVector<BlockLayoutChunk>(8, new BlockLayoutChunk());
      
      // 'this' capture.
      if (blockDecl.capturesCXXThis()) {
        BlockLayoutChunk chunk/*J*/= new BlockLayoutChunk();
        chunk.OffsetInBits
           = blockLayout.getElementOffsetInBits(block.CXXThisIndex);
        chunk.Capture = null;
        chunks.push_back(chunk);
      }
      
      // Variable captures.
      for (final /*const*/ BlockDecl.Capture /*&*/ capture : blockDecl.captures()) {
        /*const*/ VarDecl /*P*/ variable = capture.getVariable();
        final /*const*/ CGBlockInfo.Capture /*&*/ captureInfo = block.getCapture$Const(variable);
        
        // Ignore constant captures.
        if (captureInfo.isConstant()) {
          continue;
        }
        
        BlockLayoutChunk chunk/*J*/= new BlockLayoutChunk();
        chunk.OffsetInBits
           = blockLayout.getElementOffsetInBits(captureInfo.getIndex());
        chunk.Capture = $AddrOf(capture);
        chunks.push_back(chunk);
      }
      
      // Sort by offset.
      llvm.array_pod_sort(chunks.begin(), chunks.end());
      
      for (final /*const*/ BlockLayoutChunk /*&*/ Chunk : chunks) {
        long/*uint64_t*/ offsetInBits = Chunk.OffsetInBits;
        /*const*/ BlockDecl.Capture /*P*/ capture = Chunk.Capture;
        
        // If we have a null capture, this must be the C++ 'this' capture.
        if (!(capture != null)) {
          QualType type/*J*/= new QualType();
          {
            /*const*/ CXXMethodDecl /*P*/ Method = cast_or_null_CXXMethodDecl(blockDecl.getNonClosureContext$Const());
            if ((Method != null)) {
              type.$assignMove(Method.getThisType(C));
            } else {
              /*const*/ CXXRecordDecl /*P*/ RDecl = dyn_cast_CXXRecordDecl(blockDecl.getParent$Const());
              if ((RDecl != null)) {
                type.$assignMove(new QualType(RDecl.getTypeForDecl(), 0));
              } else {
                throw new llvm_unreachable("unexpected block declcontext");
              }
            }
          }
          
          fields.push_back(createFieldType(new StringRef(/*KEEP_STR*/$this), new QualType(type), new SourceLocation(loc), AccessSpecifier.AS_public, 
                  offsetInBits, tunit, tunit));
          continue;
        }
        
        /*const*/ VarDecl /*P*/ variable = capture.getVariable();
        StringRef name = variable.getName();
        
        DIType /*P*/ fieldType;
        if (capture.isByRef()) {
          TypeInfo PtrInfo = C.getTypeInfo(C.VoidPtrTy.$QualType());
          
          // FIXME: this creates a second copy of this type!
          ulong$ptr xoffset = create_ulong$ptr();
          fieldType = EmitTypeForVarWithBlocksAttr(variable, $AddrOf(xoffset));
          fieldType = DBuilder.createPointerType(fieldType, PtrInfo.Width);
          fieldType
             = DBuilder.createMemberType(tunit, new StringRef(name), tunit, line, PtrInfo.Width, 
              $uint2ulong(PtrInfo.Align), offsetInBits, 0, fieldType);
        } else {
          fieldType = createFieldType(new StringRef(name), variable.getType(), new SourceLocation(loc), AccessSpecifier.AS_public, 
              offsetInBits, tunit, tunit);
        }
        fields.push_back(fieldType);
      }
      
      SmallString/*<36>*/ typeName/*J*/= new SmallString/*<36>*/(36);
      $c$.clean($c$.track(new raw_svector_ostream(typeName)).$out(/*KEEP_STR*/"__block_literal_").$out_int(
          CGM.getUniqueBlockCount()
      ));
      
      MDTupleTypedArrayWrapper<DINode> fieldsArray = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(fields, true));
      
      DIType /*P*/ type = DBuilder.createStructType(tunit, typeName.str(), tunit, line, 
          CGM.getContext().toBits(new CharUnits(block.BlockSize)), 
          CGM.getContext().toBits(new CharUnits(block.BlockAlign)), 0, (DIType /*P*/ )null, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, fieldsArray));
      type = DBuilder.createPointerType(type, $uchar2ulong(CGM.PointerWidthInBits));
      
      // Get overall information about the block.
      /*uint*/int flags = DINode.DIFlags.FlagArtificial;
      DILocalScope /*P*/ scope = cast_DILocalScope(LexicalBlockStack.back().$star());
      
      // Create the descriptor for the parameter.
      DILocalVariable /*P*/ debugVar = DBuilder.createParameterVariable(scope, Arg.getName(), ArgNo, tunit, line, type, 
          CGM.getLangOpts().Optimize, flags);
      if ((LocalAddr != null)) {
        // Insert an llvm.dbg.value into the current block.
        $c$.clean(DBuilder.insertDbgValueIntrinsic_1(LocalAddr, $int2ulong(0), debugVar, DBuilder.createExpression(), 
            $c$.track(DebugLoc.get(line, column, scope)).$DILocation$P(), Builder.GetInsertBlock()));
      }
      
      // Insert an llvm.dbg.declare into the current block.
      $c$.clean(DBuilder.insertDeclare_1(Arg, debugVar, DBuilder.createExpression(), 
          $c$.track(DebugLoc.get(line, column, scope)).$DILocation$P(), 
          Builder.GetInsertBlock()));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Emit information about a global variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitGlobalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3532,
   FQN="clang::CodeGen::CGDebugInfo::EmitGlobalVariable", NM="_ZN5clang7CodeGen11CGDebugInfo18EmitGlobalVariableEPN4llvm14GlobalVariableEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo18EmitGlobalVariableEPN4llvm14GlobalVariableEPKNS_7VarDeclE")
  //</editor-fold>
  public void EmitGlobalVariable(GlobalVariable /*P*/ Var, 
                    /*const*/ VarDecl /*P*/ D) {
    assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
    if (D.hasAttr(NoDebugAttr.class)) {
      return;
    }
    // Create global variable debug descriptor.
    type$ref<DIFile /*P*/ > Unit = create_type$null$ref(null);
    type$ref<DIScope /*P*/ > DContext = create_type$null$ref(null);
    uint$ref LineNo = create_uint$ref();
    StringRef DeclName/*J*/= new StringRef();
    StringRef LinkageName/*J*/= new StringRef();
    QualType T/*J*/= new QualType();
    collectVarDeclProps(D, Unit, LineNo, T, DeclName, LinkageName, DContext);
    
    // Attempt to store one global variable for the declaration - even if we
    // emit a lot of fields.
    DIGlobalVariable /*P*/ GV = null;
    
    // If this is an anonymous union then we'll want to emit a global
    // variable for each member of the anonymous union so that it's possible
    // to find the name of any field in the union.
    if (T.$arrow().isUnionType() && DeclName.empty()) {
      /*const*/ RecordDecl /*P*/ RD = T.$arrow().castAs$RecordType().getDecl();
      assert (RD.isAnonymousStructOrUnion()) : "unnamed non-anonymous struct or union?";
      GV = CollectAnonRecordDecls(RD, Unit.$deref(), LineNo.$deref(), new StringRef(LinkageName), Var, DContext.$deref());
    } else {
      GV = DBuilder.createGlobalVariable(DContext.$deref(), new StringRef(DeclName), new StringRef(LinkageName), Unit.$deref(), LineNo.$deref(), getOrCreateType(new QualType(T), Unit.$deref()), 
          Var.hasLocalLinkage(), Var, 
          getOrCreateStaticDataMemberDeclarationOrNull(D));
    }
    DeclCache.$at_T1$RR(D.getCanonicalDecl$Const()).reset(GV);
  }

  
  /// Emit global variable's debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitGlobalVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3566,
   FQN="clang::CodeGen::CGDebugInfo::EmitGlobalVariable", NM="_ZN5clang7CodeGen11CGDebugInfo18EmitGlobalVariableEPKNS_9ValueDeclEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo18EmitGlobalVariableEPKNS_9ValueDeclEPN4llvm8ConstantE")
  //</editor-fold>
  public void EmitGlobalVariable(/*const*/ ValueDecl /*P*/ VD, 
                    Constant /*P*/ Init) {
    assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
    if (VD.hasAttr(NoDebugAttr.class)) {
      return;
    }
    // Create the descriptor for the variable.
    DIFile /*P*/ Unit = getOrCreateFile(VD.getLocation());
    StringRef Name = VD.getName();
    DIType /*P*/ Ty = getOrCreateType(VD.getType(), Unit);
    {
      /*const*/ EnumConstantDecl /*P*/ ECD = dyn_cast_EnumConstantDecl(VD);
      if ((ECD != null)) {
        /*const*/ EnumDecl /*P*/ ED = cast_EnumDecl(ECD.getDeclContext$Const());
        assert (isa_EnumType(ED.getTypeForDecl())) : "Enum without EnumType?";
        Ty = getOrCreateType(new QualType(ED.getTypeForDecl(), 0), Unit);
      }
    }
    // Do not use global variables for enums.
    //
    // FIXME: why not?
    if (Ty.getTag() == $ushort2uint(Tag.DW_TAG_enumeration_type)) {
      return;
    }
    // Do not emit separate definitions for function local const/statics.
    if (isa_FunctionDecl(VD.getDeclContext$Const())) {
      return;
    }
    VD = cast_ValueDecl(VD.getCanonicalDecl$Const());
    /*const*/ VarDecl /*P*/ VarD = cast_VarDecl(VD);
    if (VarD.isStaticDataMember()) {
      /*const*/ RecordDecl /*P*/ RD = cast_RecordDecl(VarD.getDeclContext$Const());
      getDeclContextDescriptor(VarD);
      // Ensure that the type is retained even though it's otherwise unreferenced.
      //
      // FIXME: This is probably unnecessary, since Ty should reference RD
      // through its scope.
      RetainedTypes.push_back_T$RR(CGM.getContext().getRecordType(RD).getAsOpaquePtr());
      return;
    }
    
    DIScope /*P*/ DContext = getDeclContextDescriptor(VD);
    
    final TrackingMDRef /*&*/ GV = DeclCache.$at_T1$RR(VD);
    if (((GV.$Metadata$P()) != null)) {
      return;
    }
    GV.reset(DBuilder.createGlobalVariable(DContext, new StringRef(Name), new StringRef(), Unit, getLineNumber(VD.getLocation()), Ty, 
            true, Init, getOrCreateStaticDataMemberDeclarationOrNull(VarD)));
  }

  
  /// Emit C++ using directive.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitUsingDirective">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3619,
   FQN="clang::CodeGen::CGDebugInfo::EmitUsingDirective", NM="_ZN5clang7CodeGen11CGDebugInfo18EmitUsingDirectiveERKNS_18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo18EmitUsingDirectiveERKNS_18UsingDirectiveDeclE")
  //</editor-fold>
  public void EmitUsingDirective(final /*const*/ UsingDirectiveDecl /*&*/ UD) {
    if (CGM.getCodeGenOpts().getDebugInfo().getValue() < DebugInfoKind.LimitedDebugInfo.getValue()) {
      return;
    }
    /*const*/ NamespaceDecl /*P*/ NSDecl = UD.getNominatedNamespace$Const();
    if (!NSDecl.isAnonymousNamespace()
       || CGM.getCodeGenOpts().DebugExplicitImport) {
      DBuilder.createImportedModule(getCurrentContextDescriptor(cast_Decl(UD.getDeclContext$Const())), 
          getOrCreateNameSpace(NSDecl), 
          getLineNumber(UD.getLocation()));
    }
  }

  
  /// Emit the type explicitly casted to.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitExplicitCastType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3765,
   FQN="clang::CodeGen::CGDebugInfo::EmitExplicitCastType", NM="_ZN5clang7CodeGen11CGDebugInfo20EmitExplicitCastTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20EmitExplicitCastTypeENS_8QualTypeE")
  //</editor-fold>
  public void EmitExplicitCastType(QualType Ty) {
    if (CGM.getCodeGenOpts().getDebugInfo().getValue() < DebugInfoKind.LimitedDebugInfo.getValue()) {
      return;
    }
    {
      
      DIType /*P*/ DieTy = getOrCreateType(new QualType(Ty), getOrCreateMainFile());
      if ((DieTy != null)) {
        // Don't ignore in case of explicit cast where it is referenced indirectly.
        DBuilder.retainType(DieTy);
      }
    }
  }

  
  /// Emit C++ using declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitUsingDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3632,
   FQN="clang::CodeGen::CGDebugInfo::EmitUsingDecl", NM="_ZN5clang7CodeGen11CGDebugInfo13EmitUsingDeclERKNS_9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo13EmitUsingDeclERKNS_9UsingDeclE")
  //</editor-fold>
  public void EmitUsingDecl(final /*const*/ UsingDecl /*&*/ UD) {
    if (CGM.getCodeGenOpts().getDebugInfo().getValue() < DebugInfoKind.LimitedDebugInfo.getValue()) {
      return;
    }
    assert ((UD.shadow_size() != 0)) : "We shouldn't be codegening an invalid UsingDecl containing no decls";
    // Emitting one decl is sufficient - debuggers can detect that this is an
    // overloaded name & provide lookup for all the overloads.
    final /*const*/ UsingShadowDecl /*&*/ USD = $Deref(UD.shadow_begin().$star());
    {
      
      // FIXME: Skip functions with undeduced auto return type for now since we
      // don't currently have the plumbing for separate declarations & definitions
      // of free functions and mismatched types (auto in the declaration, concrete
      // return type in the definition)
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(USD.getUnderlyingDecl$Const());
      if ((FD != null)) {
        {
          /*const*/ AutoType /*P*/ AT = FD.getType().$arrow().getAs(FunctionProtoType.class).getContainedAutoType();
          if ((AT != null)) {
            if (AT.getDeducedType().isNull()) {
              return;
            }
          }
        }
      }
    }
    {
      DINode /*P*/ Target = getDeclarationOrDefinition(USD.getUnderlyingDecl$Const());
      if ((Target != null)) {
        DBuilder.createImportedDeclaration(getCurrentContextDescriptor(cast_Decl(USD.getDeclContext$Const())), Target, 
            getLineNumber(USD.getLocation()));
      }
    }
  }

  
  /// Emit an @import declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3657,
   FQN="clang::CodeGen::CGDebugInfo::EmitImportDecl", NM="_ZN5clang7CodeGen11CGDebugInfo14EmitImportDeclERKNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo14EmitImportDeclERKNS_10ImportDeclE")
  //</editor-fold>
  public void EmitImportDecl(final /*const*/ ImportDecl /*&*/ ID) {
    if (CGM.getCodeGenOpts().getDebuggerTuning() != DebuggerKind.LLDB) {
      return;
    }
    {
      org.clang.basic.Module /*P*/ M = ID.getImportedModule();
      if ((M != null)) {
        ExternalASTSource.ASTSourceDescriptor Info = new ExternalASTSource.ASTSourceDescriptor($Deref(M));
        DBuilder.createImportedDeclaration(getCurrentContextDescriptor(cast_Decl(ID.getDeclContext$Const())), 
            getOrCreateModuleRef(new ExternalASTSource.ASTSourceDescriptor(Info), DebugTypeExtRefs), 
            getLineNumber(ID.getLocation()));
      }
    }
  }

  
  /// Emit C++ namespace alias.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitNamespaceAlias">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3669,
   FQN="clang::CodeGen::CGDebugInfo::EmitNamespaceAlias", NM="_ZN5clang7CodeGen11CGDebugInfo18EmitNamespaceAliasERKNS_18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo18EmitNamespaceAliasERKNS_18NamespaceAliasDeclE")
  //</editor-fold>
  public DIImportedEntity /*P*/ EmitNamespaceAlias(final /*const*/ NamespaceAliasDecl /*&*/ NA) {
    if (CGM.getCodeGenOpts().getDebugInfo().getValue() < DebugInfoKind.LimitedDebugInfo.getValue()) {
      return null;
    }
    final TrackingMDRef /*&*/ VH = NamespaceAliasCache.$at_T1$RR($AddrOf(NA));
    if (((VH.$Metadata$P()) != null)) {
      return cast_DIImportedEntity(VH.$star());
    }
    DIImportedEntity /*P*/ R;
    {
      /*const*/ NamespaceAliasDecl /*P*/ Underlying = dyn_cast_NamespaceAliasDecl(NA.getAliasedNamespace());
      if ((Underlying != null)) {
        // This could cache & dedup here rather than relying on metadata deduping.
        R = DBuilder.createImportedDeclaration(getCurrentContextDescriptor(cast_Decl(NA.getDeclContext$Const())), 
            EmitNamespaceAlias($Deref(Underlying)), getLineNumber(NA.getLocation()), 
            NA.getName());
      } else {
        R = DBuilder.createImportedDeclaration(getCurrentContextDescriptor(cast_Decl(NA.getDeclContext$Const())), 
            getOrCreateNameSpace(cast_NamespaceDecl(NA.getAliasedNamespace())), 
            getLineNumber(NA.getLocation()), NA.getName());
      }
    }
    VH.reset(R);
    return R;
  }

  
  /// Emit record type's standalone debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateRecordType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1552,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateRecordType", NM="_ZN5clang7CodeGen11CGDebugInfo21getOrCreateRecordTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21getOrCreateRecordTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public DIType /*P*/ getOrCreateRecordType(QualType RTy, 
                       SourceLocation Loc) {
    assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
    DIType /*P*/ T = getOrCreateType(new QualType(RTy), getOrCreateFile(new SourceLocation(Loc)));
    return T;
  }

  
  /// Emit an Objective-C interface type standalone debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1559,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateInterfaceType", NM="_ZN5clang7CodeGen11CGDebugInfo24getOrCreateInterfaceTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24getOrCreateInterfaceTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public DIType /*P*/ getOrCreateInterfaceType(QualType D, 
                          SourceLocation Loc) {
    return getOrCreateStandaloneType(new QualType(D), new SourceLocation(Loc));
  }

  
  /// Emit standalone debug info for a type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateStandaloneType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1564,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateStandaloneType", NM="_ZN5clang7CodeGen11CGDebugInfo25getOrCreateStandaloneTypeENS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo25getOrCreateStandaloneTypeENS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public DIType /*P*/ getOrCreateStandaloneType(QualType D, 
                           SourceLocation Loc) {
    assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
    assert (!D.isNull()) : "null type";
    DIType /*P*/ T = getOrCreateType(new QualType(D), getOrCreateFile(new SourceLocation(Loc)));
    assert ((T != null)) : "could not create debug info for type";
    
    RetainedTypes.push_back_T$RR(D.getAsOpaquePtr());
    return T;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::completeType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1575,
   FQN="clang::CodeGen::CGDebugInfo::completeType", NM="_ZN5clang7CodeGen11CGDebugInfo12completeTypeEPKNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo12completeTypeEPKNS_8EnumDeclE")
  //</editor-fold>
  public void completeType(/*const*/ EnumDecl /*P*/ ED) {
    if (DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      return;
    }
    QualType Ty = CGM.getContext().getEnumType(ED);
    Object/*void P*/ TyPtr = Ty.getAsOpaquePtr();
    DenseMapIterator</*const*/Object/*void P*/ , TrackingMDRef> I = TypeCache.find(TyPtr);
    if (I.$eq(/*NO_ITER_COPY*/TypeCache.end()) || !cast_DIType(I.$arrow().second.$star()).isForwardDecl()) {
      return;
    }
    DIType /*P*/ Res = CreateTypeDefinition(Ty.$arrow().castAs$EnumType());
    assert (!Res.isForwardDecl());
    TypeCache.$at_T1$RR(TyPtr).reset(Res);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::completeType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1588,
   FQN="clang::CodeGen::CGDebugInfo::completeType", NM="_ZN5clang7CodeGen11CGDebugInfo12completeTypeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo12completeTypeEPKNS_10RecordDeclE")
  //</editor-fold>
  public void completeType(/*const*/ RecordDecl /*P*/ RD) {
    if (DebugKind.getValue() > DebugInfoKind.LimitedDebugInfo.getValue()
       || !CGM.getLangOpts().CPlusPlus) {
      completeRequiredType(RD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::completeRequiredType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1594,
   FQN="clang::CodeGen::CGDebugInfo::completeRequiredType", NM="_ZN5clang7CodeGen11CGDebugInfo20completeRequiredTypeEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20completeRequiredTypeEPKNS_10RecordDeclE")
  //</editor-fold>
  public void completeRequiredType(/*const*/ RecordDecl /*P*/ RD) {
    if (DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      return;
    }
    {
      
      /*const*/ CXXRecordDecl /*P*/ CXXDecl = dyn_cast_CXXRecordDecl(RD);
      if ((CXXDecl != null)) {
        if (CXXDecl.isDynamicClass()) {
          return;
        }
      }
    }
    if (DebugTypeExtRefs && RD.isFromASTFile()) {
      return;
    }
    
    QualType Ty = CGM.getContext().getRecordType(RD);
    DIType /*P*/ T = getTypeOrNull(new QualType(Ty));
    if ((T != null) && T.isForwardDecl()) {
      completeClassData(RD);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::completeClassData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1611,
   FQN="clang::CodeGen::CGDebugInfo::completeClassData", NM="_ZN5clang7CodeGen11CGDebugInfo17completeClassDataEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17completeClassDataEPKNS_10RecordDeclE")
  //</editor-fold>
  public void completeClassData(/*const*/ RecordDecl /*P*/ RD) {
    if (DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      return;
    }
    QualType Ty = CGM.getContext().getRecordType(RD);
    Object/*void P*/ TyPtr = Ty.getAsOpaquePtr();
    DenseMapIterator</*const*/Object/*void P*/ , TrackingMDRef> I = TypeCache.find(TyPtr);
    if (I.$noteq(/*NO_ITER_COPY*/TypeCache.end()) && !cast_DIType(I.$arrow().second.$star()).isForwardDecl()) {
      return;
    }
    DIType /*P*/ Res = CreateTypeDefinition(Ty.$arrow().castAs$RecordType());
    assert (!Res.isForwardDecl());
    TypeCache.$at_T1$RR(TyPtr).reset(Res);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::completeTemplateDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2322,
   FQN="clang::CodeGen::CGDebugInfo::completeTemplateDefinition", NM="_ZN5clang7CodeGen11CGDebugInfo26completeTemplateDefinitionERKNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo26completeTemplateDefinitionERKNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public void completeTemplateDefinition(final /*const*/ ClassTemplateSpecializationDecl /*&*/ SD) {
    if (DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      return;
    }
    
    completeClassData($AddrOf(SD));
    // In case this type has no member function definitions being emitted, ensure
    // it is retained
    RetainedTypes.push_back_T$RR(CGM.getContext().getRecordType($AddrOf(SD)).getAsOpaquePtr());
  }

/*private:*/
  /// Emit call to llvm.dbg.declare for a variable declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitDeclare">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3111,
   FQN="clang::CodeGen::CGDebugInfo::EmitDeclare", NM="_ZN5clang7CodeGen11CGDebugInfo11EmitDeclareEPKNS_7VarDeclEPN4llvm5ValueENS5_8OptionalIjEERNS0_11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo11EmitDeclareEPKNS_7VarDeclEPN4llvm5ValueENS5_8OptionalIjEERNS0_11CGBuilderTyE")
  //</editor-fold>
  private void EmitDeclare(/*const*/ VarDecl /*P*/ VD, Value /*P*/ Storage, 
             OptionalUInt ArgNo, 
             final CGBuilderTy /*&*/ Builder) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue());
      assert (!LexicalBlockStack.empty()) : "Region stack mismatch, stack empty!";
      if (VD.hasAttr(NoDebugAttr.class)) {
        return;
      }
      
      boolean Unwritten = VD.isImplicit() || (isa_Decl(VD.getDeclContext$Const())
         && cast_Decl(VD.getDeclContext$Const()).isImplicit());
      DIFile /*P*/ Unit = null;
      if (!Unwritten) {
        Unit = getOrCreateFile(VD.getLocation());
      }
      DIType /*P*/ Ty;
      ulong$ptr XOffset = create_ulong$ptr($int2ulong(0));
      if (VD.hasAttr(BlocksAttr.class)) {
        Ty = EmitTypeForVarWithBlocksAttr(VD, $AddrOf(XOffset));
      } else {
        Ty = getOrCreateType(VD.getType(), Unit);
      }
      
      // If there is no debug info for this type then do not emit debug info
      // for this variable.
      if (!(Ty != null)) {
        return;
      }
      
      // Get location information.
      /*uint*/int Line = 0;
      /*uint*/int Column = 0;
      if (!Unwritten) {
        Line = getLineNumber(VD.getLocation());
        Column = getColumnNumber(VD.getLocation());
      }
      SmallVectorLong Expr/*J*/= new SmallVectorLong(9, (long/*int64_t*/)0);
      /*uint*/int Flags = 0;
      if (VD.isImplicit()) {
        Flags |= DINode.DIFlags.FlagArtificial;
      }
      // If this is the first argument and it is implicit then
      // give it an object pointer flag.
      // FIXME: There has to be a better way to do this, but for static
      // functions there won't be an implicit param at arg1 and
      // otherwise it is 'self' or 'this'.
      if (isa_ImplicitParamDecl(VD) && ArgNo.$bool() && ArgNo.$star() == 1) {
        Flags |= DINode.DIFlags.FlagObjectPointer;
      }
      {
        Argument /*P*/ Arg = dyn_cast_Argument(Storage);
        if ((Arg != null)) {
          if (Arg.getType().isPointerTy() && !Arg.hasByValAttr()
             && !VD.getType().$arrow().isPointerType()) {
            Expr.push_back($uint2llong(LocationAtom.DW_OP_deref));
          }
        }
      }
      
      DIScope /*P*/ Scope = cast_DIScope(LexicalBlockStack.back().$star());
      
      StringRef Name = VD.getName();
      if (!Name.empty()) {
        if (VD.hasAttr(BlocksAttr.class)) {
          CharUnits offset = CharUnits.fromQuantity(32);
          Expr.push_back($uint2llong(LocationAtom.DW_OP_plus));
          // offset of __forwarding field
          offset.$assignMove(CGM.getContext().toCharUnitsFromBits(CGM.getTarget().getPointerWidth(0)));
          Expr.push_back(offset.getQuantity());
          Expr.push_back($uint2llong(LocationAtom.DW_OP_deref));
          Expr.push_back($uint2llong(LocationAtom.DW_OP_plus));
          // offset of x field
          offset.$assignMove(CGM.getContext().toCharUnitsFromBits(XOffset.$star()));
          Expr.push_back(offset.getQuantity());
          
          // Create the descriptor for the variable.
          DILocalVariable /*P*/ D = ArgNo.$bool() ? DBuilder.createParameterVariable(Scope, VD.getName(), 
              ArgNo.$star(), Unit, Line, Ty) : DBuilder.createAutoVariable(Scope, VD.getName(), Unit, 
              Line, Ty);
          
          // Insert an llvm.dbg.declare into the current block.
          $c$.clean(DBuilder.insertDeclare_1(Storage, D, DBuilder.createExpression(new ArrayRefLong(Expr)), 
              $c$.track(DebugLoc.get(Line, Column, Scope)).$DILocation$P(), 
              Builder.GetInsertBlock()));
          return;
        } else if (isa_VariableArrayType(VD.getType())) {
          Expr.push_back($uint2llong(LocationAtom.DW_OP_deref));
        }
      } else {
        /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(VD.getType());
        if ((RT != null)) {
          // If VD is an anonymous union then Storage represents value for
          // all union fields.
          /*const*/ RecordDecl /*P*/ RD = cast_RecordDecl(RT.getDecl());
          if (RD.isUnion() && RD.isAnonymousStructOrUnion()) {
            // GDB has trouble finding local variables in anonymous unions, so we emit
            // artifical local variables for each of the members.
            //
            // FIXME: Remove this code as soon as GDB supports this.
            // The debug info verifier in LLVM operates based on the assumption that a
            // variable has the same size as its storage and we had to disable the check
            // for artificial variables.
            for (/*const*/ FieldDecl /*P*/ Field : RD.fields()) {
              DIType /*P*/ FieldTy = getOrCreateType(Field.getType(), Unit);
              StringRef FieldName = Field.getName();
              
              // Ignore unnamed fields. Do not ignore unnamed records.
              if (FieldName.empty() && !isa_RecordType(Field.getType())) {
                continue;
              }
              
              // Use VarDecl's Tag, Scope and Line number.
              DILocalVariable /*P*/ D = DBuilder.createAutoVariable(Scope, new StringRef(FieldName), Unit, Line, FieldTy, CGM.getLangOpts().Optimize, 
                  Flags | DINode.DIFlags.FlagArtificial);
              
              // Insert an llvm.dbg.declare into the current block.
              $c$.clean(DBuilder.insertDeclare_1(Storage, D, DBuilder.createExpression(new ArrayRefLong(Expr)), 
                  $c$.track(DebugLoc.get(Line, Column, Scope)).$DILocation$P(), 
                  Builder.GetInsertBlock()));
            }
          }
        }
      }
      
      // Create the descriptor for the variable.
      DILocalVariable /*P*/ D = ArgNo.$bool() ? DBuilder.createParameterVariable(Scope, new StringRef(Name), ArgNo.$star(), Unit, Line, 
          Ty, CGM.getLangOpts().Optimize, 
          Flags) : DBuilder.createAutoVariable(Scope, new StringRef(Name), Unit, Line, Ty, 
          CGM.getLangOpts().Optimize, Flags);
      
      // Insert an llvm.dbg.declare into the current block.
      $c$.clean(DBuilder.insertDeclare_1(Storage, D, DBuilder.createExpression(new ArrayRefLong(Expr)), 
          $c$.track(DebugLoc.get(Line, Column, Scope)).$DILocation$P(), 
          Builder.GetInsertBlock()));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Build up structure info for the byref.  See \a BuildByRefType.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::EmitTypeForVarWithBlocksAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3039,
   FQN="clang::CodeGen::CGDebugInfo::EmitTypeForVarWithBlocksAttr", NM="_ZN5clang7CodeGen11CGDebugInfo28EmitTypeForVarWithBlocksAttrEPKNS_7VarDeclEPy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo28EmitTypeForVarWithBlocksAttrEPKNS_7VarDeclEPy")
  //</editor-fold>
  private DIType /*P*/ EmitTypeForVarWithBlocksAttr(/*const*/ VarDecl /*P*/ VD, 
                              ulong$ptr/*uint64_t P*/ XOffset) {
    
    SmallVector<Metadata /*P*/ > EltTys/*J*/= new SmallVector<Metadata /*P*/ >(5, (Metadata /*P*/ )null);
    QualType FType/*J*/= new QualType();
    long/*uint64_t*/ FieldSize;
    ulong$ptr FieldOffset = create_ulong$ptr();
    /*uint*/int FieldAlign;
    
    DIFile /*P*/ Unit = getOrCreateFile(VD.getLocation());
    QualType Type = VD.getType();
    
    FieldOffset.$set($int2ulong(0));
    FType.$assignMove(CGM.getContext().getPointerType(/*NO_COPY*/CGM.getContext().VoidTy).$QualType());
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__isa"), $AddrOf(FieldOffset)));
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__forwarding"), $AddrOf(FieldOffset)));
    FType.$assignMove(CGM.getContext().IntTy.$QualType());
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__flags"), $AddrOf(FieldOffset)));
    EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__size"), $AddrOf(FieldOffset)));
    
    boolean HasCopyAndDispose = CGM.getContext().BlockRequiresCopying(new QualType(Type), VD);
    if (HasCopyAndDispose) {
      FType.$assignMove(CGM.getContext().getPointerType(/*NO_COPY*/CGM.getContext().VoidTy).$QualType());
      EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__copy_helper"), $AddrOf(FieldOffset)));
      EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__destroy_helper"), $AddrOf(FieldOffset)));
    }
    bool$ref HasByrefExtendedLayout = create_bool$ref();
    type$ref<Qualifiers.ObjCLifetime> Lifetime = create_type$ref();
    if (CGM.getContext().getByrefLifetime(new QualType(Type), Lifetime, 
        HasByrefExtendedLayout)
       && HasByrefExtendedLayout.$deref()) {
      FType.$assignMove(CGM.getContext().getPointerType(/*NO_COPY*/CGM.getContext().VoidTy).$QualType());
      EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/"__byref_variable_layout"), $AddrOf(FieldOffset)));
    }
    
    CharUnits Align = CGM.getContext().getDeclAlign(VD);
    if (Align.$greater(CGM.getContext().toCharUnitsFromBits(CGM.getTarget().getPointerAlign(0)))) {
      CharUnits FieldOffsetInBytes = CGM.getContext().toCharUnitsFromBits(FieldOffset.$star());
      CharUnits AlignedOffsetInBytes = FieldOffsetInBytes.alignTo(Align);
      CharUnits NumPaddingBytes = AlignedOffsetInBytes.$sub(FieldOffsetInBytes);
      if (NumPaddingBytes.isPositive()) {
        APInt pad/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 32, NumPaddingBytes.getQuantity());
        FType.$assignMove(CGM.getContext().getConstantArrayType(CGM.getContext().CharTy.$QualType(), 
                pad, org.clang.ast.ArrayType.ArraySizeModifier.Normal, 0));
        EltTys.push_back(CreateMemberType(Unit, new QualType(FType), new StringRef(/*KEEP_STR*/$EMPTY), $AddrOf(FieldOffset)));
      }
    }
    
    FType.$assign(Type);
    DIType /*P*/ FieldTy = getOrCreateType(new QualType(FType), Unit);
    FieldSize = CGM.getContext().getTypeSize(new QualType(FType));
    FieldAlign = $long2uint(CGM.getContext().toBits(new CharUnits(Align)));
    
    XOffset.$set(FieldOffset.$star());
    FieldTy = DBuilder.createMemberType(Unit, VD.getName(), Unit, 0, FieldSize, 
        $uint2ulong(FieldAlign), FieldOffset.$star(), 0, FieldTy);
    EltTys.push_back(FieldTy);
    FieldOffset.$inc((int)FieldSize);
    
    MDTupleTypedArrayWrapper<DINode> Elements = DBuilder.getOrCreateArray(new ArrayRef<Metadata /*P*/ >(EltTys, true));
    
    /*uint*/int Flags = DINode.DIFlags.FlagBlockByrefStruct;
    
    return DBuilder.createStructType(Unit, new StringRef(/*KEEP_STR*/$EMPTY), Unit, 0, FieldOffset.$star(), $int2ulong(0), Flags, 
        (DIType /*P*/ )null, new MDTupleTypedArrayWrapper<DINode>(JD$Convertible.INSTANCE, DINode.class, Elements));
  }

  
  /// Get context info for the DeclContext of \p Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getDeclContextDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 154,
   FQN="clang::CodeGen::CGDebugInfo::getDeclContextDescriptor", NM="_ZN5clang7CodeGen11CGDebugInfo24getDeclContextDescriptorEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24getDeclContextDescriptorEPKNS_4DeclE")
  //</editor-fold>
  private DIScope /*P*/ getDeclContextDescriptor(/*const*/ Decl /*P*/ D) {
    DIScope /*P*/ Mod = getParentModuleOrNull(D);
    return getContextDescriptor(cast_Decl(D.getDeclContext$Const()), 
        (Mod != null) ? Mod : TheCU);
  }

  /// Get context info for a given DeclContext \p Decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getContextDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 160,
   FQN="clang::CodeGen::CGDebugInfo::getContextDescriptor", NM="_ZN5clang7CodeGen11CGDebugInfo20getContextDescriptorEPKNS_4DeclEPN4llvm7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20getContextDescriptorEPKNS_4DeclEPN4llvm7DIScopeE")
  //</editor-fold>
  private DIScope /*P*/ getContextDescriptor(/*const*/ Decl /*P*/ Context, 
                      DIScope /*P*/ Default) {
    if (!(Context != null)) {
      return Default;
    }
    
    DenseMapIterator</*const*/ Decl /*P*/ , TrackingMDRef> I = RegionMap.find(Context);
    if (I.$noteq(/*NO_ITER_COPY*/RegionMap.end())) {
      Metadata /*P*/ V = I.$arrow().second.$Metadata$P();
      return dyn_cast_or_null_DIScope(V);
    }
    {
      
      // Check namespace.
      /*const*/ NamespaceDecl /*P*/ NSDecl = dyn_cast_NamespaceDecl(Context);
      if ((NSDecl != null)) {
        return getOrCreateNameSpace(NSDecl);
      }
    }
    {
      
      /*const*/ RecordDecl /*P*/ RDecl = dyn_cast_RecordDecl(Context);
      if ((RDecl != null)) {
        if (!RDecl.isDependentType()) {
          return getOrCreateType(CGM.getContext().getTypeDeclType(RDecl), 
              getOrCreateMainFile());
        }
      }
    }
    return Default;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getCurrentContextDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3612,
   FQN="clang::CodeGen::CGDebugInfo::getCurrentContextDescriptor", NM="_ZN5clang7CodeGen11CGDebugInfo27getCurrentContextDescriptorEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo27getCurrentContextDescriptorEPKNS_4DeclE")
  //</editor-fold>
  private DIScope /*P*/ getCurrentContextDescriptor(/*const*/ Decl /*P*/ D) {
    if (!LexicalBlockStack.empty()) {
      return LexicalBlockStack.back().$T$P();
    }
    DIScope /*P*/ Mod = getParentModuleOrNull(D);
    return getContextDescriptor(D, (Mod != null) ? Mod : TheCU);
  }

  
  /// Create a forward decl for a RecordType in a given context.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateRecordFwdDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 713,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateRecordFwdDecl", NM="_ZN5clang7CodeGen11CGDebugInfo24getOrCreateRecordFwdDeclEPKNS_10RecordTypeEPN4llvm7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24getOrCreateRecordFwdDeclEPKNS_10RecordTypeEPN4llvm7DIScopeE")
  //</editor-fold>
  private DICompositeType /*P*/ getOrCreateRecordFwdDecl(/*const*/ RecordType /*P*/ Ty, 
                          DIScope /*P*/ Ctx) {
    /*const*/ RecordDecl /*P*/ RD = Ty.getDecl();
    {
      DIType /*P*/ T = getTypeOrNull(CGM.getContext().getRecordType(RD));
      if ((T != null)) {
        return cast_DICompositeType(T);
      }
    }
    DIFile /*P*/ DefUnit = getOrCreateFile(RD.getLocation());
    /*uint*/int Line = getLineNumber(RD.getLocation());
    StringRef RDName = getClassName(RD);
    
    long/*uint64_t*/ Size = $int2ulong(0);
    long/*uint64_t*/ Align = $int2ulong(0);
    
    /*const*/ RecordDecl /*P*/ D = RD.getDefinition();
    if ((D != null) && D.isCompleteDefinition()) {
      Size = CGM.getContext().getTypeSize(Ty);
      Align = $uint2ulong(CGM.getContext().getTypeAlign(Ty));
    }
    
    // Create the type.
    SmallString/*<256>*/ FullName = CGDebugInfoStatics.getUniqueTagTypeName(Ty, CGM, TheCU);
    DICompositeType /*P*/ RetTy = DBuilder.createReplaceableCompositeType($ushort2uint(CGDebugInfoStatics.getTagForRecord(RD)), new StringRef(RDName), Ctx, DefUnit, Line, 0, Size, Align, 
        DINode.DIFlags.FlagFwdDecl, FullName.$StringRef());
    ReplaceMap.emplace_back(new std.pairPtrType</*const*/ TagType /*P*/ , TrackingMDRef>(Ty, 
        new TrackingMDRef((/*static_cast*/Metadata /*P*/ )(RetTy))));
    return RetTy;
  }

  
  /// Return current directory name.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getCurrentDirname">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 373,
   FQN="clang::CodeGen::CGDebugInfo::getCurrentDirname", NM="_ZN5clang7CodeGen11CGDebugInfo17getCurrentDirnameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17getCurrentDirnameEv")
  //</editor-fold>
  private StringRef getCurrentDirname() {
    if (!CGM.getCodeGenOpts().DebugCompilationDir.empty()) {
      return new StringRef(CGM.getCodeGenOpts().DebugCompilationDir);
    }
    if (!CWDName.empty()) {
      return new StringRef(CWDName);
    }
    SmallString/*<256>*/ CWD/*J*/= new SmallString/*<256>*/(256);
    fs.current_path(CWD);
    return new StringRef(CWDName.$assignMove(internString(CWD.$StringRef())));
  }

  
  /// Create new compile unit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateCompileUnit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 384,
   FQN="clang::CodeGen::CGDebugInfo::CreateCompileUnit", NM="_ZN5clang7CodeGen11CGDebugInfo17CreateCompileUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17CreateCompileUnitEv")
  //</editor-fold>
  private void CreateCompileUnit() {
    
    // Should we be asking the SourceManager for the main file name, instead of
    // accepting it as an argument? This just causes the main file name to
    // mismatch with source locations and create extra lexical scopes or
    // mismatched debug info (a CU with a DW_AT_file of "-", because that's what
    // the driver passed, but functions/other things have DW_AT_file of "<stdin>"
    // because that's what the SourceManager says)
    
    // Get absolute path name.
    final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
    std.string MainFileName = new std.string(CGM.getCodeGenOpts().MainFileName);
    if (MainFileName.empty()) {
      MainFileName.$assign_T$C$P(/*KEEP_STR*/"<stdin>");
    }
    
    // The main file name provided via the "-main-file-name" option contains just
    // the file name itself with no path information. This file name may have had
    // a relative path, so we look into the actual file entry for the main
    // file to determine the real absolute path for the file.
    std.string MainFileDir/*J*/= new std.string();
    {
      /*const*/ FileEntry /*P*/ MainFile = SM.getFileEntryForID(SM.getMainFileID());
      if ((MainFile != null)) {
        MainFileDir.$assignMove(remapDIPath(new StringRef(MainFile.getDir().getName())));
        if ($noteq_string$C_T$C$P(MainFileDir, /*KEEP_STR*/".")) {
          SmallString/*<1024>*/ MainFileDirSS/*J*/= new SmallString/*<1024>*/(1024, new StringRef(MainFileDir));
          path.append(MainFileDirSS, new Twine(MainFileName));
          MainFileName.$assignMove(MainFileDirSS.str().$string());
        }
      }
    }
    
    /*SourceLanguage*//*uint*/int LangTag = 0;
    final /*const*/ LangOptions /*&*/ LO = CGM.getLangOpts();
    if (LO.CPlusPlus) {
      if (LO.ObjC1) {
        LangTag = SourceLanguage.DW_LANG_ObjC_plus_plus;
      } else {
        LangTag = SourceLanguage.DW_LANG_C_plus_plus;
      }
    } else if (LO.ObjC1) {
      LangTag = SourceLanguage.DW_LANG_ObjC;
    } else if (LO.RenderScript) {
      LangTag = SourceLanguage.DW_LANG_GOOGLE_RenderScript;
    } else if (LO.C99) {
      LangTag = SourceLanguage.DW_LANG_C99;
    } else {
      LangTag = SourceLanguage.DW_LANG_C89;
    }
    
    std.string Producer = getClangFullVersion();
    
    // Figure out which version of the ObjC runtime we have.
    /*uint*/int RuntimeVers = 0;
    if (LO.ObjC1) {
      RuntimeVers = LO.ObjCRuntime.isNonFragile() ? 2 : 1;
    }
    
    DICompileUnit.DebugEmissionKind EmissionKind = DICompileUnit.DebugEmissionKind.NoDebug;
    switch (DebugKind) {
     case NoDebugInfo:
     case LocTrackingOnly:
      EmissionKind = DICompileUnit.DebugEmissionKind.NoDebug;
      break;
     case DebugLineTablesOnly:
      EmissionKind = DICompileUnit.DebugEmissionKind.LineTablesOnly;
      break;
     case LimitedDebugInfo:
     case FullDebugInfo:
      EmissionKind = DICompileUnit.DebugEmissionKind.FullDebug;
      break;
    }
    
    // Create new compile unit.
    // FIXME - Eliminate TheCU.
    TheCU = DBuilder.createCompileUnit(LangTag, new StringRef(remapDIPath(new StringRef(MainFileName))), new StringRef(remapDIPath(getCurrentDirname())), 
        new StringRef(Producer), LO.Optimize, new StringRef(CGM.getCodeGenOpts().DwarfDebugFlags), RuntimeVers, 
        new StringRef(CGM.getCodeGenOpts().SplitDwarfFile), EmissionKind, $int2ulong(0/* DWOid */));
  }

  
  /// Remap a given path with the current debug prefix map
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::remapDIPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 345,
   FQN="clang::CodeGen::CGDebugInfo::remapDIPath", NM="_ZNK5clang7CodeGen11CGDebugInfo11remapDIPathEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZNK5clang7CodeGen11CGDebugInfo11remapDIPathEN4llvm9StringRefE")
  //</editor-fold>
  private std.string remapDIPath(StringRef Path) /*const*/ {
    for (final /*const*/std.pair<StringRef, StringRef> /*&*/ Entry : DebugPrefixMap)  {
      if (Path.startswith(/*NO_COPY*/Entry.first)) {
        return ($add_Twine$C(new Twine(Entry.second), new Twine(Path.substr(Entry.first.size())))).str();
      }
    }
    return Path.str();
  }

  
  /// Get the file debug info descriptor for the input location.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 309,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateFile", NM="_ZN5clang7CodeGen11CGDebugInfo15getOrCreateFileENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15getOrCreateFileENS_14SourceLocationE")
  //</editor-fold>
  private DIFile /*P*/ getOrCreateFile(SourceLocation Loc) {
    if (!Loc.isValid()) {
      // If Location is not valid then use main input file.
      return DBuilder.createFile(new StringRef(remapDIPath(TheCU.getFilename())), 
          new StringRef(remapDIPath(TheCU.getDirectory())));
    }
    
    final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
    PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc);
    if (PLoc.isInvalid() || new StringRef(PLoc.getFilename()).empty()) {
      // If the location is not valid then use main input file.
      return DBuilder.createFile(new StringRef(remapDIPath(TheCU.getFilename())), 
          new StringRef(remapDIPath(TheCU.getDirectory())));
    }
    
    // Cache the results.
    /*const*/char$ptr/*char P*/ fname = $tryClone(PLoc.getFilename());
    DenseMapIterator<char$ptr, TrackingMDRef> it = DIFileCache.find(fname);
    if (it.$noteq(/*NO_ITER_COPY*/DIFileCache.end())) {
      {
        // Verify that the information still exists.
        Metadata /*P*/ V = it.$arrow().second.$Metadata$P();
        if ((V != null)) {
          return cast_DIFile(V);
        }
      }
    }
    
    DIFile /*P*/ F = DBuilder.createFile(new StringRef(remapDIPath(new StringRef(PLoc.getFilename()))), 
        new StringRef(remapDIPath(getCurrentDirname())));
    
    DIFileCache.$at_T1$C$R(fname).reset(F);
    return F;
  }

  
  /// Get the file info for main compile unit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 340,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateMainFile", NM="_ZN5clang7CodeGen11CGDebugInfo19getOrCreateMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo19getOrCreateMainFileEv")
  //</editor-fold>
  private DIFile /*P*/ getOrCreateMainFile() {
    return DBuilder.createFile(new StringRef(remapDIPath(TheCU.getFilename())), 
        new StringRef(remapDIPath(TheCU.getDirectory())));
  }

  
  /// Get the type from the cache or create a new type if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2333,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateType", NM="_ZN5clang7CodeGen11CGDebugInfo15getOrCreateTypeENS_8QualTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15getOrCreateTypeENS_8QualTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ getOrCreateType(QualType Ty, DIFile /*P*/ Unit) {
    if (Ty.isNull()) {
      return null;
    }
    
    // Unwrap the type as needed for debug information.
    Ty.$assignMove(CGDebugInfoStatics.UnwrapTypeForDebugInfo(new QualType(Ty), CGM.getContext()));
    {
      
      DIType /*P*/ T = getTypeOrNull(new QualType(Ty));
      if ((T != null)) {
        return T;
      }
    }
    
    DIType /*P*/ Res = CreateTypeNode(new QualType(Ty), Unit);
    Object/*void P*/ TyPtr = Ty.getAsOpaquePtr();
    
    // And update the type cache.
    TypeCache.$at_T1$RR(TyPtr).reset(Res);
    
    return Res;
  }

  
  /// Get a reference to a clang module.  If \p CreateSkeletonCU is true,
  /// this also creates a split dwarf skeleton compile unit.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateModuleRef">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1823,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateModuleRef", NM="_ZN5clang7CodeGen11CGDebugInfo20getOrCreateModuleRefENS_17ExternalASTSource19ASTSourceDescriptorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo20getOrCreateModuleRefENS_17ExternalASTSource19ASTSourceDescriptorEb")
  //</editor-fold>
  private DIModule /*P*/ getOrCreateModuleRef(ExternalASTSource.ASTSourceDescriptor Mod, 
                      boolean CreateSkeletonCU) {
    // Use the Module pointer as the key into the cache. This is a
    // nullptr if the "Module" is a PCH, which is safe because we don't
    // support chained PCH debug info, so there can only be a single PCH.
    /*const*/ org.clang.basic.Module /*P*/ M = Mod.getModuleOrNull();
    DenseMapIterator</*const*/ org.clang.basic.Module /*P*/ , TrackingMDRef> ModRef = ModuleCache.find(M);
    if (ModRef.$noteq(/*NO_ITER_COPY*/ModuleCache.end())) {
      return cast_DIModule(ModRef.$arrow().second.$star());
    }
    
    // Macro definitions that were defined with "-D" on the command line.
    SmallString/*<128>*/ ConfigMacros/*J*/= new SmallString/*<128>*/(128);
    {
      raw_svector_ostream OS = null;
      try {
        OS/*J*/= new raw_svector_ostream(ConfigMacros);
        final /*const*/ PreprocessorOptions /*&*/ PPOpts = CGM.getPreprocessorOpts();
        /*uint*/int I = 0;
        // Translate the macro definitions back into a commmand line.
        for (final /*const*/std.pairTypeBool<std.string>/*&*/ M$1 : PPOpts.Macros) {
          if ($greater_uint(++I, 1)) {
            OS.$out(/*KEEP_STR*/$SPACE);
          }
          final /*const*/std.string/*&*/ Macro = M$1.first;
          boolean Undef = M$1.second;
          OS.$out(/*KEEP_STR*/"\"-").$out_char((Undef ? $$U : $$D));
          for (/*char*/byte c : Macro.$array())  {
            switch (c) {
             case '\\':
              OS.$out(/*KEEP_STR*/"\\\\");
              break;
             case '"':
              OS.$out(/*KEEP_STR*/"\\\"");
              break;
             default:
              OS.$out_char(c);
            }
          }
          OS.$out_char($$DBL_QUOTE);
        }
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
    
    boolean IsRootModule = (M != null) ? !(M.Parent != null) : true;
    if (CreateSkeletonCU && IsRootModule) {
      DIBuilder DIB = null;
      try {
        // PCH files don't have a signature field in the control block,
        // but LLVM detects skeleton CUs by looking for a non-zero DWO id.
        long/*uint64_t*/ Signature = (Mod.getSignature() != 0) ? Mod.getSignature() : ~1L/*ULL*/;
        DIB/*J*/= new DIBuilder(CGM.getModule());
        DIB.createCompileUnit(TheCU.getSourceLanguage(), new StringRef(Mod.getModuleName()), 
            Mod.getPath(), TheCU.getProducer(), true, 
            new StringRef(), 0, Mod.getASTFile(), 
            DICompileUnit.DebugEmissionKind.FullDebug, Signature);
        DIB.finalize();
      } finally {
        if (DIB != null) { DIB.$destroy(); }
      }
    }
    DIModule /*P*/ Parent = IsRootModule ? null : getOrCreateModuleRef(new ExternalASTSource.ASTSourceDescriptor($Deref(M.Parent)), 
        CreateSkeletonCU);
    DIModule /*P*/ DIMod = DBuilder.createModule(Parent, new StringRef(Mod.getModuleName()), ConfigMacros.$StringRef(), 
        Mod.getPath(), new StringRef(CGM.getHeaderSearchOpts().Sysroot));
    ModuleCache.$at_T1$C$R(M).reset(DIMod);
    return DIMod;
  }

  
  /// DebugTypeExtRefs: If \p D originated in a clang module, return it.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getParentModuleOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2352,
   FQN="clang::CodeGen::CGDebugInfo::getParentModuleOrNull", NM="_ZN5clang7CodeGen11CGDebugInfo21getParentModuleOrNullEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo21getParentModuleOrNullEPKNS_4DeclE")
  //</editor-fold>
  private DIModule /*P*/ getParentModuleOrNull(/*const*/ Decl /*P*/ D) {
    // A forward declaration inside a module header does not belong to the module.
    if (isa_RecordDecl(D) && !(cast_RecordDecl(D).getDefinition() != null)) {
      return null;
    }
    if (DebugTypeExtRefs && D.isFromASTFile()) {
      // Record a reference to an imported clang module or precompiled header.
      ExternalASTSource /*P*/ Reader = CGM.getContext().getExternalSource();
      /*uint*/int Idx = D.getOwningModuleID();
      Optional<ExternalASTSource.ASTSourceDescriptor> Info = Reader.getSourceDescriptor(Idx);
      if (Info.$bool()) {
        return getOrCreateModuleRef(new ExternalASTSource.ASTSourceDescriptor(Info.$star()), /*SkeletonCU=*/ true);
      }
    } else if ((ClangModuleMap != null)) {
      // We are building a clang module or a precompiled header.
      //
      // TODO: When D is a CXXRecordDecl or a C++ Enum, the ODR applies
      // and it wouldn't be necessary to specify the parent scope
      // because the type is already unique by definition (it would look
      // like the output of -fno-standalone-debug). On the other hand,
      // the parent scope helps a consumer to quickly locate the object
      // file where the type's definition is located, so it might be
      // best to make this behavior a command line or debugger tuning
      // option.
      FullSourceLoc Loc/*J*/= new FullSourceLoc(D.getLocation(), CGM.getContext().getSourceManager());
      {
        org.clang.basic.Module /*P*/ M = ClangModuleMap.inferModuleFromLocation(/*NO_COPY*/Loc);
        if ((M != null)) {
          // This is a (sub-)module.
          ExternalASTSource.ASTSourceDescriptor Info = new ExternalASTSource.ASTSourceDescriptor($Deref(M));
          return getOrCreateModuleRef(new ExternalASTSource.ASTSourceDescriptor(Info), /*SkeletonCU=*/ false);
        } else {
          // This the precompiled header being built.
          return getOrCreateModuleRef(new ExternalASTSource.ASTSourceDescriptor(PCHDescriptor), /*SkeletonCU=*/ false);
        }
      }
    }
    
    return null;
  }

  
  /// Get the type from the cache or create a new partial type if
  /// necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateLimitedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2471,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateLimitedType", NM="_ZN5clang7CodeGen11CGDebugInfo22getOrCreateLimitedTypeEPKNS_10RecordTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo22getOrCreateLimitedTypeEPKNS_10RecordTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DICompositeType /*P*/ getOrCreateLimitedType(/*const*/ RecordType /*P*/ Ty, 
                        DIFile /*P*/ Unit) {
    QualType QTy/*J*/= new QualType(Ty, 0);
    
    DICompositeType /*P*/ T = cast_or_null_DICompositeType(getTypeOrNull(new QualType(QTy)));
    
    // We may have cached a forward decl when we could have created
    // a non-forward decl. Go ahead and create a non-forward decl
    // now.
    if ((T != null) && !T.isForwardDecl()) {
      return T;
    }
    
    // Otherwise create the type.
    type$ref<DICompositeType /*P*/ > Res = create_type$ref(CreateLimitedType(Ty));
    
    // Propagate members from the declaration to the definition
    // CreateType(const RecordType*) will overwrite this with the members in the
    // correct order if the full type is needed.
    DBuilder.replaceArrays(Res, (T != null) ? T.getElements() : new MDTupleTypedArrayWrapper<DINode>(DINode.class));
    
    // And update the type cache.
    TypeCache.$at_T1$RR(QTy.getAsOpaquePtr()).reset(Res.$deref());
    return Res.$deref();
  }

  
  /// Create type metadata for a source language type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateTypeNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2388,
   FQN="clang::CodeGen::CGDebugInfo::CreateTypeNode", NM="_ZN5clang7CodeGen11CGDebugInfo14CreateTypeNodeENS_8QualTypeEPN4llvm6DIFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo14CreateTypeNodeENS_8QualTypeEPN4llvm6DIFileE")
  //</editor-fold>
  private DIType /*P*/ CreateTypeNode(QualType Ty, DIFile /*P*/ Unit) {
    // Handle qualifiers, which recursively handles what they refer to.
    if (Ty.hasLocalQualifiers()) {
      return CreateQualifiedType(new QualType(Ty), Unit);
    }
    
    // Work out details of type.
    switch (Ty.$arrow().getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case TemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
      throw new llvm_unreachable("Dependent types cannot show up in debug information");
     case ExtVector:
     case Vector:
      return CreateType_VectorType$C$P_DIFile$P(cast_VectorType(Ty), Unit);
     case ObjCObjectPointer:
      return CreateType_ObjCObjectPointerType$C$P_DIFile$P(cast_ObjCObjectPointerType(Ty), Unit);
     case ObjCObject:
      return CreateType_ObjCObjectType$C$P_DIFile$P(cast_ObjCObjectType(Ty), Unit);
     case ObjCInterface:
      return CreateType_ObjCInterfaceType$C$P_DIFile$P(cast_ObjCInterfaceType(Ty), Unit);
     case Builtin:
      return CreateType(cast_BuiltinType(Ty));
     case Complex:
      return CreateType(cast_ComplexType(Ty));
     case Pointer:
      return CreateType_PointerType$C$P_DIFile$P(cast_PointerType(Ty), Unit);
     case Adjusted:
     case Decayed:
      // Decayed and adjusted types use the adjusted type in LLVM and DWARF.
      return CreateType_PointerType$C$P_DIFile$P(cast_PointerType(cast_AdjustedType(Ty).getAdjustedType()), Unit);
     case BlockPointer:
      return CreateType_BlockPointerType$C$P_DIFile$P(cast_BlockPointerType(Ty), Unit);
     case Typedef:
      return CreateType_TypedefType$C$P_DIFile$P(cast_TypedefType(Ty), Unit);
     case Record:
      return CreateType(cast_RecordType(Ty));
     case Enum:
      return CreateEnumType(cast_EnumType(Ty));
     case FunctionProto:
     case FunctionNoProto:
      return CreateType_FunctionType$C$P_DIFile$P(cast_FunctionType(Ty), Unit);
     case ConstantArray:
     case VariableArray:
     case IncompleteArray:
      return CreateType_ArrayType$C$P_DIFile$P(cast_ArrayType(Ty), Unit);
     case LValueReference:
      return CreateType_LValueReferenceType$C$P_DIFile$P(cast_LValueReferenceType(Ty), Unit);
     case RValueReference:
      return CreateType_RValueReferenceType$C$P_DIFile$P(cast_RValueReferenceType(Ty), Unit);
     case MemberPointer:
      return CreateType_MemberPointerType$C$P_DIFile$P(cast_MemberPointerType(Ty), Unit);
     case Atomic:
      return CreateType_AtomicType$C$P_DIFile$P(cast_AtomicType(Ty), Unit);
     case Pipe:
      return CreateType_PipeType$C$P_DIFile$P(cast_PipeType(Ty), Unit);
     case TemplateSpecialization:
      return CreateType_TemplateSpecializationType$C$P_DIFile$P(cast_TemplateSpecializationType(Ty), Unit);
     case Auto:
     case Attributed:
     case Elaborated:
     case Paren:
     case SubstTemplateTypeParm:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case PackExpansion:
      break;
    }
    throw new llvm_unreachable("type should have been unwrapped!");
  }

  
  /// Create new member and increase Offset by FType's size.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CreateMemberType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2586,
   FQN="clang::CodeGen::CGDebugInfo::CreateMemberType", NM="_ZN5clang7CodeGen11CGDebugInfo16CreateMemberTypeEPN4llvm6DIFileENS_8QualTypeENS2_9StringRefEPy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo16CreateMemberTypeEPN4llvm6DIFileENS_8QualTypeENS2_9StringRefEPy")
  //</editor-fold>
  private DIType /*P*/ CreateMemberType(DIFile /*P*/ Unit, QualType FType, 
                  StringRef Name, ulong$ptr/*uint64_t P*/ Offset) {
    DIType /*P*/ FieldTy = /*super.*/getOrCreateType(new QualType(FType), Unit);
    long/*uint64_t*/ FieldSize = CGM.getContext().getTypeSize(new QualType(FType));
    /*uint*/int FieldAlign = CGM.getContext().getTypeAlign(new QualType(FType));
    DIType /*P*/ Ty = DBuilder.createMemberType(Unit, new StringRef(Name), Unit, 0, FieldSize, 
        $uint2ulong(FieldAlign), Offset.$star(), 0, FieldTy);
    Offset.$set(Offset.$star() + FieldSize);
    return Ty;
  }

  
  /// Retrieve the DIDescriptor, if any, for the canonical form of this
  /// declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getDeclarationOrDefinition">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2730,
   FQN="clang::CodeGen::CGDebugInfo::getDeclarationOrDefinition", NM="_ZN5clang7CodeGen11CGDebugInfo26getDeclarationOrDefinitionEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo26getDeclarationOrDefinitionEPKNS_4DeclE")
  //</editor-fold>
  private DINode /*P*/ getDeclarationOrDefinition(/*const*/ Decl /*P*/ D) {
    {
      // We only need a declaration (not a definition) of the type - so use whatever
      // we would otherwise do to get a type for a pointee. (forward declarations in
      // limited debug info, full definitions (if the type definition is available)
      // in unlimited debug info)
      /*const*/ TypeDecl /*P*/ TD = dyn_cast_TypeDecl(D);
      if ((TD != null)) {
        return getOrCreateType(CGM.getContext().getTypeDeclType(TD), 
            getOrCreateFile(TD.getLocation()));
      }
    }
    DenseMapIterator</*const*/ Decl /*P*/ , TrackingMDRef> I = DeclCache.find(D.getCanonicalDecl$Const());
    if (I.$noteq(/*NO_ITER_COPY*/DeclCache.end())) {
      return dyn_cast_or_null_DINode(I.$arrow().second.$star());
    }
    {
      
      // No definition for now. Emit a forward definition that might be
      // merged with a potential upcoming definition.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        return getFunctionForwardDeclaration(FD);
      } else {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          return getGlobalVariableForwardDeclaration(VD);
        }
      }
    }
    
    return null;
  }

  
  /// \return debug info descriptor to describe method
  /// declaration for the given method definition.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getFunctionDeclaration">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2753,
   FQN="clang::CodeGen::CGDebugInfo::getFunctionDeclaration", NM="_ZN5clang7CodeGen11CGDebugInfo22getFunctionDeclarationEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo22getFunctionDeclarationEPKNS_4DeclE")
  //</editor-fold>
  private DISubprogram /*P*/ getFunctionDeclaration(/*const*/ Decl /*P*/ D) {
    if (!(D != null) || DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue()) {
      return null;
    }
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if (!(FD != null)) {
      return null;
    }
    
    // Setup context.
    DIScope /*P*/ S = getDeclContextDescriptor(D);
    
    DenseMapIterator</*const*/ FunctionDecl /*P*/ , TrackingMDRef> MI = SPCache.find(FD.getCanonicalDecl$Const());
    if (MI.$eq(/*NO_ITER_COPY*/SPCache.end())) {
      {
        /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD.getCanonicalDecl$Const());
        if ((MD != null)) {
          return CreateCXXMemberFunction(MD, getOrCreateFile(MD.getLocation()), 
              cast_DICompositeType(S));
        }
      }
    }
    if (MI.$noteq(/*NO_ITER_COPY*/SPCache.end())) {
      DISubprogram /*P*/ SP = dyn_cast_or_null_DISubprogram(MI.$arrow().second.$star());
      if ((SP != null) && !SP.isDefinition()) {
        return SP;
      }
    }
    
    for (FunctionDecl /*P*/ NextFD : FD.redeclarable_redecls()) {
      DenseMapIterator</*const*/ FunctionDecl /*P*/ , TrackingMDRef> MI$1 = SPCache.find(NextFD.getCanonicalDecl());
      if (MI$1.$noteq(/*NO_ITER_COPY*/SPCache.end())) {
        DISubprogram /*P*/ SP = dyn_cast_or_null_DISubprogram(MI$1.$arrow().second.$star());
        if ((SP != null) && !SP.isDefinition()) {
          return SP;
        }
      }
    }
    return null;
  }

  
  /// \return debug info descriptor to describe in-class static data
  /// member declaration for the given out-of-class definition.  If D
  /// is an out-of-class definition of a static data member of a
  /// class, find its corresponding in-class declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getOrCreateStaticDataMemberDeclarationOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3490,
   FQN="clang::CodeGen::CGDebugInfo::getOrCreateStaticDataMemberDeclarationOrNull", NM="_ZN5clang7CodeGen11CGDebugInfo44getOrCreateStaticDataMemberDeclarationOrNullEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo44getOrCreateStaticDataMemberDeclarationOrNullEPKNS_7VarDeclE")
  //</editor-fold>
  private DIDerivedType /*P*/ getOrCreateStaticDataMemberDeclarationOrNull(/*const*/ VarDecl /*P*/ D) {
    if (!D.isStaticDataMember()) {
      return null;
    }
    
    DenseMapIterator</*const*/ Decl /*P*/ , TypedTrackingMDRef<DIDerivedType>> MI = StaticDataMemberCache.find(D.getCanonicalDecl$Const());
    if (MI.$noteq(/*NO_ITER_COPY*/StaticDataMemberCache.end())) {
      assert (((MI.$arrow().second.$T$P()) != null)) : "Static data member declaration should still exist";
      return MI.$arrow().second.$T$P();
    }
    
    // If the member wasn't found in the cache, lazily construct and add it to the
    // type (used when a limited form of the type is emitted).
    /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
    DICompositeType /*P*/ Ctxt = cast_DICompositeType(getDeclContextDescriptor(D));
    return CreateRecordStaticField(D, Ctxt, cast_RecordDecl(DC));
  }

  
  /// Create a subprogram describing the forward declaration
  /// represented in the given FunctionDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getFunctionForwardDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2679,
   FQN="clang::CodeGen::CGDebugInfo::getFunctionForwardDeclaration", NM="_ZN5clang7CodeGen11CGDebugInfo29getFunctionForwardDeclarationEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo29getFunctionForwardDeclarationEPKNS_12FunctionDeclE")
  //</editor-fold>
  private DISubprogram /*P*/ getFunctionForwardDeclaration(/*const*/ FunctionDecl /*P*/ FD) {
    MDTupleTypedArrayWrapper<DINode> TParamsArray/*J*/= new MDTupleTypedArrayWrapper<DINode>(DINode.class);
    StringRef Name/*J*/= new StringRef();
    StringRef LinkageName/*J*/= new StringRef();
    uint$ref Flags = create_uint$ref(0);
    SourceLocation Loc = FD.getLocation();
    DIFile /*P*/ Unit = getOrCreateFile(new SourceLocation(Loc));
    type$ref<DIScope /*P*/ > DContext = create_type$ref(Unit);
    /*uint*/int Line = getLineNumber(new SourceLocation(Loc));
    
    collectFunctionDeclProps(new GlobalDecl(FD), Unit, Name, LinkageName, DContext, 
        TParamsArray, Flags);
    // Build function type.
    SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
    for (/*const*/ ParmVarDecl /*P*/ Parm : FD.parameters$Const())  {
      ArgTypes.push_back(Parm.getType());
    }
    org.clang.basic.CallingConv CC = FD.getType().$arrow().castAs(org.clang.ast.FunctionType.class).getCallConv();
    QualType FnType = CGM.getContext().getFunctionType(FD.getReturnType(), new ArrayRef<QualType>(ArgTypes, false), new FunctionProtoType.ExtProtoInfo(CC));
    DISubprogram /*P*/ SP = DBuilder.createTempFunctionFwdDecl(DContext.$deref(), new StringRef(Name), new StringRef(LinkageName), Unit, Line, 
        getOrCreateFunctionType(FD, new QualType(FnType), Unit), !FD.isExternallyVisible(), 
        /* isDefinition = */ false, 0, Flags.$deref(), CGM.getLangOpts().Optimize, 
        new MDTupleTypedArrayWrapper<DITemplateParameter>(DITemplateParameter.class, TParamsArray.get()), getFunctionDeclaration(FD));
    /*const*/ FunctionDecl /*P*/ CanonDecl = cast_FunctionDecl(FD.getCanonicalDecl$Const());
    FwdDeclReplaceMap.emplace_back(new std.pairPtrType</*const*/ DeclaratorDecl /*P*/ , TrackingMDRef>(
        CanonDecl, 
        new TrackingMDRef(SP)));
    return SP;
  }

  
  /// Create a global variable describing the forward decalration
  /// represented in the given VarDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getGlobalVariableForwardDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2710,
   FQN="clang::CodeGen::CGDebugInfo::getGlobalVariableForwardDeclaration", NM="_ZN5clang7CodeGen11CGDebugInfo35getGlobalVariableForwardDeclarationEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo35getGlobalVariableForwardDeclarationEPKNS_7VarDeclE")
  //</editor-fold>
  private DIGlobalVariable /*P*/ getGlobalVariableForwardDeclaration(/*const*/ VarDecl /*P*/ VD) {
    QualType T/*J*/= new QualType();
    StringRef Name/*J*/= new StringRef();
    StringRef LinkageName/*J*/= new StringRef();
    SourceLocation Loc = VD.getLocation();
    type$ref<DIFile /*P*/ > Unit = create_type$ref(getOrCreateFile(new SourceLocation(Loc)));
    type$ref<DIScope /*P*/ > DContext = create_type$ref(Unit.$deref());
    uint$ref Line = create_uint$ref(getLineNumber(new SourceLocation(Loc)));
    
    collectVarDeclProps(VD, Unit, Line, T, Name, LinkageName, DContext);
    DIGlobalVariable /*P*/ GV = DBuilder.createTempGlobalVariableFwdDecl(DContext.$deref(), new StringRef(Name), new StringRef(LinkageName), Unit.$deref(), Line.$deref(), getOrCreateType(new QualType(T), Unit.$deref()), 
        !VD.isExternallyVisible(), (Constant /*P*/ )null, (MDNode /*P*/ )null);
    FwdDeclReplaceMap.emplace_back(new std.pairPtrType</*const*/ DeclaratorDecl /*P*/ , TrackingMDRef>(
        cast_VarDecl(VD.getCanonicalDecl$Const()), 
        new TrackingMDRef((/*static_cast*/Metadata /*P*/ )(GV))));
    return GV;
  }

  
  /// \brief Return a global variable that represents one of the
  /// collection of global variables created for an anonmyous union.
  ///
  /// Recursively collect all of the member fields of a global
  /// anonymous decl and create static variables for them. The first
  /// time this is called it needs to be on a union and then from
  /// there we can have additional unnamed fields.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::CollectAnonRecordDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3508,
   FQN="clang::CodeGen::CGDebugInfo::CollectAnonRecordDecls", NM="_ZN5clang7CodeGen11CGDebugInfo22CollectAnonRecordDeclsEPKNS_10RecordDeclEPN4llvm6DIFileEjNS5_9StringRefEPNS5_14GlobalVariableEPNS5_7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo22CollectAnonRecordDeclsEPKNS_10RecordDeclEPN4llvm6DIFileEjNS5_9StringRefEPNS5_14GlobalVariableEPNS5_7DIScopeE")
  //</editor-fold>
  private DIGlobalVariable /*P*/ CollectAnonRecordDecls(/*const*/ RecordDecl /*P*/ RD, DIFile /*P*/ Unit, /*uint*/int LineNo, 
                        StringRef LinkageName, GlobalVariable /*P*/ Var, DIScope /*P*/ DContext) {
    DIGlobalVariable /*P*/ GV = null;
    
    for (/*const*/ FieldDecl /*P*/ Field : RD.fields()) {
      DIType /*P*/ FieldTy = getOrCreateType(Field.getType(), Unit);
      StringRef FieldName = Field.getName();
      
      // Ignore unnamed fields, but recurse into anonymous records.
      if (FieldName.empty()) {
        {
          /*const*/ RecordType /*P*/ RT = dyn_cast_RecordType(Field.getType());
          if ((RT != null)) {
            GV = CollectAnonRecordDecls(RT.getDecl(), Unit, LineNo, new StringRef(LinkageName), 
                Var, DContext);
          }
        }
        continue;
      }
      // Use VarDecl's Tag, Scope and Line number.
      GV = DBuilder.createGlobalVariable(DContext, new StringRef(FieldName), new StringRef(LinkageName), Unit, 
          LineNo, FieldTy, 
          Var.hasLocalLinkage(), Var, (MDNode /*P*/ )null);
    }
    return GV;
  }

  
  /// Get function name for the given FunctionDecl. If the name is
  /// constructed on demand (e.g., C++ destructor) then the name is
  /// stored on the side.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getFunctionName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 182,
   FQN="clang::CodeGen::CGDebugInfo::getFunctionName", NM="_ZN5clang7CodeGen11CGDebugInfo15getFunctionNameEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15getFunctionNameEPKNS_12FunctionDeclE")
  //</editor-fold>
  private StringRef getFunctionName(/*const*/ FunctionDecl /*P*/ FD) {
    raw_svector_ostream OS = null;
    try {
      assert ((FD != null)) : "Invalid FunctionDecl!";
      IdentifierInfo /*P*/ FII = FD.getIdentifier();
      FunctionTemplateSpecializationInfo /*P*/ Info = FD.getTemplateSpecializationInfo();
      
      // Emit the unqualified name in normal operation. LLVM and the debugger can
      // compute the fully qualified name from the scope chain. If we're only
      // emitting line table info, there won't be any scope chains, so emit the
      // fully qualified name here so that stack traces are more accurate.
      // FIXME: Do this when emitting DWARF as well as when emitting CodeView after
      // evaluating the size impact.
      boolean UseQualifiedName = DebugKind == DebugInfoKind.DebugLineTablesOnly
         && CGM.getCodeGenOpts().EmitCodeView;
      if (!(Info != null) && (FII != null) && !UseQualifiedName) {
        return FII.getName();
      }
      
      SmallString/*<128>*/ NS/*J*/= new SmallString/*<128>*/(128);
      OS/*J*/= new raw_svector_ostream(NS);
      PrintingPolicy Policy/*J*/= new PrintingPolicy(CGM.getLangOpts());
      Policy.MSVCFormatting = CGM.getCodeGenOpts().EmitCodeView;
      if (!UseQualifiedName) {
        FD.printName(OS);
      } else {
        FD.printQualifiedName(OS, Policy);
      }
      
      // Add any template specialization args.
      if ((Info != null)) {
        /*const*/ TemplateArgumentList /*P*/ TArgs = Info.TemplateArguments;
        TemplateSpecializationType.PrintTemplateArgumentList1(OS, TArgs.asArray(), 
            Policy);
      }
      
      // Copy this name on the side and use its reference.
      return internString(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// Returns the unmangled name of an Objective-C method.
  /// This is the display name for the debugging info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getObjCMethodName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 220,
   FQN="clang::CodeGen::CGDebugInfo::getObjCMethodName", NM="_ZN5clang7CodeGen11CGDebugInfo17getObjCMethodNameEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo17getObjCMethodNameEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  private StringRef getObjCMethodName(/*const*/ ObjCMethodDecl /*P*/ OMD) {
    raw_svector_ostream OS = null;
    try {
      SmallString/*<256>*/ MethodName/*J*/= new SmallString/*<256>*/(256);
      OS/*J*/= new raw_svector_ostream(MethodName);
      OS.$out_char((OMD.isInstanceMethod() ? $$MINUS : $$PLUS)).$out_char($$LSQUARE);
      /*const*/ DeclContext /*P*/ DC = OMD.getDeclContext$Const();
      {
        /*const*/ ObjCImplementationDecl /*P*/ OID = dyn_cast_ObjCImplementationDecl(DC);
        if ((OID != null)) {
          OS.$out(OID.getName());
        } else {
          /*const*/ ObjCInterfaceDecl /*P*/ OID$1 = dyn_cast_ObjCInterfaceDecl(DC);
          if ((OID$1 != null)) {
            OS.$out(OID$1.getName());
          } else {
            /*const*/ ObjCCategoryDecl /*P*/ OC = dyn_cast_ObjCCategoryDecl(DC);
            if ((OC != null)) {
              if (OC.IsClassExtension()) {
                OS.$out(OC.getClassInterface$Const().getName());
              } else {
                OS.$out(OC.getIdentifier().getNameStart()).$out_char($$LPAREN).$out(
                    OC.getIdentifier().getNameStart()
                ).$out_char($$RPAREN);
              }
            } else {
              /*const*/ ObjCCategoryImplDecl /*P*/ OCD = dyn_cast_ObjCCategoryImplDecl(DC);
              if ((OCD != null)) {
                OS.$out(((/*const*/ NamedDecl /*P*/ )OCD).getIdentifier().getNameStart()).$out_char($$LPAREN).$out(
                    OCD.getIdentifier().getNameStart()
                ).$out_char($$RPAREN);
              } else if (isa_ObjCProtocolDecl(DC)) {
                {
                  // We can extract the type of the class from the self pointer.
                  ImplicitParamDecl /*P*/ SelfDecl = OMD.getSelfDecl();
                  if ((SelfDecl != null)) {
                    QualType ClassTy = cast_ObjCObjectPointerType(SelfDecl.getType()).getPointeeType();
                    ClassTy.print(OS, new PrintingPolicy(new LangOptions()));
                  }
                }
              }
            }
          }
        }
      }
      OS.$out_char($$SPACE).$out(OMD.getSelector().getAsString()).$out_char($$RSQUARE);
      
      return internString(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// Return selector name. This is used for debugging
  /// info.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getSelectorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 252,
   FQN="clang::CodeGen::CGDebugInfo::getSelectorName", NM="_ZN5clang7CodeGen11CGDebugInfo15getSelectorNameENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15getSelectorNameENS_8SelectorE")
  //</editor-fold>
  private StringRef getSelectorName(Selector S) {
    return internString(new StringRef(S.getAsString()));
  }

  
  /// Get class name including template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 256,
   FQN="clang::CodeGen::CGDebugInfo::getClassName", NM="_ZN5clang7CodeGen11CGDebugInfo12getClassNameEPKNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo12getClassNameEPKNS_10RecordDeclE")
  //</editor-fold>
  private StringRef getClassName(/*const*/ RecordDecl /*P*/ RD) {
    if (isa_ClassTemplateSpecializationDecl(RD)) {
      raw_svector_ostream OS = null;
      try {
        SmallString/*<128>*/ Name/*J*/= new SmallString/*<128>*/(128);
        OS/*J*/= new raw_svector_ostream(Name);
        RD.getNameForDiagnostic(OS, CGM.getContext().getPrintingPolicy(), 
            /*Qualified*/ false);
        
        // Copy this name on the side and use its reference.
        return internString(Name.$StringRef());
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
    {
      
      // quick optimization to avoid having to intern strings that are already
      // stored reliably elsewhere
      /*const*/ IdentifierInfo /*P*/ II = RD.getIdentifier();
      if ((II != null)) {
        return II.getName();
      }
    }
    
    // The CodeView printer in LLVM wants to see the names of unnamed types: it is
    // used to reconstruct the fully qualified type names.
    if (CGM.getCodeGenOpts().EmitCodeView) {
      {
        /*const*/ TypedefNameDecl /*P*/ D = RD.getTypedefNameForAnonDecl();
        if ((D != null)) {
          assert (RD.getDeclContext$Const() == D.getDeclContext$Const()) : "Typedef should not be in another decl context!";
          assert ((D.getDeclName().getAsIdentifierInfo() != null)) : "Typedef was not named!";
          return D.getDeclName().getAsIdentifierInfo().getName();
        }
      }
      if (CGM.getLangOpts().CPlusPlus) {
        StringRef Name/*J*/= new StringRef();
        
        final ASTContext /*&*/ Context = CGM.getContext();
        {
          /*const*/ DeclaratorDecl /*P*/ DD = Context.getDeclaratorForUnnamedTagDecl(RD);
          if ((DD != null)) {
            // Anonymous types without a name for linkage purposes have their
            // declarator mangled in if they have one.
            Name.$assignMove(DD.getName());
          } else {
            /*const*/ TypedefNameDecl /*P*/ TND = Context.getTypedefNameForUnnamedTagDecl(RD);
            if ((TND != null)) {
              // Anonymous types without a name for linkage purposes have their
              // associate typedef mangled in if they have one.
              Name.$assignMove(TND.getName());
            }
          }
        }
        if (!Name.empty()) {
          SmallString/*<256>*/ UnnamedType/*J*/= new SmallString/*<256>*/(256, new StringRef(/*KEEP_STR*/"<unnamed-type-"));
          UnnamedType.$addassign(/*NO_COPY*/Name);
          UnnamedType.$addassign($$GT);
          return internString(UnnamedType.$StringRef());
        }
      }
    }
    
    return new StringRef();
  }

  
  /// Get the vtable name for the given class.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getVTableName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1528,
   FQN="clang::CodeGen::CGDebugInfo::getVTableName", NM="_ZN5clang7CodeGen11CGDebugInfo13getVTableNameEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo13getVTableNameEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  private StringRef getVTableName(/*const*/ CXXRecordDecl /*P*/ RD) {
    // Copy the gdb compatible name on the side and use its reference.
    return internString(new StringRef(/*KEEP_STR*/"_vptr$"), new StringRef(RD.getNameAsString()));
  }

  
  /// Get line number for the location. If location is invalid
  /// then use current location.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getLineNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 352,
   FQN="clang::CodeGen::CGDebugInfo::getLineNumber", NM="_ZN5clang7CodeGen11CGDebugInfo13getLineNumberENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo13getLineNumberENS_14SourceLocationE")
  //</editor-fold>
  private /*uint*/int getLineNumber(SourceLocation Loc) {
    if (Loc.isInvalid() && CurLoc.isInvalid()) {
      return 0;
    }
    final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
    PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc.isValid() ? Loc : CurLoc);
    return PLoc.isValid() ? PLoc.getLine() : 0;
  }

  
  /// Get column number for the location. If location is
  /// invalid then use current location.
  /// \param Force  Assume DebugColumnInfo option is true.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::getColumnNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 360,
   FQN="clang::CodeGen::CGDebugInfo::getColumnNumber", NM="_ZN5clang7CodeGen11CGDebugInfo15getColumnNumberENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo15getColumnNumberENS_14SourceLocationEb")
  //</editor-fold>
  private /*uint*/int getColumnNumber(SourceLocation Loc) {
    return getColumnNumber(Loc, false);
  }
  private /*uint*/int getColumnNumber(SourceLocation Loc, boolean Force/*= false*/) {
    // We may not want column information at all.
    if (!Force && !CGM.getCodeGenOpts().DebugColumnInfo) {
      return 0;
    }
    
    // If the location is invalid then use the current column.
    if (Loc.isInvalid() && CurLoc.isInvalid()) {
      return 0;
    }
    final SourceManager /*&*/ SM = CGM.getContext().getSourceManager();
    PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*/Loc.isValid() ? Loc : CurLoc);
    return PLoc.isValid() ? PLoc.getColumn() : 0;
  }

  
  /// Collect various properties of a FunctionDecl.
  /// \param GD  A GlobalDecl whose getDecl() must return a FunctionDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::collectFunctionDeclProps">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2597,
   FQN="clang::CodeGen::CGDebugInfo::collectFunctionDeclProps", NM="_ZN5clang7CodeGen11CGDebugInfo24collectFunctionDeclPropsENS_10GlobalDeclEPN4llvm6DIFileERNS3_9StringRefES7_RPNS3_7DIScopeERNS3_24MDTupleTypedArrayWrapperINS3_6DINodeEEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo24collectFunctionDeclPropsENS_10GlobalDeclEPN4llvm6DIFileERNS3_9StringRefES7_RPNS3_7DIScopeERNS3_24MDTupleTypedArrayWrapperINS3_6DINodeEEERj")
  //</editor-fold>
  private void collectFunctionDeclProps(GlobalDecl GD, DIFile /*P*/ Unit, 
                          final StringRef /*&*/ Name, 
                          final StringRef /*&*/ LinkageName, 
                          final type$ref<DIScope /*P*/ /*&*/> FDContext, 
                          final MDTupleTypedArrayWrapper<DINode> /*&*/ TParamsArray, 
                          final uint$ref/*uint &*/ Flags) {
    /*const*/ FunctionDecl /*P*/ FD = cast_FunctionDecl(GD.getDecl());
    Name.$assignMove(getFunctionName(FD));
    // Use mangled name as linkage name for C/C++ functions.
    if (FD.hasPrototype()) {
      LinkageName.$assignMove(CGM.getMangledName(new GlobalDecl(GD)));
      Flags.$set$orassign(DINode.DIFlags.FlagPrototyped);
    }
    // No need to replicate the linkage name if it isn't different from the
    // subprogram name, no need to have it at all unless coverage is enabled or
    // debug is set to more than just line tables.
    if ($eq_StringRef(/*NO_COPY*/LinkageName, /*NO_COPY*/Name) || (!CGM.getCodeGenOpts().EmitGcovArcs
       && !CGM.getCodeGenOpts().EmitGcovNotes
       && DebugKind.getValue() <= DebugInfoKind.DebugLineTablesOnly.getValue())) {
      LinkageName.$assignMove(new StringRef());
    }
    if (DebugKind.getValue() >= DebugInfoKind.LimitedDebugInfo.getValue()) {
      {
        /*const*/ NamespaceDecl /*P*/ NSDecl = dyn_cast_or_null_NamespaceDecl(FD.getDeclContext$Const());
        if ((NSDecl != null)) {
          FDContext.$set(getOrCreateNameSpace(NSDecl));
        } else {
          /*const*/ RecordDecl /*P*/ RDecl = dyn_cast_or_null_RecordDecl(FD.getDeclContext$Const());
          if ((RDecl != null)) {
            DIScope /*P*/ Mod = getParentModuleOrNull(RDecl);
            FDContext.$set(getContextDescriptor(RDecl, (Mod != null) ? Mod : TheCU));
          }
        }
      }
      // Collect template parameters.
      TParamsArray.$assignMove(CollectFunctionTemplateParams(FD, Unit));
    }
  }

  
  /// Collect various properties of a VarDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::collectVarDeclProps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2632,
   FQN="clang::CodeGen::CGDebugInfo::collectVarDeclProps", NM="_ZN5clang7CodeGen11CGDebugInfo19collectVarDeclPropsEPKNS_7VarDeclERPN4llvm6DIFileERjRNS_8QualTypeERNS5_9StringRefESD_RPNS5_7DIScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo19collectVarDeclPropsEPKNS_7VarDeclERPN4llvm6DIFileERjRNS_8QualTypeERNS5_9StringRefESD_RPNS5_7DIScopeE")
  //</editor-fold>
  private void collectVarDeclProps(/*const*/ VarDecl /*P*/ VD, final type$ref<DIFile /*P*/ /*&*/> Unit, 
                     final uint$ref/*uint &*/ LineNo, final QualType /*&*/ T, 
                     final StringRef /*&*/ Name, final StringRef /*&*/ LinkageName, 
                     final type$ref<DIScope /*P*/ /*&*/> VDContext) {
    Unit.$set(getOrCreateFile(VD.getLocation()));
    LineNo.$set(getLineNumber(VD.getLocation()));
    
    setLocation(VD.getLocation());
    
    T.$assignMove(VD.getType());
    if (T.$arrow().isIncompleteArrayType()) {
      // CodeGen turns int[] into int[1] so we'll do the same here.
      APInt ConstVal/*J*/= new APInt(JD$UInt_ULong.INSTANCE, 32, $int2ulong(1));
      QualType ET = CGM.getContext().getAsArrayType(new QualType(T)).getElementType();
      
      T.$assignMove(CGM.getContext().getConstantArrayType(new QualType(ET), ConstVal, 
              org.clang.ast.ArrayType.ArraySizeModifier.Normal, 0));
    }
    
    Name.$assignMove(VD.getName());
    if ((VD.getDeclContext$Const() != null) && !isa_FunctionDecl(VD.getDeclContext$Const())
       && !isa_ObjCMethodDecl(VD.getDeclContext$Const())) {
      LinkageName.$assignMove(CGM.getMangledName(new GlobalDecl(VD)));
    }
    if ($eq_StringRef(/*NO_COPY*/LinkageName, /*NO_COPY*/Name)) {
      LinkageName.$assignMove(new StringRef());
    }
    
    // Since we emit declarations (DW_AT_members) for static members, place the
    // definition of those static members in the namespace they were declared in
    // in the source code (the lexical decl context).
    // FIXME: Generalize this for even non-member global variables where the
    // declaration and definition may have different lexical decl contexts, once
    // we have support for emitting declarations of (non-member) global variables.
    /*const*/ DeclContext /*P*/ DC = VD.isStaticDataMember() ? VD.getLexicalDeclContext$Const() : VD.getDeclContext$Const();
    // When a record type contains an in-line initialization of a static data
    // member, and the record type is marked as __declspec(dllexport), an implicit
    // definition of the member will be created in the record context.  DWARF
    // doesn't seem to have a nice way to describe this in a form that consumers
    // are likely to understand, so fake the "normal" situation of a definition
    // outside the class by putting it in the global scope.
    if (DC.isRecord()) {
      DC = CGM.getContext().getTranslationUnitDecl();
    }
    
    DIScope /*P*/ Mod = getParentModuleOrNull(VD);
    VDContext.$set(getContextDescriptor(cast_Decl(DC), (Mod != null) ? Mod : TheCU));
  }

  
  /// Allocate a copy of \p A using the DebugInfoNames allocator
  /// and return a reference to it. If multiple arguments are given the strings
  /// are concatenated.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGDebugInfo::internString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.h", line = 527,
   FQN="clang::CodeGen::CGDebugInfo::internString", NM="_ZN5clang7CodeGen11CGDebugInfo12internStringEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN5clang7CodeGen11CGDebugInfo12internStringEN4llvm9StringRefES3_")
  //</editor-fold>
  private StringRef internString(StringRef A) {
    return internString(A, new StringRef());
  }
  private StringRef internString(StringRef A, StringRef B/*= StringRef()*/) {
    char$ptr/*char P*/ Data = $tryClone(DebugInfoNames.Allocate(A.size() + B.size()));
    if (!A.empty()) {
      std.memcpy(Data, A.data(), A.size());
    }
    if (!B.empty()) {
      std.memcpy(Data.$add(A.size()), B.data(), B.size());
    }
    return new StringRef(Data, A.size() + B.size());
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", DebugKind=" + DebugKind // NOI18N
              + ", DebugTypeExtRefs=" + DebugTypeExtRefs // NOI18N
              + ", DBuilder=" + "[DIBuilder]" // NOI18N
              + ", TheCU=" + TheCU // NOI18N
              + ", ClangModuleMap=" + ClangModuleMap // NOI18N
              + ", PCHDescriptor=" + PCHDescriptor // NOI18N
              + ", CurLoc=" + CurLoc // NOI18N
              + ", VTablePtrType=" + VTablePtrType // NOI18N
              + ", ClassTy=" + ClassTy // NOI18N
              + ", ObjTy=" + ObjTy // NOI18N
              + ", SelTy=" + SelTy // NOI18N
              + ", OCLImage1dROTy=" + OCLImage1dROTy // NOI18N
              + ", OCLImage1dArrayROTy=" + OCLImage1dArrayROTy // NOI18N
              + ", OCLImage1dBufferROTy=" + OCLImage1dBufferROTy // NOI18N
              + ", OCLImage2dROTy=" + OCLImage2dROTy // NOI18N
              + ", OCLImage2dArrayROTy=" + OCLImage2dArrayROTy // NOI18N
              + ", OCLImage2dDepthROTy=" + OCLImage2dDepthROTy // NOI18N
              + ", OCLImage2dArrayDepthROTy=" + OCLImage2dArrayDepthROTy // NOI18N
              + ", OCLImage2dMSAAROTy=" + OCLImage2dMSAAROTy // NOI18N
              + ", OCLImage2dArrayMSAAROTy=" + OCLImage2dArrayMSAAROTy // NOI18N
              + ", OCLImage2dMSAADepthROTy=" + OCLImage2dMSAADepthROTy // NOI18N
              + ", OCLImage2dArrayMSAADepthROTy=" + OCLImage2dArrayMSAADepthROTy // NOI18N
              + ", OCLImage3dROTy=" + OCLImage3dROTy // NOI18N
              + ", OCLImage1dWOTy=" + OCLImage1dWOTy // NOI18N
              + ", OCLImage1dArrayWOTy=" + OCLImage1dArrayWOTy // NOI18N
              + ", OCLImage1dBufferWOTy=" + OCLImage1dBufferWOTy // NOI18N
              + ", OCLImage2dWOTy=" + OCLImage2dWOTy // NOI18N
              + ", OCLImage2dArrayWOTy=" + OCLImage2dArrayWOTy // NOI18N
              + ", OCLImage2dDepthWOTy=" + OCLImage2dDepthWOTy // NOI18N
              + ", OCLImage2dArrayDepthWOTy=" + OCLImage2dArrayDepthWOTy // NOI18N
              + ", OCLImage2dMSAAWOTy=" + OCLImage2dMSAAWOTy // NOI18N
              + ", OCLImage2dArrayMSAAWOTy=" + OCLImage2dArrayMSAAWOTy // NOI18N
              + ", OCLImage2dMSAADepthWOTy=" + OCLImage2dMSAADepthWOTy // NOI18N
              + ", OCLImage2dArrayMSAADepthWOTy=" + OCLImage2dArrayMSAADepthWOTy // NOI18N
              + ", OCLImage3dWOTy=" + OCLImage3dWOTy // NOI18N
              + ", OCLImage1dRWTy=" + OCLImage1dRWTy // NOI18N
              + ", OCLImage1dArrayRWTy=" + OCLImage1dArrayRWTy // NOI18N
              + ", OCLImage1dBufferRWTy=" + OCLImage1dBufferRWTy // NOI18N
              + ", OCLImage2dRWTy=" + OCLImage2dRWTy // NOI18N
              + ", OCLImage2dArrayRWTy=" + OCLImage2dArrayRWTy // NOI18N
              + ", OCLImage2dDepthRWTy=" + OCLImage2dDepthRWTy // NOI18N
              + ", OCLImage2dArrayDepthRWTy=" + OCLImage2dArrayDepthRWTy // NOI18N
              + ", OCLImage2dMSAARWTy=" + OCLImage2dMSAARWTy // NOI18N
              + ", OCLImage2dArrayMSAARWTy=" + OCLImage2dArrayMSAARWTy // NOI18N
              + ", OCLImage2dMSAADepthRWTy=" + OCLImage2dMSAADepthRWTy // NOI18N
              + ", OCLImage2dArrayMSAADepthRWTy=" + OCLImage2dArrayMSAADepthRWTy // NOI18N
              + ", OCLImage3dRWTy=" + OCLImage3dRWTy // NOI18N
              + ", OCLEventDITy=" + OCLEventDITy // NOI18N
              + ", OCLClkEventDITy=" + OCLClkEventDITy // NOI18N
              + ", OCLQueueDITy=" + OCLQueueDITy // NOI18N
              + ", OCLNDRangeDITy=" + OCLNDRangeDITy // NOI18N
              + ", OCLReserveIDDITy=" + OCLReserveIDDITy // NOI18N
              + ", TypeCache=" + TypeCache // NOI18N
              + ", DebugPrefixMap=" + DebugPrefixMap // NOI18N
              + ", ObjCInterfaceCache=" + ObjCInterfaceCache // NOI18N
              + ", ModuleCache=" + ModuleCache // NOI18N
              + ", RetainedTypes=" + RetainedTypes // NOI18N
              + ", ReplaceMap=" + ReplaceMap // NOI18N
              + ", FwdDeclReplaceMap=" + FwdDeclReplaceMap // NOI18N
              + ", LexicalBlockStack=" + LexicalBlockStack // NOI18N
              + ", RegionMap=" + RegionMap // NOI18N
              + ", FnBeginRegionCount=" + FnBeginRegionCount // NOI18N
              + ", DebugInfoNames=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", CWDName=" + CWDName // NOI18N
              + ", DIFileCache=" + DIFileCache // NOI18N
              + ", SPCache=" + SPCache // NOI18N
              + ", DeclCache=" + DeclCache // NOI18N
              + ", NameSpaceCache=" + NameSpaceCache // NOI18N
              + ", NamespaceAliasCache=" + NamespaceAliasCache // NOI18N
              + ", StaticDataMemberCache=" + StaticDataMemberCache; // NOI18N
  }
}

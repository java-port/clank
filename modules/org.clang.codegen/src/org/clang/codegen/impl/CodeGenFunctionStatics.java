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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.dyn_cast_or_null_CompoundStmt;
import static org.clang.ast.java.AstStatementsRTTI.isa_ReturnStmt;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunctionStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL10EmitIfUsedRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE;_ZL14TryMarkNoThrowPN4llvm8FunctionE;_ZL14endsWithReturnPKN5clang4DeclE;_ZL18emitNonZeroVLAInitRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_7AddressES4_PN4llvm5ValueE;_ZL19hasRequiredFeaturesRKN4llvm15SmallVectorImplINS_9StringRefEEERN5clang7CodeGen13CodeGenModuleEPKNS5_12FunctionDeclERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZL20GenOpenCLArgMetadataPKN5clang12FunctionDeclEPN4llvm8FunctionERNS_7CodeGen13CodeGenModuleERNS3_11LLVMContextERNS6_11CGBuilderTyERNS_10ASTContextE; -static-type=CodeGenFunctionStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CodeGenFunctionStatics {

//<editor-fold defaultstate="collapsed" desc="EmitIfUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 267,
 FQN="EmitIfUsed", NM="_ZL10EmitIfUsedRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL10EmitIfUsedRN5clang7CodeGen15CodeGenFunctionEPN4llvm10BasicBlockE")
//</editor-fold>
public static void EmitIfUsed(final CodeGenFunction /*&*/ CGF, BasicBlock /*P*/ BB) {
  if (!(BB != null)) {
    return;
  }
  if (!BB.use_empty()) {
    CGF.CurFn.getBasicBlockList().push_back(BB);
    /*JAVA:return*/return;
  }
  /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)BB);
}


// OpenCL v1.2 s5.6.4.6 allows the compiler to store kernel argument
// information in the program executable. The argument information stored
// includes the argument name, its type, the address and access qualifiers used.
//<editor-fold defaultstate="collapsed" desc="GenOpenCLArgMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 442,
 FQN="GenOpenCLArgMetadata", NM="_ZL20GenOpenCLArgMetadataPKN5clang12FunctionDeclEPN4llvm8FunctionERNS_7CodeGen13CodeGenModuleERNS3_11LLVMContextERNS6_11CGBuilderTyERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL20GenOpenCLArgMetadataPKN5clang12FunctionDeclEPN4llvm8FunctionERNS_7CodeGen13CodeGenModuleERNS3_11LLVMContextERNS6_11CGBuilderTyERNS_10ASTContextE")
//</editor-fold>
public static void GenOpenCLArgMetadata(/*const*/ FunctionDecl /*P*/ FD, Function /*P*/ Fn, 
                    final CodeGenModule /*&*/ CGM, final LLVMContext /*&*/ Context, 
                    final CGBuilderTy /*&*/ Builder, final ASTContext /*&*/ ASTCtx) {
  // Create MDNodes that represent the kernel arg metadata.
  // Each MDNode is a list in the form of "key", N number of values which is
  // the same number of values as their are kernel arguments.
  final /*const*/ PrintingPolicy /*&*/ Policy = ASTCtx.getPrintingPolicy();
  
  // MDNode for the kernel argument address space qualifiers.
  SmallVector<Metadata /*P*/ > addressQuals/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  
  // MDNode for the kernel argument access qualifiers (images only).
  SmallVector<Metadata /*P*/ > accessQuals/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  
  // MDNode for the kernel argument type names.
  SmallVector<Metadata /*P*/ > argTypeNames/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  
  // MDNode for the kernel argument base type names.
  SmallVector<Metadata /*P*/ > argBaseTypeNames/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  
  // MDNode for the kernel argument type qualifiers.
  SmallVector<Metadata /*P*/ > argTypeQuals/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  
  // MDNode for the kernel argument names.
  SmallVector<Metadata /*P*/ > argNames/*J*/= new SmallVector<Metadata /*P*/ >(8, (Metadata /*P*/ )null);
  
  for (/*uint*/int i = 0, e = FD.getNumParams(); i != e; ++i) {
    /*const*/ ParmVarDecl /*P*/ parm = FD.getParamDecl$Const(i);
    QualType ty = parm.getType();
    std.string typeQuals/*J*/= new std.string();
    if (ty.$arrow().isPointerType()) {
      QualType pointeeTy = ty.$arrow().getPointeeType();
      
      // Get address qualifier.
      addressQuals.push_back(ConstantAsMetadata.get(Builder.getInt32(ASTCtx.getTargetAddressSpace(pointeeTy.getAddressSpace()))));
      
      // Get argument type name.
      std.string typeName = $add_string_T$C$P(pointeeTy.getUnqualifiedType().getAsString(Policy), /*KEEP_STR*/"*");
      
      // Turn "unsigned type" to "utype"
      /*size_t*/int pos = typeName.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"unsigned");
      if (pointeeTy.isCanonical() && pos != std.string.npos) {
        typeName.erase(pos + 1, 8);
      }
      
      argTypeNames.push_back(MDString.get(Context, new StringRef(typeName)));
      
      std.string baseTypeName = $add_string_T$C$P(pointeeTy.getUnqualifiedType().getCanonicalType().getAsString(Policy), 
          /*KEEP_STR*/"*");
      
      // Turn "unsigned type" to "utype"
      pos = baseTypeName.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"unsigned");
      if (pos != std.string.npos) {
        baseTypeName.erase(pos + 1, 8);
      }
      
      argBaseTypeNames.push_back(MDString.get(Context, new StringRef(baseTypeName)));
      
      // Get argument type qualifiers:
      if (ty.isRestrictQualified()) {
        typeQuals.$assign_T$C$P(/*KEEP_STR*/"restrict");
      }
      if (pointeeTy.isConstQualified()
         || (pointeeTy.getAddressSpace() == LangAS.ID.opencl_constant)) {
        typeQuals.$addassign_T$C$P(typeQuals.empty() ? $const : $(" const"));
      }
      if (pointeeTy.isVolatileQualified()) {
        typeQuals.$addassign_T$C$P(typeQuals.empty() ? $volatile : $(" volatile"));
      }
    } else {
      /*uint32_t*/int AddrSpc = 0;
      boolean isPipe = ty.$arrow().isPipeType();
      if (ty.$arrow().isImageType() || isPipe) {
        AddrSpc
           = CGM.getContext().getTargetAddressSpace(LangAS.ID.opencl_global);
      }
      
      addressQuals.push_back(ConstantAsMetadata.get(Builder.getInt32(AddrSpc)));
      
      // Get argument type name.
      std.string typeName/*J*/= new std.string();
      if (isPipe) {
        typeName.$assignMove(ty.getCanonicalType().$arrow().getAs(PipeType.class).getElementType().
                getAsString(Policy));
      } else {
        typeName.$assignMove(ty.getUnqualifiedType().getAsString(Policy));
      }
      
      // Turn "unsigned type" to "utype"
      /*size_t*/int pos = typeName.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"unsigned");
      if (ty.isCanonical() && pos != std.string.npos) {
        typeName.erase(pos + 1, 8);
      }
      
      argTypeNames.push_back(MDString.get(Context, new StringRef(typeName)));
      
      std.string baseTypeName/*J*/= new std.string();
      if (isPipe) {
        baseTypeName.$assignMove(ty.getCanonicalType().$arrow().getAs(PipeType.class).
                getElementType().getCanonicalType().
                getAsString(Policy));
      } else {
        baseTypeName.$assignMove(
            ty.getUnqualifiedType().getCanonicalType().getAsString(Policy)
        );
      }
      
      // Turn "unsigned type" to "utype"
      pos = baseTypeName.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"unsigned");
      if (pos != std.string.npos) {
        baseTypeName.erase(pos + 1, 8);
      }
      
      argBaseTypeNames.push_back(MDString.get(Context, new StringRef(baseTypeName)));
      
      // Get argument type qualifiers:
      if (ty.isConstQualified()) {
        typeQuals.$assign_T$C$P(/*KEEP_STR*/"const");
      }
      if (ty.isVolatileQualified()) {
        typeQuals.$addassign_T$C$P(typeQuals.empty() ? $volatile : $(" volatile"));
      }
      if (isPipe) {
        typeQuals.$assign_T$C$P(/*KEEP_STR*/"pipe");
      }
    }
    
    argTypeQuals.push_back(MDString.get(Context, new StringRef(typeQuals)));
    
    // Get image and pipe access qualifier:
    if (ty.$arrow().isImageType() || ty.$arrow().isPipeType()) {
      /*const*/ OpenCLAccessAttr /*P*/ A = parm.getAttr(OpenCLAccessAttr.class);
      if ((A != null) && A.isWriteOnly()) {
        accessQuals.push_back(MDString.get(Context, $write_only));
      } else if ((A != null) && A.isReadWrite()) {
        accessQuals.push_back(MDString.get(Context, $read_write));
      } else {
        accessQuals.push_back(MDString.get(Context, $read_only));
      }
    } else {
      accessQuals.push_back(MDString.get(Context, $("none")));
    }
    
    // Get argument name.
    argNames.push_back(MDString.get(Context, parm.getName()));
  }
  
  Fn.setMetadata(new StringRef(/*KEEP_STR*/"kernel_arg_addr_space"), 
      MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(addressQuals, true)));
  Fn.setMetadata(new StringRef(/*KEEP_STR*/"kernel_arg_access_qual"), 
      MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(accessQuals, true)));
  Fn.setMetadata(new StringRef(/*KEEP_STR*/"kernel_arg_type"), 
      MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(argTypeNames, true)));
  Fn.setMetadata(new StringRef(/*KEEP_STR*/"kernel_arg_base_type"), 
      MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(argBaseTypeNames, true)));
  Fn.setMetadata(new StringRef(/*KEEP_STR*/"kernel_arg_type_qual"), 
      MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(argTypeQuals, true)));
  if (CGM.getCodeGenOpts().EmitOpenCLArgMetadata) {
    Fn.setMetadata(new StringRef(/*KEEP_STR*/"kernel_arg_name"), 
        MDNode.get(Context, new ArrayRef<Metadata /*P*/ >(argNames, true)));
  }
}


/// Determine whether the function F ends with a return stmt.
//<editor-fold defaultstate="collapsed" desc="endsWithReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 638,
 FQN="endsWithReturn", NM="_ZL14endsWithReturnPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL14endsWithReturnPKN5clang4DeclE")
//</editor-fold>
public static boolean endsWithReturn(/*const*/ Decl /*P*/ F) {
  /*const*/ Stmt /*P*/ Body = null;
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(F);
    if ((FD != null)) {
      Body = FD.getBody();
    } else {
      /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_or_null_ObjCMethodDecl(F);
      if ((OMD != null)) {
        Body = OMD.getBody();
      }
    }
  }
  {
    
    /*const*/ CompoundStmt /*P*/ CS = dyn_cast_or_null_CompoundStmt(Body);
    if ((CS != null)) {
      std.reverse_iterator<Stmt /*P*/ /*const*/> LastStmt = CS.body_rbegin$Const();
      if ($noteq_reverse_iterator$C(LastStmt, CS.body_rend$Const())) {
        return isa_ReturnStmt(LastStmt.$star());
      }
    }
  }
  return false;
}


/// Tries to mark the given function nounwind based on the
/// non-existence of any throwing calls within it.  We believe this is
/// lightweight enough to do at -O0.
//<editor-fold defaultstate="collapsed" desc="TryMarkNoThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 940,
 FQN="TryMarkNoThrow", NM="_ZL14TryMarkNoThrowPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL14TryMarkNoThrowPN4llvm8FunctionE")
//</editor-fold>
public static void TryMarkNoThrow(Function /*P*/ F) {
  // LLVM treats 'nounwind' on a function as part of the type, so we
  // can't do this on functions that can be overwritten.
  if (F.isInterposable()) {
    return;
  }
  
  for (final BasicBlock /*&*/ BB : /*Deref*/F)  {
    for (final Instruction /*&*/ I : BB)  {
      if (I.mayThrow()) {
        return;
      }
    }
  }
  
  F.setDoesNotThrow();
}


/// emitNonZeroVLAInit - Emit the "zero" initialization of a
/// variable-length array whose elements have a non-zero bit-pattern.
///
/// \param baseType the inner-most element type of the array
/// \param src - a char* pointing to the bit-pattern for a single
/// base element of the array
/// \param sizeInChars - the total size of the VLA, in chars
//<editor-fold defaultstate="collapsed" desc="emitNonZeroVLAInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1394,
 FQN="emitNonZeroVLAInit", NM="_ZL18emitNonZeroVLAInitRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_7AddressES4_PN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL18emitNonZeroVLAInitRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_7AddressES4_PN4llvm5ValueE")
//</editor-fold>
public static void emitNonZeroVLAInit(final CodeGenFunction /*&*/ CGF, QualType baseType, 
                  Address dest, Address src, 
                  Value /*P*/ sizeInChars) {
  final CGBuilderTy /*&*/ Builder = CGF.Builder;
  
  CharUnits baseSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/baseType);
  Value /*P*/ baseSizeInChars = ConstantInt.get(CGF.Unnamed_field8.IntPtrTy, baseSize.getQuantity());
  
  Address begin = Builder.CreateElementBitCast(new Address(dest), CGF.Int8Ty, new Twine(/*KEEP_STR*/"vla.begin"));
  Value /*P*/ end = Builder.CreateInBoundsGEP(begin.getPointer(), new ArrayRef<Value /*P*/ >(sizeInChars, true), new Twine(/*KEEP_STR*/"vla.end"));
  
  BasicBlock /*P*/ originBB = CGF.Builder.GetInsertBlock();
  BasicBlock /*P*/ loopBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vla-init.loop"));
  BasicBlock /*P*/ contBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"vla-init.cont"));
  
  // Make a loop over the VLA.  C99 guarantees that the VLA element
  // count must be nonzero.
  CGF.EmitBlock(loopBB);
  
  PHINode /*P*/ cur = Builder.CreatePHI(begin.getType(), 2, new Twine(/*KEEP_STR*/"vla.cur"));
  cur.addIncoming(begin.getPointer(), originBB);
  
  CharUnits curAlign = dest.getAlignment().alignmentOfArrayElement(new CharUnits(baseSize));
  
  // memcpy the individual element bit-pattern.
  Builder.CreateMemCpy(new Address(cur, new CharUnits(curAlign)), new Address(src), baseSizeInChars, 
      /*volatile*/ false);
  
  // Go to the next element.
  Value /*P*/ next = Builder.CreateInBoundsGEP(CGF.Int8Ty, cur, baseSizeInChars, new Twine(/*KEEP_STR*/"vla.next"));
  
  // Leave if that's the end of the VLA.
  Value /*P*/ done = Builder.CreateICmpEQ(next, end, new Twine(/*KEEP_STR*/"vla-init.isdone"));
  Builder.CreateCondBr(done, contBB, loopBB);
  cur.addIncoming(next, loopBB);
  
  CGF.EmitBlock(contBB);
}

//<editor-fold defaultstate="collapsed" desc="hasRequiredFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1925,
 FQN="hasRequiredFeatures", NM="_ZL19hasRequiredFeaturesRKN4llvm15SmallVectorImplINS_9StringRefEEERN5clang7CodeGen13CodeGenModuleEPKNS5_12FunctionDeclERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZL19hasRequiredFeaturesRKN4llvm15SmallVectorImplINS_9StringRefEEERN5clang7CodeGen13CodeGenModuleEPKNS5_12FunctionDeclERSs")
//</editor-fold>
public static boolean hasRequiredFeatures(final /*const*/ SmallVectorImpl<StringRef> /*&*/ ReqFeatures, 
                   final CodeGenModule /*&*/ CGM, /*const*/ FunctionDecl /*P*/ FD, 
                   final std.string/*&*/ FirstMissing) {
  StringMapBool CallerFeatureMap = null;
  try {
    // If there aren't any required features listed then go ahead and return.
    if (ReqFeatures.empty()) {
      return false;
    }
    
    // Now build up the set of caller features and verify that all the required
    // features are there.
    CallerFeatureMap/*J*/= new StringMapBool(false);
    CGM.getFunctionFeatureMap(CallerFeatureMap, FD);
    
    // If we have at least one of the features in the feature list return
    // true, otherwise return false.
    final StringMapBool _CallerFeatureMap = CallerFeatureMap;
    return std.all_of(ReqFeatures.begin$Const(), ReqFeatures.end$Const(), /*[&, &CallerFeatureMap, &FirstMissing]*/ (StringRef Feature) -> {
              SmallVector<StringRef> OrFeatures/*J*/= new SmallVector<StringRef>(1, new StringRef());
              Feature.split(OrFeatures, /*STRINGREF_STR*/"|");
              return std.any_of(OrFeatures.begin(), OrFeatures.end(), 
                  /*[&, &CallerFeatureMap, &FirstMissing]*/ (StringRef Feature$1) -> {
                        if (!_CallerFeatureMap.lookup(new StringRef(Feature$1))) {
                          FirstMissing.$assignMove(Feature$1.str());
                          return false;
                        }
                        return true;
                      });
            });
  } finally {
    if (CallerFeatureMap != null) { CallerFeatureMap.$destroy(); }
  }
}

} // END OF class CodeGenFunctionStatics

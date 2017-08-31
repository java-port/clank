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

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstTypesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenCLRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.h", line = 32,
 FQN="clang::CodeGen::CGOpenCLRuntime", NM="_ZN5clang7CodeGen15CGOpenCLRuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenCLRuntimeE")
//</editor-fold>
public class CGOpenCLRuntime implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final CodeGenModule /*&*/ CGM;
  protected Type /*P*/ PipeTy;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenCLRuntime::CGOpenCLRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.h", line = 38,
   FQN="clang::CodeGen::CGOpenCLRuntime::CGOpenCLRuntime", NM="_ZN5clang7CodeGen15CGOpenCLRuntimeC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenCLRuntimeC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public CGOpenCLRuntime(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM), PipeTy(null) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    this.PipeTy = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenCLRuntime::~CGOpenCLRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp", line = 25,
   FQN="clang::CodeGen::CGOpenCLRuntime::~CGOpenCLRuntime", NM="_ZN5clang7CodeGen15CGOpenCLRuntimeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenCLRuntimeD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Emit the IR required for a work-group-local variable declaration, and add
  /// an entry to CGF's LocalDeclMap for D.  The base class does this using
  /// CodeGenFunction::EmitStaticVarDecl to emit an internal global for D.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenCLRuntime::EmitWorkGroupLocalVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp", line = 27,
   FQN="clang::CodeGen::CGOpenCLRuntime::EmitWorkGroupLocalVarDecl", NM="_ZN5clang7CodeGen15CGOpenCLRuntime25EmitWorkGroupLocalVarDeclERNS0_15CodeGenFunctionERKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenCLRuntime25EmitWorkGroupLocalVarDeclERNS0_15CodeGenFunctionERKNS_7VarDeclE")
  //</editor-fold>
  public void EmitWorkGroupLocalVarDecl(final CodeGenFunction /*&*/ CGF, 
                           final /*const*/ VarDecl /*&*/ D) {
    CGF.EmitStaticVarDecl(D, GlobalValue.LinkageTypes.InternalLinkage);
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenCLRuntime::convertOpenCLSpecificType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp", line = 32,
   FQN="clang::CodeGen::CGOpenCLRuntime::convertOpenCLSpecificType", NM="_ZN5clang7CodeGen15CGOpenCLRuntime25convertOpenCLSpecificTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenCLRuntime25convertOpenCLSpecificTypeEPKNS_4TypeE")
  //</editor-fold>
  public Type /*P*/ convertOpenCLSpecificType(/*const*/ org.clang.ast.Type /*P*/ T) {
    assert (T.isOpenCLSpecificType()) : "Not an OpenCL specific type!";
    
    final LLVMContext /*&*/ Ctx = CGM.getLLVMContext();
    /*uint32_t*/int ImgAddrSpc = CGM.getContext().getTargetAddressSpace(LangAS.ID.opencl_global);
    switch (cast_BuiltinType(T).getKind()) {
     default:
      throw new llvm_unreachable("Unexpected opencl builtin type!");
//      return null;
     case OCLImage1dRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_ro_t")), ImgAddrSpc);
     case OCLImage1dArrayRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_array_ro_t")), ImgAddrSpc);
     case OCLImage1dBufferRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_buffer_ro_t")), ImgAddrSpc);
     case OCLImage2dRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_ro_t")), ImgAddrSpc);
     case OCLImage2dArrayRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_ro_t")), ImgAddrSpc);
     case OCLImage2dDepthRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_depth_ro_t")), ImgAddrSpc);
     case OCLImage2dArrayDepthRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_depth_ro_t")), ImgAddrSpc);
     case OCLImage2dMSAARO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_msaa_ro_t")), ImgAddrSpc);
     case OCLImage2dArrayMSAARO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_msaa_ro_t")), ImgAddrSpc);
     case OCLImage2dMSAADepthRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_msaa_depth_ro_t")), ImgAddrSpc);
     case OCLImage2dArrayMSAADepthRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_msaa_depth_ro_t")), ImgAddrSpc);
     case OCLImage3dRO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image3d_ro_t")), ImgAddrSpc);
     case OCLImage1dWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_wo_t")), ImgAddrSpc);
     case OCLImage1dArrayWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_array_wo_t")), ImgAddrSpc);
     case OCLImage1dBufferWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_buffer_wo_t")), ImgAddrSpc);
     case OCLImage2dWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_wo_t")), ImgAddrSpc);
     case OCLImage2dArrayWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_wo_t")), ImgAddrSpc);
     case OCLImage2dDepthWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_depth_wo_t")), ImgAddrSpc);
     case OCLImage2dArrayDepthWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_depth_wo_t")), ImgAddrSpc);
     case OCLImage2dMSAAWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_msaa_wo_t")), ImgAddrSpc);
     case OCLImage2dArrayMSAAWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_msaa_wo_t")), ImgAddrSpc);
     case OCLImage2dMSAADepthWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_msaa_depth_wo_t")), ImgAddrSpc);
     case OCLImage2dArrayMSAADepthWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_msaa_depth_wo_t")), ImgAddrSpc);
     case OCLImage3dWO:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image3d_wo_t")), ImgAddrSpc);
     case OCLImage1dRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_rw_t")), ImgAddrSpc);
     case OCLImage1dArrayRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_array_rw_t")), ImgAddrSpc);
     case OCLImage1dBufferRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image1d_buffer_rw_t")), ImgAddrSpc);
     case OCLImage2dRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_rw_t")), ImgAddrSpc);
     case OCLImage2dArrayRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_rw_t")), ImgAddrSpc);
     case OCLImage2dDepthRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_depth_rw_t")), ImgAddrSpc);
     case OCLImage2dArrayDepthRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_depth_rw_t")), ImgAddrSpc);
     case OCLImage2dMSAARW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_msaa_rw_t")), ImgAddrSpc);
     case OCLImage2dArrayMSAARW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_msaa_rw_t")), ImgAddrSpc);
     case OCLImage2dMSAADepthRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_msaa_depth_rw_t")), ImgAddrSpc);
     case OCLImage2dArrayMSAADepthRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image2d_array_msaa_depth_rw_t")), ImgAddrSpc);
     case OCLImage3dRW:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.image3d_rw_t")), ImgAddrSpc);
     case OCLSampler:
      return IntegerType.get(Ctx, 32);
     case OCLEvent:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.event_t")), 0);
     case OCLClkEvent:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.clk_event_t")), 0);
     case OCLQueue:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.queue_t")), 0);
     case OCLNDRange:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.ndrange_t")), 0);
     case OCLReserveID:
      return PointerType.get(StructType.create(Ctx, new StringRef(/*KEEP_STR*/"opencl.reserve_id_t")), 0);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGOpenCLRuntime::getPipeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp", line = 69,
   FQN="clang::CodeGen::CGOpenCLRuntime::getPipeType", NM="_ZN5clang7CodeGen15CGOpenCLRuntime11getPipeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenCLRuntime.cpp -nm=_ZN5clang7CodeGen15CGOpenCLRuntime11getPipeTypeEv")
  //</editor-fold>
  public Type /*P*/ getPipeType() {
    if (!(PipeTy != null)) {
      /*uint32_t*/int PipeAddrSpc = CGM.getContext().getTargetAddressSpace(LangAS.ID.opencl_global);
      PipeTy = PointerType.get(StructType.create(CGM.getLLVMContext(), new StringRef(/*KEEP_STR*/"opencl.pipe_t")), PipeAddrSpc);
    }
    
    return PipeTy;
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", PipeTy=" + PipeTy; // NOI18N
  }
}

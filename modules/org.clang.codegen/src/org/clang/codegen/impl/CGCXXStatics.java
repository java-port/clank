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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type CGCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGCXXStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZL25BuildAppleKextVirtualCallRN5clang7CodeGen15CodeGenFunctionENS_10GlobalDeclEPN4llvm4TypeEPKNS_13CXXRecordDeclE; -static-type=CGCXXStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGCXXStatics {

//<editor-fold defaultstate="collapsed" desc="BuildAppleKextVirtualCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 263,
 FQN="BuildAppleKextVirtualCall", NM="_ZL25BuildAppleKextVirtualCallRN5clang7CodeGen15CodeGenFunctionENS_10GlobalDeclEPN4llvm4TypeEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZL25BuildAppleKextVirtualCallRN5clang7CodeGen15CodeGenFunctionENS_10GlobalDeclEPN4llvm4TypeEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static Value /*P*/ BuildAppleKextVirtualCall(final CodeGenFunction /*&*/ CGF, 
                         GlobalDecl GD, 
                         org.llvm.ir.Type /*P*/ Ty, 
                         /*const*/ CXXRecordDecl /*P*/ RD) {
  assert (!CGF.CGM.getTarget().getCXXABI().isMicrosoft()) : "No kext in Microsoft ABI";
  GD.$assignMove(GD.getCanonicalDecl());
  final CodeGenModule /*&*/ CGM = CGF.CGM;
  Value /*P*/ VTable = CGM.getCXXABI().getAddrOfVTable(RD, new CharUnits());
  Ty = Ty.getPointerTo().getPointerTo();
  VTable = CGF.Builder.CreateBitCast(VTable, Ty);
  assert ((VTable != null)) : "BuildVirtualCall = kext vtbl pointer is null";
  long/*uint64_t*/ VTableIndex = CGM.getItaniumVTableContext().getMethodVTableIndex(new GlobalDecl(GD));
  long/*uint64_t*/ AddressPoint = CGM.getItaniumVTableContext().getVTableLayout(RD).
      getAddressPoint(new BaseSubobject(RD, CharUnits.Zero()));
  VTableIndex += AddressPoint;
  Value /*P*/ VFuncPtr = CGF.Builder.CreateConstInBoundsGEP1_64(VTable, VTableIndex, new Twine(/*KEEP_STR*/"vfnkxt"));
  return CGF.Builder.CreateAlignedLoad(VFuncPtr, $uchar2uint(CGF.Unnamed_field13.PointerAlignInBytes));
}

} // END OF class CGCXXStatics

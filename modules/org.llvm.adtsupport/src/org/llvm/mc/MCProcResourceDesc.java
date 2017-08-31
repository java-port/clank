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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.aliases.*;


/// Define a kind of processor resource that will be modeled by the scheduler.
//<editor-fold defaultstate="collapsed" desc="llvm::MCProcResourceDesc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSchedule.h", line = 26,
 FQN = "llvm::MCProcResourceDesc", NM = "_ZN4llvm18MCProcResourceDescE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCModuleYAML.cpp -nm=_ZN4llvm18MCProcResourceDescE")
//</editor-fold>
public class/*struct*/ MCProcResourceDesc implements Native.NativeComparable<MCProcResourceDesc> {
  public /*const*/char$ptr/*char P*/ Name;
  public /*uint*/int NumUnits; // Number of resource of this kind
  public /*uint*/int SuperIdx; // Index of the resources kind that contains this kind.
  
  // Number of resources that may be buffered.
  //
  // Buffered resources (BufferSize > 0 || BufferSize == -1) may be consumed at
  // some indeterminate cycle after dispatch (e.g. for instructions that may
  // issue out-of-order). Unbuffered resources (BufferSize == 0) always consume
  // their resource some fixed number of cycles after dispatch (e.g. for
  // instruction interlocking that may stall the pipeline).
  public int BufferSize;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCProcResourceDesc::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSchedule.h", line = 47,
   FQN = "llvm::MCProcResourceDesc::operator==", NM = "_ZNK4llvm18MCProcResourceDesceqERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCModuleYAML.cpp -nm=_ZNK4llvm18MCProcResourceDesceqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/MCProcResourceDesc /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public boolean $noteq(/*const*/MCProcResourceDesc /*&*/ Other) /*const*/ {
    return !$eq(Other);
  }
}

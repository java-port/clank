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

package org.clang.basic.target.impl;

import org.clank.support.aliases.char$ptr;
import org.llvm.adt.NoneType;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;

/**
 * Special class used to make protected methods visible by impl package
 * it is the base class for TargetInfo real implementation and 
 * TargetInfoInherited which delegates all to TargetInfo through this 'interface'
 * @author Vladimir Voskresensky
 */
public abstract class TargetInfoImpl extends org.clang.basic.target.TargetInfo {

  protected TargetInfoImpl(NoneType None) {
    super(None);
  }

  protected TargetInfoImpl() {
    super();
  }

  public final TargetInfo $TargetInfo() {
    if (this instanceof org.clang.basic.target.impl.TargetInfo) {
      assert !(this instanceof TargetInfoInherited);
      return (org.clang.basic.target.impl.TargetInfo)this;
    } else {
      assert this instanceof TargetInfoInherited;
      return ((TargetInfoInherited)this).tgt;
    }
  }
  
  @Override
  protected abstract void resetDataLayout(StringRef DL);
  
  @Override
  protected abstract ArrayRef<AddlRegName> getGCCAddlRegNames();

  @Override
  protected abstract ArrayRef<GCCRegAlias> getGCCRegAliases();

  @Override
  protected abstract ArrayRef<char$ptr> getGCCRegNames();

  @Override
  protected abstract IntType getPtrDiffTypeV(int AddrSpace);

  @Override
  protected abstract long getPointerAlignV(int AddrSpace);

  @Override
  protected abstract long getPointerWidthV(int AddrSpace);
}

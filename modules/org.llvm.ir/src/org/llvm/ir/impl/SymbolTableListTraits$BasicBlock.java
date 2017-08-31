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

package org.llvm.ir.impl;

import org.clank.support.Converted;
import org.clank.support.NativeTrace;
import org.llvm.adt.ilist_nextprev_traits;
import org.llvm.adt.ilist_node_traits;
import org.llvm.adt.iplist;
import org.llvm.ir.BasicBlock;
import org.llvm.ir.Function;
import org.llvm.ir.SymbolTableList;
import org.llvm.ir.SymbolTableListTraits;

///<editor-fold defaultstate="collapsed" desc="llvm::SymbolTableListTraits<BasicBlock>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Function.cpp", line = 38,
 FQN="llvm::SymbolTableListTraits<BasicBlock>", NM="_ZN4llvm21SymbolTableListTraitsINS_10BasicBlockEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm21SymbolTableListTraitsINS_10BasicBlockEEE")
//</editor-fold>
public class SymbolTableListTraits$BasicBlock implements /*public*/ SymbolTableListTraits<BasicBlock, Function>, /*public*/ ilist_nextprev_traits<BasicBlock>, /*public*/ ilist_node_traits<BasicBlock> {
    
  @Override
  public Function getListOwner(iplist<BasicBlock> list) {
    assert list instanceof SymbolTableList$BasicBlock : "forgot to pass valid list object?" + NativeTrace.getIdentityStr(list);
    return ((SymbolTableList$BasicBlock) list).getListOwner(list);
  }
  
  private final BasicBlock $sentinelField = BasicBlock.$createSentinel();

  @Override
  public BasicBlock $SentinelField() {
    return $sentinelField;
  }

  @Override
  public Class<BasicBlock> $getValueSubClass() {
    return BasicBlock.class;
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public static class SymbolTableList$BasicBlock extends SymbolTableList<BasicBlock, Function> {

    public SymbolTableList$BasicBlock(Function/*P*/ Owner) {
      super(Owner);
    }
    
    @Override
    public BasicBlock $SentinelField() {
      return (BasicBlock)((SymbolTableListTraits)super.$traits()).$SentinelField();
    }
    
    @Override
    protected SymbolTableListTraits$BasicBlock $createTraits() {
      return new SymbolTableListTraits$BasicBlock();
    }
    
    @Override
    public Class<BasicBlock> $getValueSubClass() {
      return ((SymbolTableListTraits)super.$traits()).$getValueSubClass();
    }
  }

}

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

package org.llvm.ir.java;

import org.llvm.adt.ilist_traits;
import org.llvm.ir.Argument;
import org.llvm.ir.BasicBlock;
import org.llvm.ir.Function;
import org.llvm.ir.GlobalAlias;
import org.llvm.ir.GlobalIFunc;
import org.llvm.ir.GlobalVariable;
import org.llvm.ir.Instruction;
import org.llvm.ir.impl.SymbolTableListTraits$Argument;
import org.llvm.ir.impl.SymbolTableListTraits$BasicBlock;
import org.llvm.ir.impl.SymbolTableListTraits$Function;
import org.llvm.ir.impl.SymbolTableListTraits$GlobalAlias;
import org.llvm.ir.impl.SymbolTableListTraits$GlobalIFunc;
import org.llvm.ir.impl.SymbolTableListTraits$GlobalVariable;
import org.llvm.ir.impl.SymbolTableListTraits$Instruction;

/**
 * An accessor to some ilist_traits specializations
 * that originally reside inside private package (org.llvm.ir.impl).
 *
 * These original specializations in fact implement not ilist_traits but SymbolTableListTraits;
 * and they are named SymbolTableListTraits$*, not ilist_traits*.
 * And it's unlikely that anybody needs SymbolTableListTraits outsdide IR.
 *
 * The above makes me think that it's better to expose them this way
 * rather than moving classes to public packages
 *
 * @author vkvashin
 */
public class ilist_traits_IR {

  private ilist_traits_IR() {}

  public static ilist_traits<Instruction> ilist_traits$Instruction() {
    return new SymbolTableListTraits$Instruction();
  }

  public static ilist_traits<Function> ilist_traits$Function() {
    return new SymbolTableListTraits$Function();
  }

  public static ilist_traits<GlobalVariable> ilist_traits$GlobalVariable() {
    return new SymbolTableListTraits$GlobalVariable();
  }

  public static ilist_traits<GlobalAlias> ilist_traits$GlobalAlias() {
    return new SymbolTableListTraits$GlobalAlias();
  }

  public static ilist_traits<GlobalIFunc> ilist_traits$GlobalIFunc() {
    return new SymbolTableListTraits$GlobalIFunc();
  }

  public static ilist_traits<BasicBlock> ilist_traits$BasicBlock() {
    return new SymbolTableListTraits$BasicBlock();
  }

  public static ilist_traits<Argument> ilist_traits$Argument() {
    return new SymbolTableListTraits$Argument();
  }
}

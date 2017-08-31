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

import org.llvm.ir.DILocation;
import org.llvm.ir.DistinctMDOperandPlaceholder;
import org.llvm.ir.MDNode;
import org.llvm.ir.MDOperand;
import org.llvm.ir.MDString;
import org.llvm.ir.Metadata;
import org.llvm.support.llvm;

/**
 *
 * @author vkvashin
 */
public class IRManualRTTI {

//  public static boolean isa_Constant(Use/*P*/ From) {
//    assert From != null;
//    return llvm.isa(Constant.class, From);
//  }
//
//  public static Constant cast_Constant(Use/*P*/ From) {
//    assert isa_Constant(From);
//    return llvm.cast(Constant.class, From);
//  }
//
//  public static Constant cast_or_null_Constant(Use/*P*/ From) {
//    return (From == null) ? null : IrRTTI.cast_Constant(From);
//  }
//
//  public static Constant dyn_cast_Constant(Use/*P*/ From) {
//    assert From != null;
//    return IrRTTI.isa_Constant(From) ? IrRTTI.cast_Constant(From) : null;
//  }

  public static boolean isa_MDString(MDOperand/*P*/ From) {
    assert From != null;
    return llvm.isa(MDString.class, From.$Metadata$P());
  }

  public static MDString cast_MDString(MDOperand/*P*/ From) {
    assert isa_MDString(From);
    return llvm.cast(MDString.class, From.$Metadata$P());
  }

  public static MDString dyn_cast_MDString(MDOperand/*P*/ From) {
    assert From != null;
    return isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static MDString dyn_cast_or_null_MDString(MDOperand/*P*/ From) {
    return (From != null) && isa_MDString(From) ? cast_MDString(From) : null;
  }

  public static boolean isa_MDNode(MDOperand/*P*/ From) {
    assert From != null;
    return llvm.isa(MDNode.class, From.$Metadata$P());
  }

  public static MDNode cast_MDNode(MDOperand/*P*/ From) {
    assert isa_MDNode(From);
    return llvm.cast(MDNode.class, From.$Metadata$P());
  }

  public static MDNode dyn_cast_MDNode(MDOperand/*P*/ From) {
    assert From != null;
    return isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static MDNode dyn_cast_or_null_MDNode(MDOperand/*P*/ From) {
    return (From != null) && isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static MDNode cast_or_null_MDNode(MDOperand/*P*/ From) {
    return (From != null) && isa_MDNode(From) ? cast_MDNode(From) : null;
  }

  public static boolean isa_DILocation(MDOperand/*P*/ From) {
    assert From != null;
    return llvm.isa(DILocation.class, From.$Metadata$P());
  }

  public static DILocation cast_DILocation(MDOperand/*P*/ From) {
    assert isa_DILocation(From);
    return llvm.cast(DILocation.class, From.$Metadata$P());
  }

  public static DILocation dyn_cast_DILocation(MDOperand/*P*/ From) {
    assert From != null;
    return isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static DILocation dyn_cast_or_null_DILocation(MDOperand/*P*/ From) {
    return (From != null) && isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static DILocation cast_or_null_DILocation(MDOperand/*P*/ From) {
    return (From != null) && isa_DILocation(From) ? cast_DILocation(From) : null;
  }

  public static boolean isa_DistinctMDOperandPlaceholder(Metadata/*P*/ From) {
    assert From != null;
    return llvm.isa(DistinctMDOperandPlaceholder.class, From);
  }

  public static DistinctMDOperandPlaceholder cast_DistinctMDOperandPlaceholder(Metadata/*P*/ From) {
    assert isa_DistinctMDOperandPlaceholder(From);
    return llvm.cast(DistinctMDOperandPlaceholder.class, From);
  }

  public static DistinctMDOperandPlaceholder dyn_cast_DistinctMDOperandPlaceholder(Metadata/*P*/ From) {
    assert From != null;
    return isa_DistinctMDOperandPlaceholder(From) ? cast_DistinctMDOperandPlaceholder(From) : null;
  }

  public static DistinctMDOperandPlaceholder dyn_cast_or_null_DistinctMDOperandPlaceholder(Metadata/*P*/ From) {
    return (From != null) && isa_DistinctMDOperandPlaceholder(From) ? cast_DistinctMDOperandPlaceholder(From) : null;
  }

  public static DistinctMDOperandPlaceholder cast_or_null_DistinctMDOperandPlaceholder(Metadata/*P*/ From) {
    return (From != null) && isa_DistinctMDOperandPlaceholder(From) ? cast_DistinctMDOperandPlaceholder(From) : null;
  }
}

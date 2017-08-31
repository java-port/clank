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

package org.llvm.support.dwarf;

import org.clank.support.*;


/// Constants for the DW_APPLE_PROPERTY_attributes attribute.
/// Keep this list in sync with clang's DeclSpec.h ObjCPropertyAttributeKind.
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::ApplePropertyAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 543,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", old_line = 552,
 FQN="llvm::dwarf::ApplePropertyAttributes", NM="_ZN4llvm5dwarf23ApplePropertyAttributesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf23ApplePropertyAttributesE")
//</editor-fold>
public final class/*enum*/ ApplePropertyAttributes {
  // Apple Objective-C Property Attributes
  public static final /*uint*/int DW_APPLE_PROPERTY_readonly = 0x01;
  public static final /*uint*/int DW_APPLE_PROPERTY_getter = 0x02;
  public static final /*uint*/int DW_APPLE_PROPERTY_assign = 0x04;
  public static final /*uint*/int DW_APPLE_PROPERTY_readwrite = 0x08;
  public static final /*uint*/int DW_APPLE_PROPERTY_retain = 0x10;
  public static final /*uint*/int DW_APPLE_PROPERTY_copy = 0x20;
  public static final /*uint*/int DW_APPLE_PROPERTY_nonatomic = 0x40;
  public static final /*uint*/int DW_APPLE_PROPERTY_setter = 0x80;
  public static final /*uint*/int DW_APPLE_PROPERTY_atomic = 0x100;
  public static final /*uint*/int DW_APPLE_PROPERTY_weak = 0x200;
  public static final /*uint*/int DW_APPLE_PROPERTY_strong = 0x400;
  public static final /*uint*/int DW_APPLE_PROPERTY_unsafe_unretained = 0x800;
  public static final /*uint*/int DW_APPLE_PROPERTY_nullability = 0x1000;
  public static final /*uint*/int DW_APPLE_PROPERTY_null_resettable = 0x2000;
  public static final /*uint*/int DW_APPLE_PROPERTY_class = 0x4000;
}

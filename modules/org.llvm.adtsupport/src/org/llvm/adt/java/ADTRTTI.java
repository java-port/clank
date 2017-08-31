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

package org.llvm.adt.java;

import org.llvm.mc.*;
import org.llvm.support.yaml.*;
import org.llvm.support.yaml.Input.*;

/**
 *
 * @author alex
 */
public class ADTRTTI {
  
  public static MapHNode /*P*/ dyn_cast_or_null_MapHNode(HNode /*P*/CurrentNode) {
    if (CurrentNode instanceof MapHNode) {
      return (MapHNode) CurrentNode;
    }
    return null;
  }
  
  public static MapHNode /*P*/ dyn_cast_MapHNode(HNode /*P*/CurrentNode) {
    return (MapHNode) CurrentNode;
  }
  
  public static SequenceHNode /*P*/ dyn_cast_SequenceHNode(HNode /*P*/CurrentNode) {
    return (SequenceHNode) CurrentNode;
  }
  
  public static ScalarHNode /*P*/ dyn_cast_ScalarHNode(HNode /*P*/CurrentNode) {
    return (ScalarHNode) CurrentNode;
  }

  public static boolean isa_EmptyHNode(HNode /*P*/CurrentNode) {
    return CurrentNode instanceof EmptyHNode;
  }
  
  public static ScalarNode /*P*/ dyn_cast_ScalarNode(Node N) {
    if (N instanceof ScalarNode) {
      return (ScalarNode)N;
    }
    return null;
  }
  
  public static BlockScalarNode /*P*/ dyn_cast_BlockScalarNode(Node N) {
    if (N instanceof BlockScalarNode) {
      return (BlockScalarNode)N;
    }
    return null;
  }
  
  public static SequenceNode /*P*/ dyn_cast_SequenceNode(Node N) {
    if (N instanceof SequenceNode) {
      return (SequenceNode)N;
    }
    return null;
  }
  
  public static MappingNode /*P*/ dyn_cast_MappingNode(Node N) {
    if (N instanceof MappingNode) {
      return (MappingNode)N;
    }
    return null;
  }
  
  public static boolean isa_NullNode(Node N){
    return N instanceof NullNode;
  }
  
  public static boolean isa_MCEncodedFragment(MCFragment F) {
    return F instanceof MCEncodedFragment;
  }
  public static boolean isa_MCCompactEncodedInstFragment(MCFragment F) {
    return F instanceof MCCompactEncodedInstFragment;
  }
  public static boolean isa_MCCVDefRangeFragment(MCFragment F) {
    return F instanceof MCCVDefRangeFragment;
  }
  
  public static MCAlignFragment cast_MCAlignFragment(MCFragment F) {
    if (F instanceof MCAlignFragment) {
      return (MCAlignFragment) F;
    }
    return null;
  }
  public static MCDataFragment cast_MCDataFragment(MCFragment F) {
    if (F instanceof MCDataFragment) {
      return (MCDataFragment) F;
    }
    return null;
  }
  public static MCDataFragment dyn_cast_or_null_MCDataFragment(MCFragment F) {
    if (F instanceof MCDataFragment) {
      return (MCDataFragment) F;
    }
    return null;
  }
  public static MCDataFragment dyn_cast_MCDataFragment(MCFragment F) {
    if (F instanceof MCDataFragment) {
      return (MCDataFragment) F;
    }
    return null;
  }

  public static MCCompactEncodedInstFragment cast_MCCompactEncodedInstFragment(MCFragment F) {
    if (F instanceof MCCompactEncodedInstFragment) {
      return (MCCompactEncodedInstFragment) F;
    }
    return null;
  }
  public static MCFillFragment cast_MCFillFragment(MCFragment F) {
    if (F instanceof MCFillFragment) {
      return (MCFillFragment) F;
    }
    return null;
  }
  public static MCRelaxableFragment cast_MCRelaxableFragment(MCFragment F) {
    if (F instanceof MCRelaxableFragment) {
      return (MCRelaxableFragment) F;
    }
    return null;
  }
  public static MCRelaxableFragment dyn_cast_MCRelaxableFragment(MCFragment F) {
    if (F instanceof MCRelaxableFragment) {
      return (MCRelaxableFragment) F;
    }
    return null;
  }
  public static MCOrgFragment cast_MCOrgFragment(MCFragment F) {
    if (F instanceof MCOrgFragment) {
      return (MCOrgFragment) F;
    }
    return null;
  }
  public static MCDwarfLineAddrFragment cast_MCDwarfLineAddrFragment(MCFragment F) {
    if (F instanceof MCDwarfLineAddrFragment) {
      return (MCDwarfLineAddrFragment) F;
    }
    return null;
  }
  public static MCDwarfCallFrameFragment cast_MCDwarfCallFrameFragment(MCFragment F) {
    if (F instanceof MCDwarfCallFrameFragment) {
      return (MCDwarfCallFrameFragment) F;
    }
    return null;
  }
  public static MCLEBFragment cast_MCLEBFragment(MCFragment F) {
    if (F instanceof MCLEBFragment) {
      return (MCLEBFragment) F;
    }
    return null;
  }
  public static MCSafeSEHFragment cast_MCSafeSEHFragment(MCFragment F) {
    if (F instanceof MCSafeSEHFragment) {
      return (MCSafeSEHFragment) F;
    }
    return null;
  }
  public static MCCVInlineLineTableFragment cast_MCCVInlineLineTableFragment(MCFragment F) {
    if (F instanceof MCCVInlineLineTableFragment) {
      return (MCCVInlineLineTableFragment) F;
    }
    return null;
  }
  public static MCCVDefRangeFragment cast_MCCVDefRangeFragment(MCFragment F) {
    if (F instanceof MCCVDefRangeFragment) {
      return (MCCVDefRangeFragment) F;
    }
    return null;
  }
  public static MCCVDefRangeFragment dyn_cast_MCCVDefRangeFragment(MCFragment F) {
    if (F instanceof MCCVDefRangeFragment) {
      return (MCCVDefRangeFragment) F;
    }
    return null;
  }
  public static MCDummyFragment cast_MCDummyFragment(MCFragment F) {
    if (F instanceof MCDummyFragment) {
      return (MCDummyFragment) F;
    }
    return null;
  }
  public static MCTargetExpr cast_MCTargetExpr(MCExpr F) {
    if (F instanceof MCTargetExpr) {
      return (MCTargetExpr) F;
    }
    return null;
  }
  public static MCConstantExpr cast_MCConstantExpr(MCExpr F) {
    if (F instanceof MCConstantExpr) {
      return (MCConstantExpr) F;
    }
    return null;
  }
  public static MCConstantExpr dyn_cast_MCConstantExpr(MCExpr F) {
    if (F instanceof MCConstantExpr) {
      return (MCConstantExpr) F;
    }
    return null;
  }
  public static boolean isa_MCConstantExpr(MCExpr F) {
    return F instanceof MCConstantExpr;
  }
  public static MCUnaryExpr cast_MCUnaryExpr(MCExpr F) {
    if (F instanceof MCUnaryExpr) {
      return (MCUnaryExpr) F;
    }
    return null;
  }
  public static MCBinaryExpr cast_MCBinaryExpr(MCExpr F) {
    if (F instanceof MCBinaryExpr) {
      return (MCBinaryExpr) F;
    }
    return null;
  }
  public static MCSymbolRefExpr cast_MCSymbolRefExpr(MCExpr F) {
    if (F instanceof MCSymbolRefExpr) {
      return (MCSymbolRefExpr) F;
    }
    return null;
  }
  public static MCSymbolRefExpr dyn_cast_MCSymbolRefExpr(MCExpr F) {
    if (F instanceof MCSymbolRefExpr) {
      return (MCSymbolRefExpr) F;
    }
    return null;
  }
  public static boolean isa_MCSymbolRefExpr(MCExpr F) {
    return F instanceof MCSymbolRefExpr;
  }
  public static MCDwarfLineAddrFragment cast_MCDwarfLineAddrFragment(MCDwarfLineAddrFragment F) {
    if (F instanceof MCDwarfLineAddrFragment) {
      return (MCDwarfLineAddrFragment) F;
    }
    return null;
  }
  public static MCRelaxableFragment cast_MCRelaxableFragment(MCRelaxableFragment F) {
    if (F instanceof MCRelaxableFragment) {
      return (MCRelaxableFragment) F;
    }
    return null;
  }
  public static MCSymbolELF cast_MCRelaxableFragment(MCSymbol F) {
    if (F instanceof MCSymbolELF) {
      return (MCSymbolELF) F;
    }
    return null;
  }
  public static MCSymbolMachO cast_MCSymbolMachO(MCSymbol F) {
    if (F instanceof MCSymbolMachO) {
      return (MCSymbolMachO) F;
    }
    return null;
  }
  public static MCSymbolELF cast_MCSymbolELF(MCSymbol F) {
    if (F instanceof MCSymbolELF) {
      return (MCSymbolELF) F;
    }
    return null;
  }
  public static MCSectionMachO cast_MCSectionMachO(MCSection F) {
    if (F instanceof MCSectionMachO) {
      return (MCSectionMachO) F;
    }
    return null;
  }
  public static MCSectionCOFF cast_MCSectionCOFF(MCSection F) {
    if (F instanceof MCSectionCOFF) {
      return (MCSectionCOFF) F;
    }
    return null;
  }
  public static MCSectionELF dyn_cast_MCSectionELF(MCSection F) {
    if (F instanceof MCSectionELF) {
      return (MCSectionELF) F;
    }
    return null;
  }
}

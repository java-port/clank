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
package org.clang.basic.target;

import org.clank.support.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type SystemZ">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7SystemZE_TargetBuiltins_h_Unnamed_enum; -static-type=SystemZ -package=org.clang.basic.target")
//</editor-fold>
public final class SystemZ {

//<editor-fold defaultstate="collapsed" desc="clang::SystemZ::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TargetBuiltins.h", line = 181,
 FQN="clang::SystemZ::(anonymous)", NM="_ZN5clang7SystemZE_TargetBuiltins_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuiltin.cpp -nm=_ZN5clang7SystemZE_TargetBuiltins_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int LastTIBuiltin = /*Builtin.ID.FirstTSBuiltin.getValue()*/ 970 - 1;
  static {
    assert Builtin.ID.FirstTSBuiltin.getValue() == 970 : "Wrong Builtin.ID.FirstTSBuiltin.getValue() value";
  }
  
  // Transactional-memory intrinsics
  public static final /*uint*/int BI__builtin_tbegin = LastTIBuiltin + 1;
  public static final /*uint*/int BI__builtin_tbegin_nofloat = BI__builtin_tbegin + 1;
  public static final /*uint*/int BI__builtin_tbeginc = BI__builtin_tbegin_nofloat + 1;
  public static final /*uint*/int BI__builtin_tabort = BI__builtin_tbeginc + 1;
  public static final /*uint*/int BI__builtin_tend = BI__builtin_tabort + 1;
  public static final /*uint*/int BI__builtin_tx_nesting_depth = BI__builtin_tend + 1;
  public static final /*uint*/int BI__builtin_tx_assist = BI__builtin_tx_nesting_depth + 1;
  public static final /*uint*/int BI__builtin_non_tx_store = BI__builtin_tx_assist + 1;
  
  // Vector intrinsics.
  // These all map directly to z instructions, except that some variants ending
  // in "s" have a final "int *" that receives the post-instruction CC value.
  
  // Vector support instructions (chapter 21 of the PoP)
  public static final /*uint*/int BI__builtin_s390_lcbb = BI__builtin_non_tx_store + 1;
  public static final /*uint*/int BI__builtin_s390_vlbb = BI__builtin_s390_lcbb + 1;
  public static final /*uint*/int BI__builtin_s390_vll = BI__builtin_s390_vlbb + 1;
  public static final /*uint*/int BI__builtin_s390_vstl = BI__builtin_s390_vll + 1;
  public static final /*uint*/int BI__builtin_s390_vperm = BI__builtin_s390_vstl + 1;
  public static final /*uint*/int BI__builtin_s390_vpdi = BI__builtin_s390_vperm + 1;
  public static final /*uint*/int BI__builtin_s390_vpksh = BI__builtin_s390_vpdi + 1;
  public static final /*uint*/int BI__builtin_s390_vpkshs = BI__builtin_s390_vpksh + 1;
  public static final /*uint*/int BI__builtin_s390_vpksf = BI__builtin_s390_vpkshs + 1;
  public static final /*uint*/int BI__builtin_s390_vpksfs = BI__builtin_s390_vpksf + 1;
  public static final /*uint*/int BI__builtin_s390_vpksg = BI__builtin_s390_vpksfs + 1;
  public static final /*uint*/int BI__builtin_s390_vpksgs = BI__builtin_s390_vpksg + 1;
  public static final /*uint*/int BI__builtin_s390_vpklsh = BI__builtin_s390_vpksgs + 1;
  public static final /*uint*/int BI__builtin_s390_vpklshs = BI__builtin_s390_vpklsh + 1;
  public static final /*uint*/int BI__builtin_s390_vpklsf = BI__builtin_s390_vpklshs + 1;
  public static final /*uint*/int BI__builtin_s390_vpklsfs = BI__builtin_s390_vpklsf + 1;
  public static final /*uint*/int BI__builtin_s390_vpklsg = BI__builtin_s390_vpklsfs + 1;
  public static final /*uint*/int BI__builtin_s390_vpklsgs = BI__builtin_s390_vpklsg + 1;
  public static final /*uint*/int BI__builtin_s390_vuphb = BI__builtin_s390_vpklsgs + 1;
  public static final /*uint*/int BI__builtin_s390_vuphh = BI__builtin_s390_vuphb + 1;
  public static final /*uint*/int BI__builtin_s390_vuphf = BI__builtin_s390_vuphh + 1;
  public static final /*uint*/int BI__builtin_s390_vuplb = BI__builtin_s390_vuphf + 1;
  public static final /*uint*/int BI__builtin_s390_vuplhw = BI__builtin_s390_vuplb + 1;
  public static final /*uint*/int BI__builtin_s390_vuplf = BI__builtin_s390_vuplhw + 1;
  public static final /*uint*/int BI__builtin_s390_vuplhb = BI__builtin_s390_vuplf + 1;
  public static final /*uint*/int BI__builtin_s390_vuplhh = BI__builtin_s390_vuplhb + 1;
  public static final /*uint*/int BI__builtin_s390_vuplhf = BI__builtin_s390_vuplhh + 1;
  public static final /*uint*/int BI__builtin_s390_vupllb = BI__builtin_s390_vuplhf + 1;
  public static final /*uint*/int BI__builtin_s390_vupllh = BI__builtin_s390_vupllb + 1;
  public static final /*uint*/int BI__builtin_s390_vupllf = BI__builtin_s390_vupllh + 1;
  
  // Vector integer instructions (chapter 22 of the PoP)
  public static final /*uint*/int BI__builtin_s390_vaq = BI__builtin_s390_vupllf + 1;
  public static final /*uint*/int BI__builtin_s390_vacq = BI__builtin_s390_vaq + 1;
  public static final /*uint*/int BI__builtin_s390_vaccb = BI__builtin_s390_vacq + 1;
  public static final /*uint*/int BI__builtin_s390_vacch = BI__builtin_s390_vaccb + 1;
  public static final /*uint*/int BI__builtin_s390_vaccf = BI__builtin_s390_vacch + 1;
  public static final /*uint*/int BI__builtin_s390_vaccg = BI__builtin_s390_vaccf + 1;
  public static final /*uint*/int BI__builtin_s390_vaccq = BI__builtin_s390_vaccg + 1;
  public static final /*uint*/int BI__builtin_s390_vacccq = BI__builtin_s390_vaccq + 1;
  public static final /*uint*/int BI__builtin_s390_vavgb = BI__builtin_s390_vacccq + 1;
  public static final /*uint*/int BI__builtin_s390_vavgh = BI__builtin_s390_vavgb + 1;
  public static final /*uint*/int BI__builtin_s390_vavgf = BI__builtin_s390_vavgh + 1;
  public static final /*uint*/int BI__builtin_s390_vavgg = BI__builtin_s390_vavgf + 1;
  public static final /*uint*/int BI__builtin_s390_vavglb = BI__builtin_s390_vavgg + 1;
  public static final /*uint*/int BI__builtin_s390_vavglh = BI__builtin_s390_vavglb + 1;
  public static final /*uint*/int BI__builtin_s390_vavglf = BI__builtin_s390_vavglh + 1;
  public static final /*uint*/int BI__builtin_s390_vavglg = BI__builtin_s390_vavglf + 1;
  public static final /*uint*/int BI__builtin_s390_vceqbs = BI__builtin_s390_vavglg + 1;
  public static final /*uint*/int BI__builtin_s390_vceqhs = BI__builtin_s390_vceqbs + 1;
  public static final /*uint*/int BI__builtin_s390_vceqfs = BI__builtin_s390_vceqhs + 1;
  public static final /*uint*/int BI__builtin_s390_vceqgs = BI__builtin_s390_vceqfs + 1;
  public static final /*uint*/int BI__builtin_s390_vchbs = BI__builtin_s390_vceqgs + 1;
  public static final /*uint*/int BI__builtin_s390_vchhs = BI__builtin_s390_vchbs + 1;
  public static final /*uint*/int BI__builtin_s390_vchfs = BI__builtin_s390_vchhs + 1;
  public static final /*uint*/int BI__builtin_s390_vchgs = BI__builtin_s390_vchfs + 1;
  public static final /*uint*/int BI__builtin_s390_vchlbs = BI__builtin_s390_vchgs + 1;
  public static final /*uint*/int BI__builtin_s390_vchlhs = BI__builtin_s390_vchlbs + 1;
  public static final /*uint*/int BI__builtin_s390_vchlfs = BI__builtin_s390_vchlhs + 1;
  public static final /*uint*/int BI__builtin_s390_vchlgs = BI__builtin_s390_vchlfs + 1;
  public static final /*uint*/int BI__builtin_s390_vcksm = BI__builtin_s390_vchlgs + 1;
  public static final /*uint*/int BI__builtin_s390_vclzb = BI__builtin_s390_vcksm + 1;
  public static final /*uint*/int BI__builtin_s390_vclzh = BI__builtin_s390_vclzb + 1;
  public static final /*uint*/int BI__builtin_s390_vclzf = BI__builtin_s390_vclzh + 1;
  public static final /*uint*/int BI__builtin_s390_vclzg = BI__builtin_s390_vclzf + 1;
  public static final /*uint*/int BI__builtin_s390_vctzb = BI__builtin_s390_vclzg + 1;
  public static final /*uint*/int BI__builtin_s390_vctzh = BI__builtin_s390_vctzb + 1;
  public static final /*uint*/int BI__builtin_s390_vctzf = BI__builtin_s390_vctzh + 1;
  public static final /*uint*/int BI__builtin_s390_vctzg = BI__builtin_s390_vctzf + 1;
  public static final /*uint*/int BI__builtin_s390_verimb = BI__builtin_s390_vctzg + 1;
  public static final /*uint*/int BI__builtin_s390_verimh = BI__builtin_s390_verimb + 1;
  public static final /*uint*/int BI__builtin_s390_verimf = BI__builtin_s390_verimh + 1;
  public static final /*uint*/int BI__builtin_s390_verimg = BI__builtin_s390_verimf + 1;
  public static final /*uint*/int BI__builtin_s390_verllb = BI__builtin_s390_verimg + 1;
  public static final /*uint*/int BI__builtin_s390_verllh = BI__builtin_s390_verllb + 1;
  public static final /*uint*/int BI__builtin_s390_verllf = BI__builtin_s390_verllh + 1;
  public static final /*uint*/int BI__builtin_s390_verllg = BI__builtin_s390_verllf + 1;
  public static final /*uint*/int BI__builtin_s390_verllvb = BI__builtin_s390_verllg + 1;
  public static final /*uint*/int BI__builtin_s390_verllvh = BI__builtin_s390_verllvb + 1;
  public static final /*uint*/int BI__builtin_s390_verllvf = BI__builtin_s390_verllvh + 1;
  public static final /*uint*/int BI__builtin_s390_verllvg = BI__builtin_s390_verllvf + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmb = BI__builtin_s390_verllvg + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmh = BI__builtin_s390_vgfmb + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmf = BI__builtin_s390_vgfmh + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmg = BI__builtin_s390_vgfmf + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmab = BI__builtin_s390_vgfmg + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmah = BI__builtin_s390_vgfmab + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmaf = BI__builtin_s390_vgfmah + 1;
  public static final /*uint*/int BI__builtin_s390_vgfmag = BI__builtin_s390_vgfmaf + 1;
  public static final /*uint*/int BI__builtin_s390_vmahb = BI__builtin_s390_vgfmag + 1;
  public static final /*uint*/int BI__builtin_s390_vmahh = BI__builtin_s390_vmahb + 1;
  public static final /*uint*/int BI__builtin_s390_vmahf = BI__builtin_s390_vmahh + 1;
  public static final /*uint*/int BI__builtin_s390_vmalhb = BI__builtin_s390_vmahf + 1;
  public static final /*uint*/int BI__builtin_s390_vmalhh = BI__builtin_s390_vmalhb + 1;
  public static final /*uint*/int BI__builtin_s390_vmalhf = BI__builtin_s390_vmalhh + 1;
  public static final /*uint*/int BI__builtin_s390_vmaeb = BI__builtin_s390_vmalhf + 1;
  public static final /*uint*/int BI__builtin_s390_vmaeh = BI__builtin_s390_vmaeb + 1;
  public static final /*uint*/int BI__builtin_s390_vmaef = BI__builtin_s390_vmaeh + 1;
  public static final /*uint*/int BI__builtin_s390_vmaleb = BI__builtin_s390_vmaef + 1;
  public static final /*uint*/int BI__builtin_s390_vmaleh = BI__builtin_s390_vmaleb + 1;
  public static final /*uint*/int BI__builtin_s390_vmalef = BI__builtin_s390_vmaleh + 1;
  public static final /*uint*/int BI__builtin_s390_vmaob = BI__builtin_s390_vmalef + 1;
  public static final /*uint*/int BI__builtin_s390_vmaoh = BI__builtin_s390_vmaob + 1;
  public static final /*uint*/int BI__builtin_s390_vmaof = BI__builtin_s390_vmaoh + 1;
  public static final /*uint*/int BI__builtin_s390_vmalob = BI__builtin_s390_vmaof + 1;
  public static final /*uint*/int BI__builtin_s390_vmaloh = BI__builtin_s390_vmalob + 1;
  public static final /*uint*/int BI__builtin_s390_vmalof = BI__builtin_s390_vmaloh + 1;
  public static final /*uint*/int BI__builtin_s390_vmhb = BI__builtin_s390_vmalof + 1;
  public static final /*uint*/int BI__builtin_s390_vmhh = BI__builtin_s390_vmhb + 1;
  public static final /*uint*/int BI__builtin_s390_vmhf = BI__builtin_s390_vmhh + 1;
  public static final /*uint*/int BI__builtin_s390_vmlhb = BI__builtin_s390_vmhf + 1;
  public static final /*uint*/int BI__builtin_s390_vmlhh = BI__builtin_s390_vmlhb + 1;
  public static final /*uint*/int BI__builtin_s390_vmlhf = BI__builtin_s390_vmlhh + 1;
  public static final /*uint*/int BI__builtin_s390_vmeb = BI__builtin_s390_vmlhf + 1;
  public static final /*uint*/int BI__builtin_s390_vmeh = BI__builtin_s390_vmeb + 1;
  public static final /*uint*/int BI__builtin_s390_vmef = BI__builtin_s390_vmeh + 1;
  public static final /*uint*/int BI__builtin_s390_vmleb = BI__builtin_s390_vmef + 1;
  public static final /*uint*/int BI__builtin_s390_vmleh = BI__builtin_s390_vmleb + 1;
  public static final /*uint*/int BI__builtin_s390_vmlef = BI__builtin_s390_vmleh + 1;
  public static final /*uint*/int BI__builtin_s390_vmob = BI__builtin_s390_vmlef + 1;
  public static final /*uint*/int BI__builtin_s390_vmoh = BI__builtin_s390_vmob + 1;
  public static final /*uint*/int BI__builtin_s390_vmof = BI__builtin_s390_vmoh + 1;
  public static final /*uint*/int BI__builtin_s390_vmlob = BI__builtin_s390_vmof + 1;
  public static final /*uint*/int BI__builtin_s390_vmloh = BI__builtin_s390_vmlob + 1;
  public static final /*uint*/int BI__builtin_s390_vmlof = BI__builtin_s390_vmloh + 1;
  public static final /*uint*/int BI__builtin_s390_vpopctb = BI__builtin_s390_vmlof + 1;
  public static final /*uint*/int BI__builtin_s390_vpopcth = BI__builtin_s390_vpopctb + 1;
  public static final /*uint*/int BI__builtin_s390_vpopctf = BI__builtin_s390_vpopcth + 1;
  public static final /*uint*/int BI__builtin_s390_vpopctg = BI__builtin_s390_vpopctf + 1;
  public static final /*uint*/int BI__builtin_s390_vsq = BI__builtin_s390_vpopctg + 1;
  public static final /*uint*/int BI__builtin_s390_vsbcbiq = BI__builtin_s390_vsq + 1;
  public static final /*uint*/int BI__builtin_s390_vsbiq = BI__builtin_s390_vsbcbiq + 1;
  public static final /*uint*/int BI__builtin_s390_vscbib = BI__builtin_s390_vsbiq + 1;
  public static final /*uint*/int BI__builtin_s390_vscbih = BI__builtin_s390_vscbib + 1;
  public static final /*uint*/int BI__builtin_s390_vscbif = BI__builtin_s390_vscbih + 1;
  public static final /*uint*/int BI__builtin_s390_vscbig = BI__builtin_s390_vscbif + 1;
  public static final /*uint*/int BI__builtin_s390_vscbiq = BI__builtin_s390_vscbig + 1;
  public static final /*uint*/int BI__builtin_s390_vsl = BI__builtin_s390_vscbiq + 1;
  public static final /*uint*/int BI__builtin_s390_vslb = BI__builtin_s390_vsl + 1;
  public static final /*uint*/int BI__builtin_s390_vsldb = BI__builtin_s390_vslb + 1;
  public static final /*uint*/int BI__builtin_s390_vsra = BI__builtin_s390_vsldb + 1;
  public static final /*uint*/int BI__builtin_s390_vsrab = BI__builtin_s390_vsra + 1;
  public static final /*uint*/int BI__builtin_s390_vsrl = BI__builtin_s390_vsrab + 1;
  public static final /*uint*/int BI__builtin_s390_vsrlb = BI__builtin_s390_vsrl + 1;
  public static final /*uint*/int BI__builtin_s390_vsumb = BI__builtin_s390_vsrlb + 1;
  public static final /*uint*/int BI__builtin_s390_vsumh = BI__builtin_s390_vsumb + 1;
  public static final /*uint*/int BI__builtin_s390_vsumgh = BI__builtin_s390_vsumh + 1;
  public static final /*uint*/int BI__builtin_s390_vsumgf = BI__builtin_s390_vsumgh + 1;
  public static final /*uint*/int BI__builtin_s390_vsumqf = BI__builtin_s390_vsumgf + 1;
  public static final /*uint*/int BI__builtin_s390_vsumqg = BI__builtin_s390_vsumqf + 1;
  public static final /*uint*/int BI__builtin_s390_vtm = BI__builtin_s390_vsumqg + 1;
  
  // Vector string instructions (chapter 23 of the PoP)
  public static final /*uint*/int BI__builtin_s390_vfaeb = BI__builtin_s390_vtm + 1;
  public static final /*uint*/int BI__builtin_s390_vfaebs = BI__builtin_s390_vfaeb + 1;
  public static final /*uint*/int BI__builtin_s390_vfaeh = BI__builtin_s390_vfaebs + 1;
  public static final /*uint*/int BI__builtin_s390_vfaehs = BI__builtin_s390_vfaeh + 1;
  public static final /*uint*/int BI__builtin_s390_vfaef = BI__builtin_s390_vfaehs + 1;
  public static final /*uint*/int BI__builtin_s390_vfaefs = BI__builtin_s390_vfaef + 1;
  public static final /*uint*/int BI__builtin_s390_vfaezb = BI__builtin_s390_vfaefs + 1;
  public static final /*uint*/int BI__builtin_s390_vfaezbs = BI__builtin_s390_vfaezb + 1;
  public static final /*uint*/int BI__builtin_s390_vfaezh = BI__builtin_s390_vfaezbs + 1;
  public static final /*uint*/int BI__builtin_s390_vfaezhs = BI__builtin_s390_vfaezh + 1;
  public static final /*uint*/int BI__builtin_s390_vfaezf = BI__builtin_s390_vfaezhs + 1;
  public static final /*uint*/int BI__builtin_s390_vfaezfs = BI__builtin_s390_vfaezf + 1;
  public static final /*uint*/int BI__builtin_s390_vfeeb = BI__builtin_s390_vfaezfs + 1;
  public static final /*uint*/int BI__builtin_s390_vfeebs = BI__builtin_s390_vfeeb + 1;
  public static final /*uint*/int BI__builtin_s390_vfeeh = BI__builtin_s390_vfeebs + 1;
  public static final /*uint*/int BI__builtin_s390_vfeehs = BI__builtin_s390_vfeeh + 1;
  public static final /*uint*/int BI__builtin_s390_vfeef = BI__builtin_s390_vfeehs + 1;
  public static final /*uint*/int BI__builtin_s390_vfeefs = BI__builtin_s390_vfeef + 1;
  public static final /*uint*/int BI__builtin_s390_vfeezb = BI__builtin_s390_vfeefs + 1;
  public static final /*uint*/int BI__builtin_s390_vfeezbs = BI__builtin_s390_vfeezb + 1;
  public static final /*uint*/int BI__builtin_s390_vfeezh = BI__builtin_s390_vfeezbs + 1;
  public static final /*uint*/int BI__builtin_s390_vfeezhs = BI__builtin_s390_vfeezh + 1;
  public static final /*uint*/int BI__builtin_s390_vfeezf = BI__builtin_s390_vfeezhs + 1;
  public static final /*uint*/int BI__builtin_s390_vfeezfs = BI__builtin_s390_vfeezf + 1;
  public static final /*uint*/int BI__builtin_s390_vfeneb = BI__builtin_s390_vfeezfs + 1;
  public static final /*uint*/int BI__builtin_s390_vfenebs = BI__builtin_s390_vfeneb + 1;
  public static final /*uint*/int BI__builtin_s390_vfeneh = BI__builtin_s390_vfenebs + 1;
  public static final /*uint*/int BI__builtin_s390_vfenehs = BI__builtin_s390_vfeneh + 1;
  public static final /*uint*/int BI__builtin_s390_vfenef = BI__builtin_s390_vfenehs + 1;
  public static final /*uint*/int BI__builtin_s390_vfenefs = BI__builtin_s390_vfenef + 1;
  public static final /*uint*/int BI__builtin_s390_vfenezb = BI__builtin_s390_vfenefs + 1;
  public static final /*uint*/int BI__builtin_s390_vfenezbs = BI__builtin_s390_vfenezb + 1;
  public static final /*uint*/int BI__builtin_s390_vfenezh = BI__builtin_s390_vfenezbs + 1;
  public static final /*uint*/int BI__builtin_s390_vfenezhs = BI__builtin_s390_vfenezh + 1;
  public static final /*uint*/int BI__builtin_s390_vfenezf = BI__builtin_s390_vfenezhs + 1;
  public static final /*uint*/int BI__builtin_s390_vfenezfs = BI__builtin_s390_vfenezf + 1;
  public static final /*uint*/int BI__builtin_s390_vistrb = BI__builtin_s390_vfenezfs + 1;
  public static final /*uint*/int BI__builtin_s390_vistrbs = BI__builtin_s390_vistrb + 1;
  public static final /*uint*/int BI__builtin_s390_vistrh = BI__builtin_s390_vistrbs + 1;
  public static final /*uint*/int BI__builtin_s390_vistrhs = BI__builtin_s390_vistrh + 1;
  public static final /*uint*/int BI__builtin_s390_vistrf = BI__builtin_s390_vistrhs + 1;
  public static final /*uint*/int BI__builtin_s390_vistrfs = BI__builtin_s390_vistrf + 1;
  public static final /*uint*/int BI__builtin_s390_vstrcb = BI__builtin_s390_vistrfs + 1;
  public static final /*uint*/int BI__builtin_s390_vstrcbs = BI__builtin_s390_vstrcb + 1;
  public static final /*uint*/int BI__builtin_s390_vstrch = BI__builtin_s390_vstrcbs + 1;
  public static final /*uint*/int BI__builtin_s390_vstrchs = BI__builtin_s390_vstrch + 1;
  public static final /*uint*/int BI__builtin_s390_vstrcf = BI__builtin_s390_vstrchs + 1;
  public static final /*uint*/int BI__builtin_s390_vstrcfs = BI__builtin_s390_vstrcf + 1;
  public static final /*uint*/int BI__builtin_s390_vstrczb = BI__builtin_s390_vstrcfs + 1;
  public static final /*uint*/int BI__builtin_s390_vstrczbs = BI__builtin_s390_vstrczb + 1;
  public static final /*uint*/int BI__builtin_s390_vstrczh = BI__builtin_s390_vstrczbs + 1;
  public static final /*uint*/int BI__builtin_s390_vstrczhs = BI__builtin_s390_vstrczh + 1;
  public static final /*uint*/int BI__builtin_s390_vstrczf = BI__builtin_s390_vstrczhs + 1;
  public static final /*uint*/int BI__builtin_s390_vstrczfs = BI__builtin_s390_vstrczf + 1;
  
  // Vector floating-point instructions (chapter 24 of the PoP)
  public static final /*uint*/int BI__builtin_s390_vfcedbs = BI__builtin_s390_vstrczfs + 1;
  public static final /*uint*/int BI__builtin_s390_vfchdbs = BI__builtin_s390_vfcedbs + 1;
  public static final /*uint*/int BI__builtin_s390_vfchedbs = BI__builtin_s390_vfchdbs + 1;
  public static final /*uint*/int BI__builtin_s390_vfidb = BI__builtin_s390_vfchedbs + 1;
  public static final /*uint*/int BI__builtin_s390_vflndb = BI__builtin_s390_vfidb + 1;
  public static final /*uint*/int BI__builtin_s390_vflpdb = BI__builtin_s390_vflndb + 1;
  public static final /*uint*/int BI__builtin_s390_vfmadb = BI__builtin_s390_vflpdb + 1;
  public static final /*uint*/int BI__builtin_s390_vfmsdb = BI__builtin_s390_vfmadb + 1;
  public static final /*uint*/int BI__builtin_s390_vfsqdb = BI__builtin_s390_vfmsdb + 1;
  public static final /*uint*/int BI__builtin_s390_vftcidb = BI__builtin_s390_vfsqdb + 1;
  public static final /*uint*/int LastTSBuiltin = BI__builtin_s390_vftcidb + 1;
/*}*/
} // END OF class SystemZ
